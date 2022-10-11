package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotGmmT209Dao;
import com.atser.tools.atserejb.model.DotGmmT209;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotGmmT209Pojo;
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
public class DotGmmT209ServiceImpl implements DotGmmT209Service, IBaseEJBException {

    @Inject
    private DotGmmT209Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotGmmT209> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotGmmT209> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotGmmT209> finalList = list(request);
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
    public DataTableWrapper<DotGmmT209> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotGmmT209> finalList = list(request);
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
        List<DotGmmT209Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotGmmT209_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 209/D2041 Theoretical Maximum Specific Gravity (Gmm) and Density of Hot Mix Asphalt (HMA)", DotGmmT209Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotGmmT209ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotGmmT209Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotGmmT209> filterList = list(request);
        List<DotGmmT209Pojo> rList = new ArrayList<>();
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

    private DotGmmT209Pojo generatePojo(DotGmmT209 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotGmmT209Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotGmmT209Pojo populatePojo(DotGmmT209 elem) {
        DotGmmT209Pojo pojo = new DotGmmT209Pojo();
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
        pojo.setUnitWeight(elem.getUnitWeight());
        pojo.setTrialNo(elem.getTrialNo());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setReportType(elem.getReportType());
        pojo.setSurfaceDryWt(elem.getSurfaceDryWt());
        pojo.setVolume(elem.getVolume());
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
        pojo.setTestTemperature(elem.getTestTemperature());
        pojo.setAvemaxspecgrav(elem.getAvemaxspecgrav());
        pojo.setSamplelocation(elem.getSamplelocation());
        pojo.setBulkspecgrav(elem.getBulkspecgrav());
        pojo.setBulkssd(elem.getBulkssd());
        pojo.setAppspecgrav(elem.getAppspecgrav());
        pojo.setReport(elem.getReport());
        pojo.setMaterialdesc(elem.getMaterialdesc());
        pojo.setGeneralTestloc(elem.getGeneralTestloc());
        pojo.setGrade(elem.getGrade());
        pojo.setRemarks(elem.getRemarks());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setSplitno(elem.getSplitno());
        pojo.setSplitsample(StringSupport.getString(elem.getSplitsample()));
        pojo.setContractName(elem.getContractName());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setTestReportNo(elem.getTestReportNo());
        pojo.setSublotNo(StringSupport.getString(elem.getSublotNo()));
        pojo.setDepartLab(elem.getDepartLab());
        pojo.setArriveSite(elem.getArriveSite());
        pojo.setLunchHours(elem.getLunchHours());
        pojo.setLunchMins(elem.getLunchMins());
        pojo.setDepartSite(elem.getDepartSite());
        pojo.setArriveLab(elem.getArriveLab());
        pojo.setTotalHours(elem.getTotalHours());
        pojo.setTechnicianHoursOvertime(StringSupport.getString(elem.getTechnicianHoursOvertime()));
        pojo.setAveUnitWeight(elem.getAveUnitWeight());
        pojo.setLotNo(StringSupport.getString(elem.getLotNo()));
        pojo.setWtsampleAir(elem.getWtsampleAir());
        pojo.setWtcontainerWater(elem.getWtcontainerWater());
        pojo.setWtcontainerSampleWater(elem.getWtcontainerSampleWater());
        pojo.setTestTemp(elem.getTestTemp());
        pojo.setRfactor(elem.getRfactor());
        pojo.setCorrfactorthermalexp(elem.getCorrfactorthermalexp());
        pojo.setMaxspecgrav(elem.getMaxspecgrav());
        pojo.setAc(elem.getAc());
        pojo.setSpecgrav(elem.getSpecgrav());
        pojo.setPavingdry(elem.getPavingdry());
        pojo.setPavingcalib(elem.getPavingcalib());
        pojo.setPavingpycnom(elem.getPavingpycnom());
        pojo.setPavingsurface(elem.getPavingsurface());
        pojo.setResultgt(elem.getResultgt());
        pojo.setResultgtc(elem.getResultgtc());
        pojo.setBowlno(elem.getBowlno());
        pojo.setBowlair(elem.getBowlair());
        pojo.setBowlwater(elem.getBowlwater());
        pojo.setSamplebowlair(elem.getSamplebowlair());
        pojo.setSamplebowlwater(elem.getSamplebowlwater());
        pojo.setDrysample(elem.getDrysample());
        pojo.setSampleair(elem.getSampleair());
        pojo.setSamplewater(elem.getSamplewater());
        pojo.setGmm(elem.getGmm());
        pojo.setGs(elem.getGs());
        pojo.setRawgse(elem.getRawgse());
        return pojo;
    }
}
