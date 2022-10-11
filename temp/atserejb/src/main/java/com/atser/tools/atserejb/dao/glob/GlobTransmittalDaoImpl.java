/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobTransmittal;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author mfuentes
 */
@Stateless
public class GlobTransmittalDaoImpl extends GenericDao<BigDecimal, GlobTransmittal>  implements GlobTransmittalDao {    
    
    
    
    @Override
    public Integer getNextGlobalSequenceNo(String clientId) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_TRANSMITTAL WHERE client_id=:clientId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getInteger(result) : 1;
        } catch (NoResultException ex) {
            return 1;
        }
    }

    @Override
    public Integer getNextProjectSequenceNo(String clientId, BigDecimal projectId) {
        String query = "SELECT NVL(MAX(to_number(spno)),0) + 1 as sno FROM GLOB_TRANSMITTAL WHERE client_id=:clientId AND project_id=:projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("projectId", projectId);
     try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getInteger(result) : 1;
        } catch (NoResultException ex) {
            return 1;
        }
    }

}
