/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobUserSignatureService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionContractInfoPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionHeaderPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionSignaturePojo;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.atser.tools.atserejb.service.glob.GlobLabsService;

@Stateless
public class QaInspectionHelperServiceImpl implements QaInspectionHelperService, IBaseEJBException {

    @Inject
    private GlobLabsService globLabsService;

    @Inject
    private GlobContactService globContactService;

    @Inject
    private GlobUserSignatureService globUserSignatureService;

    /**
     * Populate Contract Information
     *
     * @param project
     * @return
     */
    @Override
    public InspectionContractInfoPojo populateInspectionContractInfo(GlobProject project) {
        InspectionContractInfoPojo elem = new InspectionContractInfoPojo();
        elem.setContractNo(project.getPNumber());
        if (project.getRegionId() != null) {
            elem.setDistrictNo(project.getRegionId().getName());
        }
        elem.setNtpDate(DateSupport.formatDate(project.getPDate(), DateSupport.FORMAT_US));
        elem.setCompDate(DateSupport.formatDate(project.getEndDate(), DateSupport.FORMAT_US));
        elem.setCityTown(project.getLocation());
        if (project.getContractorId() != null) {
            elem.setPrimeContractor(project.getContractorId().getContractor());
        }
        elem.setFederalAidNo(project.getCuicNo());
        elem.setConstructionParsNo(project.getAccNo());
        if (project.getPersonProjectManager() != null) {
            elem.setResidenteEngr(globContactService.findById(project.getPersonProjectManager().toString()).getFullName());
        }
        if (project.getPersonEngineer() != null) {
            elem.setDistMatEngr(globContactService.findById(project.getPersonEngineer().toString()).getFullName());
        }
        elem.setContractDescription(project.getPName());
        return elem;
    }

    /**
     * Populate Report Header
     *
     * @param title
     * @param rmsInfo
     * @param it
     * @param project
     * @param clientLogoImage
     * @return
     */
    @Override
    public InspectionHeaderPojo populateInspectionHeader(String title, String rmsInfo, QaInspection it, GlobProject project, BufferedImage clientLogoImage) {
        InspectionHeaderPojo elem = new InspectionHeaderPojo();
        elem.setRmsInfo(rmsInfo);
        elem.setProjectLogo(clientLogoImage);
        elem.setRevDate("Rev." + DateSupport.formatDate(new Date(), DateSupport.FORMAT_US));
        elem.setReportTitle(title);
        if (it.getLabId() != null) {
            GlobLabs lab = globLabsService.findById(it.getLabId().toString());
            if (lab != null) {
                elem.setDistrict(lab.getLabName());
                elem.setAddress(lab.getFullAddress());
                elem.setInspectionType(lab.getFunctionId().getFName());
            }
        }
        elem.setTestNo(it.getInspNo());
        return elem;
    }

    /**
     * Populate Signature Map
     *
     * @param insp
     * @return
     */
    @Override
    public Map<String, InspectionSignaturePojo> populateSignatureMap(QaInspection insp) {
        Map<String, InspectionSignaturePojo> map = new HashMap<>();
        initializeServiceList(insp.getQaInspectionSigninfoList());
        if (!insp.getQaInspectionSigninfoList().isEmpty()) {
            insp.getQaInspectionSigninfoList().forEach(it -> {
                if (it.getSigned().equals('Y') && it.getSignedBy() != null) {
                    BufferedImage signature;
                    try {
                        signature = ImageSupport.convertByteArrayToBufferedImage(globUserSignatureService.findByUserId(it.getSignedBy().toString()).getImageData());
                    } catch (IOException | NullPointerException ex) {
                        signature = null;
                    }
                    map.put(it.getSignflowId().getSimplecatId().getShortName(), new InspectionSignaturePojo(it.getSignedByName(), DateSupport.formatDate(it.getSignedDate(), DateSupport.FORMAT_US), it.getSignedByJobtitle(), signature));
                }
            });
        }
        return map;
    }

}
