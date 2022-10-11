/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.glob;

import java.awt.image.BufferedImage;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mfuentes
 */
@Data
@NoArgsConstructor
public class GlobProjectCdotLogTO {

    private String pName;
    private String pNumber;

    private String version;
    private BufferedImage logo;
}
