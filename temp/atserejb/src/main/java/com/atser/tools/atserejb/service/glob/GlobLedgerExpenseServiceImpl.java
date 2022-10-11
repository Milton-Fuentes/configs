/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.GlobLedgerExpense;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import com.atser.tools.atserejb.dao.glob.GlobLedgerExpenseDao;
import com.atser.tools.atserejb.model.GlobLedgerV1;

@Stateless
@Slf4j
public class GlobLedgerExpenseServiceImpl implements GlobLedgerExpenseService, IBaseEJBException {

    @Inject
    private GlobLedgerExpenseDao dao;

    @Inject
    private GlobLedgerV1Service globLedgerService;

    @Override
    public GlobLedgerExpense findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLedgerExpense findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobLedgerExpense elem) {
        if (elem != null) {
           // GlobLedger ledger = globLedgerService.findById(elem.getExpenseOperation().getId());
            if (elem.getOperationId() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
           // elem.setExpenseOperation(ledger);
            return dao.save(elem).getId();

        }
        return BigDecimal.ZERO;
    }

    @Override
    // @UpdateMethod
    public void update(ManageITHeader header, GlobLedgerExpense elem) {
        if (elem != null) {
            GlobLedgerExpense model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobLedgerExpense populate(GlobLedgerExpense model, GlobLedgerExpense elem) {
        model.setDescription(elem.getDescription());
        model.setAmount(elem.getAmount());
        model.setMiles(elem.getMiles());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());

        this.calculateExpense(model);
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobLedgerExpense> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobLedgerExpense> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobLedgerExpense> finalList = list(request);
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
    public DataGridWrapper<GlobLedgerExpense> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
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
    public void calculateExpense(GlobLedgerExpense model) {
        model.setExpense(BigDecimal.ZERO);
        if (model.getAmount() != null) {
            model.setExpense(model.getAmount());
        } else if (model.getMiles() != null) {
            model.setExpense(model.getMiles().multiply(new BigDecimal("0.45")));
        }
    }
}
