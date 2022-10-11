/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.VwBpmSubmittalAllDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.VwBpmSubmittalAll;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.bpm.BpmTaskInstanceService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class VwBpmSubmittalAllServiceImpl implements VwBpmSubmittalAllService, IBaseEJBException {

    @Inject
    private VwBpmSubmittalAllDao dao;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Override
    public VwBpmSubmittalAll findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public VwBpmSubmittalAll findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public DataTableWrapper<VwBpmSubmittalAll> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwBpmSubmittalAll> finalList = list(request);
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
    public DataGridWrapper<VwBpmSubmittalAll> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<VwBpmSubmittalAll> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Map<String, Integer> getTotalByStatus(BigDecimal clientId, BigDecimal projectId) {
        Map<String, Integer> result = new HashMap<>();
        List<VwBpmSubmittalAll> process;

        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("clientId", clientId);
        search.filter("projectId", projectId);

        // Find [Draft] Submittals
        process = list(search.filter("status", "Draft"));
        result.put("Draft", process.isEmpty() ? 0 : process.size());

        // Find [Closed] Submittals
        search.getFilter().remove(2);
        process = list(search.filter("status", "In Review"));
        result.put("In Review", process.isEmpty() ? 0 : process.size());

        // Find [In Review] Submittals
        search.getFilter().remove(2);
        process = list(search.filter("status", "Closed"));
        result.put("Closed", process.isEmpty() ? 0 : process.size());

        return result;
    }

    @Override
    public Map<String, BigDecimal> getTotalOverdue(BigDecimal clientId, BigDecimal projectId) {
        Map<String, BigDecimal> result = new HashMap<>();
        result.put("1 to 3 Days", dao.getTotalOverdue(clientId, projectId, 1, 3));
        result.put("4 to 7 Days", dao.getTotalOverdue(clientId, projectId, 4, 7));
        result.put("> 7 Days", dao.getTotalOverdue(clientId, projectId, 7, null));
        return result;
    }

    @Override
    public Map<String, Long> getDaysByProcess(ManageITBodyRequest request) {
        Map<String, Long> daysByProcess = new HashMap<String, Long>();
        List<VwBpmSubmittalAll> list = list(request);
        Date endDate;
        for (VwBpmSubmittalAll item : list) {
            if ("Closed".equals(item.getStatus())) {
                endDate = item.getDoneDate();
            } else {
                endDate = new Date();
            }
            if (endDate != null && item.getCreated() != null) {
                Long days = DateSupport.daysBeetwenDates(item.getCreated(), endDate);
                daysByProcess.put(item.getSubnumber(), days);
            }
        }
        return daysByProcess;
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
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), funcId, reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);

            BufferedImage clientLogoImage = genericHelperService.getClientLogo(header.getClientid());
            paramsJasper.put("CLIENT_LOGO", clientLogoImage);

            if (request.getParams() != null && StringSupport.isNotNullAndNotEmpty(request.getParams().get("projectId"))) {
                GlobProject project = projectService.findById(request.getParams().get("projectId").toString());
                paramsJasper.put("PROJECT_NAME", project.getPName());
                paramsJasper.put("PROJECT_NUMBER", project.getPNumber());
            }

            return buildReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper, funcId);
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
    private String buildReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<VwBpmSubmittalAll> pResult = generateReportData(request);
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private List<VwBpmSubmittalAll> generateReportData(ManageITBodyRequest request) {
        // Load process list.
        List<VwBpmSubmittalAll> list = list(request);

        for (VwBpmSubmittalAll item : list) {
            if ("BPM_SUBMITTAL".equals(item.getSource())) {
                // Load process tasks.
                ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
                search.filter("refId", item.getPersistenceid());
                search.filter("taskId.processId.code", "BPM_SUBMITTAL");
                item.setTaskInstanceList(bpmTaskInstanceService.list(search));
                // Set current/last task.
                if (!item.getTaskInstanceList().isEmpty()) {
                    item.setTaskInstanceCurrent(item.getTaskInstanceList().get(item.getTaskInstanceList().size() - 1));
                }
            }
        }
        return list;
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
        List<VwBpmSubmittalAll> pResult = generateReportData(request);
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
