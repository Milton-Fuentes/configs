/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionContractInfoPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionHeaderPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionSignaturePojo;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface QaInspectionHelperService {

    InspectionContractInfoPojo populateInspectionContractInfo(GlobProject project);

    InspectionHeaderPojo populateInspectionHeader(String title, String rmsInfo, QaInspection it, GlobProject project, BufferedImage clientLogoImage);

    Map<String, InspectionSignaturePojo> populateSignatureMap(QaInspection insp);
}
