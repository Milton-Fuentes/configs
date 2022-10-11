/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobLandacqLogDao;
import com.atser.tools.atserejb.model.GlobLandacqLog;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridExcelSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.landacq.GlobLandacqLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobLandacqLogSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;

@Stateless
@Slf4j
public class GlobLandacqLogServiceImpl implements GlobLandacqLogService, IBaseEJBException {

    private final String rootFolderName = "Land Acquisition Management";

    @Inject
    private GlobLandacqLogDao dao;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private QmCvlFieldDataService qmCvlFieldDataService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public GlobLandacqLog findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLandacqLog findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobLandacqLog findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLandacqLog findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobLandacqLog elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header, elem);
                if (fId != null) {
                    elem.setFolderId(fId.toBigInteger());
                    dao.update(elem);
                }
            }
            return elem;
        }
    }

    // Review This Method
    private BigDecimal createFolderStruct(ManageITHeader header, GlobLandacqLog elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Master Folder
        BigDecimal rootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), rootFolderName);
        if (rootFolderId != null) {
            // Create No Folder
            return folderService.createTrackITFolder(rootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "Y", 'N', elem.getLandacqNo(), new BigInteger("2"));
        }
        return null;
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobLandacqLog elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(elem.getProjectId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setSpattern(DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")));
            elem.setSno(dao.getNextGlobalSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getSpattern()));
            elem.setLlpcn(dao.getNextProjectSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getProjectId()));
            String seqFormat = globClientService.generateSequencialNumber(header.getClientid(), elem.getSno(), "landacq");
            if (StringSupport.isNullOrEmpty(seqFormat)) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setLandacqNo(seqFormat);
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobLandacqLog elem) {
        if (elem != null) {
            GlobLandacqLog model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobLandacqLog populate(GlobLandacqLog model, GlobLandacqLog elem) {
        model.setRowacqNo(elem.getRowacqNo());
        model.setEnvIssues(elem.getEnvIssues());
        model.setDateAvailable(elem.getDateAvailable());
        model.setOwners(elem.getOwners());
        model.setGisLocation(elem.getGisLocation());
        model.setSiteAddress(elem.getSiteAddress());
        model.setLandType(elem.getLandType());
        model.setMappg(elem.getMappg());
        model.setCounty(elem.getCounty());
        model.setStationing(elem.getStationing());
        model.setRowCertificationNo(elem.getRowCertificationNo());
        model.setTypeOfContract(elem.getTypeOfContract());
        model.setContactPhoneNumber(elem.getContactPhoneNumber());
        model.setRowCertificationDate(elem.getRowCertificationDate());
        model.setAcquisitionType(elem.getAcquisitionType());
        model.setImprovements(elem.getImprovements());
        model.setLandAvailable(elem.getLandAvailable());
        model.setPropertyStatus(elem.getPropertyStatus());
        model.setOccupiedDate(elem.getOccupiedDate());
        model.setRequestForUtility(elem.getRequestForUtility());
        model.setAccessToProperty(elem.getAccessToProperty());
        model.setPropertyOwnerConversations(elem.getPropertyOwnerConversations());
        model.setUtDrawingNo(elem.getUtDrawingNo());
        model.setParcelImpact(elem.getParcelImpact());
        model.setRemarks(elem.getRemarks());        
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobLandacqLog> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobLandacqLog> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobLandacqLog> finalList = list(request);
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
    public DataGridWrapper<GlobLandacqLog> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
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
                GlobLandacqLog model = (GlobLandacqLog) objResp[0];
                // Set Project Full Name
                if (model.getProjectId() != null) {
                    GlobProject currentproject = globProjectService.findById(model.getProjectId().toString());
                    if (currentproject != null) {
                        model.setProjectFullName(currentproject.getProjectFullName());
                    }
                }
                // Cvl Land Type Name
                if (model.getLandType() != null) {
                    QmCvlFieldData cvlLandType = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(model.getLandType()));
                    if (cvlLandType != null) {
                        model.setLandTypeName(cvlLandType.getValue());
                    }
                }
                // Cvl County Name
                if (model.getCounty()!= null) {
                    QmCvlFieldData cvlCounty = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(model.getCounty()));
                    if (cvlCounty != null) {
                        model.setCountyName(cvlCounty.getValue());
                    }
                }
                // Cvl Property Status
                if (model.getPropertyStatus()!= null) {
                    QmCvlFieldData cvlPropStatus = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(model.getPropertyStatus()));
                    if (cvlPropStatus != null) {
                        model.setPropertyStatusName(cvlPropStatus.getValue());
                    }
                }
            });
        }
        return vlist;
    }

    @Override
    public void changeStatus(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobLandacqLog model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    @Override
    public Object getFrontEndSearch(ManageITHeader header, GlobLandacqLogSearchDefParam defParam) {
        if (defParam == null || !defParam.isDataValid()) {
            log.error("GlobLandacqLogSearchDefParam is not valid.");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(defParam.dt)) {
            return dao.getFrontEndSearch(defParam);
        } else {
            switch (defParam.dt) {
                case "table": {
                    return dao.getFrontEndSearch(defParam);
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public String generateReport(String tplbasePath, String docpathsegment, ManageITHeader header, GlobLandacqLogSearchDefParam defParam) {
        if (defParam == null || StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(defParam.reportId, defParam.functionId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), defParam.functionId, defParam.reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (defParam.reportId) {
                case "LandACQManagementPrintReport": {
                    return generateLandAcqLogPrintReport(tplbasePath, tplpath, docpathsegment, header, defParam, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateLandAcqLogPrintReport(String tplbasePath, String tplpath, String docpathsegment, ManageITHeader header, GlobLandacqLogSearchDefParam defParam, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (defParam.docType == null || defParam.docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(defParam.docType);
        }
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(header.getClientid());
        paramsJasper.put("PROJECT_LOGO", projectLogoImage);

        // Search Data
        DataTableWrapper<GlobLandacqLogBO> ds = (DataTableWrapper<GlobLandacqLogBO>) getFrontEndSearch(header, defParam);
        String targetPath = docpathsegment + "LandACQLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            switch (extension) {
                case pdf:
                case doc: {
                    targetPath = pdf.exportDocument(tplpath, paramsJasper, ds.getData(), targetPath, extension.getValue());
                    return targetPath;
                }
                case excel:
                case csv: {
                    JasperDesignGridExcelSimple jd = new JasperDesignGridExcelSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, extension);
                    JasperDesign tpl = jd.buildTemplate("Land Acquisition Log", GlobLandacqLogBO.class, Optional.ofNullable(defParam.themeCompany).orElseGet(() -> "default"));
                    targetPath = pdf.exportDocument(tpl, null, ds.getData(), targetPath, extension.getValue(), Boolean.FALSE);
                    return targetPath;
                }
            }

        } catch (Exception ex) {
            log.debug(ex.getMessage());
        }
        return null;
    }

}
