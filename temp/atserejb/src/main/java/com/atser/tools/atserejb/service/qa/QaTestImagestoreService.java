/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface QaTestImagestoreService {

    QaTestImagestore findById(String id);

    QaTestImagestore findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaTestImagestore elem);

    void update(ManageITHeader header, QaTestImagestore elem);

    void updateReportStatus(String id, String reportStatus, String reportPath);

    void delete(String id);

    void delete(String id, String reportPath);

    void delete(BigInteger id);

    void delete(ManageITBodyRequest request);

    List<QaTestImagestore> list(ManageITBodyRequest request);

    void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, BigInteger refId, String standard, String spec);

    void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    public void rotateImage(BigDecimal id, String side);

    List<QaTestImagestore> getImageListByWoId(BigInteger woId);
}
