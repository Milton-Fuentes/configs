/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.objects.bo.bpm.engine.ArchivedHumanTaskBO;
import com.atser.tools.atserutil.objects.bo.bpm.engine.HumanTaskInstanceBO;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.bpm.BpmTimelineRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.search.SearchOptionsBuilder;

/**
 *
 * @author dperez
 */
public interface BpmOperatorService {

    void UpdateUserInformation(BonitaBpmSupport session, String userid) throws BonitaException;

    void InsertUserInformation(BonitaBpmSupport session, String userid) throws BonitaException;

    void InsertUserInformation(BonitaBpmSupport session, BigDecimal userid) throws BonitaException;

    void DisableUser(BonitaBpmSupport session, String userid, String status) throws BonitaException;
    
    Long StartProcess(BonitaBpmSupport session, String pname, Long userid, Map<String, Serializable> instantiationInputs) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    Long StartProcess(BonitaBpmSupport session, ManageITHeader header, String pname, Map<String, Serializable> instantiationInputs) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException;

    void CancelProcessInstance(BonitaBpmSupport session, Long caseId) throws BonitaException;

    BpmTimelineRequest getRequestTimeLine(BonitaBpmSupport session, Long caseId) throws BonitaException;

    DataGridWrapper<HumanTaskInstanceBO> searchHumanTasks(BonitaBpmSupport session, ManageITRequest<SearchOptionsBuilder> request) throws BonitaException;
    
    DataGridWrapper<ArchivedHumanTaskBO> searchMyArchivedHumanTasks(BonitaBpmSupport session, ManageITRequest<SearchOptionsBuilder> request) throws BonitaException;
    
    List<HumanTaskInstance> getPendingHumanTaskInstances(BonitaBpmSupport session, String user, String clientId) throws BonitaException;
    
    List<HumanTaskInstance> getAssignedHumanTaskInstances(BonitaBpmSupport session, String user, String clientId) throws BonitaException;
}
