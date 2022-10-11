/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignMasterDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobSieveSets;
import com.atser.tools.atserejb.model.GlobSieveSetsInfo;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesignMaster;
import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobClientService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobSieveSetsInfoService;
import com.atser.tools.atserejb.service.glob.GlobSieveSetsService;
import com.atser.tools.atserejb.service.glob.GlobSupplierAddressService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.document.write.csv.BuildCsv;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.enumerator.parser.eAspmMixDesign;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsTO;
import com.atser.tools.atserutil.objects.to.qa.ImportAspmMixDesignTO;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.AspmMixDesignPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@Stateless
public class QaaspmMixdesignMasterServiceImpl implements QaaspmMixdesignMasterService, IBaseEJBException {

    private final String rootFolderName = "Asphalt";

    @Inject
    private QaaspmMixdesignMasterDao dao;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private QaaspmMixdesignsService qaaspmMixdesignsService;

    @Inject
    private QaaspmMixdesignJmfMasterService qaaspmMixdesignJmfMasterService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobSupplierService globSupplierService;

    @Inject
    private GlobSupplierAddressService globSupplierAddressService;

    @Inject
    QmCvlFieldDataService qmCvlFieldDataService;

    @Inject
    GlobClientService globClient;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private WsDocTemplateService wsDocTemplateService;

    @Inject
    private GlobSieveSetsService globSieveSetsService;

    @Inject
    private GlobSieveSetsInfoService globSieveSetsInfoService;

