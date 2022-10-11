/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.requirement;

import com.atser.tools.atserutil.annotation.ReportColumnDef;
import com.atser.tools.atserutil.annotation.ReportColumnMapping;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class GlobRequirementLogBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String rqpcn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Req. No")})
    private String reqNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Ref. ID")})
    private String refId;
    private BigInteger categoryId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Category")})
    private String categoryName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Description")})
    private String description;
    private BigInteger classificationId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Classification")})
    private String classificationName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Doc. Ref.")})
    private String designDocRef;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Tech Spec Ref")})
    private String techSpecRef;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "WBS Deliverables Ref")})
    private String wbsDeliverablesRef;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Implemented In")})
    private String implementedIn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Closed")})
    private Character closed;
    private BigInteger statusId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Status")})
    private String statusName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Verification Date")})
    private String verificationDate;
    private BigInteger folderId;
    private String created;
    private String createdBy;
    private String version;
}
