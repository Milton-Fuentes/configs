/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author dperez
 */
@Entity
@Immutable
@Table(name = "VW_BPM_PROCESS_BO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBpmProcessBo.findById", query = "SELECT v FROM VwBpmProcessBo v WHERE v.id = :id"),
    @NamedQuery(name = "VwBpmProcessBo.findAll", query = "SELECT v FROM VwBpmProcessBo v")})
public class VwBpmProcessBo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    @NotNull
    @Column(name = "PR_ID")
    private BigDecimal prId;

    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;

    @Column(name = "PROJECT_ID")
    private BigDecimal projectId;

    @Size(max = 255)
    @Column(name = "PROJECT_NUMBER")
    private String projectNumber;

    @Size(max = 255)
    @Column(name = "PR_TYPE")
    private String prType;

    @Size(max = 255)
    @Column(name = "PR_CODE")
    private String prCode;

    @Size(max = 255)
    @Column(name = "PR_NUMBER")
    private String prNumber;

    @Size(max = 255)
    @Column(name = "PR_NAME")
    private String prName;

    @Size(max = 255)
    @Column(name = "PR_CREATED")
    private String prCreated;

    @Size(max = 50)
    @Column(name = "PR_STATUS")
    private String prStatus;

    public VwBpmProcessBo() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPrId() {
        return prId;
    }

    public void setPrId(BigDecimal prId) {
        this.prId = prId;
    }

    public BigDecimal getProjectId() {
        return projectId;
    }

    public void setProjectId(BigDecimal projectId) {
        this.projectId = projectId;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getPrType() {
        return prType;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public String getPrCode() {
        return prCode;
    }

    public void setPrCode(String prCode) {
        this.prCode = prCode;
    }

    public String getPrNumber() {
        return prNumber;
    }

    public void setPrNumber(String prNumber) {
        this.prNumber = prNumber;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrCreated() {
        return prCreated;
    }

    public void setPrCreated(String prCreated) {
        this.prCreated = prCreated;
    }

    public String getPrStatus() {
        return prStatus;
    }

    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus;
    }

    @Override
    public String toString() {
        return "VwBpmProcessBo{" + "prId=" + prId + ", prType=" + prType + ", prNumber=" + prNumber + ", prName=" + prName + ", prCreated=" + prCreated + ", prStatus=" + prStatus + '}';
    }

}
