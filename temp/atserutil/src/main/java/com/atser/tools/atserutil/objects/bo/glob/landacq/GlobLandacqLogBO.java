/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.landacq;

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
public class GlobLandacqLogBO implements Serializable {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Project Number")})
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String llpcn;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Land Acquisition No.")})
    private String landacqNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "ROW Acquisitions ID.")})
    private String rowacqNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Environmental Issues")})
    private Character envIssues;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Date Available")})
    private String dateAvailable;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Owners")})
    private String owners;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "GIS Location")})
    private String gisLocation;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Site Address")})
    private String siteAddress;
    private BigInteger landType;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Land Type")})
    private String landTypeName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "MapPg")})
    private String mappg;
    private BigInteger county;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "County")})
    private String countyName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Stationing")})
    private String stationing;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "ROW Certification No")})
    private String rowCertificationNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Type of Contract")})
    private String typeOfContract;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Contact Phone Number")})
    private String contactPhoneNumber;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "ROW Certification  Date")})
    private String rowCertificationDate;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Acquisition Type")})
    private String acquisitionType;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Improvements to be Demolished")})
    private String improvements;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Land Available")})
    private Character landAvailable;
    private BigInteger propertyStatus;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Property Status")})
    private String propertyStatusName;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Occupied Dates")})
    private String occupiedDate;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Type of Utilities on Property")})
    private String typeOfUtilities;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Request for Utility Shut Off")})
    private Character requestForUtility;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Access to Property")})
    private String accessToProperty;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Property Owner Conversations")})
    private String propertyOwnerConversations;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "UT Drawing No")})
    private BigInteger utDrawingNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Parcel Impact")})
    private String parcelImpact;
    private String remarks;
    private BigInteger statusId;
    private BigInteger folderId;
    private String created;
    private String createdBy;
    private String version;
}
