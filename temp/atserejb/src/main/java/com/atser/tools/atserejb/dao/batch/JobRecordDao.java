/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.batch;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.JobRecords;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface JobRecordDao extends ICrudDao<BigDecimal, JobRecords> {
}
