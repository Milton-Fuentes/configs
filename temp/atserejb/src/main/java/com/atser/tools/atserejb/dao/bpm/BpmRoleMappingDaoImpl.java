/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.BpmRoleMapping;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmRoleMappingDaoImpl extends GenericDao<BigDecimal, BpmRoleMapping> implements BpmRoleMappingDao {
    
    @Override
    public BpmRoleMapping findByManageItRoleAndClientID(String role, BigInteger id) {
        try {
            BpmRoleMapping elem = (BpmRoleMapping) getEntityManager()
                    .createNamedQuery("BpmRoleMapping.findByManageitRoleNameAndClient")
                    .setParameter("manageitRoleName", role)
                    .setParameter("clientId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
