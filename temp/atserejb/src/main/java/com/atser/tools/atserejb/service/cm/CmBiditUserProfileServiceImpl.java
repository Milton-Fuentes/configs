/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.cm.CmBiditUserProfileDao;
import com.atser.tools.atserejb.model.CmBiditCompany;
import com.atser.tools.atserejb.model.CmBiditPrjItems;
import com.atser.tools.atserejb.model.CmBiditPrjItemsCo;
import com.atser.tools.atserejb.model.CmBiditSignflowdef;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import com.atser.tools.atserejb.model.CmBiditUserProfile;
import com.atser.tools.atserejb.model.GlobSystemSimpleCat;
import com.atser.tools.atserejb.service.glob.GlobSystemSimpleCatService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.cm.CmBiditUserProfileSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class CmBiditUserProfileServiceImpl implements CmBiditUserProfileService, IBaseEJBException {

    private final String rootFolderName = "attachments";

    @Inject
    private CmBiditUserProfileDao dao;

    @Inject
    private CmBiditPrjItemsService cmBiditPrjItemsService;

    @Inject
    private CmBiditPrjItemsCoService cmBiditPrjItemsCoService;

    @Inject
    private CmBiditCompanyService cmBiditCompanyService;

    @Inject
    private CmBiditSignflowdefService cmBiditSignflowdefService;

    @Inject
    private CmBiditSigninfoService cmBiditSigninfoService;

    @Inject
    private GlobSystemSimpleCatService globSystemSimpleCatService;

    @Override
    public CmBiditUserProfile findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditUserProfile findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public CmBiditUserProfile findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditUserProfile findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            CmBiditUserProfile elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header, elem);
                if (fId != null) {
                    elem.setFolderId(fId.toBigInteger());
                    dao.update(elem);
                }
            }
            return elem;
        }
    }

    // Review This Method
    private BigDecimal createFolderStruct(ManageITHeader header, CmBiditUserProfile elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Bidder Folder by ClientID
        /*BigDecimal rootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "BidIT Documents");
        if (rootFolderId != null) {
            // Create Attachment Folder
            BigDecimal attachmentRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), rootFolderName, rootFolderId.toBigInteger());
            if (attachmentRootFolderId == null) {
                attachmentRootFolderId = folderService.createTrackITFolder(rootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', rootFolderName, new BigInteger("2"));
            }
            if (attachmentRootFolderId != null) {
                return folderService.createTrackITFolder(attachmentRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', elem.getBidNo(), new BigInteger("2"));
            }
        }*/
        return null;
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditUserProfile elem) {
        if (elem == null || StringSupport.isNullOrEmpty(header.getClientid()) || Objects.isNull(elem.getUserId()) || Objects.isNull(elem.getCompanyId()) || Objects.isNull(elem.getPrjCatgId())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return BigDecimal.ZERO;
        }
        if (elem.getCompanyId().compareTo(new BigInteger("-1")) == 0) {
            Optional<CmBiditCompany> companyId = cmBiditCompanyService.findEngineerEstimationCompany(NumberSupport.getBigInteger(header.getClientid()));
            if (companyId.isPresent()) {
                elem.setCompanyId(companyId.get().getId().toBigInteger());
            } else {
                log.error(String.format("Engineer Estimate Company not Found for client: '%s'", header.getClientid()));
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Engineer Estimate Company not Found !");
            }
        }

        if (dao.exists(elem)) {
            throwBaseException(Response.Status.EXPECTATION_FAILED, "You are already bidding on this record.");
        }
        BigDecimal profileId = dao.save(elem).getId();
        copyBidItems(header, profileId, elem.getPrjCatgId());
        populateSignFlowDef(header, elem);
        return profileId;
    }

    private void populateSignFlowDef(ManageITHeader header, CmBiditUserProfile elem) {
        String code = "code_bidit_sign_workflow";
        String shortName = "bidsignbidderwf";
        BigInteger clientId = NumberSupport.getBigInteger(header.getClientid());
        List<CmBiditSignflowdef> list = cmBiditSignflowdefService.list(new ManageITBodyRequest(0, 0).filter("clientId", clientId).filter("typeId.code", code).filter("typeId.shortName", shortName).filter("active", "Y"));
        // Getting TypeId
        List<GlobSystemSimpleCat> typeList = globSystemSimpleCatService.list(new ManageITBodyRequest(0, 2).filter("clientId", clientId).filter("code", code).filter("shortName", shortName).filter("active", 'Y'));
        if (typeList == null || typeList.isEmpty() || typeList.size() > 1) {
            log.error(String.format("Wrong database configuration for GlobSystemSimpleCat for code : '%s' and shortName: '%s' with client: '%s'", code, shortName, clientId));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            return;
        }
        // Add Signatures
        list.forEach(it -> {
            cmBiditSigninfoService.save(header, new CmBiditSigninfo(clientId, it.getSignOrder(), elem.getId().toBigInteger(), it, typeList.get(0)));
        });
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, CmBiditUserProfile elem) {
        if (elem != null) {
            CmBiditUserProfile model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private CmBiditUserProfile populate(CmBiditUserProfile model, CmBiditUserProfile elem) {
        model.setCompanyId(elem.getCompanyId());
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
    public List<CmBiditUserProfile> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<CmBiditUserProfile> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditUserProfile> finalList = list(request);
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
    public DataGridWrapper<CmBiditUserProfile> dataGridList(ManageITBodyRequest request) {
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
    public Object getFrontEndSearch(ManageITHeader header, CmBiditUserProfileSearchDefParam defParam) {
        if (defParam == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(defParam.dt)) {
            return dao.getFrontEndSearch(defParam);
        } else {
            switch (defParam.dt) {
                case "table": {
                    return dao.getFrontEndSearch(defParam);
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void changeStatus(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditUserProfile model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    private void copyBidItems(ManageITHeader header, BigDecimal profileId, BigInteger prjCatgId) {
        List<CmBiditPrjItems> items = cmBiditPrjItemsService.list(new ManageITBodyRequest(0, 0).filter("prjCatgId", prjCatgId).filter("active", 'Y'));
        if (items != null && !items.isEmpty()) {
            items.forEach(it -> {
                cmBiditPrjItemsCoService.save(header, new CmBiditPrjItemsCo(it.getId().toBigInteger(), profileId.toBigInteger()));
            });
        }
    }

}
