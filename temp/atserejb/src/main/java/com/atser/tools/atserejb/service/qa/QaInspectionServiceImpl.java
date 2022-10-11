/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.qualifiers.inspection.InspectionTestAnnotationLiteral;
import com.atser.tools.atserejb.dao.qa.QaInspectionDao;
import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.QaInspectionSignflowdef;
import com.atser.tools.atserejb.model.QaInspectionSigninfo;
import com.atser.tools.atserejb.model.QaInspectionSimpleCat;
import com.atser.tools.atserejb.model.QaInspectionType;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobClientService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaInspectionSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaInspectionSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.jboss.resteasy.spi.ResteasyUriInfo;
import com.atser.tools.atserejb.service.glob.GlobLabsService;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.UnsatisfiedResolutionException;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class QaInspectionServiceImpl implements QaInspectionService, IBaseEJBException {

    @Inject
    private QaInspectionDao dao;

    @Inject
    @Any
    private Instance<QaInspectionTestService> inspectionInstance;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private QaInspectionTypeService qaInspectionTypeService;

    @Inject
    private QaInspectionSimpleCatService qaInspectionSimpleCatService;

    @Inject
    private QaInspectionSignflowdefService qaInspectionSignflowdefService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private GlobUserService globUserService;

    @Inject
    private GlobLabsService globLabsService;

    @Inject
    private GlobFileService globFileService;

    private QaInspectionTestService getInstance(String name) {
        if (StringSupport.isNullOrEmpty(name)) {
            throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with the description of the test to support it.");
            log.error("getInstance -> Name is Empty");
        }
        try {
            QaInspectionTestService strategy = inspectionInstance.select(new InspectionTestAnnotationLiteral(name)).get();
            if (strategy != null) {
                return strategy;
            } else {
                throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with the description of the test to support it.");
                log.error("getInstance -> strategy is null");
            }
        } catch (IllegalArgumentException | UnsatisfiedResolutionException ex) {
            throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with the description of the test to support it.");
            log.error("getInstance -> " + ex.getMessage());
        }
        return null;
    }

    @Override
    public QaInspection findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspection findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaInspection findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspection findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaInspection elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                // Get Instance
                QaInspectionTestService instance = getInstance(elem.getInspectionTypeId().getShortName());
                BigDecimal fId = (BigDecimal) instance.createFolderStruct(header, elem);
                if (fId != null) {
                    elem.setFolderId(fId.toBigInteger());
                    dao.update(elem);
                }
                // destroy selected instance
                inspectionInstance.destroy(instance);
            }
            return elem;
        }
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaInspection elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(elem.getProjectId()) || elem.getInspectionTypeId() == null || elem.getInspectionTypeId().getId() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            // Load Inspection Type
            QaInspectionType typeId = qaInspectionTypeService.findById(elem.getInspectionTypeId().getId());
            if (typeId == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }

            // Load Simple Catg Id
            if (elem.getSimplecatId() != null && elem.getSimplecatId().getId() != null) {
                QaInspectionSimpleCat catId = qaInspectionSimpleCatService.findById(elem.getSimplecatId().getId());
                if (catId != null) {
                    elem.setSimplecatId(catId);
                }
            }

            elem.setInspectionTypeId(typeId);
            elem.setClientId(NumberSupport.getBigInteger(header.getClientid()));
            GlobUsers userId = globUserService.findById(header.getUserid());
            if (userId != null) {
                elem.setLoggedInBy(userId.getContactid().getFullName());
                elem.setLoggedInJobtitle(userId.getContactid().getTitle());
            } else {
                elem.setLoggedInBy(header.getUser());
            }
            elem.setCreated(new Date());
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastMod(new Date());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setActive('Y');
            // Fix By Client
            elem.setSpattern(DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")));
            elem.setSno(dao.getNextGlobalSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getSpattern()));
            elem.setIcn(dao.getNextProjectSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getProjectId()));
            String seqFormat = globClientService.generateSequencialNumber(header.getClientid(), elem.getSno(), "inspection");
            if (StringSupport.isNullOrEmpty(seqFormat)) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setInspNo(seqFormat);
            elem = populateSignFlowDef(elem, NumberSupport.getBigInteger(header.getClientid()), typeId.getId().toBigInteger());
            // Get Instance
            QaInspectionTestService instance = getInstance(typeId.getShortName());
            instance.save(header, elem);
            // destroy selected instance
            inspectionInstance.destroy(instance);
        }
        return BigDecimal.ZERO;
    }

    /**
     * Populate Sign Flow
     *
     * @param elem
     * @param clientId
     * @param inspectionTypeId
     * @return
     */
    private QaInspection populateSignFlowDef(QaInspection elem, BigInteger clientId, BigInteger inspectionTypeId) {
        List<QaInspectionSignflowdef> list = qaInspectionSignflowdefService.list(new ManageITBodyRequest(0, 0).filter("clientId", clientId).filter("inspectionTypeId.id", inspectionTypeId));
        list.forEach(it -> {
            elem.addQaInspectionSigninfoList(new QaInspectionSigninfo(clientId, elem, it, it.getSignOrder()));
        });
        return elem;
    }

    @Override
    public void update(ManageITHeader header, QaInspection elem) {
        if (elem != null) {
            QaInspection model = findById(elem.getId());
            if (!elem.equals(model)) {
                model = populate(model, elem);
                if (model != null) {
                    model.setLastMod(new Date());
                    model.setLastModBy(header.getUser());
                    model.setLastModIp(header.getModIp());
                    dao.update(model);
                }
            }
        }
    }

    /**
     * Populate Parent
     *
     * @param model
     * @param elem
     * @return
     */
    private QaInspection populate(QaInspection model, QaInspection elem) {
        QaInspectionTestService instance = getInstance(model.getInspectionTypeId().getShortName());
        try {
            // Load Simple Catg Id
            if (elem.getSimplecatId() != null && elem.getSimplecatId().getId() != null) {
                QaInspectionSimpleCat catId = qaInspectionSimpleCatService.findById(elem.getSimplecatId().getId());
                if (catId != null) {
                    model.setSimplecatId(catId);
                }
            }
            return instance.populate(model, elem);
        } finally {
            // destroy selected instance
            inspectionInstance.destroy(instance);
        }

    }

    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            dao.delete(id);
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaInspection> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaInspection> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaInspection> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaInspection> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaInspection> finalList = list(request);
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
        QaInspection model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N');
        dao.update(model);
    }

    @Override
    public void updateTestStatus(BigDecimal id, BigInteger statusId) {
        if (id != null) {
            QaInspection model = findById(id);
            if (model != null) {
                model.setStatusId(statusId);
                dao.update(model);
            }
        }
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        List vlist = dao.getRevisions(NumberSupport.getBigDecimal(id));
        if (vlist != null && vlist.size() > 0) {
            vlist.forEach(it -> {
                Object[] objResp = (Object[]) it;
                QaInspection model = (QaInspection) objResp[0];
                // Set Project Full Name
                if (model.getProjectId() != null) {
                    GlobProject currentproject = globProjectService.findById(model.getProjectId().toString());
                    if (currentproject != null) {
                        model.setProjectFullName(currentproject.getProjectFullName());
                    }
                }
                // Set LabName
                if (model.getLabId() != null) {
                    GlobLabs lab = globLabsService.findById(model.getLabId().toString());
                    if (lab != null) {
                        model.setLabName(lab.getFullLabName());
                    }
                }
                // Determination
                if (model.getSimplecatId() != null && StringSupport.isNotNullAndNotEmpty(model.getSimplecatId().getName())) {
                    model.setDeterminationDescript(model.getSimplecatId().getName().toUpperCase());
                }
                // Get Instance
                QaInspectionTestService instance = getInstance(model.getInspectionTypeId().getShortName());
                instance.populateVersioning(model);
                // destroy selected instance
                inspectionInstance.destroy(instance);
            });
        }
        return vlist;
    }

    // -------------------------- GENERATE REPORTS -----------------------------
    @Override
    public void generateReportAndUploadToTrackIT(QaInspection elem, String serverPath, String tplbasePath, String docpathsegment, ManageITHeader header) {
        if (elem != null) {
            // Get Instance
            QaInspectionTestService instance = getInstance(elem.getInspectionTypeId().getShortName());
            InspectionReportMetadataPojo reportMetadata = instance.generateTrackITReportTitle(header, elem);
            ManageITBodyRequest request = new ManageITBodyRequest(0, 0).filter("id", elem.getId());
            if (StringSupport.isNotNullAndNotEmpty(reportMetadata.reportId, reportMetadata.funcId)) {
                String tempReportPath = generateReport(reportMetadata.reportId, reportMetadata.funcId, tplbasePath, docpathsegment, "pdf", header, request);
                String finalReportPath = serverPath + header.getClientid() + "/general/" + FileSupport.sanitizeFileName(reportMetadata.trackItReportName) + ".pdf";
                try {
                    Map<String, Object> metaData = FileSupport.moveFileAndGetMetaData(tempReportPath, finalReportPath);
                    globFileService.saveFileToDbByFunctionality(reportMetadata.folderFunct, elem.getProjectId().toString(), header, metaData);
                } catch (IOException ex) {
                    log.error(ex.getMessage());
                }
            }
            // destroy selected instance
            inspectionInstance.destroy(instance);
        } else {
            log.error("We could not generate the Report. Inspection ID is Null.");
        }
    }

    /**
     * Generate Report
     *
     * @param reportId
     * @param funcId
     * @param tplbasePath
     * @param docpathsegment
     * @param docType
     * @param header
     * @param request
     * @return
     */
    @Override
    public String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(reportId)) {
            log.error("@ATSER: generateReport - Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), funcId, reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            return buildGenericReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper, funcId);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    /**
     * Build Generic Report
     *
     * @param tplbasePath
     * @param tplpath
     * @param docpathsegment
     * @param docType
     * @param request
     * @param paramsJasper
     * @param funcId
     * @return
     */
    private String buildGenericReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<QaInspectionReportTO> pResult = generateReportData(request, funcId);
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    /**
     * Generate Report Data
     *
     * @param request
     * @param funcId
     * @return
     */
    private List<QaInspectionReportTO> generateReportData(ManageITBodyRequest request, String funcId) {
        QaInspectionTestService instance = null;
        try {
            List<QaInspection> ds = list(request);
            if (ds != null && !ds.isEmpty()) {
                //Get Project
                GlobProject project = globProjectService.findById(ds.get(0).getProjectId().toString());
                BufferedImage clientLogoImage = genericHelperService.getClientLogo(project);
                switch (funcId) {
                    case "fc_inspection_notunused": {
                        // Get Instance
                        instance = getInstance("notice_unused_items");
                        break;
                    }
                    case "fc_inspection_precast_prestress": {
                        instance = getInstance("precast_prestress");
                        break;
                    }
                    case "fc_inspection_qualified_construction_materials": {
                        instance = getInstance("qualified_construction_materials_list");
                        break;
                    }
                    case "fc_inspection_visual": {
                        instance = getInstance("visual_inspection");
                        break;
                    }
                    case "fc_inspection_certofsrc": {
                        instance = getInstance("certificate_of_source");
                        break;
                    }
                }
                if (instance != null) {
                    return instance.generateReportData(ds, clientLogoImage);
                }
            }
            return new ArrayList<>();
        } finally {
            if (instance != null) {
                // destroy selected instance
                inspectionInstance.destroy(instance);
            }
        }
    }

    @Override
    public Object getFrontEndSearchInspection(ManageITHeader header, ManageITBodyRequest body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getSearchInspectionInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
        } else {
            switch (datatype) {
                case "table": {
                    return getSearchInspectionInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private DataTableWrapper<QaInspectionSearchBO> getSearchInspectionInbox(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params) {
        // Define parameters
        QaInspectionSearchDefParam tp = new QaInspectionSearchDefParam();
        tp.userId = userId;
        tp.currentRole = currentRole;
        tp.clientId = clientId;
        tp.projectId = StringSupport.getString(params.get("projectId"));
        tp.regionId = StringSupport.getString(params.get("regionId"));
        tp.startDate = StringSupport.getString(params.get("startDate"));
        tp.endDate = StringSupport.getString(params.get("endDate"));
        tp.themeCompany = StringSupport.getString(params.get("themeCompany"));
        tp.sortBy = StringSupport.getString(params.get("sortBy"));
        tp.sortDir = StringSupport.getString(params.get("sortDir"));
        tp.dtSearchUrl = StringSupport.getString(params.get("dtSearchUrl"));
        tp.startIndex = NumberSupport.getInteger(params.get("startIndex"));
        tp.maxResults = NumberSupport.getInteger(params.get("maxResults"));
        tp.isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        tp.multiproject = StringSupport.getBoolean(params.get("multiproject"));
        tp.isAllDateActive = StringSupport.getBoolean(params.get("isAllDateActive"));
        tp.showInactive = StringSupport.getBoolean(params.get("showInactive"));
        tp.useGlobalProfiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        tp.usesRoleMatrix = StringSupport.getBoolean(params.get("usesRoleMatrix"));
        tp.statusMap = AtserLinkedHashMap.parseJsonString(StringSupport.getString(params.get("statusMap")));
        if (StringSupport.isNotNullAndNotEmpty(params.get("dtSearchUrl"))) {
            UriInfo pUriInfo = new ResteasyUriInfo("", StringSupport.getString(params.get("dtSearchUrl")), "");
            MultivaluedMap<String, String> queryParams = pUriInfo.getQueryParameters();
            Map<String, String> search = new HashMap();
            queryParams.get("f").stream().map((string) -> string.split("%=")).filter((split) -> (split.length == 2)).forEachOrdered((split) -> {
                search.put(split[0], split[1]);
            });
            tp.dtMapSearch = search;
        } else {
            tp.dtMapSearch = new HashMap<>();
        }
        return dao.getFrontEndInspectionSearch(tp);
    }
}
