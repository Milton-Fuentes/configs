/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.QaSampleDocs;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QaSampleDocsDao;
import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaSampleDocsServiceImpl implements QaSampleDocsService, IBaseEJBException {

    @Inject
    private QaSampleDocsDao dao;

    @Override
    public QaSampleDocs findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleDocs findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, QaSampleDocs elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, QaSampleDocs elem) {
        if (elem != null) {
            QaSampleDocs model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private QaSampleDocs populate(QaSampleDocs model, QaSampleDocs elem) {
        model.setId(elem.getId());
        model.setSampleId(elem.getSampleId());
        model.setSourcePath(elem.getSourcePath());
        model.setFTitle(elem.getFTitle());
        model.setExtension(elem.getExtension());
        model.setFName(elem.getFName());
        model.setNote1(elem.getNote1());
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
    public DataTableWrapper<QaSampleDocs> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaSampleDocs> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<QaSampleDocs> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaSampleDocs> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename")) || params == null || !params.containsKey("sampleId") || StringSupport.isNullOrEmpty(params.get("sampleId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger clientId = (params.containsKey("clientId") && StringSupport.isNotNullAndNotEmpty(params.get("clientId"))) ? NumberSupport.getBigInteger(params.get("clientId").toString()) : null;
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        header.setClientid(StringSupport.getString(params.get("clientId")));

        QaSampleDocs model = new QaSampleDocs();
        model.setSampleId(NumberSupport.getBigDecimal(params.get("sampleId")));
        model.setNote1(StringSupport.emptyOnNull(params.get("note1")));
        model.setSourcePath(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        model.setFTitle(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        model.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        model.setFName(StringSupport.emptyOnNull(metaDataFile.get("timename")));

        save(header, model);
    }

}
