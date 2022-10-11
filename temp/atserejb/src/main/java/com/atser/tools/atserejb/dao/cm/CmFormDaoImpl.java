/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmForm;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.cm.CmFormRFIBO;
import com.atser.tools.atserutil.objects.bo.cm.CmFormSubmittalBO;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class CmFormDaoImpl extends GenericDao<BigDecimal, CmForm> implements CmFormDao {

    @Override
    public List<DataSelectWrapper> getRFISelectList(BigInteger clientId) {
        String query = "SELECT cmf.id, gp.p_number, cmfd.varchar_2 FROM cm_form cmf "
                + "INNER JOIN cm_form_data cmfd ON (cmf.id=cmfd.cm_form_id) "
                + "INNER JOIN glob_contract gc ON (gc.id = cmf.contract_id) "
                + "INNER JOIN glob_project gp ON (gp.id = gc.project_id) "
                + "WHERE cmf.active = 'Y' AND cmfd.active = 'Y' AND cmfd.varchar_2 IS NOT NULL "
                + "AND cmf.form_type_id=69 AND cmf.bpm_process_done = 'N' AND gp.client_id = :clientId "
                + "ORDER BY gp.p_number, cmfd.varchar_2";
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

    @Override
    public List<DataSelectWrapper> getSubmittalSelectList(BigInteger clientId) {
        String query = "SELECT cmf.id, gp.p_number, cmfd.varchar_1 FROM cm_form cmf "
                + "INNER JOIN cm_form_data cmfd ON (cmf.id=cmfd.cm_form_id) "
                + "INNER JOIN glob_contract gc ON (gc.id = cmf.contract_id) "
                + "INNER JOIN glob_project gp ON (gp.id = gc.project_id) "
                + "WHERE cmf.active = 'Y' AND cmfd.active = 'Y' AND cmfd.varchar_1 IS NOT NULL "
                + "AND cmf.form_type_id=115 AND cmf.bpm_process_done = 'N' AND gp.client_id = :clientId "
                + "ORDER BY gp.p_number, cmfd.varchar_1";
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

    @Override
    public void setBpmProcessDone(BigInteger id, Character status) {
        String query = "UPDATE CM_FORM SET bpm_process_done = :status WHERE id = :id";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("id", id)
                .setParameter("status", status);
        q.executeUpdate();
    }

    @Override
    public CmFormRFIBO rfiFindById(String id) {
        String query = "SELECT cmf.id, cmfd.varchar_2, cmfd.varchar_14, cmfd.date_5, cmfd.radio_1, cmfd.varchar_6, cmfd.varchar_10, cmfd.text_1, cmfd.bool_1, cmfd.date_1, "
                + "cmfd.text_2, cmfd.radio_4, cmfd.date_3, cmfd.varchar_8, cmfd.varchar_7, cmfd.date_6, cmfd.date_4, cmfd.date_2, cmfd.radio_5, cmfd.bool_3, cmfd.text_4, cmfd.radio_8 "
                + "FROM cm_form cmf INNER JOIN cm_form_data cmfd ON (cmf.id=cmfd.cm_form_id) WHERE cmf.id = :id";
        try {
            CmFormRFIBO model = new CmFormRFIBO();
            Object[] dto = (Object[]) getEntityManager().createNativeQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            // populate
            model.setId(NumberSupport.getBigInteger(dto[0]));
            model.setRfiNo(StringSupport.emptyOnNull(dto[1]));
            model.setLocation(StringSupport.emptyOnNull(dto[2]));            
            model.setRfiDate(dto[3] != null ? DateSupport.formatUS((Date) dto[3]) : null);
            model.setGeneratedBy(StringSupport.emptyOnNull(dto[4]));
            model.setSpecNo(StringSupport.emptyOnNull(dto[5]));            
            model.setDrawNo(StringSupport.emptyOnNull(dto[6]));            
            model.setRfiQuestion(StringSupport.emptyOnNull(dto[7])); 
            model.setResponseCode(StringSupport.getActiveAsCharacter(StringSupport.getString(dto[8])));
            model.setDateResponseRequired(dto[9] != null ? DateSupport.formatUS((Date) dto[9]) : null);            
            model.setResponse(StringSupport.emptyOnNull(dto[10]));            
            model.setResponseBy(StringSupport.emptyOnNull(dto[11]));            
            model.setDateReceived(dto[12] != null ? DateSupport.formatUS((Date) dto[12]) : null);            
            model.setResponderName(StringSupport.emptyOnNull(dto[13]));            
            model.setResponderFirm(StringSupport.emptyOnNull(dto[14]));            
            model.setDateToDesignConsultant(dto[15] != null ? DateSupport.formatUS((Date) dto[15]) : null);            
            model.setDateFromDesignConsultant(dto[16] != null ? DateSupport.formatUS((Date) dto[16]) : null);            
            model.setDateResponded(dto[17] != null ? DateSupport.formatUS((Date) dto[17]) : null);            
            model.setReviewRequired(StringSupport.emptyOnNull(dto[18]));            
            model.setStatus(StringSupport.getActiveAsCharacter(StringSupport.getString(dto[19])));
            model.setResponseFinal(StringSupport.emptyOnNull(dto[20]));
            model.setSubmitTo(StringSupport.emptyOnNull(dto[21]));
            return model;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public CmFormSubmittalBO submittalsFindById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
