/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "QaTicket.findByClientId", query = "SELECT q FROM QaTicket q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaTicket.findByProjectId", query = "SELECT q FROM QaTicket q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaTicket.findByDocControlno", query = "SELECT q FROM QaTicket q WHERE q.docControlno = :docControlno"),
    @NamedQuery(name = "QaTicket.findByCatg", query = "SELECT q FROM QaTicket q WHERE q.catg = :catg"),
    @NamedQuery(name = "QaTicket.findBySupplierId", query = "SELECT q FROM QaTicket q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaTicket.findByTicketNo", query = "SELECT q FROM QaTicket q WHERE q.ticketNo = :ticketNo"),
    @NamedQuery(name = "QaTicket.findByOrderDate", query = "SELECT q FROM QaTicket q WHERE q.orderDate = :orderDate"),
    @NamedQuery(name = "QaTicket.findByOrderNo", query = "SELECT q FROM QaTicket q WHERE q.orderNo = :orderNo"),
    @NamedQuery(name = "QaTicket.findByRouteFrom", query = "SELECT q FROM QaTicket q WHERE q.routeFrom = :routeFrom"),
    @NamedQuery(name = "QaTicket.findByRouteTo", query = "SELECT q FROM QaTicket q WHERE q.routeTo = :routeTo"),
    @NamedQuery(name = "QaTicket.findByDeliveryDate", query = "SELECT q FROM QaTicket q WHERE q.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "QaTicket.findByDeliveryTime", query = "SELECT q FROM QaTicket q WHERE q.deliveryTime = :deliveryTime"),
    @NamedQuery(name = "QaTicket.findByLoadDescript", query = "SELECT q FROM QaTicket q WHERE q.loadDescript = :loadDescript"),
    @NamedQuery(name = "QaTicket.findByLoadWt", query = "SELECT q FROM QaTicket q WHERE q.loadWt = :loadWt"),
    @NamedQuery(name = "QaTicket.findByLoadUnit", query = "SELECT q FROM QaTicket q WHERE q.loadUnit = :loadUnit"),
    @NamedQuery(name = "QaTicket.findByBiditemNo", query = "SELECT q FROM QaTicket q WHERE q.biditemNo = :biditemNo"),
    @NamedQuery(name = "QaTicket.findByReceivedBy", query = "SELECT q FROM QaTicket q WHERE q.receivedBy = :receivedBy"),
    @NamedQuery(name = "QaTicket.findByCostUnit", query = "SELECT q FROM QaTicket q WHERE q.costUnit = :costUnit"),
    @NamedQuery(name = "QaTicket.findByCostLoad", query = "SELECT q FROM QaTicket q WHERE q.costLoad = :costLoad"),
    @NamedQuery(name = "QaTicket.findByCostOther", query = "SELECT q FROM QaTicket q WHERE q.costOther = :costOther"),
    @NamedQuery(name = "QaTicket.findByCostInvoice", query = "SELECT q FROM QaTicket q WHERE q.costInvoice = :costInvoice"),
    @NamedQuery(name = "QaTicket.findByInvoiceStatus", query = "SELECT q FROM QaTicket q WHERE q.invoiceStatus = :invoiceStatus"),
    @NamedQuery(name = "QaTicket.findByPaidDate", query = "SELECT q FROM QaTicket q WHERE q.paidDate = :paidDate"),
    @NamedQuery(name = "QaTicket.findByActive", query = "SELECT q FROM QaTicket q WHERE q.active = :active"),
    @NamedQuery(name = "QaTicket.findByRemarks", query = "SELECT q FROM QaTicket q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaTicket.findByLatGps", query = "SELECT q FROM QaTicket q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QaTicket.findByLonGps", query = "SELECT q FROM QaTicket q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QaTicket.findByAltGps", query = "SELECT q FROM QaTicket q WHERE q.altGps = :altGps"),
    @NamedQuery(name = "QaTicket.findByField1", query = "SELECT q FROM QaTicket q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaTicket.findByField2", query = "SELECT q FROM QaTicket q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaTicket.findByField3", query = "SELECT q FROM QaTicket q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaTicket.findByField4", query = "SELECT q FROM QaTicket q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaTicket.findByField5", query = "SELECT q FROM QaTicket q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaTicket.findByField6", query = "SELECT q FROM QaTicket q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaTicket.findByCreateBy", query = "SELECT q FROM QaTicket q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaTicket.findByCreateByIp", query = "SELECT q FROM QaTicket q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaTicket.findByLastModBy", query = "SELECT q FROM QaTicket q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaTicket.findByLastMod", query = "SELECT q FROM QaTicket q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaTicket.findByLastModIp", query = "SELECT q FROM QaTicket q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaTicket.findByVersion", query = "SELECT q FROM QaTicket q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TICKET", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_EQUIPINFO SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTicket.findAll", query = "SELECT q FROM QaTicket q"),
    @NamedQuery(name = "QaTicket.findById", query = "SELECT q FROM QaTicket q WHERE q.id = :id")})
