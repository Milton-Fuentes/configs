/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.risk;

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
public class GlobRiskRegisterBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String rpcn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Risk No")})
    private String riskNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Ref ID")})
    private String refId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Risk")})
    private String risk;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Risk Owner")})
    private String riskOwner;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Risk Trigger")})
    private String riskTrigger;
    private BigInteger riskCatg;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Risk Category")})
    private String riskCatgName;
    private BigInteger probability;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Probability")})
    private String probabilityName;
    private BigInteger impact;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Impact")})
    private String impactName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Expected Result")})
    private String expectedResult;
    private BigInteger positiveRiskResp;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Positive Risk Response")})
    private String positiveRiskRespName;
    private BigInteger negativeRiskResp;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Negative Risk Response")})
    private String negativeRiskRespName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Response Trigger")})
    private String respTrigger;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Response Owner")})
    private String respOwner;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Response Description")})
    private String respDescription;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Expected Response Impact")})
    private String expectedRespImpact;
    private BigInteger statusId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Status")})
    private String statusName;
    private BigInteger folderId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Created")})
    private String created;
    private String createdBy;
    private String version;
}
