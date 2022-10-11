/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.WsRigths;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface WsUsersDao extends ICrudDao<BigDecimal, WsUsers> {

    WsUsers findBySSO(String username, eWsUserCategory category);

    Map<String, List<WsRigths>> getMapRigths();
    
    List<WsRigths> getRigthsByUserId(BigInteger userid);

    List<WsUsers> getUserGraph(String graph);
}
