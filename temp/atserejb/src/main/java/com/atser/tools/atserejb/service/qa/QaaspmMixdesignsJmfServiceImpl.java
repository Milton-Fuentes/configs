/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignsJmfDao;
import com.atser.tools.atserejb.model.GlobSieveSetsInfo;
import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmf;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmfSieves;
import com.atser.tools.atserejb.model.VwQaaspmMixJmfsv;
import com.atser.tools.atserejb.service.glob.GlobSieveSetsInfoService;
import com.atser.tools.atserejb.service.view.VwQaaspmMixJmfsvService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaaspmMixdesignsJmfServiceImpl implements QaaspmMixdesignsJmfService, IBaseEJBException {

    @Inject
    private QaaspmMixdesignsJmfDao dao;

    @Inject
    private GlobSieveSetsInfoService globSieveSetsInfoService;

    @Inject
    private QaaspmMixdesignsService qaaspmMixdesignsService;

    @Inject
    private QaaspmMixdesignsJmfSievesService qaaspmMixdesignsJmfSievesService;
    
    @Inject
    private VwQaaspmMixJmfsvService vwQaaspmMixJmfsvService;

    @Override
    public QaaspmMixdesignsJmf findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignsJmf findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesignsJmf findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignsJmf findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesignsJmf elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaaspmMixdesignsJmf elem) {
        if (elem != null) {
            if (!dao.exists(elem.getMixDesignId().getId().toBigInteger(), elem.getJmfNo())) {
                elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setVersion("1");
                elem.setCreateBy(header.getUser());
                elem.setCreateByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setMain("N");
                QaaspmMixdesigns mixId = qaaspmMixdesignsService.findById(elem.getMixDesignId().getId());
                if (mixId != null) {
                    elem.setMixDesignId(mixId);
                    dao.save(elem);
                    populateJMFSieves(header, elem, mixId.getSetId().getId().toBigInteger());
                } else {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "Inconsistent data.");
                }
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This JMF already exists.");
            }
        }
    }

    @Override
    public void copy(ManageITHeader header, QaaspmMixdesignsJmf elem) {
        if (elem != null) {
            if (!dao.exists(elem.getMixDesignId().getId().toBigInteger(), elem.getJmfNo())) {
                dao.deactiveMain(elem.getMixDesignId().getId().toBigInteger());
                elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setVersion("1");
                elem.setCreateBy(header.getUser());
                elem.setCreateByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setMain("Y");
                QaaspmMixdesigns mixId = qaaspmMixdesignsService.findById(elem.getMixDesignId().getId());
                if (mixId != null) {
                    elem.setMixDesignId(mixId);
                    dao.save(elem);
                } else {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "Inconsistent data.");
                }
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This JMF already exists.");
            }
        }
    }

    @Override
    public void update(ManageITHeader header, QaaspmMixdesignsJmf elem) {
        if (elem != null) {
            QaaspmMixdesignsJmf model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }

        }
    }

    private QaaspmMixdesignsJmf populate(QaaspmMixdesignsJmf model, QaaspmMixdesignsJmf elem) {
        model.setJmfNo(elem.getJmfNo());
        model.setJmfAc(elem.getJmfAc());
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
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaaspmMixdesignsJmf> list(ManageITBodyRequest request) {
        List<QaaspmMixdesignsJmf> list;
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
    public DataTableWrapper<QaaspmMixdesignsJmf> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesignsJmf> finalList = list(request);
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
    public DataGridWrapper<QaaspmMixdesignsJmf> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaaspmMixdesignsJmf> finalList = list(request);
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

    private void populateJMFSieves(ManageITHeader header, QaaspmMixdesignsJmf jmfId, BigInteger setId) {
        GlobSieveSetsInfo svObj = globSieveSetsInfoService.findById(setId.toString());
        if (svObj != null) {
            int size = svObj.getGlobSieveSetsList().size();
            if (size > 0) {
                svObj.getGlobSieveSetsList().forEach(it -> {
                    QaaspmMixdesignsJmfSieves model = new QaaspmMixdesignsJmfSieves();
                    model.setJmfId(jmfId);
                    model.setSieveId(NumberSupport.getBigInteger(it.getSieveId().getId()));
                    model.setOrdering(it.getOrdering());
                    model.setJmfPercPassing(0d);
                    qaaspmMixdesignsJmfSievesService.save(header, model);
                });
            }
        }
    }

    @Override
    public void setMain(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("mixId")) || StringSupport.isNullOrEmpty(request.getParams().get("jmfId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<QaaspmMixdesignsJmf> jmfList = list(new ManageITBodyRequest(0, 0).filter("mixDesignId.id", request.getParams().get("mixId")));
        if (jmfList != null && jmfList.size() > 0) {
            jmfList.forEach(it -> {
                if (it.getId().compareTo(NumberSupport.getBigDecimal(request.getParams().get("jmfId"))) == 0) {
                    it.setMain("Y");
                } else {
                    it.setMain("N");
                }
                dao.update(it);
            });
        }
    }

    @Override
    public LinkedHashMap<String, Object> hasSetMainJMF(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("mixId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        LinkedHashMap<String, Object> response = new AtserLinkedHashMap<>();
        List<QaaspmMixdesignsJmf> jmfList = list(new ManageITBodyRequest(0, 0).filter("mixDesignId.id", request.getParams().get("mixId")).filter("main", "Y"));
        if (jmfList != null && jmfList.size() > 0) {
            response.put("hasmain", Boolean.TRUE);
            response.put("jmfId", jmfList.get(0).getId());
            return response;
        }
        response.put("hasmain", Boolean.FALSE);
        return response;
    }
    
    @Override
    public QaaspmMixdesignsJmf getMainMixdesignJmfMaster(BigDecimal masterMixId) {
        List<QaaspmMixdesignsJmf> jmfList = list(new ManageITBodyRequest(0, 1).filter("mixDesignId.id", masterMixId).filter("main", "Y"));
        if (jmfList != null && jmfList.size() > 0) {
            return jmfList.get(0);
        }
        return null;
    }
    
    /**
     * Get Gradation List
     * @param masterMixId
     * @param mainJmfId
     * @param setId
     * @return 
     */
    @Override
    public List<GradationPojo> getGradationPojoList(BigDecimal masterMixId, BigDecimal mainJmfId, BigDecimal setId) {
        if (masterMixId != null && mainJmfId != null && setId != null) {
            List<GradationPojo> list = new ArrayList<>();
            List<VwQaaspmMixJmfsv> jmsvList = vwQaaspmMixJmfsvService.list(new ManageITBodyRequest(0, 0).filter("jmfId", mainJmfId).filter("setId", setId).sorted("ordering", "asc"));
            jmsvList.forEach(it -> {
                list.add(it.generateGradationPojo());
            });
            return list;
        }
        return null;
    }

}
