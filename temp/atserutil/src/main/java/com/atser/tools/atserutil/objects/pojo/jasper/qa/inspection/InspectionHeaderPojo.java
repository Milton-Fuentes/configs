/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

import java.awt.image.BufferedImage;
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
public class InspectionHeaderPojo {

    private String rmsInfo;
    private String revDate;
    private BufferedImage projectLogo;
    private String district;
    private String address;
    private String reportTitle;
    private String inspectionType;
    private String testNo;
}
