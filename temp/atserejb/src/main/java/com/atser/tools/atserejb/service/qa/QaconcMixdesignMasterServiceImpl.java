/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaconcMixdesignMasterDao;
import com.atser.tools.atserejb.dao.qa.QaconcMixdesignMasterprojectDao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.model.QaconcMixdesignMaster;
import com.atser.tools.atserejb.model.QaconcMixdesignMasterproject;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.model.QmCvlField;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobClientService;
import com.atser.tools.atserejb.service.glob.GlobDataGatewayLogService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobSupplierAddressService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridExcelSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.enumerator.parser.eConcMixDesign;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixdesignsTO;
import com.atser.tools.atserutil.objects.to.qa.ImportConcMixDesignTO;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.ConcMixDesignPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@Stateless
public class QaconcMixdesignMasterServiceImpl implements QaconcMixdesignMasterService, IBaseEJBException {

    private final String rootFolderName = "Concrete";

    @Inject
    private QaconcMixdesignMasterDao dao;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobSupplierService globSupplierService;

    @Inject
    private GlobSupplierAddressService globSupplierAddressService;

    @Inject
    QmCvlFieldDataService qmCvlFieldDataService;

    @Inject
    GlobClientService globClientService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GlobDataGatewayLogService globDataGatewayLogService;

    @Inject
    private QaconcMixdesignMasterprojectDao qaconcMixdesignMasterprojectDao;

