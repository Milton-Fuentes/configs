/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobContactCertDao;
import com.atser.tools.atserejb.common.objects.to.GlobContactCertTO;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobContactCert;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobPersonnelCertTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobContactCertServiceImpl implements GlobContactCertService, IBaseEJBException {

    private final String rootFolderName = "Personnel Certification";

    @Inject
    private GlobContactCertDao dao;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private WsReportService wsReportService;

    @Override
    public GlobContactCert findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public GlobContactCert findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobContactCert findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobContactCert findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobContactCert elem = dao.findById(id);
            if (elem.getContactId() == null) {
                return elem;
            }
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
                elem.setFolderId(fId.toBigInteger());
                dao.update(elem);
            }
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, GlobContactCert elem) {
        if (elem != null) {
            elem.setActive("Y");
            elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setVersion("1");
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, GlobContactCert elem) {
        if (elem != null) {
            GlobContactCert model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                model.setContactId(elem.getContactId());
                model.setQualifyingAgencyId(elem.getQualifyingAgencyId());
                model.setQualificationId(elem.getQualificationId());
                model.setCertNo(elem.getCertNo());
                model.setAuthorizedDate(elem.getAuthorizedDate());
                model.setExpirationDate(elem.getExpirationDate());
                model.setOverride(elem.getOverride());
                model.setIgnoreProficiency(elem.getIgnoreProficiency());
                model.setComments(elem.getComments());
                if (StringSupport.isNullOrEmpty(model.getVersion())) {
                    model.setVersion("1");
                } else {
                    model.setVersion(String.valueOf(Integer.valueOf(model.getVersion()) + 1));
                }
                dao.update(model);
            }
        }
    }

    @Override
    public void update(GlobContactCert elem) {
        update(null, elem);
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobContactCert> list(ManageITBodyRequest request) {
        List<GlobContactCert> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    private List<GlobContactCertTO> groupContactCertByContactId(List<GlobContactCert> localList) {
        if (localList == null || localList.isEmpty()) {
            return new ArrayList<>();
        }
        List<GlobContactCertTO> list = new ArrayList<>();
        Map<GlobContact, List<GlobContactCert>> groupByContact
                = localList.stream().collect(Collectors.groupingBy(GlobContactCert::getContactId));
        groupByContact.forEach((k, v) -> {
            list.add(new GlobContactCertTO(k, v));
        });
        return list;
    }

    public List<GlobContactCertTO> contactCertTree(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return groupContactCertByContactId(list(request));
        }
        return new ArrayList<>();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobContactCert> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobContactCert> finalList = list(request);
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
        GlobContactCert model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    private BigDecimal createFolderStruct(String userId, String clientId, GlobContactCert elem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger cId = new BigInteger(clientId);
        BigInteger owner = NumberSupport.getBigInteger(userId);
        // Create Root Folder
        BigDecimal rootFolderId = folderService.getFolderIdByClientBy(clientId, eManageITFolder.eFLabCompliance);
        if (rootFolderId == null) {
            BigDecimal froot = folderService.getRootFolderIdByClient(cId);
            rootFolderId = folderService.createTrackITFolder(froot, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', eManageITFolder.eFLabCompliance.getValue(), new BigInteger("2"), folderService.getNextFolderNumber(froot.toBigInteger(), "##0.0"));
        }

        // Create Personnel Root Folder
        BigDecimal PersonnelCertRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName, rootFolderId.toBigInteger());
        if (PersonnelCertRootFolderId == null) {
            PersonnelCertRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }

        String pFolderName = StringSupport.isNotNullAndNotEmpty(elem.getContactId().getFullName()) ? elem.getContactId().getFullName() : elem.getCertNo();
        BigDecimal contactCertRootFolderId = folderService.getFolderIdByClientBy(clientId, pFolderName, PersonnelCertRootFolderId.toBigInteger());
        if (contactCertRootFolderId == null) {
            contactCertRootFolderId = folderService.createTrackITFolder(PersonnelCertRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', pFolderName, new BigInteger("2"));
        }

        String qFolderName = StringSupport.isNotNullAndNotEmpty(elem.getQualificationId().getAcronym()) ? elem.getQualificationId().getAcronym() : elem.getQualificationId().getQualification();
        BigDecimal qCertRootFolderId = folderService.getFolderIdByClientBy(clientId, qFolderName, contactCertRootFolderId.toBigInteger());
        if (qCertRootFolderId == null) {
            qCertRootFolderId = folderService.createTrackITFolder(contactCertRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', qFolderName, new BigInteger("2"));
        }
        return qCertRootFolderId;
    }

    @Override
    public String generateReportByProject(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, String projectId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_globcontactcert", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "PersonnelCertLogTable": {
                    return generateCertLogByProjectReport(tplbasePath, tplpath, docpathsegment, docType, projectId, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }
    
    public String generateCertLogByProjectReport(String tplbasePath, String tplpath, String docpathsegment, String docType, String projectId, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobPersonnelCertTO> pResult = generateReportDataByProject(request, projectId);

        String targetPath = docpathsegment + "CertLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobContactCertServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private List<GlobPersonnelCertTO> generateReportDataByProject(ManageITBodyRequest request, String projectId) {
        //List<GlobContactCertTO> dbTree = contactCertTree(request);
        List<GlobContactCertTO> dbTree = groupContactCertByContactId(dao.filterByProject(NumberSupport.getBigInteger(projectId)));
        List<GlobPersonnelCertTO> rData = new ArrayList<>();
        dbTree.forEach(it -> {
            rData.add(it.getTOForJasper());
        });
        return rData;
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_globcontactcert", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "PersonnelCertLogTable": {
                    return generateCertLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    public String generateCertLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobPersonnelCertTO> pResult = generateReportData(request);

        String targetPath = docpathsegment + "CertLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobContactCertServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobPersonnelCertTO> generateReportData(ManageITBodyRequest request) {
        List<GlobContactCertTO> dbTree = contactCertTree(request);
        List<GlobPersonnelCertTO> rData = new ArrayList<>();
        dbTree.forEach(it -> {
            rData.add(it.getTOForJasper());
        });
        return rData;
    }

    @Override
    public List<GlobContactCert> filterByProject(String projectId) {
        if (StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.filterByProject(NumberSupport.getBigInteger(projectId));
    }
}
