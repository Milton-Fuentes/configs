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
import com.atser.tools.atserejb.model.QaconcMixdesigns;
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
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionPrecaststressPojo;
import com.atser.tools.atserutil.objects.pojo.qa.inspection.InspectionReportMetadataPojo;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionPrecaststressTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
@InspectionTest(type = "precast_prestress")
public class QaInspectionPrecaststressServiceImpl implements QaInspectionTestService, IBaseEJBException {

    private final String ROOT_FOLDER_NAME = "attachments";
    private final String TEST_TITLE = "Precast / Prestress";
    private final String TEST_RMS_INFO = "RMS 801";
    private final String TEST_REPORT_ABBR = "PRIN - ";
    private final String TEST_TRACKIT_NAME = "RMS 801 Precast/Prestressed Inspection Report";

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

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

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
            // Get Precast Report Folder
            BigDecimal precastRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), TEST_TRACKIT_NAME, inspectionReportFolderId.toBigInteger());
            if (precastRootFolderId != null) {
                // Create Attachment Folder
                BigDecimal attachmentRootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), ROOT_FOLDER_NAME, precastRootFolderId.toBigInteger());
                if (attachmentRootFolderId == null) {
                    attachmentRootFolderId = folderService.createTrackITFolder(precastRootFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "N", 'N', ROOT_FOLDER_NAME, new BigInteger("2"));
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
            GlobContact cinfo = globContactService.findById(elem.getQaInspectionPrecaststress().getInspectedBy().toString());
            if (cinfo != null) {
                elem.getQaInspectionPrecaststress().setInspectedByName(cinfo.getFullName());
                elem.getQaInspectionPrecaststress().setInspectedByJobtitle(cinfo.getTitle());
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public QaInspection populate(QaInspection model, QaInspection elem) {
        model.getQaInspectionPrecaststress().setWbsitemId(elem.getQaInspectionPrecaststress().getWbsitemId());
        model.getQaInspectionPrecaststress().setBiditemId(elem.getQaInspectionPrecaststress().getBiditemId());
        model.getQaInspectionPrecaststress().setSubBiditemId(elem.getQaInspectionPrecaststress().getSubBiditemId());
        model.getQaInspectionPrecaststress().setSupplierId(elem.getQaInspectionPrecaststress().getSupplierId());
        model.getQaInspectionPrecaststress().setSupplierLocationId(elem.getQaInspectionPrecaststress().getSupplierLocationId());
        model.getQaInspectionPrecaststress().setMixId(elem.getQaInspectionPrecaststress().getMixId());
        model.getQaInspectionPrecaststress().setCastDate(elem.getQaInspectionPrecaststress().getCastDate());
        model.getQaInspectionPrecaststress().setCategoryId(elem.getQaInspectionPrecaststress().getCategoryId());
        model.getQaInspectionPrecaststress().setCuringId(elem.getQaInspectionPrecaststress().getCuringId());
        model.getQaInspectionPrecaststress().setAssetAddinfo(elem.getQaInspectionPrecaststress().getAssetAddinfo());
        model.getQaInspectionPrecaststress().setInspectedBy(elem.getQaInspectionPrecaststress().getInspectedBy());
        GlobContact cinfo = globContactService.findById(elem.getQaInspectionPrecaststress().getInspectedBy().toString());
        if (cinfo != null) {
            model.getQaInspectionPrecaststress().setInspectedByName(cinfo.getFullName());
            model.getQaInspectionPrecaststress().setInspectedByJobtitle(cinfo.getTitle());
        }
        model.getQaInspectionPrecaststress().setInspectedLocation(elem.getQaInspectionPrecaststress().getInspectedLocation());
        model.getQaInspectionPrecaststress().setInspectedDate(elem.getQaInspectionPrecaststress().getInspectedDate());
        model.getQaInspectionPrecaststress().setCitytown(elem.getQaInspectionPrecaststress().getCitytown());
        model.getQaInspectionPrecaststress().setInspectionEntity(elem.getQaInspectionPrecaststress().getInspectionEntity());
        model.getQaInspectionPrecaststress().setEntityLocation(elem.getQaInspectionPrecaststress().getEntityLocation());
        model.getQaInspectionPrecaststress().setInspectorSupervisorId(elem.getQaInspectionPrecaststress().getInspectorSupervisorId());
        model.getQaInspectionPrecaststress().setGpsLatitude(elem.getQaInspectionPrecaststress().getGpsLatitude());
        model.getQaInspectionPrecaststress().setGpsLongitude(elem.getQaInspectionPrecaststress().getGpsLongitude());
        model.getQaInspectionPrecaststress().setGpsAltitude(elem.getQaInspectionPrecaststress().getGpsAltitude());
        model.getQaInspectionPrecaststress().setInspAddinfo(elem.getQaInspectionPrecaststress().getInspAddinfo());
        model.getQaInspectionPrecaststress().setMqcaInspActivities(elem.getQaInspectionPrecaststress().getMqcaInspActivities());
        model.getQaInspectionPrecaststress().setDefectIdent(elem.getQaInspectionPrecaststress().getDefectIdent());
        model.setRemarks(elem.getQaInspectionPrecaststress().getRemarks());
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
                    QaInspectionPrecaststressTO obj = new QaInspectionPrecaststressTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Precast Info
                    obj.setPrecastInfo(generateInspectionPrecastPojo(it));
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

    private InspectionPrecaststressPojo generateInspectionPrecastPojo(QaInspection it) {
        InspectionPrecaststressPojo elem = new InspectionPrecaststressPojo();
        elem.setLoggedInBy(it.getLoggedInBy());
        elem.setLoggedDate(DateSupport.formatDate(it.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        elem.setLoggedJobTitle(it.getLoggedInJobtitle());
        if (it.getQaInspectionPrecaststress() != null) {
            // WbsItems
            if (it.getQaInspectionPrecaststress().getWbsitemId() != null) {
                VwTestPlanItem wbsItemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getWbsitemId());
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
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getBiditemId());
            if (biditemId != null) {
                elem.setBiditemNo(biditemId.getItemNo());
                elem.setBiditemSpecNo(biditemId.getMatSpec());
                if (biditemId.getEstmQty() != null) {
                    elem.setBiditemProjQuantity(StringSupport.getString(biditemId.getEstmQty()) + " " + biditemId.getUnit());
                }
                elem.setBiditemDescription(biditemId.getItemDescript());
            }
            // SubBidItems
            if (it.getQaInspectionPrecaststress().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getSubBiditemId());
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
            GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getSupplierId()));
            if (supplier != null) {
                elem.setSupplier(supplier.getSupplier());
            }
            // Supplier Address
            GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getSupplierLocationId()));
            if (address != null) {
                elem.setSupplierLocation(address.getLocation());
            }
            elem.setCastDate(DateSupport.formatDate(it.getQaInspectionPrecaststress().getCastDate(), DateSupport.FORMAT_US));
            // Concrete Mix Design
            QaconcMixdesigns concMixId = qaconcMixdesignsService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getMixId()));
            if (concMixId != null) {
                elem.setMixIdNo(StringSupport.getString(concMixId.getMixDesign()));
                elem.setDesignStrength(StringSupport.getString(concMixId.getAvg28dayStrength()));
                if (concMixId.getDesignCompstrAge() != null) {
                    elem.setDesignAge(StringSupport.getString(concMixId.getDesignCompstrAge()) + " " + StringSupport.emptyOnNull(concMixId.getDesignCompstrAgeUnit()));
                }
                elem.setMaterialType(StringSupport.getString(concMixId.getMixType()));
                if (concMixId.getMaxAggSizeId() != null) {
                    elem.setMaxAggSize(concMixId.getMaxAggSizeId().getValue());
                }
                elem.setTotalCement(StringSupport.getString(concMixId.getTotalCementMat()));
            }
            // Category/Type
            QmCvlFieldData catType = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionPrecaststress().getCategoryId()));
            if (catType != null) {
                elem.setCategoryType(catType.getValue());
            }
            // Curing
            QmCvlFieldData curing = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionPrecaststress().getCuringId()));
            if (curing != null) {
                elem.setCuring(curing.getValue());
            }
            // Asset List
            List<QaInspectionAsset> assetList = qaInspectionAssetService.list(new ManageITBodyRequest(0, 0).filter("inspectionId.id", it.getId()));
            if (assetList != null && !assetList.isEmpty()) {
                elem.setNoConstAsset(StringSupport.getString(assetList.size()));
                String listByComma = assetList.stream().map(s -> s.getAssetNo()).collect(Collectors.joining(";"));
                if (StringSupport.isNotNullAndNotEmpty(listByComma)) {
                    elem.setConstAssetList(listByComma);
                }
            }
            elem.setAssetAddInfo(it.getQaInspectionPrecaststress().getAssetAddinfo());
            elem.setInspectedBy(it.getQaInspectionPrecaststress().getInspectedByName());
            elem.setInspectedDate(DateSupport.formatDate(it.getQaInspectionPrecaststress().getInspectedDate(), DateSupport.FORMAT_US));
            elem.setInspectedJobTitle(it.getQaInspectionPrecaststress().getInspectedByJobtitle());
            elem.setInspectedEntity(it.getQaInspectionPrecaststress().getInspectionEntity());
            elem.setEntityCityTown(it.getQaInspectionPrecaststress().getEntityLocation());
            GlobContact supervisor = globContactService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getInspectorSupervisorId()));
            if (supervisor != null) {
                elem.setSupervisor(supervisor.getFullName());
            }
            elem.setInspectedLocation(it.getQaInspectionPrecaststress().getInspectedLocation());
            elem.setGpsLatitude(it.getQaInspectionPrecaststress().getGpsLatitude());
            elem.setGpsLongitude(it.getQaInspectionPrecaststress().getGpsLongitude());
            elem.setGpsAltitude(it.getQaInspectionPrecaststress().getGpsAltitude());
            elem.setInspAddinfo(it.getQaInspectionPrecaststress().getInspAddinfo());
            // Mqca Insp Activities Map
            if (it.getQaInspectionPrecaststress().getMqcaInspActivities() != null && !it.getQaInspectionPrecaststress().getMqcaInspActivities().isEmpty()) {
                Map<String, Object> currentActMap = new HashMap<>(it.getQaInspectionPrecaststress().getMqcaInspActivities());
                if (currentActMap.containsKey("dcp_materials_cvl1") && StringSupport.isNotNullAndNotEmpty(currentActMap.get("dcp_materials_cvl1"))) {
                    QmCvlFieldData dcp_materials_cvl1 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentActMap.get("dcp_materials_cvl1")));
                    if (dcp_materials_cvl1 != null) {
                        currentActMap.put("dcp_materials_cvl1", dcp_materials_cvl1.getValue());
                    }
                }
                if (currentActMap.containsKey("dfs_workmanship_cvl1") && StringSupport.isNotNullAndNotEmpty(currentActMap.get("dfs_workmanship_cvl1"))) {
                    QmCvlFieldData dfs_workmanship_cvl1 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentActMap.get("dfs_workmanship_cvl1")));
                    if (dfs_workmanship_cvl1 != null) {
                        currentActMap.put("dfs_workmanship_cvl1", dfs_workmanship_cvl1.getValue());
                    }
                }
                elem.setMqcaInspActivities(currentActMap);
            } else {
                elem.setMqcaInspActivities(new HashMap<>());
            }
            // Defect Ident Map
            if (it.getQaInspectionPrecaststress().getDefectIdent() != null && !it.getQaInspectionPrecaststress().getDefectIdent().isEmpty()) {
                Map<String, Object> currentDefectMap = new HashMap<>(it.getQaInspectionPrecaststress().getDefectIdent());
                if (currentDefectMap.containsKey("cvl1") && StringSupport.isNotNullAndNotEmpty(currentDefectMap.get("cvl1"))) {
                    QmCvlFieldData cvl1 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentDefectMap.get("cvl1")));
                    if (cvl1 != null) {
                        currentDefectMap.put("cvl1", cvl1.getValue());
                    }
                }
                if (currentDefectMap.containsKey("cvl2") && StringSupport.isNotNullAndNotEmpty(currentDefectMap.get("cvl2"))) {
                    QmCvlFieldData cvl2 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentDefectMap.get("cvl2")));
                    if (cvl2 != null) {
                        currentDefectMap.put("cvl2", cvl2.getValue());
                    }
                }
                if (currentDefectMap.containsKey("cvl3") && StringSupport.isNotNullAndNotEmpty(currentDefectMap.get("cvl3"))) {
                    QmCvlFieldData cvl3 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentDefectMap.get("cvl3")));
                    if (cvl3 != null) {
                        currentDefectMap.put("cvl3", cvl3.getValue());
                    }
                }
                if (currentDefectMap.containsKey("cvl4") && StringSupport.isNotNullAndNotEmpty(currentDefectMap.get("cvl4"))) {
                    QmCvlFieldData cvl4 = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(currentDefectMap.get("cvl4")));
                    if (cvl4 != null) {
                        currentDefectMap.put("cvl4", cvl4.getValue());
                    }
                }
                elem.setDefectIdent(currentDefectMap);
            } else {
                elem.setDefectIdent(new HashMap<>());
            }

            elem.setCitytown(it.getQaInspectionPrecaststress().getCitytown());
            elem.setRemarks(it.getQaInspectionPrecaststress().getRemarks());
        }
        return elem;
    }

    @Override
    public QaInspection populateVersioning(QaInspection it) {
        // WbsItems
        if (it.getQaInspectionPrecaststress().getWbsitemId() != null) {
            VwTestPlanItem wbsItemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getWbsitemId());
            if (wbsItemId != null) {
                it.getQaInspectionPrecaststress().setWbsitemFullName(wbsItemId.getItemNoDescription());
            }
        }
        // BidItems
        VwTestPlanItem biditemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getBiditemId());
        if (biditemId != null) {
            it.getQaInspectionPrecaststress().setBiditemFullName(biditemId.getItemNoDescription());
        }
        // SubBidItems
        if (it.getQaInspectionPrecaststress().getSubBiditemId() != null) {
            VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(it.getQaInspectionPrecaststress().getSubBiditemId());
            if (subBiditemId != null) {
                it.getQaInspectionPrecaststress().setSubBiditemFullName(subBiditemId.getItemNo());
            }
        }
        // Supplier
        GlobSupplier supplier = globSupplierService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getSupplierId()));
        if (supplier != null) {
            it.getQaInspectionPrecaststress().setSupplierFullName(supplier.getSupplier());
        }
        // Supplier Address
        GlobSupplierAddress address = globSupplierAddressService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getSupplierLocationId()));
        if (address != null) {
            it.getQaInspectionPrecaststress().setSupplierLocationName(address.getLocation());
        }
        // Concrete Mix Design
        QaconcMixdesigns concMixId = qaconcMixdesignsService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getMixId()));
        if (concMixId != null) {
            it.getQaInspectionPrecaststress().setMixName(StringSupport.getString(concMixId.getMixDesign()));
        }
        // Category/Type
        QmCvlFieldData catType = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionPrecaststress().getCategoryId()));
        if (catType != null) {
            it.getQaInspectionPrecaststress().setCategoryName(catType.getValue());
        }
        // Curing
        QmCvlFieldData curing = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(it.getQaInspectionPrecaststress().getCuringId()));
        if (curing != null) {
            it.getQaInspectionPrecaststress().setCuringName(curing.getValue());
        }
        // Supervisor
        GlobContact supervisor = globContactService.findById(StringSupport.getString(it.getQaInspectionPrecaststress().getInspectorSupervisorId()));
        if (supervisor != null) {
            it.getQaInspectionPrecaststress().setInspectorSupervisorFullName(supervisor.getFullName());
        }
        return it;
    }

    @Override
    public InspectionReportMetadataPojo generateTrackITReportTitle(ManageITHeader header, QaInspection elem) {
        InspectionReportMetadataPojo response = new InspectionReportMetadataPojo();
        StringBuilder title = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            // WbsItems
            if (elem.getQaInspectionPrecaststress().getWbsitemId() != null) {
                VwTestPlanItem wbsitemId = vwTestPlanItemService.findById(elem.getQaInspectionPrecaststress().getWbsitemId());
                if (wbsitemId != null) {
                    title.append(wbsitemId.getItemNo()).append("-");
                }
            }
            // BidItems
            VwTestPlanItem biditemId = vwTestPlanItemService.findById(elem.getQaInspectionPrecaststress().getBiditemId());
            if (biditemId != null) {
                title.append(biditemId.getItemNo());
            }
            // SubBidItems
            if (elem.getQaInspectionPrecaststress().getSubBiditemId() != null) {
                VwTestPlanItem subBiditemId = vwTestPlanItemService.findById(elem.getQaInspectionPrecaststress().getSubBiditemId());
                if (subBiditemId != null) {
                    title.append("(").append(subBiditemId.getItemDescriptCom()).append(") - ");
                }
            }
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        } else {
            title.append(TEST_REPORT_ABBR).append(elem.getInspNo());
        }
        response.trackItReportName = title.toString();
        response.reportId = "qaInspPrecastPrestress";
        response.funcId = "fc_inspection_precast_prestress";
        response.folderFunct = "insp_folder_precast_prestress";
        return response;
    }

}
