/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.objects.to;

import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import java.io.Serializable;

/**
 *
 * @author mfuentes
 * @param <T>
 */
public class QaGenericTestTO<T> implements Serializable {

    T test;
    QaSampleTestAddInfo qaSampleTestAddInfo;

    public QaGenericTestTO() {
    }

    public T getTest() {
        return test;
    }

    public void setTest(T test) {
        this.test = test;
    }

    public QaSampleTestAddInfo getQaSampleTestAddInfo() {
        return qaSampleTestAddInfo;
    }

    public void setQaSampleTestAddInfo(QaSampleTestAddInfo qaSampleTestAddInfo) {
        this.qaSampleTestAddInfo = qaSampleTestAddInfo;
    }
    

}
