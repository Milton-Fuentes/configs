/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.to.pattern.AtserFolderView;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFolderDao extends ICrudDao<BigDecimal, GlobFolder> {

    void delete(List<BigInteger> ids);

    String getNextFolderNumber(BigInteger parentId, String numberFormat);

    String getNextSpecFolderNameStep(BigInteger projectId, BigInteger contractId, String name);

    String getNextSpecFolderNameStep(BigInteger projectId, BigInteger contractId, String name, String folderName);

    BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, BigInteger contractId, String name);

    BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, BigInteger contractId, String name, BigInteger parentId);

    BigDecimal getFolderIdByFunctionInProject(String functionName, BigInteger projectId, BigInteger clientId);

    Boolean exists(String folderNumber, String folderName, BigInteger folderParentId);

    GlobFolder findByFName(BigInteger projectId, BigInteger contractId, String subname, String name);

    GlobFolder getClientFolder(BigInteger clientId);

    GlobFolder getProjectFolder(BigInteger projectId);

    GlobFolder getPlanProjectFolder(BigInteger projectId);

    List<AtserFolderView> folderList(String mode, BigInteger projectId, BigInteger contractId, String name);

    List<GlobFolder> listByIds(List<BigInteger> ids);

    List<GlobFolder> listFolderByParentId(BigInteger parentId);

    List<GlobFolder> listFolderByParentIdWithRights(BigInteger parentId, BigInteger userId, String role_name);

    List<GlobFolder> listFolderTreeByParentId(BigInteger parentId);

    List<GlobFolder> listFolderTreeByParentIdWithRights(BigInteger parentId, BigInteger userId, String role_name);

    List<GlobFolder> listFolderPathByParentId(BigInteger parentId);

    List<DocumentBO> listDocumentToZip(BigDecimal parentId);

}
