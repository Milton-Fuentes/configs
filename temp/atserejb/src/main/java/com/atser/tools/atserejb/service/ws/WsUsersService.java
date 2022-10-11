/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.common.jpa.ICrudService;
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
public interface WsUsersService extends ICrudService<BigDecimal, WsUsers>{

    WsUsers findBySSO(String username, eWsUserCategory category);

    void inactiveUser(String id, Boolean active);

    WsUsers authUser(String username, String pwd, eWsUserCategory category);

    Map<String, List<WsRigths>> getMapRigths();
    
    List<WsRigths> getRigthsByUserId(BigInteger userid);
    
    List<WsUsers> getUserGraph(String graph);
}
