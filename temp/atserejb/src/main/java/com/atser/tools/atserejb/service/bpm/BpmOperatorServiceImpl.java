/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.BpmRoleMapping;
import com.atser.tools.atserejb.model.GlobProfiles;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.service.glob.GlobProfilesService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.bpm.engine.ArchivedHumanTaskBO;
import com.atser.tools.atserutil.objects.bo.bpm.engine.HumanTaskInstanceBO;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.bpm.BpmTimelineRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceCriterion;
import org.bonitasoft.engine.bpm.flownode.ArchivedHumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinition;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.search.SearchOptionsBuilder;
import org.bonitasoft.engine.search.SearchResult;

@Stateless
public class BpmOperatorServiceImpl implements BpmOperatorService, IBaseEJBException {

    @Inject
    GlobUserService globUserService;

    @Inject
    GlobProfilesService globProfilesService;

    @Inject
    BpmRoleMappingService bpmRoleMappingService;

    @Override
    public void DisableUser(BonitaBpmSupport session, String userid, String status) throws BonitaException {
        if (userid != null) {
            Boolean bstatus = (StringSupport.isNullOrEmpty(status) || status.equals("true") ? Boolean.TRUE : Boolean.FALSE);
            session.disableUser(userid, bstatus);
        }
    }

    @Override
    public void InsertUserInformation(BonitaBpmSupport session, String userid) throws BonitaException {
        if (userid != null) {
            InsertUserInformation(session, NumberSupport.getBigDecimal(userid));
        }
    }

    @Override
    public void InsertUserInformation(BonitaBpmSupport session, BigDecimal userid) throws BonitaException {
        if (userid != null) {
            GlobUsers user = globUserService.findById(userid);
            if (user != null) {
                List<GlobProfiles> userprofile = globProfilesService.findByUserId(userid);
                for (GlobProfiles globProfiles : userprofile) {
                    BpmRoleMapping map = bpmRoleMappingService.findByManageItRoleAndClientID(globProfiles.getRoleId().getRoleName(), globProfiles.getClientId().getId().toBigInteger());
                    if (map != null) {
                        Boolean isAdmin = map.getIsadmin().equals('Y');
                        session.createUser(user.getId().toString(), user.getContactid().getEmail(), user.getContactid().getFirstname(), user.getContactid().getLastname(), user.getContactid().getTitle(), user.getUserid(), user.getPass(), map.getBpmRoleName(), map.getBpmGroupName(), isAdmin, StringSupport.getString(user.getContactid().getClientId()));
                    }
                }
            }
        }
    }

    @Override
    public void UpdateUserInformation(BonitaBpmSupport session, String userid) throws BonitaException {
        GlobUsers user = globUserService.findById(userid);
        if (user != null) {
            session.updateUserInformation(user.getUserid(), user.getContactid().getEmail(), user.getContactid().getFirstname(), user.getContactid().getLastname(), user.getContactid().getTitle(), user.getPass());
        }
    }