    @Override
    public QaaspmMixdesignMaster findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignMaster findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesignMaster findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignMaster findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesignMaster elem = dao.findById(id);
            if (elem != null && elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
                elem.setFolderId(fId.toBigInteger());
                dao.update(elem);
            }
            return elem;
        }
    }

    private BigDecimal createFolderStruct(String userId, String clientId, QaaspmMixdesignMaster elem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger cId = new BigInteger(clientId);
        BigInteger owner = NumberSupport.getBigInteger(userId);

        // Create Root Folder
        BigDecimal rootFolderId = folderService.getFolderIdByClientBy(clientId, eManageITFolder.eFMixDesign);
        if (rootFolderId == null) {
            BigDecimal froot = folderService.getRootFolderIdByClient(cId);
            rootFolderId = folderService.createTrackITFolder(froot, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', eManageITFolder.eFMixDesign.getValue(), new BigInteger("2"), folderService.getNextFolderNumber(froot.toBigInteger(), "##0.0"));
        }

        // Create Asphalt Root Folder
        BigDecimal aspmRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName);
        if (aspmRootFolderId == null) {
            aspmRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }
        // Create Mix Folder
        String mixFolderName = elem.getMixdesignNo();
        BigDecimal mixFolderId = folderService.createTrackITFolder(aspmRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', mixFolderName, new BigInteger("2"));
        return mixFolderId;
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaaspmMixdesignMaster elem) {
        if (elem != null) {
            if (!dao.exists(elem.getClientId(), elem.getMixdesignNo())) {
                elem.setStatus("PENDING");
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.buildReferences();
                return dao.save(elem).getId();
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design already exists.");
            }
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaaspmMixdesignMaster elem) {
        if (elem != null) {
            QaaspmMixdesignMaster model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                model = populate(model, elem);
                dao.update(model);
                // Update Limits Calc
                QaaspmMixdesignJmfMaster mainJmf = qaaspmMixdesignJmfMasterService.getMainMixdesignJmfMaster(model.getId());
                if (mainJmf != null) {
                    qaaspmMixdesignJmfMasterService.updateLimits(header, mainJmf, model);
                }
            }

        }
    }

    private QaaspmMixdesignMaster populate(QaaspmMixdesignMaster model, QaaspmMixdesignMaster elem) {
        model.setMixdesignNo(elem.getMixdesignNo());
        model.setParentMixdesignNo(elem.getParentMixdesignNo());
        //model.setCatg(elem.getCatg());
        model.setSupplierId(elem.getSupplierId());
        model.setSupplierLocId(elem.getSupplierLocId());
        model.setMixdesignType(elem.getMixdesignType());
        model.setMixdesignDescription(elem.getMixdesignDescription());
        model.setMixdesignRemark(elem.getMixdesignRemark());
        model.setNmasId(elem.getNmasId());
        model.setGyrationsId(elem.getGyrationsId());
        model.setTrafficLevelId(elem.getTrafficLevelId());
        model.setPgBinderGradeId(elem.getPgBinderGradeId());
        model.setPgBinderAdditiveId(elem.getPgBinderAdditiveId());
        model.setAdditivePct(elem.getAdditivePct());
        model.setRecycleTypeId(elem.getRecycleTypeId());
        model.setWmaTechtypeId(elem.getWmaTechtypeId());
        model.setWmaTechnologyId(elem.getWmaTechnologyId());
        model.setTechPct(elem.getTechPct());
        model.setGsb(elem.getGsb());
        model.setBulkSgGmb(elem.getBulkSgGmb());
        model.setGmm(elem.getGmm());
        model.setDesac(elem.getDesac());
        model.setMinac(elem.getMinac());
        model.setMaxac(elem.getMaxac());
        model.setMinengac(elem.getMinengac());
        model.setMaxengac(elem.getMaxengac());
        model.setDesvtm(elem.getDesvtm());
        model.setMinvtm(elem.getMinvtm());
        model.setMaxvtm(elem.getMaxvtm());
        model.setMinengvtm(elem.getMinengvtm());
        model.setMaxengvtm(elem.getMaxengvtm());
        model.setDesvma(elem.getDesvma());
        model.setMinvma(elem.getMinvma());
        model.setMaxvma(elem.getMaxvma());
        model.setMinengvma(elem.getMinengvma());
        model.setMaxengvma(elem.getMaxengvma());
        model.setDesvfa(elem.getDesvfa());
        model.setMinvfa(elem.getMinvfa());
        model.setMaxvfa(elem.getMaxvfa());
        model.setMinengvfa(elem.getMinengvfa());
        model.setMaxengvfa(elem.getMaxengvfa());
        model.setGse(elem.getGse());
        model.setGasp(elem.getGasp());
        model.setPba(elem.getPba());
        model.setPbe(elem.getPbe());
        model.setDesdpbr(elem.getDesdpbr());
        model.setMindpbr(elem.getMindpbr());
        model.setMaxdpbr(elem.getMaxdpbr());
        model.setMinengdpbr(elem.getMinengdpbr());
        model.setMaxengdpbr(elem.getMaxengdpbr());
        model.setMincompfd(elem.getMincompfd());
        model.setMaxcompfd(elem.getMaxcompfd());
        model.setDescompfd(elem.getDescompfd());
        model.setBlows(elem.getBlows());
        model.setMinstability(elem.getMinstability());
        model.setMaxstability(elem.getMaxstability());
        model.setDesstability(elem.getDesstability());
        model.setMinflow(elem.getMinflow());
        model.setMaxflow(elem.getMaxflow());
        model.setDesflow(elem.getDesflow());
        model.setMinjointden(elem.getMinjointden());
        model.setMaxjointden(elem.getMaxjointden());
        model.setDesjointden(elem.getDesjointden());
        model.setMinmatden(elem.getMinmatden());
        model.setMaxmatden(elem.getMaxmatden());
        model.setDesmatden(elem.getDesmatden());
        model.setMinhveemstability(elem.getMinhveemstability());
        model.setMaxhveemstability(elem.getMaxhveemstability());
        model.setDeshveemstability(elem.getDeshveemstability());
        model.setMintsr(elem.getMintsr());
        model.setMaxtsr(elem.getMaxtsr());
        model.setDestsr(elem.getDestsr());
        model.setDescompfdpcf(elem.getDescompfdpcf());
        model.setDesmaxtheodens(elem.getDesmaxtheodens());
        model.setTolminac(elem.getTolminac());
        model.setTolmaxac(elem.getTolmaxac());
        model.setTolminvtm(elem.getTolminvtm());
        model.setTolmaxvtm(elem.getTolmaxvtm());
        model.setTolminvma(elem.getTolminvma());
        model.setTolmaxvma(elem.getTolmaxvma());
        model.setTolminvfa(elem.getTolminvfa());
        model.setTolmaxvfa(elem.getTolmaxvfa());
        model.setTolmindpbr(elem.getTolmindpbr());
        model.setTolmaxdpbr(elem.getTolmaxdpbr());
        model.setTolminengac(elem.getTolminengac());
        model.setTolmaxengac(elem.getTolmaxengac());
        model.setTolminengvtm(elem.getTolminengvtm());
        model.setTolmaxengvtm(elem.getTolmaxengvtm());
        model.setTolminengvma(elem.getTolminengvma());
        model.setTolmaxengvma(elem.getTolmaxengvma());
        model.setTolminengvfa(elem.getTolminengvfa());
        model.setTolmaxengvfa(elem.getTolmaxengvfa());
        model.setTolminengdpbr(elem.getTolminengdpbr());
        model.setTolmaxengdpbr(elem.getTolmaxengdpbr());
        model.setTolminhveemstability(elem.getTolminhveemstability());
        model.setTolmaxhveemstability(elem.getTolmaxhveemstability());
        model.setTolmincompfd(elem.getTolmincompfd());
        model.setTolmaxcompfd(elem.getTolmaxcompfd());
        model.setDessieve200(elem.getDessieve200());
        model.setMinsieve200(elem.getMinsieve200());
        model.setMaxsieve200(elem.getMaxsieve200());
        model.setTolminsieve200(elem.getTolminsieve200());
        model.setTolmaxsieve200(elem.getTolmaxsieve200());
        model.setCurrentJmfNo(elem.getCurrentJmfNo());
        model.setPressCorrFactor(elem.getPressCorrFactor());
        model.setPressIdSerialNo(elem.getPressIdSerialNo());
        model.setG1SpecGravAsp(elem.getG1SpecGravAsp());
        model.setAcCorrFactor(elem.getAcCorrFactor());
        model.setExpirationDate(elem.getExpirationDate());
        model.setMixStatus(elem.getMixStatus());
        model.setApprovedDate(elem.getApprovedDate());
        model.setLtmfDate(elem.getLtmfDate());
        model.setSetId(elem.getSetId());
        model.setItemId(elem.getItemId());
        model.setMatId(elem.getMatId());
        model.setRapPct(elem.getRapPct());

        if (elem.getQaaspmMixdesignMasterProjectList() != null && !elem.getQaaspmMixdesignMasterProjectList().isEmpty()) {
            model.setIsGlobal("N");
        } else {
            model.setIsGlobal("Y");
        }
        model.updateReferences(elem.getQaaspmMixdesignMasterProjectList());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaaspmMixdesignMaster> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<QaaspmMixdesignMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesignMaster> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaaspmMixdesignMaster model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
        qaaspmMixdesignsService.changeStatusByMasterId(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N', model.getId().toBigInteger());
    }

    @Override
    public void updateCurrentJMFNo(BigDecimal mixId, String jmfNo) {
        if (mixId != null && StringSupport.isNotNullAndNotEmpty(jmfNo)) {
            QaaspmMixdesignMaster model = findById(mixId);
            model.setCurrentJmfNo(jmfNo);
            dao.update(model);
        }
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        List vlist = dao.getRevisions(NumberSupport.getBigDecimal(id));
        if (vlist != null && vlist.size() > 0) {
            vlist.forEach(it -> {
                Object[] objResp = (Object[]) it;
                QaaspmMixdesignMaster model = (QaaspmMixdesignMaster) objResp[0];
                if (model.getSupplierId() != null) {
                    model.getSupplierId().getSupplier();
                }
                if (model.getSupplierLocId() != null) {
                    model.getSupplierLocId().getLocation();
                }
                if (model.getNmasId() != null) {
                    model.getNmasId().getId();
                }
                if (model.getGyrationsId() != null) {
                    model.getGyrationsId().getId();
                }
                if (model.getTrafficLevelId() != null) {
                    model.getTrafficLevelId().getId();
                }
                if (model.getPgBinderGradeId() != null) {
                    model.getPgBinderGradeId().getId();
                }
                if (model.getPgBinderAdditiveId() != null) {
                    model.getPgBinderAdditiveId().getId();
                }
                if (model.getRecycleTypeId() != null) {
                    model.getRecycleTypeId().getId();
                }
                if (model.getWmaTechnologyId() != null) {
                    model.getWmaTechnologyId().getId();
                }
                if (model.getWmaTechtypeId() != null) {
                    model.getWmaTechtypeId().getId();
                }
                if (model.getMixdesignType() != null) {
                    model.getMixdesignType().getId();
                }
            });
        }
        return vlist;
    }

    @Override
    public List<DataSelectWrapper> filterByProject(String projectId, String supplierId, String supplierLocId, String nmasId, String gyrationId, String mixTypeId) {
        List<DataSelectWrapper> list = new ArrayList<>();
        GlobProject project = globProjectService.findById(projectId);
        if (project != null) {
            Boolean isContractual = (StringSupport.isNotNullAndNotEmpty(project.getTypeProject()) && project.getTypeProject().equals("Contractual")) ? Boolean.TRUE : Boolean.FALSE;
            List<QaaspmMixdesignMaster> masterList = list(new ManageITBodyRequest(0, 0)
                    .filter("supplierLocId.id", supplierLocId)
                    .filter("mixdesignType.id", mixTypeId)
                    .filter("nmasId.id", nmasId)
                    .filter("gyrationsId.id", gyrationId)
                    .filter("active", "Y")
                    .filter("status", "PENDING"));

            masterList.forEach(it -> {
                if (it.getIsGlobal().equals("Y")) {
                    if (it.getMixStatus().equals("approvedmix") || (it.getMixStatus().equals("pending") && !isContractual)) {
                        list.add(new DataSelectWrapper(it.getId(), it.getMixdesignNo()));
                    }
                } else {
                    if (it.getQaaspmMixdesignMasterProjectList() == null || it.getQaaspmMixdesignMasterProjectList().isEmpty()) {
                        if (it.getMixStatus().equals("approvedmix") || (it.getMixStatus().equals("pending") && !isContractual)) {
                            list.add(new DataSelectWrapper(it.getId(), it.getMixdesignNo()));
                        }
                    } else {
                        if (it.getQaaspmMixdesignMasterProjectList().stream().filter(o -> (o.getProjectId().compareTo(project.getId().toBigInteger()) == 0)).findFirst().isPresent()) {
                            if (it.getMixStatus().equals("approvedmix") || (it.getMixStatus().equals("pending") && !isContractual)) {
                                list.add(new DataSelectWrapper(it.getId(), it.getMixdesignNo()));
                            }
                        }
                    }
                }
            });
        }
        return list;
    }

    @Override
    public void assignToProject(ManageITHeader header, String projectId, String mixId) {
        if (StringSupport.isNullOrEmpty(projectId) || StringSupport.isNullOrEmpty(mixId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaaspmMixdesignMaster elem = findById(mixId);
        if (elem != null) {
            if (!qaaspmMixdesignsService.exists(NumberSupport.getBigInteger(projectId), elem.getMixdesignNo())) {
                QaaspmMixdesigns persistMix = toQaaspmMixdesigns(projectId, elem);
                qaaspmMixdesignsService.save(header, persistMix);
                qaaspmMixdesignJmfMasterService.assignMainJMFToProject(header, NumberSupport.getBigDecimal(mixId), persistMix.getId());
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design already exists.");
            }
        }
    }

    private QaaspmMixdesigns toQaaspmMixdesigns(String projectId, QaaspmMixdesignMaster elem) {
        QaaspmMixdesigns model = new QaaspmMixdesigns();
        model.setProjectId(NumberSupport.getBigInteger(projectId));
        model.setMixdesign(elem.getMixdesignNo());
        model.setMixtype((elem.getMixdesignType() != null) ? elem.getMixdesignType().getValue() : null);
        model.setCatg(elem.getCatg());
        model.setMinvtm(elem.getMinvtm());
        model.setMaxvtm(elem.getMaxvtm());
        model.setDesvtm(elem.getDesvtm());
        model.setMinvma(elem.getMinvma());
        model.setMaxvma(elem.getMaxvma());
        model.setDesvma(elem.getDesvma());
        model.setMincompfd(elem.getMincompfd());
        model.setMaxcompfd(elem.getMaxcompfd());
        model.setDescompfd(elem.getDescompfd());
        model.setMinac(elem.getMinac());
        model.setMaxac(elem.getMaxac());
        model.setDesac(elem.getDesac());
        model.setBlows(elem.getBlows());
        model.setMinstability(elem.getMinstability());
        model.setMaxstability(elem.getMaxstability());
        model.setDesstability(elem.getDesstability());
        model.setMinflow(elem.getMinflow());
        model.setMaxflow(elem.getMaxflow());
        model.setDesflow(elem.getDesflow());
        model.setMinjointden(elem.getMinjointden());
        model.setMaxjointden(elem.getMaxjointden());
        model.setDesjointden(elem.getDesjointden());
        model.setMinmatden(elem.getMinmatden());
        model.setMaxmatden(elem.getMaxmatden());
        model.setDesmatden(elem.getDesmatden());
        model.setMinhveemstability(elem.getMinhveemstability());
        model.setMaxhveemstability(elem.getMaxhveemstability());
        model.setDeshveemstability(elem.getDeshveemstability());
        model.setMinvfa(elem.getMinvfa());
        model.setMaxvfa(elem.getMaxvfa());
        model.setDesvfa(elem.getDesvfa());
        model.setMintsr(elem.getMintsr());
        model.setMaxtsr(elem.getMaxtsr());
        model.setDestsr(elem.getDestsr());
        model.setDescompfdpcf(elem.getDescompfdpcf());
        model.setDesmaxtheodens(elem.getDesmaxtheodens());
        model.setTolminac(elem.getTolminac());
        model.setTolmaxac(elem.getTolmaxac());
        model.setTolminvtm(elem.getTolminvtm());
        model.setTolmaxvtm(elem.getTolmaxvtm());
        model.setTolminvma(elem.getTolminvma());
        model.setTolmaxvma(elem.getTolmaxvma());
        model.setTolminvfa(elem.getTolminvfa());
        model.setTolmaxvfa(elem.getTolmaxvfa());
        model.setTolmindpbr(elem.getTolmindpbr());
        model.setTolmaxdpbr(elem.getTolmaxdpbr());
        model.setTolminengac(elem.getTolminengac());
        model.setTolmaxengac(elem.getTolmaxengac());
        model.setTolminengvtm(elem.getTolminengvtm());
        model.setTolmaxengvtm(elem.getTolmaxengvtm());
        model.setTolminengvma(elem.getTolminengvma());
        model.setTolmaxengvma(elem.getTolmaxengvma());
        model.setTolminengvfa(elem.getTolminengvfa());
        model.setTolmaxengvfa(elem.getTolmaxengvfa());
        model.setTolminengdpbr(elem.getTolminengdpbr());
        model.setTolmaxengdpbr(elem.getTolmaxengdpbr());
        model.setTolminhveemstability(elem.getTolminhveemstability());
        model.setTolmaxhveemstability(elem.getTolmaxhveemstability());
        model.setTolmincompfd(elem.getTolmincompfd());
        model.setTolmaxcompfd(elem.getTolmaxcompfd());
        model.setDessieve200(elem.getDessieve200());
        model.setMinsieve200(elem.getMinsieve200());
        model.setMaxsieve200(elem.getMaxsieve200());
        model.setTolminsieve200(elem.getTolminsieve200());
        model.setTolmaxsieve200(elem.getTolmaxsieve200());
        model.setSetId(elem.getSetId());
        model.setItemId(elem.getItemId());
        model.setMatId(elem.getMatId());
        model.setGsb(elem.getGsb());
        model.setGmm(elem.getGmm());
        model.setGasp(elem.getGasp());
        model.setSupplier(elem.getSupplierId() != null ? elem.getSupplierId().getSupplier() : "");
        model.setCurrentJmfNo(elem.getCurrentJmfNo());
        model.setPressCorrFactor(elem.getPressCorrFactor());
        model.setPressIdSerialNo(elem.getPressIdSerialNo());
        model.setG1SpecGravAsp(elem.getG1SpecGravAsp());
        model.setAcCorrFactor(elem.getAcCorrFactor());
        model.setSupplierId(elem.getSupplierId());
        model.setSupplierLocId(elem.getSupplierLocId());
        model.setMixdesignDescription(elem.getMixdesignDescription());
        model.setParentMixdesignNo(elem.getParentMixdesignNo());
        model.setNmasId(elem.getNmasId());
        model.setGyrationsId(elem.getGyrationsId());
        model.setTrafficLevelId(elem.getTrafficLevelId());
        model.setPgBinderGradeId(elem.getPgBinderGradeId());
        model.setPgBinderAdditiveId(elem.getPgBinderAdditiveId());
        model.setAdditivePct(elem.getAdditivePct());
        model.setRecycleTypeId(elem.getRecycleTypeId());
        model.setWmaTechtypeId(elem.getWmaTechtypeId());
        model.setWmaTechnologyId(elem.getWmaTechnologyId());
        model.setTechPct(elem.getTechPct());
        model.setBulkSgGmb(elem.getBulkSgGmb());
        model.setMinengac(elem.getMinengac());
        model.setMaxengac(elem.getMaxengac());
        model.setMinengvtm(elem.getMinengvtm());
        model.setMaxengvtm(elem.getMaxengvtm());
        model.setMinengvma(elem.getMinengvma());
        model.setMaxengvma(elem.getMaxengvma());
        model.setMinengvfa(elem.getMinengvfa());
        model.setMaxengvfa(elem.getMaxengvfa());
        model.setGse(elem.getGse());
        model.setPba(elem.getPba());
        model.setPbe(elem.getPbe());
        model.setDesdpbr(elem.getDesdpbr());
        model.setMindpbr(elem.getMindpbr());
        model.setMaxdpbr(elem.getMaxdpbr());
        model.setMinengdpbr(elem.getMinengdpbr());
        model.setMaxengdpbr(elem.getMaxengdpbr());
        model.setLtmfDate(elem.getLtmfDate());
        model.setRapPct(elem.getRapPct());
        model.setMasterrefid(elem.getId().toBigInteger());
        return model;
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_aspmmixdesignmaster", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "qaAspmMixMaster": {
                    return generateMasterReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateMasterCsvReport(String docpathsegment, ManageITBodyRequest request) {
        try {
            List<QaaspmMixDesignsTO> pResult = generateReportData(request);
            String targetPath = docpathsegment + "AsphaltMasterMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + ".csv";
            BuildCsv csvFile = new BuildCsv(targetPath, QaaspmMixDesignsTO.class);
            return csvFile.writeCsv(pResult);
        } catch (IOException ex) {
            Logger.getLogger(QaaspmMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String generateMasterReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<QaaspmMixDesignsTO> pResult = generateReportData(request);

        String targetPath = docpathsegment + "AsphaltMasterMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaaspmMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaaspmMixDesignsTO> generateReportData(ManageITBodyRequest request) {
        List<QaaspmMixdesignMaster> filterList = list(request);
        List<QaaspmMixDesignsTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            QaaspmMixdesignJmfMaster mainJmf = qaaspmMixdesignJmfMasterService.getMainMixdesignJmfMaster(it.getId());
            QaaspmMixDesignsTO obj = it.generateQaaspmMixDesignsTO();
            if (mainJmf != null) {
                List<GradationPojo> gradationList = qaaspmMixdesignJmfMasterService.getGradationPojoList(it.getId(), mainJmf.getId(), it.getSetId().getId());
                obj.setMainJmf(mainJmf.generateJmfMasterPojo());
                obj.setGradationList(gradationList);
            }
            rList.add(obj);
        });
        return rList;
    }

    private Boolean isListNullOrEmpty(List... items) {
        for (List item : items) {
            return item == null || item.isEmpty();
        }
        return Boolean.FALSE;
    }

    @Override
    public String generateExcelTemplate(String paramClientId, String paramSetId, String tplbasePath, String docpathsegment) {
        WsDocTemplate rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(paramClientId), "fc_importaspmmixdesign", "excel");
        GlobClient client = globClient.findById(paramClientId);
        if (rp == null || client == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
        }
        List<GlobSieveSets> svList = globSieveSetsService.list(new ManageITBodyRequest(0, 0).filter("setId", paramSetId).sorted("ordering", "asc"));
        if (svList.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Sieve Set is Empty.");
        }
        String clientName = client.getCompanyName();
        eAspmMixDesign docTpl = eAspmMixDesign.valueOf(rp.getDocCode());
        List<GlobSupplier> supplierList = globSupplierService.filterByMaterialType(paramClientId, "asphalt");
        List<Object[]> locList = globSupplierService.getSupplierAndLocation(NumberSupport.getBigInteger(paramClientId), "asphalt");
        List<QmCvlFieldData> cvlNmas = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "NMAS").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlGyration = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "GYRATIONS").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlMixType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "MIX_DESIG").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlTrafficLevel = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "TRAFFIC_LEVEL").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlBinderGrade = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "BINDER_GRADE").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlBinderAdditive = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "ADDITIVE").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlRecycleType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "RECYCLE_OPTION").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlVmaTechType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "UNIQUE_TECH").filter("active", "Y").sorted("fieldOrder", "asc"));
        List<QmCvlFieldData> cvlVmaTechnology = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "UNIQUE_TECH_LOCATIONS").filter("active", "Y").sorted("fieldOrder", "asc"));

        if (isListNullOrEmpty(supplierList, cvlNmas, cvlGyration, cvlMixType, cvlTrafficLevel, cvlBinderGrade, cvlBinderAdditive, cvlRecycleType, cvlVmaTechType, cvlVmaTechnology)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing Information in the Database.");
        }
        String tplpath = tplbasePath + rp.getDocPath();
        String targetPath = docpathsegment + "AspmMixDesignTemplate_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + ".xlsx";
        try {
            AspmMixDesignPluginDirector director = new AspmMixDesignPluginDirector(new File(tplpath), docTpl);
            ExcelDocument doc = director.getpDoc();
            if (!doc.getListPages().isEmpty() && doc.getListPages().size() == 2) {
                Sheet catalog = doc.getListPages().get(1);
                if (catalog.getSheetName().equals("Catalog")) {
                    int startRow = 1;
                    // Write ProducedBy
                    startRow = 1;
                    for (GlobSupplier it : supplierList) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(2);
                        cell.setCellValue(it.getSupplier());
                    }

                    // Write Location
                    startRow = 1;
                    for (Object[] it : locList) {
                        Row row = catalog.getRow(startRow++);
                        Cell cellProd = row.getCell(4);
                        Cell cellLoc = row.getCell(5);
                        cellProd.setCellValue(StringSupport.emptyOnNull(it[0]));
                        cellLoc.setCellValue(StringSupport.emptyOnNull(it[1]));
                    }

                    // Write cvlNmas
                    startRow = 1;
                    for (QmCvlFieldData it : cvlNmas) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(7);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlGyration
                    startRow = 1;
                    for (QmCvlFieldData it : cvlGyration) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(9);
                        cell.setCellValue(it.getValue());
                    }

                    // Write MixDesignType
                    startRow = 1;
                    for (QmCvlFieldData it : cvlMixType) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(11);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlTrafficLevel
                    startRow = 1;
                    for (QmCvlFieldData it : cvlTrafficLevel) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(13);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlBinderGrade
                    startRow = 1;
                    for (QmCvlFieldData it : cvlBinderGrade) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(15);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlBinderAdditive
                    startRow = 1;
                    for (QmCvlFieldData it : cvlBinderAdditive) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(17);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlRecycleType
                    startRow = 1;
                    for (QmCvlFieldData it : cvlRecycleType) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(19);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlVmaTechType
                    startRow = 1;
                    for (QmCvlFieldData it : cvlVmaTechType) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(21);
                        cell.setCellValue(it.getValue());
                    }

                    // Write cvlVmaTechnology
                    startRow = 1;
                    for (QmCvlFieldData it : cvlVmaTechnology) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(23);
                        cell.setCellValue(it.getValue());
                    }
                } else {
                    throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
                }

                Sheet data = doc.getListPages().get(0);
                if (data.getSheetName().equals("Data")) {
                    int startCol = 40;
                    if (clientName != null && clientName.equals("massdot")) {
                        startCol = 41;
                    }
                    for (GlobSieveSets it : svList) {
                        Row row = data.getRow(3);
                        Cell cell = row.getCell(startCol++);
                        cell.setCellValue(it.getSieveId().getCommonName());
                    }

                    for (int i = startCol; i < 105; i++) {
                        data.setColumnHidden(i, true);
                    }
                } else {
                    throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
            }
            doc.buildOutputDocument(new File(targetPath));
            doc.write();
            return targetPath;
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | FileNotFoundException ex) {
            Logger.getLogger(QaaspmMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QaaspmMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportAspmMixDesignTO data) {
        if (data != null && data.getMixes() != null && !data.getMixes().isEmpty()) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(data.getSetId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            List<GenericStatusPojo> importErrors = new ArrayList<>();
            List<GlobSupplier> supplierList = globSupplierService.filterByMaterialType(header.getClientid(), "asphalt");
            List<Object[]> locList = globSupplierService.getSupplierAndLocation(NumberSupport.getBigInteger(header.getClientid()), "asphalt");
            List<QmCvlFieldData> cvlNmas = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "NMAS").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlGyration = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "GYRATIONS").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlMixType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "MIX_DESIG").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlTrafficLevel = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "TRAFFIC_LEVEL").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlBinderGrade = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "BINDER_GRADE").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlBinderAdditive = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "ADDITIVE").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlRecycleType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "RECYCLE_OPTION").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlVmaTechType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "UNIQUE_TECH").filter("active", "Y").sorted("fieldOrder", "asc"));
            List<QmCvlFieldData> cvlVmaTechnology = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "UNIQUE_TECH_LOCATIONS").filter("active", "Y").sorted("fieldOrder", "asc"));

            if (isListNullOrEmpty(supplierList, cvlNmas, cvlGyration, cvlMixType, cvlTrafficLevel, cvlBinderGrade, cvlBinderAdditive, cvlRecycleType, cvlVmaTechType, cvlVmaTechnology)) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing Information in the Database.");
            }

            data.getMixes().forEach(it -> {
                if (StringSupport.isNotNullAndNotEmpty(it.getSupplier(), it.getSupplierLoc(), it.getMixdesignType(), it.getNmasId(), it.getGyrationsId(), it.getTrafficLevelId(), it.getPgBinderGradeId(), it.getPgBinderAdditiveId(), it.getRecycleTypeId(), it.getWmaTechtypeId(), it.getWmaTechnologyId())) {
                    if (!dao.exists(NumberSupport.getBigInteger(header.getClientid()), it.getMixdesignNo())) {
                        // Match Supplier
                        Optional<GlobSupplier> matchSupplier = supplierList.stream().filter(p -> p.getSupplier().equals(it.getSupplier())).findFirst();
                        GlobSupplier fSupplier = matchSupplier.orElse(null);
                        // Match Supplier Loc
                        Optional<Object[]> matchLoc = locList.stream().filter(p -> p[1].equals(it.getSupplierLoc())).findFirst();
                        Object[] fPlantLocation = matchLoc.orElse(null);
                        // Match NMAS
                        Optional<QmCvlFieldData> matchNMAS = cvlNmas.stream().filter(p -> p.getValue().equals(it.getNmasId())).findFirst();
                        QmCvlFieldData fNMAS = matchNMAS.orElse(null);
                        // Match GYRATIONS
                        Optional<QmCvlFieldData> matchGyration = cvlGyration.stream().filter(p -> p.getValue().equals(it.getGyrationsId())).findFirst();
                        QmCvlFieldData fGyration = matchGyration.orElse(null);
                        // Match MIXDESG
                        Optional<QmCvlFieldData> matchMixDesig = cvlMixType.stream().filter(p -> p.getValue().equals(it.getMixdesignType())).findFirst();
                        QmCvlFieldData fMixDesig = matchMixDesig.orElse(null);
                        // Match TRAFFIC LEVEL
                        Optional<QmCvlFieldData> matchTrafficLevel = cvlTrafficLevel.stream().filter(p -> p.getValue().equals(it.getTrafficLevelId())).findFirst();
                        QmCvlFieldData fTrafficLevel = matchTrafficLevel.orElse(null);
                        // Match PG BINDER GRADE
                        Optional<QmCvlFieldData> matchPgBinderGrade = cvlBinderGrade.stream().filter(p -> p.getValue().equals(it.getPgBinderGradeId())).findFirst();
                        QmCvlFieldData fPgBinderGrade = matchPgBinderGrade.orElse(null);
                        // Match PG BINDER ADDIT
                        Optional<QmCvlFieldData> matchPgBinderAddt = cvlBinderAdditive.stream().filter(p -> p.getValue().equals(it.getPgBinderAdditiveId())).findFirst();
                        QmCvlFieldData fPgBinderAddt = matchPgBinderAddt.orElse(null);
                        // Match RECYCLE TYPE
                        Optional<QmCvlFieldData> matchRecyleType = cvlRecycleType.stream().filter(p -> p.getValue().equals(it.getRecycleTypeId())).findFirst();
                        QmCvlFieldData fRecyleType = matchRecyleType.orElse(null);
                        // Match WMA TECH TYPE
                        Optional<QmCvlFieldData> matchWmaTechType = cvlVmaTechType.stream().filter(p -> p.getValue().equals(it.getWmaTechtypeId())).findFirst();
                        QmCvlFieldData fWmaTechType = matchWmaTechType.orElse(null);
                        // Match WMA TECHNOLOGY
                        Optional<QmCvlFieldData> matchWmaTechnology = cvlVmaTechnology.stream().filter(p -> p.getValue().equals(it.getWmaTechnologyId())).findFirst();
                        QmCvlFieldData fWmaTechnology = matchWmaTechnology.orElse(null);

                        if (fSupplier != null && fPlantLocation != null && fNMAS != null && fGyration != null && fMixDesig != null && fTrafficLevel != null
                                && fPgBinderGrade != null && fPgBinderAddt != null && fRecyleType != null && fWmaTechType != null && fWmaTechnology != null) {
                            if (it.getDesac() != null && it.getDesvtm() != null && it.getDesvma() != null && it.getDesvfa() != null && it.getDesdpbr() != null) {
                                GlobSupplierAddress dbSupAddress = globSupplierAddressService.findById(fPlantLocation[2].toString());
                                GlobSieveSetsInfo setId = globSieveSetsInfoService.findById(data.getSetId());
                                QaaspmMixdesignMaster elem = toQaaspmMixdesignMaster(it, NumberSupport.getBigInteger(header.getClientid()), setId, fSupplier, dbSupAddress,
                                        fNMAS, fGyration, fMixDesig, fTrafficLevel, fPgBinderGrade, fPgBinderAddt, fRecyleType, fWmaTechType, fWmaTechnology);
                                elem.setStatus("PENDING");
                                elem.setCreatedBy(header.getUser());
                                elem.setCreatedByIp(header.getModIp());
                                elem.setLastModIp(header.getModIp());
                                elem.setLastModBy(header.getUser());
                                dao.save(elem);
                                qaaspmMixdesignJmfMasterService.saveFromTo(header, it, elem);
                            } else {
                                it.setStatus("ERROR: JMF Targets not Found !");
                                importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "JMF Targets not Found !"));
                            }
                        } else {
                            it.setStatus("ERROR: Basic Information not Found !");
                            importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "Basic Information not Found !"));
                        }
                    } else {
                        it.setStatus("ERROR: This Mix Design already exists !");
                        importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "This Mix Design already exists !"));
                    }
                } else {
                    it.setStatus("ERROR: Basic Information Empty or Null !");
                    importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "Basic Information Empty or Null !"));
                }
            });
            return importErrors;
        }
        return null;
    }

    private QaaspmMixdesignMaster toQaaspmMixdesignMaster(AspmMixDesignDef elem, BigInteger clientId, GlobSieveSetsInfo setId, GlobSupplier supplierId, GlobSupplierAddress supplierLocId, QmCvlFieldData nmasId,
            QmCvlFieldData gyrationId, QmCvlFieldData mixDesigId, QmCvlFieldData trafficLevelId, QmCvlFieldData pgBinderGradeId, QmCvlFieldData pgBinderAddtId, QmCvlFieldData recycleTypeId,
            QmCvlFieldData wmaTechTypeId, QmCvlFieldData wmaTechnologyId) {
        QaaspmMixdesignMaster model = new QaaspmMixdesignMaster();
        model.setMixdesignNo(elem.getMixdesignNo());
        model.setClientId(clientId);
        model.setSupplierId(supplierId);
        model.setSupplierLocId(supplierLocId);
        model.setMixdesignType(mixDesigId);
        model.setNmasId(nmasId);
        model.setGyrationsId(gyrationId);
        model.setTrafficLevelId(trafficLevelId);
        model.setPgBinderGradeId(pgBinderGradeId);
        model.setPgBinderAdditiveId(pgBinderAddtId);
        model.setAdditivePct(NumberSupport.getBigDecimal(elem.getAdditivePct()));
        model.setRecycleTypeId(recycleTypeId);
        model.setRapPct(NumberSupport.getBigDecimal(elem.getRapPct()));
        model.setWmaTechtypeId(wmaTechTypeId);
        model.setWmaTechnologyId(wmaTechnologyId);
        model.setTechPct(NumberSupport.getBigDecimal(elem.getTechPct()));
        model.setGsb(NumberSupport.getBigDecimal(elem.getGsb()));
        model.setBulkSgGmb(NumberSupport.getBigDecimal(elem.getBulkSgGmb()));
        model.setGmm(NumberSupport.getBigDecimal(elem.getGmm()));
        model.setGse(NumberSupport.getBigDecimal(elem.getGse()));
        model.setGasp(NumberSupport.getBigDecimal(elem.getGasp()));
        model.setPba(NumberSupport.getBigDecimal(elem.getPba()));
        model.setPbe(NumberSupport.getBigDecimal(elem.getPbe()));
        model.setMincompfd(NumberSupport.getBigDecimal(elem.getMincompfd()));
        model.setMaxcompfd(NumberSupport.getBigDecimal(elem.getMaxcompfd()));
        model.setDescompfd(NumberSupport.getBigDecimal(elem.getDescompfd()));
        model.setBlows(NumberSupport.getBigDecimal(elem.getBlows()));
        model.setMinstability(NumberSupport.getBigDecimal(elem.getMinstability()));
        model.setMaxstability(NumberSupport.getBigDecimal(elem.getMaxstability()));
        model.setDesstability(NumberSupport.getBigDecimal(elem.getDesstability()));
        model.setMinflow(NumberSupport.getBigDecimal(elem.getMinflow()));
        model.setMaxflow(NumberSupport.getBigDecimal(elem.getMaxflow()));
        model.setDesflow(NumberSupport.getBigDecimal(elem.getDesflow()));
        model.setMinjointden(NumberSupport.getBigDecimal(elem.getMinjointden()));
        model.setMaxjointden(NumberSupport.getBigDecimal(elem.getMaxjointden()));
        model.setDesjointden(NumberSupport.getBigDecimal(elem.getDesjointden()));
        model.setMinmatden(NumberSupport.getBigDecimal(elem.getMinmatden()));
        model.setMaxmatden(NumberSupport.getBigDecimal(elem.getMaxmatden()));
        model.setDesmatden(NumberSupport.getBigDecimal(elem.getDesmatden()));
        model.setMinhveemstability(NumberSupport.getBigDecimal(elem.getMinhveemstability()));
        model.setMaxhveemstability(NumberSupport.getBigDecimal(elem.getMaxhveemstability()));
        model.setDeshveemstability(NumberSupport.getBigDecimal(elem.getDeshveemstability()));
        model.setMintsr(NumberSupport.getBigDecimal(elem.getMintsr()));
        model.setMaxtsr(NumberSupport.getBigDecimal(elem.getMaxtsr()));
        model.setDestsr(NumberSupport.getBigDecimal(elem.getDestsr()));
        model.setDescompfdpcf(NumberSupport.getBigDecimal(elem.getDescompfdpcf()));
        model.setDesmaxtheodens(NumberSupport.getBigDecimal(elem.getDesmaxtheodens()));
        model.setTolminac(NumberSupport.getBigDecimal(elem.getTolminac()));
        model.setTolmaxac(NumberSupport.getBigDecimal(elem.getTolmaxac()));
        model.setTolminvtm(NumberSupport.getBigDecimal(elem.getTolminvtm()));
        model.setTolmaxvtm(NumberSupport.getBigDecimal(elem.getTolmaxvtm()));
        model.setTolminvma(NumberSupport.getBigDecimal(elem.getTolminvma()));
        model.setTolmaxvma(NumberSupport.getBigDecimal(elem.getTolmaxvma()));
        model.setTolminvfa(NumberSupport.getBigDecimal(elem.getTolminvfa()));
        model.setTolmaxvfa(NumberSupport.getBigDecimal(elem.getTolmaxvfa()));
        model.setTolmindpbr(NumberSupport.getBigDecimal(elem.getTolmindpbr()));
        model.setTolmaxdpbr(NumberSupport.getBigDecimal(elem.getTolmaxdpbr()));
        model.setTolminengac(NumberSupport.getBigDecimal(elem.getTolminengac()));
        model.setTolmaxengac(NumberSupport.getBigDecimal(elem.getTolmaxengac()));
        model.setTolminengvtm(NumberSupport.getBigDecimal(elem.getTolminengvtm()));
        model.setTolmaxengvtm(NumberSupport.getBigDecimal(elem.getTolmaxengvtm()));
        model.setTolminengvma(NumberSupport.getBigDecimal(elem.getTolminengvma()));
        model.setTolmaxengvma(NumberSupport.getBigDecimal(elem.getTolmaxengvma()));
        model.setTolminengvfa(NumberSupport.getBigDecimal(elem.getTolminengvfa()));
        model.setTolmaxengvfa(NumberSupport.getBigDecimal(elem.getTolmaxengvfa()));
        model.setTolminengdpbr(NumberSupport.getBigDecimal(elem.getTolminengdpbr()));
        model.setTolmaxengdpbr(NumberSupport.getBigDecimal(elem.getTolmaxengdpbr()));
        model.setTolminhveemstability(NumberSupport.getBigDecimal(elem.getTolminhveemstability()));
        model.setTolmaxhveemstability(NumberSupport.getBigDecimal(elem.getTolmaxhveemstability()));
        model.setTolmincompfd(NumberSupport.getBigDecimal(elem.getTolmincompfd()));
        model.setTolmaxcompfd(NumberSupport.getBigDecimal(elem.getTolmaxcompfd()));
        model.setDessieve200(NumberSupport.getBigDecimal(elem.getDessieve200()));
        model.setMinsieve200(NumberSupport.getBigDecimal(elem.getMinsieve200()));
        model.setMaxsieve200(NumberSupport.getBigDecimal(elem.getMaxsieve200()));
        model.setTolminsieve200(NumberSupport.getBigDecimal(elem.getTolminsieve200()));
        model.setTolmaxsieve200(NumberSupport.getBigDecimal(elem.getTolmaxsieve200()));
        model.setCurrentJmfNo(elem.getCurrentJmfNo());
        model.setPressCorrFactor(elem.getPressCorrFactor());
        model.setPressIdSerialNo(elem.getPressIdSerialNo());
        model.setG1SpecGravAsp(NumberSupport.getBigDecimal(elem.getG1SpecGravAsp()));
        model.setAcCorrFactor(NumberSupport.getBigDecimal(elem.getAcCorrFactor()));
        model.setMixStatus("approvedmix");
        model.setLtmfDate(elem.getLtmfDate());
        model.setExpirationDate(elem.getExpirationDate());
        model.setSetId(setId);
        model.setIsGlobal("Y");
        return model;
    }

    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            dao.delete(id);
        }
    }

    @Override
    public DataGridWrapper<QaaspmMixdesignMaster> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }
}
