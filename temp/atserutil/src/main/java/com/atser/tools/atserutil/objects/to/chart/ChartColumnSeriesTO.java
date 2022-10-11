/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.chart;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dperez
 */
public class ChartColumnSeriesTO {

    String name;
    List<ChartColumnPointTO> points;

    public ChartColumnSeriesTO() {
    }

    public ChartColumnSeriesTO(String name, ChartColumnPointTO point) {
        this.name = name;
        points = new ArrayList<>();
        points.add(point);
    }

    public ChartColumnSeriesTO(String name, List<ChartColumnPointTO> points) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChartColumnPointTO> getPoints() {
        return points;
    }

    public void setPoints(List<ChartColumnPointTO> points) {
        this.points = points;
    }

}
