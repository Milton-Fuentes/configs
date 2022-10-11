/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dperez
 */
@Entity
@Table(name = "QA_SAMPLE_DOCS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleDocs.findAll", query = "SELECT q FROM QaSampleDocs q"),
    @NamedQuery(name = "QaSampleDocs.findById", query = "SELECT q FROM QaSampleDocs q WHERE q.id = :id")})
public class QaSampleDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "APP_TABLE_IMG_SEQ", sequenceName = "APP_TABLE_IMG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_TABLE_IMG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "sample_id")
    private BigDecimal sampleId;
    @Size(max = 255)
    @Column(name = "source_path")
    private String sourcePath;
    @Size(max = 255)
    @Column(name = "f_title")
    private String fTitle;
    @Size(max = 10)
    @Column(name = "extension")
    private String extension;
    @Size(max = 255)
    @Column(name = "f_name")
    private String fName;
    @Size(max = 255)
    @Column(name = "note1")
    private String note1;

    public QaSampleDocs() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigDecimal sampleId) {
        this.sampleId = sampleId;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFTitle() {
        return fTitle;
    }

    public void setFTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

}
