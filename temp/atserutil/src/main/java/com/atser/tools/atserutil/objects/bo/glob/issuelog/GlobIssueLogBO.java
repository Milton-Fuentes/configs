/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.issuelog;

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
public class GlobIssueLogBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String ilpcn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Issue No")})
    private String issueNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Ref ID")})
    private String refId;
    private BigInteger identifiedBy;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Identified By")})
    private String identifiedByName;
    private BigInteger issueType;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Type")})
    private String issueTypeName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Date Found")})
    private String dateFound;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Date Submitted")})
    private String dateSubmitted;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Date Resolved")})
    private String dateResolved;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Description")})
    private String description;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Comments")})
    private String remarks;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Assigned To")})
    private String assignedTo;
    private BigInteger statusId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Status")})
    private String statusName;
    private BigInteger projectPhase;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Phase")})
    private String projectPhaseName;
    private BigInteger folderId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Created")})
    private String created;
    private String createdBy;
    private String version;
}
