/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.bpm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@AllArgsConstructor
@Getter
@Setter
public class BpmConfiguration {

    private Boolean isEnabled;
    private String bpmPath;
    private String bpmContext;
    private String bpmUserName;
    private String bpmPwd;
}
