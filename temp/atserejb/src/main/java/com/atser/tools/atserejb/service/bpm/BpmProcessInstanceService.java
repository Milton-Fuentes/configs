/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.BpmProcess;
import com.atser.tools.atserejb.model.BpmProcessInstance;
import com.atser.tools.atserutil.objects.to.chart.ChartColumnSeriesTO;
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
public interface BpmProcessInstanceService extends ICrudService<BigDecimal, BpmProcessInstance> {

    BigDecimal save(BpmProcessInstance elem);

    void update(BpmProcessInstance elem);

    void startProcess(ManageITHeader header, TemplateEngine engine, String processCode, BigDecimal modelId, BigDecimal projectId, BigDecimal clientId);

    BigDecimal createProcessInstance(BpmProcess process, BigDecimal projectId, BigDecimal clientId, BigDecimal modelId);

    void closeProcessInstance(BigDecimal id);

    // List<ChartColumnSeriesTO> generateChartDataOverdueProcess(BigDecimal clientId, String processCode);

    Map<String, BigDecimal> getTotalOverdue(BigDecimal clientId, BigDecimal projectId, String processCode);

    Map<String, Long> getDaysByProcess(ManageITBodyRequest request);

    Map<String, Double> getDaysAvgByProcess(ManageITBodyRequest request);

}
