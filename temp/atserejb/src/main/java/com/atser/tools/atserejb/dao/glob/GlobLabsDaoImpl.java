/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.lab.GlobLabsBO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobLabsDaoImpl extends GenericDao<BigDecimal, GlobLabs> implements GlobLabsDao {

    @Override
    public GlobLabs findById(BigInteger clientId, BigInteger labId, BigInteger functionId) {
        String query = "SELECT t.* FROM GLOB_LABS t WHERE t.client_id = :clientId AND t.masterlabid = :masterlabId AND t.function_id = :functionId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query, GlobLabs.class).setParameter("masterlabId", labId).setParameter("clientId", clientId).setParameter("functionId", functionId);
        try {
            if (q.getSingleResult() != null) {
                return (GlobLabs) q.getSingleResult();
            }
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Boolean exists(BigInteger clientId, BigInteger labId, BigInteger functionId) {
        String query = "SELECT t.id FROM GLOB_LABS t WHERE t.client_id = :clientId AND t.masterlabid = :masterlabId AND t.function_id = :functionId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("masterlabId", labId).setParameter("clientId", clientId).setParameter("functionId", functionId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public String getLabFunctionFilterByUser(String userId, String clientId, boolean isAdmin, String projectId) {
        String filter_by_lab = "";
        if (isAdmin) {
            if (StringSupport.isNullOrEmpty(projectId) || projectId.equals("-1")) {
                filter_by_lab = "(SELECT DISTINCT l.id FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.client_id = " + clientId + " AND l.active = 'Y')";
            } else {
                filter_by_lab = "(SELECT DISTINCT l.id FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.client_id = " + clientId + " AND l.active = 'Y' AND i.project_id = " + projectId + ")";
            }
        } else {
            if (StringSupport.isNullOrEmpty(projectId) || projectId.equals("-1")) {
                filter_by_lab = "(SELECT DISTINCT l.id FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i, GLOB_PROFILES p WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.id = p.lab_id AND p.user_id = " + userId + " AND l.client_id = " + clientId + " AND l.active = 'Y')";
            } else {
                filter_by_lab = "(SELECT DISTINCT l.id FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i, GLOB_PROFILES p WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.id = p.lab_id AND p.user_id = " + userId + " AND l.client_id = " + clientId + " AND l.active = 'Y' AND (p.project_id = " + projectId + " OR p.project_id=-99))";
            }
        }
        return filter_by_lab;
    }

    @Override
    public List<GlobLabsBO> getLabFunctionListModel(String userId, String clientId, boolean isAdmin, BigInteger projectId) {
        String query;
        Boolean setProjectId = false;
        if (isAdmin) {
            if (projectId == null || projectId.compareTo(new BigInteger("-1")) == 0) {
                query = "SELECT DISTINCT l.id, l.LAB_NAME, f.f_name, (l.lab_name || ' ( ' || CASE WHEN (f.f_name IS NULL) THEN '' ELSE f.f_name END || ' )') fullname, f.id functionId FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.client_id = :clientId AND l.active = 'Y' ORDER BY l.lab_name";
            } else {
                setProjectId = true;
                query = "SELECT DISTINCT l.id, l.LAB_NAME, f.f_name, (l.lab_name || ' ( ' || CASE WHEN (f.f_name IS NULL) THEN '' ELSE f.f_name END || ' )') fullname, f.id functionId FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.client_id = :clientId AND l.active = 'Y' AND i.project_id = :projectId ORDER BY l.lab_name";
            }
        } else {
            if (projectId == null || projectId.compareTo(new BigInteger("-1")) == 0) {
                query = "SELECT DISTINCT l.id, l.LAB_NAME, f.f_name, (l.lab_name || ' ( ' || CASE WHEN (f.f_name IS NULL) THEN '' ELSE f.f_name END || ' )') fullname, f.id functionId FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i, GLOB_PROFILES p WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.id = p.lab_id AND p.user_id = :userId AND l.client_id = :clientId AND l.active = 'Y' ORDER BY l.lab_name";
            } else {
                setProjectId = true;
                query = "SELECT DISTINCT l.id, l.LAB_NAME, f.f_name, (l.lab_name || ' ( ' || CASE WHEN (f.f_name IS NULL) THEN '' ELSE f.f_name END || ' )') fullname, f.id functionId FROM GLOB_LABS l, GLOB_FUNCTIONS f, GLOB_INFO i, GLOB_PROFILES p WHERE l.FUNCTION_ID = f.id AND i.FUNCTION_ID = f.id AND l.ID = i.LAB_ID AND l.id = p.lab_id AND p.user_id = :userId AND l.client_id = :clientId AND l.active = 'Y' AND (p.project_id = :projectId OR p.project_id=-99) ORDER BY l.lab_name";
            }
        }
        try {
            Query hquery = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
            if (!isAdmin) {
                hquery.setParameter("userId", userId);
            }
            if (setProjectId) {
                hquery.setParameter("projectId", projectId);
            }
            List<Object[]> objects = hquery.getResultList();
            return populateLabBO(objects);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobLabsBO> populateLabBO(List<Object[]> objects) {
        List<GlobLabsBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobLabsBO p = new GlobLabsBO();
            p.setId((StringSupport.isNullOrEmpty(it[0])) ? null : NumberSupport.getBigInteger(it[0]));
            p.setLabName(StringSupport.emptyOnNull(it[1]));
            p.setFunctionName(StringSupport.emptyOnNull(it[2]));
            p.setFullName(StringSupport.emptyOnNull(it[3]));
            p.setFunctionId(StringSupport.emptyOnNull(it[4]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }
}
