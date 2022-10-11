/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobCustomConfig;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobCustomConfigDaoImpl extends GenericDao<BigDecimal, GlobCustomConfig> implements GlobCustomConfigDao {

    @Override
    public String findValueByClientAndFunctionalityAndNameAndUserId(BigInteger clientId, String functionality, String name, BigInteger userId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT CASE WHEN (SELECT COUNT(gccu.id) FROM glob_custom_config gcc LEFT JOIN glob_custom_config_user gccu ON (gcc.id = gccu.config_id) ");
        query.append("WHERE gcc.active = 'Y' AND gcc.deleted = 'N' AND gccu.active = 'Y' AND gccu.deleted = 'N' AND gcc.customizable = 'Y' AND gcc.client_id = :clientId AND gcc.name = :name ");
        if (StringSupport.isNotNullAndNotEmpty(functionality)) {
            query.append(" AND gcc.functionality = :functionality ");
        }
        if (userId != null) {
            query.append(" AND gccu.user_id = :userId ");
        }
        query.append(" ) = 0 THEN (SELECT gcc.value FROM glob_custom_config gcc WHERE gcc.active = 'Y' AND gcc.deleted = 'N' AND gcc.customizable = 'Y' AND gcc.client_id = :clientId AND gcc.name = :name ");
        if (StringSupport.isNotNullAndNotEmpty(functionality)) {
            query.append(" AND gcc.functionality = :functionality ");
        }
        query.append(" ) ELSE (SELECT gccu.value FROM glob_custom_config gcc LEFT JOIN glob_custom_config_user gccu ON (gcc.id = gccu.config_id) WHERE gcc.active = 'Y' AND gcc.deleted = 'N' AND gccu.active = 'Y' ");
        query.append(" AND gccu.deleted = 'N' AND gcc.customizable = 'Y' AND gcc.client_id = :clientId AND gcc.name = :name ");
        if (StringSupport.isNotNullAndNotEmpty(functionality)) {
            query.append(" AND gcc.functionality = :functionality ");
        }
        if (userId != null) {
            query.append(" AND gccu.user_id = :userId ) END AS value FROM DUAL ");
        }
        Query q = getEntityManager().createNativeQuery(query.toString())
                .setParameter("clientId", clientId)
                .setParameter("name", name);
        if (StringSupport.isNotNullAndNotEmpty(functionality)) {
            q.setParameter("functionality", functionality);
        }
        if (userId != null) {
            q.setParameter("userId", userId);
        }
                
        try {
            return StringSupport.getStringFromClob((Clob)q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(GlobCustomConfigDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<GlobCustomConfig> listPendingConfigsByClientAndFunctionalityAndUserId(BigInteger clientId, String functionality, BigInteger userId) {
        String query = "SELECT gcc.* FROM glob_custom_config gcc WHERE gcc.active = 'Y' AND gcc.deleted = 'N' AND gcc.customizable = 'Y' AND gcc.client_id = :clientId "
                + "AND gcc.functionality = :functionality AND gcc.id NOT IN (SELECT gccu.config_id FROM glob_custom_config_user gccu WHERE gccu.active = 'Y' "
                + "AND gccu.deleted = 'N' AND gccu.user_id = :userId)";
        Query q = getEntityManager().createNativeQuery(query, GlobCustomConfig.class)
                .setParameter("clientId", clientId)
                .setParameter("functionality", functionality)
                .setParameter("userId", userId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