public class QaTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "qa_ticket_id_seq", sequenceName = "qa_ticket_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_ticket_id_seq")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "DOC_CONTROLNO")
    private String docControlno;
    @Size(max = 200)
    @Column(name = "CATG")
    private String catg;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Size(max = 500)
    @Column(name = "TICKET_NO")
    private String ticketNo;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 200)
    @Column(name = "ORDER_NO")
    private String orderNo;
    @Size(max = 200)
    @Column(name = "ROUTE_FROM")
    private String routeFrom;
    @Size(max = 200)
    @Column(name = "ROUTE_TO")
    private String routeTo;
    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Size(max = 50)
    @Column(name = "DELIVERY_TIME")
    private String deliveryTime;
    @Size(max = 1000)
    @Column(name = "LOAD_DESCRIPT")
    private String loadDescript;
    @Column(name = "LOAD_WT")
    private Double loadWt;
    @Size(max = 50)
    @Column(name = "LOAD_UNIT")
    private String loadUnit;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 200)
    @Column(name = "RECEIVED_BY")
    private String receivedBy;
    @Column(name = "COST_UNIT")
    private Double costUnit;
    @Column(name = "COST_LOAD")
    private Double costLoad;
    @Column(name = "COST_OTHER")
    private Double costOther;
    @Column(name = "COST_INVOICE")
    private Double costInvoice;
    @Size(max = 50)
    @Column(name = "INVOICE_STATUS")
    private String invoiceStatus;
    @Column(name = "PAID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
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
    @Column(name = "VERSION", insertable = false)
    private String version;

    public QaTicket() {
    }

    public QaTicket(BigDecimal id) {
        this.id = id;
    }

    public QaTicket(BigDecimal id, BigInteger clientId) {
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getDocControlno() {
        return docControlno;
    }

    public void setDocControlno(String docControlno) {
        this.docControlno = docControlno;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(String routeFrom) {
        this.routeFrom = routeFrom;
    }

    public String getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(String routeTo) {
        this.routeTo = routeTo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getLoadDescript() {
        return loadDescript;
    }

    public void setLoadDescript(String loadDescript) {
        this.loadDescript = loadDescript;
    }

    public Double getLoadWt() {
        return loadWt;
    }

    public void setLoadWt(Double loadWt) {
        this.loadWt = loadWt;
    }

    public String getLoadUnit() {
        return loadUnit;
    }

    public void setLoadUnit(String loadUnit) {
        this.loadUnit = loadUnit;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Double getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(Double costUnit) {
        this.costUnit = costUnit;
    }

    public Double getCostLoad() {
        return costLoad;
    }

    public void setCostLoad(Double costLoad) {
        this.costLoad = costLoad;
    }

    public Double getCostOther() {
        return costOther;
    }

    public void setCostOther(Double costOther) {
        this.costOther = costOther;
    }

    public Double getCostInvoice() {
        return costInvoice;
    }

    public void setCostInvoice(Double costInvoice) {
        this.costInvoice = costInvoice;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
    }

    public String getLonGps() {
        return lonGps;
    }

    public void setLonGps(String lonGps) {
        this.lonGps = lonGps;
    }

    public String getAltGps() {
        return altGps;
    }

    public void setAltGps(String altGps) {
        this.altGps = altGps;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(clientId)
                .append(projectId)
                .append(docControlno)
                .append(catg)
                .append(supplierId)
                .append(ticketNo)
                .append(orderDate)
                .append(orderNo)
                .append(routeFrom)
                .append(routeTo)
                .append(deliveryDate)
                .append(deliveryTime)
                .append(loadDescript)
                .append(loadWt)
                .append(loadUnit)
                .append(biditemNo)
                .append(receivedBy)
                .append(costUnit)
                .append(costLoad)
                .append(costOther)
                .append(costInvoice)
                .append(invoiceStatus)
                .append(paidDate)
                .append(remarks)
                .append(latGps)
                .append(lonGps)
                .append(altGps)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaTicket)) {
            return false;
        }
        QaTicket other = (QaTicket) object;

        return new EqualsBuilder()
                .append(this.clientId, other.clientId)
                .append(this.projectId, other.projectId)
                .append(this.docControlno, other.docControlno)
                .append(this.catg, other.catg)
                .append(this.supplierId, other.supplierId)
                .append(this.ticketNo, other.ticketNo)
                .append(this.orderDate, other.orderDate)
                .append(this.orderNo, other.orderNo)
                .append(this.routeFrom, other.routeFrom)
                .append(this.routeTo, other.routeTo)
                .append(this.deliveryDate, other.deliveryDate)
                .append(this.deliveryTime, other.deliveryTime)
                .append(this.loadDescript, other.loadDescript)
                .append(this.loadWt, other.loadWt)
                .append(this.loadUnit, other.loadUnit)
                .append(this.biditemNo, other.biditemNo)
                .append(this.receivedBy, other.receivedBy)
                .append(this.costUnit, other.costUnit)
                .append(this.costLoad, other.costLoad)
                .append(this.costOther, other.costOther)
                .append(this.costInvoice, other.costInvoice)
                .append(this.invoiceStatus, other.invoiceStatus)
                .append(this.paidDate, other.paidDate)
                .append(this.remarks, other.remarks)
                .append(this.latGps, other.latGps)
                .append(this.lonGps, other.lonGps)
                .append(this.altGps, other.altGps)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTicket[ id=" + id + " ]";
    }

}
