/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test.bpm;

import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.bpm.BpmConfiguration;
import com.atser.tools.atserutil.collection.list.ListSupport;
import com.atser.tools.atserutil.objects.to.bpm.BpmTimelineRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceCriterion;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstanceSearchDescriptor;
import org.bonitasoft.engine.bpm.flownode.ArchivedHumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.ArchivedHumanTaskInstanceSearchDescriptor;
import org.bonitasoft.engine.bpm.flownode.FlowNodeType;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstanceSearchDescriptor;
import org.bonitasoft.engine.bpm.process.ProcessDefinition;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.search.Order;
import org.bonitasoft.engine.search.SearchOptionsBuilder;
import org.bonitasoft.engine.search.SearchResult;

/**
 *
 * @author droldan
 */
public class BpmTest {

    private static BpmConfiguration config;
    private static BonitaBpmSupport bonita;

    /**
     * Print Timeline
     *
     * @param caseId
     * @throws BonitaException
     */
    public static void printCaseTimeline(Long caseId) throws BonitaException {
        BpmTimelineRequest timeline = bonita.getRequestTimeLine(caseId);
        System.out.println("Requested By: " + timeline.getProcRequestedBy());
        System.out.println("Requested Date: " + timeline.getProcRequestedDate());
        System.out.println("Requested Job Title: " + timeline.getProcRequestorJobTitle());
        ListSupport.printList(timeline.getTasks());
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    /**
     * Search All Process Instances
     *
     * @param sob
     * @throws BonitaException
     */
    public static void searchProcessInstances(SearchOptionsBuilder sob) throws BonitaException {
        SearchResult<ProcessInstance> searchResult = bonita.searchProcessInstances(sob);
        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("CaseId: " + p.getId());
            System.out.println("Started By UserId : " + p.getStartedBy());
            System.out.println("Pool Process Name: " + p.getName());
            System.out.println("Process Description: " + p.getDescription());
            System.out.println("Started Date: " + p.getStartDate());
            System.out.println("End Date: " + p.getEndDate());
            System.out.println("State: " + p.getState());
            System.out.println("Caller ID: " + p.getCallerId());
            System.out.println("None: " + p.getStringIndex1());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchActivityInstance(SearchOptionsBuilder sob) throws BonitaException {
        SearchResult<ActivityInstance> searchResult = bonita.searchActivities(sob);
        System.out.println(searchResult.getCount());

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    // Review
    public static void getPendingHumanTaskInstances(Long uId) throws BonitaException {
        List<HumanTaskInstance> searchResult = bonita.getPendingHumanTaskInstances(uId, 0, Integer.MAX_VALUE, ActivityInstanceCriterion.NAME_ASC);

        searchResult.forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            try {
                System.out.println("Process Name: " + bonita.getProcessInstanceDefinition(p.getRootContainerId()).getName());
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchMyAvailableHumanTasks(Long uId, SearchOptionsBuilder sob) throws BonitaException {
        SearchResult<HumanTaskInstance> searchResult = bonita.searchMyAvailableHumanTasks(uId, sob);

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Assigned Id: " + p.getAssigneeId());
            try {
                System.out.println("Process Name: " + bonita.getProcessInstanceDefinition(p.getRootContainerId()).getName());
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchAssignedAndPendingHumanTasks(SearchOptionsBuilder sob) throws BonitaException {
        SearchResult<HumanTaskInstance> searchResult = bonita.searchAssignedAndPendingHumanTasks(sob);
        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            try {
                System.out.println("Process Name: " + bonita.getProcessInstanceDefinition(p.getRootContainerId()).getName());
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void getAssignedHumanTaskInstances(Long uId) throws BonitaException {
        List<HumanTaskInstance> searchResult = bonita.getAssignedHumanTaskInstances(uId, 0, Integer.MAX_VALUE, ActivityInstanceCriterion.NAME_ASC);

        searchResult.forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Assigned To: " + p.getAssigneeId());
            /*try {
                System.out.println("Process Name: " + bonita.getProcessInstanceDefinition(p.getRootContainerId()).getName());
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }*/
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchAssignedTasksManagedBy(Long uId, SearchOptionsBuilder sob) throws BonitaException {
        SearchResult<HumanTaskInstance> searchResult = bonita.searchAssignedTasksManagedBy(0L, sob);

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Assigned To: " + p.getAssigneeId());
            try {
                System.out.println("Process Name: " + bonita.getProcessInstanceDefinition(p.getRootContainerId()).getName());
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchArchivedHumanTasksManagedBy(Long uId, SearchOptionsBuilder sob) throws BonitaException {
        sob.filter(ArchivedHumanTaskInstanceSearchDescriptor.ASSIGNEE_ID, uId);
        sob.filter(ArchivedHumanTaskInstanceSearchDescriptor.STATE_NAME, "completed");
        SearchResult<ArchivedHumanTaskInstance> searchResult = bonita.getProcessAPI().searchArchivedHumanTasks(sob.done());

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Assigned To: " + p.getAssigneeId());
            try {
                ProcessInstance pi = bonita.getProcessInstanceDefinition(p.getProcessDefinitionId());
                if (pi != null) {
                    System.out.println("Process Name: " + pi.getName());
                }
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchArchivedHumanTasks() throws BonitaException {
        SearchOptionsBuilder sob = new SearchOptionsBuilder(0, 50);
        //sob.filter(ArchivedHumanTaskInstanceSearchDescriptor.STATE_NAME, "completed");
        //sob.filter(ArchivedHumanTaskInstanceSearchDescriptor.DISPLAY_NAME, "Review RFI # 0048 from Requestor");
        sob.searchTerm("# 0048");
        SearchResult<ArchivedHumanTaskInstance> searchResult = bonita.getProcessAPI().searchArchivedHumanTasks(sob.done());

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Executed By: " + p.getExecutedBy());
            System.out.println("Assigned To: " + p.getAssigneeId());
            System.out.println("Process Definition Id: " + p.getProcessDefinitionId());
            try {
                ProcessDefinition pi = bonita.getProcessAPI().getProcessDefinition(p.getProcessDefinitionId());
                System.out.println("Process Definition: " + pi);
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            try {
                User executedBy = bonita.getUserById(p.getExecutedBy());
                System.out.println("Executed By: " + executedBy);
            } catch (BonitaException ex) {
                System.out.println("User Not Found");
            }
            System.out.println("Name: " + p.getName());
            System.out.println("Reached State Date: " + p.getReachedStateDate().getTime());
            System.out.println("State: " + p.getState());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void searchHumanTaskInstances() throws BonitaException {
        SearchOptionsBuilder sob = new SearchOptionsBuilder(0, 50);
        sob.filter(HumanTaskInstanceSearchDescriptor.PROCESS_DEFINITION_ID, "7570944293731849777");
        SearchResult<HumanTaskInstance> searchResult = bonita.getProcessAPI().searchHumanTaskInstances(sob.done());

        searchResult.getResult().forEach(p -> {
            System.out.println("-----------------------------------");
            System.out.println("Task Id: " + p.getId());
            System.out.println("Case Id: " + p.getRootContainerId());
            System.out.println("Name: " + p.getName());
            System.out.println("Display Name: " + p.getDisplayName());
            System.out.println("Assigned Id: " + p.getAssigneeId());
            System.out.println("Assigned Date: " + p.getClaimedDate());
            System.out.println("Last Update Date: " + p.getLastUpdateDate());
            System.out.println("Process Definition Id: " + p.getProcessDefinitionId());
            try {
                ProcessDefinition pi = bonita.getProcessAPI().getProcessDefinition(p.getProcessDefinitionId());
                System.out.println("Process Definition: " + pi);
            } catch (BonitaException ex) {
                System.out.println("Process Name: Unknow");
            }
            try {
                User executedBy = bonita.getUserById(p.getExecutedBy());
                System.out.println("Executed By: " + executedBy);
            } catch (BonitaException ex) {
                System.out.println("User Not Found");
            }
            System.out.println("Reached State Date: " + p.getReachedStateDate());
            System.out.println("State: " + p.getState());
            System.out.println("Priotity: " + p.getPriority());
        });
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static Long filterUserByTask(String taskname, Long processInstanceId) throws BonitaException {
        SearchOptionsBuilder sob = new SearchOptionsBuilder(0, 1)
                .filter(ArchivedHumanTaskInstanceSearchDescriptor.PARENT_PROCESS_INSTANCE_ID, processInstanceId)
                .filter(ArchivedHumanTaskInstanceSearchDescriptor.NAME, taskname)
                .filter(ArchivedHumanTaskInstanceSearchDescriptor.TERMINAL, true);
        SearchResult<ArchivedHumanTaskInstance> searchResult = bonita.getProcessAPI().searchArchivedHumanTasks(sob.done());

        searchResult.getResult().stream().forEach(it -> {
            System.out.println(it);
        });

        if (searchResult.getResult() != null && !searchResult.getResult().isEmpty()) {
            return searchResult.getResult().get(0).getExecutedBy();
        }

        return 0L;
    }

    public static void searchArchivedActivities() throws BonitaException {
        SearchOptionsBuilder searchBuilder = new SearchOptionsBuilder(0, 50);
        //searchBuilder.filter(ArchivedActivityInstanceSearchDescriptor.PARENT_PROCESS_INSTANCE_ID, caseId);
        searchBuilder.filter(ArchivedActivityInstanceSearchDescriptor.ACTIVITY_TYPE, FlowNodeType.USER_TASK);
        searchBuilder.sort(ArchivedActivityInstanceSearchDescriptor.REACHED_STATE_DATE, Order.DESC);
        SearchResult<ArchivedActivityInstance> archActivitResult = bonita.getProcessAPI().searchArchivedActivities(searchBuilder.done());
        if (archActivitResult.getResult().isEmpty()) {
            System.out.println("Empty");
        }
        archActivitResult.getResult().stream().forEach(it -> {
            System.out.println(it);
        });
    }

    public static void startProcessWithContract(String processName, Long userId) throws BonitaException {
        // Task 1
        Map<String, Serializable> c1 = new HashMap<>();
        /*HashMap<String, Long> values = new HashMap<>();
        values.put("entityId", Long.valueOf("1"));
        c1.put("entityInstanceBOInput", values);*/
        c1.put("entityId", Long.valueOf("2"));
        bonita.startProcessWithContract(processName, userId, c1);
        System.out.println("------------------CALL FINISHED-------------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        config = new BpmConfiguration(Boolean.TRUE, "http://127.0.0.1:5910", "bonita", "atseradmin", "Atser2018?.");
        //config = new BpmConfiguration(Boolean.TRUE, "http://127.0.0.1:5911", "bonita", "install", "install");

        try {
            bonita = new BonitaBpmSupport(config);
            if (bonita.isSessionActive()) {
                //System.out.println(bonita.getUserByUserName("admin"));
                //System.out.println(bonita.getUserByUserName("mandy"));
                Long mandyUserId = 1L;//301L;
                Long adminUserId = 502L;//302L;                 
                //-----------------DO NOT DELETE--------------------------------
                // Todo
                //searchMyAvailableHumanTasks(mandyUserId, new SearchOptionsBuilder(0, Integer.MAX_VALUE));
                //getPendingHumanTaskInstances(mandyUserId);
                // My Tasks
                //searchMyAvailableHumanTasks(mandyUserId, new SearchOptionsBuilder(0, Integer.MAX_VALUE).filter(HumanTaskInstanceSearchDescriptor.ASSIGNEE_ID, mandyUserId));
                //getAssignedHumanTaskInstances(mandyUserId);
                // Done Tasks
                //searchArchivedHumanTasksManagedBy(adminUserId, new SearchOptionsBuilder(0, Integer.MAX_VALUE));
                //--------------------------------------------------------------
                //printCaseTimeline(18L);
                //--------------------------------------------------------------
                Long taskId = 160051L;
                // Scene 1
                //startProcessWithContract("RFI Process", adminUserId);
                //bonita.executeTask(taskId, adminUserId);
                //Thread.sleep(4000L);
                //searchMyAvailableHumanTasks(adminUserId, new SearchOptionsBuilder(0, Integer.MAX_VALUE));

                //searchArchivedHumanTasks();
                searchHumanTaskInstances();
                //System.out.println(bonita.getProcessAPI().getProcessDefinition(5623159465706571078l));

                // Logout
                bonita.doTenantLogout();
            }
        } catch (BonitaException | java.net.ConnectException ex) {
            Logger.getLogger(BpmTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
