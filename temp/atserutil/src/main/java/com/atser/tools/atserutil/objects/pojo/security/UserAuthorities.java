/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.security;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorities {
    private BigInteger id;
    private BigInteger roleId;
    private String roleName;
    private BigInteger functionalityId;
    private String code;
    private String functionality;
    private Boolean hasRigth;
    
}
