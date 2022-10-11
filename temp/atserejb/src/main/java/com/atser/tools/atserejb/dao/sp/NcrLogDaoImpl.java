/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.objects.to.gateway.NcrLogTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NcrLogDaoImpl implements NcrLogDao {

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.1.0PU")
    EntityManager em;

    @Override
    public List<NcrLogTO> filter(String pNumber) {
        String query = "SELECT ncr_no,doc_controlno,ncr_date1,cm_location,ncr_descript,ncr_resol,target_close_date,checkbyname,"
                + "openby_sig_date, revbyname,rev_sig_date,ackbyname,appv_sig_date,closebyname,closeby_sig_date,review_status,ncr_status  "
                + "FROM vw_ncr t WHERE t.p_number=:pNumber order by id desc";

        List<Object[]> objects = em.createNativeQuery(query)
                .setParameter("pNumber", pNumber)
                .getResultList();
        return populateDataTO(objects);
    }

    private List<NcrLogTO> populateDataTO(List<Object[]> objects) {
        List<NcrLogTO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            NcrLogTO to = new NcrLogTO();
            to.setNcrNo(StringSupport.emptyOnNull(it[0]));
            to.setDocControlNo(StringSupport.emptyOnNull(it[1]));
            to.setOcurrenceDate(StringSupport.emptyOnNull(it[2]));
            to.setLocation(StringSupport.emptyOnNull(it[3]));
            to.setNcrDescription(StringSupport.emptyOnNull(it[4]));
            to.setNcrResolution(StringSupport.emptyOnNull(it[5]));
            to.setTargetClosingDate(StringSupport.emptyOnNull(it[6]));
            to.setCompletedBy(StringSupport.emptyOnNull(it[7]));
            to.setCompleteDate(StringSupport.emptyOnNull(it[8]));
            to.setIssuedBy(StringSupport.emptyOnNull(it[9]));
            to.setIssuedDate(StringSupport.emptyOnNull(it[10]));
            to.setAckdBy(StringSupport.emptyOnNull(it[11]));
            to.setAckdDate(StringSupport.emptyOnNull(it[12]));
            to.setClosedBy(StringSupport.emptyOnNull(it[13]));
            to.setClosedDate(StringSupport.emptyOnNull(it[14]));
            to.setWorkflowStatus(StringSupport.emptyOnNull(it[15]));
            to.setNcrStatus(StringSupport.emptyOnNull(it[16]));
            return to;
        }).forEachOrdered((to) -> {
            list.add(to);
        });

        return list;
    }

}
