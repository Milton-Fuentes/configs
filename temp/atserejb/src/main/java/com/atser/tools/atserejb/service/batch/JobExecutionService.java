/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.batch;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.JobExecution;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface JobExecutionService extends ICrudService<BigDecimal, JobExecution> {

    BigDecimal save(JobExecution elem);

    void update(JobExecution elem);
}
