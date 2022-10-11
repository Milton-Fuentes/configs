/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmBiditCompany;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class CmBiditCompanyDaoImpl extends GenericDao<BigDecimal, CmBiditCompany> implements CmBiditCompanyDao {

    @Override
    public Boolean exists(String companyTin) {
        String query = "SELECT t.id FROM CM_BIDIT_COMPANY t WHERE t.COMPANY_TIN = :companyTin AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("companyTin", companyTin);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

}
