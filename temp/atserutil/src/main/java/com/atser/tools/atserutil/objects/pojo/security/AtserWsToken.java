/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.security;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class AtserWsToken implements Serializable {

    private AtserTokenDef token;

    public AtserWsToken() {
    }

    @JsonGetter(value = "ATSER-WS-TOKEN")
    public AtserTokenDef getToken() {
        return token;
    }

    @JsonSetter(value = "ATSER-WS-TOKEN")
    public void setToken(AtserTokenDef token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AtserWsToken{" + "token=" + token + '}';
    }
}
