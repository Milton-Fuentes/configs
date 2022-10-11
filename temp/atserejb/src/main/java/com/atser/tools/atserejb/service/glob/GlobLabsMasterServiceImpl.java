/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobLabsMasterDao;
import com.atser.tools.atserejb.model.GlobContractorContract;
import com.atser.tools.atserejb.model.GlobFunctions;
import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserejb.model.GlobLabsMaster;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.contractorcontract.GlobContractorContractBO;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobLabsMasterServiceImpl implements GlobLabsMasterService, IBaseEJBException {

    private final String rootFolderName = "Labs";

    @Inject
    private GlobLabsMasterDao dao;

    @Inject
    private GlobContractorContractService globContractorContractService;

    @Inject
    private GlobLabsService globLabsService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private GlobFunctionsService globFunctionsService;

    @Override
    public GlobLabsMaster findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLabsMaster findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public GlobLabsMaster findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLabsMaster findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobLabsMaster elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, GlobLabsMaster elem) {
        if (elem != null) {
            if (!dao.exists(elem.getClientId(), elem.getLabName())) {
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                dao.save(elem);
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Lab already exists.");
            }
        }
    }

    @Override
    public void update(ManageITHeader header, GlobLabsMaster elem) {
        if (elem != null) {
            GlobLabsMaster model = findById(elem.getId());
            elem.setLastMod(new Date());
            elem.setLastModBy(header.getUser());
            elem.setLastModIp(header.getModIp());
            dao.update(populate(model, elem));
        }
    }

    private GlobLabsMaster populate(GlobLabsMaster model, GlobLabsMaster elem) {
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setContact(elem.getContact());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setFax(elem.getFax());
        model.setZip(elem.getZip());
        model.setEmail(elem.getEmail());
        model.setLocation(elem.getLocation());
        model.setTbpeRegistrationNo(elem.getTbpeRegistrationNo());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobLabsMaster> list(ManageITBodyRequest request) {
        List<GlobLabsMaster> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        list.forEach(it -> {
            if (it.getGlobLabsList().size() > 0) {
                it.setCanBeEdited("false");
                it.setGlobLabsList(null);
            }
        });
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobLabsMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobLabsMaster> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobLabsMaster model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
    }

    @Override
    public void assignLabFunction(ManageITHeader header, GlobContractorContractBO elem) {
        if (elem.getProjectId() == null || elem.getMasterlabId() == null || elem.getFunctionIdList() == null || elem.getFunctionIdList().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
        }
        GlobLabsMaster model = findById(new BigDecimal(elem.getMasterlabId()));
        GlobProject project = globProjectService.findById(new BigDecimal(elem.getProjectId()));
        if (model != null) {
            elem.getFunctionIdList().forEach(it -> {
                GlobFunctions function = globFunctionsService.findById(new BigDecimal(it));
                GlobLabs plab = globLabsService.findById(NumberSupport.getBigInteger(header.getClientid()), elem.getMasterlabId(), it);

                if (plab == null) {
                    plab = toGlobLabs(function, model);
                    globLabsService.save(header, plab);
                    plab.setClientsLabid("id_" + plab.getId());
                    globLabsService.updateLabId(plab);
                }
                
                if (!globContractorContractService.exists(NumberSupport.getBigInteger(header.getClientid()), elem.getProjectId(), elem.getMasterlabId(), it)) {
                    GlobContractorContract functionProject = new GlobContractorContract(project, plab, function.getId().toBigInteger());
                    globContractorContractService.save(functionProject);
                    
                }
            });
        }
    }

    private GlobLabs toGlobLabs(GlobFunctions functionId, GlobLabsMaster elem) {
        GlobLabs model = new GlobLabs();
        model.setMasterlabId(elem);
        model.setLabName(elem.getLabName());
        model.setName(elem.getLabName());
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setContact(elem.getContact());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setFax(elem.getFax());
        model.setEmail(elem.getEmail());
        model.setActive('Y');
        model.setFunctionId(functionId);
        model.setLocation(elem.getLocation());
        model.setClientId(elem.getClientId());
        model.setZip(elem.getZip());
        model.setTbpeRegistrationNo(elem.getTbpeRegistrationNo());
        model.setUploadI2ms('N');
        return model;
    }

}
