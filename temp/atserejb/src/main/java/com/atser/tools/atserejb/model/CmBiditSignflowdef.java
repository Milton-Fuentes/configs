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
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "CmBiditSignflowdef.findByClientId", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "CmBiditSignflowdef.findBySignOrder", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.signOrder = :signOrder"),
    @NamedQuery(name = "CmBiditSignflowdef.findBySignRuleName", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.signRuleName = :signRuleName"),
    @NamedQuery(name = "CmBiditSignflowdef.findByCreated", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditSignflowdef.findByCreatedBy", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditSignflowdef.findByCreatedByIp", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditSignflowdef.findByLastMod", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditSignflowdef.findByLastModIp", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditSignflowdef.findByLastModBy", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditSignflowdef.findByDeleted", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditSignflowdef.findByActive", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditSignflowdef.findByVersion", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_BIDIT_SIGNFLOWDEF", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_SIGNFLOWDEF SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditSignflowdef.findAll", query = "SELECT c FROM CmBiditSignflowdef c"),
    @NamedQuery(name = "CmBiditSignflowdef.findById", query = "SELECT c FROM CmBiditSignflowdef c WHERE c.id = :id")})
public class CmBiditSignflowdef implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CM_BIDIT_SIGNFLOWDEF_SEQ", sequenceName = "CM_BIDIT_SIGNFLOWDEF_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_SIGNFLOWDEF_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "SIGN_ORDER")
    private BigInteger signOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SIGN_RULE_NAME")
    private String signRuleName;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
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
    @JoinColumn(name = "SIMPLECAT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobSystemSimpleCat simplecatId;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobSystemSimpleCat typeId;
    @JsonIgnore
    @OneToMany(mappedBy = "signflowId")
    private List<CmBiditSigninfo> cmBiditSigninfoList;

    public CmBiditSignflowdef() {
    }

    public CmBiditSignflowdef(BigDecimal id) {
        this.id = id;
    }

    public CmBiditSignflowdef(BigDecimal id, String signRuleName) {
        this.id = id;
        this.signRuleName = signRuleName;
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

    public BigInteger getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(BigInteger signOrder) {
        this.signOrder = signOrder;
    }

    public String getSignRuleName() {
        return signRuleName;
    }

    public void setSignRuleName(String signRuleName) {
        this.signRuleName = signRuleName;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public GlobSystemSimpleCat getSimplecatId() {
        return simplecatId;
    }

    public void setSimplecatId(GlobSystemSimpleCat simplecatId) {
        this.simplecatId = simplecatId;
    }

    public GlobSystemSimpleCat getTypeId() {
        return typeId;
    }

    public void setTypeId(GlobSystemSimpleCat typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public List<CmBiditSigninfo> getCmBiditSigninfoList() {
        return cmBiditSigninfoList;
    }

    public void setCmBiditSigninfoList(List<CmBiditSigninfo> cmBiditSigninfoList) {
        this.cmBiditSigninfoList = cmBiditSigninfoList;
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
        if (!(object instanceof CmBiditSignflowdef)) {
            return false;
        }
        CmBiditSignflowdef other = (CmBiditSignflowdef) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmBiditSignflowdef[ id=" + id + " ]";
    }
    
}
