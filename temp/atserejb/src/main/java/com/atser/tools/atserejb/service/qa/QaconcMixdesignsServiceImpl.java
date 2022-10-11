/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaconcMixdesignsDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixdesignsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaconcMixdesignsServiceImpl implements QaconcMixdesignsService, IBaseEJBException {

    @Inject
    private QaconcMixdesignsDao dao;

    @Inject
    private QaSampleService qaSampleService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private WsReportService wsReportService;

    @Override
    public QaconcMixdesigns findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcMixdesigns findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaconcMixdesigns findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcMixdesigns findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaconcMixdesigns elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaconcMixdesigns elem) {
        if (elem != null) {
            if (!dao.exists(elem.getProjectId(), elem.getMixDesign())) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                elem.setCreateBy(header.getUser());
                elem.setCreateByIp(header.getModIp());
                elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setVersion("1");
                dao.save(elem);
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Mix Design already exists.");
            }
        }
    }

    @Override
    public void update(ManageITHeader header, QaconcMixdesigns elem) {
        if (elem != null) {
            QaconcMixdesigns model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                if (StringSupport.isNullOrEmpty(model.getVersion())) {
                    model.setVersion("1");
                } else {
                    model.setVersion(String.valueOf(Integer.valueOf(model.getVersion()) + 1));
                }
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    public void updateFromMaster(BigInteger projectId, BigInteger masterRefId, QaconcMixdesigns elem) {
        if (projectId != null && masterRefId != null && elem != null) {
            QaconcMixdesigns model = dao.findByMasterRefAndProject(projectId, masterRefId);
            if (model != null) {
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModBy(model.getLastModBy());
                model.setLastModIp(model.getLastModIp());
                if (StringSupport.isNullOrEmpty(model.getVersion())) {
                    model.setVersion("1");
                } else {
                    model.setVersion(String.valueOf(Integer.valueOf(model.getVersion()) + 1));
                }
                dao.update(populate(model, elem));
            }
        }
    }

    private QaconcMixdesigns populate(QaconcMixdesigns model, QaconcMixdesigns elem) {
        model.setConcreteClass(elem.getConcreteClass());
        model.setSpecSlumpMin(elem.getSpecSlumpMin());
        model.setSpecSlumpMax(elem.getSpecSlumpMax());
        model.setSpecAircontMin(elem.getSpecAircontMin());
        model.setSpecAircontMax(elem.getSpecAircontMax());
        model.setMaxWaterCmt(elem.getMaxWaterCmt());
        model.setAggSource(elem.getAggSource());
        model.setAggSource1(elem.getAggSource1());
        model.setAggSource2(elem.getAggSource2());
        model.setSandSource(elem.getSandSource());
        model.setSandSource1(elem.getSandSource1());
        model.setSandSource2(elem.getSandSource2());
        model.setFlyAsh(elem.getFlyAsh());
        model.setSpecSlumpDesign(elem.getSpecSlumpDesign());
        model.setSpecSlumpSuspension(elem.getSpecSlumpSuspension());
        model.setSpecSlumpAction(elem.getSpecSlumpAction());
        model.setSpecAircontDesign(elem.getSpecAircontDesign());
        model.setSpecAircontSuspension(elem.getSpecAircontSuspension());
        model.setSpecAircontAction(elem.getSpecAircontAction());
        model.setFlexstr28day(elem.getFlexstr28day());
        model.setReqtk(elem.getReqtk());
        model.setSpecFlexAction(elem.getSpecFlexAction());
        model.setSpecTkAction(elem.getSpecTkAction());
        model.setCementAmount(elem.getCementAmount());
        model.setSpecConcTempMin(elem.getSpecConcTempMin());
        model.setSpecConcTempMax(elem.getSpecConcTempMax());
        model.setAdmixtureQty1(elem.getAdmixtureQty1());
        model.setAdmixtureQty2(elem.getAdmixtureQty2());
        model.setAdmixtureQty3(elem.getAdmixtureQty3());
        model.setSpecResidualStrength1(elem.getSpecResidualStrength1());
        model.setSpecResidualStrength2(elem.getSpecResidualStrength2());
        model.setSpecResidualStrength3(elem.getSpecResidualStrength3());
        model.setBoiledabsorption28day(elem.getBoiledabsorption28day());
        model.setTensilestr28day(elem.getTensilestr28day());
        model.setSpecResidualStrengthPeak(elem.getSpecResidualStrengthPeak());
        model.setSpecWater(elem.getSpecWater());
        model.setAvg28dayStrength(elem.getAvg28dayStrength());
        model.setAdmixtureQty4(elem.getAdmixtureQty4());
        model.setAdmixtureQty5(elem.getAdmixtureQty5());
        model.setAdmixtureType1(elem.getAdmixtureType1());
        model.setAdmixtureType2(elem.getAdmixtureType2());
        model.setAdmixtureType3(elem.getAdmixtureType3());
        model.setAdmixtureType4(elem.getAdmixtureType4());
        model.setAdmixtureType5(elem.getAdmixtureType5());
        model.setSpecFlexSuspension(elem.getSpecFlexSuspension());
        model.setSpecTkSuspension(elem.getSpecTkSuspension());
        model.setRemarks(elem.getRemarks());
        model.setMixdesignDescription(elem.getMixdesignDescription());
        model.setMaxAggSizeId(elem.getMaxAggSizeId());
        model.setDesignCompstrAge(elem.getDesignCompstrAge());
        model.setDesignCompstrAgeUnit(elem.getDesignCompstrAgeUnit());
        model.setDesignSlumpFlowScc(elem.getDesignSlumpFlowScc());
        model.setSlag(elem.getSlag());
        model.setSilicaFume(elem.getSilicaFume());
        model.setTotalCementMat(elem.getTotalCementMat());
        model.setAdmixtureQty6(elem.getAdmixtureQty6());
        model.setAdmixtureType6(elem.getAdmixtureType6());
        model.setAdmixtureQty7(elem.getAdmixtureQty7());
        model.setAdmixtureType7(elem.getAdmixtureType7());
        model.setAdmixtureQty8(elem.getAdmixtureQty8());
        model.setAdmixtureType8(elem.getAdmixtureType8());
        model.setWaterCementRatio(elem.getWaterCementRatio());
        model.setTheoreticalAirContent(elem.getTheoreticalAirContent());
        model.setVolumenPaste(elem.getVolumenPaste());
        model.setEngLimitSlumpMin(elem.getEngLimitSlumpMin());
        model.setEngLimitSlumpMax(elem.getEngLimitSlumpMax());
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
        model.setDesignTensileStrAge(elem.getDesignTensileStrAge());
        model.setDesignTensileStrAgeUnit(elem.getDesignTensileStrAgeUnit());
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
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaconcMixdesigns> list(ManageITBodyRequest request) {
        List<QaconcMixdesigns> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        list.forEach(it -> {
            if (qaSampleService.existsConcMixDesign(it.getId().toBigInteger())) {
                it.setCanbeDeleted("false");
            }
        });
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QaconcMixdesigns> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaconcMixdesigns> finalList = list(request);
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
                QaconcMixdesigns model = (QaconcMixdesigns) objResp[0];
                if (model.getSupplierId() != null) {
                    model.getSupplierId().getSupplier();
                }
                if (model.getMaxAggSizeId() != null) {
                    model.getMaxAggSizeId().getId();
                }
            });
        }
        return vlist;
    }

    @Override
    public Boolean exists(BigInteger projectId, String name) {
        return dao.exists(projectId, name);
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_concmixdesign", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "qaConcMix": {
                    return generateMasterReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "qaConcMixLog": {
                    return generateLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
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

        String targetPath = docpathsegment + "ConcreteMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaconcMixdesignsTO> generateReportData(ManageITBodyRequest request) {
        List<QaconcMixdesigns> filterList = list(request);
        GlobProject project;
        if (filterList != null && !filterList.isEmpty()) {
            project = globProjectService.findById(filterList.get(0).getProjectId().toString());
            List<QaconcMixdesignsTO> rList = new ArrayList<>();
            filterList.forEach(it -> {
                QaconcMixdesignsTO to = it.generateTO();
                if (project != null) {
                    to.setpNumber(project.getPNumber());
                }
                rList.add(to);
            });
            return rList;
        }
        return null;
    }

    private String generateLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<QaconcMixDesignsLogTO> pResult = generateReportLogData(request);

        String targetPath = docpathsegment + "ConcreteMixDesignLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaconcMixDesignsLogTO> generateReportLogData(ManageITBodyRequest request) {
        List<QaconcMixdesigns> filterList = list(request);
        GlobProject project;
        if (filterList != null && !filterList.isEmpty()) {
            project = globProjectService.findById(filterList.get(0).getProjectId().toString());
            List<QaconcMixDesignsLogTO> rList = new ArrayList<>();
            filterList.forEach(it -> {
                QaconcMixDesignsLogTO to = it.generateLogTO();
                if (project != null) {
                    to.setpNumber(project.getPNumber());
                }
                rList.add(to);
            });
            return rList;
        }
        return null;
    }

    @Override
    public void changeStatusByMasterId(Character status, BigInteger masterId) {
        dao.changeStatusByMasterId(status, masterId);
    }

    /**
     * Find QaconcMixdesigns by ProjectId and MixDesign No
     * @param projectId
     * @param mixdesignNo
     * @return Null on Error
     */
    @Override
    public QaconcMixdesigns findByMixdesignNo(BigInteger projectId, String mixdesignNo) {
        if (projectId == null || StringSupport.isNullOrEmpty(mixdesignNo)) {
            return null;
        }
        return dao.findByMixdesignNo(projectId, mixdesignNo);
    }
}
