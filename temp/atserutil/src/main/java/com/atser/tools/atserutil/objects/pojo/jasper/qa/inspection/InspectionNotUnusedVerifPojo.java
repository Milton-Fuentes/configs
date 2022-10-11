/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

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
public class InspectionNotUnusedVerifPojo {

    private String loggedInBy;
    private String loggedDate;
    private String loggedJobTitle;
    private String noUnusedItems;
    private String verifiedBy;
    private String verifiedDate;
    private String verifiedJobTitle;
}
