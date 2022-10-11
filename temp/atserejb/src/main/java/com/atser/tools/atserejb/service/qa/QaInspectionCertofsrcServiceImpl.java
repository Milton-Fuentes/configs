/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.qualifiers.inspection.InspectionTest;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QaInspectionDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobSupplierAddressService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.view.VwTestPlanItemService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionCertOfSrcPojo;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionCertOfSrcTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
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
@InspectionTest(type = "certificate_of_source")
public class QaInspectionCertofsrcServiceImpl implements QaInspectionTestService, IBaseEJBException {

    private final String ROOT_FOLDER_NAME = "attachments";
    private final String TEST_TITLE = "Confirmation of Source";
    private final String TEST_RMS_INFO = "RMS 768";
    private final String TEST_REPORT_ABBR = "COS - ";
    private final String TEST_TRACKIT_NAME = TEST_TITLE;

    @Inject
    private QaInspectionDao dao;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private GlobContactService globContactService;

    @Inject
    private QaInspectionHelperService qaInspectionHelperService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobSupplierService globSupplierService;

    @Inject
    private GlobSupplierAddressService globSupplierAddressService;

    @Inject
    private VwTestPlanItemService vwTestPlanItemService;

    @Override
    public BigDecimal save(ManageITHeader header, QaInspection elem) {
        if (elem != null) {
            GlobContact cinfo = globContactService.findById(elem.getQaInspectionCertofsrc().getVerifiedBy().toString());
            if (cinfo != null) {
                elem.getQaInspectionCertofsrc().setVerifiedByName(cinfo.getFullName());
                elem.getQaInspectionCertofsrc().setVerifiedByJobtitle(cinfo.getTitle());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public QaInspection populate(QaInspection model, QaInspection elem) {
        model.getQaInspectionCertofsrc().setWbsitemId(elem.getQaInspectionCertofsrc().getWbsitemId());
        model.getQaInspectionCertofsrc().setBiditemId(elem.getQaInspectionCertofsrc().getBiditemId());
        model.getQaInspectionCertofsrc().setSubBiditemId(elem.getQaInspectionCertofsrc().getSubBiditemId());
        model.getQaInspectionCertofsrc().setSupplierId(elem.getQaInspectionCertofsrc().getSupplierId());
        model.getQaInspectionCertofsrc().setSupplierLocationId(elem.getQaInspectionCertofsrc().getSupplierLocationId());
        model.getQaInspectionCertofsrc().setSupplierName(elem.getQaInspectionCertofsrc().getSupplierName());
        model.getQaInspectionCertofsrc().setSupplierLocation(elem.getQaInspectionCertofsrc().getSupplierLocation());
        model.getQaInspectionCertofsrc().setSupplierType(elem.getQaInspectionCertofsrc().getSupplierType());
        model.getQaInspectionCertofsrc().setFabricatorName(elem.getQaInspectionCertofsrc().getFabricatorName());
        model.getQaInspectionCertofsrc().setFabricatorLocation(elem.getQaInspectionCertofsrc().getFabricatorLocation());
        model.getQaInspectionCertofsrc().setTotalItemOnContract(elem.getQaInspectionCertofsrc().getTotalItemOnContract());
        model.getQaInspectionCertofsrc().setProductName(elem.getQaInspectionCertofsrc().getProductName());
        model.getQaInspectionCertofsrc().setApplication(elem.getQaInspectionCertofsrc().getApplication());
        model.getQaInspectionCertofsrc().setVerifiedBy(elem.getQaInspectionCertofsrc().getVerifiedBy());
        GlobContact cinfo = globContactService.findById(elem.getQaInspectionCertofsrc().getVerifiedBy().toString());
        if (cinfo != null) {
            model.getQaInspectionCertofsrc().setVerifiedByName(cinfo.getFullName());
            model.getQaInspectionCertofsrc().setVerifiedByJobtitle(cinfo.getTitle());
        }
        model.getQaInspectionCertofsrc().setVerifiedDate(elem.getQaInspectionCertofsrc().getVerifiedDate());
        model.getQaInspectionCertofsrc().setInspAddinfo(elem.getQaInspectionCertofsrc().getInspAddinfo());
        model.getQaInspectionCertofsrc().setSrcHasBeenVerified(elem.getQaInspectionCertofsrc().getSrcHasBeenVerified());
        model.getQaInspectionCertofsrc().setCertOfCompliance(elem.getQaInspectionCertofsrc().getCertOfCompliance());
        model.getQaInspectionCertofsrc().setDoNotUse(elem.getQaInspectionCertofsrc().getDoNotUse());
        model.getQaInspectionCertofsrc().setSampleTest(elem.getQaInspectionCertofsrc().getSampleTest());
        model.setRemarks(elem.getQaInspectionCertofsrc().getRemarks());
        return model;
    }

    @Override
    public BigDecimal createFolderStruct(ManageITHeader header, QaInspection elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Inspection Reports Folder
        BigDecimal inspectionReportFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "Inspection Reports");
        if (inspectionReportFolderId != null) {
            // Get Cert. of Source Report Folder
            BigDecimal certofsrcRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), TEST_TRACKIT_NAME, inspectionReportFolderId.toBigInteger());
            if (certofsrcRootFolderId != null) {
                // Create Attachment Folder
                BigDecimal attachmentRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), ROOT_FOLDER_NAME, certofsrcRootFolderId.toBigInteger());
                if (attachmentRootFolderId == null) {
                    attachmentRootFolderId = folderService.createTrackITFolder(certofsrcRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', ROOT_FOLDER_NAME, new BigInteger("2"));
                }
                if (attachmentRootFolderId != null) {
                    return folderService.createTrackITFolder(attachmentRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', elem.getInspNo(), new BigInteger("2"));
                }
            }
        }
        return null;
    }

