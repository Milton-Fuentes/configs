package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotFashC311Dao;
import com.atser.tools.atserejb.model.DotFashC311;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotFashC311Pojo;
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
public class DotFashC311ServiceImpl implements DotFashC311Service, IBaseEJBException {

    @Inject
    private DotFashC311Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotFashC311> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotFashC311> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotFashC311> finalList = list(request);
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
    public DataTableWrapper<DotFashC311> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotFashC311> finalList = list(request);
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
        List<DotFashC311Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotFashC311_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "null", DotFashC311Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotFashC311ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotFashC311Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotFashC311> filterList = list(request);
        List<DotFashC311Pojo> rList = new ArrayList<>();
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

    private DotFashC311Pojo generatePojo(DotFashC311 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotFashC311Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotFashC311Pojo populatePojo(DotFashC311 elem) {
        DotFashC311Pojo pojo = new DotFashC311Pojo();
        pojo.setControlCementRangeBetween(elem.getControlCementRangeBetween());
        pojo.setControlCementRangeSpec(elem.getControlCementRangeSpec());
        pojo.setControlCementRetestRequired(elem.getControlCementRetestRequired());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setFlyAshRangeBetween(elem.getFlyAshRangeBetween());
        pojo.setFlyAshRangeSpec(elem.getFlyAshRangeSpec());
        pojo.setFlyAshRetestRequired(elem.getFlyAshRetestRequired());
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
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setSamplesperset(elem.getSamplesperset());
        pojo.setAvgdays(elem.getAvgdays());
        pojo.setAverage(elem.getAverage());
        pojo.setLotNo(StringSupport.getString(elem.getLotNo()));
        pojo.setSublotNo(StringSupport.getString(elem.getSublotNo()));
        pojo.setTestReportNo(elem.getTestReportNo());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setCcmMassCement(elem.getCcmMassCement());
        pojo.setCcmMassStandardSand(elem.getCcmMassStandardSand());
        pojo.setCcmVolumeWater(elem.getCcmVolumeWater());
        pojo.setCcmIncreaseDiameter1(elem.getCcmIncreaseDiameter1());
        pojo.setCcmIncreaseDiameter2(elem.getCcmIncreaseDiameter2());
        pojo.setCcmIncreaseDiameter3(elem.getCcmIncreaseDiameter3());
        pojo.setCcmIncreaseDiameter4(elem.getCcmIncreaseDiameter4());
        pojo.setCcmFlowCement25Blows(elem.getCcmFlowCement25Blows());
        pojo.setVolMassCement(elem.getVolMassCement());
        pojo.setVolMassFlyAsh(elem.getVolMassFlyAsh());
        pojo.setVolMassStandardSand(elem.getVolMassStandardSand());
        pojo.setVolVolumeWaterRequired(elem.getVolVolumeWaterRequired());
        pojo.setVolVolumeWaterPct(elem.getVolVolumeWaterPct());
        pojo.setVolIncreaseDiameter1(elem.getVolIncreaseDiameter1());
        pojo.setVolIncreaseDiameter2(elem.getVolIncreaseDiameter2());
        pojo.setVolIncreaseDiameter3(elem.getVolIncreaseDiameter3());
        pojo.setVolIncreaseDiameter4(elem.getVolIncreaseDiameter4());
        pojo.setVolFlowFlyAshCement(elem.getVolFlowFlyAshCement());
        pojo.setVolSpec(elem.getVolSpec());
        pojo.setVolRetestRequired(elem.getVolRetestRequired());
        pojo.setAiFlyAshAverage(elem.getAiFlyAshAverage());
        pojo.setAiControlCementAverage(elem.getAiControlCementAverage());
        pojo.setAiStrengthActivityIndex(elem.getAiStrengthActivityIndex());
        pojo.setAiSpecMin(elem.getAiSpecMin());
        pojo.setAiResult(elem.getAiResult());
        pojo.setMcMassFlyAshAsReceived(elem.getMcMassFlyAshAsReceived());
        pojo.setMcMassDriedFlyAsh(elem.getMcMassDriedFlyAsh());
        pojo.setMcMoistureContent(elem.getMcMoistureContent());
        pojo.setMcSpecMax(elem.getMcSpecMax());
        pojo.setMcResult(elem.getMcResult());
        pojo.setIgnMassDriedFlyAsh(elem.getIgnMassDriedFlyAsh());
        pojo.setIgnMassIgnitedFlyAsh(elem.getIgnMassIgnitedFlyAsh());
        pojo.setIgnLossOnIgnition(elem.getIgnLossOnIgnition());
        pojo.setIgnSpecMax(elem.getIgnSpecMax());
        pojo.setIgnResult(elem.getIgnResult());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        return pojo;
    }
}