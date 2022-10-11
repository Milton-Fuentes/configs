/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "PROCTOR_ATTLIMIT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProctorAttLimit.findAll", query = "SELECT a FROM VwProctorAttLimit a")})
public class VwProctorAttLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Id
    @NotNull
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Column(name = "COLLECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate;
    @Size(max = 50)
    @Column(name = "APPROVEDBY")
    private String approvedBy;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 4000)
    @Column(name = "SOURCE")
    private String source;
    @Size(max = 255)
    @Column(name = "STRUCTURE")
    private String structure;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSITY")
    private String maxDryDensity;
    @Size(max = 50)
    @Column(name = "OPTMOISTCONTENT")
    private String optMoistContent;
    @Size(max = 50)
    @Column(name = "LIQUIDLIMIT")
    private String liquidLimit;
    @Size(max = 50)
    @Column(name = "PLASTICLIMIT")
    private String plasticLimit;
    @Size(max = 50)
    @Column(name = "PLASTICINDEX")
    private String plasticIndex;

    public VwProctorAttLimit() {
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getMaxDryDensity() {
        return maxDryDensity;
    }

    public void setMaxDryDensity(String maxDryDensity) {
        this.maxDryDensity = maxDryDensity;
    }

    public String getOptMoistContent() {
        return optMoistContent;
    }

    public void setOptMoistContent(String optMoistContent) {
        this.optMoistContent = optMoistContent;
    }

    public String getLiquidLimit() {
        return liquidLimit;
    }

    public void setLiquidLimit(String liquidLimit) {
        this.liquidLimit = liquidLimit;
    }

    public String getPlasticLimit() {
        return plasticLimit;
    }

    public void setPlasticLimit(String plasticLimit) {
        this.plasticLimit = plasticLimit;
    }

    public String getPlasticIndex() {
        return plasticIndex;
    }

    public void setPlasticIndex(String plasticIndex) {
        this.plasticIndex = plasticIndex;
    }

    public String getPI() {
        if (StringSupport.isNotNullAndNotEmpty(this.plasticLimit) && this.plasticLimit.equals("Non-Plastic")) {
            return "NP";
        }
        return this.plasticIndex;
    }

}
