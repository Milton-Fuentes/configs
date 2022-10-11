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
import com.atser.tools.atserejb.model.QaInspectionAsset;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobSupplierAddressService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.view.VwTestPlanItemService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.QaInspectionVisualPojo;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionVisualTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
@InspectionTest(type = "visual_inspection")
public class QaInspectionVisualServiceImpl implements QaInspectionTestService, IBaseEJBException {

    private final String ROOT_FOLDER_NAME = "attachments";
    private final String TEST_TITLE = "Visual Inspection";
    private final String TEST_RMS_INFO = "RMS 902";
    private final String TEST_REPORT_ABBR = "INSP - ";
    private final String TEST_TRACKIT_NAME = "Visual Inspection Report";

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
    private QaInspectionAssetService qaInspectionAssetService;

    @Override
    public BigDecimal createFolderStruct(ManageITHeader header, QaInspection elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Inspection Reports Folder
        BigDecimal inspectionReportFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "Inspection Reports");
        if (inspectionReportFolderId != null) {
            // Get Visual Report Folder
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
            GlobContact cinfo = globContactService.findById(elem.getQaInspectionVisual().getInspectedBy().toString());
            if (cinfo != null) {
                elem.getQaInspectionVisual().setInspectedByName(cinfo.getFullName());
                elem.getQaInspectionVisual().setInspectedByJobtitle(cinfo.getTitle());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    /**
     * Populate QaInspectionVisual
     *
     * @param model
     * @param elem
     * @return
     */
    @Override
    public QaInspection populate(QaInspection model, QaInspection elem) {
        model.getQaInspectionVisual().setWbsitemId(elem.getQaInspectionVisual().getWbsitemId());
        model.getQaInspectionVisual().setBiditemId(elem.getQaInspectionVisual().getBiditemId());
        model.getQaInspectionVisual().setSubBiditemId(elem.getQaInspectionVisual().getSubBiditemId());
        model.getQaInspectionVisual().setSupplierId(elem.getQaInspectionVisual().getSupplierId());
        model.getQaInspectionVisual().setSupplierLocationId(elem.getQaInspectionVisual().getSupplierLocationId());
        model.getQaInspectionVisual().setSupplierName(elem.getQaInspectionVisual().getSupplierName());
        model.getQaInspectionVisual().setSupplierLocation(elem.getQaInspectionVisual().getSupplierLocation());
        model.getQaInspectionVisual().setSupplierType(elem.getQaInspectionVisual().getSupplierType());
        model.getQaInspectionVisual().setProposedUse(elem.getQaInspectionVisual().getProposedUse());
        model.getQaInspectionVisual().setAssetAddinfo(elem.getQaInspectionVisual().getAssetAddinfo());
        model.getQaInspectionVisual().setInspectedBy(elem.getQaInspectionVisual().getInspectedBy());
        GlobContact cinfo = globContactService.findById(elem.getQaInspectionVisual().getInspectedBy().toString());
        if (cinfo != null) {
            model.getQaInspectionVisual().setInspectedByName(cinfo.getFullName());
            model.getQaInspectionVisual().setInspectedByJobtitle(cinfo.getTitle());
        }
        model.getQaInspectionVisual().setInspectedLocation(elem.getQaInspectionVisual().getInspectedLocation());
        model.getQaInspectionVisual().setInspectedDate(elem.getQaInspectionVisual().getInspectedDate());
        model.getQaInspectionVisual().setCitytown(elem.getQaInspectionVisual().getCitytown());
        model.getQaInspectionVisual().setGpsLatitude(elem.getQaInspectionVisual().getGpsLatitude());
        model.getQaInspectionVisual().setGpsLongitude(elem.getQaInspectionVisual().getGpsLongitude());
        model.getQaInspectionVisual().setGpsAltitude(elem.getQaInspectionVisual().getGpsAltitude());
        model.getQaInspectionVisual().setInspAddinfo(elem.getQaInspectionVisual().getInspAddinfo());
        model.setRemarks(elem.getQaInspectionVisual().getRemarks());
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
                    QaInspectionVisualTO obj = new QaInspectionVisualTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Visual Info
                    obj.setVisualInfo(generateInspectionVisualPojo(it));
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

    public QaInspectionVisualPojo generateInspectionVisualPojo(QaInspection it) {
        QaInspectionVisualPojo elem = new QaInspectionVisualPojo();
        elem.setLoggedInBy(it.getLoggedInBy());
        elem.setLoggedDate(DateSupport.formatDate(it.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        elem.setLoggedJobTitle(it.getLoggedInJobtitle());
        if (it.getQaInspectionVisual() != null) {
            // WbsItems
            if (it.getQaInspectionVisual().getWbsitemId() != null) {
                VwTestPlanItem wbsItemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getWbsitemId());
                if (wbsItemId != null) {
                    elem.setWbsitemNo(wbsItemId.getItemNo());
                    elem.setWbsitemSpecNo(wbsItemId.getMatSpec());
                    if (wbsItemId.getEstmQty() != null) {
                        elem.setWbsitemProjQuantity(StringSupport.getString(wbsItemId.getEstmQty()) + " " + wbsItemId.getUnit());
                    }
                    elem.setWbsitemDescription(wbsItemId.getItemDescript());
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getBiditemId());
            if (biditemId != null) {
                elem.setBiditemNo(biditemId.getItemNo());
                elem.setBiditemSpecNo(biditemId.getMatSpec());
                if (biditemId.getEstmQty() != null) {
                    elem.setBiditemProjQuantity(StringSupport.getString(biditemId.getEstmQty()) + " " + biditemId.getUnit());
                }
                elem.setBiditemDescription(biditemId.getItemDescript());
            }
            // SubBidItems
            if (it.getQaInspectionVisual().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getSubBiditemId());
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
            if (it.getQaInspectionVisual().getSupplierId() != null) {
                GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionVisual().getSupplierId()));
                if (supplier != null) {
                    elem.setSupplier(supplier.getSupplier());
                }
            }
            if (it.getQaInspectionVisual().getSupplierLocationId() != null) {
                // Supplier Address
                GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionVisual().getSupplierLocationId()));
                if (address != null) {
                    elem.setSupplierLocation(address.getLocation());
                }
            }
            elem.setSupplierStr(it.getQaInspectionVisual().getSupplierName());
            elem.setSupplierLocationStr(it.getQaInspectionVisual().getSupplierLocation());
            elem.setProposedUse(it.getQaInspectionVisual().getProposedUse());
            // Asset List
            List<QaInspectionAsset> assetList = qaInspectionAssetService.list(new ManageITBodyRequest(0, 0).filter("inspectionId.id", it.getId()));
            if (assetList != null && !assetList.isEmpty()) {
                elem.setNoConstAsset(StringSupport.getString(assetList.size()));
                String listByComma = assetList.stream().map(s -> s.getAssetNo()).collect(Collectors.joining(";"));
                if (StringSupport.isNotNullAndNotEmpty(listByComma)) {
                    elem.setConstAssetList(listByComma);
                }
            }
            elem.setAssetAddInfo(it.getQaInspectionVisual().getAssetAddinfo());
            elem.setInspectedBy(it.getQaInspectionVisual().getInspectedByName());
            elem.setInspectedDate(DateSupport.formatDate(it.getQaInspectionVisual().getInspectedDate(), DateSupport.FORMAT_US));
            elem.setInspectedJobTitle(it.getQaInspectionVisual().getInspectedByJobtitle());
            elem.setInspectedLocation(it.getQaInspectionVisual().getInspectedLocation());
            elem.setCitytown(it.getQaInspectionVisual().getCitytown());
            elem.setInspAddinfo(it.getQaInspectionVisual().getInspAddinfo());
            elem.setRemarks(it.getQaInspectionVisual().getRemarks());
        }
        return elem;
    }

    @Override
    public QaInspection populateVersioning(QaInspection it) {
        // WbsItems
        if (it.getQaInspectionVisual().getWbsitemId() != null) {
            VwTestPlanItem wbsItemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getWbsitemId());
            if (wbsItemId != null) {
                it.getQaInspectionVisual().setWbsitemFullName(wbsItemId.getItemNoDescription());
            }
        }
        // BidItems
        VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getBiditemId());
        if (biditemId != null) {
            it.getQaInspectionVisual().setBiditemFullName(biditemId.getItemNoDescription());
        }
        // SubBidItems
        if (it.getQaInspectionVisual().getSubBiditemId() != null) {
            VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionVisual().getSubBiditemId());
            if (subBiditemId != null) {
                it.getQaInspectionVisual().setSubBiditemFullName(subBiditemId.getItemNo());
            }
        }
        // Supplier
        if (it.getQaInspectionVisual().getSupplierId() != null) {
            GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionVisual().getSupplierId()));
            if (supplier != null) {
                it.getQaInspectionVisual().setSupplierFullName(supplier.getSupplier());
            }
        }
        // Supplier Address
        if (it.getQaInspectionVisual().getSupplierLocationId() != null) {
            GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionVisual().getSupplierLocationId()));
            if (address != null) {
                it.getQaInspectionVisual().setSupplierLocationName(address.getLocation());
            }
        }
        return it;
    }

    @Override
    public InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem) {
        InspectionReportMetadataPojo response = new InspectionReportMetadataPojo();
        StringBuilder title = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            // WbsItems
            if (elem.getQaInspectionVisual().getWbsitemId() != null) {
                VwTestPlanItem wbsitemId = vwTestPlanItemService.findById(elem.getQaInspectionVisual().getWbsitemId());
                if (wbsitemId != null) {
                    title.append(wbsitemId.getItemNo()).append("-");
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(elem.getQaInspectionVisual().getBiditemId());
            if (biditemId != null) {
                title.append(biditemId.getItemNo());
            }
            // SubBidItems
            if (elem.getQaInspectionVisual().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(elem.getQaInspectionVisual().getSubBiditemId());
                if (subBiditemId != null) {
                    title.append("(").append(subBiditemId.getItemDescriptCom()).append(") - ");
                }
            }
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        } else {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        }
        response.trackItReportName = title.toString();
        response.reportId = "qaInspVisual";
        response.funcId = "fc_inspection_visual";
        response.folderFunct = "insp_folder_visual_inspection";
        return response;
    }

}
