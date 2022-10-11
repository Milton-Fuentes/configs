/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.GlobFolderSubscribe;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobFolderSubscribeDao;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobFolderSubscribeServiceImpl implements GlobFolderSubscribeService, IBaseEJBException {

    @Inject
    private GlobFolderSubscribeDao dao;

    @Inject
    private GlobFolderService folderService;

    @Override
    public GlobFolderSubscribe findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobFolderSubscribe findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobFolderSubscribe elem) {
        if (elem != null && !dao.exists(elem.getFolderId().getId().toBigInteger(), elem.getSubscriberId().getId().toBigInteger())) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobFolderSubscribe elem) {
        if (elem != null) {
            GlobFolderSubscribe model = findById(elem.getId());
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
    public void delete(BigInteger folderId, BigInteger subscriberId) {
        if (folderId == null || subscriberId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(folderId, subscriberId);
    }

    @LatencyLogger
    @Override
    public List<GlobFolderSubscribe> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobFolderSubscribe> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobFolderSubscribe> finalList = list(request);
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
    public DataGridWrapper<GlobFolderSubscribe> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
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

    private GlobFolderSubscribe populate(GlobFolderSubscribe model, GlobFolderSubscribe elem) {
        model.setId(elem.getId());
        model.setFolderId(elem.getFolderId());
        model.setSubscriberId(elem.getSubscriberId());
        return model;
    }

    // -------------------------------------------------------------------------
    @Override
    public String getStatus(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin) {
        if (folderId == null && subscriberId == null && !StringSupport.isNotNullAndNotEmpty(roleName) && isAdmin == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobFolder> folders = folderService.listFolderTreeByParentIdWithRights(folderId, subscriberId, roleName, isAdmin);
        Integer cont = 0;
        String status = "SUBSCRIBED_SOME";
        for (GlobFolder folder : folders) {
            if (dao.exists(folder.getId().toBigInteger(), subscriberId)) {
                cont++;
                if (folder.getId().toBigInteger().equals(folderId)) {
                    status = "SUBSCRIBED_THIS";
                }
            }
        }
        if (cont == folders.size()) {
            status = "SUBSCRIBED_ALL";
        } else if (cont == 0) {
            status = "UNSUBSCRIBED_ALL";
        }
        return status;
    }

    @Override
    public void subscribeToAll(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin) {
        if (folderId != null && subscriberId != null && StringSupport.isNotNullAndNotEmpty(roleName) && isAdmin != null) {
            List<GlobFolder> folders = folderService.listFolderTreeByParentIdWithRights(folderId, subscriberId, roleName, isAdmin);
            for (GlobFolder folder : folders) {
                if (!dao.exists(folder.getId().toBigInteger(), subscriberId)) {
                    dao.save(new GlobFolderSubscribe(folder.getId(), new BigDecimal(subscriberId)));
                }
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
    }

    @Override
    public void unsubscribeToAll(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin) {
        if (folderId != null && subscriberId != null && StringSupport.isNotNullAndNotEmpty(roleName) && isAdmin != null) {
            List<GlobFolder> folders = folderService.listFolderTreeByParentIdWithRights(folderId, subscriberId, roleName, isAdmin);
            for (GlobFolder folder : folders) {
                dao.delete(folder.getId().toBigInteger(), subscriberId);
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
    }

    @Override
    public List<String> listSubscribersEmailByFolderId(BigInteger folderId) {
        if (folderId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.listSubscribersEmailByFolderId(folderId);
    }

    @Override
    public List<String> listSubscribersEmailByFolderIds(List<BigInteger> folderIds) {
        if (folderIds == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.listSubscribersEmailByFolderIds(folderIds);
    }
}
