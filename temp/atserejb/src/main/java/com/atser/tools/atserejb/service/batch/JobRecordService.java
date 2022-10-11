/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.batch;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.JobRecords;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface JobRecordService extends ICrudService<BigDecimal, JobRecords> {

    BigDecimal save(JobRecords elem);

    void update(JobRecords elem);
}
