/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.model.GlobFolderSubscribe;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFolderSubscribeService extends ICrudService<BigDecimal, GlobFolderSubscribe> {

    void delete(ManageITBodyRequest request);

    void delete(BigInteger folderId, BigInteger subscriberId);

    void subscribeToAll(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin);

    void unsubscribeToAll(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin);

    Boolean extists(BigInteger folderId, BigInteger subscriberId);

    String getStatus(BigInteger folderId, BigInteger subscriberId, String roleName, Boolean isAdmin);

    List<String> listSubscribersEmailByFolderId (BigInteger folderId);

    List<String> listSubscribersEmailByFolderIds(List<BigInteger> folderIds);

}
