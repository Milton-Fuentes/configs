/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.BpmTaskInstance;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.bpm.BpmTaskInstanceDao;
import com.atser.tools.atserejb.model.BpmModelField;
import com.atser.tools.atserejb.model.BpmProcess;
import com.atser.tools.atserejb.model.BpmProcessInstance;
import com.atser.tools.atserejb.model.BpmTask;
import com.atser.tools.atserejb.model.BpmTaskMatrix;
import com.atser.tools.atserejb.model.Bpmcorrespondencebo;
import com.atser.tools.atserejb.model.Bpmcorrespondenceremark;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.VwBpmTaskInstanceBo;
import com.atser.tools.atserejb.service.glob.GlobClientRolesService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProfilesService;
import com.atser.tools.atserejb.service.glob.GlobStakeholderGroupService;
import com.atser.tools.atserejb.service.glob.GlobStakeholderService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.helper.SystemNotificationHelperService;
import com.atser.tools.atserejb.service.view.VwBpmTaskInstanceBoService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.ws.rs.core.Response;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author dperez
 */
@Stateless
public class BpmTaskInstanceServiceImpl implements BpmTaskInstanceService, IBaseEJBException {

    @Inject
    private BpmTaskInstanceDao dao;

    @Inject
    private BpmTaskService taskService;

    @Inject
    private BpmTaskMatrixService taskMatrixService;

    @Inject
    private GlobUserService userService;

    @Inject
    private BpmRFIService rfiService;

    @Inject
    private BpmSubmittalService submittalService;

    @Inject
    private BpmCorrespondenceService correspondenceService;

    @Inject
    private BpmCorrespondenceRemarkService correspondenceRemarkService;

    @Inject
    private GlobProfilesService profileService;

    @Inject
    private VwBpmTaskInstanceBoService taskInstanceBoServiceImpl;

    @Inject
    private SystemNotificationHelperService systemNotificationHelperService;

    @Inject
    private BpmProcessInstanceService processInstanceService;

    @Inject
    private GlobClientRolesService clientRolesService;

    @Inject
    private GlobStakeholderService stakeholderService;

    @Inject
    private GlobNotificationTrackService globNotificationTrackService;

    @Inject
    private GlobStakeholderGroupService stakeholderGroupService;

    @Inject
    private BpmModelFieldService modelFieldService;

    @Override
    public BpmTaskInstance findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public BpmTaskInstance findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(BpmTaskInstance elem) {
        return save(null, elem);
    }

