/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.migt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class VendorInfoBO {

    private Long id;
    private String vendor;
    private String firstname;
    private String lastname;
    private String address;
    private String title;
    private String city;
    private String cstate;
    private String zipcode;
    private String workphone;
    private String cellphone;
    private String email;
    private String status;
    private String rejectReason;
    private Long oVendorId;
}
