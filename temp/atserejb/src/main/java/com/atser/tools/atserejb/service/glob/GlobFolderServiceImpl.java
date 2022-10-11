/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.dao.glob.GlobFolderDao;
import com.atser.tools.atserejb.model.Bpmdispatchbo;
import com.atser.tools.atserejb.model.Bpminspectordispatchbo;
import com.atser.tools.atserejb.model.Bpmrfibo;
import com.atser.tools.atserejb.model.Bpmsubmittalbo;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.service.bpm.BpmDispatchService;
import com.atser.tools.atserejb.service.bpm.BpmInspectorDispatchService;
import com.atser.tools.atserejb.service.bpm.BpmRFIService;
import com.atser.tools.atserejb.service.bpm.BpmSubmittalService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.service.helper.SystemNotificationHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobDocumentChangePojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.pattern.AtserFolderView;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.commons.io.FilenameUtils;
import org.thymeleaf.TemplateEngine;

@Stateless
public class GlobFolderServiceImpl implements GlobFolderService, IBaseEJBException {

    @Inject
    private GlobFolderDao dao;

    @Inject
    private BpmSubmittalService submittalService;

    @Inject
    private BpmRFIService rfiService;

    @Inject
    private BpmDispatchService dispatchService;

    @Inject
    private BpmInspectorDispatchService inspDispatchService;

    @Inject
    private GlobFolderSubscribeService folderSubscribeService;

    @Inject
    private SystemNotificationHelperService systemNotificationHelperService;

