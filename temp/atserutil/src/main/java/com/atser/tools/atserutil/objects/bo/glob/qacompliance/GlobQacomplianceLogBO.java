/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.qacompliance;

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
public class GlobQacomplianceLogBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String qcpcn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "QC. No")})
    private String reqNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Task ID")})
    private String refId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Description")})
    private String description;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Meet Requirement")})
    private Character meetRequirement;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Response")})
    private String response;
    private BigInteger qcTypeId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Type")})
    private String qcTypeName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Scorecard (%)")})
    private BigDecimal scorecard;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Objective")})
    private String objective;
    private BigInteger qcPeriodId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Period")})
    private String qcPeriodName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Threshold")})
    private String threshold;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Range")})
    private String range;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Warning")})
    private BigDecimal warning;
    private BigInteger folderId;
    private String created;
    private String createdBy;
    private String version;
}
