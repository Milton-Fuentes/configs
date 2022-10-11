/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.bpm;

import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dperez
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BpmTaskReportTO extends QaInspectionReportTO {

    private String actions;
    private String responsability;
    private Date creationDate;
    private Date resolvedTargetDate;
    private Date reslvedActualDate;
    private String actionStatus;
    private String actionStatusNotes;
}
