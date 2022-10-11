package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotProcT180Dao;
import com.atser.tools.atserejb.model.DotProcT180;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotProcT180Pojo;
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
public class DotProcT180ServiceImpl implements DotProcT180Service, IBaseEJBException {

    @Inject
    private DotProcT180Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotProcT180> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotProcT180> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotProcT180> finalList = list(request);
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
    public DataTableWrapper<DotProcT180> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotProcT180> finalList = list(request);
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
        List<DotProcT180Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotProcT180_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 180 Moisture Density of Soils Using 10 lb. Rammer", DotProcT180Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotProcT180ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotProcT180Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotProcT180> filterList = list(request);
        List<DotProcT180Pojo> rList = new ArrayList<>();
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

    private DotProcT180Pojo generatePojo(DotProcT180 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotProcT180Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotProcT180Pojo populatePojo(DotProcT180 elem) {
        DotProcT180Pojo pojo = new DotProcT180Pojo();
        pojo.setStatus(elem.getStatus());
        pojo.setWetSampleMoldvolLin(elem.getWetSampleMoldvolLin());
        pojo.setSampleMoldsize(elem.getSampleMoldsize());
        pojo.setSampleMoldvol(elem.getSampleMoldvol());
        pojo.setSpecgravity(elem.getSpecgravity());
        pojo.setMaxdrydensity(elem.getMaxdrydensity());
        pojo.setOptmoistcontent(elem.getOptmoistcontent());
        pojo.setMaxdrydensover(elem.getMaxdrydensover());
        pojo.setCormoistcontentover(elem.getCormoistcontentover());
        pojo.setInitSoilDesc(elem.getInitSoilDesc());
        pojo.setSampleLoc(elem.getSampleLoc());
        pojo.setPassNo4(elem.getPassNo4());
        pojo.setPassNo10(elem.getPassNo10());
        pojo.setPassNo40(elem.getPassNo40());
        pojo.setPassNo200(elem.getPassNo200());
        pojo.setCompactionMethod(elem.getCompactionMethod());
        pojo.setLiquidLimit(elem.getLiquidLimit());
        pojo.setPlasticLimit(elem.getPlasticLimit());
        pojo.setPlasticIndex(elem.getPlasticIndex());
        pojo.setBulkSpecGrav(elem.getBulkSpecGrav());
        pojo.setAbsorption(elem.getAbsorption());
        pojo.setUnitengmet(elem.getUnitengmet());
        pojo.setSource(elem.getSource());
        pojo.setStructure(elem.getStructure());
        pojo.setRemarks(elem.getRemarks());
        pojo.setSampledby(elem.getSampledby());
        pojo.setProctormolds(elem.getProctormolds());
        pojo.setProctorhammer(elem.getProctorhammer());
        pojo.setOven(elem.getOven());
        pojo.setBalance(elem.getBalance());
        pojo.setScale(elem.getScale());
        pojo.setPercentcoarser(elem.getPercentcoarser());
        pojo.setOrgSampleWt(elem.getOrgSampleWt());
        pojo.setRet34(elem.getRet34());
        pojo.setRet38(elem.getRet38());
        pojo.setRetNo4(elem.getRetNo4());
        pojo.setPerRet34(elem.getPerRet34());
        pojo.setPerRet38(elem.getPerRet38());
        pojo.setPerRetNo4(elem.getPerRetNo4());
        pojo.setPercentcoarserMoist(elem.getPercentcoarserMoist());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setSplitno(elem.getSplitno());
        pojo.setSplitsample(StringSupport.getString(elem.getSplitsample()));
        pojo.setCategory(elem.getCategory());
        pojo.setNumPoints(StringSupport.getString(elem.getNumPoints()));
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setHideOnPda(StringSupport.getString(elem.getHideOnPda()));
        pojo.setOvenDryWt(elem.getOvenDryWt());
        pojo.setWtPycnWater(elem.getWtPycnWater());
        pojo.setWtAggPycnWater(elem.getWtAggPycnWater());
        pojo.setHygrMoist(elem.getHygrMoist());
        pojo.setSpecgravityIscalc(StringSupport.getString(elem.getSpecgravityIscalc()));
        pojo.setMoldTareWt(elem.getMoldTareWt());
        pojo.setPercentOversized(elem.getPercentOversized());
        pojo.setPercentFinerMaterial(elem.getPercentFinerMaterial());
        pojo.setTotalWeight(elem.getTotalWeight());
        pojo.setRetNo10(elem.getRetNo10());
        pojo.setPerRetNo10(elem.getPerRetNo10());
        pojo.setPlus10AbsorbPerc(elem.getPlus10AbsorbPerc());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setPoint(elem.getPoint());
        pojo.setDrydensity(elem.getDrydensity());
        pojo.setMoistcontent(elem.getMoistcontent());
        pojo.setWetEstwater(elem.getWetEstwater());
        pojo.setWetSoilmoldwt(elem.getWetSoilmoldwt());
        pojo.setWetMoldwt(elem.getWetMoldwt());
        pojo.setWetSoilwt(elem.getWetSoilwt());
        pojo.setWetUnitwt(elem.getWetUnitwt());
        pojo.setDryContainerno(elem.getDryContainerno());
        pojo.setDryWetsoiltare(elem.getDryWetsoiltare());
        pojo.setDryDrysoiltare(elem.getDryDrysoiltare());
        pojo.setDryTare(elem.getDryTare());
        pojo.setDrySoilwt(elem.getDrySoilwt());
        pojo.setDryWaterwt(elem.getDryWaterwt());
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
        pojo.setWetMassWaterAdd(elem.getWetMassWaterAdd());
        pojo.setWetSampleMoldsize(elem.getWetSampleMoldsize());
        pojo.setTestResults(elem.getTestResults());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setTestdesign(elem.getTestdesign());
        pojo.setTestmethod(elem.getTestmethod());
        pojo.setPrepmethod(elem.getPrepmethod());
        pojo.setTyperammer(elem.getTyperammer());
        pojo.setField11(elem.getField11());
        pojo.setDescription(elem.getDescription());
        pojo.setSoilclass(elem.getSoilclass());
        pojo.setWetEstdrydensity(elem.getWetEstdrydensity());
        pojo.setWetMassMaterial(elem.getWetMassMaterial());
        pojo.setWetSampleMoldvol(elem.getWetSampleMoldvol());
        return pojo;
    }
}
