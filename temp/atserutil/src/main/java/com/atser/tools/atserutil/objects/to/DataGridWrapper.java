/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

import java.io.Serializable;
import java.util.List;

/**
 * This class is to Define a Syncfusion Data Grid Wrapper
 *
 * @author droldan
 * @param <T>
 */
public class DataGridWrapper<T> implements Serializable {

    private List<T> result;
    private Long count;

    public DataGridWrapper() {
    }

    public DataGridWrapper(List<T> result, Long count) {
        this.result = result;
        this.count = count;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
