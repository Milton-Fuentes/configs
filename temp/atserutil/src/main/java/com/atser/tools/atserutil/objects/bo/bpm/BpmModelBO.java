/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.bpm;

/**
 *
 * @author dperez
 */
public class BpmModelBO {

    private Long persistenceId;
    private String number;
    private Long clientId;

    public BpmModelBO() {
    }

    public Long getPersistenceId() {
        return persistenceId;
    }

    public void setPersistenceId(Long persistenceId) {
        this.persistenceId = persistenceId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "BpmModelBO{" + "persistenceId=" + persistenceId + ", number=" + number + ", clientId=" + clientId + '}';
    }

}
