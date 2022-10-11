/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobProjectClient;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Stateless
public class GlobProjectClientDaoImpl extends GenericDao<BigDecimal, GlobProjectClient> implements GlobProjectClientDao {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public List<GlobProjectClient> getFrontEndProjectClientListByCurrentProfile(String userId, String clientId, boolean isAdmin, boolean uses_global_profiles, String functionId) {
        String query = buildProjectClientQuery(userId, clientId, isAdmin, uses_global_profiles, functionId);
        try {
            return getEntityManager().createNativeQuery(query, GlobProjectClient.class)
                    .setParameter("clientId", clientId)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    private String buildProjectClientQuery(String userId, String clientId, boolean isAdmin, boolean uses_global_profiles, String functionId) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select distinct pc.* from glob_project_client pc, glob_project p where pc.id=p.project_client_id and p.active='Y' and pc.customer_id = :clientId ");
        // Filter by Profile
        String filter_by_profile = globProjectDao.filterByProfile(" p.id", isAdmin, uses_global_profiles, clientId, userId);
        if (!filter_by_profile.isEmpty()) {
            queryBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
        }
        // Filter by Function
        if (StringSupport.isNotNullAndNotEmpty(functionId)) {
            queryBuilder.append(" and p.id in (select project_id from glob_info where function_id = ").append(functionId).append(") ");
        }
        // Order By
        queryBuilder.append(" order by pc.project_client_name ");
        return queryBuilder.toString();
    }

}
