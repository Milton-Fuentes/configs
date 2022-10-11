/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobStakeholderGroup;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class GlobStakeholderGroupDaoImpl extends GenericDao<BigDecimal, GlobStakeholderGroup> implements GlobStakeholderGroupDao {

    @Override
    public List<GlobStakeholderGroup> getStakeholderListByClientId(BigInteger clientId) {
        String query = "SELECT * FROM GLOB_STAKEHOLDER WHERE CLIENT_ID = :cId AND ACTIVE = 1";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query).setParameter("cId", clientId).getResultList();
        List<GlobStakeholderGroup> stakeholders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populateBO(it);
        }).forEachOrdered((to) -> {
            stakeholders.add(to);
        });
        return stakeholders;
    }

    private GlobStakeholderGroup populateBO(Object it) {
        if (it == null) {
            return null;
        }
        Object[] item = (Object[]) it;
        GlobStakeholderGroup stakeholder = new GlobStakeholderGroup();
        stakeholder.setId(NumberSupport.getBigDecimal(item[0]));
        stakeholder.setClientId(NumberSupport.getBigInteger(item[1]));
        stakeholder.setName(StringSupport.emptyOnNull(item[2]));
        stakeholder.setDescription(StringSupport.emptyOnNull(item[3]));
        // stakeholder.setStatus(StringSupport.emptyOnNull(item[4]));
        // stakeholder.setMembersCant(StringSupport.emptyOnNull(item[5]));
        return stakeholder;
    }

}
