/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.reports;

import java.util.List;

/**
 *
 * @author droldan
 */
public class ReportColumsTO implements IReportSyncfusion {

    private List<ReportPointsTO> points;
    private String name;

    public ReportColumsTO(List<ReportPointsTO> points, String name) {
        this.points = points;
        this.name = name;
    }

    public ReportColumsTO() {
    }

    public List<ReportPointsTO> getPoints() {
        return points;
    }

    public void setPoints(List<ReportPointsTO> points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
