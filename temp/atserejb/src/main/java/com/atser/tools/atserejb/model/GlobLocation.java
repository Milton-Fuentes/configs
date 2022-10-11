/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobLocation.findByClientId", query = "SELECT g FROM GlobLocation g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobLocation.findByFmtId", query = "SELECT g FROM GlobLocation g WHERE g.fmtId = :fmtId")
    , @NamedQuery(name = "GlobLocation.findByUnitNumber", query = "SELECT g FROM GlobLocation g WHERE g.unitNumber = :unitNumber")
    , @NamedQuery(name = "GlobLocation.findByUnitName", query = "SELECT g FROM GlobLocation g WHERE g.unitName = :unitName")
    , @NamedQuery(name = "GlobLocation.findByReachType", query = "SELECT g FROM GlobLocation g WHERE g.reachType = :reachType")
    , @NamedQuery(name = "GlobLocation.findByRowType", query = "SELECT g FROM GlobLocation g WHERE g.rowType = :rowType")
    , @NamedQuery(name = "GlobLocation.findByResponsible", query = "SELECT g FROM GlobLocation g WHERE g.responsible = :responsible")
    , @NamedQuery(name = "GlobLocation.findBySequenceNo", query = "SELECT g FROM GlobLocation g WHERE g.sequenceNo = :sequenceNo")
    , @NamedQuery(name = "GlobLocation.findByFromUs", query = "SELECT g FROM GlobLocation g WHERE g.fromUs = :fromUs")
    , @NamedQuery(name = "GlobLocation.findByToDs", query = "SELECT g FROM GlobLocation g WHERE g.toDs = :toDs")
    , @NamedQuery(name = "GlobLocation.findByPrecinct", query = "SELECT g FROM GlobLocation g WHERE g.precinct = :precinct")
    , @NamedQuery(name = "GlobLocation.findBySector", query = "SELECT g FROM GlobLocation g WHERE g.sector = :sector")
    , @NamedQuery(name = "GlobLocation.findByKeyMap", query = "SELECT g FROM GlobLocation g WHERE g.keyMap = :keyMap")
    , @NamedQuery(name = "GlobLocation.findByMapBook", query = "SELECT g FROM GlobLocation g WHERE g.mapBook = :mapBook")
    , @NamedQuery(name = "GlobLocation.findByCreateBy", query = "SELECT g FROM GlobLocation g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobLocation.findByCreateByIp", query = "SELECT g FROM GlobLocation g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobLocation.findByLastModBy", query = "SELECT g FROM GlobLocation g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobLocation.findByLastMod", query = "SELECT g FROM GlobLocation g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobLocation.findByLastModIp", query = "SELECT g FROM GlobLocation g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobLocation.findByVersion", query = "SELECT g FROM GlobLocation g WHERE g.version = :version")
    , @NamedQuery(name = "GlobLocation.findByUnitnoId", query = "SELECT g FROM GlobLocation g WHERE g.unitnoId = :unitnoId")
    , @NamedQuery(name = "GlobLocation.findByFunct", query = "SELECT g FROM GlobLocation g WHERE g.funct = :funct")
    , @NamedQuery(name = "GlobLocation.findByAgmtNumber", query = "SELECT g FROM GlobLocation g WHERE g.agmtNumber = :agmtNumber")
    , @NamedQuery(name = "GlobLocation.findByMagreement", query = "SELECT g FROM GlobLocation g WHERE g.magreement = :magreement")
    , @NamedQuery(name = "GlobLocation.findByReachComment", query = "SELECT g FROM GlobLocation g WHERE g.reachComment = :reachComment")
    , @NamedQuery(name = "GlobLocation.findByFmtlocationType", query = "SELECT g FROM GlobLocation g WHERE g.fmtlocationType = :fmtlocationType")
    , @NamedQuery(name = "GlobLocation.findByBasinAcres", query = "SELECT g FROM GlobLocation g WHERE g.basinAcres = :basinAcres")
    , @NamedQuery(name = "GlobLocation.findByMaintAcres", query = "SELECT g FROM GlobLocation g WHERE g.maintAcres = :maintAcres")
    , @NamedQuery(name = "GlobLocation.findByFmtLength", query = "SELECT g FROM GlobLocation g WHERE g.fmtLength = :fmtLength")
    , @NamedQuery(name = "GlobLocation.findByLamb", query = "SELECT g FROM GlobLocation g WHERE g.lamb = :lamb")
    , @NamedQuery(name = "GlobLocation.findByMbpg", query = "SELECT g FROM GlobLocation g WHERE g.mbpg = :mbpg")
    , @NamedQuery(name = "GlobLocation.findByMblink", query = "SELECT g FROM GlobLocation g WHERE g.mblink = :mblink")
    , @NamedQuery(name = "GlobLocation.findByReachinCoh", query = "SELECT g FROM GlobLocation g WHERE g.reachinCoh = :reachinCoh")
    , @NamedQuery(name = "GlobLocation.findByActiveRmz", query = "SELECT g FROM GlobLocation g WHERE g.activeRmz = :activeRmz")
    , @NamedQuery(name = "GlobLocation.findByDitType", query = "SELECT g FROM GlobLocation g WHERE g.ditType = :ditType")
    , @NamedQuery(name = "GlobLocation.findByGisId", query = "SELECT g FROM GlobLocation g WHERE g.gisId = :gisId")
    , @NamedQuery(name = "GlobLocation.findByGislinearreferencestart", query = "SELECT g FROM GlobLocation g WHERE g.gislinearreferencestart = :gislinearreferencestart")
    , @NamedQuery(name = "GlobLocation.findByGislinearreferenceend", query = "SELECT g FROM GlobLocation g WHERE g.gislinearreferenceend = :gislinearreferenceend")
    , @NamedQuery(name = "GlobLocation.findByPmActivityId", query = "SELECT g FROM GlobLocation g WHERE g.pmActivityId = :pmActivityId")
    , @NamedQuery(name = "GlobLocation.findByPmActvComments", query = "SELECT g FROM GlobLocation g WHERE g.pmActvComments = :pmActvComments")
    , @NamedQuery(name = "GlobLocation.findByPmActvMeasure", query = "SELECT g FROM GlobLocation g WHERE g.pmActvMeasure = :pmActvMeasure")
    , @NamedQuery(name = "GlobLocation.findByLocation", query = "SELECT g FROM GlobLocation g WHERE g.location = :location")
    , @NamedQuery(name = "GlobLocation.findByInactive", query = "SELECT g FROM GlobLocation g WHERE g.inactive = :inactive")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_LOCATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobLocation.findAll", query = "SELECT g FROM GlobLocation g")
    , @NamedQuery(name = "GlobLocation.findById", query = "SELECT g FROM GlobLocation g WHERE g.id = :id")})
