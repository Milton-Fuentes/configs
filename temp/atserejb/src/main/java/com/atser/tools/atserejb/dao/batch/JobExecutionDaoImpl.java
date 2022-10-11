/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.batch;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.JobExecution;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class JobExecutionDaoImpl extends GenericDao<BigDecimal, JobExecution> implements JobExecutionDao {

    @Override
    public void delete(BigDecimal id) {
        JobExecution elem = (JobExecution) getEntityManager()
                .createNamedQuery("JobExecution.findByJobexecutionid")
                .setParameter("jobexecutionid", id)
                .getSingleResult();
        delete(elem);
    }
}
