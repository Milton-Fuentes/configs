/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipinfoV1;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipCalibAlertPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipMaintAlertPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.MaintLogPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface QalabEquipinfoV1Service {

    QalabEquipinfoV1 findById(String id);

    void save(ManageITHeader header, QalabEquipinfoV1 elem);

    void update(QalabEquipinfoV1 elem);

    void update(ManageITHeader header, QalabEquipinfoV1 elem);

    void updateExpirationDate(QalabEquipinfoV1 elem);

    void delete(String id);

    List<QalabEquipinfoV1> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QalabEquipinfoV1> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<QalabEquipinfoV1> dataGridList(ManageITBodyRequest request);

    // New services
    List<MaintLogPojo> listMaintDueDate(String id);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    BigDecimal createEquipFolderStruct(String userId, String clientId, String InfoId);

    BigDecimal createEquipFolderStruct(String userId, String clientId, QalabEquipinfoV1 elem);

    Object getVersion(Integer number);

    List getRevisions(String id);

    List<EquipCalibAlertPojo> getEquipCalibExpiredList(BigInteger clientId, Integer alertDays);

    List<EquipMaintAlertPojo> getEquipMainExpiredList(BigInteger clientId, Integer alertDays);

    void sendCalibAlertNotification(BigInteger clientId, TemplateEngine engine);

    void sendMaintAlertNotification(BigInteger clientId, TemplateEngine engine);

    void assignToProject(ManageITHeader header, String projectId, String equipId);

    QalabEquipinfoV1 findBySerialNo(BigInteger clientId, String serialNo);

    BigDecimal getIdBySerialNo(BigInteger clientId, String serialNo);
    
    String generateEquipBarcode(String tplbasePath, String docpathsegment, String reportId, String docType, String clientId, ManageITBodyRequest request, String reqId);
}
