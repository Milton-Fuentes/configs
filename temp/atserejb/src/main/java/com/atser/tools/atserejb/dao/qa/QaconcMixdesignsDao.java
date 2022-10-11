/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaconcMixdesignsDao extends ICrudDao<BigDecimal, QaconcMixdesigns> {
    
    Boolean exists(BigInteger projectId, String name);
    
    QaconcMixdesigns findByMixdesignNo(BigInteger projectId, String mixdesignNo);
    
    void changeStatusByMasterId(Character status, BigInteger masterId);
    
    QaconcMixdesigns findByMasterRefAndProject(BigInteger projectId, BigInteger masterRefId);
}
