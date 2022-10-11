/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.contractmgmt;

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
public class GlobContractmgmtLogBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String cmpcn;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "CM. No")})
    private String reqNo;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "DCN No.")})
    private String refId;
    private BigInteger categoryId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Category")})
    private String categoryName;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Description")})
    private String description;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Version No.")})
    private String versionNo;
    private BigInteger folderId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Created")})
    private String created;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Created By")})
    private String createdBy;
    private String version;
}
