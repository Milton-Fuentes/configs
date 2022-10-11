/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignsDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmf;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsTO;
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
public class QaaspmMixdesignsServiceImpl implements QaaspmMixdesignsService, IBaseEJBException {

    @Inject
    private QaaspmMixdesignsDao dao;

    @Inject
    private QaSampleService qaSampleService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private QaaspmMixdesignsJmfService qaaspmMixdesignsJmfService;

    @Override
    public QaaspmMixdesigns findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesigns findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesigns findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesigns findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesigns elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaaspmMixdesigns elem) {
        if (elem != null) {
            if (!dao.exists(elem.getProjectId(), elem.getMixdesign())) {
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
    public void update(ManageITHeader header, QaaspmMixdesigns elem) {
        if (elem != null) {
            QaaspmMixdesigns model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                if (StringSupport.isNullOrEmpty(model.getVersion())) {
                    model.setVersion("1");
                } else {
                    model.setVersion(String.valueOf(Integer.valueOf(model.getVersion()) + 1));
                }
                dao.update(populate(model, elem));
            }
        }
    }

    private QaaspmMixdesigns populate(QaaspmMixdesigns model, QaaspmMixdesigns elem) {
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
        model.setLtmfDate(elem.getLtmfDate());
        model.setRapPct(elem.getRapPct());
        model.setParentMixdesignNo(elem.getParentMixdesignNo());
        model.setMixdesign(elem.getMixdesign());
        model.setMixtype(elem.getMixtype());
        model.setAdditivePct(elem.getAdditivePct());
        model.setTechPct(elem.getTechPct());        
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaaspmMixdesigns> list(ManageITBodyRequest request) {
        List<QaaspmMixdesigns> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        list.forEach(it -> {
            if (qaSampleService.existsAspmMixDesign(it.getId().toBigInteger())) {
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
    public DataTableWrapper<QaaspmMixdesigns> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesigns> finalList = list(request);
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
                QaaspmMixdesigns model = (QaaspmMixdesigns) objResp[0];
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
            });
        }
        return vlist;
    }

    @Override
    public Boolean exists(BigInteger projectId, String name) {
        return dao.exists(projectId, name);
    }

    @Override
    public void changeStatusByMasterId(Character status, BigInteger masterId) {
        dao.changeStatusByMasterId(status, masterId);
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_aspmmixdesign", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "qaAspmMix": {
                    return generateMasterReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "qaAspmMixLog": {
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

        List<QaaspmMixDesignsTO> pResult = generateReportData(request);

        String targetPath = docpathsegment + "AsphaltMixDesign_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaaspmMixdesignsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaaspmMixDesignsTO> generateReportData(ManageITBodyRequest request) {
        List<QaaspmMixdesigns> filterList = list(request);
        GlobProject project;
        List<QaaspmMixDesignsTO> rList = new ArrayList<>();
        project = globProjectService.findById(filterList.get(0).getProjectId().toString());
        filterList.forEach(it -> {
            QaaspmMixdesignsJmf mainJmf = qaaspmMixdesignsJmfService.getMainMixdesignJmfMaster(it.getId());
            if (mainJmf != null) {
                QaaspmMixDesignsTO obj = it.generateTO();
                List<GradationPojo> gradationList = qaaspmMixdesignsJmfService.getGradationPojoList(it.getId(), mainJmf.getId(), it.getSetId().getId());
                obj.setMainJmf(mainJmf.generatePojo());
                obj.setGradationList(gradationList);
                if (project != null) {
                    obj.setpNumber(project.getPNumber());
                }
                rList.add(obj);
            }
        });
        return rList;
    }

    private String generateLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<QaaspmMixDesignsLogTO> pResult = generateReportLogData(request);

        String targetPath = docpathsegment + "AsphaltMixDesignLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QaaspmMixdesignsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaaspmMixDesignsLogTO> generateReportLogData(ManageITBodyRequest request) {
        List<QaaspmMixdesigns> filterList = list(request);
        GlobProject project;
        List<QaaspmMixDesignsLogTO> rList = new ArrayList<>();
        project = globProjectService.findById(filterList.get(0).getProjectId().toString());
        filterList.forEach(it -> {
            QaaspmMixDesignsLogTO obj = it.generateLogTO();
            if (project != null) {
                obj.setpNumber(project.getPNumber());
            }
            rList.add(obj);
        });
        return rList;
    }
}
