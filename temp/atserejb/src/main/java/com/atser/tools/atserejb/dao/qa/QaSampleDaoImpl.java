/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.dao.glob.GlobProjectDao;
import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import com.atser.tools.atserejb.dao.glob.GlobLabsDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.dao.glob.GlobSystemPropertiesDao;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class QaSampleDaoImpl extends GenericDao<BigDecimal, QaSample> implements QaSampleDao, ISearchDao<QaSampleSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Inject
    private GlobLabsDao globLabsDao;

    @Inject
    private GlobSystemPropertiesDao globSystemPropertiesDao;

    @Override
    public Boolean existsSample(BigDecimal sampleId) {
        return existsSample(sampleId, Boolean.TRUE);
    }

    /**
     * status = TRUE - Fetch only Active status = FALSE - Fetch all
     * Active/Inactive
     *
     * @param sampleId
     * @param status
     * @return
     */
    @Override
    public Boolean existsSample(BigDecimal sampleId, Boolean status) {
        String query = "SELECT t.id FROM QA_SAMPLE t WHERE t.id = :sampleId ";
        if (status) {
            query += " AND t.active = 'Y'";
        }
        Query q = getEntityManager().createNativeQuery(query).setParameter("sampleId", sampleId);
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
    public Boolean existsConcMixDesign(BigInteger mixId) {
        String query = "SELECT t.id FROM QA_SAMPLE t,qaconc_mixdesigns a WHERE t.mix_design_id=a.id and t.mix_design_id = :mixId AND a.active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("mixId", mixId);
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
    public Boolean existsAspmMixDesign(BigInteger mixId) {
        String query = "SELECT t.id FROM QA_SAMPLE t,qaaspm_mixdesigns a WHERE t.mix_design_id=a.id and t.mix_design_id = :mixId AND a.active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("mixId", mixId);
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
    public String getSampleCategory(String clientId, String sampleNo) {
        String query = "SELECT c.name FROM qa_sample q, glob_project p, qa_sample_catg c WHERE q.project_id = p.id AND q.sample_catg_id = c.id AND p.client_id = :clientId AND q.sample_no = :sampleNo";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("sampleNo", sampleNo);
        try {
            return StringSupport.getString(q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public QaSample findBySampleNo(String sampleNo, BigInteger projectId) {
        String query = "SELECT s.* FROM qa_sample s WHERE s.project_id = :projectId AND s.sample_no = :sampleNo AND s.active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query, QaSample.class).setParameter("projectId", projectId).setParameter("sampleNo", sampleNo);
        try {
            return (QaSample) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            log.debug("@ERROR NonUniqueResultException.  QaSampleDaoImpl: " + sampleNo);
            return (QaSample) q.getResultList().get(0);
        }
    }

    @Override
    public void updateStatus(BigDecimal sampleId, String active) {
        String query = "UPDATE qa_sample t SET t.active = :status WHERE t.id = :sampleId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("status", active).setParameter("sampleId", sampleId);
        q.executeUpdate();
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    //@LatencyLogger
    public List<QaSampleSearchBO> getFrontEndSearchAllSampleInbox(QaSampleSearchDefParam filters) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2);
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            Map<String, String> systemProp = globSystemPropertiesDao.getSystemPropertiesByClient(NumberSupport.getBigInteger(filters.clientId));
            if (systemProp.isEmpty()) {
                return null;
            }
            return populateBO(objects, systemProp);
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    //@LatencyLogger
    public DataTableWrapper<QaSampleSearchBO> getFrontEndSearchSampleInbox(QaSampleSearchDefParam filters) {
        log.info("@track QaSampleSearchDefParam filters  ");
        // TailLine Definition
        String tailLine = buildFilters(filters);
        log.info("@track QaSampleSearchDefParam tailLine  {} ", tailLine);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        log.info("@track QaSampleSearchDefParam orderLine  {} ", orderLine);
        String orderLine2 = buildSort(filters, 2);
        log.info("@track QaSampleSearchDefParam orderLine2  {} ", orderLine2);
        String countQuery = buildCountQuery(filters, tailLine);
        log.info("@track QaSampleSearchDefParam countQuery  {} ", countQuery);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2, true);
        log.info("@track QaSampleSearchDefParam query  {} ", query);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            Map<String, String> systemProp = globSystemPropertiesDao.getSystemPropertiesByClient(NumberSupport.getBigInteger(filters.clientId));
            if (systemProp.isEmpty()) {
                return null;
            }
            List<QaSampleSearchBO> data = populateBO(objects, systemProp);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<QaSampleSearchBO> populateBO(List<Object[]> objects, Map<String, String> systemProp) {
        List<QaSampleSearchBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            QaSampleSearchBO p = new QaSampleSearchBO();
            p.setId(NumberSupport.getBigInteger(it[0]));
            p.setProjectNo(StringSupport.emptyOnNull(it[1]));
            p.setSampleNumber(StringSupport.emptyOnNull(it[2]));
            p.setRetest(StringSupport.emptyOnNull(it[3]));
            p.setWoNo(StringSupport.emptyOnNull(it[4]));
            p.setStatus(StringSupport.emptyOnNull(it[5]));
            p.setCategoryId(NumberSupport.getBigInteger(it[6]));
            p.setCategory(StringSupport.emptyOnNull(it[7]));
            p.setCategoryTitle(StringSupport.emptyOnNull(it[8]));
            p.setCategoryPageName(StringSupport.emptyOnNull(it[9]));
            p.setFieldUsr(StringSupport.emptyOnNull(it[10]));
            p.setCollectionDate(it[11] != null ? DateSupport.formatUS((Date) it[11]) : null);
            p.setActive(StringSupport.emptyOnNull(it[12]));
            p.setVersion(StringSupport.emptyOnNull(it[13]));
            p.setOfficeLocation(StringSupport.emptyOnNull(it[14]));
            p.setDeparmentId(NumberSupport.getBigInteger(it[15]));
            p.setProjectCode(StringSupport.emptyOnNull(it[16]));
            p.setItemNo(StringSupport.emptyOnNull(it[17]));
            p.setMaterial(StringSupport.emptyOnNull(it[18]));
            p.setSpecBookClass(StringSupport.emptyOnNull(it[19]));
            p.setTraceNo(StringSupport.emptyOnNull(it[20]));
            p.setLocationName(StringSupport.emptyOnNull(it[21]));
            p.setSupplierName(StringSupport.emptyOnNull(it[22]));
            p.setBinderSupplierName(StringSupport.emptyOnNull(it[23]));
            p.setCanbeInactived(StringSupport.emptyOnNull(it[24]));
            p.setSampleOf(StringSupport.emptyOnNull(it[25]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    /**
     * Build Count Query
     *
     * @param filters
     * @param tailLine
     * @return
     */
    @Override
    public String buildCountQuery(QaSampleSearchDefParam filters, String tailLine) {
        String query = "select ";
        String countOnly = "count(*) AS cnt ";
        String fromLine = " from qa_sample q, qa_sample_catg sc, glob_workorder o, glob_info i, glob_project p, glob_spec_book_item it, glob_spec_book_mat ma, glob_spec_book_class cl,  (select * from glob_client_sample_catg where client_id= " + filters.clientId + ") cc  ";
        String whereLine = " where q.info_id=i.id and q.wo_no=o.id(+) and q.sample_catg_id=sc.id and sc.id=cc.sample_catg_id(+) and p.id=i.project_id and p.client_id= " + filters.clientId + " ";
        if (filters.clientName.equals("massdot")) {
            fromLine += ", V_LAST_SAMPLE_LOCATION_RECORD r, glob_supplier gs, glob_supplier gbs ";
            whereLine += " and q.id = r.sample_id(+) AND q.supplier_id = gs.id(+) AND q.binder_supplier_id = gbs.id(+) ";
        }
        whereLine += " and p.active='Y' ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(QaSampleSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        return buildQuery(filters, tailLine, orderLine, orderLine2, false);
    }

    private String buildQuery(QaSampleSearchDefParam filters, String tailLine, String orderLine, String orderLine2, Boolean pagination) {
        String fieldLine = "q.id as id, p.p_number as project_no, q.sample_no as sample_no, q.retest as retest, o.wo_no as wo_no, q.status as status, sc.id as category_id, "
                + "sc.name as category, case when cc.sample_catg_title is not null then cc.sample_catg_title else sc.description end as category_title, sc.page_name as category_page_name, "
                + "q.fieldusr as fieldusr, q.collection_date, q.active as active, q.version as version, p.office_location, p.department_id, p.project_code, it.item_no, ma.material, cl.class, "
                + "q.trace_no ";
        String fromLine = " from qa_sample q, qa_sample_catg sc, glob_workorder o, glob_info i, glob_project p, glob_spec_book_item it, glob_spec_book_mat ma, glob_spec_book_class cl,  "
                + "(select * from glob_client_sample_catg where client_id= " + filters.clientId + ") cc  ";
        String whereLine = " where q.info_id=i.id and q.wo_no=o.id(+) and q.sample_catg_id=sc.id and sc.id=cc.sample_catg_id(+) and p.id=i.project_id and p.client_id= " + filters.clientId + " ";
        if (filters.clientName.equals("massdot")) {
            fieldLine += ", r.location_name as rec, gs.supplier, gbs.supplier as binder_supplier  ";
            fromLine += ", V_LAST_SAMPLE_LOCATION_RECORD r, glob_supplier gs, glob_supplier gbs ";
            whereLine += " AND q.id = r.sample_id(+) AND q.supplier_id = gs.id(+) AND q.binder_supplier_id = gbs.id(+)";
        } else {
            fieldLine += ", 0 as rec, null as supplier, null as binder_supplier";
        }
        fieldLine += ", (select case when count(id) > 0 then 'N' else 'Y' END from qa_sample_test where sample_id=q.id and active='Y') canbeinactivate, q.description as sampleof";
        whereLine += " and p.active='Y' ";
        if (pagination) {
            String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
            return wrapToServerSide(query, orderLine2, filters);
        } else {
            return "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        }
    }

    /**
     * Build Filters
     *
     * @param filters
     * @return
     */
    @Override
    public String buildFilters(QaSampleSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter 
        if (StringSupport.isNotNullAndNotEmpty(filters.functionId) && !filters.functionId.equals("-1")) {
            tailLineBuilder.append(" and i.function_id=' ").append(filters.functionId).append("'");
        }
        // Filter
        if (!filters.multiproject || (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1"))) {
            tailLineBuilder.append(" and (i.project_id = ").append(filters.projectId).append(") ");
        }
        if (filters.multiproject) {
            String filter_by_profile = globProjectDao.filterByProfile(" i.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
            if (!filter_by_profile.isEmpty()) {
                tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
            }
        } else {
            tailLineBuilder.append(" and ( i.lab_id = ").append(filters.labId).append(") ");
        }
        // Filter
        if (!filters.showInactive) {
            tailLineBuilder.append(" and q.active='Y' ");
        } else {
            tailLineBuilder.append(" and q.active='N' ");
        }
        // Filter filters.clientName.equals("massdot") && 
        if (StringSupport.isNotNullAndNotEmpty(filters.sampleRegionId) && !filters.sampleRegionId.equals("-1")) {
            tailLineBuilder.append(" and ( r.location_id = ").append(filters.sampleRegionId).append(") ");
        }
        // Filter filters.clientName.equals("gdot") && 
        if (StringSupport.isNotNullAndNotEmpty(filters.sampleMatCodeId) && !filters.sampleMatCodeId.equals("-1")) {
            tailLineBuilder.append(" and ( q.material_description = '").append(filters.sampleMatCodeId).append("') ");
        }
        // Filter filters.clientName.equals("gdot") && 
        if (StringSupport.isNotNullAndNotEmpty(filters.sampleRandomCode) && !filters.sampleRandomCode.equals("-1")) {
            tailLineBuilder.append(" and ( q.random_sample = '").append(filters.sampleRandomCode).append("') ");
        }
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.category) && !filters.category.equals("-1")) {
            tailLineBuilder.append(" and (sc.id='").append(filters.category).append("') ");
        }
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.labId)) {
            if (!filters.labId.equals("-1")) {
                tailLineBuilder.append(" and (i.lab_id = '").append(filters.labId).append("') ");
            } else {
                String filter_by_lab = globLabsDao.getLabFunctionFilterByUser(filters.userId, filters.clientId, filters.isAdmin, filters.projectId);
                tailLineBuilder.append(" and i.lab_id in ").append(filter_by_lab);
            }
        }
        // Filter
        if (!filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append(" and q.collection_date between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy') ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" and ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("fieldUsr")) {
                tailLineBuilder.append("(q.fieldusr like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("fieldUsr"))).append("%') ");
            }
            // Filter
            if (filters.dtMapSearch.containsKey("sampleNumber")) {
                tailLineBuilder.append(" or (q.sample_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("sampleNumber"))).append("%') ");
            }
            // Filter
            if (filters.usesWorkorder && filters.dtMapSearch.containsKey("woNo")) {
                tailLineBuilder.append(" or (o.wo_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("woNo"))).append("%') ");
            }
            // Filter
            if (filters.dtMapSearch.containsKey("traceNo")) {
                tailLineBuilder.append(" or (q.trace_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("traceNo"))).append("%') ");
            }
            // Filter
            if (filters.dtMapSearch.containsKey("specimenNo")) {
                tailLineBuilder.append(" or q.id in (select sample_id from qa_sample_specimens where specimen_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("specimenNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("supplierName")) {
                tailLineBuilder.append(" or lower(gs.supplier) like lower('%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("supplierName"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("binderSupplierName")) {
                tailLineBuilder.append(" or lower(gbs.supplier) like lower('%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("binderSupplierName"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("sampleOf")) {
                tailLineBuilder.append(" or lower(q.description) like lower('%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("sampleOf"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("assetNo")) {
                tailLineBuilder.append(" or q.id in (select sample_id from qa_sample_assets where asset_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("assetNo"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        tailLineBuilder.append(" and q.item_id = it.id(+) and q.mat_id = ma.id(+) and q.class_id = cl.id(+) ");
        return tailLineBuilder.toString();
    }

    /**
     * Build Sorts
     *
     * @param filters
     * @param level
     * @return
     */
    @Override
    public String buildSort(QaSampleSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by q.fieldusr ");
            } else {
                orderBuilder.append(" order by fieldusr ");
            }
            return orderBuilder.toString();
        }

        switch (filters.sortBy) {
            case "sampleNumber": {
                if (level == 1) {
                    orderBuilder.append(" order by lower(q.sample_no) ");
                } else {
                    orderBuilder.append(" order by lower(sample_no) ");
                }
                break;
            }
            case "collectionDate": {
                if (level == 1) {
                    orderBuilder.append(" order by q.collection_date ");
                } else {
                    orderBuilder.append(" order by collection_date ");
                }
                break;
            }
            case "categoryTitle": {
                if (level == 1) {
                    orderBuilder.append(" order by case when cc.sample_catg_title is not null then cc.sample_catg_title else sc.description end ");
                } else {
                    orderBuilder.append(" order by category_title ");
                }
                break;
            }
            case "fieldUsr": {
                if (level == 1) {
                    orderBuilder.append(" order by q.fieldusr ");
                } else {
                    orderBuilder.append(" order by fieldusr ");
                }
                break;
            }
            case "woNo": {
                if (level == 1) {
                    orderBuilder.append(" order by o.wo_no ");
                } else {
                    orderBuilder.append(" order by wo_no ");
                }
                break;
            }
            case "projectNo": {
                if (level == 1) {
                    orderBuilder.append(" order by p.p_number ");
                } else {
                    orderBuilder.append(" order by project_no ");
                }
                break;
            }
            case "specBookClass": {
                if (level == 1) {
                    orderBuilder.append(" order by it.item_no, ma.material, cl.class ");
                } else {
                    orderBuilder.append(" order by item_no, material, class ");
                }
                break;
            }
            case "traceNo": {
                if (level == 1) {
                    orderBuilder.append(" order by q.trace_no, lower(q.sample_no) ");
                } else {
                    orderBuilder.append(" order by trace_no, lower(sample_no) ");
                }
                break;
            }
            case "locationName": {
                if (level == 1) {
                    orderBuilder.append(" order by r.location_name ");
                } else {
                    orderBuilder.append(" order by rec ");
                }
                break;
            }
            case "supplierName": {
                if (level == 1) {
                    orderBuilder.append(" order by lower(gs.supplier) ");
                } else {
                    orderBuilder.append(" order by lower(supplier) ");
                }
                break;
            }
            case "binderSupplierName": {
                if (level == 1) {
                    orderBuilder.append(" order by lower(gbs.supplier) ");
                } else {
                    orderBuilder.append(" order by lower(binder_supplier) ");
                }
                break;
            }
            case "sampleOf": {
                if (level == 1) {
                    orderBuilder.append(" order by lower(q.description) ");
                } else {
                    orderBuilder.append(" order by lower(sampleof) ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by q.fieldusr ");
                } else {
                    orderBuilder.append(" order by fieldusr ");
                }
                break;
            }
        }
        orderBuilder.append(filters.sortDir);
        return orderBuilder.toString();
    }
}
