/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobProjectPersonnelDaoImpl extends GenericDao<BigDecimal, GlobProjectPersonnel> implements GlobProjectPersonnelDao {

    @Override
    public List<String> getPersonnelIdWithWO(BigInteger projectId) {
        String query;
        Query q;
        query = "select distinct t.id from ( select DISTINCT gc.id from glob_dispatchcall_log igdc, "
                + "glob_project_personnel gpp, glob_contact gc where gpp.contact_id = gc.id "
                + "and igdc.techrefid = gc.id and igdc.project_id = :projectId "
                + "union all select distinct gc.id from glob_inspworkorder igiwo, glob_project_personnel gpp, "
                + "glob_contact gc where igiwo.insp_refid = gpp.contact_id "
                + "AND gpp.contact_id = gc.id and igiwo.project_id = :projectId) t";
        q = getEntityManager().createNativeQuery(query)
                .setParameter("projectId", projectId);
        List<BigDecimal> array = q.getResultList();
        List<String> result = new ArrayList<>();
        array.forEach((obj) -> {
            result.add(obj.toString());
        });
        return result;
    }

    @Override
    public List<String> getPersonnelIdWithWOForDispatchByProject(BigInteger projectId) {
        String query = "select distinct t.id from ( select DISTINCT gc.id from glob_dispatchcall_log igdc, glob_project_personnel gpp, glob_contact gc where gpp.contact_id = gc.id and igdc.techrefid = gc.id and igdc.project_id = :projectId ) t";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("projectId", projectId);
        try {
            List<BigDecimal> array = q.getResultList();
            List<String> result = new ArrayList<>();
            array.forEach((obj) -> {
                result.add(obj.toString());
            });
            return result;
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<String> getPersonnelIdWithWOForDispatchByClient(BigInteger clientId) {
        String query;
        query = "select distinct t.id from ( select DISTINCT gc.id from glob_dispatchcall_log igdc, glob_project_personnel gpp, glob_contact gc where gpp.contact_id = gc.id and igdc.techrefid = gc.id and igdc.project_id IN (select id from glob_project gp where gp.client_id = :clientId) ) t";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId);
        try {
            List<BigDecimal> array = q.getResultList();
            List<String> result = new ArrayList<>();
            array.forEach((obj) -> {
                result.add(obj.toString());
            });
            return result;
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Boolean existsGlobalProject(BigInteger contactId) {
        String query = "SELECT client_id FROM glob_project_personnel WHERE project_id=0 AND contact_id=:contactId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("contactId", contactId);
        try {
            if (q.getResultList() != null && q.getResultList().size() > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public void inactiveAllProjectWhenGlobal(BigInteger clientId, BigInteger contactId) {
        if (clientId != null && contactId != null) {
            String query = "UPDATE glob_project_personnel SET active='N' WHERE client_id=:clientId AND project_id<>0 AND contact_id=:contactId";
            Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("contactId", contactId);
            q.executeUpdate();
        }
    }

    @Override
    public List<CalendarResourceTO> getDispatchCalendarResources(String clientId, String projectId, String usersFilter) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT DISTINCT t.id, t.firstname, t.lastname FROM ( SELECT DISTINCT gc.id, gc.firstname, gc.lastname FROM "
                + " glob_dispatchcall_log igdc JOIN glob_contact gc ON (igdc.techrefid = gc.id) "
                + "JOIN glob_project_personnel gpp ON (gpp.contact_id = gc.id) WHERE gpp.client_id = ").append(clientId).append(" AND gpp.show_dispatch = 'Y' AND gpp.active = 'Y' ");
        if (StringSupport.isNotNullAndNotEmpty(usersFilter) && !usersFilter.equals("null")) {
            if (!projectId.equals("-1")) {
                query.append(" AND ( gpp.PROJECT_ID IN ( ").append(projectId).append(",0)) ");
                query.append(" AND ( gc.id IN ( ").append(usersFilter).append(" )) ");
            } else {
                query.append(" AND ( gc.id IN ( ").append(usersFilter).append(" )) ");
            }
        } else {
            if (!projectId.equals("-1")) {
                query.append(" AND ( gpp.PROJECT_ID IN ( ").append(projectId).append(",0)) ");
            }
        }
        query.append(" ) t order by t.firstname");
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query.toString()).getResultList();
            List<CalendarResourceTO> data = objects.stream().map(p -> new CalendarResourceTO(StringSupport.getString(p[0]), StringSupport.emptyOnNull(p[1]) + " " + StringSupport.emptyOnNull(p[2]))).collect(Collectors.toList());
            return data;
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public List<CalendarResourceTO> getAllDispatchCalendarResources(GlobSheduleSearchDefParam filters) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT DISTINCT t.id, t.firstname, t.lastname FROM ( SELECT DISTINCT gc.id, gc.firstname, gc.lastname FROM "
                + " glob_project_personnel gpp JOIN glob_contact gc ON (gpp.contact_id = gc.id) JOIN glob_users gu ON (gc.id = gu.contactid) "
                + " WHERE gpp.client_id = ").append(filters.clientId).append(" AND gpp.show_dispatch = 'Y' AND gpp.active = 'Y' AND gu.active = 'Y' ");
        /*
            join: LEFT JOIN glob_project gp ON (gpp.project_id = gp.id)
            filter:  AND (gp.region_id = 130 OR gp.region_id is null)
        */ 
        if (StringSupport.isNotNullAndNotEmpty(filters.resourceFilter) && !filters.resourceFilter.equals("null")) {
            if (!filters.projectId.equals("-1")) {
                query.append(" AND ( gpp.PROJECT_ID IN ( ").append(filters.projectId).append(",0)) ");
                query.append(" AND ( gc.id IN ( ").append(filters.resourceFilter).append(" )) ");
            } else {
                query.append(" AND ( gc.id IN ( ").append(filters.resourceFilter).append(" )) ");
            }
        } else {
            if (!filters.projectId.equals("-1")) {
                query.append(" AND ( gpp.PROJECT_ID IN ( ").append(filters.projectId).append(",0)) ");
            }
            
            if (!filters.regionId.equals("-1")) {
                query.append(" AND ( gc.REGION_ID IN ( ").append(filters.regionId).append(",0)) ");
            }
        }
        
        if(filters.isEnableSentReports != null && filters.isEnableSentReports) {
            query.append(" AND gc.id NOT IN (SELECT DISTINCT gdc.techrefid FROM glob_dispatchcall_log gdc LEFT JOIN qa_sample_test qst ON (gdc.wo_id = qst.workorder_id) WHERE qst.active = 'Y' AND qst.from_mobile = 'Y') ");
        }
        
        query.append(" ) t order by t.firstname");
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query.toString()).getResultList();
            List<CalendarResourceTO> data = objects.stream().map(p -> new CalendarResourceTO(StringSupport.getString(p[0]), StringSupport.emptyOnNull(p[1]) + " " + StringSupport.emptyOnNull(p[2]))).collect(Collectors.toList());
            return data;
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
}
