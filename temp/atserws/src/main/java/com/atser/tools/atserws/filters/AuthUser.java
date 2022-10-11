/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.filters;

import com.atser.tools.atserejb.model.WsUsers;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Optional;

/**
 *
 * @author droldan
 */
public class AuthUser implements Principal {

    private WsUsers wsUser;

    public AuthUser() {
    }

    public AuthUser(WsUsers wsUser) {
        this.wsUser = wsUser;
    }

    public WsUsers getWsUser() {
        return wsUser;
    }

    public void setWsUser(WsUsers wsUser) {
        this.wsUser = wsUser;
    }
    
    public Optional<BigInteger> getClientId() {
        return Optional.ofNullable(this.wsUser.getClientId());
    }

    @Override
    public String getName() {
        return wsUser.getUsername();
    }

}