    @Override
    public BigDecimal save(ManageITHeader header, BpmTaskInstance elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(BpmTaskInstance elem) {
        update(null, elem);
    }

    @Override
    public void update(ManageITHeader header, BpmTaskInstance elem) {
        if (elem != null) {
            BpmTaskInstance model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
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
    public List<BpmTaskInstance> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<BpmTaskInstance> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<BpmTaskInstance> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BpmTaskInstance populate(BpmTaskInstance model, BpmTaskInstance elem) {
        // model.setFirstName(elem.getFirstName());
        // model.setLastName(elem.getLastName());
        // model.setEmail(elem.getEmail());
        // model.setContactNo(elem.getContactNo());
        // model.setLastMod(elem.getLastMod());
        // model.setLastModBy(elem.getLastModBy());
        // model.setLastModByIp(elem.getLastModByIp());
        return model;
    }

    // -------------------------------------------------------------------------
    @Override
    public void takeTask(List<BigDecimal> taksIds, BigDecimal userId) {
        dao.takeTask(taksIds, userId);
    }

    @Override
    public void releaseTask(List<BigDecimal> taksIds) {
        dao.releaseTask(taksIds);
    }

    @Override
    public void updateTaskState(ManageITHeader header, TemplateEngine engine, String state, BigDecimal id) {
        // Update status.
        dao.updateTaskState(state, id);

        // If status is 'Completed' then create the next instnace.
        if (state.equals("COMPLETED")) {

            // Get current instance.
            BpmTaskInstance currentTaskInst = findById(id);

            //--[ Multi-User Task ]---------------------------------------------
            if (currentTaskInst.getParentId() != null) {
                if (isAllChildTaskCompleted(currentTaskInst.getParentId())) {
                    // Complete Parent Task.
                    updateTaskState(header, engine, "COMPLETED", currentTaskInst.getParentId());
                }
                return;
            }
            //--[ Multi-User Task End]------------------------------------------

            // List all next task by origen-task-id.
            ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
            search.filter("orgTaskId", currentTaskInst.getTaskId().getId());
            List<BpmTaskMatrix> taskMatixList = taskMatrixService.list(search);

            // Validate if there is a next task?
            if (!taskMatixList.isEmpty()) {

                // Get BPM object.
                Object bpmModel = getBpmModelById(currentTaskInst.getRefId(), currentTaskInst.getProcessInstanceId().getProcessId());
                // Object bpmModel = rfiService.findById(currentTaskInst.getRefId().toString());

                // Only one taks (Traight path -> no condition to validate).
                if (taskMatixList.size() == 1) {

                    // Create task instance.
                    generateTaskInstance(header, engine, taskMatixList.get(0).getTrgTaskId(), null, currentTaskInst.getProcessInstanceId(), bpmModel);
                } else {

                    // Convert BPM object to JSON.
                    ObjectMapper mapper = new ObjectMapper();
                    String jBpmModel = null;
                    try {
                        jBpmModel = mapper.writeValueAsString(bpmModel);
                    } catch (JsonProcessingException ex) {
                        Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Evaluate Condition.
                    Boolean conditionResult = false;
                    ScriptEngineManager factory = new ScriptEngineManager();
                    boolean conditionApplied = false;
                    for (BpmTaskMatrix item : taskMatixList) {
                        if (item.getCondition() != null) {
                            try {
                                ScriptEngine jsEngine = factory.getEngineByName("JavaScript");
                                jsEngine.eval("var entity = " + jBpmModel);
                                conditionResult = (Boolean) jsEngine.eval(item.getCondition());
                                if (conditionResult) {
                                    // Create task instance.
                                    generateTaskInstance(header, engine, item.getTrgTaskId(), null, currentTaskInst.getProcessInstanceId(), bpmModel);
                                    conditionApplied = true;
                                }
                            } catch (ScriptException ex) {
                                Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if (!conditionApplied) {
                        closeProcess(currentTaskInst);
                    }
                }
            } else {
                closeProcess(currentTaskInst);
            }
            // Execute system tasks.
            // executeSystemTasks(header, engine);
        }
    }

    public void closeProcess(BpmTaskInstance currentTaskInst) {
        // Close Process.
        processInstanceService.closeProcessInstance(currentTaskInst.getProcessInstanceId().getId());
        BpmProcessInstance processInstance = processInstanceService.findById(currentTaskInst.getProcessInstanceId().getId());
        // Update BPM Model status.
        if ("BPM_RFI".equals(processInstance.getProcessId().getCode())) {
            rfiService.close(currentTaskInst.getRefId());
        } else if ("BPM_SUBMITTAL".equals(processInstance.getProcessId().getCode())) {
            submittalService.close(currentTaskInst.getRefId());
        } else if ("BPM_CORRESPONDENCE".equals(processInstance.getProcessId().getCode())) {
            correspondenceService.close(currentTaskInst.getRefId());
        }
    }

    @Override
    public void generateTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, List<Integer> users, BpmProcessInstance processInstance, Object bpmModel) {

        // Find target task.
        BpmTask trgTask = taskService.findById(trgTaskId);

        // Is not a multi-user-task.
        if (trgTask.getIsMultiUserTask() == 0) {
            // Direct user assignation
            if (users == null || users.isEmpty()) {
                // Create single task for roles.
                createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, null, "SINGLE");
            } else {
                // Create single task for specific user.
                createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, userService.findById(BigDecimal.valueOf(users.get(0))), "SINGLE");
            }
        } else {
            // Direct user assignation
            if (users != null && !users.isEmpty()) {
                if (users.size() == 1) {
                    // Create single task for specific user.
                    createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, userService.findById(BigDecimal.valueOf(users.get(0))), "SINGLE");
                } else {
                    // Create multi-user-task for spacific users.
                    BpmTaskInstance parentInstance = createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, null, "PARENT");
                    for (Integer id : users) {
                        createTaskInstance(header, engine, trgTask, parentInstance, processInstance, bpmModel, userService.findById(BigDecimal.valueOf(id)), "SINGLE");
                    }
                }
            } else { // Create task with BMP user engine.
                // Get bpm model in json format.
                ObjectMapper mapper = new ObjectMapper();
                String obj = null;
                try {
                    obj = mapper.writeValueAsString(bpmModel);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Find users for task.
                String userIds = "";
                try {
                    ScriptEngineManager factory = new ScriptEngineManager();
                    ScriptEngine jsEngine = factory.getEngineByName("JavaScript");
                    jsEngine.eval("var bpmModel = " + obj);
                    userIds = (String) jsEngine.eval(trgTask.getMultiUserTaskSrc() + ";");
                } catch (ScriptException ex) {
                    Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Validate how many users.
                if (!userIds.isEmpty()) {
                    String[] ids = userIds.split(",");
                    if (ids.length == 1) {
                        // Create single task.
                        createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, userService.findById(new BigDecimal(ids[0])), "SINGLE");
                    } else {
                        // Create multi-user-task
                        BpmTaskInstance parentInstance = createTaskInstance(header, engine, trgTask, null, processInstance, bpmModel, null, "PARENT");
                        for (String id : ids) {
                            createTaskInstance(header, engine, trgTask, parentInstance, processInstance, bpmModel, userService.findById(new BigDecimal(id)), "SINGLE");
                        }
                    }
                }
            }
        }
    }

    @Override
    public BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, BigDecimal processInstanceId, BigDecimal bpmModelId) {
        return createTaskInstance(header, engine, trgTaskId, null, processInstanceId, bpmModelId, null);
    }

    @Override
    public BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, BigDecimal taskInstanceParentId, BigDecimal processInstanceId, BigDecimal bpmModelId, BigDecimal assignedId) {

        BpmTask trgTask = taskService.findById(trgTaskId);
        BpmProcessInstance processInstance = processInstanceService.findById(processInstanceId);

        BpmTaskInstance taskInstanceParent = null;
        if (taskInstanceParentId != null) {
            taskInstanceParent = findById(taskInstanceParentId);
        }

        GlobUsers assigned = null;
        if (assignedId != null) {
            assigned = userService.findById(assignedId);
        }

        Object bpmModel = getBpmModelById(bpmModelId, processInstance.getProcessId());
        // Bpmrfibo model = rfiService.findById(bpmModelId.toString());

        return createTaskInstance(header, engine, trgTask, taskInstanceParent, processInstance, bpmModel, assigned, "SINGLE");
    }

    @Override
    public BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BpmTask trgTask, BpmTaskInstance trgTaskParent, BpmProcessInstance processInstance, Object bpmModel, GlobUsers assigned, String type) {
        // Create instance object.
        BpmTaskInstance taskInstance = new BpmTaskInstance();
        taskInstance.setTaskId(trgTask);
        taskInstance.setProcessInstanceId(processInstance);
        taskInstance.setRefId(new BigDecimal(getObjectFieldValue("persistenceid", bpmModel)));
        //taskInstance.setRefId(bpmModel.getPersistenceid());
        taskInstance.setState("READY");
        taskInstance.setType(type);
        if (assigned != null) {
            taskInstance.setUserId(assigned);
        } else if (!"USER".equals(trgTask.getType())) {
            taskInstance.setUserId(userService.findById(header.getUserid()));
        }

        if (trgTaskParent != null) {
            taskInstance.setParentId(trgTaskParent.getId());
        }

        // Persist instance object.
        save(header, taskInstance);

        // Send notifications.
        if (trgTask.getTaskNotificationNew() == 1 && !"PARENT".equals(type)) {
            sendNotification(header, engine, taskInstance, bpmModel, "Pending Task Notification", null);
        }

        // Check automatic task.
        if ("SEND".equals(taskInstance.getTaskId().getType()) || "CLOSE".equals(taskInstance.getTaskId().getType())) {
            updateTaskState(header, engine, "COMPLETED", taskInstance.getId());
        }

        // Return created instance object.
        return taskInstance;
    }

