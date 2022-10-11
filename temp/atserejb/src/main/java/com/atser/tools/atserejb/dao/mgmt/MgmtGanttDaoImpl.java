/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.mgmt;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.MgmtGantt;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class MgmtGanttDaoImpl extends GenericDao<BigDecimal, MgmtGantt> implements MgmtGanttDao {

    @Override
    public void saveMetaDataGantt(BigDecimal id, String data, SyncFusionEnvInfo envinfo) {
         MgmtGantt elem = (MgmtGantt) getEntityManager()
                .createNamedQuery("MgmtGantt.findById")
                .setParameter("id", id)
                .getSingleResult();
        elem.setData(data);
        elem.setLastMod(DateSupport.formatUS(Calendar.getInstance().getTime()));
        elem.setLastModBy(envinfo.getUser());
        elem.setLastModIp(envinfo.getModIp());
        update(elem);
    }

    @Override
    public void setOpenGantt(BigDecimal id, Boolean data, SyncFusionEnvInfo envinfo) {
         MgmtGantt elem = (MgmtGantt) getEntityManager()
                .createNamedQuery("MgmtGantt.findById")
                .setParameter("id", id)
                .getSingleResult();
         if (data == true) {
            elem.setOpen((short) 1);
            elem.setOpenBy(envinfo.getUser());
        } else {
            elem.setOpen((short) 0);
            elem.setOpenBy(null);
        }
        update(elem);
    }

    @Override
    public List<MgmtGantt> findAll(List<SyncFusionSorted> sorted,String projectId) {
        StringBuilder jql = new StringBuilder();
        jql.append("SELECT NEW MgmtGantt(m.id, m.name, m.description, m.status, m.open, m.openBy, m.lastMod, m.lastModBy, m.lastModIp, m.created, m.createBy, m.createByIp, m.clientId, m.projectId) FROM MgmtGantt m WHERE m.projectId = ");
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
        jql.deleteCharAt(jql.length()-1);
        jql.append(" NULLS LAST");
        Query sortQuery = getEntityManager().createQuery(jql.toString());
        List<MgmtGantt> array = sortQuery.getResultList();
        return array;
    }

}
