/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.batch;

import com.atser.tools.atserejb.model.JobExecution;
import java.math.BigDecimal;
import com.atser.tools.atserejb.common.jpa.ICrudDao;

/**
 *
 * @author droldan
 */
public interface JobExecutionDao extends ICrudDao<BigDecimal, JobExecution> {
}
