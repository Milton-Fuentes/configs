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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "GlobRiskRegister.findByClientId", query = "SELECT g FROM GlobRiskRegister g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobRiskRegister.findByProjectId", query = "SELECT g FROM GlobRiskRegister g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobRiskRegister.findBySpattern", query = "SELECT g FROM GlobRiskRegister g WHERE g.spattern = :spattern"),
    @NamedQuery(name = "GlobRiskRegister.findBySno", query = "SELECT g FROM GlobRiskRegister g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobRiskRegister.findByRpcn", query = "SELECT g FROM GlobRiskRegister g WHERE g.rpcn = :rpcn"),
    @NamedQuery(name = "GlobRiskRegister.findByRiskNo", query = "SELECT g FROM GlobRiskRegister g WHERE g.riskNo = :riskNo"),
    @NamedQuery(name = "GlobRiskRegister.findByRefId", query = "SELECT g FROM GlobRiskRegister g WHERE g.refId = :refId"),
    @NamedQuery(name = "GlobRiskRegister.findByRisk", query = "SELECT g FROM GlobRiskRegister g WHERE g.risk = :risk"),
    @NamedQuery(name = "GlobRiskRegister.findByRiskOwner", query = "SELECT g FROM GlobRiskRegister g WHERE g.riskOwner = :riskOwner"),
    @NamedQuery(name = "GlobRiskRegister.findByRiskTrigger", query = "SELECT g FROM GlobRiskRegister g WHERE g.riskTrigger = :riskTrigger"),
    @NamedQuery(name = "GlobRiskRegister.findByRiskCatg", query = "SELECT g FROM GlobRiskRegister g WHERE g.riskCatg = :riskCatg"),
    @NamedQuery(name = "GlobRiskRegister.findByProbability", query = "SELECT g FROM GlobRiskRegister g WHERE g.probability = :probability"),
    @NamedQuery(name = "GlobRiskRegister.findByImpact", query = "SELECT g FROM GlobRiskRegister g WHERE g.impact = :impact"),
    @NamedQuery(name = "GlobRiskRegister.findByExpectedResult", query = "SELECT g FROM GlobRiskRegister g WHERE g.expectedResult = :expectedResult"),
    @NamedQuery(name = "GlobRiskRegister.findByPositiveRiskResp", query = "SELECT g FROM GlobRiskRegister g WHERE g.positiveRiskResp = :positiveRiskResp"),
    @NamedQuery(name = "GlobRiskRegister.findByNegativeRiskResp", query = "SELECT g FROM GlobRiskRegister g WHERE g.negativeRiskResp = :negativeRiskResp"),
    @NamedQuery(name = "GlobRiskRegister.findByRespTrigger", query = "SELECT g FROM GlobRiskRegister g WHERE g.respTrigger = :respTrigger"),
    @NamedQuery(name = "GlobRiskRegister.findByRespOwner", query = "SELECT g FROM GlobRiskRegister g WHERE g.respOwner = :respOwner"),
    @NamedQuery(name = "GlobRiskRegister.findByRespDescription", query = "SELECT g FROM GlobRiskRegister g WHERE g.respDescription = :respDescription"),
    @NamedQuery(name = "GlobRiskRegister.findByExpectedRespImpact", query = "SELECT g FROM GlobRiskRegister g WHERE g.expectedRespImpact = :expectedRespImpact"),
    @NamedQuery(name = "GlobRiskRegister.findByStatusId", query = "SELECT g FROM GlobRiskRegister g WHERE g.statusId = :statusId"),
    @NamedQuery(name = "GlobRiskRegister.findByCreated", query = "SELECT g FROM GlobRiskRegister g WHERE g.created = :created"),
    @NamedQuery(name = "GlobRiskRegister.findByCreatedBy", query = "SELECT g FROM GlobRiskRegister g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobRiskRegister.findByCreatedByIp", query = "SELECT g FROM GlobRiskRegister g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobRiskRegister.findByLastMod", query = "SELECT g FROM GlobRiskRegister g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobRiskRegister.findByLastModIp", query = "SELECT g FROM GlobRiskRegister g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobRiskRegister.findByLastModBy", query = "SELECT g FROM GlobRiskRegister g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobRiskRegister.findByDeleted", query = "SELECT g FROM GlobRiskRegister g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobRiskRegister.findByActive", query = "SELECT g FROM GlobRiskRegister g WHERE g.active = :active"),
    @NamedQuery(name = "GlobRiskRegister.findByVersion", query = "SELECT g FROM GlobRiskRegister g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_RISK_REGISTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_RISK_REGISTER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobRiskRegister.findAll", query = "SELECT g FROM GlobRiskRegister g"),
    @NamedQuery(name = "GlobRiskRegister.findById", query = "SELECT g FROM GlobRiskRegister g WHERE g.id = :id")})