    @Override
    public Boolean isAllChildTaskCompleted(BigDecimal parentId) {
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("parentId", parentId);
        List<BpmTaskInstance> list = list(search);
        return list.stream().noneMatch(item -> (!item.getState().equals("COMPLETED")));
    }

    @Override
    public void sendNotification(ManageITHeader header, TemplateEngine engine, BpmTaskInstance taskInstance, Object bpmModel, String subject, String messageText) {
        // Ger emails to notify.
        List<String> emails = new ArrayList<>();
        if (taskInstance.getUserId() != null) {
            // Emails by user.
            emails.add(userService.getUserEmail(taskInstance.getUserId().getId()));
        } else {
            // Emails by role.
            emails.addAll(profileService.getEmailListByRole(taskInstance.getTaskId().getActorId().getRoleName(), new BigInteger(header.getClientid())));
        }

        // Add other email notifications
        if (taskInstance.getTaskId().getTaskNotificationOther() != null && taskInstance.getTaskId().getTaskNotificationOther() == 1) {
            emails.addAll(loadStakeholdersToNotify(bpmModel));
        }

        if (!emails.isEmpty()) {
            // Get data.
            VwBpmTaskInstanceBo taskInstanceBo = taskInstanceBoServiceImpl.findById(taskInstance.getId());

            // Populate message data.
            LinkedHashMap senderInfo = new AtserLinkedHashMap();
            senderInfo.put("roleName", clientRolesService.getRoleName(taskInstanceBo.getTaskId().getActorId().getId(), header.getModule(), new BigDecimal(header.getClientid())));
            senderInfo.put("taskName", taskInstanceBo.getTaskId().getName());
            // senderInfo.put("processName", bpmModel.getRfiname());
            senderInfo.put("processModelNumber", taskInstanceBo.getModelNumber());
            // senderInfo.put("responseDueDate", DateSupport.getNowToFormat("MM/dd/yyyy HH:mm aaa"));

            Map<String, Object> map = getObjectMap(bpmModel);
            senderInfo.putAll(map);

            // Create message.
            SystemMessage msg = new SystemMessage();
            msg.setTo(emails.toArray(new String[0]));
            msg.setSubject(taskInstanceBo.getProcessInstanceId().getProcessId().getName() + " - " + subject);
            msg.setMessageText(messageText);
            msg.setFunctionality(taskInstance.getTaskId().getTaskNtfTmpl());
            msg.setIsSmsActive(Boolean.FALSE);
            msg.setSenderInfo(senderInfo);

            // Send message.
            systemNotificationHelperService.notify(header, engine, msg, taskInstance.getTaskId().getTaskNtfTmplCode());
        }
    }

