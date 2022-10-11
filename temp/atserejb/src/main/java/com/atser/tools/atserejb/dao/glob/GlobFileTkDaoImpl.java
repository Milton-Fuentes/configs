/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFileTk;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author dperez
 */
@Stateless
public class GlobFileTkDaoImpl extends GenericDao<BigDecimal, GlobFileTk> implements GlobFileTkDao {

    @Override
    public Optional<BigInteger> validateTokenAndGetFileId(String token) {
        String query = "SELECT (TRUNC((EXTRACT (DAY FROM (SYSTIMESTAMP - t.CREATED)))) - t.EXPIRE_DAYS) as DAYS, t.file_id FROM glob_file_tk t WHERE t.TOKEN = :token ";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("token", token);
        try {
            Object[] dto = (Object[]) q.getSingleResult();
            Integer days = NumberSupport.getInteger(dto[0]);
            if (days >= 0) {
                return Optional.empty();
            }
            return Optional.ofNullable(NumberSupport.getBigInteger(dto[1]));
        } catch (NoResultException | NonUniqueResultException ex) {
            return Optional.empty();
        }
    }
}
