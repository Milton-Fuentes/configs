/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.security;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class AtserTokenDef implements Serializable {

    private String name;
    private String value;
    private Integer version;
    private String path;
    private String domain;
    private String comment;
    private Integer maxAge;
    private BigInteger expiry;
    private Boolean secure;
    private Boolean httpOnly;

    public AtserTokenDef() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public BigInteger getExpiry() {
        return expiry;
    }

    public void setExpiry(BigInteger expiry) {
        this.expiry = expiry;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public Boolean getHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(Boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    @Override
    public String toString() {
        return "AtserTokenDef{" + "name=" + name + ", value=" + value + '}';
    }

}
