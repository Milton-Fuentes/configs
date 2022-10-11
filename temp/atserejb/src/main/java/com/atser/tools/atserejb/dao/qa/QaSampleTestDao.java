/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleTestSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleTestDao extends ICrudDao<BigDecimal, QaSampleTest> {

    DataTableWrapper<QaSampleTestSearchBO> getFrontEndSearchTestInbox(QaSampleTestSearchDefParam filters);
    
    List<QaSampleTestSearchBO> getFrontEndSearchAllTestInbox(QaSampleTestSearchDefParam filters);
    
    BigInteger getNextTestNoByProject(BigInteger projectId);
    
    String getTestNameListByWorkOrder(BigInteger clientId, BigInteger woId);
    
    BigDecimal getDynamicTestTableId(String tableName, BigInteger sampleTestId);
}
