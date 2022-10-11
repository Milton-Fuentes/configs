/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestFailureLogBO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleTestAddInfoDaoImpl extends GenericDao<BigDecimal, QaSampleTestAddInfo> implements QaSampleTestAddInfoDao {

    @Override
    public QaSampleTestAddInfo findBySampleTestId(BigDecimal sampletestid) {
        try {
            return (QaSampleTestAddInfo) getEntityManager()
                    .createNamedQuery("QaSampleTestAddInfo.findBySampleTestId")
                    .setParameter("id", sampletestid)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public QaSampleTestAddInfo findByTestId(BigInteger sampletestid) {
        return findBySampleTestId(NumberSupport.getBigDecimal(sampletestid));
    }

    @Override
    public Boolean existsQaSampleTestAddInfo(BigDecimal sampletestid) {
        //  AND t.active = 'Y'
        String query = "SELECT t.id FROM qa_sample_test_add_info t WHERE t.sample_test_id = :sampleTestId";
        Query q = getEntityManager()
                .createNativeQuery(query)
                .setParameter("sampleTestId", sampletestid);
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
    public List<QaSampleTestFailureLogBO> getFailureLog(String projectId) {
        String query = "select t.id as sample_test_id,inf.project_id,p.name as project_name,p.p_number as project_number,p.p_name as project_description,wo.wo_no as work_order_no,clog.technician,clog.service_date,decode (ctm.report_title,'',tm.name,ctm.report_title) as test_name,ti.work_inspected,ti.material_under_requirements,ti.material_met_requirements, ti.observations"
                + " from qa_sample_test t,qa_test_methods tm,glob_client_test ctm,qa_sample_test_add_info ti,glob_project p,glob_contractor_contract inf,glob_workorder wo,glob_dispatchcall_log clog"
                + " where ti.sample_test_id=t.id and t.workorder_id=wo.id and t.test_id = tm.id and tm.id=ctm.test_id and wo.id=clog.wo_id and inf.id=t.info_id and inf.project_id=p.id and ctm.client_id=p.client_id  and (ti.work_inspected='N' or ti.material_under_requirements ='N' or ti.material_met_requirements='N')"
                + " and inf.project_id = :projectId";
        try {
            return populateBO(getEntityManager().createNativeQuery(query).setParameter("projectId", projectId).getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<QaSampleTestFailureLogBO> populateBO(List<Object[]> objects) {
        List<QaSampleTestFailureLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            QaSampleTestFailureLogBO p = new QaSampleTestFailureLogBO();
            p.setSampleTestId(NumberSupport.getBigInteger(it[0]));
            p.setProjectId(NumberSupport.getBigInteger(it[1]));
            p.setProjectName(StringSupport.emptyOnNull(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setProjectDescription(StringSupport.emptyOnNull(it[4]));
            p.setWorkOrderNo(StringSupport.emptyOnNull(it[5]));
            p.setTechnician(StringSupport.emptyOnNull(it[6]));
            p.setServiceDate(it[7] != null ? DateSupport.formatUS((Date) it[7]) : null);
            p.setTestName(StringSupport.emptyOnNull(it[8]));
            p.setWorkInspected(StringSupport.emptyOnNull(it[9]));
            p.setMaterialUnderRequirements(StringSupport.emptyOnNull(it[10]));
            p.setMaterialMetRequirements(StringSupport.emptyOnNull(it[11]));
            p.setObservations(StringSupport.emptyOnNull(it[12]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }
}
