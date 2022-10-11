package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotSpgT166Dao;
import com.atser.tools.atserejb.model.DotSpgT166;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSpgT166Pojo;
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
public class DotSpgT166ServiceImpl implements DotSpgT166Service, IBaseEJBException {

    @Inject
    private DotSpgT166Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSpgT166> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSpgT166> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSpgT166> finalList = list(request);
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
    public DataTableWrapper<DotSpgT166> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSpgT166> finalList = list(request);
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
        List<DotSpgT166Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSpgT166_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 166 Bulk Specific Gravity of Compacted HMA", DotSpgT166Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotSpgT166ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSpgT166Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSpgT166> filterList = list(request);
        List<DotSpgT166Pojo> rList = new ArrayList<>();
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

    private DotSpgT166Pojo generatePojo(DotSpgT166 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSpgT166Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotSpgT166Pojo populatePojo(DotSpgT166 elem) {
        DotSpgT166Pojo pojo = new DotSpgT166Pojo();
        pojo.setTrialNo(elem.getTrialNo());
        pojo.setVfa(elem.getVfa());
        pojo.setVolume(elem.getVolume());
        pojo.setAbsorption(elem.getAbsorption());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setCorrectedBsg(elem.getCorrectedBsg());
        pojo.setPctRelCompaction(elem.getPctRelCompaction());
        pojo.setAirvoids(elem.getAirvoids());
        pojo.setVma(elem.getVma());
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
        pojo.setCategory(elem.getCategory());
        pojo.setMixDesignation(elem.getMixDesignation());
        pojo.setSampleLocation(elem.getSampleLocation());
        pojo.setTheomax(elem.getTheomax());
        pojo.setBulkspecgrav(elem.getBulkspecgrav());
        pojo.setAggpercentwt(elem.getAggpercentwt());
        pojo.setAvgCorrected(elem.getAvgCorrected());
        pojo.setAvgCorrectedBsg(elem.getAvgCorrectedBsg());
        pojo.setAvgPctRelCompaction(elem.getAvgPctRelCompaction());
        pojo.setAvgAirvoids(elem.getAvgAirvoids());
        pojo.setAvgVma(elem.getAvgVma());
        pojo.setMaterialdesc(elem.getMaterialdesc());
        pojo.setGrade(elem.getGrade());
        pojo.setLottman(elem.getLottman());
        pojo.setLottmanSpecMin(elem.getLottmanSpecMin());
        pojo.setHveem(elem.getHveem());
        pojo.setHveemSpecMin(elem.getHveemSpecMin());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setSplitno(elem.getSplitno());
        pojo.setSplitsample(StringSupport.getString(elem.getSplitsample()));
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setRemarks(elem.getRemarks());
        pojo.setTestReportNo(elem.getTestReportNo());
        pojo.setMassSample(elem.getMassSample());
        pojo.setMassSfcdry(elem.getMassSfcdry());
        pojo.setMassSampWater(elem.getMassSampWater());
        pojo.setBulkSpecgrav(elem.getBulkSpecgrav());
        pojo.setCorrection(elem.getCorrection());
        return pojo;
    }
}