    @Override
    public GlobFolder findById(String id) {
        return findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobFolder findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(GlobFolder elem) {
        return save(null, elem);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobFolder elem) {
        return save(header, null, elem);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, TemplateEngine engine, GlobFolder elem) {
        if (elem != null) {
            // Validate if a folder with the same number and name already exists under the parent provided.
            if (dao.exists(elem.getFNumber(), elem.getFName(), elem.getParentId())) {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "A folder with the same number and name already exists!");
            }
            // Set default values.
            elem.setActive('Y');
            elem.setReadOnly('N');
            elem.setVisible("Y");
            elem.setDefaultId(BigInteger.valueOf(-1));
            elem.setFolderTypeId(BigInteger.ZERO);
            // Persits and get the new id.
            BigDecimal id = dao.save(elem).getId();
            // Subscriptions
            if (engine != null && header != null) {
                validateSubscriptions(header, engine, "save_folder", elem, null, "Document Notification - Folder Change", "Folder Change");
            }
            // Return the new id.
            return id;
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(GlobFolder elem) {
        if (elem != null) {
            update(null, null, elem);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobFolder elem) {
        if (elem != null) {
            update(header, null, elem);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, TemplateEngine engine, GlobFolder elem) {
        if (elem != null) {
            GlobFolder folder = findById(elem.getId());

            List<GlobDocumentChangePojo> changes = new ArrayList<>();
            if (engine != null && header != null) {
                if (!elem.getFNumber().equals(folder.getFNumber())) {
                    changes.add(new GlobDocumentChangePojo("Number", folder.getFNumber(), elem.getFNumber()));
                }
                if (!elem.getFName().equals(folder.getFName())) {
                    changes.add(new GlobDocumentChangePojo("Name", folder.getFName(), elem.getFName()));
                }
            }

            folder.setFNumber(elem.getFNumber());
            folder.setFName(elem.getFName());
            dao.update(folder);

            if (engine != null && header != null) {
                validateSubscriptions(header, engine, "update_folder", folder, changes, "Document Notification - Folder Change", "Folder Change");
            }
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id) || !NumberSupport.isNumeric(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        delete(null, null, new BigDecimal(id));
    }

    @Override
    public void delete(BigInteger id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        delete(null, null, new BigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        delete(null, null, id);
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeysAndNotNull(new String[]{"id"})
                && !request.getParams().isContainsAllKeysAndNotNull(new String[]{"ids"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (request.getParams().containsKey("id") && NumberSupport.isNumeric(request.getParams().get("id").toString())) {
            delete(null, null, NumberSupport.getBigDecimal(request.getParams().get("id")));
        } else {
            delete(null, null, (List<BigInteger>) request.getParams().get("ids"));
        }
    }

    @Override
    public void delete(ManageITHeader header, TemplateEngine engine, BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobFolder elem = findById(id);
        dao.delete(id);
        if (engine != null && header != null) {
            validateSubscriptions(header, engine, "remove_folder", elem, null, "Document Notification - Folder Change", "Folder Change");
        }
    }

    @Override
    public void delete(ManageITHeader header, TemplateEngine engine, List<BigInteger> ids) {
        if (StringSupport.isNullOrEmpty(ids)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobFolder> folders = dao.listByIds(ids);
        dao.delete(ids);

        if (engine != null && header != null) {
            folders.forEach(folder -> {
                validateSubscriptions(header, engine, "remove_folder", folder, null, "Document Notification - Folder Change", "Folder Change");
            });
        }
    }

    @Override
    public List<GlobFolder> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<AtserFolderView> folderList(ManageITBodyRequest request, eManageITFolder folderName, String module) throws BaseException {
        if (request.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Empty Parameters.");
        } else if (!request.getParams().isContainsAllKeys(new String[]{"mode", "projectId", "contractId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        String projectId = request.getParams().get("projectId").toString();
        String contractId = request.getParams().get("contractId").toString();
        String mode = request.getParams().get("mode").toString();

        return dao.folderList(mode, NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(contractId), folderName.getValue());
    }

    @Override
    public GlobFolder findByBPMFName(String projectId, String contractId, String subStep, eManageITFolder folderName) {
        if (StringSupport.isNullOrEmpty(projectId) || StringSupport.isNullOrEmpty(contractId) || StringSupport.isNullOrEmpty(subStep)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger tprojectId = NumberSupport.getBigInteger(projectId);
        BigInteger tcontractId = NumberSupport.getBigInteger(contractId);
        String subname = folderName.getValue();
        String name = subStep;
        return dao.findByFName(tprojectId, tcontractId, subname, name);
    }

    @Override
    public BigDecimal getFolderIdByClientBy(String clientId, eManageITFolder folderName) {
        return getFolderIdByClientBy(clientId, folderName.getValue(), null);
    }

    @Override
    public BigDecimal getFolderIdByClientBy(String clientId, String folderName) {
        return getFolderIdByClientBy(clientId, folderName, null);
    }

    @Override
    public BigDecimal getFolderIdByClientBy(String clientId, String folderName, BigInteger parentId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(folderName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger tclientId = NumberSupport.getBigInteger(clientId);
        ManageITBodyRequest search = new ManageITBodyRequest(0, 3);
        search.filter("projectId", tclientId.negate()).filter("fName", folderName);
        if (parentId != null) {
            search.filter("parentId", parentId);
        }
        List<GlobFolder> folderList = list(search);
        if (folderList != null && folderList.size() >= 1) {
            return folderList.get(0).getId();
        }
        return null;
    }

    @Override
    public GlobFolder getFolderByClientBy(String clientId, eManageITFolder folderName) {
        return getFolderByClientBy(clientId, folderName.getValue(), null);
    }

    @Override
    public GlobFolder getFolderByClientBy(String clientId, String folderName) {
        return getFolderByClientBy(clientId, folderName, null);
    }

    @Override
    public GlobFolder getFolderByClientBy(String clientId, String folderName, BigInteger parentId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(folderName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger tclientId = NumberSupport.getBigInteger(clientId);
        ManageITBodyRequest search = new ManageITBodyRequest(0, 3);
        search.filter("projectId", tclientId.negate()).filter("fName", folderName);
        if (parentId != null) {
            search.filter("parentId", parentId);
        }
        List<GlobFolder> folderList = list(search);
        if (folderList != null && folderList.size() >= 1) {
            return folderList.get(0);
        }
        return null;
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, String folderName, BigInteger parentId) {
        if (StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger tprojectId = NumberSupport.getBigInteger(projectId);
        BigInteger tcontractId = NumberSupport.getBigInteger(contractId);
        if (parentId != null) {
            return dao.getFolderIdByFolderNameByProject(tprojectId, tcontractId, folderName, parentId);
        }
        return dao.getFolderIdByFolderNameByProject(tprojectId, tcontractId, folderName);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, String folderName, BigInteger parentId) {
        return getFolderIdByFolderNameByProject(StringSupport.getString(projectId), null, folderName, parentId);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(String projectId, String folderName, BigInteger parentId) {
        return getFolderIdByFolderNameByProject(projectId, null, folderName, parentId);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, String folderName) {
        return getFolderIdByFolderNameByProject(StringSupport.getString(projectId), null, folderName, null);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(String projectId, String folderName) {
        return getFolderIdByFolderNameByProject(projectId, null, folderName, null);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, eManageITFolder folderName) {
        return getFolderIdByFolderNameByProject(projectId, contractId, folderName.getValue(), null);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, String folderName) {
        return getFolderIdByFolderNameByProject(projectId, contractId, folderName, null);
    }

    @Override
    public String getNextSpecFolderNameStep(ManageITBodyRequest request, Integer type, eManageITFolder folderName) {
        if (request.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Empty Parameters.");
        } else if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "contractId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String projectId = request.getParams().get("projectId").toString();
        String contractId = request.getParams().get("contractId").toString();
        if (type == 1) {
            return dao.getNextSpecFolderNameStep(NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(contractId), folderName.getValue());
        } else {
            if (!request.getParams().isContainsAllKeys(new String[]{"persistenceId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            if (folderName.equalsName(eManageITFolder.eFSubmittal)) {
                String persistenceId = request.getParams().get("persistenceId").toString();
                Bpmsubmittalbo model = submittalService.findById(persistenceId);
                String subnumber = NumberSupport.getBigInteger(model.getSubnumber()).toString();
                return dao.getNextSpecFolderNameStep(NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(contractId), folderName.getValue(), subnumber);
            } else if (folderName.equalsName(eManageITFolder.eFRFI)) {

            }
            return null;
        }
    }

    @Override
    public BigDecimal createTrackITFolder(BigDecimal parentId, BigInteger projectId, BigInteger owner, BigInteger contractId, Character active, String visible, Character readonly, String folderName, BigInteger folderType, String folderNumber) {
        GlobFolder elem = new GlobFolder();
        elem.setParentId(parentId.toBigInteger());
        elem.setProjectId(projectId);
        elem.setFDate(Calendar.getInstance().getTime());
        elem.setCreated(Calendar.getInstance().getTime());
        elem.setOwner(owner);
        elem.setDefaultId(new BigInteger("-1"));
        elem.setFolderTypeId(folderType);
        elem.setDefaultGroupNum(BigInteger.ONE);
        elem.setContractId(contractId);
        elem.setActive(active);
        elem.setVisible(visible);
        elem.setReadOnly(readonly);
        elem.setFName(folderName);
        elem.setFNumber(folderNumber);
        return dao.save(elem).getId();
    }

    @Override
    public BigDecimal createTrackITFolder(BigDecimal parentId, BigInteger projectId, BigInteger owner, BigInteger contractId, Character active, String visible, Character readonly, String folderName, BigInteger folderType) {
        return createTrackITFolder(parentId, projectId, owner, contractId, active, visible, readonly, folderName, folderType, null);
    }

    /**
     * List of all the folders that belong to the root of the project. It
     * includes the case that the project has no contractId.
     *
     * @param projectId
     * @param contractId
     * @return List<BigDecimal>
     */
    @Override
    public BigDecimal getRootFolderIdByProject(BigInteger projectId, BigInteger contractId) {
        List<GlobFolder> root = list(new ManageITBodyRequest(0, 5).filter("projectId", projectId).filter("contractId", BigInteger.ZERO).filter("parentId", BigInteger.ZERO));

        if (root != null && root.size() == 1) {
            if (contractId != null && contractId.intValue() > 0) {
                List<GlobFolder> flevel = list(new ManageITBodyRequest(0, 5).filter("projectId", projectId).filter("contractId", contractId).filter("parentId", root.get(0).getId().toBigInteger()));
                if (flevel != null && flevel.size() == 1) {
                    return flevel.get(0).getId();
                }
            } else {
                return root.get(0).getId();
            }
        }
        return null;
    }

    @Override
    public BigDecimal getRootFolderIdByClient(BigInteger clientId) {
        List<GlobFolder> root = list(new ManageITBodyRequest(0, 2).filter("projectId", clientId.negate()).filter("parentId", clientId.negate()));
        if (root != null && !root.isEmpty()) {
            return root.get(0).getId();
        }
        return null;
    }

    @Override
    public String getNextFolderNumber(BigInteger parentId, String numberFormat) {
        return dao.getNextFolderNumber(parentId, numberFormat);
    }

    @Override
    public Map<String, String> createBPMFolderTrackIt(String userId, ManageITBodyRequest request, eManageITFolder folderName) {
        Map<String, String> response = new HashMap<>();
        if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "contractId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        BigInteger projectId = NumberSupport.getBigInteger(request.getParams().get("projectId").toString());
        BigInteger contractId = NumberSupport.getBigInteger(request.getParams().get("contractId").toString());
        BigInteger owner = NumberSupport.getBigInteger(userId);

        BigDecimal folderId = dao.getFolderIdByFolderNameByProject(projectId, contractId, folderName.getValue());

        if (folderId == null) {
            BigDecimal froot = getRootFolderIdByProject(projectId, contractId);
            folderId = createTrackITFolder(froot, projectId, owner, contractId, 'Y', "Y", 'N', folderName.getValue(), new BigInteger("2"), dao.getNextFolderNumber(froot.toBigInteger(), "#00.0"));
        }

        String nextStep;

        nextStep = getBPMNextStepByFolderType(request, folderName);

        BigDecimal rootFolderId = createTrackITFolder(folderId, projectId, owner, contractId, 'Y', "Y", 'N', nextStep, new BigInteger("2"));
        response.put("rootFolderId", rootFolderId.toString());
        response.put("nextStep", nextStep);
        createTrackITFolder(rootFolderId, projectId, owner, contractId, 'Y', "Y", 'N', nextStep + "-Doc", new BigInteger("2"));

        return response;
    }

    private String getBPMNextStepByFolderType(ManageITBodyRequest request, eManageITFolder folderName) {
        Boolean isRevision = request.getParams().containsKey("revision");
        BigInteger projectId = NumberSupport.getBigInteger(request.getParams().get("projectId").toString());
        BigInteger contractId = NumberSupport.getBigInteger(request.getParams().get("contractId").toString());
        if (isRevision) {
            String tkey = request.getParams().get("persistenceId").toString();
            String number = StringSupport.STRING_EMPTY;
            if (folderName.equalsName(eManageITFolder.eFSubmittal)) {
                Bpmsubmittalbo model = submittalService.findById(tkey);
                number = model.getSubnumber();
            } else if (folderName.equalsName(eManageITFolder.eFRFI)) {
                Bpmrfibo model = rfiService.findById(tkey);
                number = model.getRfinumber();
            } else if (folderName.equalsName(eManageITFolder.eFDispatch)) {
                Bpmdispatchbo model = dispatchService.findById(NumberSupport.getBigDecimal(tkey));
                number = model.getRequestnumber();
            } else if (folderName.equalsName(eManageITFolder.eFInspDispatch)) {
                Bpminspectordispatchbo model = inspDispatchService.findById(NumberSupport.getBigDecimal(tkey));
                number = model.getRequestnumber();
            }

            return dao.getNextSpecFolderNameStep(projectId, contractId, folderName.getValue(), number);
        }

        return dao.getNextSpecFolderNameStep(projectId, contractId, folderName.getValue());
    }

    @Override
    public String getNextFolderNameByIncrementalStep(BigInteger projectId, BigInteger contractId, String parentName) {
        if (projectId == null || StringSupport.isNullOrEmpty(parentName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        return dao.getNextSpecFolderNameStep(projectId, contractId, parentName);
    }

    @Override
    public BigDecimal getFolderIdByFunctionInProject(String function, BigInteger projectId, BigInteger clientId) {
        if (StringSupport.isNullOrEmpty(function) || projectId == null) {
            return null;
        }
        return dao.getFolderIdByFunctionInProject(function, projectId, clientId);
    }

    @Override
    public BigDecimal getFolderIdByFunctionInProject(String function, String projectId, String clientId) {
        return getFolderIdByFunctionInProject(function, NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(clientId));
    }

    @Override
    public GlobFolder getRootFolderByClientId(BigInteger clientId) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getClientFolder(NumberSupport.getBigInteger(clientId).negate());
    }

    @Override
    public GlobFolder getRootFolderByProjectId(BigInteger projectId, String projectType) {
        if (projectId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (projectType != null && !projectType.isEmpty() && "Planning".equals(projectType)) {
            return dao.getPlanProjectFolder(projectId);
        }
        return dao.getProjectFolder(projectId);
    }

    @Override
    public List<GlobFolder> listFolderByParentIdWithRights(BigInteger parentId, BigInteger userId, String roleName, Boolean isAdmin) {
        if (parentId == null || userId == null || roleName == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return isAdmin ? dao.listFolderByParentId(parentId) : dao.listFolderByParentIdWithRights(parentId, userId, roleName);
    }

    @Override
    public List<GlobFolder> getFolderTree(BigInteger folderId, BigInteger folderParentId, BigInteger projectId, BigInteger userId, String roleName, Boolean isAdmin) {
        if (folderParentId == null || userId == null || roleName == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobFolder> folders = new ArrayList<>();
        if (folderParentId.signum() == -1) {
            // parent id : negative -> load client folder.
            folders.add(getRootFolderByClientId(folderParentId.abs()));
        } else if (folderParentId.signum() == 0) {
            // parent id : zero -> load project and client folders.
            if (folderId == null || folderParentId == null || projectId == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            folders.add(getRootFolderByProjectId(projectId, null));
            folders.addAll(listFolderByParentIdWithRights(folderId, userId, roleName, isAdmin));
        } else {
            // load parent folders.
            folders.addAll(listFolderByParentIdWithRights(folderParentId, userId, roleName, isAdmin));
        }
        return folders;
    }

    @Override
    public DataGridWrapper<GlobFolder> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<GlobFolder> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GlobFolder> listFolderTreeByParentIdWithRights(BigInteger parentId, BigInteger userId, String roleName, Boolean isAdmin) {
        if (parentId == null || userId == null || roleName == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return isAdmin ? dao.listFolderTreeByParentId(parentId) : dao.listFolderTreeByParentIdWithRights(parentId, userId, roleName);
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void validateSubscriptions(ManageITHeader header, TemplateEngine engine, String action, GlobFolder elem, List<GlobDocumentChangePojo> docChanges, String subject, String messageText) {
        if (engine == null || header == null || !StringSupport.isNotNullAndNotEmpty(action) || elem == null || !StringSupport.isNotNullAndNotEmpty(action)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        // Get subscribers list by folder.
        List<String> emails = folderSubscribeService.listSubscribersEmailByFolderIds(Arrays.asList(elem.getId().toBigInteger(), elem.getParentId()));

        // Send emails to subscribers.
        if (!emails.isEmpty()) {

            // Populate message data.
            LinkedHashMap senderInfo = new AtserLinkedHashMap();
            senderInfo.put("docChangeTitle", messageText);
            senderInfo.put("docAction", action);
            senderInfo.put("docActionDate", DateSupport.getNowToFormat("MM/dd/yyyy HH:mm aaa"));
            senderInfo.put("docActionBy", header.getUser());
            senderInfo.put("docType", "Folder");
            senderInfo.put("docTitle", getFolderName(elem));
            senderInfo.put("docPath", getFolderPath(elem));
            senderInfo.put("changeList", docChanges);

            SystemMessage msg = new SystemMessage();
            msg.setTo(emails.toArray(new String[0]));
            msg.setSubject(subject);
            msg.setMessageText(null);
            msg.setFunctionality("tk_subscription_ntf");
            msg.setRefId(elem.getId().toString());
            msg.setIsSmsActive(Boolean.FALSE);
            if (elem.getPlanProjectId() != null) {
                msg.setProjectId(elem.getPlanProjectId());
                msg.setProjectType("Planning");
            } else {
                msg.setProjectId(elem.getProjectId());
            }
            msg.setSenderInfo(senderInfo);
            systemNotificationHelperService.notify(header, engine, msg, "AtserTkSubscriptionNtf");
        }
    }

    public String getFolderName(GlobFolder folder) {
        if (folder != null) {
            return StringSupport.isNotNullAndNotEmpty(folder.getFNumber()) ? folder.getFNumber() + " " + folder.getFName() : folder.getFName();
        } else {
            return "";
        }
    }

    @Override
    public String getFolderPath(GlobFolder folder) {
        String path = "";
        List<GlobFolder> list = dao.listFolderPathByParentId(folder.getId().toBigInteger());
        path = list.stream().map(item -> getFolderName(item) + "/").reduce(path, String::concat);
        return path;
    }

    @Override
    public String listDocumentToZip(BigDecimal parentId, String zipPath) {
        FileOutputStream fout = null;
        String zipFilePath = null;
        try {
            // Documents (Result List).
            List<DocumentBO> documents = new ArrayList<>();

            // Get parent folder.
            GlobFolder parentFolder = findById(parentId);

            // Get parent folder content (SubFolders and files).
            List<DocumentBO> parentFolderContent;
            parentFolderContent = dao.listDocumentToZip(parentFolder.getId());

            // Validate if the file already exist.
            Map<String, Integer> listExisting = new HashMap<>();
            for (DocumentBO doc : parentFolderContent) {
                if (doc.getServerPath() != null) { // (getServerPath() != null) -> Is file
                    if (listExisting.get(doc.getPath() + "-->" + doc.getTitle()) == null) {
                        documents.add(doc);
                        listExisting.put(doc.getPath() + "-->" + doc.getTitle(), 0);
                    } else {
                        listExisting.put(doc.getPath() + "-->" + doc.getTitle(), listExisting.get(doc.getPath() + "-->" + doc.getTitle()) + 1);
                        String newName = FilenameUtils.removeExtension(doc.getTitle()) + "_" + listExisting.get(doc.getPath() + "-->" + doc.getTitle()) + "." + FilenameUtils.getExtension(doc.getTitle());
                        doc.setTitle(newName);
                        documents.add(doc);
                    }
                } else { // Is folder.
                    // is a folder.
                    documents.add(doc);
                }
            }
            //------------------------------------------------------------------
            // Crete zip file.
            zipFilePath = zipPath + UUID.randomUUID().toString() + ".zip";
            fout = new FileOutputStream(zipFilePath);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            ZipOutputStream zout = new ZipOutputStream(bos);

            if (documents.isEmpty()) {
                zout.putNextEntry(new ZipEntry("/"));
                zout.closeEntry();
            } else {
                Integer cont = 0;
                for (DocumentBO document : documents) {
                    if (document.getPath().equals("-->")) {
                        zout.putNextEntry(new ZipEntry(document.getPath()));
                    } else {
                        if ((document.getServerPath() == null) || (document.getName() == null)) {
                            zout.putNextEntry(new ZipEntry(document.getPath().replaceAll("-->", "/") + "/"));
                            zout.closeEntry();
                        } else {
                            try {
                                String filePath = document.getPath().replaceAll("-->", "/") + "/" + document.getTitle();
                                zout.putNextEntry(new ZipEntry(filePath));
                            } catch (ZipException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (document.getServerPath() != null && new File(document.getServerPath()).exists()) {
                        FileInputStream fis = new FileInputStream(document.getServerPath());
                        int length;
                        byte[] buffer = new byte[1024];
                        while ((length = fis.read(buffer)) > 0) {
                            zout.write(buffer, 0, length);
                        }
                        fis.close();
                        zout.closeEntry();
                    } else if (DocumentBO.fileType.equals(document.getType())) {
                        System.out.println("Skip: " + document.toString());
                    }
                }
            }
            zout.close();
            bos.flush();
            bos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return zipFilePath;
    }

    @Override
    public String zipFolderByPackage(BigDecimal parentId, String zipPath) {
        FileOutputStream fout = null;
        String zipFilePath = null;
        try {
            // Documents (Result List).
            List<DocumentBO> documents = new ArrayList<>();

            // Get parent folder.
            GlobFolder parentFolder = findById(parentId);

            // Get parent folder content (SubFolders and files).
            List<DocumentBO> parentFolderContent;
            parentFolderContent = dao.listDocumentToZip(parentFolder.getId());

            // Validate if the file already exist.
            Map<String, Integer> listExisting = new HashMap<>();
            for (DocumentBO doc : parentFolderContent) {
                if (doc.getServerPath() != null) { // (getServerPath() != null) -> Is file
                    if (listExisting.get(doc.getPath() + "-->" + doc.getTitle()) == null) {
                        documents.add(doc);
                        listExisting.put(doc.getPath() + "-->" + doc.getTitle(), 0);
                    } else {
                        listExisting.put(doc.getPath() + "-->" + doc.getTitle(), listExisting.get(doc.getPath() + "-->" + doc.getTitle()) + 1);
                        String newName = FilenameUtils.removeExtension(doc.getTitle()) + "_" + listExisting.get(doc.getPath() + "-->" + doc.getTitle()) + "." + FilenameUtils.getExtension(doc.getTitle());
                        doc.setTitle(newName);
                        documents.add(doc);
                    }
                } else { // Is folder.
                    // is a folder.
                    documents.add(doc);
                }
            }
            //------------------------------------------------------------------
            // Crete zip file.
            zipFilePath = zipPath + UUID.randomUUID().toString() + ".zip";
            fout = new FileOutputStream(zipFilePath);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            ZipOutputStream zout = new ZipOutputStream(bos);

            if (documents.isEmpty()) {
                zout.putNextEntry(new ZipEntry("/"));
                zout.closeEntry();
            } else {
                Integer cont = 0;
                for (DocumentBO document : documents) {
                    if (document.getPath().equals("-->")) {
                        zout.putNextEntry(new ZipEntry(document.getPath()));
                    } else {
                        if ((document.getServerPath() == null) || (document.getName() == null)) {
                            zout.putNextEntry(new ZipEntry(document.getPath().replaceAll("-->", "/") + "/"));
                            zout.closeEntry();
                        } else {
                            try {
                                String filePath = document.getPath().replaceAll("-->", "/") + "/" + document.getTitle();
                                zout.putNextEntry(new ZipEntry(filePath));
                            } catch (ZipException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (document.getServerPath() != null && new File(document.getServerPath()).exists()) {
                        FileInputStream fis = new FileInputStream(document.getServerPath());
                        int length;
                        byte[] buffer = new byte[1024];
                        while ((length = fis.read(buffer)) > 0) {
                            zout.write(buffer, 0, length);
                        }
                        fis.close();
                        zout.closeEntry();
                    } else if (DocumentBO.fileType.equals(document.getType())) {
                        System.out.println("Skip: " + document.toString());
                    }
                }
            }
            zout.close();
            bos.flush();
            bos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(GlobFolderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return zipFilePath;
    }

}
