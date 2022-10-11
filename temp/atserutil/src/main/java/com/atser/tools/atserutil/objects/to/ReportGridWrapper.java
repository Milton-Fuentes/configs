/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

import com.atser.tools.atserutil.objects.pojo.DefaultReportDefParam;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class ReportGridWrapper extends DefaultReportDefParam {
    
    private String typePrint;
    private String tableFilter;
    private List<ReportGridColumnsTO> columns;
}
