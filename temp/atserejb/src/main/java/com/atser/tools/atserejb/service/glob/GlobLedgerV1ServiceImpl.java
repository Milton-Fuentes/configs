/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.GlobLedgerV1;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
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
import com.atser.tools.atserejb.dao.glob.GlobLedgerDao;
import java.math.BigInteger;

@Stateless
@Slf4j
public class GlobLedgerV1ServiceImpl implements GlobLedgerV1Service, IBaseEJBException {

    private final String rootFolderName = "Ledger";
    @Inject
    private GlobLedgerDao dao;
    @Inject
    private GlobLedgerExpenseService globLedgerExpenseService;
    @Inject
    private GlobFolderService folderService;

    @Override
    public GlobLedgerV1 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLedgerV1 findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobLedgerV1 findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLedgerV1 findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobLedgerV1 elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header, elem);
                if (fId != null) {
                    elem.setFolderId(fId);
                    dao.update(elem);
                }
            }
            return elem;
        }
    }

// Review This Method
    private BigDecimal createFolderStruct(ManageITHeader header, GlobLedgerV1 elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger cId = new BigInteger(header.getClientid());
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());

        // Create Root Folder
        BigDecimal rootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId().toString(), rootFolderName);
        if (rootFolderId == null) {
            return null; // Do something
        }
        BigDecimal catgRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId().toString(), "Ledger", rootFolderId.toBigInteger());
        if (catgRootFolderId == null) {
            catgRootFolderId = folderService.createTrackITFolder(rootFolderId, elem.getProjectId().toBigInteger(), owner, BigInteger.ZERO, 'Y', "Y", 'N', "ledger", new BigInteger("2"));
        }
        return catgRootFolderId;
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobLedgerV1 elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getProjectId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
            }
            elem.setClientId(new BigDecimal(header.getClientid()));
            calculate(elem);
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobLedgerV1 elem) {
        if (elem != null) {
            GlobLedgerV1 model = findById(elem.getId());
            calculate(elem);
            if (!elem.equals(model)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobLedgerV1 populate(GlobLedgerV1 model, GlobLedgerV1 elem) {
        model.setInspectorId(elem.getInspectorId());
        model.setOperationDate(elem.getOperationDate());
        model.setDescription(elem.getDescription());
        model.setAccount(elem.getAccount());
        model.setIncome(elem.getIncome());
        model.setFolderId(elem.getFolderId());
        model.setExpense(elem.getExpense());
        model.setMiles(elem.getMiles());
        model.setMileageExpense(elem.getMileageExpense());
        model.setTotalExpense(elem.getTotalExpense());
        model.setBalance(elem.getBalance());
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
    public List<GlobLedgerV1> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobLedgerV1> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobLedgerV1> finalList = list(request);
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
    public DataGridWrapper<GlobLedgerV1> dataGridList(ManageITBodyRequest request) {
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
    public void changeStatus(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobLedgerV1 model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    private void calculate(GlobLedgerV1 elem) {

        BigDecimal incomes = BigDecimal.ZERO;
        BigDecimal expenses = BigDecimal.ZERO;
        BigDecimal mileage = BigDecimal.ZERO;
        BigDecimal mileageExpense = BigDecimal.ZERO;

        if (elem.getExpense() != null) {
            expenses = elem.getExpense();
        }
        if (elem.getMiles() != null) {
            mileage = elem.getMiles();
            mileageExpense = mileage.multiply(new BigDecimal("0.45"));
        }
        if (elem.getIncome() != null) {
            incomes = elem.getIncome();
        }

        elem.setIncome(incomes);
        elem.setExpense(expenses);
        elem.setMiles(mileage);
        elem.setMileageExpense(mileageExpense);
        elem.setTotalExpense(expenses.add(mileageExpense));
        elem.setBalance(incomes.subtract(expenses));
    }

}
