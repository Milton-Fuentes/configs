package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotPszT88Dao;
import com.atser.tools.atserejb.model.DotPszT88;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotPszT88Pojo;
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
public class DotPszT88ServiceImpl implements DotPszT88Service, IBaseEJBException {

    @Inject
    private DotPszT88Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotPszT88> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotPszT88> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotPszT88> finalList = list(request);
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
    public DataTableWrapper<DotPszT88> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotPszT88> finalList = list(request);
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
        List<DotPszT88Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotPszT88_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T  88 Particle Size Analysis of Soils", DotPszT88Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotPszT88ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotPszT88Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotPszT88> filterList = list(request);
        List<DotPszT88Pojo> rList = new ArrayList<>();
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

    private DotPszT88Pojo generatePojo(DotPszT88 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotPszT88Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotPszT88Pojo populatePojo(DotPszT88 elem) {
        DotPszT88Pojo pojo = new DotPszT88Pojo();
        pojo.setWtpassed(elem.getWtpassed());
        pojo.setPercentret(elem.getPercentret());
        pojo.setProjrequire(elem.getProjrequire());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setMcDryWtSoilTare(elem.getMcDryWtSoilTare());
        pojo.setMcWtTare(elem.getMcWtTare());
        pojo.setMcWtWater(elem.getMcWtWater());
        pojo.setMcWtdrySoil(elem.getMcWtdrySoil());
        pojo.setMcWaterContent(elem.getMcWaterContent());
        pojo.setMcMeniscusCorrFactor(elem.getMcMeniscusCorrFactor());
        pojo.setMcSpecificGravity(elem.getMcSpecificGravity());
        pojo.setMcSolutionUsed(elem.getMcSolutionUsed());
        pojo.setCoarseMassTotalAirdried(elem.getCoarseMassTotalAirdried());
        pojo.setCoarseMassFracRetNo10(elem.getCoarseMassFracRetNo10());
        pojo.setCoarsePercRetNo10(elem.getCoarsePercRetNo10());
        pojo.setCoarsePercPassingNo10(elem.getCoarsePercPassingNo10());
        pojo.setHmContainerNo(elem.getHmContainerNo());
        pojo.setHmMassContainerAirdried(elem.getHmMassContainerAirdried());
        pojo.setHmMassContainerOvendried(elem.getHmMassContainerOvendried());
        pojo.setHmMassContainer(elem.getHmMassContainer());
        pojo.setHmMassWater(elem.getHmMassWater());
        pojo.setHmMassAirdried(elem.getHmMassAirdried());
        pojo.setHmMassOvendried(elem.getHmMassOvendried());
        pojo.setHmHygroscopicMoist(elem.getHmHygroscopicMoist());
        pojo.setFineContainerNo(elem.getFineContainerNo());
        pojo.setFineMassContainerAirdried(elem.getFineMassContainerAirdried());
        pojo.setFineMassContainer(elem.getFineMassContainer());
        pojo.setFineMassAirdriedSoil(elem.getFineMassAirdriedSoil());
        pojo.setFineMassOvendried(elem.getFineMassOvendried());
        pojo.setFineCalcMassTotal(elem.getFineCalcMassTotal());
        pojo.setFineTotalPercentPassed(elem.getFineTotalPercentPassed());
        pojo.setAmountTypeDispAgentUsed(elem.getAmountTypeDispAgentUsed());
        pojo.setHmHygroscopicMoistCorrFact(elem.getHmHygroscopicMoistCorrFact());
        pojo.setRunNo(StringSupport.getString(elem.getRunNo()));
        pojo.setAggType(StringSupport.getString(elem.getAggType()));
        pojo.setSaType(elem.getSaType());
        pojo.setSieveName(elem.getSieveName());
        pojo.setPercentpass(elem.getPercentpass());
        pojo.setWtret(elem.getWtret());
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
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setParticleLargerThan2mmPct(elem.getParticleLargerThan2mmPct());
        pojo.setCoarseSand2To42mmPct(elem.getCoarseSand2To42mmPct());
        pojo.setFineSand42To074mmPct(elem.getFineSand42To074mmPct());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setSilt074To002mmPct(elem.getSilt074To002mmPct());
        pojo.setClaySmallerThan002mmPct(elem.getClaySmallerThan002mmPct());
        pojo.setColloidSmallerThan001mmPct(elem.getColloidSmallerThan001mmPct());
        pojo.setSmallerThan02mmPercent(elem.getSmallerThan02mmPercent());
        pojo.setSmallerThan002mmPercent(elem.getSmallerThan002mmPercent());
        pojo.setSmallerThan001mmPercent(elem.getSmallerThan001mmPercent());
        pojo.setRemarks(elem.getRemarks());
        pojo.setWtSamplePassNo10TakenTest(elem.getWtSamplePassNo10TakenTest());
        pojo.setPerpassNo10WholeSample(elem.getPerpassNo10WholeSample());
        pojo.setHydrometerNo(elem.getHydrometerNo());
        pojo.setMcWetWtSoilTare(elem.getMcWetWtSoilTare());
        return pojo;
    }
}
