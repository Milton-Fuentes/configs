/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.Bpmsubmittalmetadata;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface BpmSubmittalMetaDataDao extends ICrudDao<BigDecimal, Bpmsubmittalmetadata> {

    Bpmsubmittalmetadata findByRfiId(BigDecimal id);
}
