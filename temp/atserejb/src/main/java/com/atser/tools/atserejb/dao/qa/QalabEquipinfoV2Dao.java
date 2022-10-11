/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QalabEquipinfoV2;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipCalibAlertPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipMaintAlertPojo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QalabEquipinfoV2Dao extends ICrudDao<BigDecimal, QalabEquipinfoV2> {

    List<EquipCalibAlertPojo> getEquipCalibExpiredList(BigInteger clientId, Integer alertDays);

    List<EquipMaintAlertPojo> getEquipMainExpiredList(BigInteger clientId, Integer alertDays);
    
    QalabEquipinfoV2 findBySerialNo(BigInteger clientId, String serialNo);
    
    BigDecimal getIdBySerialNo(BigInteger clientId, String serialNo);
}
