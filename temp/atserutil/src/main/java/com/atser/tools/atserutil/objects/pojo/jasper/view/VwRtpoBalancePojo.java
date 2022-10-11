/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.view;

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
public class VwRtpoBalancePojo {
    private String programName;
    private String phase;
    private String jobNo;
    private String purchaseOrderNo;
    private String cnumber;
    private String cname;
    private String cstatus;
    private String cdescription;
    private String camount;
    private String pstatus;
    private String pnumber;
    private String projectCode;
    private String pdate;
    private String pname;
    private Character active;
    private String balance;
    private BufferedImage projectLogo;
}
