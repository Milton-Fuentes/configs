/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserutil.objects.pojo.cm.CmBidITPrjCatgSearchDefParam;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidItAnalysis;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mdelabat
 */
public interface CmBiditPrjCatgService extends ICrudService<BigDecimal, CmBiditPrjCatg> {

    CmBiditPrjCatg findById(ManageITHeader header, String id);

    CmBiditPrjCatg findById(ManageITHeader header, BigDecimal id);

    Object getFrontEndSearch(ManageITHeader header, CmBidITPrjCatgSearchDefParam body);

    void changeStatus(ManageITBodyRequest body);

    void updateBidSignStatus(BigDecimal id, BigInteger statusId);

    void changeBidRevision(ManageITBodyRequest body);

    void changePublishStatus(ManageITBodyRequest<Object> body);

    CmBidItAnalysis getBidAnalysis(BigInteger prjCatgId);

    String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, String prjCatgId);
}
