/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

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
public class InspectionContractInfoPojo {

    private String contractNo;
    private String districtNo;
    private String ntpDate;
    private String compDate;
    private String cityTown;
    private String primeContractor;
    private String federalAidNo;
    private String constructionParsNo;
    private String residenteEngr;
    private String distMatEngr;
    private String contractDescription;
}
