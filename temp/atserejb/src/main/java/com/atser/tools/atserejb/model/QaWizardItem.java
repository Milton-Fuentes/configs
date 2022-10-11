package com.atser.tools.atserejb.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mdelabat
 */
@Entity
@Table(name = "QA_WIZARD_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaWizardItem.findAll", query = "SELECT g FROM QaWizardItem g"),
    @NamedQuery(name = "QaWizardItem.findById", query = "SELECT g FROM QaWizardItem g WHERE g.id = :id")
})
public class QaWizardItem implements Serializable {
private static long serialVersionUID = 1L;    
@Id
@Basic(optional = false)
@Column(name = "ID")
private BigDecimal id;    
@Column(name = "CODE")
private String code; 
@Column(name = "NAME")
private String name; 
@Column(name = "DESCRIPTION")
private String description; 
@Column(name = "ORDER_")
private Integer order; 
@Column(name = "CONDITION_IN")
private String conditionIn; 
@Column(name = "SOURCE")
private String source; 
@Column(name = "CONDITION_OUT")
private String conditionOut; 
@Column(name = "PAGE")
private String page; 
@Column(name = "BREADCRUMBS")
private String breadcrumbs; 
@Column(name = "ACTIVE")
private String active; 
@Column(name = "CMODULE")
private String cmodule; 


    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return the conditionIn
     */
    public String getConditionIn() {
        return conditionIn;
    }

    /**
     * @param conditionIn the conditionIn to set
     */
    public void setConditionIn(String conditionIn) {
        this.conditionIn = conditionIn;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the conditionOut
     */
    public String getConditionOut() {
        return conditionOut;
    }

    /**
     * @param conditionOut the conditionOut to set
     */
    public void setConditionOut(String conditionOut) {
        this.conditionOut = conditionOut;
    }

    /**
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * @return the breadcrumbs
     */
    public String getBreadcrumbs() {
        return breadcrumbs;
    }

    /**
     * @param breadcrumbs the breadcrumbs to set
     */
    public void setBreadcrumbs(String breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    /**
     * @return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * @return the cmodule
     */
    public String getCmodule() {
        return cmodule;
    }

    /**
     * @param cmodule the cmodule to set
     */
    public void setCmodule(String cmodule) {
        this.cmodule = cmodule;
    }
}
