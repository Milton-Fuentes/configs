/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesignMaster;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignJmfMasterService {

    QaaspmMixdesignJmfMaster findById(String id);

    QaaspmMixdesignJmfMaster findById(BigDecimal id);

    QaaspmMixdesignJmfMaster findById(ManageITHeader header, String id);

    QaaspmMixdesignJmfMaster findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, QaaspmMixdesignJmfMaster elem);
    
    void saveFromTo(ManageITHeader header, AspmMixDesignDef elem, QaaspmMixdesignMaster masterMixId);

    void update(ManageITHeader header, QaaspmMixdesignJmfMaster elem);

    void delete(String id);

    List<QaaspmMixdesignJmfMaster> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QaaspmMixdesignJmfMaster> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<QaaspmMixdesignJmfMaster> dataGridList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    void setMain(ManageITBodyRequest request);
    
    LinkedHashMap<String, Object> hasSetMainJMF(ManageITBodyRequest request);

    void assignMainJMFToProject(ManageITHeader header, BigDecimal masterMixId, BigDecimal projectMixId);

    void updateLimits(ManageITHeader header, QaaspmMixdesignJmfMaster elem, QaaspmMixdesignMaster mixId);
    
    QaaspmMixdesignJmfMaster getMainMixdesignJmfMaster(BigDecimal masterMixId);
    
    void changeStatus(ManageITBodyRequest request);

    void assignJMFToProject(ManageITHeader header, BigDecimal projectMixId, BigDecimal jmfId);

    List<DataSelectWrapper> filterJmfByProject(BigInteger projectId, BigInteger mixId);
    
    BigInteger getNextJMFNo(BigInteger mixId);
    
    List<GradationPojo> getGradationPojoList(BigDecimal masterMixId, BigDecimal mainJmfId, BigDecimal setId);
}
