/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

/**
 *
 * @author droldan
 */
public class DataSelectWrapper {

    private Object id;
    private String text;
    private Boolean selected;
    private Boolean disabled;
    private Object model;

    /**
     * 
     * @param id
     * @param text 
     */
    public DataSelectWrapper(Object id, String text) {
        this.id = id;
        this.text = text;
        this.selected = false;
        this.disabled = false;
        this.model = null;
    }

    /**
     * 
     * @param id
     * @param text
     * @param disabled 
     */
    public DataSelectWrapper(Object id, String text, Boolean disabled) {
        this.id = id;
        this.text = text;
        this.selected = false;
        this.disabled = disabled;
        this.model = null;
    }

    /**
     * 
     * @param id
     * @param text
     * @param selected
     * @param disabled 
     */
    public DataSelectWrapper(Object id, String text, Boolean selected, Boolean disabled) {
        this.id = id;
        this.text = text;
        this.selected = selected;
        this.disabled = disabled;
        this.model = null;
    }

    /**
     * 
     * @param id
     * @param text
     * @param model 
     */
    public DataSelectWrapper(Object id, String text, Object model) {
        this.id = id;
        this.text = text;
        this.model = model;
        this.selected = false;
        this.disabled = false;
    }

    /**
     * 
     * @param id
     * @param text
     * @param selected
     * @param disabled
     * @param model 
     */
    public DataSelectWrapper(Object id, String text, Boolean selected, Boolean disabled, Object model) {
        this.id = id;
        this.text = text;
        this.selected = selected;
        this.disabled = disabled;
        this.model = model;
    }

    public DataSelectWrapper() {
        this.selected = false;
        this.disabled = false;
        this.model = null;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }
}
