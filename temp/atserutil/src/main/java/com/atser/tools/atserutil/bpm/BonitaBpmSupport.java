/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.bpm;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.bpm.BpmTimelineRequest;
import com.atser.tools.atserutil.objects.to.bpm.BpmTimelineTask;
import java.io.Serializable;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.LoginAPI;
import org.bonitasoft.engine.api.PlatformAPI;
import org.bonitasoft.engine.api.PlatformAPIAccessor;
import org.bonitasoft.engine.api.PlatformLoginAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.api.ProcessRuntimeAPI;
import org.bonitasoft.engine.api.ProfileAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceCriterion;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstanceSearchDescriptor;
import org.bonitasoft.engine.bpm.flownode.ArchivedHumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.FlowNodeType;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstanceSearchDescriptor;
import org.bonitasoft.engine.bpm.process.ArchivedProcessInstance;
import org.bonitasoft.engine.bpm.process.ArchivedProcessInstancesSearchDescriptor;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinition;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessDeploymentInfo;
import org.bonitasoft.engine.bpm.process.ProcessDeploymentInfoSearchDescriptor;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.bpm.process.ProcessInstanceSearchDescriptor;
import org.bonitasoft.engine.exception.AlreadyExistsException;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.identity.ContactData;
import org.bonitasoft.engine.identity.ContactDataCreator;
import org.bonitasoft.engine.identity.ContactDataUpdater;
import org.bonitasoft.engine.identity.CustomUserInfoValue;
import org.bonitasoft.engine.identity.CustomUserInfoValueSearchDescriptor;
import org.bonitasoft.engine.identity.Group;
import org.bonitasoft.engine.identity.GroupSearchDescriptor;
import org.bonitasoft.engine.identity.Role;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserCreator;
import org.bonitasoft.engine.identity.UserSearchDescriptor;
import org.bonitasoft.engine.identity.UserUpdater;
import org.bonitasoft.engine.identity.UserWithContactData;
import org.bonitasoft.engine.profile.Profile;
import org.bonitasoft.engine.profile.ProfileMemberCreator;
import org.bonitasoft.engine.profile.ProfileSearchDescriptor;
import org.bonitasoft.engine.search.Order;
import org.bonitasoft.engine.search.SearchOptionsBuilder;
import org.bonitasoft.engine.search.SearchResult;
import org.bonitasoft.engine.session.APISession;
import org.bonitasoft.engine.session.InvalidSessionException;
import org.bonitasoft.engine.session.PlatformSession;
import org.bonitasoft.engine.util.APITypeManager;

/**
 *
 * @author droldan
 */
public final class BonitaBpmSupport {

    private final BpmConfiguration config;
    private APISession session;

    public BonitaBpmSupport(BpmConfiguration config) throws BonitaException, ConnectException {
        this.config = config;
        if (config.getIsEnabled()) {
            initBpmContextAndLogin();
        }
    }

