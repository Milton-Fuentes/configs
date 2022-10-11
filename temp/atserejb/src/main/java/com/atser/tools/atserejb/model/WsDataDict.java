/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;

/*
    , @NamedQuery(name = "WsDataDict.findByDeleted", query = "SELECT w FROM WsDataDict w WHERE w.deleted = :deleted")
    , @NamedQuery(name = "WsDataDict.findByCreated", query = "SELECT w FROM WsDataDict w WHERE w.created = :created")
    , @NamedQuery(name = "WsDataDict.findByCreateBy", query = "SELECT w FROM WsDataDict w WHERE w.createBy = :createBy")
 */
/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE WS_DATA_DICT SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "WS_DATA_DICT", catalog = "", schema = "ORACLE")
//@TypeDef(name = "json", typeClass = JsonStringType.class)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsDataDict.findAll", query = "SELECT w FROM WsDataDict w"),
    @NamedQuery(name = "WsDataDict.findById", query = "SELECT w FROM WsDataDict w WHERE w.id = :id"),
    @NamedQuery(name = "WsDataDict.findByClientId", query = "SELECT w FROM WsDataDict w WHERE w.clientId = :clientId"),
    @NamedQuery(name = "WsDataDict.findByCode", query = "SELECT w FROM WsDataDict w WHERE w.code = :code"),
    @NamedQuery(name = "WsDataDict.findByType", query = "SELECT w FROM WsDataDict w WHERE w.type = :type"),
    @NamedQuery(name = "WsDataDict.findByActive", query = "SELECT w FROM WsDataDict w WHERE w.active = :active"),
    @NamedQuery(name = "WsDataDict.findByVersion", query = "SELECT w FROM WsDataDict w WHERE w.version = :version")})
public class WsDataDict implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CODE")
    private String code;
    @Size(max = 150)
    @Column(name = "TYPE")
    private String type;
    //@Type(type = "json")
    @JsonSkipXssSerialization
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Size(max = 20)
    @Column(name = "ACTIVE")
    private String active;
    @Size(max = 20)
    @Column(name = "DELETED")
    private String deleted;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 150)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "VERSION")
    private BigInteger version;

    public WsDataDict() {
    }

    public WsDataDict(BigDecimal id) {
        this.id = id;
    }

    public WsDataDict(BigDecimal id, BigInteger clientId, String code) {
        this.id = id;
        this.clientId = clientId;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    /*public JsonNode getJsonNodeContent() {
        return JacksonUtil.toJsonNode(content);
    }*/

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
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
        if (!(object instanceof WsDataDict)) {
            return false;
        }
        WsDataDict other = (WsDataDict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsDataDict[ id=" + id + " ]";
    }

}
