/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmBiditPrjCatgDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserejb.model.CmBiditSignflowdef;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobClientService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.GlobSystemSimpleCat;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobSystemSimpleCatService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.cm.CmBidITPrjCatgSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidItAnalysis;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidItemSummary;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author mdelabat
 */
@Stateless
@Slf4j
public class CmBiditPrjCatgServiceImpl implements CmBiditPrjCatgService, IBaseEJBException {

    private final String rootFolderName = "BidIT Documents";

    @Inject
    private CmBiditPrjCatgDao dao;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private CmBiditSignflowdefService cmBiditSignflowdefService;

    @Inject
    private CmBiditSigninfoService cmBiditSigninfoService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GlobSystemSimpleCatService globSystemSimpleCatService;

    @Override
    public CmBiditPrjCatg findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditPrjCatg findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public CmBiditPrjCatg findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditPrjCatg findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            CmBiditPrjCatg elem = dao.findById(id);
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

    private BigDecimal createFolderStruct(ManageITHeader header, CmBiditPrjCatg elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger cId = new BigInteger(header.getClientid());
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());

        // Create Root Folder
        /*BigDecimal rootFolderId = folderService.getFolderIdByClientBy(header.getClientid(), rootFolderName);
        if (rootFolderId == null) {
            BigDecimal froot = folderService.getRootFolderIdByClient(cId);
            rootFolderId = folderService.createTrackITFolder(froot, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"), folderService.getNextFolderNumber(froot.toBigInteger(), "##0.0"));
        }*/
        // Create Program Root Folder
        /*BigDecimal programRootFolderId = folderService.getFolderIdByClientBy(header.getClientid(), program.getSubCaption(), rootFolderId.toBigInteger());
        if (programRootFolderId == null) {
            programRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', program.getSubCaption(), new BigInteger("2"));
        }
        
        BigDecimal catgRootFolderId = folderService.getFolderIdByClientBy(header.getClientid(), catg.getValue(), programRootFolderId.toBigInteger());
        if (catgRootFolderId == null) {
            catgRootFolderId = folderService.createTrackITFolder(programRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', catg.getValue(), new BigInteger("2"));
        }
        return catgRootFolderId;*/
        return null;
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditPrjCatg elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(elem.getProjectId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setSpattern(DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")));
            elem.setSno(dao.getNextGlobalSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getSpattern()));
            elem.setBpcn(dao.getNextProjectSequenceNo(NumberSupport.getBigInteger(header.getClientid()), elem.getProjectId()));
            String seqFormat = globClientService.generateSequencialNumber(header.getClientid(), elem.getSno(), "bidit");
            if (StringSupport.isNullOrEmpty(seqFormat)) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setBidNo(seqFormat);
            elem.setBidAddendumRev(BigInteger.ZERO);
            elem.setBidClosed('N');
            elem.setBidPublished('N');
            BigDecimal bidId = dao.save(elem).getId();
            populateSignFlowDef(header, elem);
            return bidId;
        }
        return BigDecimal.ZERO;
    }

    private void populateSignFlowDef(ManageITHeader header, CmBiditPrjCatg elem) {
        String code = "code_bidit_sign_workflow";
        String shortName = "bidsigndesignerwf";
        BigInteger clientId = NumberSupport.getBigInteger(header.getClientid());
        List<CmBiditSignflowdef> list = cmBiditSignflowdefService.list(new ManageITBodyRequest(0, 0).filter("clientId", clientId).filter("typeId.code", code).filter("typeId.shortName", shortName).filter("active", "Y"));
        // Getting TypeId
        List<GlobSystemSimpleCat> typeList = globSystemSimpleCatService.list(new ManageITBodyRequest(0, 2).filter("clientId", clientId).filter("code", code).filter("shortName", shortName).filter("active", 'Y'));
        if (typeList == null || typeList.isEmpty() || typeList.size() > 1) {
            log.error(String.format("Wrong database configuration for GlobSystemSimpleCat for code : '%s' and shortName: '%s' with client: '%s'", code, shortName, clientId));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            return;
        }
        // Add Signatures
        list.forEach(it -> {
            cmBiditSigninfoService.save(header, new CmBiditSigninfo(clientId, it.getSignOrder(), elem.getId().toBigInteger(), it, typeList.get(0)));
        });
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, CmBiditPrjCatg elem) {
        if (elem != null) {
            CmBiditPrjCatg model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private CmBiditPrjCatg populate(CmBiditPrjCatg model, CmBiditPrjCatg elem) {
        model.setBidIssueDate(elem.getBidIssueDate());
        model.setBidClosingDate(elem.getBidClosingDate());
        model.setBidPublishDate(elem.getBidPublishDate());
        model.setDescription(elem.getDescription());
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
    public List<CmBiditPrjCatg> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<CmBiditPrjCatg> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditPrjCatg> finalList = list(request);
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
    public DataGridWrapper<CmBiditPrjCatg> dataGridList(ManageITBodyRequest request) {
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
                CmBiditPrjCatg model = (CmBiditPrjCatg) objResp[0];
                // Set Project Full Name
                if (model.getProjectId() != null) {
                    GlobProject currentproject = globProjectService.findById(model.getProjectId().toString());
                    if (currentproject != null) {
                        model.setProjectFullName(currentproject.getProjectFullName());
                    }
                }
            });
        }
        return vlist;
    }

    @Override
    public Object getFrontEndSearch(ManageITHeader header, CmBidITPrjCatgSearchDefParam defParam) {
        if (defParam == null) {
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
    public void changeStatus(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditPrjCatg model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    @Override
    public void updateBidSignStatus(BigDecimal id, BigInteger statusId) {
        if (id != null) {
            CmBiditPrjCatg model = findById(id);
            if (model != null) {
                model.setStatusId(statusId);
                dao.update(model);
            }
        }
    }

    @Override
    public void changeBidRevision(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("decision"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditPrjCatg model = findById(body.getParams().get("id").toString());
        if (StringSupport.getBoolean(body.getParams().get("decision"))) {
            model.setBidAddendumRev(model.getBidAddendumRev().add(BigInteger.ONE));
            dao.update(model);
        }
    }

    @Override
    public void changePublishStatus(ManageITBodyRequest<Object> body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditPrjCatg model = findById(body.getParams().get("id").toString());
        model.setBidPublished(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    @Override
    public CmBidItAnalysis getBidAnalysis(BigInteger prjCatgId) {
        if (prjCatgId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return null;
        }
        CmBidItAnalysis ana = new CmBidItAnalysis();
        ana.setCompanySummary(dao.getCompanySummary(prjCatgId));
        if (ana.getCompanySummary() != null && !ana.getCompanySummary().isEmpty() && ana.getCompanySummary().stream().anyMatch(p -> p.getIsEngineerEstimation())) {
            ana.setBidItemSummary(dao.getBidItemSummary(prjCatgId, true));
            ana.getCompanySummary().stream().filter(f -> f.getIsEngineerEstimation() == false).forEachOrdered(it -> {
                Map<BigInteger, CmBidItemSummary> bidderList = dao.getBidItemSummary(prjCatgId, false, it.getId());
                ana.addBidderItems(bidderList, it);
            });
        }
        return ana;
    }

    @Override
    public String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, String prjCatgId) {
        if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(reportId)) {
            log.error("Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), funcId, reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            return buildReport(tplbasePath, tplpath, docpathsegment, docType, prjCatgId, paramsJasper, funcId);
        } else {
            log.error("Wrong Database Configuration for this Report.");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String buildReport(String tplbasePath, String tplpath, String docpathsegment, String docType, String prjCatgId, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        // Check Parameters
        if (StringSupport.isNullOrEmpty(prjCatgId)) {
            log.error("Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        BigInteger catgId = NumberSupport.getBigInteger(prjCatgId);

        CmBidItAnalysis anads = getBidAnalysis(catgId);
        paramsJasper.put("COMPANY_DS", anads.getCompanySummary());
        List<CmBidItemSummary> itemDs;
        if (anads.getBidItemSummary() == null || anads.getBidItemSummary().isEmpty()) {
            itemDs = new ArrayList();
        } else {
            itemDs = new ArrayList(anads.getBidItemSummary().values());
        }
        String targetPath = docpathsegment + "EngineerEstimateAnalysis_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, itemDs, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

}
