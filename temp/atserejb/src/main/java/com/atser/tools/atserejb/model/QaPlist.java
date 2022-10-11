/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.qa.punchlist.QaPunchDetailTO;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
@NamedQuery(name = "QaPlist.findByProjectId", query = "SELECT q FROM QaPlist q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaPlist.findByItemNo", query = "SELECT q FROM QaPlist q WHERE q.itemNo = :itemNo"),
    @NamedQuery(name = "QaPlist.findByItemTypeId", query = "SELECT q FROM QaPlist q WHERE q.itemTypeId = :itemTypeId"),
    @NamedQuery(name = "QaPlist.findByItemDate", query = "SELECT q FROM QaPlist q WHERE q.itemDate = :itemDate"),
    @NamedQuery(name = "QaPlist.findByCheckedBy", query = "SELECT q FROM QaPlist q WHERE q.checkedBy = :checkedBy"),
    @NamedQuery(name = "QaPlist.findByItemDescript", query = "SELECT q FROM QaPlist q WHERE q.itemDescript = :itemDescript"),
    @NamedQuery(name = "QaPlist.findByItemLocation", query = "SELECT q FROM QaPlist q WHERE q.itemLocation = :itemLocation"),
    @NamedQuery(name = "QaPlist.findByDetailLocation", query = "SELECT q FROM QaPlist q WHERE q.detailLocation = :detailLocation"),
    @NamedQuery(name = "QaPlist.findByLatGps", query = "SELECT q FROM QaPlist q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QaPlist.findByLonGps", query = "SELECT q FROM QaPlist q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QaPlist.findByAltGps", query = "SELECT q FROM QaPlist q WHERE q.altGps = :altGps"),
    @NamedQuery(name = "QaPlist.findBySegment", query = "SELECT q FROM QaPlist q WHERE q.segment = :segment"),
    @NamedQuery(name = "QaPlist.findByContractor", query = "SELECT q FROM QaPlist q WHERE q.contractor = :contractor"),
    @NamedQuery(name = "QaPlist.findByResolvedDetail", query = "SELECT q FROM QaPlist q WHERE q.resolvedDetail = :resolvedDetail"),
    @NamedQuery(name = "QaPlist.findByClosedDate", query = "SELECT q FROM QaPlist q WHERE q.closedDate = :closedDate"),
    @NamedQuery(name = "QaPlist.findByItemStatus", query = "SELECT q FROM QaPlist q WHERE q.itemStatus = :itemStatus"),
    @NamedQuery(name = "QaPlist.findByInsp1Appv", query = "SELECT q FROM QaPlist q WHERE q.insp1Appv = :insp1Appv"),
    @NamedQuery(name = "QaPlist.findByInsp2Appv", query = "SELECT q FROM QaPlist q WHERE q.insp2Appv = :insp2Appv"),
    @NamedQuery(name = "QaPlist.findByInsp3Appv", query = "SELECT q FROM QaPlist q WHERE q.insp3Appv = :insp3Appv"),
    @NamedQuery(name = "QaPlist.findByInsp4Appv", query = "SELECT q FROM QaPlist q WHERE q.insp4Appv = :insp4Appv"),
    @NamedQuery(name = "QaPlist.findByInsp5Appv", query = "SELECT q FROM QaPlist q WHERE q.insp5Appv = :insp5Appv"),
    @NamedQuery(name = "QaPlist.findByItemPhoto", query = "SELECT q FROM QaPlist q WHERE q.itemPhoto = :itemPhoto"),
    @NamedQuery(name = "QaPlist.findByLastMod", query = "SELECT q FROM QaPlist q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaPlist.findByLastModBy", query = "SELECT q FROM QaPlist q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaPlist.findByLastModIp", query = "SELECT q FROM QaPlist q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaPlist.findByCreateBy", query = "SELECT q FROM QaPlist q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaPlist.findByCreateByIp", query = "SELECT q FROM QaPlist q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaPlist.findByCreateDate", query = "SELECT q FROM QaPlist q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaPlist.findByVersion", query = "SELECT q FROM QaPlist q WHERE q.version = :version"),
    @NamedQuery(name = "QaPlist.findByUnappvId", query = "SELECT q FROM QaPlist q WHERE q.unappvId = :unappvId"),
    @NamedQuery(name = "QaPlist.findByUnappvDate", query = "SELECT q FROM QaPlist q WHERE q.unappvDate = :unappvDate"),
    @NamedQuery(name = "QaPlist.findByResponsibility", query = "SELECT q FROM QaPlist q WHERE q.responsibility = :responsibility"),
    @NamedQuery(name = "QaPlist.findByTraceNo", query = "SELECT q FROM QaPlist q WHERE q.traceNo = :traceNo"),
    @NamedQuery(name = "QaPlist.findByPsegId", query = "SELECT q FROM QaPlist q WHERE q.psegId = :psegId"),
    @NamedQuery(name = "QaPlist.findByPsectId", query = "SELECT q FROM QaPlist q WHERE q.psectId = :psectId"),
    @NamedQuery(name = "QaPlist.findByOrientId", query = "SELECT q FROM QaPlist q WHERE q.orientId = :orientId"),
    @NamedQuery(name = "QaPlist.findByTyperdId", query = "SELECT q FROM QaPlist q WHERE q.typerdId = :typerdId"),
    @NamedQuery(name = "QaPlist.findByTypeactvId", query = "SELECT q FROM QaPlist q WHERE q.typeactvId = :typeactvId"),
    @NamedQuery(name = "QaPlist.findByTypeactvNb", query = "SELECT q FROM QaPlist q WHERE q.typeactvNb = :typeactvNb"),
    @NamedQuery(name = "QaPlist.findBySubtypeId", query = "SELECT q FROM QaPlist q WHERE q.subtypeId = :subtypeId"),
    @NamedQuery(name = "QaPlist.findBySubtypeNb", query = "SELECT q FROM QaPlist q WHERE q.subtypeNb = :subtypeNb"),
    @NamedQuery(name = "QaPlist.findByElementId", query = "SELECT q FROM QaPlist q WHERE q.elementId = :elementId"),
    @NamedQuery(name = "QaPlist.findByElementNb", query = "SELECT q FROM QaPlist q WHERE q.elementNb = :elementNb"),
    @NamedQuery(name = "QaPlist.findByPartId", query = "SELECT q FROM QaPlist q WHERE q.partId = :partId"),
    @NamedQuery(name = "QaPlist.findByPartNb", query = "SELECT q FROM QaPlist q WHERE q.partNb = :partNb"),
    @NamedQuery(name = "QaPlist.findByStation", query = "SELECT q FROM QaPlist q WHERE q.station = :station"),
    @NamedQuery(name = "QaPlist.findByOffset", query = "SELECT q FROM QaPlist q WHERE q.offset = :offset"),
    @NamedQuery(name = "QaPlist.findByElevation", query = "SELECT q FROM QaPlist q WHERE q.elevation = :elevation"),
    @NamedQuery(name = "QaPlist.findByToStation", query = "SELECT q FROM QaPlist q WHERE q.toStation = :toStation"),
    @NamedQuery(name = "QaPlist.findByCorridorId", query = "SELECT q FROM QaPlist q WHERE q.corridorId = :corridorId"),
    @NamedQuery(name = "QaPlist.findByClientId", query = "SELECT q FROM QaPlist q WHERE q.clientId = :clientId")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_PLIST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPlist.findAll", query = "SELECT q FROM QaPlist q"),
    @NamedQuery(name = "QaPlist.findById", query = "SELECT q FROM QaPlist q WHERE q.id = :id")})
