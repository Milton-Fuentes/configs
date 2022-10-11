/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.BpmTaskInstance;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface BpmTaskInstanceDao extends ICrudDao<BigDecimal, BpmTaskInstance> {

    void takeTask(List<BigDecimal> taskIds, BigDecimal userId);

    void releaseTask(List<BigDecimal> taskIds);

    void updateTaskState(String state, BigDecimal id);
}
