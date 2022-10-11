/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobFolderDefaultLink;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFolderDefaultLinkService extends ICrudService<BigDecimal, GlobFolderDefaultLink> {

    GlobFolderDefaultLink getByFolderIdAndGroup(BigInteger folderId, BigInteger groupNumber);
}
