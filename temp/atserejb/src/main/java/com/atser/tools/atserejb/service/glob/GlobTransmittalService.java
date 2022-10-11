/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobTransmittal;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author mfuentes
 */
public interface GlobTransmittalService extends ICrudService<BigDecimal, GlobTransmittal> {

    GlobTransmittal findById(ManageITHeader header, String id);

    GlobTransmittal findById(ManageITHeader header, BigDecimal id);

    void transmitt(ManageITBodyRequest body, String server_domain, TemplateEngine engine);

    void changeStatus(ManageITBodyRequest body);

    //  String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request);
    // void generateReportAndUploadToTrackIT(GlobTransmittal elem, String serverPath, String tplbasePath, String docpathsegment, ManageITHeader header);
}
