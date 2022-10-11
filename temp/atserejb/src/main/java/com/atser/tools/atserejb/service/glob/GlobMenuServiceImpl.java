/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.GlobMenu;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobMenuDao;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobMenuServiceImpl implements GlobMenuService, IBaseEJBException {

    @Inject
    private GlobMenuDao dao;

    @Override
    public GlobMenu findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobMenu findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobMenu elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobMenu elem) {
        if (elem != null) {
            GlobMenu model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private void updateDataPhoto(ManageITHeader header, GlobMenu elem) {
        /*if (elem != null) {
            GlobMenu model = findById(elem.getId());
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
        }*/
    }

    private void updatePhoto(ManageITHeader header, GlobMenu elem) {
        /* if (elem != null) {
            GlobMenu model = findById(elem.getId());
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
        }*/
    }

    private GlobMenu populate(GlobMenu model, GlobMenu elem) {
        /*model.setFirstName(elem.getFirstName());
        model.setLastName(elem.getLastName());
        model.setEmail(elem.getEmail());
        model.setContactNo(elem.getContactNo());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModByIp(elem.getLastModByIp());*/
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
    public DataTableWrapper<GlobMenu> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobMenu> finalList = list(request);
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
    public DataGridWrapper<GlobMenu> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<GlobMenu> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobMenu> listByRoleName(String roleName, Boolean isAdmin, BigDecimal parentId, BigDecimal moduleId, BigDecimal clientId) {
        if (roleName == null || isAdmin == null || moduleId == null || clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("moduleId", moduleId);
        search.filter("clientId", clientId);
        search.filter("parentId", parentId != null ? parentId : "null");
        search.sorted("tabOrder", "asc");
        if (!isAdmin) {
            search.filter("condition", roleName, "%=");
        }

        List<GlobMenu> menuItems = list(search);
        
        // If no results then search menu for default client.
        if (menuItems.isEmpty()) {
            search.getFilter().remove(1);
            search.filter("clientId", 0);
            menuItems = list(search);
        }

        return menuItems;
    }

    @Override
    public void saveDataFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("firstName") && StringSupport.isNullOrEmpty(params.get("firstName"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobMenu elem = new GlobMenu();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        /*elem.setFirstName(StringSupport.getString(params.get("firstName")));
        elem.setLastName(StringSupport.getString(params.get("lastName")));
        elem.setEmail(StringSupport.getString(params.get("email")));
        elem.setContactNo(StringSupport.getString(params.get("contactNo")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));*/
        save(header, elem);
    }

    @Override
    public void updateDataFileDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobMenu elem = new GlobMenu();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        /*elem.setFirstName(StringSupport.getString(params.get("firstName")));
        elem.setLastName(StringSupport.getString(params.get("lastName")));
        elem.setEmail(StringSupport.getString(params.get("email")));
        elem.setContactNo(StringSupport.getString(params.get("contactNo")));
        // File Data
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));*/
        updateDataPhoto(header, elem);
    }

    @Override
    public void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobMenu elem = new GlobMenu();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        // File Data
        /*elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));*/
        updatePhoto(header, elem);
    }

    @Override
    public void updateFileDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (!params.containsKey("id") && StringSupport.isNullOrEmpty(params.get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobMenu elem = new GlobMenu();
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        // Contact Data
        elem.setId(NumberSupport.getBigDecimal(params.get("id")));
        // File Data
        /*elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setfName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setfSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));*/
        updatePhoto(header, elem);
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<GlobMenu> list = list(request);
        /*list.forEach(it -> {
            rlist.add(new DataSelectWrapper(it.getId(), it.getFirstName()));
        });*/
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
        GlobMenu model = findById(request.getParams().get("id").toString());
        /*if (model != null) {
            model.setActive(String.valueOf(StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status")))));
            dao.update(model);
        }*/
    }

}
