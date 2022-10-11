/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchCalllogSpecimenTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobDispatchcallLogDaoImpl extends GenericDao<BigDecimal, GlobDispatchcallLog> implements GlobDispatchcallLogDao {

    @Override
    public List<GlobDispatchcallLog> findByRequestOrigID(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobDispatchcallLog> array = getEntityManager().createNamedQuery("GlobDispatchcallLog.findByRequestOrigID")
                    .setParameter("requestOrigId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobDispatchcallLog> findByProjectID(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobDispatchcallLog> array = getEntityManager().createNamedQuery("GlobDispatchcallLog.findByProjectIDAndNotCancelled")
                    .setParameter("projectId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public GlobDispatchcallLog findByWOID(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            GlobDispatchcallLog object = (GlobDispatchcallLog) getEntityManager().createNamedQuery("GlobDispatchcallLog.findByWoId")
                    .setParameter("woId", new BigDecimal(id))
                    .getSingleResult();
            return object;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<DispatchCalllogSpecimenTO> findBySpecimenList(String specList) {
        String query = "SELECT dcl.id dcl_id, sp.specimen_no specimen_no FROM qa_sample_specimens sp, qa_sample s, glob_workorder wo, glob_dispatchcall_log dcl "
                + "WHERE sp.sample_id = s.id AND s.wo_no = wo.id AND dcl.wo_id = wo.id AND sp.id IN ( " + StringSupport.sanitizeStringForSql(specList) + " )";
        Query q = getEntityManager().createNativeQuery(query);
        try {
            List<Object[]> objects = q.getResultList();
            return objects.stream().map(p -> new DispatchCalllogSpecimenTO(NumberSupport.getBigDecimal(p[0]), StringSupport.emptyOnNull(p[1]))).collect(Collectors.toList());
        } catch(NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<DataSelectWrapper> getDispatchSelectList(BigInteger clientId) {
        String query = "SELECT calllog.id, gp.p_number, gw.wo_no FROM glob_dispatchcall_log calllog "
                + "INNER JOIN glob_project gp ON calllog.project_id = gp.id "
                + "LEFT JOIN glob_workorder gw ON calllog.wo_id = gw.id "
                + "WHERE gp.active='Y' AND gw.active = 'Y' AND gw.cancelled IS NOT NULL "
                + "AND gw.wo_no IS NOT NULL AND (gw.cancelled = 'No') AND (gw.wo_completed = 'N') "
                + "AND gp.client_id = :clientId ORDER BY calllog.id, gp.p_number";
        try {
            final Function<Object[], DataSelectWrapper> populate = p -> new DataSelectWrapper(StringSupport.getString(p[0]), "[" + StringSupport.getString(p[1]) + "] " + StringSupport.getString(p[2]));
            List<Object[]> objects = getEntityManager().createNativeQuery(query)
                    .setParameter("clientId", clientId)
                    .getResultList();
            List<DataSelectWrapper> data = objects.stream().map(populate).collect(Collectors.toList());
            return data;
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
}
