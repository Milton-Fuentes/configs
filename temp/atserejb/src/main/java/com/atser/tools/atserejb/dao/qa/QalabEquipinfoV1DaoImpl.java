/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QalabEquipinfoV1;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipCalibAlertPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipMaintAlertPojo;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class QalabEquipinfoV1DaoImpl extends GenericDao<BigDecimal, QalabEquipinfoV1> implements QalabEquipinfoV1Dao {

    @Override
    public List<EquipCalibAlertPojo> getEquipCalibExpiredList(BigInteger clientId, Integer alertDays) {
        String query = "SELECT tp.item as equipType, t.equip_item_descrip as equipDescription, t.equip_electronictag as electronicTag, t.serial_no as serialNo, t.equip_no as equipNo, "
                + "t.log_date as calibDate, t.expiration_date as expirationDate FROM qalab_equipinfo t JOIN glob_labs_master l ON (t.lab_id = l.id) JOIN qalab_equiptype tp ON (t.equip_id = tp.id) "
                + "WHERE l.client_id = :clientId AND t.active = 'Y' AND t.deleted = 'N' AND (t.expiration_date - :days) <= SYSDATE";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("days", alertDays);
        try {
            return populateEquipCalibAlertPojo(q.getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<EquipMaintAlertPojo> getEquipMainExpiredList(BigInteger clientId, Integer alertDays) {
        String query = "SELECT tp.item as equipType, t.equip_electronictag as electronicTag, t.serial_no as serialNo, t.equip_no as equipNo, m.equippart_name as equipPartName, c.maint_date as maintDate, "
                + "c.maint_due_date as maintDueDate FROM qalab_equipinfo t JOIN glob_labs_master l ON (t.lab_id = l.id) JOIN qalab_maintlog c ON (c.equip_infoid = t.id) "
                + "JOIN qalab_mainttype m ON (c.equip_mainttypeid = m.id) JOIN qalab_equiptype tp ON (t.equip_id = tp.id) WHERE l.client_id = :clientId AND t.active = 'Y' AND t.deleted = 'N' "
                + "AND c.maint_date =( SELECT max(maint_date) FROM qalab_maintlog WHERE equip_mainttypeid = m.id ) AND (c.maint_due_date - :days) <= SYSDATE";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("days", alertDays);
        try {
            return populateEquipMaintAlertPojo(q.getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<EquipCalibAlertPojo> populateEquipCalibAlertPojo(List<Object[]> objects) {
        List<EquipCalibAlertPojo> list = new ArrayList<>();
        objects.stream().map((it) -> {
            EquipCalibAlertPojo p = new EquipCalibAlertPojo();
            p.setEquipType(StringSupport.emptyOnNull(it[0]));
            try {
                p.setEquipDescription(StringSupport.getStringFromClob((Clob) it[1]));
            } catch (IOException | SQLException ex) {
                Logger.getLogger(QalabEquipinfoV2DaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setElectronicTag(StringSupport.emptyOnNull(it[2]));
            p.setSerialNo(StringSupport.emptyOnNull(it[3]));
            p.setEquipNo(StringSupport.emptyOnNull(it[4]));
            p.setCalibDate(it[5] != null ? DateSupport.formatUS((Date) it[5]) : null);
            p.setExpirationDate(it[6] != null ? DateSupport.formatUS((Date) it[6]) : null);
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    private List<EquipMaintAlertPojo> populateEquipMaintAlertPojo(List<Object[]> objects) {
        List<EquipMaintAlertPojo> list = new ArrayList<>();
        objects.stream().map((it) -> {
            EquipMaintAlertPojo p = new EquipMaintAlertPojo();
            p.setEquipType(StringSupport.emptyOnNull(it[0]));
            p.setElectronicTag(StringSupport.emptyOnNull(it[1]));
            p.setSerialNo(StringSupport.emptyOnNull(it[2]));
            p.setEquipNo(StringSupport.emptyOnNull(it[3]));
            p.setEquipPartName(StringSupport.emptyOnNull(it[4]));
            p.setMaintDate(it[5] != null ? DateSupport.formatUS((Date) it[5]) : null);
            p.setMaintDueDate(it[6] != null ? DateSupport.formatUS((Date) it[6]) : null);
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public QalabEquipinfoV1 findBySerialNo(BigInteger clientId, String serialNo) {
        String query = "SELECT t.* FROM QALAB_EQUIPINFO t INNER JOIN GLOB_LABS l ON (t.lab_id = l.id) WHERE l.client_id = :clientId AND UPPER(t.SERIAL_NO) = UPPER(:serialNo) AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query, QalabEquipinfoV1.class)
                .setParameter("clientId", clientId)
                .setParameter("serialNo", serialNo);
        try {
            return (QalabEquipinfoV1) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            System.out.println("@ERROR NonUniqueResultException.  findBySerialNo: " + serialNo);
            return (QalabEquipinfoV1) q.getResultList().get(0);
        }
    }

    @Override
    public BigDecimal getIdBySerialNo(BigInteger clientId, String serialNo) {
        String query = "SELECT t.id FROM QALAB_EQUIPINFO t INNER JOIN GLOB_LABS l ON (t.lab_id = l.id) WHERE l.client_id = :clientId AND UPPER(t.SERIAL_NO) = UPPER(:serialNo) AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("serialNo", serialNo);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            System.out.println("@ERROR NonUniqueResultException.  getIdBySerialNo: " + serialNo);
            return (BigDecimal) q.getResultList().get(0);
        }
    }
}