    public Object getBpmModelById(BigDecimal bpmModelId, BpmProcess process) {

        if ("BPM_RFI".equals(process.getCode())) {
            return rfiService.findById(bpmModelId.toString());
        } else if ("BPM_SUBMITTAL".equals(process.getCode())) {
            return submittalService.findById(bpmModelId.toString());
        } else if ("BPM_CORRESPONDENCE".equals(process.getCode())) {
            return correspondenceService.findById(bpmModelId.toString());
        } else {
            return null;
        }
    }

    public Map<String, Object> getObjectMap(Object obj) {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = oMapper.convertValue(obj, Map.class);
        return map;
    }

    public String getObjectFieldValue2(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            Object value = field.get(object);
            return value.toString();
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getObjectFieldValue(String fieldName, Object obj) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            // MZ: Find the correct method
            for (Method method : obj.getClass().getMethods()) {
                if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3))) {
                    if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                        Object result = method.invoke(obj);
                        if (result != null) {
                            return method.invoke(obj).toString();
                        }
                        return null;
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException | SecurityException e) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    public List<String> loadStakeholdersToNotify(Object bpmModel) {
        String stkhIds = getObjectFieldValue("stkhIds", bpmModel);
        String stkhGrpIds = getObjectFieldValue("stkhGrpIds", bpmModel);

        List<String> emails = new ArrayList<>();
        if (stkhIds != null && !stkhIds.isEmpty()) {
            emails.addAll(stakeholderService.listEmailByIds(stkhIds));
        }
        if (stkhGrpIds != null && !stkhGrpIds.isEmpty()) {
            emails.addAll(stakeholderGroupService.listEmailByIds(stkhGrpIds));
        }
        return emails;
    }

    public void rollback2Task(ManageITHeader header, TemplateEngine engine, BigDecimal taskInstanceId) {
        BpmTaskInstance taskInstance = dao.findById(taskInstanceId);

        // createTaskInstance(header, engine, BpmTask trgTask, BpmTaskInstance trgTaskParent, BpmProcessInstance processInstance, Object bpmModel, GlobUsers assigned, String type) {
        save(header, taskInstance);

    }

    @Override
    public void rollbackToTask(ManageITHeader header, TemplateEngine engine, String remarks, BigDecimal taskId, List<Integer> userIds, BigDecimal refId, String processCode) {
        try {
            //--[ CLEAN PREVIOUS DATA ]-----------------------------------------
            // Find model.
            Bpmcorrespondencebo correspondence = correspondenceService.findById(refId.toString());

            // Convert model to json.
            ObjectMapper mapper = new ObjectMapper();
            String jBpmModel = null;
            jBpmModel = mapper.writeValueAsString(correspondence);

            // Init java script engine.
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine jsEngine = factory.getEngineByName("JavaScript");
            jsEngine.eval("var entity = " + jBpmModel);

            // List task instance.
            ManageITBodyRequest sRequest = new ManageITBodyRequest(0, 0);
            sRequest.filter("refId", refId);
            sRequest.filter("processInstanceId.processId.code", processCode);
            sRequest.filter("taskId.type", "USER");
            sRequest.sorted("id", "asc");
            List<BpmTaskInstance> taskInstanceList = list(sRequest);

            BpmTaskInstance currentTask = null;
            for (BpmTaskInstance taskInstanceItem : taskInstanceList) {

                // List model fields by task.
                sRequest = new ManageITBodyRequest(0, 0);
                sRequest.filter("taskId", taskInstanceItem.getTaskId().getId());
                List<BpmModelField> modelFieldList = modelFieldService.list(sRequest);

                // Clean task model fields.
                for (BpmModelField modielField : modelFieldList) {
                    jsEngine.eval("entity." + modielField.getValue());
                }

                // Check if is target task.
                /*if (taskInstanceItem.getId() == taskId) {
                    taskInstanceItem.setState("READY");
                    update(taskInstanceItem);
                    break;
                } else {
                    delete(taskInstanceItem.getId());
                }*/
                // Set ROLLBACK to current task.
                if ("READY".equals(taskInstanceItem.getState())) {
                    taskInstanceItem.setState("ROLLBACK");
                    taskInstanceItem.setUserId(new GlobUsers(new BigDecimal(header.getUserid())));
                    update(taskInstanceItem);
                    currentTask = taskInstanceItem;
                }
            }

            // Convert json to entity.
            correspondence = mapper.readValue(jsEngine.eval("JSON.stringify(entity);").toString(), Bpmcorrespondencebo.class);

            // Update correspondence model.
            correspondenceService.update(correspondence);

            // Set comments.
            if (currentTask != null && StringSupport.isNotNullAndNotEmpty(remarks)) {
                Bpmcorrespondenceremark remark = new Bpmcorrespondenceremark();
                remark.setBpmcorrespondenceboPid(correspondence);
                remark.setTaskInstanceId(currentTask);
                remark.setRemark(remarks);
                remark.setReviewerId(header.getUserid());
                remark.setReviewerName(header.getUser());
                correspondenceRemarkService.save(header, remark);
            }

            //--[ CREATE NEW TASK ]---------------------------------------------
            // Get process instance.
            BpmProcessInstance processInstance = taskInstanceList.get(0).getProcessInstanceId();

            // Generate rollback task.
            // List<BpmTask> task = taskService.list(new ManageITBodyRequest(0, 0).filter("code", "COR_000"));
            // generateTaskInstance(header, engine, task.get(0).getId(), processInstance, correspondence);
            // Generate task.
            generateTaskInstance(header, engine, taskId, userIds, processInstance, correspondence);

        } catch (JsonProcessingException | ScriptException ex) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProcessExecutionException ex) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ContractViolationException ex) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BonitaException ex) {
            Logger.getLogger(BpmTaskInstanceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Map<String, Double> getDaysAvgByTask(ManageITBodyRequest request) {
        // Validate Parameters.
        if (!request.getParams().isContainsAllKeys(new String[]{"pc"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        // Set filter.
        request.filter("processInstanceId.processId.code", request.getParams().get("pc").toString());
        request.filter("taskId.type", "USER");

        // Load process list.
        List<BpmTaskInstance> list = list(request);

        // Init variables.
        Map<String, Double> daysAvg = new HashMap<>();
        Map<String, Integer> totals = new HashMap<>();

        // Get process information.
        for (BpmTaskInstance item : list) {

            // Get spend days.
            Date endDate = "COMPLETED".equals(item.getState()) ? item.getLastMod() : new Date();
            Double days = DateSupport.daysBeetwenDates(item.getCreated(), endDate).doubleValue();

            // Set "spend days" and "task total".
            if (!daysAvg.containsKey(item.getTaskId().getCode())) {
                daysAvg.put(item.getTaskId().getCode(), days);
                totals.put(item.getTaskId().getCode(), 1);
            } else {
                daysAvg.put(item.getTaskId().getCode(), daysAvg.get(item.getTaskId().getCode()) + days);
                totals.put(item.getTaskId().getCode(), totals.get(item.getTaskId().getCode()) + 1);
            }
        }

        // Calculate days average.
        for (Map.Entry<String, Double> entry : daysAvg.entrySet()) {
            entry.setValue(new BigDecimal(entry.getValue() / totals.get(entry.getKey())).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }

        return daysAvg;
    }

    @Override
    public Map<String, Double> getPersonDaysAvgByTask(ManageITBodyRequest request) {
        // Validate Parameters.
        if (!request.getParams().isContainsAllKeys(new String[]{"ti"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        // Set filter.
        request.filter("taskId.id", request.getParams().get("ti").toString());
        request.filter("taskId.type", "USER");

        // Load process list.
        List<BpmTaskInstance> list = list(request);

        // Init variables.
        Map<String, Double> daysAvg = new HashMap<>();
        Map<String, Integer> totals = new HashMap<>();

        // Get process information.
        for (BpmTaskInstance item : list) {
            if (item.getUserId() != null) {
                // Get spend days.
                Date endDate = "COMPLETED".equals(item.getState()) ? item.getLastMod() : new Date();
                Double days = DateSupport.daysBeetwenDates(item.getCreated(), endDate).doubleValue();
                // Set "spend days" and "task total".
                if (!daysAvg.containsKey(item.getUserId().getUserid())) {
                    daysAvg.put(item.getUserId().getUserid(), days);
                    totals.put(item.getUserId().getUserid(), 1);
                } else {
                    daysAvg.put(item.getUserId().getUserid(), daysAvg.get(item.getUserId().getUserid()) + days);
                    totals.put(item.getUserId().getUserid(), totals.get(item.getUserId().getUserid()) + 1);
                }
            }
        }

        // Calculate days average.
        for (Map.Entry<String, Double> entry : daysAvg.entrySet()) {
            entry.setValue(new BigDecimal(entry.getValue() / totals.get(entry.getKey())).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }

        return daysAvg;
    }

}
