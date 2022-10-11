/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserejb.dao.mgmt.MgmtExcelDao;
import com.atser.tools.atserejb.model.MgmtExcel;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MgmtExcelServiceImpl implements MgmtExcelService, IBaseEJBException {

    @Inject
    private MgmtExcelDao dao;

    @Override
    public MgmtExcel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public MgmtExcel findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(MgmtExcel elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(MgmtExcel elem) {
        if (elem != null) {
            MgmtExcel model = findById(elem.getId());
            model.setName(elem.getName());
            model.setDescription(elem.getDescription());
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
    public List<MgmtExcel> findAll(List<SyncFusionSorted> sorted,String projectId) {
        return dao.findAll(sorted, projectId);
    }

    @Override
    public void saveMetaDataExcel(String id, Object data, SyncFusionEnvInfo envinfo) {
        if (data != null && id != null) {
            dao.saveMetaDataExcel(NumberSupport.getBigDecimal(id), data.toString(), envinfo);
        }
    }

    @Override
    public String getMetaData(String id) {
        MgmtExcel elem = dao.findById(NumberSupport.getBigDecimal(id));
        return elem.getData();
    }

    @Override
    public Map<String, Object> isOpen(String id) {
        MgmtExcel rd = findById(id);
        Map<String, Object> result = new HashMap<>();
        if (rd.getOpen() == 0) {
            result.put("open", Boolean.FALSE);
        } else {
            result.put("open", Boolean.TRUE);
            result.put("openby", rd.getOpenBy());
        }
        return result;
    }

    @Override
    public void setOpenExcel(String id, Object data, SyncFusionEnvInfo envinfo) {
        if (data != null && envinfo != null && id != null) {
            dao.setOpenExcel(NumberSupport.getBigDecimal(id), (data.toString().equals("true") ? Boolean.TRUE : Boolean.FALSE), envinfo);
        }
    }
}