    @Override
    public QaInspection populateVersioning(QaInspection it) {
        // WbsItems
        if (it.getQaInspectionCertofsrc().getWbsitemId() != null) {
            VwTestPlanItem wbsIditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getWbsitemId());
            if (wbsIditemId != null) {
                it.getQaInspectionCertofsrc().setWbsitemFullName(wbsIditemId.getItemNoDescription());
            }
        }
        // BidItems
        VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getBiditemId());
        if (biditemId != null) {
            it.getQaInspectionCertofsrc().setBiditemFullName(biditemId.getItemNoDescription());
        }
        // SubBidItems
        if (it.getQaInspectionCertofsrc().getSubBiditemId() != null) {
            VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getSubBiditemId());
            if (subBiditemId != null) {
                it.getQaInspectionCertofsrc().setSubBiditemFullName(subBiditemId.getItemDescriptCom());
            }
        }
        // Supplier
        if (it.getQaInspectionCertofsrc().getSupplierId() != null) {
            GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionCertofsrc().getSupplierId()));
            if (supplier != null) {
                it.getQaInspectionCertofsrc().setSupplierFullName(supplier.getSupplier());
            }
        }
        // Supplier Address
        if (it.getQaInspectionCertofsrc().getSupplierLocationId() != null) {
            GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionCertofsrc().getSupplierLocationId()));
            if (address != null) {
                it.getQaInspectionCertofsrc().setSupplierLocationName(address.getLocation());
            }
        }
        return it;
    }

    @Override
    public List<QaInspectionReportTO> generateReportData(List<QaInspection> ds, BufferedImage clientLogoImage) {
        List<QaInspectionReportTO> rList = new ArrayList<>();
        ds.forEach(it -> {
            //Get Project
            if (it.getProjectId() != null) {
                GlobProject currentproject = globProjectService.findById(it.getProjectId().toString());
                if (currentproject != null) {
                    QaInspectionCertOfSrcTO obj = new QaInspectionCertOfSrcTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Cert Info
                    obj.setCertInfo(generateInspectionCertOfSrcPojo(it));
                    // Populate Signture Map
                    obj.setSignatureList(qaInspectionHelperService.populateSignatureMap(it));
                    // Add to List
                    rList.add(obj);
                }
            }
        });
        return rList;
    }

    private InspectionCertOfSrcPojo generateInspectionCertOfSrcPojo(QaInspection it) {
        InspectionCertOfSrcPojo elem = new InspectionCertOfSrcPojo();
        elem.setLoggedInBy(it.getLoggedInBy());
        elem.setLoggedDate(DateSupport.formatDate(it.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        elem.setLoggedJobTitle(it.getLoggedInJobtitle());
        if (it.getQaInspectionCertofsrc() != null) {
            // WbsItems
            if (it.getQaInspectionCertofsrc().getWbsitemId() != null) {
                VwTestPlanItem wbsIditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getWbsitemId());
                if (wbsIditemId != null) {
                    elem.setWbsitemNo(wbsIditemId.getItemNo());
                    elem.setWbsitemSpecNo(wbsIditemId.getMatSpec());
                    if (wbsIditemId.getEstmQty() != null) {
                        elem.setWbsitemProjQuantity(StringSupport.getString(wbsIditemId.getEstmQty()) + " " + wbsIditemId.getUnit());
                    }
                    elem.setWbsitemDescription(wbsIditemId.getItemDescript());
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getBiditemId());
            if (biditemId != null) {
                elem.setBiditemNo(biditemId.getItemNo());
                elem.setBiditemSpecNo(biditemId.getMatSpec());
                if (biditemId.getEstmQty() != null) {
                    elem.setBiditemProjQuantity(StringSupport.getString(biditemId.getEstmQty()) + " " + biditemId.getUnit());
                }
                elem.setBiditemDescription(biditemId.getItemDescript());
            }
            // SubBidItems
            if (it.getQaInspectionCertofsrc().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionCertofsrc().getSubBiditemId());
                if (subBiditemId != null) {
                    elem.setSubBiditemNo(subBiditemId.getItemNo());
                    elem.setSubBiditemSpecNo(subBiditemId.getMatSpec());
                    if (subBiditemId.getEstmQty() != null) {
                        elem.setSubBiditemProjQuantity(StringSupport.getString(subBiditemId.getEstmQty()) + " " + subBiditemId.getUnit());
                    }
                    elem.setSubBiditemDescription(subBiditemId.getItemDescript());
                }
            }
            // Supplier
            if (it.getQaInspectionCertofsrc().getSupplierId() != null) {
                GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionCertofsrc().getSupplierId()));
                if (supplier != null) {
                    elem.setSupplier(supplier.getSupplier());
                }
            }
            // Supplier Address
            if (it.getQaInspectionCertofsrc().getSupplierLocationId() != null) {
                GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionCertofsrc().getSupplierLocationId()));
                if (address != null) {
                    elem.setSupplierLocation(address.getLocation());
                }
            }
            elem.setSupplierStr(it.getQaInspectionCertofsrc().getSupplierName());
            elem.setSupplierLocationStr(it.getQaInspectionCertofsrc().getSupplierLocation());
            elem.setFabricatorStr(it.getQaInspectionCertofsrc().getFabricatorName());
            elem.setFabricatorLocationStr(it.getQaInspectionCertofsrc().getFabricatorLocation());
            elem.setTotalItemOnContract(it.getQaInspectionCertofsrc().getTotalItemOnContract());
            elem.setProductName(it.getQaInspectionCertofsrc().getProductName());
            elem.setApplication(it.getQaInspectionCertofsrc().getApplication());
            elem.setVerifiedBy(it.getQaInspectionCertofsrc().getVerifiedByName());
            elem.setVerifiedDate(DateSupport.formatDate(it.getQaInspectionCertofsrc().getVerifiedDate(), DateSupport.FORMAT_US));
            elem.setVerifiedJobTitle(it.getQaInspectionCertofsrc().getVerifiedByJobtitle());
            elem.setInspAddinfo(it.getQaInspectionCertofsrc().getInspAddinfo());
            elem.setSrcHasBeenVerified(it.getQaInspectionCertofsrc().getSrcHasBeenVerified());
            elem.setCertOfCompliance(it.getQaInspectionCertofsrc().getCertOfCompliance());
            elem.setDoNotUse(it.getQaInspectionCertofsrc().getDoNotUse());
            elem.setSampleTest(it.getQaInspectionCertofsrc().getSampleTest());
            elem.setRemarks(it.getQaInspectionCertofsrc().getRemarks());
        }
        return elem;
    }

    @Override
    public InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem) {
        InspectionReportMetadataPojo response = new InspectionReportMetadataPojo();
        StringBuilder title = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            // WbsItems
            if (elem.getQaInspectionCertofsrc().getWbsitemId() != null) {
                VwTestPlanItem wbsitemId = vwTestPlanItemService.findById(elem.getQaInspectionCertofsrc().getWbsitemId());
                if (wbsitemId != null) {
                    title.append(wbsitemId.getItemNo()).append("-");
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(elem.getQaInspectionCertofsrc().getBiditemId());
            if (biditemId != null) {
                title.append(biditemId.getItemNo());
            }
            // SubBidItems
            if (elem.getQaInspectionCertofsrc().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(elem.getQaInspectionCertofsrc().getSubBiditemId());
                if (subBiditemId != null) {
                    title.append("(").append(subBiditemId.getItemDescriptCom()).append(") - ");
                }
            }
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        } else {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        }
        response.trackItReportName = title.toString();
        response.reportId = "qaInspCertOfSrc";
        response.funcId = "fc_inspection_certofsrc";
        response.folderFunct = "insp_folder_certificate_of_source";
        return response;
    }
}
