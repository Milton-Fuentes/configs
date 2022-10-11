/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmBiditItemMasterDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.CmBiditItemMaster;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class CmBiditItemMasterServiceImpl implements CmBiditItemMasterService, IBaseEJBException {

    @Inject
    private CmBiditItemMasterDao dao;
    
    @Override
    public CmBiditItemMaster findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditItemMaster findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditItemMaster elem) {
        if (elem != null) {
            if (elem.getParentId() != null && elem.getParentId().compareTo(NumberSupport.getBigInteger("-1")) == 0) {
                elem.setParentId(null);
            }
            BigDecimal dbId = dao.save(elem).getId();
            if (elem.getParentId() != null) {
                dao.setParent(elem.getParentId());
            }
            return dbId;
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, CmBiditItemMaster elem) {
        if (elem != null) {
            CmBiditItemMaster model = findById(elem.getId());
            if (!model.equals(elem)) {
                BigInteger currentParentId = model.getParentId();
                dao.update(populate(model, elem));
                if (elem.getParentId() != null) {
                    dao.setParent(currentParentId);
                    dao.setParent(elem.getParentId());
                }
            }
        }
    }

    private CmBiditItemMaster populate(CmBiditItemMaster model, CmBiditItemMaster elem) {
        if (elem.getParentId() != null && elem.getParentId().compareTo(NumberSupport.getBigInteger("-1")) == 0) {
            model.setParentId(null);
        } else {
            model.setParentId(elem.getParentId());
        }
        model.setItemNo(elem.getItemNo());
        model.setCategory(elem.getCategory());
        model.setSpecNo(elem.getSpecNo());
        model.setDescription(elem.getDescription());
        model.setUnit(elem.getUnit());
        model.setItemType(elem.getItemType());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditItemMaster elem = findById(id);
        if (elem != null) {
            if (elem.getIsParent() && dao.hasChilds(elem.getId().toBigInteger())) {
                dao.deleteChilds(id.toBigInteger());
                dao.delete(elem);
            } else {
                dao.delete(elem);
                dao.clearAndFlushSession();
                if (elem.getParentId() != null) {
                    dao.setParent(elem.getParentId());
                }
            }
        }
    }

    @Override
    public List<CmBiditItemMaster> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<CmBiditItemMaster> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataGridWrapper<CmBiditItemMaster> dataTreeGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Optional<Object[]> matchParentId = request.getFilter().stream().filter(p -> ((ManageITFilter<Object>) p).getField().equals("parentId")).findFirst();
            if (!matchParentId.isPresent()) {
                request.filter("parentId", "null");
            }
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<CmBiditItemMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditItemMaster> finalList = list(request);
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
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditItemMaster model = findById(request.getParams().get("id").toString());
        if (model != null) {
            model.setActive(StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status"))));
            dao.update(model);
        }
    }

    @Override
    public Boolean hasChilds(BigInteger parentId) {
        if (parentId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.hasChilds(parentId);
    }

}
