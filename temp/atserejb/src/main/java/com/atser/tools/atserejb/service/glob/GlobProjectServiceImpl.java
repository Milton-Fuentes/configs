/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.objects.to.GlobProjectInfoTO;
import com.atser.tools.atserejb.dao.glob.GlobProjectDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.GlobContractorContract;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobProjectServiceImpl implements GlobProjectService, IBaseEJBException {

    @Inject
    private GlobProjectDao dao;

    @Inject
    private GlobContactService globContactService;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobModuleService globModuleService;

    @Inject
    private GlobContractorContractService globContractorContractService; //globInfo 

    @Inject
    GlobContractorPersonnelService globContractorPersonnelService; //contractors per client 

    @Inject
    GlobProjContrPersonnelService globProjContrPersonnelService; // client contractors per project

    @Inject
    GlobFolderService globfodlerService;

    @Inject
    GlobSpecBookProjService globSpecBookProjService; //Todo

    @Override
    public GlobProject findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobProject findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProject elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobProject elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;

    }

    @Override
    public void saveTo(ManageITHeader header, GlobProjectInfoTO elem) {
        //----------------------------------------------------------------------
        // Checking Necesary Data
        if (elem == null || StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(header.getModule())) {
            log.error("@EJB saveTo GlobProjectInfoTO, clientId or module are empty or null ");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (this.exists(header.getClientid(), StringSupport.getString(elem.getGlobProject().getPNumber()), false)) {
            log.error("@EJB , This Project No. already exists. Please choose a different Project No. ");
            throwBaseException(Response.Status.BAD_REQUEST, "This Project No. already exists. Please choose a different Project No.");
        }
        //----------------------------------------------------------------------
        // Before Save Project
        populatePreInsert(header, elem);
        // Before By Module
        populatePreInsertByModule(elem);
        //----------------------------------------------------------------------
        // Save Project
        this.save(elem.getGlobProject());
        log.info("@mfb save: Project ID {} ", elem.getGlobProject().getId());
        //----------------------------------------------------------------------
        // After Save Project
        postSaveTo(elem);

    }

    public void populatePreInsert(ManageITHeader header, GlobProjectInfoTO elem) {
        //project
        elem.getGlobProject().setClientId(globClientService.findById(header.getClientid()));
        elem.getGlobProject().setUsesBuckets(StringSupport.isNullOrEmpty(elem.getGlobProject().getUsesBuckets()) ? 'N' : elem.getGlobProject().getUsesBuckets());
        elem.getGlobProject().setUsesDisciplines(StringSupport.isNullOrEmpty(elem.getGlobProject().getUsesDisciplines()) ? 'N' : elem.getGlobProject().getUsesDisciplines());
        elem.getGlobProject().setPDate(elem.getGlobProject().getPDate() == null ? new Date() : elem.getGlobProject().getPDate());
        elem.getGlobProject().setActive('Y');
        elem.getGlobProject().setName(elem.getGlobProject().getPNumber());
        elem.getGlobProject().setDescription(elem.getGlobProject().getPName());
        elem.getGlobProject().setPType(StringSupport.isNullOrEmpty(elem.getGlobProject().getPType()) ? "Construction" : elem.getGlobProject().getPType());
        //module
        elem.setGlobModule(globModuleService.findByModuleName(header.getModule()));

    }

    private void populatePreInsertByModule(GlobProjectInfoTO elem) {
        // ToDO    
        switch (elem.getGlobModule().getModuleName()) {
            case "QMS":
                // code block
                break;
            case "CMS":
                // code block
                break;
            case "ASPHALT":
                // code block
                break;
            case "TRACKIT":
                // code block
                break;
            case "DRAWIT":
                // code block
                break;
            case "PLANIT":
                // code block
                break;
            case "CONCRETE":
                // code block
                break;
            default:
            // code block    

        }

    }

    private void postSaveTo(GlobProjectInfoTO elem) {

        // add to GlobInfo == GlobContractorContract    (Done)
        globContractorContractService.saveDefault(elem.getGlobProject());
        // ToDo ToDo ToDo
        //create a Default Mix design every after create a new project
        // Set Information to call EndPoints
        //add to glob_info
        //.....add project to current user profile
        // adding project spec book
        //......add project specifications from spec book default specs
        // .....else
        //......add project specifications from default client specs
        //add default test preferences
        // adding manager to the project roster
        // adding contractor to the project
        // adding contact id
        //Create project Folder Structure 

        // ToDO  In case it is needed  
        switch (elem.getGlobModule().getModuleName()) {
            case "QMS":
                // code block
                break;
            case "CMS":
                // code block
                break;
            case "ASPHALT":
                // code block
                break;
            case "TRACKIT":
                // code block
                break;
            case "DRAWIT":
                // code block
                break;
            case "PLANIT":
                // code block
                break;
            case "CONCRETE":
                // code block
                break;
            default:
            // code block    

        }

    }

    public void populateQmsProject(ManageITHeader header, GlobProjectInfoTO elem) {
        // ToDo
    }

    public void populateCmsProject(ManageITHeader header, GlobProjectInfoTO elem) {
        // ToDo
    }

    public void populateAsphaltProject(ManageITHeader header, GlobProjectInfoTO elem) {
        // ToDo
    }

    @Override
    public void update(GlobProject elem) {
        if (elem != null) {
            GlobProject model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobProject> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public BigDecimal findIdByClientAndPNumber(String clientId, String contractNo) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(contractNo)) {
            log.error("@EJB findIdByClientAndPNumber clientId or contractNo are empty or null ");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findIdByClientAndPNumber(NumberSupport.getBigDecimal(clientId), contractNo);
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobProject> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobProject> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobProject model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N');
        dao.update(model);
    }

    @Override
    public List<Object[]> getProjectListInLab(BigInteger clientId) {
        if (clientId != null) {
            return dao.getProjectListInLab(clientId);
        }
        return null;
    }

    @Override
    public List<DataSelectWrapper> getProjectListInLabForSelect(BigInteger clientId) {
        List<Object[]> flist = getProjectListInLab(clientId);
        if (flist == null || flist.isEmpty()) {
            return new ArrayList<>();
        }
        return flist.stream().map(p -> new DataSelectWrapper(p[0], StringSupport.emptyOnNull(p[1]))).collect(Collectors.toList());
    }

    @Override
    public Object getFrontEndProjectListByCurrentProfile(ManageITHeader header, ManageITBodyRequest body) {
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getProjectListByCurrentProfile(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getProjectListByCurrentProfileForSelect(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
                }
                case "table": {
                    return getProjectListByCurrentProfile(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getProjectListByCurrentProfileForSelect(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params) {
        List<ProjectBO> ds = getProjectListByCurrentProfile(userId, clientId, currentRole, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getProjectFullName())).collect(Collectors.toList());
    }

    @Override
    public List<ProjectBO> getProjectListByCurrentProfile(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params) {
        String status = StringSupport.getString(params.get("status"));
        boolean isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        boolean multiproject = StringSupport.getBoolean(params.get("multiproject"));
        boolean project_uses_multiple_location = StringSupport.getBoolean(params.get("useMultipleLocation"));
        boolean uses_global_profiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        boolean ProjectSetup = StringSupport.getBoolean(params.get("projectSetup"));
        boolean uses_allow_readonly_labs = StringSupport.getBoolean(params.get("useAllowReadOnlyLabs"));
        // ----- Filters ------
        String regionId = StringSupport.getString(params.get("regionId"));
        String divisionId = StringSupport.getString(params.get("divisionId"));
        String locationId = StringSupport.getString(params.get("locationId"));
        List<ProjectBO> ds = dao.getFrontEndProjectListByCurrentProfile(userId, clientId, currentRole, isAdmin, multiproject, project_uses_multiple_location, uses_global_profiles, ProjectSetup, uses_allow_readonly_labs, status);
        if (StringSupport.isNullOrEmpty(regionId) && StringSupport.isNullOrEmpty(locationId) && StringSupport.isNullOrEmpty(divisionId)) {
            return ds;
        }
        Predicate<ProjectBO> predicateDS = s -> s.getStatus().equals(status);
        if (StringSupport.isNotNullAndNotEmpty(regionId)) {
            predicateDS = predicateDS.and(s -> s.getRegionId() != null && s.getRegionId().compareTo(NumberSupport.getBigInteger(regionId)) == 0);
        }
        if (StringSupport.isNotNullAndNotEmpty(divisionId)) {
            predicateDS = predicateDS.and(s -> s.getDivisionId() != null && s.getDivisionId().compareTo(NumberSupport.getBigInteger(divisionId)) == 0);
        }
        if (StringSupport.isNotNullAndNotEmpty(locationId)) {
            predicateDS = predicateDS.and(s -> s.getLocationId() != null && s.getLocationId().compareTo(NumberSupport.getBigInteger(locationId)) == 0);
        }
        return ds.stream().filter(predicateDS).collect(Collectors.toList());
    }

    @Override
    public Object getFrontEndProjectListByFunctionProfile(ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getProjectListByFunctionProfile(header.getUserid(), header.getClientid(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getProjectListByFunctionProfileForSelect(header.getUserid(), header.getClientid(), body.getParams());
                }
                case "table": {
                    return getProjectListByFunctionProfile(header.getUserid(), header.getClientid(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getProjectListByFunctionProfileForSelect(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        List<GlobProject> ds = getProjectListByFunctionProfile(userId, clientId, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getProjectFullName())).collect(Collectors.toList());
    }

    private List<GlobProject> getProjectListByFunctionProfile(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        String functionId = StringSupport.getString(params.get("functionId"));
        boolean isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        boolean uses_global_profiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        String projectClientId = StringSupport.getString(params.get("projectClientId"));
        return dao.getFrontEndProjectListByFunctionProfile(userId, clientId, isAdmin, uses_global_profiles, functionId, projectClientId);
    }

    @Override
    public void update(ManageITHeader header, GlobProject elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<GlobProject> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Object> getProjectDetails(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobProject gp = findById(id);
        Map<String, Object> rmap = new HashMap<>();
        if (gp != null) {
            if (StringSupport.isNotNullAndNotEmpty(gp.getContactId())) {
                GlobContact gcmodel = globContactService.findById(gp.getContactId());
                rmap.put("contactName", gcmodel.getFullName());
                rmap.put("contactPhone", gcmodel.getPhone());
            }
            rmap.put("addcontactName", gp.getOtherContactName1());
            rmap.put("addcontactPhone", gp.getOtherContactTelephone1());
        }
        return rmap;
    }

    @Override
    public List<DataSelectWrapper> getAllProjectsForSelect(ManageITBodyRequest request) {
        List<GlobProject> ds = list(request);
        if (ds != null) {
            return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getProjectFullName())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public ProjectBO toProjectBO(GlobProject project) {
        if (project == null) {
            return null;
        }
        ProjectBO projectBO = new ProjectBO();
        projectBO.setId(project.getId().toBigInteger());
        projectBO.setNumber(project.getPNumber());
        projectBO.setName(project.getPName());
        projectBO.setType(project.getPType());
        return projectBO;
    }

    @Override
    public void updateTo(ManageITHeader header, GlobProjectInfoTO data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String clientId, String pNumberCode, Boolean useProjectCode) {
        return dao.exists(clientId, pNumberCode, useProjectCode);
    }

}
