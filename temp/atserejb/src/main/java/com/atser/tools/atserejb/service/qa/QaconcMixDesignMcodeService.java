/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaconcMixDesignMcode;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaconcMixDesignMcodeService {

    QaconcMixDesignMcode findById(String id);

    QaconcMixDesignMcode findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaconcMixDesignMcode elem);

    void update(ManageITHeader header, QaconcMixDesignMcode elem);

    void delete(String id);

    List<QaconcMixDesignMcode> list(ManageITBodyRequest request);

    DataGridWrapper<QaconcMixDesignMcode> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<QaconcMixDesignMcode> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    void copyFromMix(ManageITHeader header, String fromMixId, String targetMixId);
}
