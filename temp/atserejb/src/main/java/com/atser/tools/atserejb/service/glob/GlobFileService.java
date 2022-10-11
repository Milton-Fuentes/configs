/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.objects.bo.FileDocumentBO;
import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentSearchDefParam;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.objects.pojo.glob.GlobPermsModelDocSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
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
public interface GlobFileService {

    GlobFile findById(String id);

    BigInteger save(GlobFile elem);

    void update(ManageITHeader header, TemplateEngine engine, GlobFile elem);

    void delete(BigInteger id);

    void delete(String id);

    void delete(ManageITBodyRequest request);

    void delete(ManageITHeader header, TemplateEngine engine, BigDecimal id);

    void delete(ManageITHeader header, TemplateEngine engine, List<BigInteger> ids);

    DataGridWrapper<GlobFile> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<GlobFile> dataTableList(ManageITBodyRequest request);

    List<GlobFile> list(ManageITBodyRequest request);

    List<FileDocumentBO> listByFolder(String folderId);

    String getNextDCNByClient(BigInteger clientId);

    String getNextDCNByProject(BigInteger projectId);

    String getNextDCNByPlanProject(BigInteger projectId);

    BigInteger saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords);

    BigInteger saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, String keywords);

    BigInteger saveFileToDb(UploadModel uploadModel, String keywords);

    List<BigInteger> saveFileToDb(ManageITHeader header, TemplateEngine engine, ManageITBodyRequest request, String from, String keywords);

    BigInteger saveFileToDb(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine, Map<String, Object> metaDataFile, Map<String, Object> params, String from, String keywords);

    BigInteger saveFileToDbByFunctionality(BigDecimal folderId, String projectId, ManageITHeader header, Map<String, Object> metaDataFile);

    BigInteger saveFileToDbByFunctionality(String function, String projectId, ManageITHeader header, Map<String, Object> metaDataFile);

    void copyFilesToFolder(ManageITHeader header, List<String> filesId, BigDecimal folderId);

    Object getFrontEndSearch(ManageITHeader header, DocumentSearchDefParam param, Boolean wrap);

    void lockFile(BigDecimal fileId, BigDecimal userId);

    void unlockFile(BigDecimal fileId);

    Boolean isFileLocked(BigDecimal fileId, BigDecimal userId);

    void notifyUpload(ManageITHeader header, ManageITBodyRequest request, TemplateEngine engine);

    //--[ Advance Search ]------------------------------------------------------
    Object getFrontEndSearchAdvance(ManageITHeader header, DocumentSearchDefParam dParam, AtserLinkedHashMap<String, Object> sParam, Boolean wrap);

    String generateFileReport(ManageITHeader header, ManageITBodyRequest request, DocumentSearchDefParam defParam, Boolean advanceSearch, String tplbasePath, String docpathsegment);

    String zipFiles(List<BigDecimal> ids, String zipPath);
}
