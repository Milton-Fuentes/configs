/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpminspectordispatchbo;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.InspWorkOrderTO;
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
public interface BpmInspectorDispatchService {

    Bpminspectordispatchbo findById(String id);

    Bpminspectordispatchbo findById(String id, BonitaBpmSupport session);

    Bpminspectordispatchbo findById(BigDecimal id);

    Bpminspectordispatchbo findByFolderId(String id);

    BigInteger[] save(BigInteger folderId, ManageITBodyRequest request);

    void updateData(Bpminspectordispatchbo elem);

    void update(Bpminspectordispatchbo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void update(Bpminspectordispatchbo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void createRollback(ManageITBodyRequest request, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void delete(ManageITBodyRequest request);

    List<Bpminspectordispatchbo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;
    
    Long getTotal(ManageITBodyRequest request);
    
    DataTableWrapper<Bpminspectordispatchbo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    // Particular functions
    Boolean isDraft(ManageITBodyRequest request);
    
    BigInteger cancelRequest(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    void generateTransmittal(BonitaBpmSupport session, String tplpath, String pdfpathsegment, ManageITBodyRequest request) throws IOException, BonitaException, Exception;

    void notifyInspectors(String persistenceId, String server_domain, TemplateEngine engine);

    Integer getInspectorsAnsweredStatus(String persistenceId);

    void manageRequestLog(ManageITRequest<List<InspWorkOrderTO>> request, BonitaBpmSupport session, String headerUser) throws BonitaException;

    List<InspWorkOrderTO> wolist(String id);

    InspWorkOrderTO findRequestLogById(String logId);

    void updateRequestLogHours(ManageITBodyRequest request) throws ParseException;

    List<IReportSyncfusion> buildReport(String reportId, Map<String, String> paramsMap);

    String generateExternalWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String woToken, String docType) throws IOException, BonitaException, Exception;

    String generateWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String persistenceId, String docType, Boolean isWO) throws IOException, BonitaException, Exception;

    String generateWoReportByFilter(BonitaBpmSupport session, String tplpath, String docpathsegment, String type, String[] idArray) throws IOException, BonitaException, Exception;

    public Boolean reAssignInspector(ManageITBodyRequest<Bpminspectordispatchbo> request, BonitaBpmSupport session);

    public void sendEmail(TemplateEngine engine, ManageITRequest<BpmMailMessage> request, String cc, Boolean isbpmTrackEnable);
}
