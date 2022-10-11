/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.objects.bo.FileDocumentBO;
import com.atser.tools.atserejb.dao.glob.GlobFileDao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserejb.model.GlobFileNotify;
import com.atser.tools.atserejb.model.GlobFileRevision;
import com.atser.tools.atserejb.model.GlobSiteaudit;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentSearchDefParam;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.service.helper.SystemNotificationHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobDocumentChangePojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
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
@Slf4j
public class GlobFileServiceImpl implements GlobFileService, IBaseEJBException {

    @Inject
    private GlobFileDao dao;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobFileRevisionService globFileRevisionService;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobFolderSubscribeService folderSubscribeService;

    @Inject
    private GlobFileSubscribeService fileSubscribeService;

    @Inject
    private SystemNotificationHelperService systemNotificationHelperService;

    @Inject
    private GlobUserService userService;

    @Inject
    private GlobProjectService projectServiceImpl;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private GlobSiteauditService siteauditService;

    @Inject
    private GlobFileNotifyService fileNotifyService;

    @Override
    public GlobFile findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobFile findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void update(ManageITHeader header, TemplateEngine engine, GlobFile elem) {
        if (elem != null) {
            GlobFile file = findById(elem.getId());

            List<GlobDocumentChangePojo> changes = new ArrayList<>();
            if (engine != null && header != null) {
                if (elem.getFTitle() == null ? file.getFTitle() != null : !elem.getFTitle().equals(file.getFTitle())) {
                    changes.add(new GlobDocumentChangePojo("Title", file.getFTitle(), elem.getFTitle()));
                }
                if (elem.getFFrom() == null ? file.getFFrom() != null : !elem.getFFrom().equals(file.getFFrom())) {
                    changes.add(new GlobDocumentChangePojo("From", file.getFFrom(), elem.getFFrom()));
                }
                if (elem.getFTo() == null ? file.getFTo() != null : !elem.getFTo().equals(file.getFTo())) {
                    changes.add(new GlobDocumentChangePojo("To", file.getFTo(), elem.getFTo()));
                }
                if (elem.getSubject() == null ? file.getSubject() != null : !elem.getSubject().equals(file.getSubject())) {
                    changes.add(new GlobDocumentChangePojo("Subject", file.getSubject(), elem.getSubject()));
                }
                if (elem.getDistributedTo() == null ? file.getDistributedTo() != null : !elem.getDistributedTo().equals(file.getDistributedTo())) {
                    changes.add(new GlobDocumentChangePojo("Distributed To", file.getDistributedTo(), elem.getDistributedTo()));
                }
                if (elem.getKeywords() == null ? file.getKeywords() != null : !elem.getKeywords().equals(file.getKeywords())) {
                    changes.add(new GlobDocumentChangePojo("Keywords", file.getKeywords(), elem.getKeywords()));
                }
                if (elem.getDescription() == null ? file.getDescription() != null : !elem.getDescription().equals(file.getDescription())) {
                    changes.add(new GlobDocumentChangePojo("Description", file.getDescription(), elem.getDescription()));
                }
            }

            file.setFTitle(elem.getFTitle());
            file.setFFrom(elem.getFFrom());
            file.setFTo(elem.getFTo());
            file.setSubject(elem.getSubject());
            file.setDistributedTo(elem.getDistributedTo());
            file.setKeywords(elem.getKeywords());
            file.setDescription(elem.getDescription());

            dao.update(file);

            if (engine != null && header != null) {
                validateSubscriptions(header, engine, "update_file", file, changes, "Document Notification - File Change", "File Change");
            }

            if (!changes.isEmpty()) {
                String changeResult = "modify: ";
                for (GlobDocumentChangePojo change : changes) {
                    changeResult += change.fieldName + " changed ";
                    // Old Value
                    if (StringSupport.isNullOrEmpty(change.oldValue)) {
                        changeResult += "from ('Empty') ";
                    } else {
                        changeResult += "from (" + change.oldValue + ") ";
                    }
                    // New Value
                    if (StringSupport.isNullOrEmpty(change.newValue)) {
                        changeResult += "to ('Empty'); ";
                    } else {
                        changeResult += "to (" + change.newValue + "); ";
                    }
                    // changeResult += change.fieldName + " changed from (" + (StringSupport.isNullOrEmpty(change.oldValue) ? change.oldValue : "'Empty'") + ") to (" + (StringSupport.isNullOrEmpty(change.newValue) ? "'Empty'" : change.newValue) + "); ";
                }
                siteauditService.save(header, new GlobSiteaudit(new GlobUsers(new BigDecimal(header.getUserid())), new Date(), "glob_file", file.getId().toBigInteger(),
                        file.getProjectId(), file.getContractId(), changeResult, file.getFTitle(), file.getFolderId().getId().toBigInteger(), 'N'));
            }
        }
    }

