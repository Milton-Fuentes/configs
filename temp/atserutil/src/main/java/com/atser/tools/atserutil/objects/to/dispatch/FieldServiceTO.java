/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.dispatch;

import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class FieldServiceTO {

    private BigInteger serviceId;
    private String serviceName;

    public FieldServiceTO() {
    }

    public FieldServiceTO(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public FieldServiceTO(BigInteger serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
