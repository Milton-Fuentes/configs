package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotNdenT355Dao;
import com.atser.tools.atserejb.model.DotNdenT355;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotNdenT355Pojo;
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
public class DotNdenT355ServiceImpl implements DotNdenT355Service, IBaseEJBException {

    @Inject
    private DotNdenT355Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotNdenT355> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotNdenT355> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotNdenT355> finalList = list(request);
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
    public DataTableWrapper<DotNdenT355> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotNdenT355> finalList = list(request);
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
        List<DotNdenT355Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotNdenT355_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 355/D2950 In-Place Density of Asphalt Mixtures by Nuclear Methods", DotNdenT355Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotNdenT355ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotNdenT355Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotNdenT355> filterList = list(request);
        List<DotNdenT355Pojo> rList = new ArrayList<>();
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

    private DotNdenT355Pojo generatePojo(DotNdenT355 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotNdenT355Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotNdenT355Pojo populatePojo(DotNdenT355 elem) {
        DotNdenT355Pojo pojo = new DotNdenT355Pojo();
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
        pojo.setTechId(elem.getTechId());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setMixDesignation(elem.getMixDesignation());
        pojo.setCategory(elem.getCategory());
        pojo.setCompspecLo(elem.getCompspecLo());
        pojo.setCompspecHi(elem.getCompspecHi());
        pojo.setCompspec(elem.getCompspec());
        pojo.setTestinstr(elem.getTestinstr());
        pojo.setSerialno(elem.getSerialno());
        pojo.setRefCount(elem.getRefCount());
        pojo.setTestMethod(elem.getTestMethod());
        pojo.setTheomax(elem.getTheomax());
        pojo.setStdctdensity(elem.getStdctdensity());
        pojo.setStdctmoisture(elem.getStdctmoisture());
        pojo.setTesttype(elem.getTesttype());
        pojo.setAmbienttemp(elem.getAmbienttemp());
        pojo.setLayerthick(elem.getLayerthick());
        pojo.setWeather(elem.getWeather());
        pojo.setIsretest(elem.getIsretest());
        pojo.setGeneralTestloc(elem.getGeneralTestloc());
        pojo.setRptFilename(elem.getRptFilename());
        pojo.setPlaceLoc(elem.getPlaceLoc());
        pojo.setSourceMaterial(elem.getSourceMaterial());
        pojo.setCompEquipment(elem.getCompEquipment());
        pojo.setGrade(elem.getGrade());
        pojo.setRemarks(elem.getRemarks());
        pojo.setForeman(elem.getForeman());
        pojo.setProbeDepth(elem.getProbeDepth());
        pojo.setRandomSheetNo(elem.getRandomSheetNo());
        pojo.setSpecsection(elem.getSpecsection());
        pojo.setCategoryno(elem.getCategoryno());
        pojo.setMixDesignation2(elem.getMixDesignation2());
        pojo.setPassdrumv(elem.getPassdrumv());
        pojo.setPassdrumnv(elem.getPassdrumnv());
        pojo.setPasspneutired(elem.getPasspneutired());
        pojo.setMaterialdesc(elem.getMaterialdesc());
        pojo.setMaterialtemp(elem.getMaterialtemp());
        pojo.setDensityType(StringSupport.getString(elem.getDensityType()));
        pojo.setDailyTonnage(elem.getDailyTonnage());
        pojo.setSplitno(elem.getSplitno());
        pojo.setSplitsample(StringSupport.getString(elem.getSplitsample()));
        pojo.setContractName(elem.getContractName());
        pojo.setPdaReportNo(elem.getPdaReportNo());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setNumPoints(StringSupport.getString(elem.getNumPoints()));
        pojo.setMileage(elem.getMileage());
        pojo.setGaugeModelNo(elem.getGaugeModelNo());
        pojo.setGaugeNo(elem.getGaugeNo());
        pojo.setDateCalibration(elem.getDateCalibration());
        pojo.setCorrFactor(elem.getCorrFactor());
        pojo.setTestDuration(elem.getTestDuration());
        pojo.setFieldTestNo(elem.getFieldTestNo());
        pojo.setCourselift(elem.getCourselift());
        pojo.setDensityCt(elem.getDensityCt());
        pojo.setDrRatio(elem.getDrRatio());
        pojo.setFieldSpecgrav(elem.getFieldSpecgrav());
        pojo.setCorrectionFactor(elem.getCorrectionFactor());
        pojo.setAdjFieldsg(elem.getAdjFieldsg());
        pojo.setPctRelcompaction(elem.getPctRelcompaction());
        pojo.setPassfail(elem.getPassfail());
        pojo.setDenIsretest(StringSupport.getString(elem.getDenIsretest()));
        pojo.setRetestTestNo(elem.getRetestTestNo());
        pojo.setDenRemarks(elem.getDenRemarks());
        pojo.setBulkdensity(elem.getBulkdensity());
        pojo.setWetdensity(elem.getWetdensity());
        pojo.setCompaction(elem.getCompaction());
        pojo.setDensity1(elem.getDensity1());
        pojo.setDensity2(elem.getDensity2());
        pojo.setDensity3(elem.getDensity3());
        pojo.setDensity4(elem.getDensity4());
        pojo.setFieldTestno(elem.getFieldTestno());
        pojo.setRefLine(elem.getRefLine());
        pojo.setBegStat(elem.getBegStat());
        pojo.setEndStat(elem.getEndStat());
        pojo.setRandom1(elem.getRandom1());
        pojo.setRandom2(elem.getRandom2());
        pojo.setTestStation(elem.getTestStation());
        pojo.setTestOffset(elem.getTestOffset());
        pojo.setSuperceded(StringSupport.getString(elem.getSuperceded()));
        pojo.setBegStn(elem.getBegStn());
        pojo.setLotLength(elem.getLotLength());
        pojo.setTestLocation(elem.getTestLocation());
        pojo.setLotWidth(elem.getLotWidth());
        pojo.setRetestremarks(elem.getRetestremarks());
        pojo.setLocation(elem.getLocation());
        pojo.setHmaThickness(elem.getHmaThickness());
        pojo.setSublot(elem.getSublot());
        pojo.setGaugeRotation(elem.getGaugeRotation());
        pojo.setWetDensity1(elem.getWetDensity1());
        pojo.setWetDensity2(elem.getWetDensity2());
        pojo.setDiffReading(elem.getDiffReading());
        pojo.setTestResults(elem.getTestResults());
        return pojo;
    }
}
