/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobProfiles;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobProfilesDaoImpl extends GenericDao<BigDecimal, GlobProfiles> implements GlobProfilesDao {

    @Override
    public List<GlobProfiles> findByUserId(BigInteger id) {
        try {
            List<GlobProfiles> array = getEntityManager().createNamedQuery("GlobProfiles.findByUserId")
                    .setParameter("userId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<String> getEmailListByRole(String role_name, BigInteger clientId) {
        String query = "SELECT distinct gc.email FROM glob_profiles gp, glob_roles gr, glob_users gu, glob_contact gc where gp.role_id = gr.id AND gp.user_id = gu.id AND gu.contactid = gc.id AND gr.role_name = :rolName AND gp.client_id = :clientId AND gu.active = 'Y' ";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("rolName", role_name);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

}