public class QaPlist implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_plist_id_seq", sequenceName = "qa_plist_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_plist_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ITEM_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDate;
    @Column(name = "UNAPPV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date unappvDate;
    @Column(name = "CLOSED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedDate;
    @Column(name = "CREATE_DATE", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "OCCUR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurDate;
    @Column(name = "TYPERD_ID")
    private BigInteger typerdId;
    @Column(name = "TYPEACTV_ID")
    private BigInteger typeactvId;
    @Column(name = "ORIENT_ID")
    private BigInteger orientId;
    @Column(name = "PSECT_ID")
    private BigInteger psectId;
    @Column(name = "PSEG_ID")
    private BigInteger psegId;
    @JoinColumn(name = "STRUCT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private QaPlistStruct structId;
    @Column(name = "PTYPE_ID")
    private BigInteger ptypeId;
    @Column(name = "COPYFROM_ID")
    private BigInteger copyfromId;
    @Column(name = "UNAPPV_ID")
    private BigInteger unappvId;
    @JoinColumn(name = "ITEM_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    QaPListType itemTypeId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "CORRIDOR_ID")
    private BigInteger corridorId;
    @Column(name = "PART_ID")
    private BigInteger partId;
    @Column(name = "ELEMENT_ID")
    private BigInteger elementId;
    @Column(name = "SUBTYPE_ID")
    private BigInteger subtypeId;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 100)
    @Column(name = "STATION")
    private String station;
    @Size(max = 100)
    @Column(name = "TO_STATION")
    private String toStation;
    @Size(max = 100)
    @Column(name = "ELEVATION")
    private String elevation;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "OFFSET")
    private String offset;
    @Size(max = 20)
    @Column(name = "VERSION", insertable = false)
    private String version;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 20)
    @Column(name = "INSP5_APPV")
    private String insp5Appv;
    @Size(max = 20)
    @Column(name = "INSP4_APPV")
    private String insp4Appv;
    @Size(max = 20)
    @Column(name = "INSP3_APPV")
    private String insp3Appv;
    @Size(max = 20)
    @Column(name = "INSP2_APPV")
    private String insp2Appv;
    @Size(max = 20)
    @Column(name = "INSP1_APPV")
    private String insp1Appv;
    @Size(max = 200)
    @Column(name = "CHECKED_BY")
    private String checkedBy;
    @Size(max = 200)
    @Column(name = "ITEM_PHOTO")
    private String itemPhoto;
    @Size(max = 200)
    @Column(name = "SEGMENT")
    private String segment;
    @Size(max = 200)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 200)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 2000)
    @Column(name = "DETAIL_LOCATION")
    private String detailLocation;
    @Size(max = 255)
    @Column(name = "RFI_REF")
    private String rfiRef;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "SUB_REF")
    private String subRef;
    @Size(max = 255)
    @Column(name = "SPEC_PLAN_REF")
    private String specPlanRef;
    @Size(max = 255)
    @Column(name = "NCR_REF")
    private String ncrRef;
    @Size(max = 255)
    @Column(name = "SCC_NCR_REF")
    private String sccNcrRef;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 3000)
    @Column(name = "RESOLVED_DETAIL")
    private String resolvedDetail;
    @Size(max = 3000)
    @Column(name = "ACTION_REQ")
    private String actionReq;
    @Size(max = 3000)
    @Column(name = "ITEM_DESCRIPT")
    private String itemDescript;
    @Size(max = 50)
    @Column(name = "PART_NB")
    private String partNb;
    @Size(max = 50)
    @Column(name = "ELEMENT_NB")
    private String elementNb;
    @Size(max = 50)
    @Column(name = "ITEM_STATUS", insertable = false)
    private String itemStatus;
    @Size(max = 50)
    @Column(name = "SUBTYPE_NB")
    private String subtypeNb;
    @Size(max = 50)
    @Column(name = "TYPEACTV_NB")
    private String typeactvNb;
    @Size(max = 500)
    @Column(name = "ITEM_LOCATION")
    private String itemLocation;
    @Size(max = 500)
    @Column(name = "RESPONSIBILITY")
    private String responsibility;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaPlistUpdate> qaplistUpdateList;

    public QaPlist() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getUnappvDate() {
        return unappvDate;
    }

    public void setUnappvDate(Date unappvDate) {
        this.unappvDate = unappvDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    public BigInteger getTyperdId() {
        return typerdId;
    }

    public void setTyperdId(BigInteger typerdId) {
        this.typerdId = typerdId;
    }

    public BigInteger getTypeactvId() {
        return typeactvId;
    }

    public void setTypeactvId(BigInteger typeactvId) {
        this.typeactvId = typeactvId;
    }

    public BigInteger getOrientId() {
        return orientId;
    }

    public void setOrientId(BigInteger orientId) {
        this.orientId = orientId;
    }

    public BigInteger getPsectId() {
        return psectId;
    }

    public void setPsectId(BigInteger psectId) {
        this.psectId = psectId;
    }

    public BigInteger getPsegId() {
        return psegId;
    }

    public void setPsegId(BigInteger psegId) {
        this.psegId = psegId;
    }

    public QaPlistStruct getStructId() {
        return structId;
    }

    public void setStructId(QaPlistStruct structId) {
        this.structId = structId;
    }

    public BigInteger getPtypeId() {
        return ptypeId;
    }

    public void setPtypeId(BigInteger ptypeId) {
        this.ptypeId = ptypeId;
    }

    public BigInteger getCopyfromId() {
        return copyfromId;
    }

    public void setCopyfromId(BigInteger copyfromId) {
        this.copyfromId = copyfromId;
    }

    public BigInteger getUnappvId() {
        return unappvId;
    }

    public void setUnappvId(BigInteger unappvId) {
        this.unappvId = unappvId;
    }

    public QaPListType getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(QaPListType itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getCorridorId() {
        return corridorId;
    }

    public void setCorridorId(BigInteger corridorId) {
        this.corridorId = corridorId;
    }

    public BigInteger getPartId() {
        return partId;
    }

    public void setPartId(BigInteger partId) {
        this.partId = partId;
    }

    public BigInteger getElementId() {
        return elementId;
    }

    public void setElementId(BigInteger elementId) {
        this.elementId = elementId;
    }

    public BigInteger getSubtypeId() {
        return subtypeId;
    }

    public void setSubtypeId(BigInteger subtypeId) {
        this.subtypeId = subtypeId;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getAltGps() {
        return altGps;
    }

    public void setAltGps(String altGps) {
        this.altGps = altGps;
    }

    public String getLonGps() {
        return lonGps;
    }

    public void setLonGps(String lonGps) {
        this.lonGps = lonGps;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getInsp5Appv() {
        return insp5Appv;
    }

    public void setInsp5Appv(String insp5Appv) {
        this.insp5Appv = insp5Appv;
    }

    public String getInsp4Appv() {
        return insp4Appv;
    }

    public void setInsp4Appv(String insp4Appv) {
        this.insp4Appv = insp4Appv;
    }

    public String getInsp3Appv() {
        return insp3Appv;
    }

    public void setInsp3Appv(String insp3Appv) {
        this.insp3Appv = insp3Appv;
    }

    public String getInsp2Appv() {
        return insp2Appv;
    }

    public void setInsp2Appv(String insp2Appv) {
        this.insp2Appv = insp2Appv;
    }

    public String getInsp1Appv() {
        return insp1Appv;
    }

    public void setInsp1Appv(String insp1Appv) {
        this.insp1Appv = insp1Appv;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getRfiRef() {
        return rfiRef;
    }

    public void setRfiRef(String rfiRef) {
        this.rfiRef = rfiRef;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getSubRef() {
        return subRef;
    }

    public void setSubRef(String subRef) {
        this.subRef = subRef;
    }

    public String getSpecPlanRef() {
        return specPlanRef;
    }

    public void setSpecPlanRef(String specPlanRef) {
        this.specPlanRef = specPlanRef;
    }

    public String getNcrRef() {
        return ncrRef;
    }

    public void setNcrRef(String ncrRef) {
        this.ncrRef = ncrRef;
    }

    public String getSccNcrRef() {
        return sccNcrRef;
    }

    public void setSccNcrRef(String sccNcrRef) {
        this.sccNcrRef = sccNcrRef;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getResolvedDetail() {
        return resolvedDetail;
    }

    public void setResolvedDetail(String resolvedDetail) {
        this.resolvedDetail = resolvedDetail;
    }

    public String getActionReq() {
        return actionReq;
    }

    public void setActionReq(String actionReq) {
        this.actionReq = actionReq;
    }

    public String getItemDescript() {
        return itemDescript;
    }

    public void setItemDescript(String itemDescript) {
        this.itemDescript = itemDescript;
    }

    public String getPartNb() {
        return partNb;
    }

    public void setPartNb(String partNb) {
        this.partNb = partNb;
    }

    public String getElementNb() {
        return elementNb;
    }

    public void setElementNb(String elementNb) {
        this.elementNb = elementNb;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getSubtypeNb() {
        return subtypeNb;
    }

    public void setSubtypeNb(String subtypeNb) {
        this.subtypeNb = subtypeNb;
    }

    public String getTypeactvNb() {
        return typeactvNb;
    }

    public void setTypeactvNb(String typeactvNb) {
        this.typeactvNb = typeactvNb;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @XmlTransient
    public List<QaPlistUpdate> getQaplistUpdateList() {
        return qaplistUpdateList;
    }

    public void setQaplistUpdateList(List<QaPlistUpdate> qaplistUpdateList) {
        this.qaplistUpdateList = qaplistUpdateList;
    }

    public QaPunchDetailTO convertToQaPunchDetailTO() {
        QaPunchDetailTO obj = new QaPunchDetailTO();
        obj.setItemNo(StringSupport.emptyOnNull(this.getItemNo()));
        obj.setItemDate(DateSupport.formatDate(this.getItemDate(), DateSupport.FORMAT_US));
        obj.setCheckedBy(StringSupport.emptyOnNull(this.getCheckedBy()));
        obj.setItemType(StringSupport.emptyOnNull(this.getItemTypeId().getItemType()));
        obj.setStructType(this.getStructId().getStructType());
        obj.setSegment(StringSupport.emptyOnNull(this.getSegment()));
        obj.setDetailLocation(StringSupport.emptyOnNull(this.getDetailLocation()));
        obj.setItemDescription(StringSupport.emptyOnNull(this.getItemDescript()));
        obj.setResolvedDetail(StringSupport.emptyOnNull(this.getResolvedDetail()));
        obj.setItemStatus(StringSupport.emptyOnNull(this.getItemStatus()));
        if (this.qaplistUpdateList.size() > 0) {
            this.qaplistUpdateList.forEach(it -> {
                obj.addQaPunchUpdate(it.convertToQaPunchUpdateTO());
            });
        }
        return obj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.itemDate);
        hash = 47 * hash + Objects.hashCode(this.unappvDate);
        hash = 47 * hash + Objects.hashCode(this.closedDate);
        hash = 47 * hash + Objects.hashCode(this.createDate);
        hash = 47 * hash + Objects.hashCode(this.occurDate);
        hash = 47 * hash + Objects.hashCode(this.typerdId);
        hash = 47 * hash + Objects.hashCode(this.typeactvId);
        hash = 47 * hash + Objects.hashCode(this.orientId);
        hash = 47 * hash + Objects.hashCode(this.psectId);
        hash = 47 * hash + Objects.hashCode(this.psegId);
        hash = 47 * hash + Objects.hashCode(this.structId);
        hash = 47 * hash + Objects.hashCode(this.ptypeId);
        hash = 47 * hash + Objects.hashCode(this.copyfromId);
        hash = 47 * hash + Objects.hashCode(this.unappvId);
        hash = 47 * hash + Objects.hashCode(this.itemTypeId);
        hash = 47 * hash + Objects.hashCode(this.projectId);
        hash = 47 * hash + Objects.hashCode(this.clientId);
        hash = 47 * hash + Objects.hashCode(this.corridorId);
        hash = 47 * hash + Objects.hashCode(this.partId);
        hash = 47 * hash + Objects.hashCode(this.elementId);
        hash = 47 * hash + Objects.hashCode(this.subtypeId);
        hash = 47 * hash + Objects.hashCode(this.latGps);
        hash = 47 * hash + Objects.hashCode(this.createBy);
        hash = 47 * hash + Objects.hashCode(this.lastModBy);
        hash = 47 * hash + Objects.hashCode(this.station);
        hash = 47 * hash + Objects.hashCode(this.toStation);
        hash = 47 * hash + Objects.hashCode(this.elevation);
        hash = 47 * hash + Objects.hashCode(this.altGps);
        hash = 47 * hash + Objects.hashCode(this.lonGps);
        hash = 47 * hash + Objects.hashCode(this.offset);
        hash = 47 * hash + Objects.hashCode(this.version);
        hash = 47 * hash + Objects.hashCode(this.lastMod);
        hash = 47 * hash + Objects.hashCode(this.insp5Appv);
        hash = 47 * hash + Objects.hashCode(this.insp4Appv);
        hash = 47 * hash + Objects.hashCode(this.insp3Appv);
        hash = 47 * hash + Objects.hashCode(this.insp2Appv);
        hash = 47 * hash + Objects.hashCode(this.insp1Appv);
        hash = 47 * hash + Objects.hashCode(this.checkedBy);
        hash = 47 * hash + Objects.hashCode(this.itemPhoto);
        hash = 47 * hash + Objects.hashCode(this.segment);
        hash = 47 * hash + Objects.hashCode(this.contractor);
        hash = 47 * hash + Objects.hashCode(this.itemNo);
        hash = 47 * hash + Objects.hashCode(this.detailLocation);
        hash = 47 * hash + Objects.hashCode(this.rfiRef);
        hash = 47 * hash + Objects.hashCode(this.traceNo);
        hash = 47 * hash + Objects.hashCode(this.subRef);
        hash = 47 * hash + Objects.hashCode(this.specPlanRef);
        hash = 47 * hash + Objects.hashCode(this.ncrRef);
        hash = 47 * hash + Objects.hashCode(this.sccNcrRef);
        hash = 47 * hash + Objects.hashCode(this.createByIp);
        hash = 47 * hash + Objects.hashCode(this.lastModIp);
        hash = 47 * hash + Objects.hashCode(this.resolvedDetail);
        hash = 47 * hash + Objects.hashCode(this.actionReq);
        hash = 47 * hash + Objects.hashCode(this.itemDescript);
        hash = 47 * hash + Objects.hashCode(this.partNb);
        hash = 47 * hash + Objects.hashCode(this.elementNb);
        hash = 47 * hash + Objects.hashCode(this.itemStatus);
        hash = 47 * hash + Objects.hashCode(this.subtypeNb);
        hash = 47 * hash + Objects.hashCode(this.typeactvNb);
        hash = 47 * hash + Objects.hashCode(this.itemLocation);
        hash = 47 * hash + Objects.hashCode(this.responsibility);
        hash = 47 * hash + Objects.hashCode(this.qaplistUpdateList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QaPlist other = (QaPlist) obj;
        if (!Objects.equals(this.latGps, other.latGps)) {
            return false;
        }
        if (!Objects.equals(this.createBy, other.createBy)) {
            return false;
        }
        if (!Objects.equals(this.lastModBy, other.lastModBy)) {
            return false;
        }
        if (!Objects.equals(this.station, other.station)) {
            return false;
        }
        if (!Objects.equals(this.toStation, other.toStation)) {
            return false;
        }
        if (!Objects.equals(this.elevation, other.elevation)) {
            return false;
        }
        if (!Objects.equals(this.altGps, other.altGps)) {
            return false;
        }
        if (!Objects.equals(this.lonGps, other.lonGps)) {
            return false;
        }
        if (!Objects.equals(this.offset, other.offset)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.lastMod, other.lastMod)) {
            return false;
        }
        if (!Objects.equals(this.insp5Appv, other.insp5Appv)) {
            return false;
        }
        if (!Objects.equals(this.insp4Appv, other.insp4Appv)) {
            return false;
        }
        if (!Objects.equals(this.insp3Appv, other.insp3Appv)) {
            return false;
        }
        if (!Objects.equals(this.insp2Appv, other.insp2Appv)) {
            return false;
        }
        if (!Objects.equals(this.insp1Appv, other.insp1Appv)) {
            return false;
        }
        if (!Objects.equals(this.checkedBy, other.checkedBy)) {
            return false;
        }
        if (!Objects.equals(this.itemPhoto, other.itemPhoto)) {
            return false;
        }
        if (!Objects.equals(this.segment, other.segment)) {
            return false;
        }
        if (!Objects.equals(this.contractor, other.contractor)) {
            return false;
        }
        if (!Objects.equals(this.itemNo, other.itemNo)) {
            return false;
        }
        if (!Objects.equals(this.detailLocation, other.detailLocation)) {
            return false;
        }
        if (!Objects.equals(this.rfiRef, other.rfiRef)) {
            return false;
        }
        if (!Objects.equals(this.traceNo, other.traceNo)) {
            return false;
        }
        if (!Objects.equals(this.subRef, other.subRef)) {
            return false;
        }
        if (!Objects.equals(this.specPlanRef, other.specPlanRef)) {
            return false;
        }
        if (!Objects.equals(this.ncrRef, other.ncrRef)) {
            return false;
        }
        if (!Objects.equals(this.sccNcrRef, other.sccNcrRef)) {
            return false;
        }
        if (!Objects.equals(this.createByIp, other.createByIp)) {
            return false;
        }
        if (!Objects.equals(this.lastModIp, other.lastModIp)) {
            return false;
        }
        if (!Objects.equals(this.resolvedDetail, other.resolvedDetail)) {
            return false;
        }
        if (!Objects.equals(this.actionReq, other.actionReq)) {
            return false;
        }
        if (!Objects.equals(this.itemDescript, other.itemDescript)) {
            return false;
        }
        if (!Objects.equals(this.partNb, other.partNb)) {
            return false;
        }
        if (!Objects.equals(this.elementNb, other.elementNb)) {
            return false;
        }
        if (!Objects.equals(this.itemStatus, other.itemStatus)) {
            return false;
        }
        if (!Objects.equals(this.subtypeNb, other.subtypeNb)) {
            return false;
        }
        if (!Objects.equals(this.typeactvNb, other.typeactvNb)) {
            return false;
        }
        if (!Objects.equals(this.itemLocation, other.itemLocation)) {
            return false;
        }
        if (!Objects.equals(this.responsibility, other.responsibility)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.itemDate, other.itemDate)) {
            return false;
        }
        if (!Objects.equals(this.unappvDate, other.unappvDate)) {
            return false;
        }
        if (!Objects.equals(this.closedDate, other.closedDate)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if (!Objects.equals(this.occurDate, other.occurDate)) {
            return false;
        }
        if (!Objects.equals(this.typerdId, other.typerdId)) {
            return false;
        }
        if (!Objects.equals(this.typeactvId, other.typeactvId)) {
            return false;
        }
        if (!Objects.equals(this.orientId, other.orientId)) {
            return false;
        }
        if (!Objects.equals(this.psectId, other.psectId)) {
            return false;
        }
        if (!Objects.equals(this.psegId, other.psegId)) {
            return false;
        }
        if (!Objects.equals(this.structId, other.structId)) {
            return false;
        }
        if (!Objects.equals(this.ptypeId, other.ptypeId)) {
            return false;
        }
        if (!Objects.equals(this.copyfromId, other.copyfromId)) {
            return false;
        }
        if (!Objects.equals(this.unappvId, other.unappvId)) {
            return false;
        }
        if (!Objects.equals(this.itemTypeId, other.itemTypeId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.corridorId, other.corridorId)) {
            return false;
        }
        if (!Objects.equals(this.partId, other.partId)) {
            return false;
        }
        if (!Objects.equals(this.elementId, other.elementId)) {
            return false;
        }
        if (!Objects.equals(this.subtypeId, other.subtypeId)) {
            return false;
        }
        if (!Objects.equals(this.qaplistUpdateList, other.qaplistUpdateList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QaPlist{" + "id=" + id + ", itemDate=" + itemDate + ", unappvDate=" + unappvDate + ", closedDate=" + closedDate + ", createDate=" + createDate + ", occurDate=" + occurDate + ", typerdId=" + typerdId + ", typeactvId=" + typeactvId + ", orientId=" + orientId + ", psectId=" + psectId + ", psegId=" + psegId + ", structId=" + structId + ", ptypeId=" + ptypeId + ", copyfromId=" + copyfromId + ", unappvId=" + unappvId + ", itemTypeId=" + itemTypeId + ", projectId=" + projectId + ", clientId=" + clientId + ", corridorId=" + corridorId + ", partId=" + partId + ", elementId=" + elementId + ", subtypeId=" + subtypeId + ", latGps=" + latGps + ", createBy=" + createBy + ", lastModBy=" + lastModBy + ", station=" + station + ", toStation=" + toStation + ", elevation=" + elevation + ", altGps=" + altGps + ", lonGps=" + lonGps + ", offset=" + offset + ", version=" + version + ", lastMod=" + lastMod + ", insp5Appv=" + insp5Appv + ", insp4Appv=" + insp4Appv + ", insp3Appv=" + insp3Appv + ", insp2Appv=" + insp2Appv + ", insp1Appv=" + insp1Appv + ", checkedBy=" + checkedBy + ", itemPhoto=" + itemPhoto + ", segment=" + segment + ", contractor=" + contractor + ", itemNo=" + itemNo + ", detailLocation=" + detailLocation + ", rfiRef=" + rfiRef + ", traceNo=" + traceNo + ", subRef=" + subRef + ", specPlanRef=" + specPlanRef + ", ncrRef=" + ncrRef + ", sccNcrRef=" + sccNcrRef + ", createByIp=" + createByIp + ", lastModIp=" + lastModIp + ", resolvedDetail=" + resolvedDetail + ", actionReq=" + actionReq + ", itemDescript=" + itemDescript + ", partNb=" + partNb + ", elementNb=" + elementNb + ", itemStatus=" + itemStatus + ", subtypeNb=" + subtypeNb + ", typeactvNb=" + typeactvNb + ", itemLocation=" + itemLocation + ", responsibility=" + responsibility + ", qaplistUpdateList=" + qaplistUpdateList + '}';
    }

}
