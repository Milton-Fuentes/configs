package com.atser.tools.atserutil.objects.bo.glob.mgmtplan;

import com.atser.tools.atserutil.annotation.ReportColumnDef;
import com.atser.tools.atserutil.annotation.ReportColumnMapping;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class GlobMgmtPlanBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger programId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Program")})
    private String programName;
    private BigInteger projectId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private BigInteger planCatgId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Plan Category")})
    private String planCatgName;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Description")})
    private String description;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Total of Docs.")})
    private BigInteger totalofDoc;
    private BigInteger folderId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Created")})
    private String created;
    private String createdBy;
    private String version;
}
