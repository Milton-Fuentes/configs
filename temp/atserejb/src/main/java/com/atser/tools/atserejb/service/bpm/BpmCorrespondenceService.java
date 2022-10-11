/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpmcorrespondencebo;
import com.atser.tools.atserejb.model.Bpmcorrespondencemetadata;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.chart.ChartColumnSeriesTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public interface BpmCorrespondenceService {

    Bpmcorrespondencebo findById(String id);

    Bpmcorrespondencebo findByFolderId(String id);

    BigInteger save(BigInteger folderId, ManageITBodyRequest request, Bpmcorrespondencemetadata metaId);

    void update(Bpmcorrespondencebo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void update(ManageITHeader header, TemplateEngine engine, Bpmcorrespondencebo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void delete(ManageITBodyRequest request);

    List<Bpmcorrespondencebo> list(ManageITBodyRequest request);

    // Particular functions
    Boolean isDraft(ManageITBodyRequest request);

    BigInteger cancel(ManageITBodyRequest request);

    String generateTransmittal(BonitaBpmSupport session, String tplpath, String pdfpath, ManageITBodyRequest request) throws BonitaException;

    DataTableWrapper<Bpmcorrespondencebo> dataTableList(ManageITBodyRequest request);

    void close(BigDecimal id);

    String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request);

    Map<String, Integer> getTotalByStatus(BigDecimal clientId, BigDecimal projectId);

    BigInteger save1(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine, Bpmcorrespondencemetadata metaId);

}
