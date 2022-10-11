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
public class GlobTransmittalTO {

    private String pname;
    private String name;
    private String pnumber;
    private String sno;
    private String spno;
    private String transmittalNo;
    
    private String transmittedBy;
    private String transmittedByCompany;
    private String attention;
    private String attentionCompany;
    private String transmittedFor;
    private String status;
    private String attachment;  
    
    private String created;
    private String createdBy;
    private String lastMod;
    private String lastModBy;
    private String version;
    private BufferedImage logo;
}
