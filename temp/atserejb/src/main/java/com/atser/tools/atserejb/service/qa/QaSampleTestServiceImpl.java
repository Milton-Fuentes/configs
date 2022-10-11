/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleTestAddInfoDao;
import com.atser.tools.atserejb.dao.qa.QaSampleTestDao;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserejb.model.QaTestMethods;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridExcelSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleTestSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import org.jboss.resteasy.spi.ResteasyUriInfo;

@Stateless
public class QaSampleTestServiceImpl implements QaSampleTestService, IBaseEJBException {

    @Inject
    private QaSampleTestDao dao;

    @Inject
    private QaSampleTestAddInfoDao qaSampleTestAddInfoDao;

    @Inject
    private QaTestMethodsService qaTestMethodsService;

    @Override
    public QaSampleTest findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleTest findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaSampleTest elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaSampleTest elem) {
        if (elem != null) {
            QaSampleTest model = findById(elem.getId());
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
    public List<QaSampleTest> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Object getFrontEndSearchTest(ManageITHeader header, ManageITBodyRequest body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getSearchTestsInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
        } else {
            switch (datatype) {
                case "table": {
                    return getSearchTestsInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private DataTableWrapper<QaSampleTestSearchBO> getSearchTestsInbox(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params) {
        // Define parameters
        QaSampleTestSearchDefParam tp = new QaSampleTestSearchDefParam();
        tp.userId = userId;
        tp.currentRole = currentRole;
        tp.clientId = clientId;
        tp.projectId = StringSupport.getString(params.get("projectId"));
        tp.testId = StringSupport.getString(params.get("testId"));
        tp.functionId = StringSupport.getString(params.get("functionId"));
        tp.startDate = StringSupport.getString(params.get("startDate"));
        tp.endDate = StringSupport.getString(params.get("endDate"));
        tp.themeCompany = StringSupport.getString(params.get("themeCompany"));
        tp.labLocationId = StringSupport.getString(params.get("labLocationId"));
        tp.category = StringSupport.getString(params.get("category"));
        tp.sortBy = StringSupport.getString(params.get("sortBy"));
        tp.sortDir = StringSupport.getString(params.get("sortDir"));
        tp.dtSearchUrl = StringSupport.getString(params.get("dtSearchUrl"));
        tp.startIndex = NumberSupport.getInteger(params.get("startIndex"));
        tp.maxResults = NumberSupport.getInteger(params.get("maxResults"));
        tp.isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        tp.multiproject = StringSupport.getBoolean(params.get("multiproject"));
        tp.usesWorkorder = StringSupport.getBoolean(params.get("useWorkorder"));
        tp.isAllDateActive = StringSupport.getBoolean(params.get("isAllDateActive"));
        tp.showInactive = StringSupport.getBoolean(params.get("showInactive"));
        if (StringSupport.isNullOrEmpty(params.get("showDistributionHold"))) {
            tp.useDistributionHold = false;
            tp.showDistributionHold = false;
        } else {
            tp.useDistributionHold = true;
            tp.showDistributionHold = StringSupport.getBoolean(params.get("showDistributionHold"));
        }
        tp.showLabReportno = StringSupport.getBoolean(params.get("showLabReportno"));
        tp.usesContractorReportSequence = StringSupport.getBoolean(params.get("usesContractorReportSequence"));
        tp.useGlobalProfiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        tp.usesRoleMatrix = StringSupport.getBoolean(params.get("usesRoleMatrix"));
        tp.usesReviewerShowUnapproved = StringSupport.getBoolean(params.get("usesReviewerShowUnapproved"));
        tp.testViewUnacknowledged = StringSupport.getBoolean(params.get("testViewUnacknowledged"));
        tp.testlogShowacknowledgeByproject = StringSupport.getBoolean(params.get("testlogShowacknowledgeByproject"));
        tp.testlogShowacknowledge = StringSupport.getBoolean(params.get("testlogShowacknowledge"));
        tp.testlogShowstateengineer = StringSupport.getBoolean(params.get("testlogShowstateengineer"));
        tp.showMaterialuse = StringSupport.getBoolean(params.get("showMaterialuse"));
        tp.sampleMatCodeId = StringSupport.getString(params.get("sampleMatCodeId"));
        tp.sampleMaterialUseId = StringSupport.getString(params.get("sampleMaterialUseId"));
        tp.sampleRandomCode = StringSupport.getString(params.get("sampleRandomCode"));
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
        return dao.getFrontEndSearchTestInbox(tp);
    }

    @Override
    public QaSampleTest createEmptyTestOrGetTest(ManageITHeader header, QaSample sampleId, String material, String testTable) {
        if (sampleId == null || header == null || StringSupport.isNullOrEmpty(header.getClientid(), material, testTable)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<QaTestMethods> testMethodsList = qaTestMethodsService.getTestMethodsByCatgAndTestTable(NumberSupport.getBigInteger(header.getClientid()), material, testTable);
        if (testMethodsList == null || testMethodsList.isEmpty() || testMethodsList.size() > 1) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Test Methods Configuration.");
        }
        QaTestMethods testMethod = testMethodsList.get(0);

        List<QaSampleTest> sampleTestList = list(new ManageITBodyRequest(0, 1).filter("sampleId", sampleId.getId()).filter("testId", testMethod.getId().toString()).filter("active", 'Y'));

        if (sampleTestList != null && !sampleTestList.isEmpty()) {
            return sampleTestList.get(0);
        }

        // Creating SampleTest
        QaSampleTest sampleTest = new QaSampleTest();
        sampleTest.setSampleId(NumberSupport.getBigInteger(sampleId.getId()));
        sampleTest.setTestId(testMethod.getId().toString());
        sampleTest.setStatus("Pending");
        sampleTest.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        sampleTest.setCreateBy(header.getUser());
        sampleTest.setCreateByIp(header.getModIp());
        sampleTest.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        sampleTest.setLastModIp(header.getModIp());
        sampleTest.setLastModBy(header.getUser());
        sampleTest.setActive('Y');
        sampleTest.setVersion("0");
        sampleTest.setUnapproved('N');
        sampleTest.setTestNo(StringSupport.getString(getNextTestNoByProject(sampleId.getProjectId())));
        sampleTest.setInfoId(sampleId.getInfoId());
        sampleTest.setPendingapproved('N');
        sampleTest.setTestDate(sampleId.getCollectionDate());
        sampleTest.setReviewed('N');
        sampleTest.setRejected('N');
        sampleTest.setPeReview('N');
        sampleTest.setTestClosed('N');
        sampleTest.setAlerted('N');
        dao.save(sampleTest);

        // Creating SampleTestAddInfo
        QaSampleTestAddInfo testAddInfo = new QaSampleTestAddInfo();
        testAddInfo.setSampleTestId(sampleTest);
        testAddInfo.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        testAddInfo.setCreateBy(header.getUser());
        testAddInfo.setCreateByIp(header.getModIp());
        testAddInfo.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        testAddInfo.setLastModIp(header.getModIp());
        testAddInfo.setLastModBy(header.getUser());
        testAddInfo.setActive('Y');
        testAddInfo.setVersion("0");
        testAddInfo.setEngDecision("No");
        qaSampleTestAddInfoDao.save(testAddInfo);
        return sampleTest;
    }

    @Override
    public BigInteger getNextTestNoByProject(BigInteger projectId) {
        if (projectId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getNextTestNoByProject(projectId);
    }

    @Override
    public String generateReport(ManageITHeader header, ManageITBodyRequest<ReportGridWrapper> body, String docpathsegment) {
        if (header == null || body == null || body.getParams() == null || body.getData() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return null;
        }
        AtserLinkedHashMap<String, Object> params = body.getParams();
        ReportGridWrapper reportGridWrapper = body.getData();
        String clientName = StringSupport.getString(params.get("themeCompany"));
        eDocExtension extension;
        if (reportGridWrapper.getDocType() == null || reportGridWrapper.getDocType().isEmpty()) {
            extension = eDocExtension.csv;
        } else {
            extension = eDocExtension.valueOf(reportGridWrapper.getDocType());
        }

        // Define parameters
        QaSampleTestSearchDefParam tp = new QaSampleTestSearchDefParam();
        tp.userId = header.getUserid();
        tp.currentRole = header.getRole();
        tp.clientId = header.getClientid();
        tp.projectId = StringSupport.getString(params.get("projectId"));
        tp.testId = StringSupport.getString(params.get("testId"));
        tp.functionId = StringSupport.getString(params.get("functionId"));
        tp.startDate = StringSupport.getString(params.get("startDate"));
        tp.endDate = StringSupport.getString(params.get("endDate"));
        tp.themeCompany = StringSupport.getString(params.get("themeCompany"));
        tp.labLocationId = StringSupport.getString(params.get("labLocationId"));
        tp.category = StringSupport.getString(params.get("category"));
        tp.sortBy = StringSupport.getString(params.get("sortBy"));
        tp.sortDir = StringSupport.getString(params.get("sortDir"));
        tp.dtSearchUrl = StringSupport.getString(params.get("dtSearchUrl"));
        tp.isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        tp.multiproject = StringSupport.getBoolean(params.get("multiproject"));
        tp.usesWorkorder = StringSupport.getBoolean(params.get("useWorkorder"));
        tp.isAllDateActive = StringSupport.getBoolean(params.get("isAllDateActive"));
        tp.showInactive = StringSupport.getBoolean(params.get("showInactive"));
        if (StringSupport.isNullOrEmpty(params.get("showDistributionHold"))) {
            tp.useDistributionHold = false;
            tp.showDistributionHold = false;
        } else {
            tp.useDistributionHold = true;
            tp.showDistributionHold = StringSupport.getBoolean(params.get("showDistributionHold"));
        }
        tp.showLabReportno = StringSupport.getBoolean(params.get("showLabReportno"));
        tp.usesContractorReportSequence = StringSupport.getBoolean(params.get("usesContractorReportSequence"));
        tp.useGlobalProfiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        tp.usesRoleMatrix = StringSupport.getBoolean(params.get("usesRoleMatrix"));
        tp.usesReviewerShowUnapproved = StringSupport.getBoolean(params.get("usesReviewerShowUnapproved"));
        tp.testViewUnacknowledged = StringSupport.getBoolean(params.get("testViewUnacknowledged"));
        tp.testlogShowacknowledgeByproject = StringSupport.getBoolean(params.get("testlogShowacknowledgeByproject"));
        tp.testlogShowacknowledge = StringSupport.getBoolean(params.get("testlogShowacknowledge"));
        tp.testlogShowstateengineer = StringSupport.getBoolean(params.get("testlogShowstateengineer"));
        tp.showMaterialuse = StringSupport.getBoolean(params.get("showMaterialuse"));
        tp.sampleMatCodeId = StringSupport.getString(params.get("sampleMatCodeId"));
        tp.sampleMaterialUseId = StringSupport.getString(params.get("sampleMaterialUseId"));
        tp.sampleRandomCode = StringSupport.getString(params.get("sampleRandomCode"));
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
        List<QaSampleTestSearchBO> ds = dao.getFrontEndSearchAllTestInbox(tp);
        String targetPath = docpathsegment + "SummaryTest_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridExcelSimple jd = new JasperDesignGridExcelSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, extension);
            JasperDesign tpl = jd.buildTemplate("Test Dashboard", QaSampleTestSearchBO.class, reportGridWrapper.getColumns());
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void alertByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setAlerted('Y');
        model.setAlertedBy(header.getUser());
        this.update(header, model);
    }

    public void approveByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setApprovedby(header.getUser());
        model.setApproveDate(new Date());
        model.setApprovedTimestamp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setApproveDateTmp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setStatus("Approved");
        this.update(header, model);
    }

    public void signOffApproveByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setApprovedby(header.getUser());
        model.setApproveDate(new Date());
        model.setApprovedTimestamp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setApproveDateTmp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setStatus("Sign Off");
        this.update(header, model);
    }

    public void stateEngApproveByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setApprovedby(header.getUser());
        model.setApproveDate(new Date());
        model.setApprovedTimestamp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setApproveDateTmp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setStatus("State Engineer Approved");
        this.update(header, model);
    }

    public void completeByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setCompletedBy(header.getUser());
        model.setDateCompleted(new Date());
        model.setDateCompletedTmp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setCompletedTimestamp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setStatus("Complete");
        this.update(header, model);
    }

    public void reviewByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setReviewed('Y');
        model.setReviewedBy(header.getUser());
        model.setReviewedDate(new Date());
        model.setReviewedTimestamp(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setStatus("Reviewed");
        this.update(header, model);
    }

    public void rejectByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setRejectedBy(header.getUser());
        model.setRejected('Y');
        model.setStatus("Rejected");
        this.update(header, model);
    }

    public void unapproveByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setUnapprovedBy(header.getUser());
        model.setUnapproved('Y');
        model.setStatus("Appr/Edit");
        this.update(header, model);
    }

    public void acknowledgedByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setStatus("Acknowledged");
        model.setAcknowledgedby(header.getUser());
        model.setAcknowledgedDate(new Date());
        this.update(header, model);
    }

    public void contractorAcknowledgedByTestId(ManageITHeader header, String id) {
        QaSampleTest model = this.findById(id);
        model.setStatus("Contractor Acknowledged");
        model.setAcknowledgedby(header.getUser());
        model.setAcknowledgedDate(new Date());
        this.update(header, model);
    }

    @Override
    public void signByTestId(ManageITHeader header, String id, String action) {
        if (header != null && StringSupport.isNotNullAndNotEmpty(id) && StringSupport.isNotNullAndNotEmpty(action)) {
            switch (action) {
                case "alert": {
                    this.alertByTestId(header, id);
                    break;
                }
                case "approve": {
                    this.approveByTestId(header, id);
                    break;
                }
                case "signoff": {
                    this.signOffApproveByTestId(header, id);
                    break;
                }
                case "stateengineer": {
                    this.stateEngApproveByTestId(header, id);
                    break;
                }
                case "complete": {
                    this.completeByTestId(header, id);
                    break;
                }
                case "review": {
                    this.reviewByTestId(header, id);
                    break;
                }
                case "unapprove": {
                    this.unapproveByTestId(header, id);
                    break;
                }
                case "acknowledged": {
                    this.acknowledgedByTestId(header, id);
                    break;
                }
                case "contractor": {
                    this.contractorAcknowledgedByTestId(header, id);
                    break;

                }
            }

        }
    }

    @Override
    public BigDecimal getDynamicTestTableId(String tableName, BigInteger sampleTestId) {
        if(StringSupport.isNullOrEmpty(tableName) || sampleTestId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return dao.getDynamicTestTableId(tableName, sampleTestId);
    }
}
