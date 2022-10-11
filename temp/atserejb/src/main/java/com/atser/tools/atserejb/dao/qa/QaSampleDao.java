/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleDao extends ICrudDao<BigDecimal, QaSample> {
    
    Boolean existsSample(BigDecimal sampleId);
    
    Boolean existsSample(BigDecimal sampleId, Boolean status);

    Boolean existsConcMixDesign(BigInteger mixId);
    
    Boolean existsAspmMixDesign(BigInteger mixId);
    
    String getSampleCategory(String clientId, String sampleNo);
    
    QaSample findBySampleNo(String sampleNo, BigInteger projectId);
    
    DataTableWrapper<QaSampleSearchBO> getFrontEndSearchSampleInbox(QaSampleSearchDefParam filters);
    
    List<QaSampleSearchBO> getFrontEndSearchAllSampleInbox(QaSampleSearchDefParam filters);
    
    void updateStatus(BigDecimal sampleId, String active);
}
