/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobFolderSubscribeAllDao;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.model.GlobFolderSubscribe;
import com.atser.tools.atserejb.model.GlobFolderSubscribeAll;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.function.BooleanSupplier;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobFolderSubscribeAllServiceImpl implements GlobFolderSubscribeAllService, IBaseEJBException {

    @Inject
    private GlobFolderSubscribeAllDao dao;

    @Inject
    private GlobFolderSubscribeService folderSubscribeService;

    @Inject
    private GlobFolderService folderService;

    @Override
    public GlobFolderSubscribeAll findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobFolderSubscribeAll findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobFolderSubscribeAll elem) {
        if (elem != null && !dao.exists(elem.getFolderId().getId().toBigInteger(), elem.getSubscriberId().getId().toBigInteger())) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobFolderSubscribeAll elem) {
        if (elem != null) {
            GlobFolderSubscribeAll model = findById(elem.getId());
            dao.update(populate(model, elem));
        }
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
    public DataTableWrapper<GlobFolderSubscribeAll> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobFolderSubscribeAll> finalList = list(request);
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
    public DataGridWrapper<GlobFolderSubscribeAll> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<GlobFolderSubscribeAll> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean extists(BigInteger folderId, BigInteger subscriberId) {
        if (folderId == null || subscriberId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.exists(folderId, subscriberId);
    }

//    public void subscribeToAll(ManageITHeader header, GlobFolderSubscribeAll elem, String roleName, Boolean isAdmin) {
//        if (elem != null && StringSupport.isNotNullAndNotEmpty(roleName) && isAdmin != null) {
//            List<GlobFolder> folders = folderService.listFolderTreeByParentIdWithRights(elem.getFolderId().getId().toBigInteger(), elem.getSubscriberId().getId().toBigInteger(), roleName, isAdmin);
//            folders.stream().map(globFolder -> new GlobFolderSubscribe(globFolder, elem.getSubscriberId())).forEachOrdered(subscription -> {
//                folderSubscribeService.save(header, subscription);
//            });
//        }
//    }
//    
//    public void unSubscribeToAll(ManageITHeader header, GlobFolderSubscribeAll elem, String roleName, Boolean isAdmin) {
//        if (elem != null && StringSupport.isNotNullAndNotEmpty(roleName) && isAdmin != null) {
//            List<GlobFolder> folders = folderService.listFolderTreeByParentIdWithRights(elem.getFolderId().getId().toBigInteger(), elem.getSubscriberId().getId().toBigInteger(), roleName, isAdmin);
//            
//            folders.stream().map(globFolder -> new GlobFolderSubscribe(globFolder, elem.getSubscriberId())).forEachOrdered(subscription -> {
//                
//                
//                folderSubscribeService.delete(header, subscription);
//            });
//        }
//    }

    private GlobFolderSubscribeAll populate(GlobFolderSubscribeAll model, GlobFolderSubscribeAll elem) {
        model.setId(elem.getId());
        //model.setFileId(elem.getFileId());
        model.setSubscriberId(elem.getSubscriberId());
        return model;
    }
}