    @Override
    public Long StartProcess(BonitaBpmSupport session, ManageITHeader header, String pname, Map<String, Serializable> instantiationInputs) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        return session.startProcessWithContract(pname, header.getUser(), instantiationInputs);
    }

    @Override
    public Long StartProcess(BonitaBpmSupport session, String pname, Long userid, Map<String, Serializable> instantiationInputs) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        return session.startProcessWithContract(pname, userid, instantiationInputs);
    }

    @Override
    public void CancelProcessInstance(BonitaBpmSupport session, Long caseId) throws BonitaException {
        session.cancelProcessInstance(caseId);
    }

    @Override
    public BpmTimelineRequest getRequestTimeLine(BonitaBpmSupport session, Long caseId) throws BonitaException {
        return session.getRequestTimeLine(caseId);
    }

    /**
     * Search My Available Human Tasks
     *
     * @param session
     * @param request
     * @return DataGridWrapper
     * @throws BonitaException
     */
    @Override
    public DataGridWrapper<HumanTaskInstanceBO> searchHumanTasks(BonitaBpmSupport session, ManageITRequest<SearchOptionsBuilder> request) throws BonitaException {
        if (request == null || !request.validate() || request.getBody().getData() == null || StringSupport.isNullOrEmpty(request.getHeader().getClientid(), request.getHeader().getUser())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        SearchResult<HumanTaskInstance> qds = session.searchHumanTasks(request.getBody().getData());
        List<HumanTaskInstanceBO> boList = new ArrayList<>();

        qds.getResult().forEach(p -> {
            HumanTaskInstanceBO bo = new HumanTaskInstanceBO();
            bo.setId(p.getId());
            bo.setName(p.getName());
            bo.setDisplayName(p.getDisplayName());
            bo.setState(p.getState());
            bo.setProcessDefinitionId(p.getProcessDefinitionId());
            // Get process Definition
            try {
                ProcessDefinition pi = session.getProcessAPI().getProcessDefinition(p.getProcessDefinitionId());
                bo.setProcessName(pi.getName());
                bo.setProcessVersion(pi.getVersion());
            } catch (BonitaException | NullPointerException ex) {
                bo.setProcessName(null);
                bo.setProcessVersion(null);
            }
            bo.setRootContainerId(p.getRootContainerId());
            bo.setAssigneeId(p.getAssigneeId());
            // Get Executed User
            try {
                User user = session.getUserById(p.getAssigneeId());
                bo.setAssigneeFullName(user.getFirstName() + " " + StringSupport.emptyOnNull(user.getLastName()));
                bo.setAssigneeJobTitle(StringSupport.emptyOnNull(user.getJobTitle()));
                bo.setAssigneeLastConnection(user.getLastConnection());
            } catch (BonitaException | NullPointerException ex) {
                bo.setAssigneeFullName(null);
                bo.setAssigneeJobTitle(null);
                bo.setAssigneeLastConnection(null);
            }
            bo.setClaimedDate(p.getClaimedDate());
            bo.setLastUpdateDate(p.getLastUpdateDate());
            bo.setReachedStateDate(p.getReachedStateDate());
            bo.setPriority(p.getPriority().toString());
            boList.add(bo);
        });
        return new DataGridWrapper<>(boList, qds.getCount());
    }

    @Override
    public DataGridWrapper<ArchivedHumanTaskBO> searchMyArchivedHumanTasks(BonitaBpmSupport session, ManageITRequest<SearchOptionsBuilder> request) throws BonitaException {
        if (request == null || !request.validate() || request.getBody().getData() == null || StringSupport.isNullOrEmpty(request.getHeader().getClientid(), request.getHeader().getUser())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        SearchResult<ArchivedHumanTaskInstance> qds = session.searchArchivedHumanTasks(request.getBody().getData());
        List<ArchivedHumanTaskBO> boList = new ArrayList<>();

        qds.getResult().forEach(p -> {
            ArchivedHumanTaskBO bo = new ArchivedHumanTaskBO();
            bo.setId(p.getId());
            bo.setName(p.getName());
            bo.setDisplayName(p.getDisplayName());
            bo.setArchiveDate(p.getArchiveDate());
            bo.setState(p.getState());
            bo.setProcessInstanceId(p.getProcessInstanceId());
            bo.setProcessDefinitionId(p.getProcessDefinitionId());
            // Get process Definition
            try {
                ProcessDefinition pi = session.getProcessAPI().getProcessDefinition(p.getProcessDefinitionId());
                bo.setProcessName(pi.getName());
                bo.setProcessVersion(pi.getVersion());
            } catch (BonitaException | NullPointerException ex) {
                bo.setProcessName(null);
                bo.setProcessVersion(null);
            }
            bo.setRootContainerId(p.getRootContainerId());
            bo.setAssigneeId(p.getAssigneeId());
            // Get Executed User
            try {
                User user = session.getUserById(p.getAssigneeId());
                bo.setAssigneeFullName(user.getFirstName() + " " + StringSupport.emptyOnNull(user.getLastName()));
                bo.setAssigneeJobTitle(StringSupport.emptyOnNull(user.getJobTitle()));
                bo.setAssigneeLastConnection(user.getLastConnection());
            } catch (BonitaException | NullPointerException ex) {
                bo.setAssigneeFullName(null);
                bo.setAssigneeJobTitle(null);
                bo.setAssigneeLastConnection(null);
            }
            bo.setReachedStateDate(p.getReachedStateDate());
            bo.setClaimedDate(p.getClaimedDate());
            bo.setPriority(p.getPriority().toString());
            boList.add(bo);
        });
        return new DataGridWrapper<>(boList, qds.getCount());
    }

    @Override
    public List<HumanTaskInstance> getPendingHumanTaskInstances(BonitaBpmSupport session, String user, String clientId) throws BonitaException {
        if (session == null || StringSupport.isNullOrEmpty(user, clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        try {
            User bpmuser = session.getUserByUserName(user);
            return session.getPendingHumanTaskInstances(bpmuser.getId(), 0, Integer.MAX_VALUE, ActivityInstanceCriterion.NAME_ASC);
        } catch (NullPointerException ex) {
            throwBaseException(Response.Status.NOT_FOUND, "User to Execute this query not found.");
            return null;
        }
    }

    @Override
    public List<HumanTaskInstance> getAssignedHumanTaskInstances(BonitaBpmSupport session, String user, String clientId) throws BonitaException {
        if (session == null || StringSupport.isNullOrEmpty(user, clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        try {
            User bpmuser = session.getUserByUserName(user);
            return session.getAssignedHumanTaskInstances(bpmuser.getId(), 0, Integer.MAX_VALUE, ActivityInstanceCriterion.NAME_ASC);
        } catch (NullPointerException ex) {
            throwBaseException(Response.Status.NOT_FOUND, "User to Execute this query not found.");
            return null;
        }
    }

}
