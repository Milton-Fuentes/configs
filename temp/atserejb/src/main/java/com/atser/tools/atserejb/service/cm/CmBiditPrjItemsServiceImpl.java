/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmBiditPrjItemsDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.CmBiditPrjItems;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.CmBiditItemMaster;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author mdelabat
 */
@Stateless
@Slf4j
public class CmBiditPrjItemsServiceImpl implements CmBiditPrjItemsService, IBaseEJBException {

    @Inject
    private CmBiditPrjItemsDao dao;

    @Inject
    private CmBiditItemMasterService cmBiditItemMasterService;

    @Inject
    private CmBiditPrjCatgService cmBiditPrjCatgService;

    @Override
    public CmBiditPrjItems findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditPrjItems findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditPrjItems elem) {
        if (elem != null) {
            if (elem.getParentId() != null && elem.getParentId().compareTo(NumberSupport.getBigInteger("-1")) == 0) {
                elem.setParentId(null);
            }
            if (elem.getIsQtyEditable() == null || elem.getIsQtyEditable() == false) {
                elem.setIsQtyEditable(Boolean.TRUE);
                elem.setDefaultQty(null);
            } else {
                elem.setIsQtyEditable(Boolean.FALSE);
            }
            elem.setIsParent(false);
            CmBiditPrjCatg biditPrjCatg = cmBiditPrjCatgService.findById(elem.getPrjCatgId().toString());
            if (biditPrjCatg == null) {
                log.error("BidIT Project Category Id not found: " + elem.getPrjCatgId().toString());
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
            }
            elem.setItemAddendumRev(biditPrjCatg.getBidAddendumRev());
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
    public void update(ManageITHeader header, CmBiditPrjItems elem) {
        if (elem != null) {
            CmBiditPrjItems model = findById(elem.getId());
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

    private CmBiditPrjItems populate(CmBiditPrjItems model, CmBiditPrjItems elem) {
        CmBiditPrjCatg biditPrjCatg = cmBiditPrjCatgService.findById(elem.getPrjCatgId().toString());
        if (biditPrjCatg == null) {
            log.error("BidIT Project Category Id not found: " + elem.getPrjCatgId().toString());
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
        }
        model.setItemAddendumRev(biditPrjCatg.getBidAddendumRev());
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
        if (elem.getIsQtyEditable() == null || elem.getIsQtyEditable() == false) {
            model.setIsQtyEditable(Boolean.TRUE);
            model.setDefaultQty(null);
        } else {
            model.setIsQtyEditable(Boolean.FALSE);
            model.setDefaultQty(elem.getDefaultQty());
        }
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
        CmBiditPrjItems elem = findById(id);
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
    public List<CmBiditPrjItems> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<CmBiditPrjItems> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditPrjItems> finalList = list(request);
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
    public DataGridWrapper<CmBiditPrjItems> dataGridList(ManageITBodyRequest request) {
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
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditPrjItems model = findById(request.getParams().get("id").toString());
        if (model != null) {
            model.setActive(StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status"))));
            dao.update(model);
        }
    }

    @Override
    public DataGridWrapper<CmBiditPrjItems> dataTreeGridList(ManageITBodyRequest request) {
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
    public void copyItemFromMaster(ManageITHeader header, ManageITBodyRequest request) {
        if (request == null || request.getParams() == null || !request.getParams().isContainsAllKeysAndNotNull(new String[]{"itemList", "prjCatgId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String itemList = StringSupport.getString(request.getParams().get("itemList"));
        BigInteger prjCatgId = NumberSupport.getBigInteger(request.getParams().get("prjCatgId"));
        CmBiditPrjCatg biditPrjCatg = cmBiditPrjCatgService.findById(prjCatgId.toString());
        if (biditPrjCatg == null) {
            log.error("BidIT Project Category Id not found: " + prjCatgId.toString());
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
        }
        String[] idList = itemList.split(",");
        for (String masterItemId : idList) {
            CmBiditItemMaster masterBidItem = cmBiditItemMasterService.findById(masterItemId);
            if (masterBidItem == null) {
                log.error(String.format("Master Bid Item Id '%s' Not found to Import.", masterBidItem));
            } else {
                BigInteger parentId = null;
                if (masterBidItem.getIsParent()) {
                    parentId = copyMasterItem(header, prjCatgId, masterBidItem, parentId, biditPrjCatg.getBidAddendumRev());
                    List<CmBiditItemMaster> childs = cmBiditItemMasterService.list(new ManageITBodyRequest(0, 0).filter("parentId", masterBidItem.getId()).filter("deleted", 'N').filter("active", 'Y'));
                    if (childs != null && !childs.isEmpty()) {
                        for (CmBiditItemMaster child : childs) {
                            copyMasterItem(header, prjCatgId, child, parentId, biditPrjCatg.getBidAddendumRev());
                        }
                    }
                } else {
                    copyMasterItem(header, prjCatgId, masterBidItem, parentId, biditPrjCatg.getBidAddendumRev());
                }
            }
        }
    }

    private BigInteger copyMasterItem(ManageITHeader header, BigInteger prjCatgId, CmBiditItemMaster elem, BigInteger parentId, BigInteger rev) {
        if (elem != null) {
            CmBiditPrjItems model = new CmBiditPrjItems();
            model.setPrjCatgId(prjCatgId);
            model.setItemAddendumRev(rev);
            model.setItemNo(elem.getItemNo());
            model.setCategory(elem.getCategory());
            model.setSpecNo(elem.getSpecNo());
            model.setDescription(elem.getDescription());
            model.setUnit(elem.getUnit());
            model.setItemType(elem.getItemType());
            model.setItemRefId(elem.getId().toBigInteger());
            model.setIsQtyEditable(Boolean.FALSE);
            model.setDefaultQty(BigDecimal.ONE);
            model.setCreated(new Date());
            model.setCreatedBy(header.getUser());
            model.setCreatedByIp(header.getModIp());
            model.setLastMod(new Date());
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            model.setActive('Y');
            model.setDeleted('N');
            model.setParentId(parentId);
            model.setIsParent(elem.getIsParent());
            return dao.save(model).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }
}
