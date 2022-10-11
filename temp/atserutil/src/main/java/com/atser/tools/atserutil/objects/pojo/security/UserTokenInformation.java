/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.security;

import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTokenInformation {

    private String token;
    private String userId;
    private eWsUserCategory userCategory;
}
