/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.BpmProcessInstance;
import com.atser.tools.atserejb.model.BpmTask;
import com.atser.tools.atserejb.model.BpmTaskInstance;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author dperez
 */
public interface BpmTaskInstanceService extends ICrudService<BigDecimal, BpmTaskInstance> {

    BigDecimal save(BpmTaskInstance elem);

    void update(BpmTaskInstance elem);

    void takeTask(List<BigDecimal> taksIds, BigDecimal userId);

    void releaseTask(List<BigDecimal> taskIds);

    void updateTaskState(ManageITHeader header, TemplateEngine engine, String state, BigDecimal id);

    void generateTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, List<Integer> users, BpmProcessInstance processInstance, Object bpmModel);

    BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, BigDecimal processInstanceId, BigDecimal bpmModelId);

    BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BigDecimal trgTaskId, BigDecimal taskInstanceParentId, BigDecimal processInstanceId, BigDecimal bpmModelId, BigDecimal assignedId);

    BpmTaskInstance createTaskInstance(ManageITHeader header, TemplateEngine engine, BpmTask trgTask, BpmTaskInstance trgTaskParent, BpmProcessInstance processInstance, Object bpmModel, GlobUsers assigned, String type);

    Boolean isAllChildTaskCompleted(BigDecimal parentId);

    void sendNotification(ManageITHeader header, TemplateEngine engine, BpmTaskInstance taskInstance, Object bpmModel, String subject, String messageText);

    Map<String, Double> getDaysAvgByTask(ManageITBodyRequest request);

    Map<String, Double> getPersonDaysAvgByTask(ManageITBodyRequest request);

    void rollbackToTask(ManageITHeader header, TemplateEngine engine, String remarks, BigDecimal taskId, List<Integer> userIds, BigDecimal refId, String processCode);

}
