/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.common;



/**
 *
 * @author droldan
 * @param <T>
 */
public class ManageITFilter<T> {
    private String field;
    private T value;
    private String condition;
    
    public ManageITFilter() {
    }

    public ManageITFilter(String field, T value) {
        this.field = field;
        this.value = value;
        this.condition = null;
    }
    
    public ManageITFilter(String field, T value, String condition) {
        this.field = field;
        this.value = value;
        this.condition = condition;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }    

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (field != null ? field.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManageITFilter)) {
            return false;
        }
        ManageITFilter other = (ManageITFilter) object;
        if ((this.field == null && other.field != null) || (this.field != null && !this.field.equals(other.field))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.field + this.condition + this.value;
    }
}
