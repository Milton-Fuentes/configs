/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QmClientRoleMatrix;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QmClientRoleMatrixDaoImpl extends GenericDao<BigDecimal, QmClientRoleMatrix> implements QmClientRoleMatrixDao {

    @Override
    public Boolean getRoleRightMatrixList(BigInteger clientId, String currentRole, String ruleName) {
        String query = "SELECT m.id FROM qm_client_role_matrix m, glob_roles t WHERE m.role_id=t.id and m.client_id=:clientId and m.item_name=:ruleName and t.role_name=:currentRole and m.read_rights='Y' and m.edit_rights='Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("currentRole", currentRole)
                .setParameter("ruleName", ruleName);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null);
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Map<String, Boolean> getRoleRightsMatrixList(BigInteger clientId, String currentRole, List<String> rulesNames) {
        Map<String, Boolean> result = new HashMap<>();
        String query = "SELECT m.* FROM qm_client_role_matrix m, glob_roles t WHERE m.role_id=t.id and m.client_id=:clientId and m.item_name in :rulesNames and t.role_name=:currentRole";
        Query q = getEntityManager().createNativeQuery(query, QmClientRoleMatrix.class)
                .setParameter("clientId", clientId)
                .setParameter("currentRole", currentRole)
                .setParameter("rulesNames", rulesNames);

        try {
            List<QmClientRoleMatrix> resultList = q.getResultList();
            System.out.println(resultList.size());
            resultList.forEach(item -> {
               result.put(item.getItemName(), Character.compare('Y', item.getReadRights()) == 0 && Character.compare('Y', item.getEditRights()) == 0); 
            });
            return result;
        } catch (NoResultException ex) {
            return result;
        }
    }

}