    @Override
    public void delete(BigInteger id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        delete(null, null, new BigDecimal(id));
    }

    @Override
    public void delete(String id) {
        delete(null, null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeysAndNotNull(new String[]{"id"})
                && !request.getParams().isContainsAllKeysAndNotNull(new String[]{"ids"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (request.getParams().containsKey("id")) {
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
        GlobFile elem = findById(id);
        dao.delete(id);
        if (engine != null && header != null) {
            validateSubscriptions(header, engine, "remove_file", elem, null, "Document Notification - File Change", "File Change");
        }
        if (header != null) {
            siteauditService.save(header, new GlobSiteaudit(new GlobUsers(new BigDecimal(header.getUserid())),
                    new Date(), "glob_file", elem.getId().toBigInteger(), elem.getProjectId(), elem.getContractId(),
                    "delete" + elem.getVersion() + ")", elem.getFTitle(), elem.getFolderId().getId().toBigInteger(), 'N'));
        }
    }

    @Override
    public void delete(ManageITHeader header, TemplateEngine engine, List<BigInteger> ids) {
        if (StringSupport.isNullOrEmpty(ids)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobFile> files = dao.listByIds(ids);
        dao.delete(ids);
        if (engine != null && header != null) {
            files.forEach(file -> {
                validateSubscriptions(header, engine, "remove_file", file, null, "Document Notification - File Change", "File Change");
            });
        }
    }

    @Override
    public BigInteger saveFileToDbByFunctionality(String function, String projectId, ManageITHeader header, Map<String, Object> metaDataFile) {
        // Get folder by function in project.
        if (StringSupport.isNullOrEmpty(function, projectId)) {
            log.error("@ATSER: saveFileToDbByFunctionality - Wrong parameters. function: " + StringSupport.emptyOnNull(function)
                    + " - projectId: " + StringSupport.emptyOnNull(projectId));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigDecimal folderId = folderService.getFolderIdByFunctionInProject(function, projectId, header.getClientid());
        return saveFileToDbByFunctionality(folderId, projectId, header, metaDataFile);
    }

    @Override
    public BigInteger saveFileToDbByFunctionality(BigDecimal folderId, String projectId, ManageITHeader header, Map<String, Object> metaDataFile) {
        GlobClient client = globClientService.findById(header.getClientid());
        if (client != null) {
            // Validations.
            if (folderId == null || metaDataFile == null || StringSupport.isNullOrEmpty(projectId)) {
                log.error("@ATSER: saveFileToDbByFunctionality - Wrong parameters. folderId: " + StringSupport.emptyOnNull(folderId)
                        + " - projectId: " + StringSupport.emptyOnNull(projectId)
                        + " - metaDataFile: " + StringSupport.emptyOnNull(metaDataFile));
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            // Get parameters. 
            Map<String, Object> params = new HashMap<>();
            params.put("folderId", folderId);
            params.put("projectId", projectId);
            params.put("clientId", header.getClientid());
            params.put("useglobaldcn", (StringSupport.isNotNullAndNotEmpty(client.getUseGlobalDCN()) && client.getUseGlobalDCN().equals("Y")) ? "true" : "false");
            params.put("userId", header.getUserid());
            params.put("from", header.getUser());
            // Save file in database.
            return saveFileToDb(metaDataFile, params, null);
        }
        return BigInteger.ZERO;
    }

    @Override
    public BigInteger saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, String keywords) {
        return saveFileToDb(metaDataFile, params, null, keywords);
    }

    @Override
    public BigInteger saveFileToDb(UploadModel uploadModel, String keywords) {
        if (uploadModel != null && uploadModel.getMetaDataFile() != null && uploadModel.getParams() != null) {
            return saveFileToDb(uploadModel.getMetaDataFile(), uploadModel.getParams(), null, keywords);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return BigInteger.ZERO;
    }

    @Override
    public List<BigInteger> saveFileToDb(ManageITHeader header, TemplateEngine engine, ManageITBodyRequest request, String from, String keywords) {
        List<BigInteger> ids = new ArrayList<>();
        List<UploadModel> uploadModels = (List<UploadModel>) request.getData();
        uploadModels.forEach(uploadModel -> {
            if (uploadModel != null && uploadModel.getMetaDataFile() != null && uploadModel.getParams() != null) {
                ids.add(saveFileToDb(header, request, engine, uploadModel.getMetaDataFile(), uploadModel.getParams(), null, keywords));
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
        });
        // if ("true".equals(request.getParams().get("notify").toString())) {
        //    request.getParams().put("fileIds", ids);
        //    notifyUpload(header, request, engine);
        // }
        return ids;
    }

    @Override
    public BigInteger saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords) {
        return saveFileToDb(null, null, null, metaDataFile, params, from, keywords);
    }

    @Override
    public BigInteger saveFileToDb(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine, Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords) {
        if (!params.containsKey("folderId") || StringSupport.isNullOrEmpty(params.get("folderId"))) {
            log.error("@ATSER: saveFileToDb - Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobFolder folderId = folderService.findById(params.get("folderId").toString());
        if (folderId != null) {
            List<GlobFile> fileList = list(new ManageITBodyRequest(0, 0).filter("folderId.id", folderId.getId()).filter("fTitle", StringSupport.emptyOnNull(metaDataFile.get("ofilename"))));
            if (fileList != null && !fileList.isEmpty()) {
                GlobFile filedb = fileList.get(0);
                GlobFileRevision fileRev = new GlobFileRevision(filedb);
                globFileRevisionService.save(fileRev);
                if (filedb.getVersion() != null) {
                    filedb.setVersion(filedb.getVersion().add(BigInteger.ONE));
                } else {
                    filedb.setVersion(BigInteger.ONE);
                }
                filedb.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
                filedb.setFName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
                filedb.setUploaded(new Date());
                dao.update(filedb);

                if (engine != null && header != null) {
                    validateSubscriptions(header, engine, "version_file", filedb, null, "Document Notification - File Change", "File Change");
                }

                // Old System Features
                if (header != null) {
                    try {

                        // Audit
                        BigDecimal auditId = siteauditService.save(header, new GlobSiteaudit(new GlobUsers(new BigDecimal(header.getUserid())),
                                new Date(), "glob_file", filedb.getId().toBigInteger(), filedb.getProjectId(), filedb.getContractId(),
                                "update (new version: V" + filedb.getVersion() + ")", filedb.getFTitle(), filedb.getFolderId().getId().toBigInteger(), 'N'));
                        // Notify Log
                        if ("true".equals(request.getParams().get("notify").toString())) {
                            List<String> userIds = (List<String>) request.getParams().get("userIds");
                            for (String userId : userIds) {
                                fileNotifyService.save(header, new GlobFileNotify(filedb.getId().toBigInteger(), new GlobUsers(new BigDecimal(header.getUserid())), new GlobUsers(new BigDecimal(userId)), new Date(), new GlobSiteaudit(auditId)));
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return NumberSupport.getBigInteger(filedb.getId());
            } else {
                return saveFile(header, request, engine, new GlobFile(), folderId, metaDataFile, params, from, keywords);
            }
        }
        return BigInteger.ZERO;
    }

    private BigInteger saveFile(GlobFile elem, GlobFolder folderId, Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords) {
        return saveFile(null, null, null, new GlobFile(), folderId, metaDataFile, params, from, keywords);
    }

    private BigInteger saveFile(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine, GlobFile elem, GlobFolder folderId, Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords) {
        // Get parameter client id.
        BigInteger clientId = (params.containsKey("clientId") && StringSupport.isNotNullAndNotEmpty(params.get("clientId"))) ? NumberSupport.getBigInteger(params.get("clientId").toString()) : null;
        if (clientId == null) {
            log.error("@ATSER: saveFile - Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        // Get parameter useglobal dcn.
        Boolean useGlobalDCN = false;
        if (params.containsKey("useglobaldcn") && StringSupport.isNotNullAndNotEmpty(params.get("useglobaldcn")) && !params.get("useglobaldcn").equals("null")) {
            useGlobalDCN = Boolean.valueOf(params.get("useglobaldcn").toString());
        } else {
            GlobClient client = globClientService.findById(StringSupport.getString(params.get("clientId")));
            if (client != null) {
                useGlobalDCN = StringSupport.getBoolean(client.getUseGlobalDCN());
            }
        }

        // Get parameter project or plan project id.
        BigInteger planProjectId = (params.containsKey("planProjectId") && StringSupport.isNotNullAndNotEmpty(params.get("planProjectId"))) ? NumberSupport.getBigInteger(params.get("planProjectId").toString()) : null;
        BigInteger projectId = (params.containsKey("projectId") && StringSupport.isNotNullAndNotEmpty(params.get("projectId"))) ? NumberSupport.getBigInteger(params.get("projectId").toString()) : null;
        if (planProjectId != null && planProjectId.signum() != 0) {
            elem.setPlanProjectId(planProjectId);
        } else if (projectId != null && projectId.signum() != 0) {
            elem.setProjectId(projectId);
        } else {
            elem.setProjectId(clientId.negate());
        }

        // Get parameter contract id.
        if (StringSupport.isNotNullAndNotEmpty(params.get("contractId"))) {
            elem.setContractId(NumberSupport.getBigInteger(StringSupport.emptyOnNull(params.get("contractId"))));
        } else {
            elem.setContractId(BigInteger.ZERO);
        }

        // Get parameter from.
        if (from == null || from.isEmpty()) {
            if (params.get("from") != null && !params.get("from").toString().isEmpty()) {
                from = params.get("from").toString();
            }
        }
        elem.setFFrom(from);

        // Get parameter keywords.
        if (keywords == null || keywords.isEmpty()) {
            if (params.get("keywords") != null && !params.get("keywords").toString().isEmpty()) {
                keywords = params.get("keywords").toString();
            }
        }
        elem.setSystemKeywords(keywords + "," + metaDataFile.get("ofilename") + "," + metaDataFile.get("ext"));

        // Set DCN.
        if (useGlobalDCN) {
            elem.setDcn(getNextDCNByClient(clientId));
        } else {
            if (elem.getPlanProjectId() != null) {
                elem.setDcn(getNextDCNByPlanProject(elem.getPlanProjectId()));
            } else if (elem.getProjectId() != null) {
                elem.setDcn(getNextDCNByProject(elem.getProjectId()));
            } else {
                log.error("@ATSER: saveFile - (useGlobalDCN = false and ProjectId = null and PlanProjectId = null)");
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong DCN Configuration.");
            }
        }

        elem.setFolderId(folderId);
        elem.setFDate(new Date());
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        elem.setSourcePath(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setOwner(NumberSupport.getBigInteger(StringSupport.emptyOnNull(params.get("userId"))));
        elem.setFTitle(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setFName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setFSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setVersion(BigInteger.ONE);
        elem.setCheckoutId(BigInteger.ZERO);
        elem.setCheckoutTime(new Date());
        elem.setFileStatus("open");
        elem.setUploaded(new Date());
        elem.setActive('Y');
        return save(header, request, engine, elem);
    }

    @Override
    public BigInteger save(GlobFile elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return save(null, null, null, elem);
    }

    public BigInteger save(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine, GlobFile elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger id = dao.save(elem).getId().toBigInteger();
        if (engine != null && header != null) {
            validateSubscriptions(header, engine, "save_file", elem, null, "Document Notification - File Change", "File Change");
        }

        // Old System Features
        try {
            // Audit
            BigDecimal auditId = siteauditService.save(header, new GlobSiteaudit(new GlobUsers(new BigDecimal(header.getUserid())),
                    new Date(), "glob_file", elem.getId().toBigInteger(), elem.getProjectId(), elem.getContractId(),
                    "upload", elem.getFTitle(), elem.getFolderId().getId().toBigInteger(), 'N'));
            // Notify Log
            if ("true".equals(request.getParams().get("notify").toString())) {
                List<String> userIds = (List<String>) request.getParams().get("userIds");
                for (String userId : userIds) {
                    fileNotifyService.save(header, new GlobFileNotify(elem.getId().toBigInteger(), new GlobUsers(new BigDecimal(header.getUserid())), new GlobUsers(new BigDecimal(userId)), new Date(), new GlobSiteaudit(auditId)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public List<GlobFile> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<GlobFile> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<GlobFile> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<GlobFile> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobFile> finalList = list(request);
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
    public List<FileDocumentBO> listByFolder(String folderId) {
        List<GlobFile> listSrc = dao.findAByFolder(NumberSupport.getBigDecimal(folderId));
        List<FileDocumentBO> listtarget = new ArrayList<>();
        listSrc.forEach((globFile) -> {
            String url = "/ws/rs/resources/files/download?f=";
            listtarget.add(new FileDocumentBO(globFile, url));
        });
        return listtarget;
    }

    @Override
    public String getNextDCNByClient(BigInteger clientId) {
        return dao.getNextDCNByClient(clientId);
    }

    @Override
    public String getNextDCNByProject(BigInteger projectId) {
        return dao.getNextDCNByProject(projectId);
    }

    @Override
    public String getNextDCNByPlanProject(BigInteger projectId) {
        return dao.getNextDCNByPlanProject(projectId);
    }

    @Override
    public void copyFilesToFolder(ManageITHeader header, List<String> filesId, BigDecimal folderId) {
        if (filesId != null && !filesId.isEmpty() && folderId != null && StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            GlobClient client = globClientService.findById(header.getClientid());
            if (client != null) {
                Boolean useGlobalDCN = StringSupport.getBoolean(client.getUseGlobalDCN());
                GlobFolder folder = folderService.findById(folderId);
                if (folder != null) {
                    filesId.stream().forEach(fileId -> {
                        GlobFile filedb = dao.findById(NumberSupport.getBigDecimal(fileId));
                        if (filedb != null) {
                            GlobFile file = new GlobFile();
                            file.setId(null);
                            file.setFolderId(folder);
                            file.setFDate(new Date());
                            file.setExtension(filedb.getExtension());
                            file.setSourcePath(filedb.getSourcePath());
                            file.setOwner(NumberSupport.getBigInteger(header.getUserid()));
                            file.setFTitle(filedb.getFTitle());
                            file.setFName(filedb.getFName());
                            file.setServerPath(filedb.getServerPath());
                            file.setProjectId(filedb.getProjectId());
                            file.setSourceName(filedb.getSourceName());
                            file.setKeywords(filedb.getKeywords());
                            file.setFSize(filedb.getFSize());
                            file.setVersion(BigInteger.ZERO);
                            file.setCheckoutId(filedb.getCheckoutId());
                            file.setCheckoutTime(filedb.getCheckoutTime());
                            file.setFileStatus(filedb.getFileStatus());
                            if (useGlobalDCN) {
                                file.setDcn(getNextDCNByClient(NumberSupport.getBigInteger(header.getClientid())));
                            } else {
                                file.setDcn(getNextDCNByProject(file.getProjectId()));
                            }
                            file.setSystemKeywords(filedb.getSystemKeywords());
                            file.setFFrom(filedb.getFFrom());
                            file.setFTo(filedb.getFTo());
                            file.setSubject(filedb.getSubject());
                            file.setDistributedTo(filedb.getDistributedTo());
                            file.setContractId(filedb.getContractId());
                            file.setUploaded(new Date());
                            file.setActive(filedb.getActive());
                            file.setDescription(filedb.getDescription());
                            file.setField3(filedb.getField3());
                            file.setField4(filedb.getField4());
                            file.setField5(filedb.getField5());
                            file.setField6(filedb.getField6());
                            dao.save(file);
                        }
                    });
                }
            }
        }
    }

    @Override
    public Object getFrontEndSearch(ManageITHeader header, DocumentSearchDefParam param, Boolean wrap) {
        if (param == null || !param.isDataValid()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(param.dt)) {
            return dao.getFrontEndSearch(param, wrap);
        } else {
            switch (param.dt) {
                case "table": {
                    return dao.getFrontEndSearch(param, wrap);
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void lockFile(BigDecimal fileId, BigDecimal userId) {
        dao.lockFile(fileId, userId);
    }

    @Override
    public void unlockFile(BigDecimal fileId) {
        dao.unlockFile(fileId);
    }

    @Override
    public Boolean isFileLocked(BigDecimal fileId, BigDecimal userId) {
        return dao.isFileLocked(fileId, userId);
    }

    public void validateSubscriptions(ManageITHeader header, TemplateEngine engine, String action, GlobFile file, List<GlobDocumentChangePojo> docChanges, String subject, String messageText) {
        if (engine == null || header == null || !StringSupport.isNotNullAndNotEmpty(action) || file == null || !StringSupport.isNotNullAndNotEmpty(action)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        // Get subscribers list by folder.
        List<String> emails = folderSubscribeService.listSubscribersEmailByFolderIds(Arrays.asList(file.getFolderId().getId().toBigInteger()));
        List<String> emailsTmp = fileSubscribeService.listSubscribersEmailByFileId(file.getFolderId().getId().toBigInteger());

        // Merge list and clean duplicates.
        emails.removeAll(emailsTmp);
        emails.addAll(emailsTmp);

        // Send emails to subscribers.
        if (!emails.isEmpty()) {

            // Populate message data.
            LinkedHashMap senderInfo = new AtserLinkedHashMap();
            senderInfo.put("docChangeTitle", messageText);
            senderInfo.put("docAction", action);
            senderInfo.put("docActionDate", DateSupport.getNowToFormat("MM/dd/yyyy HH:mm aaa"));
            senderInfo.put("docActionBy", header.getUser());
            senderInfo.put("docType", "Folder");
            senderInfo.put("docTitle", file.getFTitle());
            senderInfo.put("docPath", folderService.getFolderPath(file.getFolderId()));
            senderInfo.put("changeList", docChanges);

            SystemMessage msg = new SystemMessage();
            msg.setTo(emails.toArray(new String[0]));
            msg.setSubject(subject);
            msg.setMessageText(null);
            msg.setFunctionality("tk_subscription_ntf");
            msg.setRefId(file.getId().toString());
            msg.setIsSmsActive(Boolean.FALSE);
            if (file.getPlanProjectId() != null) {
                msg.setProjectId(file.getPlanProjectId());
                msg.setProjectType("Planning");
            } else {
                msg.setProjectId(file.getProjectId());
            }
            msg.setSenderInfo(senderInfo);
            systemNotificationHelperService.notify(header, engine, msg, "AtserTkSubscriptionNtf");
        }
    }

    @Override
    public void notifyUpload(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine) {
        // Get params information (Project & Folder & User).
        BigInteger projectId = NumberSupport.getBigInteger(request.getParams().get("projectId"));
        String projectType = request.getParams().get("projectType").toString();
        GlobFolder folder = folderService.findById(NumberSupport.getBigDecimal(request.getParams().get("folderId")));
        GlobUsers user = userService.findById(header.getUserid());

        // Get params information (Files [Uploaded] -> Names).
        List<GlobFile> files = list(new ManageITBodyRequest(0, 0).filter("id", request.getParams().get("fileIds"), ":="));
        List<String> fileNames = files.stream().map(GlobFile::getFTitle).collect(Collectors.toList());

        // Get params information (Users [Receivers] -> Emails).
        List<BigDecimal> userIds = (List<BigDecimal>) request.getParams().get("userIds");
        List<GlobUsers> users = userService.list(new ManageITBodyRequest(0, 0).filter("id", userIds, ":="));
        List<String> userEmails = users.stream().map(GlobUsers::getContactid).map(GlobContact::getEmail).collect(Collectors.toList());

        // Validate receivers emails.
        if (!userEmails.isEmpty()) {
            // Populate message content.
            LinkedHashMap senderInfo = new AtserLinkedHashMap();
            senderInfo.put("folderName", folder.getFullName());
            senderInfo.put("userName", user.getContactid().getFullName());
            senderInfo.put("date", DateSupport.getNowToFormat("MM/dd/yyyy HH:mm aaa"));
            senderInfo.put("fileNames", fileNames);

            // Create message.
            SystemMessage msg = new SystemMessage();
            msg.setTo(userEmails.toArray(new String[0]));
            msg.setSubject("File upload notification");
            msg.setMessageText(null);

            msg.setSenderInfo(senderInfo);
            msg.setProjectId(projectId);
            msg.setProjectType(projectType);

            msg.setIsSmsActive(Boolean.FALSE);
            msg.setFunctionality("tk_upload_file_notification");

            // Send notification.
            systemNotificationHelperService.notify(header, engine, msg);
        }
    }

    //--[ Advance Search ]------------------------------------------------------
    @Override
    public Object getFrontEndSearchAdvance(ManageITHeader header, DocumentSearchDefParam dParam, AtserLinkedHashMap<String, Object> sParam, Boolean wrap) {
        if (dParam == null || !dParam.isDataValid()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(dParam.dt)) {
            return dao.getFrontEndSearchAdvance(dParam, sParam, wrap);
        } else {
            switch (dParam.dt) {
                case "table": {
                    return dao.getFrontEndSearchAdvance(dParam, sParam, wrap);
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public String generateFileReport(ManageITHeader header, ManageITBodyRequest request, DocumentSearchDefParam defParam, Boolean advanceSearch, String tplbasePath, String docpathsegment) {
        if (defParam == null || StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(defParam.reportId, defParam.functionId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), defParam.functionId, defParam.reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            return buildReport(tplbasePath, tplpath, docpathsegment, header, request, defParam, paramsJasper, advanceSearch);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String buildReport(String tplbasePath, String tplpath, String docpathsegment, ManageITHeader header, ManageITBodyRequest request, DocumentSearchDefParam defParam, Map<String, Object> paramsJasper, Boolean advanceSearch) {
        eDocExtension extension;
        if (defParam.docType == null || defParam.docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(defParam.docType);
        }
        BufferedImage clientLogoImage = genericHelperService.getClientLogo(header.getClientid());
        paramsJasper.put("CLIENT_LOGO", clientLogoImage);

        DataTableWrapper<DocumentBO> ds;
        if (advanceSearch) {
            ds = (DataTableWrapper<DocumentBO>) getFrontEndSearchAdvance(header, defParam, request.getParams(), false);
        } else {
            ds = (DataTableWrapper<DocumentBO>) getFrontEndSearch(header, defParam, false);
        }
        String targetPath = docpathsegment + "File_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, ds.getData(), targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private List<GlobFile> generateReportData(BigDecimal folderId) {

        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("folderId", folderId);
        List<GlobFile> fileList = list(search);

        List<DocumentBO> boList = new ArrayList<>();
        for (GlobFile file : fileList) {

        }

        return fileList;
    }

    @Override
    public String zipFiles(List<BigDecimal> ids, String zipPath) {
        // Load files by ids.
        List<GlobFile> files = list(new ManageITBodyRequest(0, 0).filter("id", ids, ":="));

        // Generate zip name.
        String zipFilePath = zipPath + UUID.randomUUID().toString() + ".zip";

        // Generate zip file.
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(zipFilePath);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            ZipOutputStream zout = new ZipOutputStream(bos);

            for (GlobFile file : files) {
                if (file.getServerPath() != null && new File(file.getServerPath()).exists()) {
                    // add entry.
                    zout.putNextEntry(new ZipEntry(file.getFTitle()));
                    // write entry.
                    FileInputStream fis = new FileInputStream(file.getServerPath());
                    int length;
                    byte[] buffer = new byte[1024];
                    while ((length = fis.read(buffer)) > 0) {
                        zout.write(buffer, 0, length);
                    }
                    fis.close();
                    zout.closeEntry();
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