public class GlobLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "FMT_ID")
    private BigInteger fmtId;
    @Size(max = 200)
    @Column(name = "UNIT_NUMBER")
    private String unitNumber;
    @Size(max = 200)
    @Column(name = "UNIT_NAME")
    private String unitName;
    @Size(max = 200)
    @Column(name = "REACH_TYPE")
    private String reachType;
    @Size(max = 200)
    @Column(name = "ROW_TYPE")
    private String rowType;
    @Size(max = 200)
    @Column(name = "RESPONSIBLE")
    private String responsible;
    @Column(name = "SEQUENCE_NO")
    private BigInteger sequenceNo;
    @Size(max = 200)
    @Column(name = "FROM_US")
    private String fromUs;
    @Size(max = 200)
    @Column(name = "TO_DS")
    private String toDs;
    @Column(name = "PRECINCT")
    private BigInteger precinct;
    @Size(max = 200)
    @Column(name = "SECTOR")
    private String sector;
    @Size(max = 200)
    @Column(name = "KEY_MAP")
    private String keyMap;
    @Column(name = "MAP_BOOK")
    private Double mapBook;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "UNITNO_ID")
    private BigInteger unitnoId;
    @Size(max = 50)
    @Column(name = "FUNCT")
    private String funct;
    @Column(name = "AGMT_NUMBER")
    private Double agmtNumber;
    @Size(max = 1000)
    @Column(name = "MAGREEMENT")
    private String magreement;
    @Size(max = 1000)
    @Column(name = "REACH_COMMENT")
    private String reachComment;
    @Size(max = 50)
    @Column(name = "FMTLOCATION_TYPE")
    private String fmtlocationType;
    @Column(name = "BASIN_ACRES")
    private Double basinAcres;
    @Column(name = "MAINT_ACRES")
    private Double maintAcres;
    @Column(name = "FMT_LENGTH")
    private Double fmtLength;
    @Column(name = "LAMB")
    private Double lamb;
    @Column(name = "MBPG")
    private BigInteger mbpg;
    @Size(max = 1000)
    @Column(name = "MBLINK")
    private String mblink;
    @Size(max = 50)
    @Column(name = "REACHIN_COH")
    private String reachinCoh;
    @Size(max = 50)
    @Column(name = "ACTIVE_RMZ")
    private String activeRmz;
    @Size(max = 50)
    @Column(name = "DIT_TYPE")
    private String ditType;
    @Column(name = "GIS_ID")
    private BigInteger gisId;
    @Column(name = "GISLINEARREFERENCESTART")
    private Double gislinearreferencestart;
    @Column(name = "GISLINEARREFERENCEEND")
    private Double gislinearreferenceend;
    @Column(name = "PM_ACTIVITY_ID")
    private BigInteger pmActivityId;
    @Size(max = 1000)
    @Column(name = "PM_ACTV_COMMENTS")
    private String pmActvComments;
    @Size(max = 50)
    @Column(name = "PM_ACTV_MEASURE")
    private String pmActvMeasure;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "INACTIVE")
    private Character inactive;

    public GlobLocation() {
    }

    public GlobLocation(BigDecimal id) {
        this.id = id;
    }

    public GlobLocation(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getFmtId() {
        return fmtId;
    }

    public void setFmtId(BigInteger fmtId) {
        this.fmtId = fmtId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getReachType() {
        return reachType;
    }

    public void setReachType(String reachType) {
        this.reachType = reachType;
    }

    public String getRowType() {
        return rowType;
    }

    public void setRowType(String rowType) {
        this.rowType = rowType;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public BigInteger getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(BigInteger sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getFromUs() {
        return fromUs;
    }

    public void setFromUs(String fromUs) {
        this.fromUs = fromUs;
    }

    public String getToDs() {
        return toDs;
    }

    public void setToDs(String toDs) {
        this.toDs = toDs;
    }

    public BigInteger getPrecinct() {
        return precinct;
    }

    public void setPrecinct(BigInteger precinct) {
        this.precinct = precinct;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(String keyMap) {
        this.keyMap = keyMap;
    }

    public Double getMapBook() {
        return mapBook;
    }

    public void setMapBook(Double mapBook) {
        this.mapBook = mapBook;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigInteger getUnitnoId() {
        return unitnoId;
    }

    public void setUnitnoId(BigInteger unitnoId) {
        this.unitnoId = unitnoId;
    }

    public String getFunct() {
        return funct;
    }

    public void setFunct(String funct) {
        this.funct = funct;
    }

    public Double getAgmtNumber() {
        return agmtNumber;
    }

    public void setAgmtNumber(Double agmtNumber) {
        this.agmtNumber = agmtNumber;
    }

    public String getMagreement() {
        return magreement;
    }

    public void setMagreement(String magreement) {
        this.magreement = magreement;
    }

    public String getReachComment() {
        return reachComment;
    }

    public void setReachComment(String reachComment) {
        this.reachComment = reachComment;
    }

    public String getFmtlocationType() {
        return fmtlocationType;
    }

    public void setFmtlocationType(String fmtlocationType) {
        this.fmtlocationType = fmtlocationType;
    }

    public Double getBasinAcres() {
        return basinAcres;
    }

    public void setBasinAcres(Double basinAcres) {
        this.basinAcres = basinAcres;
    }

    public Double getMaintAcres() {
        return maintAcres;
    }

    public void setMaintAcres(Double maintAcres) {
        this.maintAcres = maintAcres;
    }

    public Double getFmtLength() {
        return fmtLength;
    }

    public void setFmtLength(Double fmtLength) {
        this.fmtLength = fmtLength;
    }

    public Double getLamb() {
        return lamb;
    }

    public void setLamb(Double lamb) {
        this.lamb = lamb;
    }

    public BigInteger getMbpg() {
        return mbpg;
    }

    public void setMbpg(BigInteger mbpg) {
        this.mbpg = mbpg;
    }

    public String getMblink() {
        return mblink;
    }

    public void setMblink(String mblink) {
        this.mblink = mblink;
    }

    public String getReachinCoh() {
        return reachinCoh;
    }

    public void setReachinCoh(String reachinCoh) {
        this.reachinCoh = reachinCoh;
    }

    public String getActiveRmz() {
        return activeRmz;
    }

    public void setActiveRmz(String activeRmz) {
        this.activeRmz = activeRmz;
    }

    public String getDitType() {
        return ditType;
    }

    public void setDitType(String ditType) {
        this.ditType = ditType;
    }

    public BigInteger getGisId() {
        return gisId;
    }

    public void setGisId(BigInteger gisId) {
        this.gisId = gisId;
    }

    public Double getGislinearreferencestart() {
        return gislinearreferencestart;
    }

    public void setGislinearreferencestart(Double gislinearreferencestart) {
        this.gislinearreferencestart = gislinearreferencestart;
    }

    public Double getGislinearreferenceend() {
        return gislinearreferenceend;
    }

    public void setGislinearreferenceend(Double gislinearreferenceend) {
        this.gislinearreferenceend = gislinearreferenceend;
    }

    public BigInteger getPmActivityId() {
        return pmActivityId;
    }

    public void setPmActivityId(BigInteger pmActivityId) {
        this.pmActivityId = pmActivityId;
    }

    public String getPmActvComments() {
        return pmActvComments;
    }

    public void setPmActvComments(String pmActvComments) {
        this.pmActvComments = pmActvComments;
    }

    public String getPmActvMeasure() {
        return pmActvMeasure;
    }

    public void setPmActvMeasure(String pmActvMeasure) {
        this.pmActvMeasure = pmActvMeasure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Character getInactive() {
        return inactive;
    }

    public void setInactive(Character inactive) {
        this.inactive = inactive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobLocation)) {
            return false;
        }
        GlobLocation other = (GlobLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobLocation[ id=" + id + " ]";
    }
    
}
