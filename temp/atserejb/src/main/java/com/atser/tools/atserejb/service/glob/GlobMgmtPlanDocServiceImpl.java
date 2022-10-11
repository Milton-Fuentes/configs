/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobMgmtPlanDocDao;
import com.atser.tools.atserejb.model.GlobMgmtPlan;
import com.atser.tools.atserejb.model.GlobMgmtPlanDoc;
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
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobMgmtPlanDocServiceImpl implements GlobMgmtPlanDocService, IBaseEJBException {

    @Inject
    private GlobMgmtPlanDocDao dao;

    @Inject
    private GlobMgmtPlanService globMgmtPlanService;

    @Inject
    private GlobFileService globFileService;

    @Override
    public GlobMgmtPlanDoc findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobMgmtPlanDoc findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobMgmtPlanDoc findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobMgmtPlanDoc findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobMgmtPlanDoc elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobMgmtPlanDoc elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(elem.getPlanId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setSno(dao.getNextGlobalSequenceNo(elem.getPlanId()));
            if (elem.getMain() != null && elem.getMain() == 'Y') {
                dao.deactiveMain(elem.getPlanId());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobMgmtPlanDoc elem) {
        if (elem != null) {
            GlobMgmtPlanDoc model = findById(elem.getId());
            if (!model.equals(elem)) {
                if (elem.getMain() != null && elem.getMain() == 'Y') {
                    dao.deactiveMain(elem.getPlanId());
                }
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobMgmtPlanDoc populate(GlobMgmtPlanDoc model, GlobMgmtPlanDoc elem) {
        model.setDescription(elem.getDescription());
        model.setVersionNo(elem.getVersionNo());
        model.setAuthorizedBy(elem.getAuthorizedBy());
        model.setMain(elem.getMain());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public void delete(String id) {
        delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobMgmtPlanDoc elemdb = findById(id);
        if(elemdb != null && elemdb.getFileId() != null) {
            globFileService.delete(elemdb.getFileId());
        }        
        dao.delete(id);
    }

    @Override
    public List<GlobMgmtPlanDoc> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobMgmtPlanDoc> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobMgmtPlanDoc> finalList = list(request);
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
    public DataGridWrapper<GlobMgmtPlanDoc> dataGridList(ManageITBodyRequest request) {
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
        GlobMgmtPlanDoc model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    @Override
    public void uploadDocument(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("planId"), params.get("description"), params.get("main"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.emptyOnNull(params.get("clientId")), StringSupport.emptyOnNull(params.get("userId")), StringSupport.emptyOnNull(params.get("modIp")));
        GlobMgmtPlan plandb = globMgmtPlanService.findById(NumberSupport.getBigDecimal(params.get("planId")));
        if (plandb != null && plandb.getFolderId() != null) {
            params.put("folderId", plandb.getFolderId());
            BigInteger fileId = globFileService.saveFileToDb(metaDataFile, params, "Management Plan Documents");
            if (fileId != null && !fileId.equals(BigInteger.ZERO)) {
                // Create GlobMgmtPlanDoc
                GlobMgmtPlanDoc elem = new GlobMgmtPlanDoc();
                elem.setPlanId(NumberSupport.getBigInteger(params.get("planId")));
                elem.setDescription(StringSupport.getString(params.get("description")));
                elem.setVersionNo(StringSupport.getString(params.get("versionNo")));
                elem.setAuthorizedBy(StringSupport.getString(params.get("authorizedBy")));
                elem.setMain(StringSupport.getActiveAsCharacter(StringSupport.getString(params.get("main"))));
                elem.setFileId(fileId);
                elem.setCreated(new Date());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                elem.setActive('Y');
                elem.setDeleted('N');
                // Saving Mgmt Plan Doc.
                this.save(header, elem);
            }
        }
    }
}
