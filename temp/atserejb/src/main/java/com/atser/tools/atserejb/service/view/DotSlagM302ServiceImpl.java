package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotSlagM302Dao;
import com.atser.tools.atserejb.model.DotSlagM302;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSlagM302Pojo;
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
public class DotSlagM302ServiceImpl implements DotSlagM302Service, IBaseEJBException {

    @Inject
    private DotSlagM302Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSlagM302> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSlagM302> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSlagM302> finalList = list(request);
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
    public DataTableWrapper<DotSlagM302> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSlagM302> finalList = list(request);
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
        List<DotSlagM302Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSlagM302_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "M 302/C989 Standard Specification for Slag Cement for Use in Concrete and Mortars", DotSlagM302Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotSlagM302ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSlagM302Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSlagM302> filterList = list(request);
        List<DotSlagM302Pojo> rList = new ArrayList<>();
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

    private DotSlagM302Pojo generatePojo(DotSlagM302 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSlagM302Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotSlagM302Pojo populatePojo(DotSlagM302 elem) {
        DotSlagM302Pojo pojo = new DotSlagM302Pojo();
        pojo.setVolSpecMax(elem.getVolSpecMax());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
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
        pojo.setCcmVolumeWaterRequired(elem.getCcmVolumeWaterRequired());
        pojo.setCcmIncreaseDiameter1(elem.getCcmIncreaseDiameter1());
        pojo.setCcmIncreaseDiameter2(elem.getCcmIncreaseDiameter2());
        pojo.setCcmIncreaseDiameter3(elem.getCcmIncreaseDiameter3());
        pojo.setCcmIncreaseDiameter4(elem.getCcmIncreaseDiameter4());
        pojo.setCcmFlowCement(elem.getCcmFlowCement());
        pojo.setCcmSpecMin(elem.getCcmSpecMin());
        pojo.setCcmRetestRequired(elem.getCcmRetestRequired());
        pojo.setVolMassCement(elem.getVolMassCement());
        pojo.setVolMassSlag(elem.getVolMassSlag());
        pojo.setVolMassStandardSand(elem.getVolMassStandardSand());
        pojo.setVolVolumeWaterRequired(elem.getVolVolumeWaterRequired());
        pojo.setVolIncreaseDiameter1(elem.getVolIncreaseDiameter1());
        pojo.setVolIncreaseDiameter2(elem.getVolIncreaseDiameter2());
        pojo.setVolIncreaseDiameter3(elem.getVolIncreaseDiameter3());
        pojo.setVolIncreaseDiameter4(elem.getVolIncreaseDiameter4());
        pojo.setVolFlowSlagCement(elem.getVolFlowSlagCement());
        pojo.setVolSpecMin(elem.getVolSpecMin());
        pojo.setVolRetestRequired(elem.getVolRetestRequired());
        pojo.setSlagRangeBetween(elem.getSlagRangeBetween());
        pojo.setSlagRangeSpec(elem.getSlagRangeSpec());
        pojo.setSlagRetestRequired(elem.getSlagRetestRequired());
        pojo.setControlCementRangeBetween(elem.getControlCementRangeBetween());
        pojo.setControlCementRangeSpec(elem.getControlCementRangeSpec());
        pojo.setControlCementRetestRequired(elem.getControlCementRetestRequired());
        pojo.setAiSlagAverage(elem.getAiSlagAverage());
        pojo.setAiControlCementAverage(elem.getAiControlCementAverage());
        pojo.setAiStrengthActivityIndex(elem.getAiStrengthActivityIndex());
        pojo.setAiSpecMin(elem.getAiSpecMin());
        pojo.setAiResult(elem.getAiResult());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setCcmSpecMax(elem.getCcmSpecMax());
        return pojo;
    }
}
