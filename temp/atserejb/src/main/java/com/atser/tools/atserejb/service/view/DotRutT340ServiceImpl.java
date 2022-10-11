package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotRutT340Dao;
import com.atser.tools.atserejb.model.DotRutT340;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotRutT340Pojo;
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
public class DotRutT340ServiceImpl implements DotRutT340Service, IBaseEJBException {

    @Inject
    private DotRutT340Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotRutT340> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotRutT340> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotRutT340> finalList = list(request);
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
    public DataTableWrapper<DotRutT340> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotRutT340> finalList = list(request);
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
        List<DotRutT340Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotRutT340_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 340 Rutting Susceptibility of Hot Mix Asphalt (HMA) Using the Asphalt Pavement Analyzer (APA)", DotRutT340Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotRutT340ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotRutT340Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotRutT340> filterList = list(request);
        List<DotRutT340Pojo> rList = new ArrayList<>();
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

    private DotRutT340Pojo generatePojo(DotRutT340 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotRutT340Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotRutT340Pojo populatePojo(DotRutT340 elem) {
        DotRutT340Pojo pojo = new DotRutT340Pojo();
        pojo.setRightDepthGaugeReading2(elem.getRightDepthGaugeReading2());
        pojo.setRightDepthGaugeReading3(elem.getRightDepthGaugeReading3());
        pojo.setRightDepthGaugeReading4(elem.getRightDepthGaugeReading4());
        pojo.setRightDepthGaugeReading5(elem.getRightDepthGaugeReading5());
        pojo.setRightAverageDepth(elem.getRightAverageDepth());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setCenterAvgAirVoidsPct(elem.getCenterAvgAirVoidsPct());
        pojo.setRightSampleId(elem.getRightSampleId());
        pojo.setRightFrontGmb(elem.getRightFrontGmb());
        pojo.setRightBackGmb(elem.getRightBackGmb());
        pojo.setRightFrontGmm(elem.getRightFrontGmm());
        pojo.setRightBackGmm(elem.getRightBackGmm());
        pojo.setRightFrontAirVoidPct(elem.getRightFrontAirVoidPct());
        pojo.setRightBackAirVoidPct(elem.getRightBackAirVoidPct());
        pojo.setRightAvgAirVoidsPct(elem.getRightAvgAirVoidsPct());
        pojo.setOverageAverageRutDepth(elem.getOverageAverageRutDepth());
        pojo.setStandardDeviation(elem.getStandardDeviation());
        pojo.setLeftFinalDepthGaugeRead1(elem.getLeftFinalDepthGaugeRead1());
        pojo.setLeftFinalDepthGaugeRead2(elem.getLeftFinalDepthGaugeRead2());
        pojo.setLeftFinalDepthGaugeRead3(elem.getLeftFinalDepthGaugeRead3());
        pojo.setLeftFinalDepthGaugeRead4(elem.getLeftFinalDepthGaugeRead4());
        pojo.setLeftFinalDepthGaugeRead5(elem.getLeftFinalDepthGaugeRead5());
        pojo.setLeftFinalAverageDepth(elem.getLeftFinalAverageDepth());
        pojo.setCenterFinalDepthGaugeRead1(elem.getCenterFinalDepthGaugeRead1());
        pojo.setCenterFinalDepthGaugeRead2(elem.getCenterFinalDepthGaugeRead2());
        pojo.setCenterFinalDepthGaugeRead3(elem.getCenterFinalDepthGaugeRead3());
        pojo.setCenterFinalDepthGaugeRead4(elem.getCenterFinalDepthGaugeRead4());
        pojo.setCenterFinalDepthGaugeRead5(elem.getCenterFinalDepthGaugeRead5());
        pojo.setCenterFinalAverageDepth(elem.getCenterFinalAverageDepth());
        pojo.setRightFinalDepthGaugeRead1(elem.getRightFinalDepthGaugeRead1());
        pojo.setRightFinalDepthGaugeRead2(elem.getRightFinalDepthGaugeRead2());
        pojo.setRightFinalDepthGaugeRead3(elem.getRightFinalDepthGaugeRead3());
        pojo.setRightFinalDepthGaugeRead4(elem.getRightFinalDepthGaugeRead4());
        pojo.setRightFinalDepthGaugeRead5(elem.getRightFinalDepthGaugeRead5());
        pojo.setRightFinalAverageDepth(elem.getRightFinalAverageDepth());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setLeftBackSampleId(elem.getLeftBackSampleId());
        pojo.setCenterBackSampleId(elem.getCenterBackSampleId());
        pojo.setRightBackSampleId(elem.getRightBackSampleId());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setPassfail(elem.getPassfail());
        pojo.setLeftFrontSampleLocation(elem.getLeftFrontSampleLocation());
        pojo.setLeftBackSampleLocation(elem.getLeftBackSampleLocation());
        pojo.setCenterFrontSampleLocation(elem.getCenterFrontSampleLocation());
        pojo.setCenterBackSampleLocation(elem.getCenterBackSampleLocation());
        pojo.setRightFrontSampleLocation(elem.getRightFrontSampleLocation());
        pojo.setRightBackSampleLocation(elem.getRightBackSampleLocation());
        pojo.setSpecimenNo(elem.getSpecimenNo());
        pojo.setLeftStrokeCount(elem.getLeftStrokeCount());
        pojo.setLeftTemperaturef(elem.getLeftTemperaturef());
        pojo.setLeftTemperaturec(elem.getLeftTemperaturec());
        pojo.setLeftDepthGaugeReading1(elem.getLeftDepthGaugeReading1());
        pojo.setLeftDepthGaugeReading2(elem.getLeftDepthGaugeReading2());
        pojo.setLeftDepthGaugeReading3(elem.getLeftDepthGaugeReading3());
        pojo.setLeftDepthGaugeReading4(elem.getLeftDepthGaugeReading4());
        pojo.setLeftDepthGaugeReading5(elem.getLeftDepthGaugeReading5());
        pojo.setLeftAverageDepth(elem.getLeftAverageDepth());
        pojo.setCenterStrokeCount(elem.getCenterStrokeCount());
        pojo.setCenterTemperaturef(elem.getCenterTemperaturef());
        pojo.setCenterTemperaturec(elem.getCenterTemperaturec());
        pojo.setCenterDepthGaugeReading1(elem.getCenterDepthGaugeReading1());
        pojo.setCenterDepthGaugeReading2(elem.getCenterDepthGaugeReading2());
        pojo.setCenterDepthGaugeReading3(elem.getCenterDepthGaugeReading3());
        pojo.setCenterDepthGaugeReading4(elem.getCenterDepthGaugeReading4());
        pojo.setCenterDepthGaugeReading5(elem.getCenterDepthGaugeReading5());
        pojo.setCenterAverageDepth(elem.getCenterAverageDepth());
        pojo.setRightStrokeCount(elem.getRightStrokeCount());
        pojo.setRightTemperaturef(elem.getRightTemperaturef());
        pojo.setRightTemperaturec(elem.getRightTemperaturec());
        pojo.setRightDepthGaugeReading1(elem.getRightDepthGaugeReading1());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        pojo.setMixDesignNo(elem.getMixDesignNo());
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
        pojo.setTypeOfSpecimen(elem.getTypeOfSpecimen());
        pojo.setMethodOfMeasurement(elem.getMethodOfMeasurement());
        pojo.setLeftSampleId(elem.getLeftSampleId());
        pojo.setLeftFrontGmb(elem.getLeftFrontGmb());
        pojo.setLeftBackGmb(elem.getLeftBackGmb());
        pojo.setLeftFrontGmm(elem.getLeftFrontGmm());
        pojo.setLeftBackGmm(elem.getLeftBackGmm());
        pojo.setLeftFrontAirVoidPct(elem.getLeftFrontAirVoidPct());
        pojo.setLeftBackAirVoidPct(elem.getLeftBackAirVoidPct());
        pojo.setLeftAvgAirVoidsPct(elem.getLeftAvgAirVoidsPct());
        pojo.setCenterSampleId(elem.getCenterSampleId());
        pojo.setCenterFrontGmb(elem.getCenterFrontGmb());
        pojo.setCenterBackGmb(elem.getCenterBackGmb());
        pojo.setCenterFrontGmm(elem.getCenterFrontGmm());
        pojo.setCenterBackGmm(elem.getCenterBackGmm());
        pojo.setCenterFrontAirVoidPct(elem.getCenterFrontAirVoidPct());
        pojo.setCenterBackAirVoidPct(elem.getCenterBackAirVoidPct());
        return pojo;
    }
}
