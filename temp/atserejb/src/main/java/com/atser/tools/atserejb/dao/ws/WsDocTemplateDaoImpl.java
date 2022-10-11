/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.WsDocTemplate;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class WsDocTemplateDaoImpl extends GenericDao<BigDecimal, WsDocTemplate> implements WsDocTemplateDao {

    @Override
    public WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type) {
        try {
            WsDocTemplate rp = (WsDocTemplate) getEntityManager()
                    .createNamedQuery("WsDocTemplate.findSpecDoc")
                    .setParameter("clientId", clientId)
                    .setParameter("docFunctionality", functionality)
                    .setParameter("docType", type)
                    .getSingleResult();
            return rp;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type, String docCode) {
        try {
            WsDocTemplate rp = (WsDocTemplate) getEntityManager()
                    .createNamedQuery("WsDocTemplate.findSpecDocByCode")
                    .setParameter("clientId", clientId)
                    .setParameter("docFunctionality", functionality)
                    .setParameter("docType", type)
                    .setParameter("docCode", docCode)
                    .getSingleResult();
            return rp;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
