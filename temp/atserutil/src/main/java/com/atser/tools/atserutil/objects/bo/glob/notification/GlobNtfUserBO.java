/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.notification;

import lombok.ToString;

/**
 *
 * @author droldan
 */
public class GlobNtfUserBO {
    private Long id;
    private String username;
    private Long clientId;

    public GlobNtfUserBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "GlobNtfUserBO{" + "id=" + id + ", username=" + username + ", clientId=" + clientId + '}';
    }
}
