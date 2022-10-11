/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobFolderSubscribe;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFolderSubscribeDao extends ICrudDao<BigDecimal, GlobFolderSubscribe> {

    public Boolean exists(BigInteger folderId, BigInteger subscriberId);

    void delete(BigInteger folderId, BigInteger subscriberId);

    List<String> listSubscribersEmailByFolderId(BigInteger folderId);

    List<String> listSubscribersEmailByFolderIds(List<BigInteger> folderIds);
}
