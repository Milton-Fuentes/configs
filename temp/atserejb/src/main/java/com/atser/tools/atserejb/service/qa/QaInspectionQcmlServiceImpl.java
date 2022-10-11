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
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobSupplierAddressService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.service.view.VwTestPlanItemService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionQcmlPojo;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionQcmlTO;
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
@InspectionTest(type = "qualified_construction_materials_list")
public class QaInspectionQcmlServiceImpl implements QaInspectionTestService, IBaseEJBException {

    private final String ROOT_FOLDER_NAME = "attachments";
    private final String TEST_TITLE = "Qualified Construction Materials List";
    private final String TEST_RMS_INFO = "RMS 903";
    private final String TEST_REPORT_ABBR = "QCML - ";
    private final String TEST_TRACKIT_NAME = "QCML Verification";

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

    @Inject
    private QmCvlFieldDataService qmCvlFieldDataService;

    @Override
    public BigDecimal createFolderStruct(ManageITHeader header, QaInspection elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Inspection Reports Folder
        BigDecimal inspectionReportFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "Inspection Reports");
        if (inspectionReportFolderId != null) {
            // Get QCML Report Folder
            BigDecimal visualRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), TEST_TRACKIT_NAME, inspectionReportFolderId.toBigInteger());
            if (visualRootFolderId != null) {
                // Create Attachment Folder
                BigDecimal attachmentRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), ROOT_FOLDER_NAME, visualRootFolderId.toBigInteger());
                if (attachmentRootFolderId == null) {
                    attachmentRootFolderId = folderService.createTrackITFolder(visualRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', ROOT_FOLDER_NAME, new BigInteger("2"));
                }
                if (attachmentRootFolderId != null) {
                    return folderService.createTrackITFolder(attachmentRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', elem.getInspNo(), new BigInteger("2"));
                }
            }
        }
        return null;
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaInspection elem) {
        if (elem != null) {
            GlobContact cinfo = globContactService.findById(elem.getQaInspectionQcml().getVerifiedBy().toString());
            if (cinfo != null) {
                elem.getQaInspectionQcml().setVerifiedByName(cinfo.getFullName());
                elem.getQaInspectionQcml().setVerifiedByJobtitle(cinfo.getTitle());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    /**
     * Populate QaInspectionQcml
     *
     * @param model
     * @param elem
     * @return
     */
    @Override
    public QaInspection populate(QaInspection model, QaInspection elem) {
        model.getQaInspectionQcml().setWbsitemId(elem.getQaInspectionQcml().getWbsitemId());
        model.getQaInspectionQcml().setBiditemId(elem.getQaInspectionQcml().getBiditemId());
        model.getQaInspectionQcml().setSubBiditemId(elem.getQaInspectionQcml().getSubBiditemId());
        model.getQaInspectionQcml().setSupplierId(elem.getQaInspectionQcml().getSupplierId());
        model.getQaInspectionQcml().setSupplierLocationId(elem.getQaInspectionQcml().getSupplierLocationId());
        model.getQaInspectionQcml().setSupplierName(elem.getQaInspectionQcml().getSupplierName());
        model.getQaInspectionQcml().setSupplierLocation(elem.getQaInspectionQcml().getSupplierLocation());
        model.getQaInspectionQcml().setSupplierType(elem.getQaInspectionQcml().getSupplierType());
        model.getQaInspectionQcml().setQcmlCategoryId(elem.getQaInspectionQcml().getQcmlCategoryId());
        model.getQaInspectionQcml().setProductType(elem.getQaInspectionQcml().getProductType());
        model.getQaInspectionQcml().setProductBarchNo(elem.getQaInspectionQcml().getProductBarchNo());
        model.getQaInspectionQcml().setProductIdentificationNo(elem.getQaInspectionQcml().getProductIdentificationNo());
        model.getQaInspectionQcml().setVerifiedBy(elem.getQaInspectionQcml().getVerifiedBy());
        GlobContact cinfo = globContactService.findById(elem.getQaInspectionQcml().getVerifiedBy().toString());
        if (cinfo != null) {
            model.getQaInspectionQcml().setVerifiedByName(cinfo.getFullName());
            model.getQaInspectionQcml().setVerifiedByJobtitle(cinfo.getTitle());
        }
        model.getQaInspectionQcml().setVerifiedDate(elem.getQaInspectionQcml().getVerifiedDate());
        model.getQaInspectionQcml().setCastingDate(elem.getQaInspectionQcml().getCastingDate());
        model.getQaInspectionQcml().setExpirationDate(elem.getQaInspectionQcml().getExpirationDate());
        model.getQaInspectionQcml().setApprovedDate(elem.getQaInspectionQcml().getApprovedDate());
        model.getQaInspectionQcml().setQcmlAddinfo(elem.getQaInspectionQcml().getQcmlAddinfo());
        model.setRemarks(elem.getQaInspectionQcml().getRemarks());
        return model;
    }

    @Override
    public List<QaInspectionReportTO> generateReportData(List<QaInspection> ds, BufferedImage clientLogoImage) {
        List<QaInspectionReportTO> rList = new ArrayList<>();
        ds.forEach(it -> {
            //Get Project
            if (it.getProjectId() != null) {
                GlobProject currentproject = globProjectService.findById(it.getProjectId().toString());
                if (currentproject != null) {
                    QaInspectionQcmlTO obj = new QaInspectionQcmlTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Qcml Info
                    obj.setQcmlInfo(generateInspectionQcmlPojo(it));
                    // Determination
                    if (it.getSimplecatId() != null && StringSupport.isNotNullAndNotEmpty(it.getSimplecatId().getName())) {
                        obj.setItemDetermination(it.getSimplecatId().getName().toUpperCase());
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

    public InspectionQcmlPojo generateInspectionQcmlPojo(QaInspection it) {
        InspectionQcmlPojo elem = new InspectionQcmlPojo();
        elem.setLoggedInBy(it.getLoggedInBy());
        elem.setLoggedDate(DateSupport.formatDate(it.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        elem.setLoggedJobTitle(it.getLoggedInJobtitle());
        if (it.getQaInspectionQcml() != null) {
            // WbsItems
            if (it.getQaInspectionQcml().getWbsitemId() != null) {
                VwTestPlanItem wbsIditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getWbsitemId());
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
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getBiditemId());
            if (biditemId != null) {
                elem.setBiditemNo(biditemId.getItemNo());
                elem.setBiditemSpecNo(biditemId.getMatSpec());
                if (biditemId.getEstmQty() != null) {
                    elem.setBiditemProjQuantity(StringSupport.getString(biditemId.getEstmQty()) + " " + biditemId.getUnit());
                }
                elem.setBiditemDescription(biditemId.getItemDescript());
            }
            // SubBidItems
            if (it.getQaInspectionQcml().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getSubBiditemId());
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
            if (it.getQaInspectionQcml().getSupplierId() != null) {
                GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionQcml().getSupplierId()));
                if (supplier != null) {
                    elem.setSupplier(supplier.getSupplier());
                }
            }
            // Supplier Address
            if (it.getQaInspectionQcml().getSupplierLocationId() != null) {
                GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionQcml().getSupplierLocationId()));
                if (address != null) {
                    elem.setSupplierLocation(address.getLocation());
                }
            }
            elem.setSupplierStr(it.getQaInspectionQcml().getSupplierName());
            elem.setSupplierLocationStr(it.getQaInspectionQcml().getSupplierLocation());
            // Qcml Category
            QmCvlFieldData qcmlCat = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionQcml().getQcmlCategoryId()));
            if (qcmlCat != null) {
                elem.setQcmlCategory(qcmlCat.getValue());
            }
            elem.setProductType(it.getQaInspectionQcml().getProductType());
            elem.setApprovedDate(DateSupport.formatDate(it.getQaInspectionQcml().getApprovedDate(), DateSupport.FORMAT_US));
            elem.setProductBarchNo(it.getQaInspectionQcml().getProductBarchNo());
            elem.setProductIdentificationNo(it.getQaInspectionQcml().getProductIdentificationNo());
            elem.setCastingDate(DateSupport.formatDate(it.getQaInspectionQcml().getCastingDate(), DateSupport.FORMAT_US));
            elem.setExpirationDate(DateSupport.formatDate(it.getQaInspectionQcml().getExpirationDate(), DateSupport.FORMAT_US));
            elem.setQcmlAddinfo(it.getQaInspectionQcml().getQcmlAddinfo());
            elem.setVerifiedBy(it.getQaInspectionQcml().getVerifiedByName());
            elem.setVerifiedDate(DateSupport.formatDate(it.getQaInspectionQcml().getVerifiedDate(), DateSupport.FORMAT_US));
            elem.setVerifiedJobTitle(it.getQaInspectionQcml().getVerifiedByJobtitle());
            elem.setRemarks(it.getQaInspectionQcml().getRemarks());
        }
        return elem;
    }

    @Override
    public QaInspection populateVersioning(QaInspection it) {
        // WbsItems
        if (it.getQaInspectionQcml().getWbsitemId() != null) {
            VwTestPlanItem wbsIditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getWbsitemId());
            if (wbsIditemId != null) {
                it.getQaInspectionQcml().setWbsitemFullName(wbsIditemId.getItemNoDescription());
            }
        }
        // BidItems
        VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getBiditemId());
        if (biditemId != null) {
            it.getQaInspectionQcml().setBiditemFullName(biditemId.getItemNoDescription());
        }
        // SubBidItems
        if (it.getQaInspectionQcml().getSubBiditemId() != null) {
            VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionQcml().getSubBiditemId());
            if (subBiditemId != null) {
                it.getQaInspectionQcml().setSubBiditemFullName(subBiditemId.getItemDescriptCom());
            }
        }
        // Supplier
        if (it.getQaInspectionQcml().getSupplierId() != null) {
            GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionQcml().getSupplierId()));
            if (supplier != null) {
                it.getQaInspectionQcml().setSupplierFullName(supplier.getSupplier());
            }
        }
        // Supplier Address
        if (it.getQaInspectionQcml().getSupplierLocationId() != null) {
            GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionQcml().getSupplierLocationId()));
            if (address != null) {
                it.getQaInspectionQcml().setSupplierLocationName(address.getLocation());
            }
        }
        // Qcml Category
        QmCvlFieldData qcmlCat = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionQcml().getQcmlCategoryId()));
        if (qcmlCat != null) {
            it.getQaInspectionQcml().setQcmlCategoryName(qcmlCat.getValue());
        }
        return it;
    }

    @Override
    public InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem) {
        InspectionReportMetadataPojo response = new InspectionReportMetadataPojo();
        StringBuilder title = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            // WbsItems
            if (elem.getQaInspectionQcml().getWbsitemId() != null) {
                VwTestPlanItem wbsitemId = vwTestPlanItemService.findById(elem.getQaInspectionQcml().getWbsitemId());
                if (wbsitemId != null) {
                    title.append(wbsitemId.getItemNo()).append("-");
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(elem.getQaInspectionQcml().getBiditemId());
            if (biditemId != null) {
                title.append(biditemId.getItemNo());
            }
            // SubBidItems
            if (elem.getQaInspectionQcml().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(elem.getQaInspectionQcml().getSubBiditemId());
                if (subBiditemId != null) {
                    title.append("(").append(subBiditemId.getItemDescriptCom()).append(") - ");
                }
            }
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        } else {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        }
        response.trackItReportName = title.toString();
        response.reportId = "qaInspQualifiedConstructionMaterials";
        response.funcId = "fc_inspection_qualified_construction_materials";
        response.folderFunct = "insp_folder_qualified_construction_materials_list";
        return response;
    }

}
