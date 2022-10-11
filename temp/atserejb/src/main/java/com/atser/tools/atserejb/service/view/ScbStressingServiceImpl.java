/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbStressingDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbStressing;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbStressingPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;

@Stateless
public class ScbStressingServiceImpl implements ScbStressingService, IBaseEJBException {

    @Inject
    private ScbStressingDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbStressing> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbStressing> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbStressing> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<ScbStressing> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbStressing> finalList = list(request);
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
    public String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request) {
        if (request == null || columns == null || columns.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<ScbStressingPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_ScbStressing_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "C1610 SCC Static Segregation (Column Technique)", ScbStressingPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbStressingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbStressingPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbStressing> filterList = list(request);
        List<ScbStressingPojo> rList = new ArrayList<>();
        if (filterList != null && !filterList.isEmpty()) {
            //Get Project
            GlobProject project = projectService.findById(StringSupport.emptyOnNull(filterList.get(0).getProjectId()));
            BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
            filterList.forEach((it) -> {
                rList.add(generatePojo(it, project, projectLogoImage));
            });
        }
        return rList;
    }

    private ScbStressingPojo generatePojo(ScbStressing elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbStressingPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbStressingPojo();
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));
            response.setTestClosed(elem.getTestClosed());
            response.setApplyForAllStrands(elem.getApplyForAllStrands());
            response.setAllStrandsStressedTogether(elem.getAllStrandsStressedTogether());
            response.setPeReview(elem.getPeReview());
            response.setTendonDesignLength(StringSupport.getString(elem.getTendonDesignLength()));
            response.setNumPoints(StringSupport.getString(elem.getNumPoints()));            
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setTestnoNolink(elem.getTestnoNolink());
            response.setTestno(StringSupport.getString(elem.getTestno()));
            response.setReportNoLink(elem.getReportNoLink());         
            response.setRamGaugeNo(elem.getRamGaugeNo());
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setSegmentLocation(elem.getSegmentLocation());
            response.setTendonType(elem.getTendonType());
            response.seteBeforeAnchorSet(elem.geteBeforeAnchorSet());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setStatus(elem.getStatus());
            response.setStrandDesignation(elem.getStrandDesignation());
            response.setTestingTech(elem.getTestingTech());
            response.setRemarks(elem.getRemarks());
            response.setEnet(elem.getEnet());
            response.setEnet80(elem.getEnet80());
            response.setEplanSeated(elem.getEplanSeated());
            response.seteValue(elem.geteValue());
            response.setForceAdjustment(elem.getForceAdjustment());
            response.setOutInputGpRequired(elem.getOutInputGpRequired());
            response.setInstallationDate(elem.getInstallationDate());
            response.setJackingEnd(elem.getJackingEnd());
            response.setJackingModeUsed(elem.getJackingModeUsed());
            response.setLeSeatingPart(elem.getLeSeatingPart());
            response.setLeSeatingTotal(elem.getLeSeatingTotal());
            response.setLeSeatingWhole(elem.getLeSeatingWhole());
            response.setLiveEndSeating(elem.getLiveEndSeating());
            response.setLiveEndSeatingPart(elem.getLiveEndSeatingPart());
            response.setLiveEndSeatingWhole(elem.getLiveEndSeatingWhole());
            response.setStrandNo(elem.getStrandNo());
            response.setStressingDateTime(elem.getStressingDateTime());
            response.setTech(elem.getTech());
            response.setTotalJackingLoss(elem.getTotalJackingLoss());
            response.setLabname(elem.getLabname());
            response.setNumberOfStrandsBars(elem.getNumberOfStrandsBars());
            response.setNominalDia(elem.getNominalDia());
            response.setAreadesign(elem.getAreadesign());
            response.setEmoddesign(elem.getEmoddesign());
            response.setJackingForce(elem.getJackingForce());
            response.setJackingModeDesign(elem.getJackingModeDesign());
            response.setJackingEndDesign(elem.getJackingEndDesign());
            response.setCoilNo(elem.getCoilNo());
            response.setHeatId(elem.getHeatId());
            response.setAreaactual(elem.getAreaactual());
            response.setLengthActualCoil(elem.getLengthActualCoil());
            response.setEmodactual(elem.getEmodactual());
            response.setOutputGaugePressureRequired(elem.getOutputGaugePressureRequired());
            response.setAdjustmentFactor(elem.getAdjustmentFactor());
            response.setCalibrationDue(elem.getCalibrationDue());
            response.setRamModel(elem.getRamModel());
            response.setRamType(elem.getRamType());
            response.setFullyStrokedRamLength(elem.getFullyStrokedRamLength());
            response.setWedgePlateThickness(elem.getWedgePlateThickness());
            response.setJackingChairLength(elem.getJackingChairLength());
            response.setInputJackingForce(elem.getInputJackingForce());
            response.setPctMaximumJackingForce1(elem.getPctMaximumJackingForce1());
            response.setGaugePressureRequired1(elem.getGaugePressureRequired1());
            response.setPctMaximumJackingForce2(elem.getPctMaximumJackingForce2());
            response.setGaugePressureRequired2(elem.getGaugePressureRequired2());
            response.setPctMaximumJackingForce3(elem.getPctMaximumJackingForce3());
            response.setGaugePressureRequired3(elem.getGaugePressureRequired3());
            response.setPctMaximumJackingForce4(elem.getPctMaximumJackingForce4());
            response.setGaugePressureRequired4(elem.getGaugePressureRequired4());
            response.setPctMaximumJackingForce5(elem.getPctMaximumJackingForce5());
            response.setGaugePressureRequired5(elem.getGaugePressureRequired5());
            response.setInputGaugePressureRequired(elem.getInputGaugePressureRequired());
            response.setOutputJackingForce(elem.getOutputJackingForce());
            response.setAvgEadjusted(elem.getAvgEadjusted());
            response.setAvgEplanSeated(elem.getAvgEplanSeated());
            response.setAvgEadjustedEplanSeated(elem.getAvgEadjustedEplanSeated());
            response.setActualJackingForce(elem.getActualJackingForce());
            response.setCoilLengthUsed(elem.getCoilLengthUsed());
            response.setComparisonFactor(elem.getComparisonFactor());
            response.setDeadEndSeating(elem.getDeadEndSeating());
            response.setDeadEndSeatingPart(elem.getDeadEndSeatingPart());
            response.setDeadEndSeatingWhole(elem.getDeadEndSeatingWhole());
            response.setEadjusted(elem.getEadjusted());
            response.setEadjustedEplanSeated(elem.getEadjustedEplanSeated());
            response.setTendonDesignation(elem.getTendonDesignation());
            response.setProjectLogo(projectLogoImage);

        }
        return response;
    }

}
