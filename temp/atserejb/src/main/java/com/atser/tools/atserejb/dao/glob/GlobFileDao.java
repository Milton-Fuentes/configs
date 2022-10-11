/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFileDao extends ICrudDao<BigDecimal, GlobFile> {

    void delete(List<BigInteger> ids);

    void lockFile(BigDecimal fileId, BigDecimal userId);

    void unlockFile(BigDecimal fileId);

    String getNextDCNByClient(BigInteger clientId);

    String getNextDCNByProject(BigInteger projectId);

    String getNextDCNByPlanProject(BigInteger projectId);

    Boolean isFileLocked(BigDecimal fileId, BigDecimal userId);

    List<GlobFile> findAByFolder(BigDecimal folderId);

    List<GlobFile> listByIds(List<BigInteger> ids);

    DataTableWrapper<DocumentBO> getFrontEndSearch(DocumentSearchDefParam filters, Boolean wrap);
    DataTableWrapper<DocumentBO> getFrontEndSearchAdvance(DocumentSearchDefParam filters, AtserLinkedHashMap<String, Object> sParam, Boolean wrap);

}
