/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "GlobLandacqLog.findByProjectId", query = "SELECT g FROM GlobLandacqLog g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobLandacqLog.findBySpattern", query = "SELECT g FROM GlobLandacqLog g WHERE g.spattern = :spattern"),
    @NamedQuery(name = "GlobLandacqLog.findBySno", query = "SELECT g FROM GlobLandacqLog g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobLandacqLog.findByLlpcn", query = "SELECT g FROM GlobLandacqLog g WHERE g.llpcn = :llpcn"),
    @NamedQuery(name = "GlobLandacqLog.findByLandacqNo", query = "SELECT g FROM GlobLandacqLog g WHERE g.landacqNo = :landacqNo"),
    @NamedQuery(name = "GlobLandacqLog.findByRowacqNo", query = "SELECT g FROM GlobLandacqLog g WHERE g.rowacqNo = :rowacqNo"),
    @NamedQuery(name = "GlobLandacqLog.findByEnvIssues", query = "SELECT g FROM GlobLandacqLog g WHERE g.envIssues = :envIssues"),
    @NamedQuery(name = "GlobLandacqLog.findByDateAvailable", query = "SELECT g FROM GlobLandacqLog g WHERE g.dateAvailable = :dateAvailable"),
    @NamedQuery(name = "GlobLandacqLog.findByOwners", query = "SELECT g FROM GlobLandacqLog g WHERE g.owners = :owners"),
    @NamedQuery(name = "GlobLandacqLog.findByGisLocation", query = "SELECT g FROM GlobLandacqLog g WHERE g.gisLocation = :gisLocation"),
    @NamedQuery(name = "GlobLandacqLog.findBySiteAddress", query = "SELECT g FROM GlobLandacqLog g WHERE g.siteAddress = :siteAddress"),
    @NamedQuery(name = "GlobLandacqLog.findByLandType", query = "SELECT g FROM GlobLandacqLog g WHERE g.landType = :landType"),
    @NamedQuery(name = "GlobLandacqLog.findByMappg", query = "SELECT g FROM GlobLandacqLog g WHERE g.mappg = :mappg"),
    @NamedQuery(name = "GlobLandacqLog.findByCounty", query = "SELECT g FROM GlobLandacqLog g WHERE g.county = :county"),
    @NamedQuery(name = "GlobLandacqLog.findByStationing", query = "SELECT g FROM GlobLandacqLog g WHERE g.stationing = :stationing"),
    @NamedQuery(name = "GlobLandacqLog.findByRowCertificationNo", query = "SELECT g FROM GlobLandacqLog g WHERE g.rowCertificationNo = :rowCertificationNo"),
    @NamedQuery(name = "GlobLandacqLog.findByTypeOfContract", query = "SELECT g FROM GlobLandacqLog g WHERE g.typeOfContract = :typeOfContract"),
    @NamedQuery(name = "GlobLandacqLog.findByContactPhoneNumber", query = "SELECT g FROM GlobLandacqLog g WHERE g.contactPhoneNumber = :contactPhoneNumber"),
    @NamedQuery(name = "GlobLandacqLog.findByRowCertificationDate", query = "SELECT g FROM GlobLandacqLog g WHERE g.rowCertificationDate = :rowCertificationDate"),
    @NamedQuery(name = "GlobLandacqLog.findByAcquisitionType", query = "SELECT g FROM GlobLandacqLog g WHERE g.acquisitionType = :acquisitionType"),
    @NamedQuery(name = "GlobLandacqLog.findByImprovements", query = "SELECT g FROM GlobLandacqLog g WHERE g.improvements = :improvements"),
    @NamedQuery(name = "GlobLandacqLog.findByLandAvailable", query = "SELECT g FROM GlobLandacqLog g WHERE g.landAvailable = :landAvailable"),
    @NamedQuery(name = "GlobLandacqLog.findByPropertyStatus", query = "SELECT g FROM GlobLandacqLog g WHERE g.propertyStatus = :propertyStatus"),
    @NamedQuery(name = "GlobLandacqLog.findByOccupiedDate", query = "SELECT g FROM GlobLandacqLog g WHERE g.occupiedDate = :occupiedDate"),
    @NamedQuery(name = "GlobLandacqLog.findByTypeOfUtilities", query = "SELECT g FROM GlobLandacqLog g WHERE g.typeOfUtilities = :typeOfUtilities"),
    @NamedQuery(name = "GlobLandacqLog.findByRequestForUtility", query = "SELECT g FROM GlobLandacqLog g WHERE g.requestForUtility = :requestForUtility"),
    @NamedQuery(name = "GlobLandacqLog.findByAccessToProperty", query = "SELECT g FROM GlobLandacqLog g WHERE g.accessToProperty = :accessToProperty"),
    @NamedQuery(name = "GlobLandacqLog.findByPropertyOwnerConversations", query = "SELECT g FROM GlobLandacqLog g WHERE g.propertyOwnerConversations = :propertyOwnerConversations"),
    @NamedQuery(name = "GlobLandacqLog.findByUtDrawingNo", query = "SELECT g FROM GlobLandacqLog g WHERE g.utDrawingNo = :utDrawingNo"),
    @NamedQuery(name = "GlobLandacqLog.findByParcelImpact", query = "SELECT g FROM GlobLandacqLog g WHERE g.parcelImpact = :parcelImpact"),
    @NamedQuery(name = "GlobLandacqLog.findByRemarks", query = "SELECT g FROM GlobLandacqLog g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobLandacqLog.findByStatusId", query = "SELECT g FROM GlobLandacqLog g WHERE g.statusId = :statusId"),
    @NamedQuery(name = "GlobLandacqLog.findByFolderId", query = "SELECT g FROM GlobLandacqLog g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobLandacqLog.findByCreated", query = "SELECT g FROM GlobLandacqLog g WHERE g.created = :created"),
    @NamedQuery(name = "GlobLandacqLog.findByCreatedBy", query = "SELECT g FROM GlobLandacqLog g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobLandacqLog.findByCreatedByIp", query = "SELECT g FROM GlobLandacqLog g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobLandacqLog.findByLastMod", query = "SELECT g FROM GlobLandacqLog g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobLandacqLog.findByLastModIp", query = "SELECT g FROM GlobLandacqLog g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobLandacqLog.findByLastModBy", query = "SELECT g FROM GlobLandacqLog g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobLandacqLog.findByDeleted", query = "SELECT g FROM GlobLandacqLog g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobLandacqLog.findByActive", query = "SELECT g FROM GlobLandacqLog g WHERE g.active = :active"),
    @NamedQuery(name = "GlobLandacqLog.findByVersion", query = "SELECT g FROM GlobLandacqLog g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Audited
@SQLDelete(sql = "UPDATE GLOB_LANDACQ_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_LANDACQ_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobLandacqLog.findAll", query = "SELECT g FROM GlobLandacqLog g"),
    @NamedQuery(name = "GlobLandacqLog.findById", query = "SELECT g FROM GlobLandacqLog g WHERE g.id = :id"),
    @NamedQuery(name = "GlobLandacqLog.findByClientId", query = "SELECT g FROM GlobLandacqLog g WHERE g.clientId = :clientId")})
