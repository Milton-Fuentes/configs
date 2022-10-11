/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.qualifiers.inspection.InspectionTest;
import com.atser.tools.atserejb.dao.qa.QaInspectionDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.QaInspectionNotuitem;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionNotUnusedVerifPojo;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionNotunusedTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
@InspectionTest(type = "notice_unused_items")
public class QaInspectionNotunusedServiceImpl implements QaInspectionTestService, IBaseEJBException {

    private final String ROOT_FOLDER_NAME = "attachments";
    private final String TEST_TITLE = "Notice of Unused Items";
    private final String TEST_RMS_INFO = "RMS 904";
    private final String TEST_REPORT_ABBR = "NU - ";
    private final String TEST_TRACKIT_NAME = TEST_TITLE;

    @Inject
    private QaInspectionDao dao;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private QaInspectionNotuitemService qaInspectionNotuitemService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private GlobContactService globContactService;

    @Inject
    private QaInspectionHelperService qaInspectionHelperService;

    @Override
    public BigDecimal createFolderStruct(ManageITHeader header, QaInspection elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Inspection Reports Folder
        BigDecimal inspectionReportFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "Inspection Reports");
        if (inspectionReportFolderId != null) {
            // Get Notice of Unused Items Report Folder
            BigDecimal notUnusedRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), TEST_TRACKIT_NAME, inspectionReportFolderId.toBigInteger());
            if (notUnusedRootFolderId != null) {
                // Create Attachment Folder
                BigDecimal attachmentRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), ROOT_FOLDER_NAME, notUnusedRootFolderId.toBigInteger());
                if (attachmentRootFolderId == null) {
                    attachmentRootFolderId = folderService.createTrackITFolder(notUnusedRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', ROOT_FOLDER_NAME, new BigInteger("2"));
                }
                if (attachmentRootFolderId != null) {
                    return folderService.createTrackITFolder(attachmentRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', elem.getInspNo(), new BigInteger("2"));
                }
            }
        }
        return null;
    }

    /**
     * To save QaInspection for Notunused
     *
     * @param header
     * @param elem
     * @see Not for regular use
     * @return
     */
    @Override
    public BigDecimal save(ManageITHeader header, QaInspection elem) {
        if (elem != null) {
            GlobContact cinfo = globContactService.findById(elem.getQaInspectionNotunused().getVerifiedBy().toString());
            if (cinfo != null) {
                elem.getQaInspectionNotunused().setVerifiedByName(cinfo.getFullName());
                elem.getQaInspectionNotunused().setVerifiedByJobtitle(cinfo.getTitle());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public QaInspection populate(QaInspection model, QaInspection elem) {
        model.getQaInspectionNotunused().setVerifiedBy(elem.getQaInspectionNotunused().getVerifiedBy());
        GlobContact cinfo = globContactService.findById(elem.getQaInspectionNotunused().getVerifiedBy().toString());
        if (cinfo != null) {
            model.getQaInspectionNotunused().setVerifiedByName(cinfo.getFullName());
            model.getQaInspectionNotunused().setVerifiedByJobtitle(cinfo.getTitle());
        }
        model.getQaInspectionNotunused().setVerifiedDate(elem.getQaInspectionNotunused().getVerifiedDate());
        model.setRemarks(elem.getQaInspectionNotunused().getRemarks());
        return model;
    }

    @Override
    public QaInspection populateVersioning(QaInspection it) {
        return it;
    }

    /**
     * Generate Report Data for Notice of Unused Items Test
     *
     * @param ds
     * @param clientLogoImage
     * @return
     */
    @Override
    public List<QaInspectionReportTO> generateReportData(List<QaInspection> ds, BufferedImage clientLogoImage) {
        List<QaInspectionReportTO> rList = new ArrayList<>();
        ds.forEach(it -> {
            //Get Project
            if (it.getProjectId() != null) {
                GlobProject currentproject = globProjectService.findById(it.getProjectId().toString());
                if (currentproject != null) {
                    QaInspectionNotunusedTO obj = new QaInspectionNotunusedTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Verif Info
                    obj.setVerifInfo(generateInspectionNotUnusedVerifPojo(it));
                    // Determination
                    if (it.getSimplecatId() != null && StringSupport.isNotNullAndNotEmpty(it.getSimplecatId().getName())) {
                        obj.setItemDetermination(it.getSimplecatId().getName().toUpperCase());
                    }
                    // Populate Item List
                    List<QaInspectionNotuitem> notuitemList = qaInspectionNotuitemService.list(new ManageITBodyRequest(0, 0).filter("inspectionId.id", it.getId()));
                    if (notuitemList != null && !notuitemList.isEmpty()) {
                        notuitemList.forEach(item -> {
                            obj.addInspectionUnusedItemPojo(item.generateInspectionUnusedItemPojo());
                        });
                        obj.getVerifInfo().setNoUnusedItems(StringSupport.getString(notuitemList.size()));
                    }
                    // Populate Signture Map
                    obj.setSignatureList(qaInspectionHelperService.populateSignatureMap(it));
                    // Add to List
                    rList.add(obj);
                }
            }
        });
        return rList;
    }

    private InspectionNotUnusedVerifPojo generateInspectionNotUnusedVerifPojo(QaInspection it) {
        InspectionNotUnusedVerifPojo elem = new InspectionNotUnusedVerifPojo();
        elem.setLoggedInBy(it.getLoggedInBy());
        elem.setLoggedDate(DateSupport.formatDate(it.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        elem.setLoggedJobTitle(it.getLoggedInJobtitle());
        if (it.getQaInspectionNotunused() != null) {
            elem.setVerifiedBy(it.getQaInspectionNotunused().getVerifiedByName());
            elem.setVerifiedDate(DateSupport.formatDate(it.getQaInspectionNotunused().getVerifiedDate(), DateSupport.FORMAT_US));
            elem.setVerifiedJobTitle(it.getQaInspectionNotunused().getVerifiedByJobtitle());
        }
        return elem;
    }

    @Override
    public InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem) {
        InspectionReportMetadataPojo response = new InspectionReportMetadataPojo();
        StringBuilder title = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        } else {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        }
        response.trackItReportName = title.toString();
        response.reportId = "qaInspNotUnused";
        response.funcId = "fc_inspection_notunused";
        response.folderFunct = "insp_folder_notice_unused_items";
        return response;
    }

}
