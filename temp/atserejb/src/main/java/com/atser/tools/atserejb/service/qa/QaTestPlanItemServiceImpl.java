/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTestPlanItemDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.QaTestPlanItem;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class QaTestPlanItemServiceImpl implements QaTestPlanItemService, IBaseEJBException {

    @Inject
    private QaTestPlanItemDao dao;

    @Override
    public QaTestPlanItem findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaTestPlanItem findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigInteger save(QaTestPlanItem elem) {
        if (elem != null) {
            elem.setActive('Y');
            elem.setVersion("1");
            return dao.save(elem).getId().toBigInteger();
        }
        return null;
    }

    @Override
    @UpdateMethod
    public void update(QaTestPlanItem elem) {
        if (elem != null) {
            QaTestPlanItem model = findById(elem.getId());
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
    public List<QaTestPlanItem> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public BigDecimal existItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId) {
        if (testplanId == null || itemId == null) {
            log.error("@Atser - existItemByTestplanIdAndItemNo: testplanId or itemId is null", testplanId, itemId);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.existItemByTestplanIdAndItemId(testplanId, itemId);
    }

    @Override
    public BigDecimal existItemByTestplanIdAndItemIdUnderStandardItemNo(BigInteger testplanId, BigInteger itemId, String itemNo) {
        if (testplanId == null || itemId == null || StringSupport.isNullOrEmpty(itemNo)) {
            log.error("@Atser - existItemByTestplanIdAndItemNo: testplanId or itemId is null", testplanId, itemId);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        if (StringSupport.isNullOrEmpty(itemNo)) {
            log.error("@Atser - existItemByTestplanIdAndItemNo: itemNo", itemNo);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.existItemByTestplanIdAndItemIdUnderStandardItemNo(testplanId, itemId, itemNo);
    }

    @Override
    public BigDecimal existWbsItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId) {
        if (testplanId == null || itemId == null) {
            log.error("@Atser - existWbsItemByTestplanIdAndItemId: testplanId or Id is null", testplanId, itemId);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.existWbsItemByTestplanIdAndItemId(testplanId, itemId);
    }

    @Override
    public BigDecimal existWbsItemByTestplanIdAndItemNo(BigInteger testplanId, String itemNo) {
        if (testplanId == null || itemNo == null) {
            log.error("@Atser - existWbsItemByTestplanIdAndItemNo: testplanId or itemNo is null", testplanId, itemNo);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.existWbsItemByTestplanIdAndItemNo(testplanId, itemNo);
    }

    @Override
    public void batchSaveItemFromBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId) {
        dao.batchSaveItemFromBiditemMaster(clientId, testplanId, itemId, createdBy, lastmodBy, itemStatusType, wbsId);
    }

    @Override
    public void batchSaveSubItemFromSubBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId) {
        dao.batchSaveSubItemFromSubBiditemMaster(clientId, testplanId, itemId, createdBy, lastmodBy, itemStatusType, wbsId);
    }

    @Override
    public void batchUpdateItem(QaTestPlanItem elem) {
        if (elem != null && (elem.getPlanQty() != null || elem.getEstmQty() != null || elem.getTodateQty() != null)) {
            dao.batchUpdateItem(elem);
        }
    }

    @Override
    public void batchUpdateWbsItem(QaTestPlanItem elem) {
        if (elem != null && (elem.getPlanQty() != null || elem.getEstmQty() != null || elem.getTodateQty() != null)) {
            dao.batchUpdateWbsItem(elem);
        }
    }

    @Override
    public void batchUpdateIncreaseVersion(QaTestPlanItem elem) {
        if (elem != null) {
            elem.setVersion(String.valueOf(Integer.valueOf(elem.getVersion()) + 1));
            dao.update(elem);
        }
    }

    @Override
    public void updateWbsId(BigInteger itemId) {
        if (itemId == null || StringSupport.isNullOrEmpty(itemId)) {
            log.error("@Atser - updateWbsId: itemId is null", itemId);
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.updateWbsId(itemId);
    }

}
