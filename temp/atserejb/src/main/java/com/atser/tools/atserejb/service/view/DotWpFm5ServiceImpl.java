package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotWpFm5Dao;
import com.atser.tools.atserejb.model.DotWpFm5;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotWpFm5Pojo;
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
public class DotWpFm5ServiceImpl implements DotWpFm5Service, IBaseEJBException {

    @Inject
    private DotWpFm5Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotWpFm5> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotWpFm5> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotWpFm5> finalList = list(request);
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
    public DataTableWrapper<DotWpFm5> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotWpFm5> finalList = list(request);
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
        List<DotWpFm5Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotWpFm5_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "FM 5-565 Water Permeability of Compacted HMA", DotWpFm5Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotWpFm5ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotWpFm5Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotWpFm5> filterList = list(request);
        List<DotWpFm5Pojo> rList = new ArrayList<>();
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

    private DotWpFm5Pojo generatePojo(DotWpFm5 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotWpFm5Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotWpFm5Pojo populatePojo(DotWpFm5 elem) {
        DotWpFm5Pojo pojo = new DotWpFm5Pojo();
        pojo.setTemperatureWaterWhole(elem.getTemperatureWaterWhole());
        pojo.setTemperatureWaterRemain(elem.getTemperatureWaterRemain());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setTraceNo(elem.getTraceNo());
        pojo.setCmLocation(elem.getCmLocation());
        pojo.setTestNo(elem.getTestNo());
        pojo.setActive(StringSupport.getString(elem.getActive()));
        pojo.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
        pojo.setFunction(elem.getFunction());
        pojo.setAsphaltcement(elem.getAsphaltcement());
        pojo.setAdditive(elem.getAdditive());
        pojo.setTestNoLink(StringSupport.getString(elem.getTestNoLink()));
        pojo.setSampleTcn(elem.getSampleTcn());
        pojo.setTechId(elem.getTechId());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setHeightTopUpperTimingMark(elem.getHeightTopUpperTimingMark());
        pojo.setHeightTopLowerTimingMark(elem.getHeightTopLowerTimingMark());
        pojo.setInsideDiameterGradCyl1(elem.getInsideDiameterGradCyl1());
        pojo.setInsideDiameterGradCyl2(elem.getInsideDiameterGradCyl2());
        pojo.setInsideAreaGradCyl(elem.getInsideAreaGradCyl());
        pojo.setHeightTestSpecimen1(elem.getHeightTestSpecimen1());
        pojo.setHeightTestSpecimen2(elem.getHeightTestSpecimen2());
        pojo.setHeightTestSpecimen3(elem.getHeightTestSpecimen3());
        pojo.setDiffHeightMeasurements(elem.getDiffHeightMeasurements());
        pojo.setAvgThicknessTestSpecimen(elem.getAvgThicknessTestSpecimen());
        pojo.setDiameterTestSpecimen1(elem.getDiameterTestSpecimen1());
        pojo.setDiameterTestSpecimen2(elem.getDiameterTestSpecimen2());
        pojo.setAvgAreaTestSpecimen(elem.getAvgAreaTestSpecimen());
        pojo.setInitialHeadAcrossSpecimen(elem.getInitialHeadAcrossSpecimen());
        pojo.setFinalHeadAcrossSpecimen(elem.getFinalHeadAcrossSpecimen());
        pojo.setElapsedTime1(elem.getElapsedTime1());
        pojo.setElapsedTime2(elem.getElapsedTime2());
        pojo.setElapsedTime3(elem.getElapsedTime3());
        pojo.setDiffBetweenRun1And3(elem.getDiffBetweenRun1And3());
        pojo.setTemperatureWater(elem.getTemperatureWater());
        pojo.setTempCorrViscocityWater(elem.getTempCorrViscocityWater());
        pojo.setCoefficientPermeability1(elem.getCoefficientPermeability1());
        pojo.setCoefficientPermeability2(elem.getCoefficientPermeability2());
        pojo.setCoefficientPermeability3(elem.getCoefficientPermeability3());
        pojo.setAvgCoefficientPermeability(elem.getAvgCoefficientPermeability());
        pojo.setSpecification(elem.getSpecification());
        pojo.setPermeabilityRequirement(elem.getPermeabilityRequirement());
        pojo.setResult(elem.getResult());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        pojo.setMixDesignNo(elem.getMixDesignNo());
        return pojo;
    }
}
