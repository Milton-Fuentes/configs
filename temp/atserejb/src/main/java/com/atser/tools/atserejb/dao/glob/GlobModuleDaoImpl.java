/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobModule;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class GlobModuleDaoImpl extends GenericDao<BigDecimal, GlobModule> implements GlobModuleDao {
    
    @Override
    public GlobModule findByModuleName(String moduleName) {
        try {
            return (GlobModule) getEntityManager().createNamedQuery("GlobModule.findByModuleName").setParameter("moduleName", moduleName).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