    @Override
    public QaconcMixdesignMaster findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcMixdesignMaster findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaconcMixdesignMaster findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcMixdesignMaster findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaconcMixdesignMaster elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
                elem.setFolderId(fId.toBigInteger());
                dao.update(elem);
            }
            return elem;
        }
    }

    private BigDecimal createFolderStruct(String userId, String clientId, QaconcMixdesignMaster elem) {
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

        // Create Concrete Root Folder
        BigDecimal ConcreteRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName);
        if (ConcreteRootFolderId == null) {
            ConcreteRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }
        // Create Mix Folder
        String mixFolderName = elem.getMixdesignNo();
        BigDecimal mixFolderId = folderService.createTrackITFolder(ConcreteRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', mixFolderName, new BigInteger("2"));
        return mixFolderId;
    }

    @Override
    public void save(ManageITHeader header, QaconcMixdesignMaster elem) {
        if (elem != null) {
            if (!dao.exists(elem.getClientId(), elem.getMixdesignNo())) {
                elem.setStatus("PENDING");
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.buildReferences();
                dao.save(elem);
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design already exists.");
            }
        }
    }

    @Override
    public void update(ManageITHeader header, QaconcMixdesignMaster elem) {
        if (elem != null) {
            QaconcMixdesignMaster model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }

        }
    }

    private QaconcMixdesignMaster populate(QaconcMixdesignMaster model, QaconcMixdesignMaster elem) {
        model.setMixdesignNo(elem.getMixdesignNo());
        model.setSupplierId(elem.getSupplierId());
        model.setSupplierLocId(elem.getSupplierLocId());
        model.setMixdesignType(elem.getMixdesignType());
        model.setMixdesignDescription(elem.getMixdesignDescription());
        model.setMixdesignRemark(elem.getMixdesignRemark());
        model.setMaxAggSizeId(elem.getMaxAggSizeId());
        model.setDesignCompstr(elem.getDesignCompstr());
        model.setDesignCompstrAge(elem.getDesignCompstrAge());
        model.setDesignCompstrAgeUnit(elem.getDesignCompstrAgeUnit());
        model.setDesignSlump(elem.getDesignSlump());
        model.setDesignSlumpFlowScc(elem.getDesignSlumpFlowScc());
        model.setDesignAirContent(elem.getDesignAirContent());
        model.setTotalCoarseAgg(NumberSupport.calcBigDecimal(elem.getCoarseAgg1(), elem.getCoarseAgg2(), "+", elem.getTotalCoarseAgg()));
        model.setCoarseAgg1(NumberSupport.getZeroWhenNull(elem.getCoarseAgg1()));
        model.setCoarseAgg2(NumberSupport.getZeroWhenNull(elem.getCoarseAgg2()));
        model.setTotalFineAgg(NumberSupport.calcBigDecimal(elem.getFineAgg1(), elem.getFineAgg2(), "+", elem.getTotalFineAgg()));
        model.setFineAgg1(NumberSupport.getZeroWhenNull(elem.getFineAgg1()));
        model.setFineAgg2(NumberSupport.getZeroWhenNull(elem.getFineAgg2()));
        model.setCement(elem.getCement());
        model.setFlyAsh(elem.getFlyAsh());
        model.setSlag(elem.getSlag());
        model.setSilicaFume(elem.getSilicaFume());
        model.setTotalCementMat(elem.getTotalCementMat());
        model.setWater(elem.getWater());
        model.setAdmixtureQty1(elem.getAdmixtureQty1());
        model.setAdmixtureType1(elem.getAdmixtureType1());
        model.setAdmixtureQty2(elem.getAdmixtureQty2());
        model.setAdmixtureType2(elem.getAdmixtureType2());
        model.setAdmixtureQty3(elem.getAdmixtureQty3());
        model.setAdmixtureType3(elem.getAdmixtureType3());
        model.setAdmixtureQty4(elem.getAdmixtureQty4());
        model.setAdmixtureType4(elem.getAdmixtureType4());
        model.setAdmixtureQty5(elem.getAdmixtureQty5());
        model.setAdmixtureType5(elem.getAdmixtureType5());
        model.setAdmixtureQty6(elem.getAdmixtureQty6());
        model.setAdmixtureType6(elem.getAdmixtureType6());
        model.setAdmixtureQty7(elem.getAdmixtureQty7());
        model.setAdmixtureType7(elem.getAdmixtureType7());
        model.setAdmixtureQty8(elem.getAdmixtureQty8());
        model.setAdmixtureType8(elem.getAdmixtureType8());
        model.setWaterCementRatio(elem.getWaterCementRatio());
        model.setWaterCementMax(elem.getWaterCementMax());
        model.setTheoreticalAirContent(elem.getTheoreticalAirContent());
        model.setVolumenPaste(elem.getVolumenPaste());
        model.setSpecLimitSlumpMin(elem.getSpecLimitSlumpMin());
        model.setSpecLimitSlumpMax(elem.getSpecLimitSlumpMax());
        model.setEngLimitSlumpMin(elem.getEngLimitSlumpMin());
        model.setEngLimitSlumpMax(elem.getEngLimitSlumpMax());
        model.setSpecLimitAirContentMin(elem.getSpecLimitAirContentMin());
        model.setSpecLimitAirContentMax(elem.getSpecLimitAirContentMax());
        model.setEngLimitAirContentMin(elem.getEngLimitAirContentMin());
        model.setEngLimitAirContentMax(elem.getEngLimitAirContentMax());
        model.setSpecLimitCompstrMin(elem.getSpecLimitCompstrMin());
        model.setSpecLimitCompstrMax(elem.getSpecLimitCompstrMax());
        model.setEngLimitCompstrMin(elem.getEngLimitCompstrMin());
        model.setEngLimitCompstrMax(elem.getEngLimitCompstrMax());
        model.setSpecLimitSlumpFlowsccMin(elem.getSpecLimitSlumpFlowsccMin());
        model.setSpecLimitSlumpFlowsccMax(elem.getSpecLimitSlumpFlowsccMax());
        model.setEngLimitSlumpFlowsccMin(elem.getEngLimitSlumpFlowsccMin());
        model.setEngLimitSlumpFlowsccMax(elem.getEngLimitSlumpFlowsccMax());
        model.setTrialOverdesignCompstrMin(elem.getTrialOverdesignCompstrMin());
        model.setTrialOverdesignCompstrMax(elem.getTrialOverdesignCompstrMax());
        model.setDesignTensileStr(elem.getDesignTensileStr());
        model.setDesignTensileStrAge(elem.getDesignTensileStrAge());
        model.setDesignTensileStrAgeUnit(elem.getDesignTensileStrAgeUnit());
        model.setDesignFlexStr(elem.getDesignFlexStr());
        model.setDesignFlexStrAge(elem.getDesignFlexStrAge());
        model.setDesignFlexStrAgeUnit(elem.getDesignFlexStrAgeUnit());
        model.setSpecLimitTensileStrMin(elem.getSpecLimitTensileStrMin());
        model.setSpecLimitTensileStrMax(elem.getSpecLimitTensileStrMax());
        model.setEngLimitTensileStrMin(elem.getEngLimitTensileStrMin());
        model.setEngLimitTensileStrMax(elem.getEngLimitTensileStrMax());
        model.setSpecLimitFlexStrMin(elem.getSpecLimitFlexStrMin());
        model.setSpecLimitFlexStrMax(elem.getSpecLimitFlexStrMax());
        model.setEngLimitFlexStrMin(elem.getEngLimitFlexStrMin());
        model.setEngLimitFlexStrMax(elem.getEngLimitFlexStrMax());
        model.setConcreteClass(elem.getConcreteClass());
        model.setSpecSlumpSuspension(elem.getSpecSlumpSuspension());
        model.setSpecSlumpAction(elem.getSpecSlumpAction());
        model.setSpecAircontentSuspension(elem.getSpecAircontentSuspension());
        model.setSpecAircontentAction(elem.getSpecAircontentAction());
        model.setReqtk(elem.getReqtk());
        model.setSpecFlexSuspension(elem.getSpecFlexSuspension());
        model.setSpecFlexAction(elem.getSpecFlexAction());
        model.setSpecTkSuspension(elem.getSpecTkSuspension());
        model.setSpecTkAction(elem.getSpecTkAction());
        model.setSpecConcTempMin(elem.getSpecConcTempMin());
        model.setSpecConcTempMax(elem.getSpecConcTempMax());
        model.setSpecResidualStr1(elem.getSpecResidualStr1());
        model.setSpecResidualStr2(elem.getSpecResidualStr2());
        model.setSpecResidualStr3(elem.getSpecResidualStr3());
        model.setSpecResidualStrPeak(elem.getSpecResidualStrPeak());
        model.setBoiledabsorption(elem.getBoiledabsorption());
        model.setExpirationDate(elem.getExpirationDate());
        model.setMixStatus(elem.getMixStatus());
        if (elem.getQaconcMixdesignMasterProjectList() != null && !elem.getQaconcMixdesignMasterProjectList().isEmpty()) {
            model.setIsGlobal("N");
        } else {
            model.setIsGlobal("Y");
        }
        model.updateReferences(elem.getQaconcMixdesignMasterProjectList());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaconcMixdesignMaster> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QaconcMixdesignMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaconcMixdesignMaster> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        List vlist = dao.getRevisions(NumberSupport.getBigDecimal(id));
        if (vlist != null && vlist.size() > 0) {
            vlist.forEach(it -> {
                Object[] objResp = (Object[]) it;
                QaconcMixdesignMaster model = (QaconcMixdesignMaster) objResp[0];
                if (model.getSupplierId() != null) {
                    model.getSupplierId().getSupplier();
                }
                if (model.getMaxAggSizeId() != null) {
                    model.getMaxAggSizeId().getId();
                }
                if (model.getMixdesignType() != null) {
                    model.getMixdesignType().getId();
                }
            });
        }
        return vlist;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaconcMixdesignMaster model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
        qaconcMixdesignsService.changeStatusByMasterId(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N', model.getId().toBigInteger());
    }

    @Override
    public List<DataSelectWrapper> filterByProject(String projectId, String supplierId, String supplierLocId) {
        List<DataSelectWrapper> list = new ArrayList<>();
        GlobProject project = globProjectService.findById(projectId);
        if (project != null) {
            Boolean isContractual = (StringSupport.isNotNullAndNotEmpty(project.getTypeProject()) && project.getTypeProject().equals("Contractual")) ? Boolean.TRUE : Boolean.FALSE;
            List<QaconcMixdesignMaster> masterList = list(new ManageITBodyRequest(0, 0)
                    .filter("supplierLocId.id", supplierLocId)
                    .filter("active", "Y")
                    .filter("status", "PENDING"));

            masterList.forEach(it -> {
                if (it.getIsGlobal().equals("Y")) {
                    if (it.getMixStatus().equals("approvedmix") || (it.getMixStatus().equals("pending") && !isContractual)) {
                        list.add(new DataSelectWrapper(it.getId(), it.getMixdesignNo()));
                    }
                } else {
                    if (it.getQaconcMixdesignMasterProjectList() == null || it.getQaconcMixdesignMasterProjectList().isEmpty()) {
                        if (it.getMixStatus().equals("approvedmix") || (it.getMixStatus().equals("pending") && !isContractual)) {
                            list.add(new DataSelectWrapper(it.getId(), it.getMixdesignNo()));
                        }
                    } else {
                        if (it.getQaconcMixdesignMasterProjectList().stream().filter(o -> (o.getProjectId().compareTo(project.getId().toBigInteger()) == 0)).findFirst().isPresent()) {
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
        QaconcMixdesignMaster elem = findById(mixId);
        if (elem != null) {
            if (!qaconcMixdesignsService.exists(NumberSupport.getBigInteger(projectId), elem.getMixdesignNo())) {
                qaconcMixdesignsService.save(header, toQaconcMixdesigns(projectId, elem));
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design already exists.");
            }
        }
    }

    private QaconcMixdesigns toQaconcMixdesigns(QaconcMixdesignMaster elem) {
        return toQaconcMixdesigns(null, elem);
    }

    private QaconcMixdesigns toQaconcMixdesigns(String projectId, QaconcMixdesignMaster elem) {
        QaconcMixdesigns model = new QaconcMixdesigns();
        if (StringSupport.isNotNullAndNotEmpty(projectId)) {
            model.setProjectId(NumberSupport.getBigInteger(projectId));
        }
        model.setMixDesign(elem.getMixdesignNo());
        model.setSupplierId(elem.getSupplierId());
        model.setSupplierLocId(elem.getSupplierLocId());
        model.setMixType((elem.getMixdesignType() != null) ? elem.getMixdesignType().getValue() : null);
        model.setMixdesignDescription(elem.getMixdesignDescription());
        model.setRemarks(elem.getMixdesignRemark());
        model.setMaxAggSizeId(elem.getMaxAggSizeId());
        model.setAvg28dayStrength(elem.getDesignCompstr());
        model.setCompstr28day(elem.getDesignCompstr());
        model.setDesignCompstrAge(elem.getDesignCompstrAge());
        model.setDesignCompstrAgeUnit(elem.getDesignCompstrAgeUnit());
        model.setSpecSlumpDesign(elem.getDesignSlump());
        model.setDesignSlumpFlowScc(elem.getDesignSlumpFlowScc());
        model.setSpecAircontDesign(elem.getDesignAirContent());
        model.setAggSource((elem.getTotalCoarseAgg() != null) ? elem.getTotalCoarseAgg().toString() : null);
        model.setAggSource1((elem.getCoarseAgg1() != null) ? elem.getCoarseAgg1().toString() : null);
        model.setAggSource2((elem.getCoarseAgg2() != null) ? elem.getCoarseAgg2().toString() : null);
        model.setSandSource((elem.getTotalFineAgg() != null) ? elem.getTotalFineAgg().toString() : null);
        model.setSandSource1((elem.getFineAgg1() != null) ? elem.getFineAgg1().toString() : null);
        model.setSandSource2((elem.getFineAgg2() != null) ? elem.getFineAgg2().toString() : null);
        model.setCementAmount(elem.getCement());
        model.setFlyAsh((elem.getFlyAsh() != null) ? elem.getFlyAsh().toString() : null);
        model.setSlag(elem.getSlag());
        model.setSilicaFume(elem.getSilicaFume());
        model.setTotalCementMat(elem.getTotalCementMat());
        model.setSpecWater((elem.getWater() != null) ? elem.getWater().toString() : null);
        model.setAdmixtureQty1((elem.getAdmixtureQty1()) != null ? elem.getAdmixtureQty1().toString() : null);
        model.setAdmixtureType1(elem.getAdmixtureType1());
        model.setAdmixtureQty2((elem.getAdmixtureQty2()) != null ? elem.getAdmixtureQty2().toString() : null);
        model.setAdmixtureType2(elem.getAdmixtureType2());
        model.setAdmixtureQty3((elem.getAdmixtureQty3()) != null ? elem.getAdmixtureQty3().toString() : null);
        model.setAdmixtureType3(elem.getAdmixtureType3());
        model.setAdmixtureQty4((elem.getAdmixtureQty4()) != null ? elem.getAdmixtureQty4().toString() : null);
        model.setAdmixtureType4(elem.getAdmixtureType4());
        model.setAdmixtureQty5((elem.getAdmixtureQty5()) != null ? elem.getAdmixtureQty5().toString() : null);
        model.setAdmixtureType5(elem.getAdmixtureType5());
        model.setAdmixtureQty6((elem.getAdmixtureQty6()) != null ? elem.getAdmixtureQty6().toString() : null);
        model.setAdmixtureType6(elem.getAdmixtureType6());
        model.setAdmixtureQty7((elem.getAdmixtureQty7()) != null ? elem.getAdmixtureQty7().toString() : null);
        model.setAdmixtureType7(elem.getAdmixtureType7());
        model.setAdmixtureQty8((elem.getAdmixtureQty8()) != null ? elem.getAdmixtureQty8().toString() : null);
        model.setAdmixtureType8(elem.getAdmixtureType8());
        model.setWaterCementRatio(elem.getWaterCementRatio());
        model.setMaxWaterCmt((elem.getWaterCementMax() != null) ? elem.getWaterCementMax().toString() : null);
        model.setTheoreticalAirContent(elem.getTheoreticalAirContent());
        model.setVolumenPaste(elem.getVolumenPaste());
        model.setSpecSlumpMin(elem.getSpecLimitSlumpMin());
        model.setSpecSlumpMax(elem.getSpecLimitSlumpMax());
        model.setEngLimitSlumpMin(elem.getEngLimitSlumpMin());
        model.setEngLimitSlumpMax(elem.getEngLimitSlumpMax());
        model.setSpecAircontMin(elem.getSpecLimitAirContentMin());
        model.setSpecAircontMax(elem.getSpecLimitAirContentMax());
        model.setEngLimitAirContentMin(elem.getEngLimitAirContentMin());
        model.setEngLimitAirContentMax(elem.getEngLimitAirContentMax());
        model.setSpecLimitCompstrMin(elem.getSpecLimitCompstrMin());
        model.setSpecLimitCompstrMax(elem.getSpecLimitCompstrMax());
        model.setEngLimitCompstrMin(elem.getEngLimitCompstrMin());
        model.setEngLimitCompstrMax(elem.getEngLimitCompstrMax());
        model.setSpecLimitSlumpFlowsccMin(elem.getSpecLimitSlumpFlowsccMin());
        model.setSpecLimitSlumpFlowsccMax(elem.getSpecLimitSlumpFlowsccMax());
        model.setEngLimitSlumpFlowsccMin(elem.getEngLimitSlumpFlowsccMin());
        model.setEngLimitSlumpFlowsccMax(elem.getEngLimitSlumpFlowsccMax());
        model.setTrialOverdesignCompstrMin(elem.getTrialOverdesignCompstrMin());
        model.setTrialOverdesignCompstrMax(elem.getTrialOverdesignCompstrMax());
        model.setTensilestr28day(elem.getDesignTensileStr());
        model.setDesignTensileStrAge(elem.getDesignTensileStrAge());
        model.setDesignTensileStrAgeUnit(elem.getDesignTensileStrAgeUnit());
        model.setFlexstr28day(elem.getDesignFlexStr());
        model.setDesignFlexStrAge(elem.getDesignFlexStrAge());
        model.setDesignFlexStrAgeUnit(elem.getDesignFlexStrAgeUnit());
        model.setSpecLimitTensileStrMin(elem.getSpecLimitTensileStrMin());
        model.setSpecLimitTensileStrMax(elem.getSpecLimitTensileStrMax());
        model.setEngLimitTensileStrMin(elem.getEngLimitTensileStrMin());
        model.setEngLimitTensileStrMax(elem.getEngLimitTensileStrMax());
        model.setSpecLimitFlexStrMin(elem.getSpecLimitFlexStrMin());
        model.setSpecLimitFlexStrMax(elem.getSpecLimitFlexStrMax());
        model.setEngLimitFlexStrMin(elem.getEngLimitFlexStrMin());
        model.setEngLimitFlexStrMax(elem.getEngLimitFlexStrMax());
        model.setConcreteClass(elem.getConcreteClass());
        model.setSpecSlumpSuspension(elem.getSpecSlumpSuspension());
        model.setSpecSlumpAction(elem.getSpecSlumpAction());
        model.setSpecAircontSuspension(elem.getSpecAircontentSuspension());
        model.setSpecAircontAction(elem.getSpecAircontentAction());
        model.setReqtk(elem.getReqtk());
        model.setSpecFlexSuspension(elem.getSpecFlexSuspension());
        model.setSpecFlexAction(elem.getSpecFlexAction());
        model.setSpecTkSuspension(elem.getSpecTkSuspension());
        model.setSpecTkAction(elem.getSpecTkAction());
        model.setSpecConcTempMin(elem.getSpecConcTempMin());
        model.setSpecConcTempMax(elem.getSpecConcTempMax());
        model.setSpecResidualStrength1(elem.getSpecResidualStr1());
        model.setSpecResidualStrength2(elem.getSpecResidualStr2());
        model.setSpecResidualStrength3(elem.getSpecResidualStr3());
        model.setSpecResidualStrengthPeak(elem.getSpecResidualStrPeak());
        model.setBoiledabsorption28day(elem.getBoiledabsorption());
        model.setMasterRefId(elem.getId().toBigInteger());
        return model;
    }

    private QaconcMixdesignMaster toQaconcMixdesignMaster(ConcMixDesignDef mdef, BigInteger clientId, GlobSupplier supplierId, GlobSupplierAddress supplierLocId, QmCvlFieldData mixdesignType, QmCvlFieldData maxAggSizeId, String isGlobal) {
        QaconcMixdesignMaster model = new QaconcMixdesignMaster();
        model.setMixdesignNo(mdef.getMixdesignNo());
        model.setClientId(clientId);
        model.setSupplierId(supplierId);
        model.setSupplierLocId(supplierLocId);
        model.setMixdesignType(mixdesignType);
        model.setMaxAggSizeId(maxAggSizeId);
        model.setMixStatus(StringSupport.isNotNullAndNotEmpty(mdef.getMixStatus()) ? StringSupport.sanitizeString(mdef.getMixStatus(), "\\s+", 0) : null);
        model.setExpirationDate(mdef.getExpirationDate());
        model.setDesignCompstr(NumberSupport.getBigDecimal(mdef.getDesignCompstr()));
        model.setDesignCompstrAge(NumberSupport.getBigInteger(mdef.getDesignCompstrAge()));
        model.setDesignCompstrAgeUnit(StringSupport.isNotNullAndNotEmpty(mdef.getDesignCompstrAgeUnit()) ? mdef.getDesignCompstrAgeUnit().toLowerCase() : null);
        model.setDesignSlump(NumberSupport.getBigDecimal(mdef.getDesignSlump()));
        model.setDesignSlumpFlowScc(NumberSupport.getBigDecimal(mdef.getDesignSlumpFlowScc()));
        model.setDesignAirContent(NumberSupport.getBigDecimal(mdef.getDesignAirContent()));
        model.setTotalCoarseAgg(NumberSupport.getBigDecimal(mdef.getTotalCoarseAgg()));
        model.setCoarseAgg1(NumberSupport.getBigDecimal(mdef.getTotalCoarseAgg()));
        model.setTotalFineAgg(NumberSupport.getBigDecimal(mdef.getTotalFineAgg()));
        model.setFineAgg1(NumberSupport.getBigDecimal(mdef.getTotalFineAgg()));
        model.setCement(NumberSupport.getBigDecimal(mdef.getCement()));
        model.setFlyAsh(NumberSupport.getBigDecimal(mdef.getFlyAsh()));
        model.setSlag(NumberSupport.getBigDecimal(mdef.getSlag()));
        model.setSilicaFume(NumberSupport.getBigDecimal(mdef.getSilicaFume()));
        model.setTotalCementMat(NumberSupport.getBigDecimal(mdef.getTotalCementMat()));
        model.setWater(NumberSupport.getBigDecimal(mdef.getWater()));
        model.setAdmixtureQty1(NumberSupport.getBigDecimal(mdef.getAdmixtureQty1()));
        model.setAdmixtureType1(mdef.getAdmixtureType1());
        model.setAdmixtureQty2(NumberSupport.getBigDecimal(mdef.getAdmixtureQty2()));
        model.setAdmixtureType2(mdef.getAdmixtureType2());
        model.setAdmixtureQty3(NumberSupport.getBigDecimal(mdef.getAdmixtureQty3()));
        model.setAdmixtureType3(mdef.getAdmixtureType3());
        model.setAdmixtureQty4(NumberSupport.getBigDecimal(mdef.getAdmixtureQty4()));
        model.setAdmixtureType4(mdef.getAdmixtureType4());
        model.setAdmixtureQty5(NumberSupport.getBigDecimal(mdef.getAdmixtureQty5()));
        model.setAdmixtureType5(mdef.getAdmixtureType5());
        model.setAdmixtureQty6(NumberSupport.getBigDecimal(mdef.getAdmixtureQty6()));
        model.setAdmixtureType6(mdef.getAdmixtureType6());
        model.setAdmixtureQty7(NumberSupport.getBigDecimal(mdef.getAdmixtureQty7()));
        model.setAdmixtureType7(mdef.getAdmixtureType7());
        model.setAdmixtureQty8(NumberSupport.getBigDecimal(mdef.getAdmixtureQty8()));
        model.setAdmixtureType8(mdef.getAdmixtureType8());
        model.setWaterCementRatio(NumberSupport.getBigDecimal(mdef.getWaterCementRatio()));
        model.setWaterCementMax(NumberSupport.getBigDecimal(mdef.getWaterCementMax()));
        model.setTheoreticalAirContent(NumberSupport.getBigDecimal(mdef.getTheoreticalAirContent()));
        model.setVolumenPaste(NumberSupport.getBigDecimal(mdef.getVolumenPaste()));
        model.setSpecLimitSlumpMin(NumberSupport.getBigDecimal(mdef.getSpecLimitSlumpMin()));
        model.setSpecLimitSlumpMax(NumberSupport.getBigDecimal(mdef.getSpecLimitSlumpMax()));
        model.setEngLimitSlumpMin(NumberSupport.getBigDecimal(mdef.getEngLimitSlumpMin()));
        model.setEngLimitSlumpMax(NumberSupport.getBigDecimal(mdef.getEngLimitSlumpMax()));
        model.setSpecLimitAirContentMin(NumberSupport.getBigDecimal(mdef.getSpecLimitAirContentMin()));
        model.setSpecLimitAirContentMax(NumberSupport.getBigDecimal(mdef.getSpecLimitAirContentMax()));
        model.setEngLimitAirContentMin(NumberSupport.getBigDecimal(mdef.getEngLimitAirContentMin()));
        model.setEngLimitAirContentMax(NumberSupport.getBigDecimal(mdef.getEngLimitAirContentMax()));
        model.setSpecLimitCompstrMin(NumberSupport.getBigDecimal(mdef.getSpecLimitCompstrMin()));
        model.setSpecLimitCompstrMax(NumberSupport.getBigDecimal(mdef.getSpecLimitCompstrMax()));
        model.setEngLimitCompstrMin(NumberSupport.getBigDecimal(mdef.getEngLimitCompstrMin()));
        model.setEngLimitCompstrMax(NumberSupport.getBigDecimal(mdef.getEngLimitCompstrMax()));
        model.setSpecLimitSlumpFlowsccMin(NumberSupport.getBigDecimal(mdef.getSpecLimitSlumpFlowsccMin()));
        model.setSpecLimitSlumpFlowsccMax(NumberSupport.getBigDecimal(mdef.getSpecLimitSlumpFlowsccMax()));
        model.setEngLimitSlumpFlowsccMin(NumberSupport.getBigDecimal(mdef.getEngLimitSlumpFlowsccMin()));
        model.setEngLimitSlumpFlowsccMax(NumberSupport.getBigDecimal(mdef.getEngLimitSlumpFlowsccMax()));
        model.setTrialOverdesignCompstrMin(NumberSupport.getBigDecimal(mdef.getTrialOverdesignCompstrMin()));
        model.setTrialOverdesignCompstrMax(NumberSupport.getBigDecimal(mdef.getTrialOverdesignCompstrMax()));
        model.setDesignTensileStr(NumberSupport.getBigDecimal(mdef.getDesignTensileStr()));
        model.setDesignTensileStrAge(NumberSupport.getBigInteger(mdef.getDesignTensileStrAge()));
        model.setDesignTensileStrAgeUnit(StringSupport.isNotNullAndNotEmpty(mdef.getDesignTensileStrAgeUnit()) ? mdef.getDesignTensileStrAgeUnit().toLowerCase() : null);
        model.setDesignFlexStr(NumberSupport.getBigDecimal(mdef.getDesignFlexStr()));
        model.setDesignFlexStrAge(NumberSupport.getBigInteger(mdef.getDesignFlexStrAge()));
        model.setDesignFlexStrAgeUnit(StringSupport.isNotNullAndNotEmpty(mdef.getDesignFlexStrAgeUnit()) ? mdef.getDesignFlexStrAgeUnit().toLowerCase() : null);
        model.setSpecLimitTensileStrMin(NumberSupport.getBigDecimal(mdef.getSpecLimitTensileStrMin()));
        model.setSpecLimitTensileStrMax(NumberSupport.getBigDecimal(mdef.getSpecLimitTensileStrMax()));
        model.setEngLimitTensileStrMin(NumberSupport.getBigDecimal(mdef.getEngLimitTensileStrMin()));
        model.setEngLimitTensileStrMax(NumberSupport.getBigDecimal(mdef.getEngLimitTensileStrMax()));
        model.setSpecLimitFlexStrMin(NumberSupport.getBigDecimal(mdef.getSpecLimitFlexStrMin()));
        model.setSpecLimitFlexStrMax(NumberSupport.getBigDecimal(mdef.getSpecLimitFlexStrMax()));
        model.setEngLimitFlexStrMin(NumberSupport.getBigDecimal(mdef.getEngLimitFlexStrMin()));
        model.setEngLimitFlexStrMax(NumberSupport.getBigDecimal(mdef.getEngLimitFlexStrMax()));
        model.setConcreteClass(mdef.getConcreteClass());
        model.setSpecSlumpSuspension(NumberSupport.getBigDecimal(mdef.getSpecSlumpSuspension()));
        model.setSpecSlumpAction(NumberSupport.getBigDecimal(mdef.getSpecSlumpAction()));
        model.setSpecAircontentSuspension(NumberSupport.getBigDecimal(mdef.getSpecAircontentSuspension()));
        model.setSpecAircontentAction(NumberSupport.getBigDecimal(mdef.getSpecAircontentAction()));
        model.setReqtk(NumberSupport.getBigDecimal(mdef.getReqtk()));
        model.setSpecFlexSuspension(NumberSupport.getBigDecimal(mdef.getSpecFlexSuspension()));
        model.setSpecFlexAction(NumberSupport.getBigDecimal(mdef.getSpecFlexAction()));
        model.setSpecTkSuspension(NumberSupport.getBigDecimal(mdef.getSpecTkSuspension()));
        model.setSpecTkAction(NumberSupport.getBigDecimal(mdef.getSpecTkAction()));
        model.setSpecConcTempMin(NumberSupport.getBigInteger(mdef.getSpecConcTempMin()));
        model.setSpecConcTempMax(NumberSupport.getBigInteger(mdef.getSpecConcTempMax()));
        model.setSpecResidualStr1(NumberSupport.getBigDecimal(mdef.getSpecResidualStr1()));
        model.setSpecResidualStr2(NumberSupport.getBigDecimal(mdef.getSpecResidualStr2()));
        model.setSpecResidualStr3(NumberSupport.getBigDecimal(mdef.getSpecResidualStr3()));
        model.setSpecResidualStrPeak(NumberSupport.getBigDecimal(mdef.getSpecResidualStrPeak()));
        model.setBoiledabsorption(NumberSupport.getBigDecimal(mdef.getBoiledabsorption()));
        model.setIsGlobal(isGlobal);
        return model;
    }

    private QaconcMixdesignMaster toQaconcMixdesignMaster(ConcMixDesignDef mdef, BigInteger clientId, GlobSupplier supplierId, GlobSupplierAddress supplierLocId, QmCvlFieldData mixdesignType, QmCvlFieldData maxAggSizeId) {
        return toQaconcMixdesignMaster(mdef, clientId, supplierId, supplierLocId, mixdesignType, maxAggSizeId, "Y");
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_concmixdesignmaster", reportId);
        GlobClient client = globClientService.findById(clientId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "qaConcMixMaster": {
                    return generateMasterReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "qaConcMixMasterLog": {
                    return generateMasterLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "qaConcMixMasterCsvLog": {
                    return generateMasterExcelCsvReport(docpathsegment, docType, request, Optional.ofNullable(client.getCompanyName()).orElseGet(()->"default"));
                }
            }
            return tplpath;
        } else {
            switch (reportId) {
                case "qaConcMixMasterCsvLog": {
                    return generateMasterExcelCsvReport(docpathsegment, docType, request, Optional.ofNullable(client.getCompanyName()).orElseGet(()->"default"));
                }
                default: {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
                }
            }
        }
        return null;
    }

    private String generateMasterExcelCsvReport(String docpathsegment, String docType, ManageITBodyRequest request, String clientName) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.excel;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<QaconcMixdesignsTO> ds = generateReportData(request);
        String targetPath = docpathsegment + "ConcreteMasterMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridExcelSimple jd = new JasperDesignGridExcelSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, extension);
            JasperDesign tpl = jd.buildTemplate("Concrete Mix Design", QaconcMixdesignsTO.class, clientName);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        List<QaconcMixdesignsTO> pResult = generateReportData(request);

        String targetPath = docpathsegment + "ConcreteMasterMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaconcMixdesignsTO> generateReportData(ManageITBodyRequest request) {
        List<QaconcMixdesignMaster> filterList = list(request);
        List<QaconcMixdesignsTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateTO());
        });
        return rList;
    }

    private String generateMasterLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<QaconcMixDesignsLogTO> pResult = generateReportLogData(request);

        String targetPath = docpathsegment + "ConcreteMasterMixDesignLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaconcMixDesignsLogTO> generateReportLogData(ManageITBodyRequest request) {
        List<QaconcMixdesignMaster> filterList = list(request);
        List<QaconcMixDesignsLogTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateLogTO());
        });
        return rList;
    }

    @Override
    public String generateExcelTemplate(String paramClientId, String tplbasePath, String docpathsegment) {
        List<GlobSupplier> supplierList = globSupplierService.filterByMaterialType(paramClientId, "concrete");
        List<Object[]> locList = globSupplierService.getSupplierAndLocation(NumberSupport.getBigInteger(paramClientId), "concrete");
        List<QmCvlFieldData> cvlMixType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldCode", "MIXTYPE_DATA").filter("active", "Y").sorted("value", "asc"));
        List<QmCvlFieldData> cvlAggSize = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", paramClientId).filter("fieldId.fieldName", "Aggregate Size").filter("active", "Y").sorted("value", "asc"));
        if (supplierList == null || supplierList.isEmpty() || cvlMixType == null || cvlMixType.isEmpty() || cvlAggSize == null || cvlAggSize.isEmpty() || locList == null || locList.isEmpty()) {
            return null;
        }
        String tplpath = tplbasePath + "ConcMixDesignTemplate.xlsx";
        String targetPath = docpathsegment + "ConcMixDesignTemplate_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + ".xlsx";
        try {
            ConcMixDesignPluginDirector director = new ConcMixDesignPluginDirector(new File(tplpath), eConcMixDesign.AtserConcMixDesignTpl);
            ExcelDocument doc = director.getpDoc();
            if (!doc.getListPages().isEmpty() && doc.getListPages().size() == 2) {
                Sheet catalog = doc.getListPages().get(1);
                if (catalog.getSheetName().equals("Catalog")) {
                    int startRow = 1;
                    // Write MixDesignType
                    for (QmCvlFieldData it : cvlMixType) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(2);
                        cell.setCellValue(it.getValue());
                    }

                    // Write MaxAgg
                    startRow = 1;
                    for (QmCvlFieldData it : cvlAggSize) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(4);
                        cell.setCellValue(it.getValue());
                    }

                    // Write ProducedBy
                    startRow = 1;
                    for (GlobSupplier it : supplierList) {
                        Row row = catalog.getRow(startRow++);
                        Cell cell = row.getCell(6);
                        cell.setCellValue(it.getSupplier());
                    }

                    // Write Location
                    startRow = 1;
                    for (Object[] it : locList) {
                        Row row = catalog.getRow(startRow++);
                        Cell cellProd = row.getCell(8);
                        Cell cellLoc = row.getCell(9);
                        cellProd.setCellValue(StringSupport.emptyOnNull(it[0]));
                        cellLoc.setCellValue(StringSupport.emptyOnNull(it[1]));
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
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportConcMixDesignTO data) {
        if (data != null && data.getMixes() != null && !data.getMixes().isEmpty()) {
            if (StringSupport.isNullOrEmpty(header.getClientid())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            List<GenericStatusPojo> importErrors = new ArrayList<>();
            List<GlobSupplier> supplierList = globSupplierService.filterByMaterialType(header.getClientid(), "concrete");
            List<QmCvlFieldData> cvlMixType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldCode", "MIXTYPE_DATA").sorted("value", "asc"));
            List<QmCvlFieldData> cvlAggSize = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", header.getClientid()).filter("fieldId.fieldName", "Aggregate Size").sorted("value", "asc"));
            data.getMixes().forEach(it -> {
                if (StringSupport.isNotNullAndNotEmpty(it.getProducedBy(), it.getPlantLocation(), it.getMixdesignType(), it.getMixStatus())) {
                    if (!dao.exists(NumberSupport.getBigInteger(header.getClientid()), it.getMixdesignNo())) {
                        Optional<GlobSupplier> matchSupplier = supplierList.stream().filter(p -> p.getSupplier().equals(it.getProducedBy())).findFirst();
                        GlobSupplier fSupplier = matchSupplier.orElse(null);
                        if (fSupplier != null) {
                            List<Object[]> locList = globSupplierService.getSupplierAndLocation(NumberSupport.getBigInteger(header.getClientid()), "concrete", fSupplier.getId());
                            Optional<Object[]> matchLoc = locList.stream().filter(p -> p[1].equals(it.getPlantLocation())).findFirst();
                            Object[] fPlantLocation = matchLoc.orElse(null);
                            Optional<QmCvlFieldData> matchMixType = cvlMixType.stream().filter(p -> p.getValue().equals(it.getMixdesignType())).findFirst();
                            QmCvlFieldData fMixType = matchMixType.orElse(null);
                            Optional<QmCvlFieldData> matchAggSize = cvlAggSize.stream().filter(p -> p.getValue().equals(it.getMaxAggSize())).findFirst();
                            QmCvlFieldData fAggSize = matchAggSize.orElse(null);
                            if (fPlantLocation != null && fMixType != null && fAggSize != null) {
                                GlobSupplierAddress dbSupAddress = globSupplierAddressService.findById(fPlantLocation[2].toString());
                                QaconcMixdesignMaster elem = toQaconcMixdesignMaster(it, NumberSupport.getBigInteger(header.getClientid()), fSupplier, dbSupAddress, fMixType, fAggSize);
                                if (StringSupport.isNotNullAndNotEmpty(elem.getMixStatus()) && elem.getMixStatus().toLowerCase().equals("pending")) {
                                    elem.setMixStatus("pending");
                                }
                                elem.setStatus("PENDING");
                                elem.setCreatedBy(header.getUser());
                                elem.setCreatedByIp(header.getModIp());
                                elem.setLastModIp(header.getModIp());
                                elem.setLastModBy(header.getUser());
                                dao.save(elem);
                            } else {
                                it.setStatus("ERROR: Basic Information not Found !");
                                importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "Basic Information not Found !"));
                            }
                        } else {
                            it.setStatus("ERROR: Basic Information not Found !");
                            importErrors.add(new GenericStatusPojo(it.getMixdesignNo(), "ERROR", null, it, "Supplier not Found !"));
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

    // **************** Import Conc Mix Design [BEGIN] *************************
    @Override
    public List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("projectId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GenericStatusPojo> importErrors = new ArrayList<>();
        List<String> projectList = Arrays.asList(StringSupport.getString(params.get("projectId")).split(","));
        if (projectList == null || projectList.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcMixDesignPluginDirector director;
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.emptyOnNull(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        director = new ConcMixDesignPluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eConcMixDesign.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<ConcMixDesignDef> model = director.getModelAllSheets();
        if (model != null) {
            model.forEach(it -> {
                GenericStatusPojo response = importConcMixDesignSaveOrUpdate(header, projectList, it);
                if (response != null) {
                    importErrors.add(response);
                }
            });
            // Track Import By Project
            projectList.forEach(it -> {
                globDataGatewayLogService.save(new GlobDataGatewayLog(NumberSupport.getBigInteger(params.get("clientId")),
                        NumberSupport.getBigInteger(it),
                        StringSupport.getString(params.get("functionality")),
                        StringSupport.getString(metaDataFile.get("ofilename")),
                        NumberSupport.getBigInteger(model.size()),
                        StringSupport.emptyOnNull(params.get("sessionUser")),
                        StringSupport.emptyOnNull(params.get("modIp"))));
            });
        }

        return importErrors;
    }

    private GenericStatusPojo importConcMixDesignSaveOrUpdate(ManageITHeader header, List<String> projectIdList, ConcMixDesignDef def) {
        if (def != null) {
            QaconcMixdesignMaster elem = dao.findByMixdesignNo(def.getMixdesignNo(), NumberSupport.getBigInteger(header.getClientid()));
            GenericStatusPojo rDef = generateQaconcMixdesignMasterFromConcMixDesignDef(header, projectIdList, def, (elem != null));
            if (rDef.getErr() != null) {
                return rDef;
            }
            QaconcMixdesignMaster elemDef = (QaconcMixdesignMaster) rDef.getData();
            if (elem != null) {
                // Update (Review)
                //if (!isConcMixDefEqualsConcMixMaster(elemDef, elem)) {
                importUpdate(header, elem, elemDef, projectIdList);
                //}
            } else {
                // Save Master Conc Mix
                dao.save(elemDef);
                // Save Project Conc Mix
                for (String it : projectIdList) {
                    try {
                        assignToProject(header, it, elemDef.getId().toString());
                    } catch (BaseException ex) {
                        return new GenericStatusPojo(def.getMixdesignNo(), "ERROR", null, def, ex.getMessage());
                    }
                }
            }
        }
        return null;
    }

    private GenericStatusPojo generateQaconcMixdesignMasterFromConcMixDesignDef(ManageITHeader header, List<String> projectIdList, ConcMixDesignDef def, boolean isUpdate) {
        GenericStatusPojo response;
        BigInteger clientId = NumberSupport.getBigInteger(header.getClientid());
        List<QmCvlFieldData> cvlMixType = qmCvlFieldDataService.list(new ManageITBodyRequest(0, 0).filter("fieldId.sectionId.clientId", clientId).filter("fieldId.fieldCode", "MIXTYPE_DATA").sorted("value", "asc"));
        // Get Supplier
        GlobSupplier supplierId = globSupplierService.findByImpCode(def.getProducedBy());
        if (supplierId != null) {
            // Get Main Supplier Location
            GlobSupplierAddress suppLocId = globSupplierAddressService.getMainLocationBySupplierId(supplierId.getId().toBigInteger());
            // Get Mix Design Type or Create it 
            Optional<QmCvlFieldData> matchMixType = cvlMixType.stream().filter(p -> StringSupport.sanitizeString(p.getValue(), "\\s+", 0).equals(StringSupport.sanitizeString(def.getMixdesignType(), "\\s+", 0))).findFirst();
            QmCvlFieldData fMixType = matchMixType.orElse(null);
            if (fMixType == null) {
                // Get CVL Field Id
                QmCvlField cvlFieldId = qmCvlFieldDataService.getQmCvlFieldParent(clientId, "Header", "MIXTYPE_DATA");
                fMixType = new QmCvlFieldData(cvlFieldId, def.getMixdesignType(), header.getUser(), header.getModIp(), BigInteger.ONE, StringSupport.sanitizeString(def.getMixdesignType(), "\\s+", 1));
                // Create CVL Field Data
                qmCvlFieldDataService.save(fMixType);
            }
            // Convert to QaconcMixdesignMaster
            QaconcMixdesignMaster elemDef = toQaconcMixdesignMaster(def, clientId, supplierId, suppLocId, fMixType, null, "N");
            elemDef.setLastModIp(header.getModIp());
            elemDef.setLastModBy(header.getUser());
            if (!isUpdate) {
                elemDef.setCreatedBy(header.getUser());
                elemDef.setCreatedByIp(header.getModIp());
            }
            // Add All Projects
            projectIdList.forEach(it -> {
                elemDef.addProjectList(new QaconcMixdesignMasterproject(NumberSupport.getBigInteger(it)));
            });
            response = new GenericStatusPojo(def.getMixdesignNo(), "DONE", elemDef);
        } else {
            response = new GenericStatusPojo(def.getMixdesignNo(), "ERROR", null, def, "Supplier not Found !");
        }
        return response;
    }

    private GenericStatusPojo importUpdate(ManageITHeader header, QaconcMixdesignMaster model, QaconcMixdesignMaster elem, List<String> projectIdList) {
        if (model != null) {
            //model.setMixdesignType(elem.getMixdesignType());
            //model.setSupplierId(elem.getSupplierId());
            model.setConcreteClass(elem.getConcreteClass());
            model.setExpirationDate(elem.getExpirationDate());
            model.setSpecLimitCompstrMin(elem.getSpecLimitCompstrMin());
            model.setDesignCompstr(elem.getDesignCompstr());
            model.setWaterCementRatio(elem.getWaterCementRatio());
            model.setTheoreticalAirContent(elem.getTheoreticalAirContent());
            model.setDesignSlump(elem.getDesignSlump());
            model.setLastMod(new Date());
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            // Update Master
            dao.update(model);
            if (model.getId() != null) {
                // Update Project Level
                for (String it : projectIdList) {
                    if (qaconcMixdesignMasterprojectDao.existsRelationshipWithProject(model.getId().toBigInteger(), NumberSupport.getBigInteger(it))) {
                        qaconcMixdesignsService.updateFromMaster(NumberSupport.getBigInteger(it), model.getId().toBigInteger(), toQaconcMixdesigns(model));
                    } else {
                        try {
                            // Saving Project Relationship with Mix
                            qaconcMixdesignMasterprojectDao.save(new QaconcMixdesignMasterproject(model, NumberSupport.getBigInteger(it)));
                            // Assigning Mix to the project Level.
                            assignToProject(header, it, model.getId().toString());
                        } catch (BaseException ex) {
                            return new GenericStatusPojo(elem.getMixdesignNo(), "ERROR", null, elem, ex.getMessage());
                        }
                    }
                }
            }
        }
        return null;
    }

    private Boolean isConcMixDefEqualsConcMixMaster(QaconcMixdesignMaster def, QaconcMixdesignMaster elem) {
        /*if (!Objects.equals(def.getMixdesignType(), elem.getMixdesignType())) {
            return Boolean.FALSE;
        }
        if (!Objects.equals(def.getSupplierId(), elem.getSupplierId())) {
            return Boolean.FALSE;
        }*/
        if (!StringSupport.compareString(def.getConcreteClass(), elem.getConcreteClass())) {
            return Boolean.FALSE;
        }
        if (!Objects.equals(def.getExpirationDate(), elem.getExpirationDate())) {
            return Boolean.FALSE;
        }
        if (!def.getSpecLimitCompstrMin().equals(elem.getSpecLimitCompstrMin())) {
            return Boolean.FALSE;
        }
        if (!def.getDesignCompstr().equals(elem.getDesignCompstr())) {
            return Boolean.FALSE;
        }
        if (!def.getWaterCementRatio().equals(elem.getWaterCementRatio())) {
            return Boolean.FALSE;
        }
        if (!def.getTheoreticalAirContent().equals(elem.getTheoreticalAirContent())) {
            return Boolean.FALSE;
        }
        if (!def.getDesignSlump().equals(elem.getDesignSlump())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    // **************** Import Conc Mix Design [END] ***************************

}
