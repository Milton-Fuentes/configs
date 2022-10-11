/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignJmfMasterDao;
import com.atser.tools.atserejb.model.GlobSieveSets;
import com.atser.tools.atserejb.model.GlobSieveSetsInfo;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfsvMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesignMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmf;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmfSieves;
import com.atser.tools.atserejb.model.VwQaaspmMixJmfsvMaster;
import com.atser.tools.atserejb.service.glob.GlobSieveSetsInfoService;
import com.atser.tools.atserejb.service.glob.GlobSieveSetsService;
import com.atser.tools.atserejb.service.view.VwQaaspmMixJmfsvMasterService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaaspmMixdesignJmfMasterServiceImpl implements QaaspmMixdesignJmfMasterService, IBaseEJBException {

    @Inject
    private QaaspmMixdesignJmfMasterDao dao;

    @Inject
    private GlobSieveSetsInfoService globSieveSetsInfoService;

    @Inject
    private QaaspmMixdesignMasterService qaaspmMixdesignMasterService;

    @Inject
    private VwQaaspmMixJmfsvMasterService vwQaaspmMixJmfsvMasterService;

    @Inject
    private QaaspmMixdesignsJmfService qaaspmMixdesignsJmfService;

    @Inject
    private QaaspmMixdesignJmfsvMasterService qaaspmMixdesignJmfsvMasterService;

    @Inject
    private GlobSieveSetsService globSieveSetsService;

    @Override
    public QaaspmMixdesignJmfMaster findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignJmfMaster findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesignJmfMaster findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignJmfMaster findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesignJmfMaster elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaaspmMixdesignJmfMaster elem) {
        if (elem != null) {
            if (!dao.exists(elem.getMixId().getId().toBigInteger(), elem.getJmfNo())) {
                dao.deactiveMain(elem.getMixId().getId().toBigInteger());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setMain("Y");
                QaaspmMixdesignMaster mixId = qaaspmMixdesignMasterService.findById(elem.getMixId().getId());
                if (mixId != null) {
                    elem.setMixId(mixId);
                    elem = preCalculateLimits(elem, mixId);
                    dao.save(elem);
                    updateCurrentJMFNo(elem.getMixId().getId(), elem.getJmfNo().toString());
                    populateJMFSieves(header, elem, mixId.getSetId().getId().toBigInteger());
                } else {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "Inconsistent data.");
                }
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This JMF already exists.");
            }
        }
    }

    private Boolean isContainData(List items) {
        for (Object item : items) {
            if (item != null) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public void saveFromTo(ManageITHeader header, AspmMixDesignDef elem, QaaspmMixdesignMaster masterMixId) {
        if (elem != null && masterMixId != null) {
            QaaspmMixdesignJmfMaster model = toQaaspmMixdesignJmfMaster(elem, masterMixId);
            model.setCreatedBy(header.getUser());
            model.setCreatedByIp(header.getModIp());
            model.setLastModIp(header.getModIp());
            model.setLastModBy(header.getUser());
            model.setMixId(masterMixId);
            model.setMain("Y");
            dao.save(model);
            if (elem.getGradationList() != null && elem.getGradationList().size() > 0 && isContainData(elem.getGradationList())) {
                populateJMFSievesFromTo(header, elem, model, masterMixId.getSetId().getId().toBigInteger());
            } else {
                populateJMFSieves(header, model, masterMixId.getSetId().getId().toBigInteger());
            }
        }
    }

    private QaaspmMixdesignJmfMaster toQaaspmMixdesignJmfMaster(AspmMixDesignDef elem, QaaspmMixdesignMaster masterMixId) {
        QaaspmMixdesignJmfMaster model = new QaaspmMixdesignJmfMaster();
        model.setJmfNo(BigInteger.ONE);
        model.setDesac(NumberSupport.getBigDecimal(elem.getDesac()));
        model.setDesvtm(NumberSupport.getBigDecimal(elem.getDesvtm()));
        model.setDesvma(NumberSupport.getBigDecimal(elem.getDesvma()));
        model.setDesvfa(NumberSupport.getBigDecimal(elem.getDesvfa()));
        model.setDesdpbr(NumberSupport.getBigDecimal(elem.getDesdpbr()));
        model.setApprovedDate(elem.getApprovedDate());
        model = preCalculateLimits(model, masterMixId);
        return model;
    }

    @Override
    public void update(ManageITHeader header, QaaspmMixdesignJmfMaster elem) {
        if (elem != null) {
            QaaspmMixdesignJmfMaster model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    public void updateLimits(ManageITHeader header, QaaspmMixdesignJmfMaster elem, QaaspmMixdesignMaster mixId) {
        if (elem != null && mixId != null) {
            QaaspmMixdesignJmfMaster model = preCalculateLimits(elem, mixId);
            model.setLastMod(new Date());
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            dao.update(model);
        }
    }

    private QaaspmMixdesignJmfMaster populate(QaaspmMixdesignJmfMaster model, QaaspmMixdesignJmfMaster elem) {
        QaaspmMixdesignMaster mixId = model.getMixId();
        model.setJmfNo(elem.getJmfNo());
        model.setJmfAc(elem.getJmfAc());
        model.setDesac(elem.getDesac());
        model.setDesvtm(elem.getDesvtm());
        model.setDesvma(elem.getDesvma());
        model.setDesvfa(elem.getDesvfa());
        model.setDesdpbr(elem.getDesdpbr());
        model.setApprovedDate(elem.getApprovedDate());
        model.setPctAbsorption(elem.getPctAbsorption());
        model = preCalculateLimits(model, mixId);
        return model;
    }

    private QaaspmMixdesignJmfMaster preCalculateLimits(QaaspmMixdesignJmfMaster model, QaaspmMixdesignMaster mixId) {
        model.setMinac(calculateLimit(model.getDesac(), mixId.getTolminac(), "lower"));
        model.setMaxac(calculateLimit(model.getDesac(), mixId.getTolmaxac(), "upper"));
        model.setMinengac(calculateLimit(model.getDesac(), mixId.getTolminengac(), "lower"));
        model.setMaxengac(calculateLimit(model.getDesac(), mixId.getTolmaxengac(), "upper"));
        model.setMinvtm(calculateLimit(model.getDesvtm(), mixId.getTolminvtm(), "lower"));
        model.setMaxvtm(calculateLimit(model.getDesvtm(), mixId.getTolmaxvtm(), "upper"));
        model.setMinengvtm(calculateLimit(model.getDesvtm(), mixId.getTolminengvtm(), "lower"));
        model.setMaxengvtm(calculateLimit(model.getDesvtm(), mixId.getTolmaxengvtm(), "upper"));
        model.setMinvma(calculateLimit(model.getDesvma(), mixId.getTolminvma(), "lower"));
        model.setMaxvma(calculateLimit(model.getDesvma(), mixId.getTolmaxvma(), "upper"));
        model.setMinengvma(calculateLimit(model.getDesvma(), mixId.getTolminengvma(), "lower"));
        model.setMaxengvma(calculateLimit(model.getDesvma(), mixId.getTolmaxengvma(), "upper"));
        model.setMinvfa(calculateLimit(model.getDesvfa(), mixId.getTolminvfa(), "lower"));
        model.setMaxvfa(calculateLimit(model.getDesvfa(), mixId.getTolmaxvfa(), "upper"));
        model.setMinengvfa(calculateLimit(model.getDesvfa(), mixId.getTolminengvfa(), "lower"));
        model.setMaxengvfa(calculateLimit(model.getDesvfa(), mixId.getTolmaxengvfa(), "upper"));
        model.setMindpbr(calculateLimit(model.getDesdpbr(), mixId.getTolmindpbr(), "lower"));
        model.setMaxdpbr(calculateLimit(model.getDesdpbr(), mixId.getTolmaxdpbr(), "upper"));
        model.setMinengdpbr(calculateLimit(model.getDesdpbr(), mixId.getTolminengdpbr(), "lower"));
        model.setMaxengdpbr(calculateLimit(model.getDesdpbr(), mixId.getTolmaxengdpbr(), "upper"));
        return model;
    }

    private BigDecimal calculateLimit(BigDecimal target, BigDecimal tol, String dir) {
        if (target == null) {
            return BigDecimal.ZERO;
        }
        if (tol == null) {
            return BigDecimal.ZERO;
        }
        if (StringSupport.isNullOrEmpty(dir)) {
            return BigDecimal.ZERO;
        }
        switch (dir) {
            case "lower":
                return CurrencySupport.formatBigDecimal(target.subtract(tol), 2);
            case "upper":
                return CurrencySupport.formatBigDecimal(target.add(tol), 2);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaaspmMixdesignJmfMaster> list(ManageITBodyRequest request) {
        List<QaaspmMixdesignJmfMaster> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QaaspmMixdesignJmfMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesignJmfMaster> finalList = list(request);
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
    public DataGridWrapper<QaaspmMixdesignJmfMaster> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaaspmMixdesignJmfMaster> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
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

    private void populateJMFSieves(ManageITHeader header, QaaspmMixdesignJmfMaster jmfId, BigInteger setId) {
        GlobSieveSetsInfo svObj = globSieveSetsInfoService.findById(setId.toString());
        if (svObj != null) {
            int size = svObj.getGlobSieveSetsList().size();
            if (size > 0) {
                svObj.getGlobSieveSetsList().forEach(it -> {
                    QaaspmMixdesignJmfsvMaster model = new QaaspmMixdesignJmfsvMaster();
                    model.setJmfId(jmfId);
                    model.setSieveId(NumberSupport.getBigInteger(it.getSieveId().getId()));
                    model.setOrdering(it.getOrdering());
                    model.setJmfPercPassing(BigDecimal.ZERO);
                    qaaspmMixdesignJmfsvMasterService.save(header, model);
                });
            }
        }
    }

    private void populateJMFSievesFromTo(ManageITHeader header, AspmMixDesignDef mdef, QaaspmMixdesignJmfMaster jmfId, BigInteger setId) {
        List<GlobSieveSets> svList = globSieveSetsService.list(new ManageITBodyRequest(0, 0).filter("setId", setId).sorted("ordering", "asc"));
        if (!svList.isEmpty()) {
            for (int i = 0; i < svList.size(); i++) {
                QaaspmMixdesignJmfsvMaster model = new QaaspmMixdesignJmfsvMaster();
                model.setJmfId(jmfId);
                model.setSieveId(NumberSupport.getBigInteger(svList.get(i).getSieveId().getId()));
                model.setOrdering(svList.get(i).getOrdering());
                model.setJmfPercPassing(NumberSupport.getBigDecimal(mdef.getGradationList().get(i)));
                qaaspmMixdesignJmfsvMasterService.save(header, model);
            }
        }
    }

    @Override
    public void setMain(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("mixId")) || StringSupport.isNullOrEmpty(request.getParams().get("jmfId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.deactiveMain(NumberSupport.getBigInteger(request.getParams().get("mixId")));
        QaaspmMixdesignJmfMaster model = findById(request.getParams().get("jmfId").toString());
        model.setMain("Y");
        updateCurrentJMFNo(NumberSupport.getBigDecimal(request.getParams().get("mixId")), model.getJmfNo().toString());
        dao.update(model);
    }

    private void updateCurrentJMFNo(BigDecimal mainMixId, String mainJmfNo) {
        if (StringSupport.isNotNullAndNotEmpty(mainJmfNo)) {
            qaaspmMixdesignMasterService.updateCurrentJMFNo(mainMixId, mainJmfNo);
        }
    }

    @Override
    public LinkedHashMap<String, Object> hasSetMainJMF(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("mixId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        LinkedHashMap<String, Object> response = new AtserLinkedHashMap<>();
        List<QaaspmMixdesignJmfMaster> jmfList = list(new ManageITBodyRequest(0, 0).filter("mixId.id", request.getParams().get("mixId")).filter("deleted", "N").filter("active", "Y").filter("main", "Y"));
        if (jmfList != null && jmfList.size() > 0) {
            response.put("hasmain", Boolean.TRUE);
            response.put("jmfId", jmfList.get(0).getId());
            return response;
        }
        response.put("hasmain", Boolean.FALSE);
        return response;
    }

    @Override
    public void assignJMFToProject(ManageITHeader header, BigDecimal projectMixId, BigDecimal jmfId) {
        if (projectMixId == null || jmfId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaaspmMixdesignJmfMaster sJmf = findById(jmfId);
        if (sJmf != null) {
            if (projectMixId != null) {
                QaaspmMixdesignsJmf persistJmf = toQaaspmMixdesignsJmf(header, sJmf, projectMixId);
                qaaspmMixdesignsJmfService.copy(header, persistJmf);
            }
        }
    }

    @Override
    public void assignMainJMFToProject(ManageITHeader header, BigDecimal masterMixId, BigDecimal projectMixId) {
        if (masterMixId == null || projectMixId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaaspmMixdesignJmfMaster mainJmf = getMainMixdesignJmfMaster(masterMixId);
        if (mainJmf != null) {
            if (projectMixId != null) {
                QaaspmMixdesignsJmf persistJmf = toQaaspmMixdesignsJmf(header, mainJmf, projectMixId);
                qaaspmMixdesignsJmfService.copy(header, persistJmf);
            }
        }
    }

    @Override
    public QaaspmMixdesignJmfMaster getMainMixdesignJmfMaster(BigDecimal masterMixId) {
        List<QaaspmMixdesignJmfMaster> jmfList = list(new ManageITBodyRequest(0, 1).filter("mixId.id", masterMixId).filter("deleted", "N").filter("active", "Y").filter("main", "Y"));
        if (jmfList != null && jmfList.size() > 0) {
            return jmfList.get(0);
        }
        return null;
    }

    private QaaspmMixdesignsJmf toQaaspmMixdesignsJmf(ManageITHeader header, QaaspmMixdesignJmfMaster elem, BigDecimal projectMixId) {
        QaaspmMixdesignsJmf model = new QaaspmMixdesignsJmf();
        model.setMixDesignId(new QaaspmMixdesigns(projectMixId));
        model.setJmfNo(elem.getJmfNo());
        model.setJmfAc(elem.getJmfAc());
        model.setMain(elem.getMain());
        model.setDesac(elem.getDesac());
        model.setMinac(elem.getMinac());
        model.setMaxac(elem.getMaxac());
        model.setMinengac(elem.getMinengac());
        model.setMaxengac(elem.getMaxengac());
        model.setDesvtm(elem.getDesvtm());
        model.setMinvtm(elem.getMinvtm());
        model.setMaxvtm(elem.getMaxvtm());
        model.setMinengvtm(elem.getMinengvtm());
        model.setMaxengvtm(elem.getMaxengvtm());
        model.setDesvma(elem.getDesvma());
        model.setMinvma(elem.getMinvma());
        model.setMaxvma(elem.getMaxvma());
        model.setMinengvma(elem.getMinengvma());
        model.setMaxengvma(elem.getMaxengvma());
        model.setDesvfa(elem.getDesvfa());
        model.setMinvfa(elem.getMinvfa());
        model.setMaxvfa(elem.getMaxvfa());
        model.setMinengvfa(elem.getMinengvfa());
        model.setMaxengvfa(elem.getMaxengvfa());
        model.setDesdpbr(elem.getDesdpbr());
        model.setMindpbr(elem.getMindpbr());
        model.setMaxdpbr(elem.getMaxdpbr());
        model.setMinengdpbr(elem.getMinengdpbr());
        model.setMaxengdpbr(elem.getMaxengdpbr());
        model.setApprovedDate(elem.getApprovedDate());
        model.setPctAbsorption(elem.getPctAbsorption());

        if (elem.getQaaspmMixdesignJmfsvMasterList().size() > 0) {
            elem.getQaaspmMixdesignJmfsvMasterList().forEach(it -> {
                QaaspmMixdesignsJmfSieves obj = new QaaspmMixdesignsJmfSieves();
                obj.setSieveId(it.getSieveId());
                obj.setOrdering(it.getOrdering());
                if (it.getJmfPercPassing() != null) {
                    obj.setJmfPercPassing(it.getJmfPercPassing().doubleValue());
                }
                obj.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                obj.setCreateBy(header.getUser());
                obj.setCreateByIp(header.getModIp());
                obj.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                obj.setLastModIp(header.getModIp());
                obj.setLastModBy(header.getUser());
                obj.setVersion("1");
                model.addAspmMixdesignsJmfSievesList(obj);
            });
        }
        return model;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaaspmMixdesignJmfMaster model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
    }

    @Override
    public List<DataSelectWrapper> filterJmfByProject(BigInteger projectId, BigInteger mixId) {
        if (projectId == null || mixId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong params.");
        }
        List<QaaspmMixdesignJmfMaster> model = dao.filterJmfByProject(projectId, mixId);
        if (model != null) {
            return model.stream().map(p -> new DataSelectWrapper(p.getId(), "JMF # " + p.getJmfNo().toString(), (p.getMain().equals("Y")), false)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public BigInteger getNextJMFNo(BigInteger mixId) {
        if (mixId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong params.");
        }
        return dao.getNextJMFNo(mixId);
    }

    /**
     * Get Gradation List
     *
     * @param masterMixId
     * @param mainJmfId
     * @param setId
     * @return
     */
    @Override
    public List<GradationPojo> getGradationPojoList(BigDecimal masterMixId, BigDecimal mainJmfId, BigDecimal setId) {
        if (masterMixId != null && mainJmfId != null && setId != null) {
            List<GradationPojo> list = new ArrayList<>();
            List<VwQaaspmMixJmfsvMaster> jmsvList = vwQaaspmMixJmfsvMasterService.list(new ManageITBodyRequest(0, 0).filter("jmfId", mainJmfId).filter("setId", setId).sorted("ordering", "asc"));
            jmsvList.forEach(it -> {
                list.add(it.generateGradationPojo());
            });
            return list;
        }
        return null;
    }
}
