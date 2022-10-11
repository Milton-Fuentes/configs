/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobContactCert;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobContactCertDaoImpl extends GenericDao<BigDecimal, GlobContactCert> implements GlobContactCertDao {

    @Override
    public List<GlobContactCert> filterByProject(BigInteger projectId) {
        String query = "SELECT * FROM glob_contact_cert c WHERE c.deleted = 'N' AND c.active = 'Y' AND c.contact_id IN (SELECT t.contact_id FROM project_personnel_list t WHERE t.project_id = :projectId AND t.active = 'Y')";
        Query q = getEntityManager().createNativeQuery(query, GlobContactCert.class).setParameter("projectId", projectId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
}
