/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.BpmProcess;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class BpmProcessDaoImpl extends GenericDao<BigDecimal, BpmProcess> implements BpmProcessDao {

    @Override
    public BpmProcess findByCode(String code) {
        return (BpmProcess) getEntityManager().createNativeQuery("select * from bpm_process where code = :c", BpmProcess.class)
                .setParameter("c", code)
                .getSingleResult();
    }

}
