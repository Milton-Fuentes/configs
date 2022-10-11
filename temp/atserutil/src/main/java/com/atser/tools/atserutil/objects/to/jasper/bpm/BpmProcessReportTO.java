/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.bpm;

import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.*;
import java.awt.image.BufferedImage;
import java.util.List;
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
public class BpmProcessReportTO extends QaInspectionReportTO {

    private BufferedImage clientLogo;
    private String number;
    private String revision;
    private String subject;
    private List<BpmTaskReportTO> tasks;
}