public class GlobLandacqLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "GLOB_LANDACQ_LOG_SEQ", sequenceName = "GLOB_LANDACQ_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_LANDACQ_LOG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @JsonProperty("projectFullName")
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN")
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "LLPCN")
    private String llpcn;
    @ToString.Include
    @Size(max = 150)
    @Column(name = "LANDACQ_NO")
    private String landacqNo;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "ROWACQ_NO")
    private String rowacqNo;
    @EqualsAndHashCode.Include
    @Column(name = "ENV_ISSUES")
    private Character envIssues;
    @EqualsAndHashCode.Include
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "DATE_AVAILABLE")
    @Temporal(TemporalType.DATE)
    private Date dateAvailable;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "OWNERS")
    private String owners;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "GIS_LOCATION")
    private String gisLocation;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "SITE_ADDRESS")
    private String siteAddress;
    @EqualsAndHashCode.Include
    @Column(name = "LAND_TYPE")
    private BigInteger landType;
    @JsonProperty("landTypeName")
    @Transient
    private String landTypeName;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "MAPPG")
    private String mappg;
    @EqualsAndHashCode.Include
    @Column(name = "COUNTY")
    private BigInteger county;
    @JsonProperty("countyName")
    @Transient
    private String countyName;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "STATIONING")
    private String stationing;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "ROW_CERTIFICATION_NO")
    private String rowCertificationNo;
    @EqualsAndHashCode.Include
    @Size(max = 150)
    @Column(name = "TYPE_OF_CONTRACT")
    private String typeOfContract;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "CONTACT_PHONE_NUMBER")
    private String contactPhoneNumber;
    @EqualsAndHashCode.Include
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "ROW_CERTIFICATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date rowCertificationDate;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "ACQUISITION_TYPE")
    private String acquisitionType;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "IMPROVEMENTS")
    private String improvements;
    @EqualsAndHashCode.Include
    @Column(name = "LAND_AVAILABLE")
    private Character landAvailable;
    @EqualsAndHashCode.Include
    @Column(name = "PROPERTY_STATUS")
    private BigInteger propertyStatus;
    @JsonProperty("propertyStatusName")
    @Transient
    private String propertyStatusName;
    @EqualsAndHashCode.Include
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "OCCUPIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date occupiedDate;
    @EqualsAndHashCode.Include
    @Size(max = 512)
    @Column(name = "TYPE_OF_UTILITIES")
    private String typeOfUtilities;
    @EqualsAndHashCode.Include
    @Column(name = "REQUEST_FOR_UTILITY")
    private Character requestForUtility;
    @EqualsAndHashCode.Include
    @Size(max = 512)
    @Column(name = "ACCESS_TO_PROPERTY")
    private String accessToProperty;
    @EqualsAndHashCode.Include
    @Size(max = 512)
    @Column(name = "PROPERTY_OWNER_CONVERSATIONS")
    private String propertyOwnerConversations;
    @EqualsAndHashCode.Include
    @Column(name = "UT_DRAWING_NO")
    private BigInteger utDrawingNo;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "PARCEL_IMPACT")
    private String parcelImpact;
    @EqualsAndHashCode.Include
    @Size(max = 512)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "STATUS_ID")
    private BigInteger statusId;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;
}
