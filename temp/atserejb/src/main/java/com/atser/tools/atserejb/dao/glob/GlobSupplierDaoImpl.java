/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless
public class GlobSupplierDaoImpl extends GenericDao<BigDecimal, GlobSupplier> implements GlobSupplierDao {

    @Override
    public GlobSupplier findByImpCode(String code) {
        Query q = getEntityManager()
                .createNamedQuery("GlobSupplier.findByImpCode")
                .setParameter("impCode", code);
        try {
            return (GlobSupplier) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            System.out.println("@ERROR NonUniqueResultException.  GlobSupplierDaoImpl: " + code);
            return (GlobSupplier) q.getResultList().get(0);
        }
    }

    @Override
    public List<GlobSupplier> filterByMaterialType(BigInteger clientId, String materialType) {
        String query = "SELECT t.* FROM glob_supplier t, (SELECT a.id, a.name as code, decode(b.sample_catg_title,null,a.description,b.sample_catg_title) catg FROM qa_sample_catg a, glob_client_sample_catg b\n"
                + "WHERE b.sample_catg_id(+)= a.id AND b.client_id(+)=:clientId) m where t.service = m.catg and m.code = :matType and t.enabled = 'Y' AND t.client_id = :clientId ORDER BY supplier ASC";
        Query q = getEntityManager().createNativeQuery(query, GlobSupplier.class).setParameter("clientId", clientId).setParameter("matType", materialType);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobSupplier> filterByMaterialTypeAndProject(BigInteger clientId, BigInteger projectId, String materialType) {
        String query = "SELECT t.* FROM glob_supplier t, glob_project_supplier ps, (SELECT a.id, a.name as code, decode(b.sample_catg_title,null,a.description,b.sample_catg_title) catg FROM qa_sample_catg a, glob_client_sample_catg b\n"
                + "WHERE b.sample_catg_id(+)= a.id AND b.client_id(+)=:clientId) m where t.service = m.catg and ps.supplier_id = t.id and m.code = :matType and t.enabled = 'Y' AND t.client_id = :clientId and ps.project_id = :projectId ORDER BY supplier ASC";
        Query q = getEntityManager().createNativeQuery(query, GlobSupplier.class).setParameter("clientId", clientId).setParameter("projectId", projectId).setParameter("matType", materialType);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobSupplier> filterSupplierByProject(BigInteger clientId, BigInteger projectId) {
        String query = "SELECT t.* FROM glob_supplier t, glob_project_supplier ps where ps.supplier_id = t.id and t.enabled = 'Y' AND t.client_id = :clientId and ps.project_id = :projectId ORDER BY supplier ASC";
        Query q = getEntityManager().createNativeQuery(query, GlobSupplier.class).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType, BigDecimal supplierId) {
        String query = "SELECT gs.supplier, gsa.location, gsa.id as locationId FROM (SELECT t.* FROM glob_supplier t, (SELECT a.id, a.name as code, decode(b.sample_catg_title,null,a.description,b.sample_catg_title) catg FROM qa_sample_catg a, glob_client_sample_catg b \n"
                + "WHERE b.sample_catg_id(+)= a.id AND b.client_id(+)=:clientId) m where t.service = m.catg and m.code = :matType and t.enabled = 'Y' AND t.client_id = :clientId ORDER BY supplier ASC) gs, glob_supplier_address gsa \n"
                + "WHERE gs.id = gsa.supplier_id AND gsa.active = 'Y' AND gsa.enabled = 'Y' AND gs.id = :supplierId";
        try {
            return getEntityManager().createNativeQuery(query)
                    .setParameter("clientId", clientId)
                    .setParameter("matType", materialType)
                    .setParameter("supplierId", supplierId)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType) {
        String query = "SELECT gs.supplier, gsa.location, gsa.id as locationId FROM (SELECT t.* FROM glob_supplier t, (SELECT a.id, a.name as code, decode(b.sample_catg_title,null,a.description,b.sample_catg_title) catg FROM qa_sample_catg a, glob_client_sample_catg b \n"
                + "WHERE b.sample_catg_id(+)= a.id AND b.client_id(+)=:clientId) m where t.service = m.catg and m.code = :matType and t.enabled = 'Y' AND t.client_id = :clientId ORDER BY supplier ASC) gs, glob_supplier_address gsa \n"
                + "WHERE gs.id = gsa.supplier_id AND gsa.active = 'Y' AND gsa.enabled = 'Y'";
        try {
            return getEntityManager().createNativeQuery(query)
                    .setParameter("clientId", clientId)
                    .setParameter("matType", materialType)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobSupplier> filterBinderSupplierByProject(BigInteger clientId, BigInteger projectId) {
        String query = "SELECT t.* FROM glob_supplier t JOIN glob_binder_supplier bs ON (t.id = bs.supplier_id) JOIN glob_prj_binder_supplier pbs ON (bs.id = pbs.binder_supplier_id) WHERE pbs.project_id = :projectId AND t.client_id = :clientId ORDER BY supplier ASC";
        Query q = getEntityManager().createNativeQuery(query, GlobSupplier.class).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobSupplierTO> listSupplierAndLocation(BigInteger clientId) {
        String query = "select"
                + " s.service s_service, s.supplier s_supplier, s.location s_location, s.contact_name s_contact_name, s.contact_title s_contact_title, s.email s_email, s.phone s_phone, s.cell s_cell, s.due_date s_due_date,"
                + " a.address a_address, a.city a_city, a.state a_state, a.zip a_zip, a.location a_location"
                + " from glob_supplier s, (select * from glob_supplier_address  where active = 'Y') a"
                + " where s.id = a.supplier_id(+) and s.enabled = 'Y' and s.active = 'Y' and s.client_id = :clientId"
                + " order by s.supplier, s.service";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
        try {
            List<Object[]> result = q.getResultList();
            return populateGlobSupplierTO(result);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobSupplierTO> populateGlobSupplierTO(List<Object[]> objects) {
        List<GlobSupplierTO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobSupplierTO obj = new GlobSupplierTO();
            obj.setService(StringSupport.emptyOnNull(it[0]));
            obj.setSupplier(StringSupport.emptyOnNull(it[1]));
            obj.setLocation(StringSupport.emptyOnNull(it[2]));
            obj.setContactName(StringSupport.emptyOnNull(it[3]));
            obj.setContactTitle(StringSupport.emptyOnNull(it[4]));
            obj.setEmail(StringSupport.emptyOnNull(it[5]));
            obj.setPhone(StringSupport.emptyOnNull(it[6]));
            obj.setCell(StringSupport.emptyOnNull(it[7]));
            obj.setDueDate(it[8] != null ? DateSupport.formatUS((Date) it[8]) : null);
            obj.setAddress(StringSupport.emptyOnNull(it[9]));
            obj.setCity(StringSupport.emptyOnNull(it[10]));
            obj.setZip(StringSupport.emptyOnNull(it[11]));
            return obj;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }
}