    private void initBpmContextAndLogin() throws BonitaException, ConnectException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("server.url", this.config.getBpmPath());
        parameters.put("application.name", this.config.getBpmContext());
        parameters.put("connections.max", "50");
        APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, parameters);
        doTenantLogin();
    }

    public boolean isSessionActive() {
        return (config.getIsEnabled() && session != null);
    }

    public void refreshBonitaBpmSession() {
        if (isSessionActive()) {
            try {
                getUserById(-1L);
            } catch (InvalidSessionException | BonitaException ex) {
                this.session = null;
                System.out.println("Refreshing Bonita Bpm Session");
                try {
                    initBpmContextAndLogin();
                } catch (BonitaException | ConnectException ex1) {
                    System.out.println("Error Refreshing Bonita Bpm Session");
                    this.session = null;
                }
            } catch (Exception ex) {
                this.session = null;
            }
        } else {
            if (config.getIsEnabled() && session == null) {
                System.out.println("Refreshing Bonita Bpm Session");
                try {
                    initBpmContextAndLogin();
                } catch (BonitaException | ConnectException ex1) {
                    System.out.println("Error Refreshing Bonita Bpm Session");
                    this.session = null;
                }
            }
        }
    }

    public APISession getSession() {
        return session;
    }

    private LoginAPI getLoginAPI() throws BonitaException {
        return TenantAPIAccessor.getLoginAPI();
    }

    private void doTenantLogin() throws BonitaException, ConnectException {
        this.session = getLoginAPI().login(config.getBpmUserName(), config.getBpmPwd());
    }

    private PlatformLoginAPI getPlaformLoginAPI() throws BonitaException {
        return PlatformAPIAccessor.getPlatformLoginAPI();
    }

    private PlatformAPI getPlatformAPI(PlatformSession platformSession) throws BonitaException {
        return PlatformAPIAccessor.getPlatformAPI(platformSession);
    }

    public IdentityAPI getIdentityAPI() throws BonitaException {
        return TenantAPIAccessor.getIdentityAPI(this.session);
    }

    public ProfileAPI getProfileAPI() throws BonitaException {
        return TenantAPIAccessor.getProfileAPI(this.session);
    }

    private ProcessRuntimeAPI getProcessRuntimeAPI() throws BonitaException {
        return (ProcessRuntimeAPI) TenantAPIAccessor.getProcessAPI(this.session);
    }

    public ProcessAPI getProcessAPI() throws BonitaException {
        return TenantAPIAccessor.getProcessAPI(this.session);
    }

    public void doTenantLogout() {
        try {
            if (isSessionActive()) {
                getLoginAPI().logout(this.session);
                this.session = null;
            }
        } catch (BonitaException ex) {
            Logger.getLogger(BonitaBpmSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get Role Id by Role Name
     *
     * @param rolename
     * @return
     * @throws BonitaException
     */
    public long getRoleIdByName(String rolename) throws BonitaException {
        Role rol = getRoleByName(rolename);
        if (rol != null) {
            return rol.getId();
        }
        return -1L;
    }

    public Role getRoleByName(String rolename) throws BonitaException {
        return getIdentityAPI().getRoleByName(rolename);
    }

    /**
     * Get Group Id by Group Name
     *
     * @param groupname
     * @return
     * @throws BonitaException
     */
    public long getGroupIdByName(String groupname) throws BonitaException {
        SearchOptionsBuilder builder = new SearchOptionsBuilder(0, 100);
        builder.filter(GroupSearchDescriptor.NAME, groupname);
        SearchResult<Group> searchGroup = getIdentityAPI().searchGroups(builder.done());
        if (searchGroup.getResult().size() >= 1) {
            return searchGroup.getResult().get(0).getId();
        }
        return -1L;
    }

    /**
     * Get Group By Path
     *
     * @param groupPath
     * @return Group
     * @throws BonitaException
     */
    public Group getGroupByPath(String groupPath) throws BonitaException {
        return getIdentityAPI().getGroupByPath(groupPath);
    }

    /**
     * Remove User
     *
     * @param userid
     * @throws BonitaException
     */
    public void removeUser(long userid) throws BonitaException {
        getIdentityAPI().deleteUser(userid);
    }

    /**
     * Get Bonita User By User Name
     *
     * @param username
     * @return
     * @throws BonitaException
     */
    public User getUserByUserName(String username) throws BonitaException {
        SearchOptionsBuilder builder = new SearchOptionsBuilder(0, 5);
        builder.filter(UserSearchDescriptor.USER_NAME, username);
        SearchResult<User> searchUser = getIdentityAPI().searchUsers(builder.done());
        if (searchUser.getResult().size() >= 1) {
            return searchUser.getResult().get(0);
        }
        return null;
    }

    /**
     * Get Bonita User by User Id
     *
     * @param id
     * @return
     * @throws BonitaException
     */
    public User getUserById(long id) throws BonitaException {
        SearchOptionsBuilder builder = new SearchOptionsBuilder(0, 10);
        builder.filter(UserSearchDescriptor.ID, id);
        SearchResult<User> searchUser = getIdentityAPI().searchUsers(builder.done());
        if (searchUser.getResult().size() >= 1) {
            return searchUser.getResult().get(0);
        }
        return null;
    }

    /**
     * Get Bonita Professional Data by UserId
     *
     * @param id
     * @return
     * @throws BonitaException
     */
    public ContactData getProfessionalDataById(long id) throws BonitaException {
        UserWithContactData proUser = getIdentityAPI().getUserWithProfessionalDetails(id);
        if (proUser != null) {
            return proUser.getContactData();
        }
        return null;
    }

    /**
     * Assign User to Profile
     *
     * @param user
     * @param profileName
     * @throws BonitaException
     */
    private void assignUserToProfile(User user, String profileName) throws BonitaException {
        org.bonitasoft.engine.api.ProfileAPI orgProfileAPI = getProfileAPI();
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 50);
        searchOptionsBuilder.filter(ProfileSearchDescriptor.NAME, profileName);
        SearchResult<Profile> searchResultProfile = orgProfileAPI.searchProfiles(searchOptionsBuilder.done());
        if (searchResultProfile.getResult().size() != 1) {
            return;
        }
        Profile profile = searchResultProfile.getResult().get(0);
        ProfileMemberCreator profileMemberCreator = new ProfileMemberCreator(profile.getId());
        profileMemberCreator.setUserId(user.getId());
        orgProfileAPI.createProfileMember(profileMemberCreator);
    }

    /**
     * Assign association between User and Group/Role
     *
     * @param user
     * @param groupname
     * @param rolename
     * @throws BonitaException
     * @throws Exception
     */
    private void assignUserToGroupRole(User user, String groupname, String rolename) throws BonitaException, Exception {
        long groupId = getGroupIdByName(groupname);
        long roleId = getRoleIdByName(rolename);
        if (groupId != -1 && roleId != -1) {
            getIdentityAPI().addUserMembership(user.getId(), groupId, roleId);
        } else {
            //System.out.println("GroupName: " + groupname + " | RoleName: " + rolename);
            throw new Exception("Not found role or group");
        }
    }

    /**
     * Assign association between User and Group/Role
     *
     * @param username
     * @param groupname
     * @param rolename
     * @throws BonitaException
     * @throws Exception
     */
    private void assignUserToGroupRole(String username, String groupname, String rolename) throws BonitaException, Exception {
        User user = getUserByUserName(username);
        assignUserToGroupRole(user, groupname, rolename);
    }

    /**
     * Create Bpm User
     *
     * @param id
     * @param email
     * @param firstname
     * @param lastname
     * @param title
     * @param username
     * @param pwd
     * @param roleName
     * @param groupname
     * @param isAdmin
     * @param clientId
     * @throws BonitaException
     */
    public void createUser(String id, String email, String firstname, String lastname, String title, String username, String pwd, String roleName, String groupname, boolean isAdmin, String clientId) throws BonitaException {
        try {
            UserCreator creator = new UserCreator(username, pwd);
            ContactDataCreator proContactDataCreator = new ContactDataCreator();
            proContactDataCreator.setEmail(email);
            creator.setFirstName(firstname)
                    .setLastName(lastname)
                    .setJobTitle(title)
                    .setPersonalContactData(proContactDataCreator)
                    .setProfessionalContactData(proContactDataCreator);
            // Create User
            final User user2 = getIdentityAPI().createUser(creator);

            // Set custom Information 
            long userIdDefinitionId = getCustomUserInfoDefinitionId("userId");
            getIdentityAPI().setCustomUserInfoValue(userIdDefinitionId, user2.getId(), id);
            long clientIdDefinitionId = getCustomUserInfoDefinitionId("clientId");
            getIdentityAPI().setCustomUserInfoValue(clientIdDefinitionId, user2.getId(), clientId);

            // Set to Profile
            if (!isAdmin) {
                assignUserToProfile(user2, "User");
            } else if (isAdmin) {
                assignUserToProfile(user2, "Administrator");
            }

            // Set to Group and Role
            assignUserToGroupRole(user2, groupname, roleName);
        } catch (AlreadyExistsException ex) {
            //System.out.println("Error: User already Exists ! | Entity [ username: " + username + ", userId : " + id + " ]. We'll proceed to update Roles.");
            try {
                assignUserToGroupRole(username, groupname, roleName);
            } catch (AlreadyExistsException ex1) {
                //System.out.println("Error: Role asociation already Exists ! | Entity [ rolename: " + roleName + ", groupname: " + groupname + ", userid: " + id + " ].");
            } catch (Exception ex1) {
                Logger.getLogger(BonitaBpmSupport.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            Logger.getLogger(BonitaBpmSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Update User Information
     *
     * @param username
     * @param email
     * @param firstname
     * @param lastname
     * @param title
     * @param pwd
     * @throws BonitaException
     */
    public void updateUserInformation(String username, String email, String firstname, String lastname, String title, String pwd) throws BonitaException {
        UserUpdater updater = new UserUpdater();
        ContactDataUpdater ctDataUpdater = new ContactDataUpdater();
        updater.setFirstName(firstname);
        updater.setLastName(lastname);
        updater.setJobTitle(title);
        updater.setPassword(pwd);
        ctDataUpdater.setEmail(email);
        updater.setPersonalContactData(ctDataUpdater);
        updater.setProfessionalContactData(ctDataUpdater);
        User user = getUserByUserName(username);
        if (user != null) {
            getIdentityAPI().updateUser(user.getId(), updater);
        }
    }

    /**
     * Disable Bpm User
     *
     * @param username
     * @param status
     * @throws BonitaException
     */
    public void disableUser(String username, boolean status) throws BonitaException {
        UserUpdater updater = new UserUpdater();
        updater.setEnabled(!status);
        User user = getUserByUserName(username);
        if (user != null) {
            getIdentityAPI().updateUser(user.getId(), updater);
        }
    }

    /**
     * Update User Roles
     *
     * @param username
     * @param pwd
     * @throws BonitaException
     */
    public void updateUserRoles(String username, String pwd) throws BonitaException {
        UserUpdater updater = new UserUpdater();
        updater.setPassword(pwd);
        User user = getUserByUserName(username);
        if (user != null) {
            getIdentityAPI().updateUser(user.getId(), updater);
        }
    }

    /**
     * Get Custom User Info Definition Id
     *
     * @param customInfo
     * @return
     * @throws BonitaException
     */
    private long getCustomUserInfoDefinitionId(String customInfo) throws BonitaException {
        long total = getIdentityAPI().getNumberOfCustomInfoDefinitions();
        if (total > 0) {
            List<Long> ids = getIdentityAPI().getCustomUserInfoDefinitions(0, 2).stream().filter(c -> c.getName().equals(customInfo)).mapToLong(m -> m.getId())
                    .boxed()
                    .collect(Collectors.toList());
            if (ids.size() > 0) {
                return ids.get(0);
            }
        }
        return -1;
    }

    /**
     * Get Bonita User Custom Information by User Id
     *
     * @param userid
     * @param customInfo
     * @return
     * @throws BonitaException
     */
    public String getCustomInformationFromUserId(long userid, String customInfo) throws BonitaException {
        long definitionId = getCustomUserInfoDefinitionId(customInfo);
        if (definitionId > 0) {
            SearchOptionsBuilder optionsBuilder = new SearchOptionsBuilder(0, 10);
            optionsBuilder.filter(CustomUserInfoValueSearchDescriptor.USER_ID, userid);
            optionsBuilder.filter(CustomUserInfoValueSearchDescriptor.DEFINITION_ID, definitionId);
            SearchResult<CustomUserInfoValue> searchResult = getIdentityAPI().searchCustomUserInfoValues(optionsBuilder.done());
            if (searchResult.getResult().size() >= 1) {
                return searchResult.getResult().get(0).getValue();
            }
        }
        return "-1";
    }

    /**
     * Get Process Definition Id by Process Name
     *
     * @param name
     * @return
     * @throws BonitaException
     */
    public long getProcessDefinitionIdByName(String name) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 10);
        searchOptionsBuilder.filter(ProcessDeploymentInfoSearchDescriptor.NAME, name);
        searchOptionsBuilder.filter(ProcessDeploymentInfoSearchDescriptor.ACTIVATION_STATE, "ENABLED");
        SearchResult<ProcessDeploymentInfo> searchResult = getProcessAPI().searchProcessDeploymentInfos(searchOptionsBuilder.done());
        Comparator<ProcessDeploymentInfo> byVersion = (ProcessDeploymentInfo o1, ProcessDeploymentInfo o2) -> o1.getVersion().compareTo(o2.getVersion());
        List<ProcessDeploymentInfo> lOrder = searchResult.getResult().stream().sorted(byVersion.reversed()).collect(Collectors.toList());
        return lOrder.get(0).getProcessId();
    }

    /**
     * Start a Process Instance with a Contract Input
     *
     * @param processName
     * @param userId
     * @param instantiationInputs
     * @return
     * @throws ProcessDefinitionNotFoundException
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    public long startProcessWithContract(String processName, long userId, Map<String, Serializable> instantiationInputs) throws ProcessDefinitionNotFoundException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        long pid = getProcessDefinitionIdByName(processName);
        if (instantiationInputs != null) {
            return getProcessAPI().startProcessWithInputs(userId, pid, instantiationInputs).getId();
        }
        return -1L;
    }

    public long startProcessWithContract(String processName, String userName, Map<String, Serializable> instantiationInputs) throws ProcessDefinitionNotFoundException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        User userId = getUserByUserName(userName);
        if (userId == null) {
            return -1;
        }
        return startProcessWithContract(processName, userId.getId(), instantiationInputs);
    }

    /**
     * Start a Process By Name By the System User
     *
     * @param processName
     * @return
     * @throws ProcessDefinitionNotFoundException
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    public long startProcessByName(String processName) throws ProcessDefinitionNotFoundException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        long pid = getProcessDefinitionIdByName(processName);
        return getProcessAPI().startProcess(pid).getId();
    }

    /**
     * Start a Process By Name and User Id
     *
     * @param processName
     * @param userId
     * @return
     * @throws ProcessDefinitionNotFoundException
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    public long startProcessByNameAndUser(String processName, long userId) throws ProcessDefinitionNotFoundException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        long pid = getProcessDefinitionIdByName(processName);
        return getProcessAPI().startProcess(pid, userId).getId();
    }

    /**
     * Start a Process By Name and User Name
     *
     * @param processName
     * @param userName
     * @return
     * @throws ProcessDefinitionNotFoundException
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    public long startProcessByNameAndUser(String processName, String userName) throws ProcessDefinitionNotFoundException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        User userId = getUserByUserName(userName);
        if (userId == null) {
            return -1;
        }
        return startProcessByNameAndUser(processName, userId.getId());
    }

    /**
     * Cancel a Process Instance
     *
     * @param caseId
     * @throws BonitaException
     */
    public void cancelProcessInstance(long caseId) throws BonitaException {
        if (caseId > 0) {
            getProcessAPI().cancelProcessInstance(caseId);
        }
    }

    /**
     * Filter Human Task by Status. Filters: [id, state, caseId, name, priority]
     *
     * @param filter
     * @param count
     * @return
     * @throws BonitaException
     */
    public List<HumanTaskInstance> filterHumanTaskDefinition(Map<String, Object> filter, int count) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, count);
        if (filter == null) {
            return null;
        }
        filter.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals("id")) {
                searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.ASSIGNEE_ID, value.toString());
            }
            if (key.equals("state")) {
                searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.STATE_NAME, value.toString());
            }
            if (key.equals("caseId")) {
                searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.PARENT_CONTAINER_ID, value.toString());
            }
            if (key.equals("name")) {
                searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.NAME, value.toString());
            }
            if (key.equals("priority")) {
                searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.PRIORITY, value.toString());
            }
        });
        SearchResult<HumanTaskInstance> searchResult = getProcessAPI().searchAssignedAndPendingHumanTasks(searchOptionsBuilder.done());
        return searchResult.getResult();
    }

    /**
     * Is HumanTask Already Assigned
     *
     * @param caseId
     * @param taskid
     * @return
     * @throws BonitaException
     */
    public boolean isHumanTaskAlreadyAssigned(long caseId, long taskid) throws BonitaException {
        return isHumanTaskAlreadyAssigned("ready", caseId, taskid);
    }

    /**
     * Is HumanTask Already Assigned
     *
     * @param status
     * @param caseId
     * @param taskid
     * @return
     * @throws BonitaException
     */
    public boolean isHumanTaskAlreadyAssigned(String status, long caseId, long taskid) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 5);
        searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.STATE_NAME, status)
                .filter(HumanTaskInstanceSearchDescriptor.PARENT_CONTAINER_ID, caseId);
        SearchResult<HumanTaskInstance> searchResult = getProcessAPI().searchAssignedAndPendingHumanTasks(searchOptionsBuilder.done());
        if (searchResult.getResult().isEmpty()) {
            return false;
        }
        return searchResult.getResult().stream().filter(p -> p.getId() == taskid).anyMatch(object -> (object.getAssigneeId() != 0));
    }

    /**
     * @deprecated Is HumanTask Already Assigned
     *
     * @param status
     * @param caseId
     * @return
     * @throws BonitaException
     */
    public boolean isHumanTaskAlreadyAssigned(String status, long caseId) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 5);
        searchOptionsBuilder.filter(HumanTaskInstanceSearchDescriptor.STATE_NAME, status)
                .filter(HumanTaskInstanceSearchDescriptor.PARENT_CONTAINER_ID, caseId);
        SearchResult<HumanTaskInstance> searchResult = getProcessAPI().searchAssignedAndPendingHumanTasks(searchOptionsBuilder.done());
        if (searchResult.getResult().size() != 1) {
            return false;
        }
        for (HumanTaskInstance object : searchResult.getResult()) {
            if (object.getAssigneeId() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve All Archived Activity Instance by Case Id
     *
     * @param caseId
     * @return
     * @throws BonitaException
     */
    public List<ArchivedActivityInstance> getArchivedTaskList(long caseId) throws BonitaException {
        SearchOptionsBuilder searchBuilder = new SearchOptionsBuilder(0, 250);
        searchBuilder.filter(ArchivedActivityInstanceSearchDescriptor.PARENT_PROCESS_INSTANCE_ID, caseId);
        SearchResult<ArchivedActivityInstance> archActivitResult = getProcessAPI().searchArchivedActivities(searchBuilder.done());
        return archActivitResult.getResult();
    }

    /**
     * Retrieve All Archived Process Instance By Case Id
     *
     * @param caseId
     * @return
     * @throws BonitaException
     */
    public ArchivedProcessInstance getArchivedProcessDefinition(long caseId) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 20);
        searchOptionsBuilder.filter(ArchivedProcessInstancesSearchDescriptor.SOURCE_OBJECT_ID, caseId);
        SearchResult<ArchivedProcessInstance> searchResult = getProcessAPI().searchArchivedProcessInstances(searchOptionsBuilder.done());
        if (searchResult.getResult().size() > 0) {
            return searchResult.getResult().get(0);
        }
        return null;
    }

    /**
     * Retrieve Process Instance Definition by CaseID
     *
     * @param caseId
     * @return
     * @throws BonitaException
     */
    public ProcessInstance getProcessInstanceDefinition(long caseId) throws BonitaException {
        SearchOptionsBuilder searchOptionsBuilder = new SearchOptionsBuilder(0, 20);
        searchOptionsBuilder.filter(ProcessInstanceSearchDescriptor.ID, caseId);
        SearchResult<ProcessInstance> searchResult = getProcessAPI().searchProcessInstances(searchOptionsBuilder.done());
        if (searchResult.getResult().isEmpty()) {
            return null;
        }
        return searchResult.getResult().get(0);
    }
    
    /**
     * Retrieve Process Definition by DefinitionId
     * @param definitionId
     * @return
     * @throws BonitaException 
     */
    public ProcessDefinition getProcessDefinition(long definitionId) throws BonitaException {
        return getProcessAPI().getProcessDefinition(definitionId);
    }

    /**
     * Get Request Timeline
     *
     * @param caseId
     * @return
     * @throws BonitaException
     */
    public BpmTimelineRequest getRequestTimeLine(long caseId) throws BonitaException {
        List<BpmTimelineTask> tasks = new ArrayList<>();
        ProcessInstance pInstance = getProcessInstanceDefinition(caseId);
        BpmTimelineRequest response = new BpmTimelineRequest();

        if (pInstance != null) {
            User procPData = getUserById(pInstance.getStartedBy());
            response.setProcRequestedBy((procPData.getFirstName() + " " + procPData.getLastName()));
            response.setProcRequestedDate(DateSupport.formatDate(pInstance.getStartDate(), DateSupport.FORMAT_MMDDYY_HHMMSSA));
            response.setProcRequestorJobTitle(procPData.getJobTitle());
        } else {
            ArchivedProcessInstance pAInstance = getArchivedProcessDefinition(caseId);
            if (pAInstance == null) {
                return response;
            }
            User procPData = getUserById(pAInstance.getStartedBy());
            response.setProcRequestedBy((procPData.getFirstName() + " " + procPData.getLastName()));
            response.setProcRequestedDate(DateSupport.formatDate(pAInstance.getStartDate(), DateSupport.FORMAT_MMDDYY_HHMMSSA));
            response.setProcRequestorJobTitle(procPData.getJobTitle());
        }

        SearchOptionsBuilder searchBuilder = new SearchOptionsBuilder(0, 200);
        searchBuilder.filter(ArchivedActivityInstanceSearchDescriptor.PARENT_PROCESS_INSTANCE_ID, caseId);
        // Remove here for get all task
        searchBuilder.filter(ArchivedActivityInstanceSearchDescriptor.ACTIVITY_TYPE, FlowNodeType.USER_TASK);
        searchBuilder.sort(ArchivedActivityInstanceSearchDescriptor.REACHED_STATE_DATE, Order.DESC);
        SearchResult<ArchivedActivityInstance> archActivitResult = TenantAPIAccessor.getProcessAPI(session).searchArchivedActivities(searchBuilder.done());
        if (archActivitResult.getResult().isEmpty()) {
            return response;
        }
        boolean reverse = false;
        for (ArchivedActivityInstance task : archActivitResult.getResult()) {
            if (task.getType() == FlowNodeType.USER_TASK) {
                User personalData = getUserById(task.getExecutedBy());
                if (personalData != null) {
                    tasks.add(new BpmTimelineTask(reverse, task.getDisplayName(), DateSupport.formatDate(task.getReachedStateDate(), DateSupport.FORMAT_MMDDYY_HHMMSSA), (personalData.getFirstName() + " " + personalData.getLastName()), personalData.getJobTitle(), task.getState()));
                } else {
                    tasks.add(new BpmTimelineTask(reverse, task.getDisplayName(), DateSupport.formatDate(task.getReachedStateDate(), DateSupport.FORMAT_MMDDYY_HHMMSSA), "", "", task.getState()));
                }
                reverse = !reverse;
            }
        }
        response.setTasks(tasks);
        return response;
    }

    /**
     * Assign Task to User
     *
     * @param taskId
     * @param userId
     * @throws BonitaException
     */
    public void assignUserTask(long taskId, long userId) throws BonitaException {
        getProcessAPI().assignUserTask(taskId, userId);
    }

    /**
     * Assign the Task and execute Flow Node by User
     *
     * @param taskId
     * @param userId
     * @throws BonitaException
     */
    public void executeTask(long taskId, long userId) throws BonitaException {
        assignUserTask(taskId, userId);
        getProcessAPI().executeFlowNode(userId, taskId);
    }

    /**
     * Assign and Execute the Task With Contract Input
     *
     * @param taskId
     * @param userId
     * @param contract
     * @throws BonitaException
     */
    public void assignAndExecuteTaskWithContract(long taskId, long userId, Map<String, Serializable> contract) throws BonitaException {
        getProcessAPI().assignAndExecuteUserTask(userId, taskId, contract);
    }

    /**
     * List all process instances.
     *
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<ProcessInstance> searchProcessInstances(SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchProcessInstances(searchOptions.done());
    }

    /**
     * Get the list of pending human task instances available to the specified
     * user. A human task is pending for a given user if it is not yet assigned
     * and if the user is a candidate either through an ActorMember or through a
     * UserFilter.
     *
     * @param userId
     * @param startIndex
     * @param maxResults
     * @param aic
     * @return
     * @throws BonitaException
     */
    public List<HumanTaskInstance> getPendingHumanTaskInstances(long userId, int startIndex, int maxResults, ActivityInstanceCriterion aic) throws BonitaException {
        return getProcessAPI().getPendingHumanTaskInstances(userId, startIndex, maxResults, aic);
    }

    /**
     *
     * @param userId
     * @param startIndex
     * @param maxResults
     * @param aic
     * @return
     * @throws BonitaException
     */
    public List<HumanTaskInstance> getAssignedHumanTaskInstances(long userId, int startIndex, int maxResults, ActivityInstanceCriterion aic) throws BonitaException {
        return getProcessAPI().getAssignedHumanTaskInstances(userId, startIndex, maxResults, aic);
    }

    /**
     * Search for all tasks available to a specified user. A task is available
     * to a user if is assigned to the user or it is pending for that user.
     * (ToDo)
     *
     * @param userId
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<HumanTaskInstance> searchMyAvailableHumanTasks(long userId, SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchMyAvailableHumanTasks(userId, searchOptions.done());
    }

    /**
     * Search Assigned Tasks Managed By User Id
     *
     * @param userId
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<HumanTaskInstance> searchAssignedTasksManagedBy(long userId, SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchAssignedTasksManagedBy(userId, searchOptions.done());
    }

    /**
     * Search Activities
     *
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<ActivityInstance> searchActivities(SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchActivities(searchOptions.done());
    }

    /**
     * Search the archived human tasks for tasks that match the search options.
     *
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<ArchivedHumanTaskInstance> searchArchivedHumanTasks(SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchArchivedHumanTasks(searchOptions.done());
    }
    
    public SearchResult<HumanTaskInstance> searchHumanTasks(SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchHumanTaskInstances(searchOptions.done());
    }

    /**
     * Search the assigned and pending human tasks for any user corresponding to
     * the options.
     *
     * @param searchOptions
     * @return
     * @throws BonitaException
     */
    public SearchResult<HumanTaskInstance> searchAssignedAndPendingHumanTasks(SearchOptionsBuilder searchOptions) throws BonitaException {
        return getProcessAPI().searchAssignedAndPendingHumanTasks(searchOptions.done());
    }
}
