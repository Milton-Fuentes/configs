/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.support.syncfusion;

/**
 *
 * @author droldan
 */
public class SectionRsBo {

    private Object list;
    private Long count;

    public SectionRsBo() {
        this.list = null;
        this.count = 0L;
    }

    public SectionRsBo(Object list, Long count) {
        this.list = list;
        this.count = count;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
