/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.List;

/**
 * QaInspectionTestService
 * @author droldan
 */
public interface QaInspectionTestService {

    BigDecimal save(ManageITHeader header, QaInspection elem);

    QaInspection populate(QaInspection model, QaInspection elem);

    List<QaInspectionReportTO> generateReportData(List<QaInspection> ds, BufferedImage clientLogoImage);

    BigDecimal createFolderStruct(ManageITHeader header, QaInspection elem);

    QaInspection populateVersioning(QaInspection it);

    InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem);
}
