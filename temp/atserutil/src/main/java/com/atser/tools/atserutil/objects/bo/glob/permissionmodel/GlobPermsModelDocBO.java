/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.permissionmodel;

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
public class GlobPermsModelDocBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "No.")})
    private BigInteger sno;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Version No")})
    private String versionNo;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Description")})
    private String description;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Authorized By")})
    private String authorizedBy;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Authorized Date")})
    private String authorizedDate;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Is Main")})
    private Character main;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Documents")})
    private BigInteger totalofDoc;
    private BigInteger folderId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Created")})
    private String created;
    private String createdBy;
    private String version;
}
