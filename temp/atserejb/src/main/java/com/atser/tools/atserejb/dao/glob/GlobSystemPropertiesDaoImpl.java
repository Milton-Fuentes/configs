/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSystemProperties;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobSystemPropertiesDaoImpl extends GenericDao<BigDecimal, GlobSystemProperties> implements GlobSystemPropertiesDao {

    @Override
    public Map<String, String> getSystemPropertiesByClient(BigInteger clientId) {
        String query = "SELECT decode(r.pkey, null, t.pkey, r.pkey) as pkey, decode(r.pvalue, null, t.pvalue, r.pvalue) as pvalue "
                + "FROM GLOB_SYSTEM_PROPERTIES t LEFT JOIN GLOB_SYSTEM_PROPERTIES r ON (t.pkey = r.pkey AND r.client_id = :clientId) "
                + "WHERE t.CLIENT_ID = 0 ORDER BY t.pkey, r.pkey";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId);
        try {
            List<Object[]> objects = q.getResultList();
            if (objects != null && !objects.isEmpty()) {
                return objects.stream().collect(Collectors.toMap(p -> StringSupport.getString(p[0]), p -> StringSupport.getString(p[1])));
            }
        } catch (NoResultException ex) {
            return new HashMap<>();
        }
        return new HashMap<>();
    }

    @Override
    public String getSystemPropertiesByClientIdAndKey(BigInteger clientId, String key) {
        String query = "SELECT pvalue FROM GLOB_SYSTEM_PROPERTIES WHERE PKEY = :pKey AND (CLIENT_ID = :clientId OR CLIENT_ID = 0) AND ROWNUM = 1 ORDER BY CLIENT_ID DESC";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("pKey", key);
        try {
            return StringSupport.getString(q.getSingleResult());
        } catch (NoResultException ex) {
            return StringSupport.STRING_EMPTY;
        }
    }
}
