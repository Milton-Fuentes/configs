/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.glob.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@AllArgsConstructor
public class ClientPasswordConfig {

    private Integer strengthLevel;
    private ClientStringLengthConfig stringLength;
    private Boolean showPwdRequirements;

    public ClientPasswordConfig() {
        this.strengthLevel = 35;
        this.stringLength = new ClientStringLengthConfig();
        this.showPwdRequirements = true;
    }
}
