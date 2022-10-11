/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.inspection;

import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionContractInfoPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionHeaderPojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QaInspectionReportTO {

    protected InspectionHeaderPojo header;
    protected InspectionContractInfoPojo contractInfo;
}
