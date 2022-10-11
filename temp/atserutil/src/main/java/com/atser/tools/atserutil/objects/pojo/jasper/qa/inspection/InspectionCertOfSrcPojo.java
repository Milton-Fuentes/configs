/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

import java.math.BigInteger;
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
public class InspectionCertOfSrcPojo {

    private String loggedInBy;
    private String loggedDate;
    private String loggedJobTitle;
    private String wbsitemNo;
    private String wbsitemSpecNo;
    private String wbsitemProjQuantity;
    private String wbsitemDescription;
    private String biditemNo;
    private String biditemSpecNo;
    private String biditemProjQuantity;
    private String biditemDescription;
    private String subBiditemNo;
    private String subBiditemSpecNo;
    private String subBiditemProjQuantity;
    private String subBiditemDescription;
    private String supplier;
    private String supplierLocation;
    private String supplierStr;
    private String supplierLocationStr;
    private String fabricatorStr;
    private String fabricatorLocationStr;
    private BigInteger totalItemOnContract;
    private String productName;
    private String application;
    private String verifiedBy;
    private String verifiedDate;
    private String verifiedJobTitle;
    private String inspAddinfo; 
    private Character srcHasBeenVerified;
    private Character certOfCompliance;
    private Character doNotUse;
    private Character sampleTest;
    private String remarks;
}
