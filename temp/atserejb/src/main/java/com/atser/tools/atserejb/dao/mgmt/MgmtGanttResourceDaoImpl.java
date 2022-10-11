/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.mgmt;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.MgmtGanttResource;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceDef;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class MgmtGanttResourceDaoImpl extends GenericDao<BigDecimal, MgmtGanttResource> implements MgmtGanttResourceDao {

    @Override
    public List<MgmtGanttResource> findAll(List<SyncFusionSorted> sorted, String projectId) {
        StringBuilder jql = new StringBuilder();
        jql.append("SELECT NEW MgmtGanttResource(m.id, m.code, m.firstname, m.lastname, m.title, m.description, m.status, m.lastMod, m.lastModBy, m.lastModIp, m.created, m.createBy, m.createByIp, m.projectId) FROM MgmtGanttResource m WHERE m.projectId = ");
        jql.append(projectId);
        jql.append(" ORDER BY ");
        for (SyncFusionSorted syncFusionSorted : sorted) {
            if (syncFusionSorted != null) {
                jql.append(syncFusionSorted.getName());
                jql.append(" ");
                jql.append(syncFusionSorted.getDirection());
                jql.append(",");
            }
        }
        jql.deleteCharAt(jql.length() - 1);
        jql.append(" NULLS LAST");
        Query sortQuery = getEntityManager().createQuery(jql.toString());
        List<MgmtGanttResource> array = sortQuery.getResultList();
        return array;
    }

    @Override
    public void save(List<ResourceDef> elems, Map<String, Object> params) {
        int batchSize = 25;
        EntityManager entityManager = getEntityManager();
        try {
            for (int i = 0; i < elems.size(); i++) {
                if (!checkIfExistByCode(elems.get(i).getCode(), NumberSupport.getBigInteger(StringSupport.getString(params.get("projectId"))))) {
                    MgmtGanttResource prs = new MgmtGanttResource(elems.get(i).getCode(), elems.get(i).getFirstname(), elems.get(i).getLastname(), elems.get(i).getTitle(), new Date(), StringSupport.getString(params.get("createBy")), StringSupport.getString(params.get("createByIp")), NumberSupport.getBigInteger(params.get("projectId")));
                    entityManager.persist(prs);
                }
                if (i > 0 && i % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityManager.flush();
            entityManager.clear();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public MgmtGanttResource findByCode(String code) {
        try {
            MgmtGanttResource elem = (MgmtGanttResource) getEntityManager()
                    .createNamedQuery("MgmtGanttResource.findByCode")
                    .setParameter("code", code)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Boolean checkIfExistByCode(String code, BigInteger projectId) {
        Long count = (Long) getEntityManager()
                .createNamedQuery("MgmtGanttResource.checkExistByCode")
                .setParameter("code", code)
                .setParameter("projectId", projectId)
                .getSingleResult();
        return (count > 0);
    }
}
