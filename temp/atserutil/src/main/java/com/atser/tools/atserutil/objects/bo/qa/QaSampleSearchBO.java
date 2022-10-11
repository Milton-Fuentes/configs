/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.qa;

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
public class QaSampleSearchBO {

    private BigInteger id;
    private String projectNo;
    private String sampleNumber;
    private String retest;
    private String woNo;
    private String status;
    private BigInteger categoryId;
    private String category;
    private String categoryTitle;
    private String categoryPageName;
    private String fieldUsr;
    private String collectionDate;
    private String active;
    private String version;
    private String officeLocation;
    private BigInteger deparmentId;
    private String projectCode;
    private String itemNo;
    private String material;
    private String specBookClass;
    private String traceNo;
    private String locationName;
    private String canbeInactived;
    private String supplierId;
    private String supplierName;
    private String binderSupplierId;
    private String binderSupplierName;
    private String sampleOf;
}
