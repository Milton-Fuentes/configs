/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service;

import com.atser.tools.atserejb.dao.AppTableImgDao;
import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.AppTableImg;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class AppTableImgServiceImpl implements AppTableImgService, IBaseEJBException {

    @Inject
    private AppTableImgDao dao;

    @Override
    public AppTableImg findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public AppTableImg findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, AppTableImg elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, AppTableImg elem) {
        if (elem != null) {
            AppTableImg model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private void updateDataPhoto(ManageITHeader header, AppTableImg elem) {
        if (elem != null) {
            AppTableImg model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setFirstName(elem.getFirstName());
                model.setLastName(elem.getLastName());
                model.setEmail(elem.getEmail());
                model.setContactNo(elem.getContactNo());
                model.setSourceName(elem.getSourceName());
                model.setServerPath(elem.getServerPath());
                model.setfName(elem.getfName());
                model.setfSize(elem.getfSize());
                model.setExtension(elem.getExtension());
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModByIp(header.getModIp());
                dao.update(model);
            }
        }
    }

    private void updatePhoto(ManageITHeader header, AppTableImg elem) {
        if (elem != null) {
            AppTableImg model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setSourceName(elem.getSourceName());
                model.setServerPath(elem.getServerPath());
                model.setfName(elem.getfName());
                model.setfSize(elem.getfSize());
                model.setExtension(elem.getExtension());
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModByIp(header.getModIp());
                dao.update(model);
            }
        }
    }

    private AppTableImg populate(AppTableImg model, AppTableImg elem) {
        model.setFirstName(elem.getFirstName());
        model.setLastName(elem.getLastName());
        model.setEmail(elem.getEmail());
        model.setContactNo(elem.getContactNo());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModByIp(elem.getLastModByIp());
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
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        delete(id);
    }

    @Override
    public DataTableWrapper<AppTableImg> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<AppTableImg> finalList = list(request);
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
    public DataGridWrapper<AppTableImg> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<AppTableImg> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void saveDataFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("firstName") && StringSupport.isNullOrEmpty(params.get("firstName"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        AppTableImg elem = new AppTableImg();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setFirstName(StringSupport.getString(params.get("firstName")));
        elem.setLastName(StringSupport.getString(params.get("lastName")));
        elem.setEmail(StringSupport.getString(params.get("email")));
        elem.setContactNo(StringSupport.getString(params.get("contactNo")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        save(header, elem);
    }

    @Override
    public void updateDataFileDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        AppTableImg elem = new AppTableImg();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        elem.setFirstName(StringSupport.getString(params.get("firstName")));
        elem.setLastName(StringSupport.getString(params.get("lastName")));
        elem.setEmail(StringSupport.getString(params.get("email")));
        elem.setContactNo(StringSupport.getString(params.get("contactNo")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        updateDataPhoto(header, elem);
    }

    @Override
    public void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        AppTableImg elem = new AppTableImg();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        updatePhoto(header, elem);
    }

    @Override
    public void updateFileDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        AppTableImg elem = new AppTableImg();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        updatePhoto(header, elem);
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<AppTableImg> list = list(request);
        list.forEach(it -> {
            rlist.add(new DataSelectWrapper(it.getId(), it.getFirstName()));
        });
        return rlist;
    }

    @Override
    public Boolean exists(String email) {
        return dao.exists(email);
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
        AppTableImg model = findById(request.getParams().get("id").toString());
        if (model != null) {
            model.setActive(String.valueOf(StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status")))));
            dao.update(model);
        }
    }

}
