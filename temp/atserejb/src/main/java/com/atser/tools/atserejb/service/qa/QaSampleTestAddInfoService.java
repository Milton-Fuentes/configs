/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestFailureLogBO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleTestAddInfoService extends ICrudService<BigDecimal, QaSampleTestAddInfo> {

    Boolean existsQaSampleTestAddInfo(BigDecimal sampletestid);

    QaSampleTestAddInfo findByTestId(BigInteger testId);

    void deleteByTestId(String id);

    QaSampleTestAddInfo findBySampleTestId(String sampletestid);

    List<QaSampleTestFailureLogBO> getFailureLog(String projectId);
}
