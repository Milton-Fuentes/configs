/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaconcMixDesignMcodeDao;
import com.atser.tools.atserejb.model.QaconcMixDesignMcode;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaconcMixDesignMcodeServiceImpl implements QaconcMixDesignMcodeService, IBaseEJBException {

    @Inject
    private QaconcMixDesignMcodeDao dao;

    @Override
    public QaconcMixDesignMcode findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcMixDesignMcode findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaconcMixDesignMcode elem) {
        if (elem != null) {
            if (elem.getMaterialId() == null || elem.getMaterialId().getId() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            if (!dao.exists(elem.getMixId(), elem.getMaterialId().getId().toBigInteger())) {
                elem.setCreated(new Date());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastMod(new Date());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setActive('Y');
                return dao.save(elem).getId().toBigInteger();
            } else {
                throwBaseException(Response.Status.CONFLICT, "This Material Code already exists.");
            }
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaconcMixDesignMcode elem) {
        if (elem != null) {
            QaconcMixDesignMcode model = findById(elem.getId());
            if (!model.equals(elem)) {
                if (!Objects.equals(model.getMaterialId().getId(), elem.getMaterialId().getId()) && dao.exists(elem.getMixId(), elem.getMaterialId().getId().toBigInteger())) {
                    throwBaseException(Response.Status.CONFLICT, "This Material Code already exists.");
                }
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
                if (model != null) {
                    dao.update(model);
                }
            }
        }
    }

    /**
     * Populate Parent
     *
     * @param model
     * @param elem
     * @return
     */
    private QaconcMixDesignMcode populate(QaconcMixDesignMcode model, QaconcMixDesignMcode elem) {
        model.setMaterialId(elem.getMaterialId());
        model.setDescription(elem.getDescription());
        model.setMcode(elem.getMcode());
        model.setMtype(elem.getMtype());
        model.setSpecGravity(elem.getSpecGravity());
        model.setPctAbsorption(elem.getPctAbsorption());
        model.setFf(elem.getFf());
        model.setSsize(elem.getSsize());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaconcMixDesignMcode> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaconcMixDesignMcode> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaconcMixDesignMcode> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaconcMixDesignMcode> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaconcMixDesignMcode> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void copyFromMix(ManageITHeader header, String fromMixId, String targetMixId) {
        if (StringSupport.isNullOrEmpty(fromMixId, targetMixId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<QaconcMixDesignMcode> matList = list(new ManageITBodyRequest(0, 0).filter("mixId", fromMixId).filter("deleted", 'N').filter("active", 'Y'));

        if (matList == null || matList.isEmpty()) {
            throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design has no materials assigned.");
        }

        matList.forEach(it -> {
            try {
                QaconcMixDesignMcode local = it.clone();
                local.setId(null);
                local.setMixId(NumberSupport.getBigInteger(targetMixId));
                local.setVersion(0);
                save(header, local);
            } catch (BaseException ex) {
                // Log Error. 
            }
        });
    }

}
