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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "QmClientRoleMatrix.findByClientId", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QmClientRoleMatrix.findByRoleId", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.roleId = :roleId"),
    @NamedQuery(name = "QmClientRoleMatrix.findByItemName", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.itemName = :itemName"),
    @NamedQuery(name = "QmClientRoleMatrix.findByNoRights", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.noRights = :noRights"),
    @NamedQuery(name = "QmClientRoleMatrix.findByReadRights", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.readRights = :readRights"),
    @NamedQuery(name = "QmClientRoleMatrix.findByEditRights", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.editRights = :editRights"),
    @NamedQuery(name = "QmClientRoleMatrix.findByApproveRights", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.approveRights = :approveRights"),
    @NamedQuery(name = "QmClientRoleMatrix.findByCreateDate", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QmClientRoleMatrix.findByCreateBy", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QmClientRoleMatrix.findByCreateByIp", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QmClientRoleMatrix.findByLastMod", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QmClientRoleMatrix.findByLastModBy", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QmClientRoleMatrix.findByLastModIp", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QmClientRoleMatrix.findByVersion", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.version = :version"),
    @NamedQuery(name = "QmClientRoleMatrix.findByAppvId", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.appvId = :appvId"),
    @NamedQuery(name = "QmClientRoleMatrix.findByAppvDate", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.appvDate = :appvDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QM_CLIENT_ROLE_MATRIX", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmClientRoleMatrix.findAll", query = "SELECT q FROM QmClientRoleMatrix q"),
    @NamedQuery(name = "QmClientRoleMatrix.findById", query = "SELECT q FROM QmClientRoleMatrix q WHERE q.id = :id")})
public class QmClientRoleMatrix implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qm_client_role_matrix_id_seq", sequenceName = "qm_client_role_matrix_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qm_client_role_matrix_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    /*@Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private BigInteger roleId;*/
    @NotNull
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobRoles roleId;
    @Size(max = 50)
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "NO_RIGHTS")
    private Character noRights;
    @Column(name = "READ_RIGHTS")
    private Character readRights;
    @Column(name = "EDIT_RIGHTS")
    private Character editRights;
    @Column(name = "APPROVE_RIGHTS")
    private Character approveRights;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "APPV_ID")
    private BigInteger appvId;
    @Column(name = "APPV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appvDate;

    public QmClientRoleMatrix() {
    }

    public QmClientRoleMatrix(BigDecimal id) {
        this.id = id;
    }

    public QmClientRoleMatrix(BigDecimal id, BigInteger clientId, GlobRoles roleId) {
        this.id = id;
        this.clientId = clientId;
        this.roleId = roleId;
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

    public GlobRoles getRoleId() {
        return roleId;
    }

    public void setRoleId(GlobRoles roleId) {
        this.roleId = roleId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Character getNoRights() {
        return noRights;
    }

    public void setNoRights(Character noRights) {
        this.noRights = noRights;
    }

    public Character getReadRights() {
        return readRights;
    }

    public void setReadRights(Character readRights) {
        this.readRights = readRights;
    }

    public Character getEditRights() {
        return editRights;
    }

    public void setEditRights(Character editRights) {
        this.editRights = editRights;
    }

    public Character getApproveRights() {
        return approveRights;
    }

    public void setApproveRights(Character approveRights) {
        this.approveRights = approveRights;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
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

    public BigInteger getAppvId() {
        return appvId;
    }

    public void setAppvId(BigInteger appvId) {
        this.appvId = appvId;
    }

    public Date getAppvDate() {
        return appvDate;
    }

    public void setAppvDate(Date appvDate) {
        this.appvDate = appvDate;
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
        if (!(object instanceof QmClientRoleMatrix)) {
            return false;
        }
        QmClientRoleMatrix other = (QmClientRoleMatrix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmClientRoleMatrix[ id=" + id + " ]";
    }
    
}
