/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmPersoninfo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class CmPersoninfoDaoImpl extends GenericDao<BigDecimal, CmPersoninfo> implements CmPersoninfoDao {
    
    @Override
    public List<Object[]> getCmTitles(BigInteger clientId) {
        String query = "SELECT t.id, CASE WHEN(ct.roles_title IS NULL OR ct.roles_title='') THEN t.role_name ELSE ct.roles_title END AS name FROM cm_personinfo_type t, glob_client_cm_personinfo_type ct WHERE t.id=ct.personinfo_type_id AND ct.client_id=:clientId ORDER BY name";
        try {
            return getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Object[]> getCmFirm(BigInteger clientId) {
        String query = "SELECT firm_type, name from ( SELECT (select name from glob_client where id=:clientId) as name, 'Default' as firm_type FROM cm_management_firm  UNION SELECT name, 'Default' as firm_type FROM cm_management_firm where name = (select name from glob_client where id=:clientId) and client_id = :clientId UNION SELECT name, 'Default' as firm_type FROM cm_management_firm where name != (select name from glob_client where id=:clientId) and client_id = :clientId ) order by name";
        try {
            List<Object[]> mainList = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).getResultList();
            mainList.addAll(buildCmFirmLevels(clientId));
            return mainList;
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<Object[]> buildCmFirmLevels(BigInteger clientId) {
        List<Object[]> resultList = new ArrayList<>();
        List<Object[]> titleList = getCmTitles(clientId);
        if (titleList != null && !titleList.isEmpty()) {
            Predicate<Object[]> isContractor = p -> p[1].equals("Contractor") || p[1].equals("Senior Project Manager") || p[1].equals("Contractor Project Manager") || p[1].equals("Asst. Project Manager") || p[1].equals("Superintendent") || p[1].equals("Asst. Superintendent");
            Predicate<Object[]> isDesgEng = p -> p[1].equals("Consultant") || p[1].equals("Lead Consultant") || p[1].equals("Sub Consultant") || p[1].equals("Consultant Inspector");
            Predicate<Object[]> isLab = p -> p[1].equals("Lab") || p[1].equals("CMT");
            Predicate<Object[]> isAgency = p -> p[1].equals("Agency");
            Predicate<Object[]> isUtility = p -> p[1].equals("Utility");

            resultList.addAll(performQueryAndReplace(titleList, clientId, isContractor, "SELECT 'rps' as firm_type, name FROM glob_contractor WHERE client_id=:clientId"));
            resultList.addAll(performQueryAndReplace(titleList, clientId, isDesgEng, "SELECT 'rps' as firm_type, name FROM cm_desg_eng WHERE client_id=:clientId"));
            resultList.addAll(performQueryAndReplace(titleList, clientId, isLab, "SELECT 'rps' as firm_type, name FROM cm_lab WHERE client_id=:clientId"));
            resultList.addAll(performQueryAndReplace(titleList, clientId, isAgency, "SELECT 'rps' as firm_type, name FROM cm_agency_firm WHERE client_id=:clientId"));
            resultList.addAll(performQueryAndReplace(titleList, clientId, isUtility, "SELECT 'rps' as firm_type, name FROM cm_util_firm WHERE client_id=:clientId"));
        }
        return resultList;
    }

    private List<Object[]> performQueryAndReplace(List<Object[]> titleList, BigInteger clientId, Predicate<Object[]> predicate, String query) {
        List<Object[]> resultList = new ArrayList<>();
        List<Object[]> matchItems = titleList.stream().filter(predicate).collect(Collectors.toList());
        if (matchItems != null && !matchItems.isEmpty()) {
            try {
                List<Object[]> results = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).getResultList();
                matchItems.forEach(it -> {
                    resultList.addAll(results.stream().map(o -> new Object[]{it[1], o[1]}).collect(Collectors.toList()));
                });
            } catch (NoResultException ex) {
                System.out.println("Not Found : " + query);
            }
        }
        return resultList;
    }
    
    //--------------------------------------------------------------------------
    

}
