package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotTsrT283Dao;
import com.atser.tools.atserejb.model.DotTsrT283;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotTsrT283Pojo;
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
public class DotTsrT283ServiceImpl implements DotTsrT283Service, IBaseEJBException {

    @Inject
    private DotTsrT283Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotTsrT283> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotTsrT283> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotTsrT283> finalList = list(request);
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
    public DataTableWrapper<DotTsrT283> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotTsrT283> finalList = list(request);
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
        List<DotTsrT283Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotTsrT283_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 283 Resistance of Compacted Asphalt Mixtures to Moisture-Induced Damage", DotTsrT283Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotTsrT283ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotTsrT283Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotTsrT283> filterList = list(request);
        List<DotTsrT283Pojo> rList = new ArrayList<>();
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

    private DotTsrT283Pojo generatePojo(DotTsrT283 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotTsrT283Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotTsrT283Pojo populatePojo(DotTsrT283 elem) {
        DotTsrT283Pojo pojo = new DotTsrT283Pojo();
        pojo.setFreezeLoad(elem.getFreezeLoad());
        pojo.setFreezeWetStrength(elem.getFreezeWetStrength());
        pojo.setFreezePctSaturation(elem.getFreezePctSaturation());
        pojo.setFreezePctSwell(elem.getFreezePctSwell());
        pojo.setWaterDamage(elem.getWaterDamage());
        pojo.setAggDamage(elem.getAggDamage());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setAvgDryWtsubmerged(elem.getAvgDryWtsubmerged());
        pojo.setAvgDrySsdwt(elem.getAvgDrySsdwt());
        pojo.setAvgDryVolume(elem.getAvgDryVolume());
        pojo.setAvgDryBulkspecgrav(elem.getAvgDryBulkspecgrav());
        pojo.setAvgDryPervoid(elem.getAvgDryPervoid());
        pojo.setAvgDryVoidsVolume(elem.getAvgDryVoidsVolume());
        pojo.setAvgDryLoading(elem.getAvgDryLoading());
        pojo.setAvgDryTensstr(elem.getAvgDryTensstr());
        pojo.setAvgWetHeight(elem.getAvgWetHeight());
        pojo.setAvgWetWtair(elem.getAvgWetWtair());
        pojo.setAvgWetWtsubmerged(elem.getAvgWetWtsubmerged());
        pojo.setAvgWetSsdwt(elem.getAvgWetSsdwt());
        pojo.setAvgWetVolume(elem.getAvgWetVolume());
        pojo.setAvgWetBulkspecgrav(elem.getAvgWetBulkspecgrav());
        pojo.setAvgWetPervoid(elem.getAvgWetPervoid());
        pojo.setAvgWetVoidsVolume(elem.getAvgWetVoidsVolume());
        pojo.setAvgSaturatedWaterMass(elem.getAvgSaturatedWaterMass());
        pojo.setAvgSaturatedSsdMass(elem.getAvgSaturatedSsdMass());
        pojo.setAvgSaturatedVolume(elem.getAvgSaturatedVolume());
        pojo.setAvgSaturatedVolAbsorbWater(elem.getAvgSaturatedVolAbsorbWater());
        pojo.setAvgSaturatedPctSaturation(elem.getAvgSaturatedPctSaturation());
        pojo.setAvgSaturatedPctSwell(elem.getAvgSaturatedPctSwell());
        pojo.setAvgFreezeHeight(elem.getAvgFreezeHeight());
        pojo.setAvgFreezeWaterMass(elem.getAvgFreezeWaterMass());
        pojo.setAvgFreezeMassAtSsd(elem.getAvgFreezeMassAtSsd());
        pojo.setAvgFreezeVolume(elem.getAvgFreezeVolume());
        pojo.setAvgFreezeVolAbsorbWater(elem.getAvgFreezeVolAbsorbWater());
        pojo.setAvgFreezeLoad(elem.getAvgFreezeLoad());
        pojo.setAvgFreezeWetStrength(elem.getAvgFreezeWetStrength());
        pojo.setAvgFreezePctSaturation(elem.getAvgFreezePctSaturation());
        pojo.setAvgFreezePctSwell(elem.getAvgFreezePctSwell());
        pojo.setAvgWaterDamage(elem.getAvgWaterDamage());
        pojo.setAvgAggDamage(elem.getAvgAggDamage());
        pojo.setTsr(elem.getTsr());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTrialNo(elem.getTrialNo());
        pojo.setSpecimenno(elem.getSpecimenno());
        pojo.setHeight(elem.getHeight());
        pojo.setWtair(elem.getWtair());
        pojo.setWtsubmerged(elem.getWtsubmerged());
        pojo.setSsdwt(elem.getSsdwt());
        pojo.setTheomaxspgr(elem.getTheomaxspgr());
        pojo.setLoading(elem.getLoading());
        pojo.setBulkspecgrav(elem.getBulkspecgrav());
        pojo.setPervoid(elem.getPervoid());
        pojo.setTensstr(elem.getTensstr());
        pojo.setVolume(elem.getVolume());
        pojo.setVoidsVolume(elem.getVoidsVolume());
        pojo.setSaturatedWaterMass(elem.getSaturatedWaterMass());
        pojo.setSaturatedSsdMass(elem.getSaturatedSsdMass());
        pojo.setSaturatedVolume(elem.getSaturatedVolume());
        pojo.setSaturatedVolAbsorbedWater(elem.getSaturatedVolAbsorbedWater());
        pojo.setSaturatedPctSaturation(elem.getSaturatedPctSaturation());
        pojo.setSaturatedPctSwell(elem.getSaturatedPctSwell());
        pojo.setFreezeHeight(elem.getFreezeHeight());
        pojo.setFreezeWaterMass(elem.getFreezeWaterMass());
        pojo.setFreezeMassAtSsd(elem.getFreezeMassAtSsd());
        pojo.setFreezeVolume(elem.getFreezeVolume());
        pojo.setFreezeVolAbsorbedWater(elem.getFreezeVolAbsorbedWater());
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
        pojo.setCompmethod(elem.getCompmethod());
        pojo.setAc(elem.getAc());
        pojo.setAcAdditive(elem.getAcAdditive());
        pojo.setRemarks(elem.getRemarks());
        pojo.setTestedby(elem.getTestedby());
        pojo.setRettenstr(elem.getRettenstr());
        pojo.setAvgcontrol(elem.getAvgcontrol());
        pojo.setAvgcondition(elem.getAvgcondition());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setCategory(elem.getCategory());
        pojo.setMixDesignation(elem.getMixDesignation());
        pojo.setGrade(elem.getGrade());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setHeightVacuum(elem.getHeightVacuum());
        pojo.setSaturationTime(elem.getSaturationTime());
        pojo.setAvgDryHeight(elem.getAvgDryHeight());
        pojo.setAvgDryWtair(elem.getAvgDryWtair());
        return pojo;
    }
}
