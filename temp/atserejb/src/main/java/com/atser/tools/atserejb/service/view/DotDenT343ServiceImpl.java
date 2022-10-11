package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotDenT343Dao;
import com.atser.tools.atserejb.model.DotDenT343;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotDenT343Pojo;
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
public class DotDenT343ServiceImpl implements DotDenT343Service, IBaseEJBException {

    @Inject
    private DotDenT343Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotDenT343> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotDenT343> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotDenT343> finalList = list(request);
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
    public DataTableWrapper<DotDenT343> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotDenT343> finalList = list(request);
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
        List<DotDenT343Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotDenT343_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 343 Density of In-Place Hot Mix Asphalt (HMA) Pavement by Electronic Surface Contact Devices", DotDenT343Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotDenT343ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotDenT343Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotDenT343> filterList = list(request);
        List<DotDenT343Pojo> rList = new ArrayList<>();
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

    private DotDenT343Pojo generatePojo(DotDenT343 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotDenT343Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotDenT343Pojo populatePojo(DotDenT343 elem) {
        DotDenT343Pojo pojo = new DotDenT343Pojo();
        pojo.setDateCalibration(elem.getDateCalibration());
        pojo.setNoDensity(elem.getNoDensity());
        pojo.setSpecimenNo(elem.getSpecimenNo());
        pojo.setTestDate(elem.getTestDate());
        pojo.setLotSublotNo(elem.getLotSublotNo());
        pojo.setStation(elem.getStation());
        pojo.setTemperature(elem.getTemperature());
        pojo.setDensity(elem.getDensity());
        pojo.setOffset(elem.getOffset());
        pojo.setRandom(elem.getRandom());
        pojo.setCompaction(elem.getCompaction());
        pojo.setPassfail(elem.getPassfail());
        pojo.setInplaceReading1(elem.getInplaceReading1());
        pojo.setInplaceReading2(elem.getInplaceReading2());
        pojo.setInplaceReading3(elem.getInplaceReading3());
        pojo.setInplaceReading4(elem.getInplaceReading4());
        pojo.setInplaceReading5(elem.getInplaceReading5());
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
        pojo.setTechId(elem.getTechId());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setSiteIdentification(elem.getSiteIdentification());
        pojo.setTestLocation(elem.getTestLocation());
        pojo.setDeviceCalibrationData(elem.getDeviceCalibrationData());
        pojo.setAvgDensity(elem.getAvgDensity());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setResult(elem.getResult());
        pojo.setMake(elem.getMake());
        pojo.setModelNo(elem.getModelNo());
        pojo.setSerialNo(elem.getSerialNo());
        pojo.setGaugeNo(elem.getGaugeNo());
        pojo.setMixtureOffset(elem.getMixtureOffset());
        pojo.setMaxTheoSpecGrav(elem.getMaxTheoSpecGrav());
        pojo.setTargetLiftThickness(elem.getTargetLiftThickness());
        return pojo;
    }
}
