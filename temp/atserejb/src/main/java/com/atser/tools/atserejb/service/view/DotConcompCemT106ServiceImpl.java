package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotConcompCemT106Dao;
import com.atser.tools.atserejb.model.DotConcompCemT106;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConcompCemT106Pojo;
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
public class DotConcompCemT106ServiceImpl implements DotConcompCemT106Service, IBaseEJBException {

    @Inject
    private DotConcompCemT106Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotConcompCemT106> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConcompCemT106> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConcompCemT106> finalList = list(request);
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
    public DataTableWrapper<DotConcompCemT106> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConcompCemT106> finalList = list(request);
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
        List<DotConcompCemT106Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotConcompCemT106_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 106/C109 Compressive Strength of Hydraulic Cement Mortars", DotConcompCemT106Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotConcompCemT106ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConcompCemT106Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConcompCemT106> filterList = list(request);
        List<DotConcompCemT106Pojo> rList = new ArrayList<>();
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

    private DotConcompCemT106Pojo generatePojo(DotConcompCemT106 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConcompCemT106Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotConcompCemT106Pojo populatePojo(DotConcompCemT106 elem) {
        DotConcompCemT106Pojo pojo = new DotConcompCemT106Pojo();
        pojo.setRetestRequired(elem.getRetestRequired());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setAverage(elem.getAverage());
        pojo.setLotNo(StringSupport.getString(elem.getLotNo()));
        pojo.setSublotNo(StringSupport.getString(elem.getSublotNo()));
        pojo.setTestReportNo(elem.getTestReportNo());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setMassCement(elem.getMassCement());
        pojo.setMassStandardSand(elem.getMassStandardSand());
        pojo.setVolumeWater(elem.getVolumeWater());
        pojo.setSampleidno(elem.getSampleidno());
        pojo.setCylinderNo(elem.getCylinderNo());
        pojo.setTestage(elem.getTestage());
        pojo.setDatetest(DateSupport.formatDate(elem.getDatetest(), DateSupport.FORMAT_US));
        pojo.setLength(elem.getLength());
        pojo.setWidth(elem.getWidth());
        pojo.setDepth(elem.getDepth());
        pojo.setMaximumload(elem.getMaximumload());
        pojo.setRequiredstrength(elem.getRequiredstrength());
        pojo.setCompressStrength(elem.getCompressStrength());
        pojo.setTech(elem.getTech());
        pojo.setArea(elem.getArea());
        pojo.setDiscard(StringSupport.getString(elem.getDiscard()));
        pojo.setResultTestage(elem.getResultTestage());
        pojo.setResultSpecMin(elem.getResultSpecMin());
        pojo.setResultSpecMax(elem.getResultSpecMax());
        pojo.setPassfail(elem.getPassfail());
        pojo.setReportStampType(elem.getReportStampType());
        pojo.setResultAverage(elem.getResultAverage());
        pojo.setRangeBetween(elem.getRangeBetween());
        pojo.setRangeSpec(elem.getRangeSpec());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        pojo.setTraceNo(elem.getTraceNo());
        pojo.setCmLocation(elem.getCmLocation());
        pojo.setTestNo(elem.getTestNo());
        pojo.setActive(StringSupport.getString(elem.getActive()));
        pojo.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
        pojo.setMixdesignno(StringSupport.getString(elem.getMixdesignno()));
        pojo.setFunction(elem.getFunction());
        pojo.setTestNoLink(StringSupport.getString(elem.getTestNoLink()));
        pojo.setSampleTcn(elem.getSampleTcn());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setDraft(elem.getDraft());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setSamplesperset(elem.getSamplesperset());
        pojo.setAvgdays(elem.getAvgdays());
        return pojo;
    }
}
