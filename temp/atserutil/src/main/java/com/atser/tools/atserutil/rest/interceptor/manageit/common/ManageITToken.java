/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * To validate external access to the WS
 * accepted types [file, workorder]
 *
 * @author droldan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManageITToken {

    /**
     * Generated Token to provide access
     */
    private String token;
    /**
     * Target Table or Functionality
     */
    private String type;

    public ManageITToken(String token) {
        this.token = token;
        this.type = "file";
    }
}
