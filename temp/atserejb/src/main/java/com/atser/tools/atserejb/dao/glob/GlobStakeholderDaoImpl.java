/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobStakeholder;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class GlobStakeholderDaoImpl extends GenericDao<BigDecimal, GlobStakeholder> implements GlobStakeholderDao {

    @Override
    public List<GlobStakeholder> getStakeholderListByClientId(BigInteger clientId) {
        String query = "SELECT * FROM GLOB_STAKEHOLDER WHERE CLIENT_ID = :cId AND ACTIVE = 1";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query).setParameter("cId", clientId).getResultList();
        List<GlobStakeholder> stakeholders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populateBO(it);
        }).forEachOrdered((to) -> {
            stakeholders.add(to);
        });
        return stakeholders;
    }

    private GlobStakeholder populateBO(Object it) {
        if (it == null) {
            return null;
        }
        Object[] item = (Object[]) it;
        GlobStakeholder stakeholder = new GlobStakeholder();
        stakeholder.setId(NumberSupport.getBigDecimal(item[0]));
        stakeholder.setProjectId(NumberSupport.getBigInteger(item[10]));
        stakeholder.setFirstname(StringSupport.emptyOnNull(item[10]));
        stakeholder.setMiddlename(StringSupport.emptyOnNull(item[10]));
        stakeholder.setLastname(StringSupport.emptyOnNull(item[10]));
        stakeholder.setPhone(StringSupport.emptyOnNull(item[10]));
        stakeholder.setEmail(StringSupport.emptyOnNull(item[10]));
        // stakeholder.setActive(StringSupport.emptyOnNull(item[10]));
        stakeholder.setLastMod(StringSupport.emptyOnNull(item[10]));
        stakeholder.setLastModBy(StringSupport.emptyOnNull(item[10]));
        stakeholder.setLastModIp(StringSupport.emptyOnNull(item[10]));
        stakeholder.setCreateBy(StringSupport.emptyOnNull(item[10]));
        stakeholder.setCreateByIp(StringSupport.emptyOnNull(item[10]));
        //stakeholder.setCreateDate(item[15] != null ? DateSupport.formatUS((Date) item[15]) : null);
        stakeholder.setVersion(StringSupport.emptyOnNull(item[10]));
        stakeholder.setTitle(StringSupport.emptyOnNull(item[10]));
        stakeholder.setClientId(NumberSupport.getBigInteger(item[0]));
        return stakeholder;
    }

}
