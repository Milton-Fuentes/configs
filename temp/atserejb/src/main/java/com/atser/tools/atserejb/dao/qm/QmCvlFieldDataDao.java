/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QmCvlField;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QmCvlFieldDataDao extends ICrudDao<BigDecimal, QmCvlFieldData>{
    
    QmCvlField getQmCvlFieldParent(BigInteger clientId, String sectionName, String fieldCode);
}
