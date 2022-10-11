/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaaspmMixdesignsJmf;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignsJmfService {

    QaaspmMixdesignsJmf findById(String id);

    QaaspmMixdesignsJmf findById(BigDecimal id);

    QaaspmMixdesignsJmf findById(ManageITHeader header, String id);

    QaaspmMixdesignsJmf findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, QaaspmMixdesignsJmf elem);
    
    void copy(ManageITHeader header, QaaspmMixdesignsJmf elem);

    void update(ManageITHeader header, QaaspmMixdesignsJmf elem);

    void delete(String id);

    List<QaaspmMixdesignsJmf> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QaaspmMixdesignsJmf> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<QaaspmMixdesignsJmf> dataGridList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    void setMain(ManageITBodyRequest request);

    LinkedHashMap<String, Object> hasSetMainJMF(ManageITBodyRequest request);
    
    List<GradationPojo> getGradationPojoList(BigDecimal masterMixId, BigDecimal mainJmfId, BigDecimal setId);
    
    QaaspmMixdesignsJmf getMainMixdesignJmfMaster(BigDecimal masterMixId);
}
