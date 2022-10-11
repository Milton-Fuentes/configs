/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotConfreezeAT166Dao;
import com.atser.tools.atserejb.model.DotConfreezeAT166;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConfreezeAT166Pojo;
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
public class DotConfreezeAT166ServiceImpl implements DotConfreezeAT166Service, IBaseEJBException {

    @Inject
    private DotConfreezeAT166Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotConfreezeAT166> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConfreezeAT166> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConfreezeAT166> finalList = list(request);
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
    public DataTableWrapper<DotConfreezeAT166> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConfreezeAT166> finalList = list(request);
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
        List<DotConfreezeAT166Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotConfreezeAT166_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 161/C666 Concrete Resistance to Rapid Freezing and Thawing", DotConfreezeAT166Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotConfreezeAT166ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConfreezeAT166Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConfreezeAT166> filterList = list(request);
        List<DotConfreezeAT166Pojo> rList = new ArrayList<>();
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

    private DotConfreezeAT166Pojo generatePojo(DotConfreezeAT166 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConfreezeAT166Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotConfreezeAT166Pojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setPeReview(elem.getPeReview());
            response.setTestClosed(elem.getTestClosed());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));
            
            response.setTestNo(elem.getTestNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setpNumber(elem.getpNumber());
            response.setpName(elem.getpName());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setLabname(elem.getLabname());
            response.setStatus(elem.getStatus());
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestingTech(elem.getTestingTech());
            response.setRemarks(elem.getRemarks());
            response.setEquipList(elem.getEquipList());
            response.setTechId(elem.getTechId());
            response.setFunction(elem.getFunction());
            response.setMixdesignno(elem.getMixdesignno());
            response.setSampleNo(elem.getSampleNo());
            response.setTestResults(elem.getTestResults());
            response.setDeltam2Result(elem.getDeltam2Result());
            response.setDeltam1Result(elem.getDeltam1Result());
            response.setPassfail(elem.getPassfail());
            response.setSpecMax(elem.getSpecMax());
            response.setSpecMin(elem.getSpecMin());
            response.setCuringDuration(elem.getCuringDuration());
            response.setLabPrep(elem.getLabPrep());
            response.setDurabilityFactorAvg(elem.getDurabilityFactorAvg());
            response.setDurabilityFactor2(elem.getDurabilityFactor2());
            response.setRelativeDynamicModulus2(elem.getRelativeDynamicModulus2());
            response.setDurabilityFactor(elem.getDurabilityFactor());
            response.setSpecifiedCycleExpTerminated(elem.getSpecifiedCycleExpTerminated());
            response.setRelativeDynamicModulus(elem.getRelativeDynamicModulus());
            response.setCyclesExposureTerminated2(elem.getCyclesExposureTerminated2());
            response.setDate14dayCurePeriod(elem.getDate14dayCurePeriod());
            response.setHumidityPct(elem.getHumidityPct());
            response.setTemperature(elem.getTemperature());
            response.setSampleDimensions(elem.getSampleDimensions());
            response.setFreezeTemp(elem.getFreezeTemp());
            response.setThawTemp(elem.getThawTemp());
            response.setTimeToFreeze(elem.getTimeToFreeze());
            response.setHoldTime(elem.getHoldTime());
            response.setTimeToThaw(elem.getTimeToThaw());
            response.setNumberOfCycles(elem.getNumberOfCycles());
            response.setDurationPerCycle(elem.getDurationPerCycle());
            response.setTotalDuration(elem.getTotalDuration());
            response.setLs(elem.getLs());
            response.setCyclesExposureTerminated(elem.getCyclesExposureTerminated());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSampleTestno(elem.getSampleTestno());
            response.setSampleTcn(elem.getSampleTcn());

            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
