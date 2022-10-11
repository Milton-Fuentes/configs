/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.to.pattern.AtserFolderView;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface GlobFolderService extends ICrudService<BigDecimal, GlobFolder> {

    void update(GlobFolder elem);

    void update(ManageITHeader header, TemplateEngine engine, GlobFolder elem);

    void delete(BigInteger id);

    void delete(ManageITBodyRequest request);

    void delete(ManageITHeader header, TemplateEngine engine, BigDecimal id);

    void delete(ManageITHeader header, TemplateEngine engine, List<BigInteger> ids);

    BigDecimal save(GlobFolder elem);

    BigDecimal save(ManageITHeader header, TemplateEngine engine, GlobFolder elem);

    String getFolderPath(GlobFolder folder);

    String getNextFolderNumber(BigInteger parentId, String numberFormat);

    String getNextFolderNameByIncrementalStep(BigInteger projectId, BigInteger contractId, String parentName);

    // Particular Querys
    BigDecimal createTrackITFolder(BigDecimal parentId, BigInteger projectId, BigInteger owner, BigInteger contractId, Character active, String visible, Character readonly, String folderName, BigInteger folderType);

    BigDecimal createTrackITFolder(BigDecimal parentId, BigInteger projectId, BigInteger owner, BigInteger contractId, Character active, String visible, Character readonly, String folderName, BigInteger folderType, String folderNumber);

    String getNextSpecFolderNameStep(ManageITBodyRequest request, Integer type, eManageITFolder folderName);

    BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, eManageITFolder folderName);

    BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, String folderName);

    BigDecimal getFolderIdByFolderNameByProject(String projectId, String contractId, String folderName, BigInteger parentId);

    BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, String folderName);

    BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, String folderName, BigInteger parentId);

    BigDecimal getFolderIdByFolderNameByProject(String projectId, String folderName);

    BigDecimal getFolderIdByFolderNameByProject(String projectId, String folderName, BigInteger parentId);

    BigDecimal getFolderIdByClientBy(String clientId, eManageITFolder folderName);

    BigDecimal getFolderIdByClientBy(String clientId, String folderName);

    BigDecimal getFolderIdByClientBy(String clientId, String folderName, BigInteger parentId);

    BigDecimal getRootFolderIdByProject(BigInteger projectId, BigInteger contractId);

    BigDecimal getRootFolderIdByClient(BigInteger clientId);

    BigDecimal getFolderIdByFunctionInProject(String function, String projectId, String clientId);

    BigDecimal getFolderIdByFunctionInProject(String function, BigInteger projectId, BigInteger clientId);

    GlobFolder findByBPMFName(String projectId, String contractId, String subStep, eManageITFolder folderName);

    GlobFolder getFolderByClientBy(String clientId, eManageITFolder folderName);

    GlobFolder getFolderByClientBy(String clientId, String folderName);

    GlobFolder getFolderByClientBy(String clientId, String folderName, BigInteger parentId);

    GlobFolder getRootFolderByClientId(BigInteger clientId);

    GlobFolder getRootFolderByProjectId(BigInteger projectId, String projectType);

    List<AtserFolderView> folderList(ManageITBodyRequest request, eManageITFolder folderName, String module);

    List<GlobFolder> listFolderByParentIdWithRights(BigInteger parentId, BigInteger userId, String roleName, Boolean isAdmin);

    List<GlobFolder> listFolderTreeByParentIdWithRights(BigInteger parentId, BigInteger userId, String roleName, Boolean isAdmin);

    List<GlobFolder> getFolderTree(BigInteger folderId, BigInteger folderParentId, BigInteger projectId, BigInteger userId, String roleName, Boolean isAdmin);

    Map<String, String> createBPMFolderTrackIt(String userId, ManageITBodyRequest request, eManageITFolder folderName);

    String listDocumentToZip(BigDecimal parentId, String zipPath);

    String zipFolderByPackage(BigDecimal parentId, String zipPath);
}
