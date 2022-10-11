/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.punchlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class QaPunchMainListTO {

    private String projectName;
    private String projectNo;
    List<QaPunchDetailTO> qapDetailList;

    public QaPunchMainListTO() {
        qapDetailList = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public List<QaPunchDetailTO> getQapDetailList() {
        return qapDetailList;
    }

    public void setQapDetailList(List<QaPunchDetailTO> qapDetailList) {
        this.qapDetailList = qapDetailList;
    }

    public void addQaPunchDetailTO(QaPunchDetailTO dt) {
        if (dt != null) {
            this.qapDetailList.add(dt);
        }
    }

}