public class GlobRiskRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_RISK_REGISTER_SEQ", sequenceName = "GLOB_RISK_REGISTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_RISK_REGISTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID", nullable = false)
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID", nullable = false)
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN", length = 150)
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "RPCN", length = 50)
    private String rpcn;
    @Size(max = 150)
    @Column(name = "RISK_NO", length = 150)
    private String riskNo;
    @Size(max = 150)
    @Column(name = "REF_ID", length = 150)
    private String refId;
    @Size(max = 512)
    @Column(name = "RISK", length = 512)
    private String risk;
    @Size(max = 255)
    @Column(name = "RISK_OWNER", length = 255)
    private String riskOwner;
    @Size(max = 255)
    @Column(name = "RISK_TRIGGER", length = 255)
    private String riskTrigger;
    @Column(name = "RISK_CATG")
    private BigInteger riskCatg;
    @Transient
    private String riskCatgName;
    @Column(name = "PROBABILITY")
    private BigInteger probability;
    @Transient
    private String probabilityName;
    @Column(name = "IMPACT")
    private BigInteger impact;
    @Transient
    private String impactName;
    @Size(max = 255)
    @Column(name = "EXPECTED_RESULT", length = 255)
    private String expectedResult;
    @Column(name = "POSITIVE_RISK_RESP")
    private BigInteger positiveRiskResp;
    @Transient
    private String positiveRiskRespName;
    @Column(name = "NEGATIVE_RISK_RESP")
    private BigInteger negativeRiskResp;
    @Transient
    private String negativeRiskRespName;
    @Size(max = 255)
    @Column(name = "RESP_TRIGGER", length = 255)
    private String respTrigger;
    @Size(max = 255)
    @Column(name = "RESP_OWNER", length = 255)
    private String respOwner;
    @Size(max = 1024)
    @Column(name = "RESP_DESCRIPTION", length = 1024)
    private String respDescription;
    @Size(max = 255)
    @Column(name = "EXPECTED_RESP_IMPACT", length = 255)
    private String expectedRespImpact;
    @Column(name = "STATUS_ID")
    private BigInteger statusId;
    @Transient
    private String statusName;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY", length = 255)
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP", length = 50)
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP", length = 50)
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY", length = 255)
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public GlobRiskRegister() {
    }

    public GlobRiskRegister(BigDecimal id) {
        this.id = id;
    }

    public GlobRiskRegister(BigDecimal id, BigInteger clientId, BigInteger projectId) {
        this.id = id;
        this.clientId = clientId;
        this.projectId = projectId;
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

    public String getSpattern() {
        return spattern;
    }

    public void setSpattern(String spattern) {
        this.spattern = spattern;
    }

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
    }

    public String getRpcn() {
        return rpcn;
    }

    public void setRpcn(String rpcn) {
        this.rpcn = rpcn;
    }

    public String getRiskNo() {
        return riskNo;
    }

    public void setRiskNo(String riskNo) {
        this.riskNo = riskNo;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRiskOwner() {
        return riskOwner;
    }

    public void setRiskOwner(String riskOwner) {
        this.riskOwner = riskOwner;
    }

    public String getRiskTrigger() {
        return riskTrigger;
    }

    public void setRiskTrigger(String riskTrigger) {
        this.riskTrigger = riskTrigger;
    }

    public BigInteger getRiskCatg() {
        return riskCatg;
    }

    public void setRiskCatg(BigInteger riskCatg) {
        this.riskCatg = riskCatg;
    }

    public BigInteger getProbability() {
        return probability;
    }

    public void setProbability(BigInteger probability) {
        this.probability = probability;
    }

    public BigInteger getImpact() {
        return impact;
    }

    public void setImpact(BigInteger impact) {
        this.impact = impact;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public BigInteger getPositiveRiskResp() {
        return positiveRiskResp;
    }

    public void setPositiveRiskResp(BigInteger positiveRiskResp) {
        this.positiveRiskResp = positiveRiskResp;
    }

    public BigInteger getNegativeRiskResp() {
        return negativeRiskResp;
    }

    public void setNegativeRiskResp(BigInteger negativeRiskResp) {
        this.negativeRiskResp = negativeRiskResp;
    }

    public String getRespTrigger() {
        return respTrigger;
    }

    public void setRespTrigger(String respTrigger) {
        this.respTrigger = respTrigger;
    }

    public String getRespOwner() {
        return respOwner;
    }

    public void setRespOwner(String respOwner) {
        this.respOwner = respOwner;
    }

    public String getRespDescription() {
        return respDescription;
    }

    public void setRespDescription(String respDescription) {
        this.respDescription = respDescription;
    }

    public String getExpectedRespImpact() {
        return expectedRespImpact;
    }

    public void setExpectedRespImpact(String expectedRespImpact) {
        this.expectedRespImpact = expectedRespImpact;
    }

    public BigInteger getStatusId() {
        return statusId;
    }

    public void setStatusId(BigInteger statusId) {
        this.statusId = statusId;
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

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
    }

    @JsonGetter(value = "riskCatgName")
    public String getRiskCatgName() {
        return riskCatgName;
    }

    public void setRiskCatgName(String riskCatgName) {
        this.riskCatgName = riskCatgName;
    }

    @JsonGetter(value = "probabilityName")
    public String getProbabilityName() {
        return probabilityName;
    }

    public void setProbabilityName(String probabilityName) {
        this.probabilityName = probabilityName;
    }

    @JsonGetter(value = "impactName")
    public String getImpactName() {
        return impactName;
    }

    public void setImpactName(String impactName) {
        this.impactName = impactName;
    }

    @JsonGetter(value = "positiveRiskRespName")
    public String getPositiveRiskRespName() {
        return positiveRiskRespName;
    }

    public void setPositiveRiskRespName(String positiveRiskRespName) {
        this.positiveRiskRespName = positiveRiskRespName;
    }

    @JsonGetter(value = "negativeRiskRespName")
    public String getNegativeRiskRespName() {
        return negativeRiskRespName;
    }

    public void setNegativeRiskRespName(String negativeRiskRespName) {
        this.negativeRiskRespName = negativeRiskRespName;
    }

    @JsonGetter(value = "statusName")
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.refId);
        hash = 79 * hash + Objects.hashCode(this.risk);
        hash = 79 * hash + Objects.hashCode(this.riskOwner);
        hash = 79 * hash + Objects.hashCode(this.riskTrigger);
        hash = 79 * hash + Objects.hashCode(this.riskCatg);
        hash = 79 * hash + Objects.hashCode(this.probability);
        hash = 79 * hash + Objects.hashCode(this.impact);
        hash = 79 * hash + Objects.hashCode(this.expectedResult);
        hash = 79 * hash + Objects.hashCode(this.positiveRiskResp);
        hash = 79 * hash + Objects.hashCode(this.negativeRiskResp);
        hash = 79 * hash + Objects.hashCode(this.respTrigger);
        hash = 79 * hash + Objects.hashCode(this.respOwner);
        hash = 79 * hash + Objects.hashCode(this.respDescription);
        hash = 79 * hash + Objects.hashCode(this.expectedRespImpact);
        hash = 79 * hash + Objects.hashCode(this.statusId);
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
        final GlobRiskRegister other = (GlobRiskRegister) obj;
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.risk, other.risk)) {
            return false;
        }
        if (!Objects.equals(this.riskOwner, other.riskOwner)) {
            return false;
        }
        if (!Objects.equals(this.riskTrigger, other.riskTrigger)) {
            return false;
        }
        if (!Objects.equals(this.expectedResult, other.expectedResult)) {
            return false;
        }
        if (!Objects.equals(this.respTrigger, other.respTrigger)) {
            return false;
        }
        if (!Objects.equals(this.respOwner, other.respOwner)) {
            return false;
        }
        if (!Objects.equals(this.respDescription, other.respDescription)) {
            return false;
        }
        if (!Objects.equals(this.expectedRespImpact, other.expectedRespImpact)) {
            return false;
        }
        if (!Objects.equals(this.riskCatg, other.riskCatg)) {
            return false;
        }
        if (!Objects.equals(this.probability, other.probability)) {
            return false;
        }
        if (!Objects.equals(this.impact, other.impact)) {
            return false;
        }
        if (!Objects.equals(this.positiveRiskResp, other.positiveRiskResp)) {
            return false;
        }
        if (!Objects.equals(this.negativeRiskResp, other.negativeRiskResp)) {
            return false;
        }
        if (!Objects.equals(this.statusId, other.statusId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobRiskRegister[ id=" + id + " ]";
    }

}
