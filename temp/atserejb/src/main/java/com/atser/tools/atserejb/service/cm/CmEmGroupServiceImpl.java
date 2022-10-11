/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmEmGroupDao;
import com.atser.tools.atserejb.model.CmEmGroup;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CmEmGroupServiceImpl implements CmEmGroupService, IBaseEJBException {

    @Inject
    private CmEmGroupDao dao;

    @Override
    public CmEmGroup findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public CmEmGroup findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void save(CmEmGroup elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(CmEmGroup elem) {
        if (elem != null) {
            CmEmGroup model = findById(elem.getId());
            /*model.set
            model.setName(elem.getName());
            model.setDescription(elem.getDescription());*/
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
         if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<CmEmGroup> findAll() {
        return dao.findAll();
    }

}
