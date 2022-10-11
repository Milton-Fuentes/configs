package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotDsrT236Dao;
import com.atser.tools.atserejb.model.DotDsrT236;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotDsrT236Pojo;
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
public class DotDsrT236ServiceImpl implements DotDsrT236Service, IBaseEJBException {

    @Inject
    private DotDsrT236Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotDsrT236> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotDsrT236> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotDsrT236> finalList = list(request);
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
    public DataTableWrapper<DotDsrT236> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotDsrT236> finalList = list(request);
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
        List<DotDsrT236Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotDsrT236_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 236/D3080 Test Method for Direct Shear Test of Soils Under Consolidated Drained Conditions", DotDsrT236Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotDsrT236ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotDsrT236Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotDsrT236> filterList = list(request);
        List<DotDsrT236Pojo> rList = new ArrayList<>();
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

    private DotDsrT236Pojo generatePojo(DotDsrT236 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotDsrT236Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotDsrT236Pojo populatePojo(DotDsrT236 elem) {
        DotDsrT236Pojo pojo = new DotDsrT236Pojo();
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
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setWaterContentLl(elem.getWaterContentLl());
        pojo.setWaterContentPl(elem.getWaterContentPl());
        pojo.setWaterContentPi(elem.getWaterContentPi());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setAngleInternalFriction(elem.getAngleInternalFriction());
        pojo.setCohesion(elem.getCohesion());
        pojo.setShearStrength(elem.getShearStrength());
        pojo.setSpecimenNo(elem.getSpecimenNo());
        pojo.setBoringNo(elem.getBoringNo());
        pojo.setDepth(elem.getDepth());
        pojo.setDescription(elem.getDescription());
        pojo.setDateTest(elem.getDateTest());
        pojo.setSpecimenType(elem.getSpecimenType());
        pojo.setPrep(elem.getPrep());
        pojo.setSpecificGravity(elem.getSpecificGravity());
        pojo.setUscsClass(elem.getUscsClass());
        pojo.setAashtoClass(elem.getAashtoClass());
        pojo.setBeforeTestDiameter(elem.getBeforeTestDiameter());
        pojo.setBeforeTestHeight(elem.getBeforeTestHeight());
        pojo.setBeforeTestWaterContent(elem.getBeforeTestWaterContent());
        pojo.setBeforeTestArea(elem.getBeforeTestArea());
        pojo.setBeforeTestVolume(elem.getBeforeTestVolume());
        pojo.setBeforeTestWetDensity(elem.getBeforeTestWetDensity());
        pojo.setBeforeTestDryDensity(elem.getBeforeTestDryDensity());
        pojo.setBeforeTestVolumeSolids(elem.getBeforeTestVolumeSolids());
        pojo.setBeforeTestVoidRatio(elem.getBeforeTestVoidRatio());
        pojo.setBeforeTestSaturation(elem.getBeforeTestSaturation());
        pojo.setConsolidationNoStages(elem.getConsolidationNoStages());
        pojo.setConsolidationSettlement(elem.getConsolidationSettlement());
        pojo.setShearNoStages(elem.getShearNoStages());
        pojo.setShearAvgNormalStress(elem.getShearAvgNormalStress());
        pojo.setShearMaxShearStress(elem.getShearMaxShearStress());
        pojo.setShearMaxShearForce(elem.getShearMaxShearForce());
        pojo.setShearMaxDisplacement(elem.getShearMaxDisplacement());
        pojo.setShearTravel(elem.getShearTravel());
        pojo.setShearAvgRate(elem.getShearAvgRate());
        pojo.setShearHeightChange(elem.getShearHeightChange());
        pojo.setShearFinalHeight(elem.getShearFinalHeight());
        pojo.setShearFinalVolume(elem.getShearFinalVolume());
        pojo.setAfterTestWaterContent(elem.getAfterTestWaterContent());
        pojo.setAfterTestDryDensity(elem.getAfterTestDryDensity());
        pojo.setAfterTestWetDensity(elem.getAfterTestWetDensity());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setAfterTestVoidRatio(elem.getAfterTestVoidRatio());
        pojo.setAfterTestSaturation(elem.getAfterTestSaturation());
        return pojo;
    }
}
