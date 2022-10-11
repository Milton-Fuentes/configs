/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpmdispatchbo;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.objects.to.reports.IReportSyncfusion;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface BpmDispatchService {

    Bpmdispatchbo findById(String id);

    Bpmdispatchbo findById(String id, BonitaBpmSupport session);

    Bpmdispatchbo findById(BigDecimal id);

    Bpmdispatchbo findByFolderId(String id);

    BigInteger[] save(BigInteger folderId, ManageITBodyRequest request);

    void updateData(Bpmdispatchbo elem);

    void update(Bpmdispatchbo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void update(Bpmdispatchbo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void createRollback(ManageITBodyRequest request, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void delete(ManageITBodyRequest request);

    List<Bpmdispatchbo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;
    
    Long getTotal(ManageITBodyRequest request);
    
    DataTableWrapper<Bpmdispatchbo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    // Particular functions
    Boolean isDraft(ManageITBodyRequest request);

    BigInteger cancelRequest(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    void generateTransmittal(BonitaBpmSupport session, String tplpath, String pdfpathsegment, ManageITBodyRequest request) throws IOException, BonitaException, Exception;

    void notifyTechnicians(String persistenceId, String server_domain, TemplateEngine engine);

    Integer getTechniciansAnsweredStatus(String persistenceId);

    void manageRequestLog(ManageITBodyRequest request, BonitaBpmSupport session, String headerUser) throws BonitaException;

    List<WorkOrderTO> wolist(String id);

    WorkOrderTO findRequestLogById(String logId);

    void updateRequestLogHours(ManageITBodyRequest request) throws ParseException;

    List<IReportSyncfusion> buildReport(String reportId, Map<String, String> paramsMap);

    List<CalendarResourceTO> buildDispatchCalendarResources(ManageITBodyRequest<Object> request);
    
    List<CalendarResourcesDataTO> buildDispatchCalendar(ManageITBodyRequest<Object> request);

    String generateExternalWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String woToken, String docType) throws IOException, BonitaException, Exception;

    String generateWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String persistenceId, String docType, Boolean isWO) throws IOException, BonitaException, Exception;

    String generateWoReportByFilter(BonitaBpmSupport session, String tplpath, String docpathsegment, String type, String[] idArray) throws IOException, BonitaException, Exception;

    Boolean reAssignTech(ManageITBodyRequest<Bpmdispatchbo> request, BonitaBpmSupport session);

    void sendEmail(TemplateEngine engine, ManageITRequest<BpmMailMessage> request, String cc, Boolean isbpmTrackEnable);

    String generateCalendarReport(String tplbasePath, String tplpath, String docpathsegment, ManageITBodyRequest<Object> request);
}
