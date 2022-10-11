/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.costmgmt;

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
public class GlobCostmgmtLogBO implements Serializable {

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
    private String spattern;
    private BigInteger sno;
    private String cmpcn;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "CM. No")})
    private String reqNo;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Work Package")})
    private String workPackage;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Approved Control Budget")})
    private BigDecimal approvedControlBudget;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Planed Value(PV)")})
    private BigDecimal planedValue;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Forecast Final Cost(BAC)")})
    private BigDecimal forecastFinalCost;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Committed Cost")})
    private BigDecimal committedCost;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Earned(EV)")})
    private BigDecimal earned;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Actual Cost(AC)")})
    private BigDecimal actualCost;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Invoiced")})
    private BigDecimal invoiced;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Paid")})
    private BigDecimal paid;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Remaining")})
    private BigDecimal remaining;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Comment")})
    private String remark;
    private BigInteger folderId;
    private String created;
    private String createdBy;
    private String version;
}
