/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestFailureLogBO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleTestAddInfoDao extends ICrudDao<BigDecimal, QaSampleTestAddInfo> {

    Boolean existsQaSampleTestAddInfo(BigDecimal sampletestid);
    
    QaSampleTestAddInfo findBySampleTestId(BigDecimal sampletestid);
    
    QaSampleTestAddInfo findByTestId(BigInteger testId);
    
    List<QaSampleTestFailureLogBO>  getFailureLog(String projectId);
}
