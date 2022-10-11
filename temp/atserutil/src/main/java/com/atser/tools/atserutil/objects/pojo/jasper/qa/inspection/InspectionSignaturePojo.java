/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

import java.awt.image.BufferedImage;
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
public class InspectionSignaturePojo {

    private String verifiedBy;
    private String verifiedDate;
    private String jobTitle;
    private BufferedImage signature;
}
