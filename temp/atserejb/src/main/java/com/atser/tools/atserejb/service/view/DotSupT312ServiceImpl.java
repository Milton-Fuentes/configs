package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotSupT312Dao;
import com.atser.tools.atserejb.model.DotSupT312;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSupT312Pojo;
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
public class DotSupT312ServiceImpl implements DotSupT312Service, IBaseEJBException {

    @Inject
    private DotSupT312Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSupT312> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSupT312> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSupT312> finalList = list(request);
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
    public DataTableWrapper<DotSupT312> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSupT312> finalList = list(request);
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
        List<DotSupT312Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSupT312_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 312 Superpave Gyratory Compactor", DotSupT312Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotSupT312ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSupT312Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSupT312> filterList = list(request);
        List<DotSupT312Pojo> rList = new ArrayList<>();
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

    private DotSupT312Pojo generatePojo(DotSupT312 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSupT312Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotSupT312Pojo populatePojo(DotSupT312 elem) {
        DotSupT312Pojo pojo = new DotSupT312Pojo();
        pojo.setCorrRelativeDensity2(elem.getCorrRelativeDensity2());
        pojo.setSpecimenNo2(elem.getSpecimenNo2());
        pojo.setHeightDesign(elem.getHeightDesign());
        pojo.setHeightMax(elem.getHeightMax());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
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
        pojo.setTestReportNo(elem.getTestReportNo());
        pojo.setAverage(elem.getAverage());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setTheoMaxSpecGrav(elem.getTheoMaxSpecGrav());
        pojo.setBulkSpecGrav(elem.getBulkSpecGrav());
        pojo.setHeightExtrudedSpecimen(elem.getHeightExtrudedSpecimen());
        pojo.setAvgUncorrRelativeDensity(elem.getAvgUncorrRelativeDensity());
        pojo.setAvgCorrRelativeDensity(elem.getAvgCorrRelativeDensity());
        pojo.setNo(elem.getNo());
        pojo.setTempComp(elem.getTempComp());
        pojo.setNoGyration(elem.getNoGyration());
        pojo.setHeight(elem.getHeight());
        pojo.setGyrationHeight(elem.getGyrationHeight());
        pojo.setSpecimenNo(elem.getSpecimenNo());
        pojo.setSpecimenDiameter(elem.getSpecimenDiameter());
        pojo.setMassSpecimen(elem.getMassSpecimen());
        pojo.setMaximumSg(elem.getMaximumSg());
        pojo.setVolumeSpecimen(elem.getVolumeSpecimen());
        pojo.setUncorrRelativeDensity(elem.getUncorrRelativeDensity());
        pojo.setBulkSpecgrav(elem.getBulkSpecgrav());
        pojo.setCorrRelativeDensity(elem.getCorrRelativeDensity());
        pojo.setNoGyration2(elem.getNoGyration2());
        pojo.setHeight2(elem.getHeight2());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        return pojo;
    }
}
