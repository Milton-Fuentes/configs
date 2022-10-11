/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobFileSubscribe;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFileSubscribeDao extends ICrudDao<BigDecimal, GlobFileSubscribe> {

    Boolean exists(BigInteger fileId, BigInteger subscriberId);

    void delete(BigInteger fileId, BigInteger subscriberId);

    List<String> listSubscribersEmailByFileId(BigInteger file);

    List<String> listSubscribersEmailByFileIds(List<BigInteger> fileIds);

}
