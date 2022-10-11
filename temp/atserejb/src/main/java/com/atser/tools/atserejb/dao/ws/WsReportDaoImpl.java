/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.WsReport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class WsReportDaoImpl extends GenericDao<BigDecimal, WsReport> implements WsReportDao {

    @Override
    public WsReport findReport(BigInteger clientId, String functionality, String code) {
        try {
            WsReport rp = (WsReport) getEntityManager()
                    .createNamedQuery("WsReport.findSpecReport")
                    .setParameter("clientId", clientId)
                    .setParameter("reportFunctionality", functionality)
                    .setParameter("reportCode", code)
                    .getSingleResult();
            rp.getSubReportList().size();
            return rp;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
