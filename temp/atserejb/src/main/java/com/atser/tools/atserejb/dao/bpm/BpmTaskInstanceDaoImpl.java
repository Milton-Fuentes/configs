/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.BpmTaskInstance;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BpmTaskInstanceDaoImpl extends GenericDao<BigDecimal, BpmTaskInstance> implements BpmTaskInstanceDao {

    @Override
    public void takeTask(List<BigDecimal> taskIds, BigDecimal userId) {
        getEntityManager().createNativeQuery("UPDATE BPM_TASK_INSTANCE SET USER_ID = :uId WHERE ID IN :tIds")
                .setParameter("tIds", taskIds)
                .setParameter("uId", userId)
                .executeUpdate();
    }

    @Override
    public void releaseTask(List<BigDecimal> taskIds) {
        getEntityManager().createNativeQuery("UPDATE BPM_TASK_INSTANCE SET USER_ID = null WHERE ID IN :tIds")
                .setParameter("tIds", taskIds)
                .executeUpdate();
    }

    @Override
    public void updateTaskState(String state, BigDecimal id) {
        getEntityManager().createNativeQuery("UPDATE BPM_TASK_INSTANCE SET STATE = :state WHERE ID = :id")
                .setParameter("state", state)
                .setParameter("id", id)
                .executeUpdate();
    }

}
