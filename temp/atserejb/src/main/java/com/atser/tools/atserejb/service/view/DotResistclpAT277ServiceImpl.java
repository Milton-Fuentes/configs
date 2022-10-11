package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotResistclpAT277Dao;
import com.atser.tools.atserejb.model.DotResistclpAT277;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotResistclpAT277Pojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class DotResistclpAT277ServiceImpl implements DotResistclpAT277Service, IBaseEJBException {

    @Inject
    private DotResistclpAT277Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotResistclpAT277> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotResistclpAT277> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotResistclpAT277> finalList = list(request);
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
    public DataTableWrapper<DotResistclpAT277> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotResistclpAT277> finalList = list(request);
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
        List<DotResistclpAT277Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotResistclpAT277_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 277/C1202 Concrete Resist Chloride Ion Penetration - Electrical Indication", DotResistclpAT277Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotResistclpAT277ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotResistclpAT277Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotResistclpAT277> filterList = list(request);
        List<DotResistclpAT277Pojo> rList = new ArrayList<>();
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

    private DotResistclpAT277Pojo generatePojo(DotResistclpAT277 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotResistclpAT277Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotResistclpAT277Pojo populatePojo(DotResistclpAT277 elem) {
        DotResistclpAT277Pojo pojo = new DotResistclpAT277Pojo();
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setConditioningStartDate(elem.getConditioningStartDate());
        pojo.setAllowDryAirFrom(elem.getAllowDryAirFrom());
        pojo.setRemarks(elem.getRemarks());
        pojo.setAllowDryAirTo(elem.getAllowDryAirTo());
        pojo.setRapidCoatingFrom(elem.getRapidCoatingFrom());
        pojo.setRapidCoatingTo(elem.getRapidCoatingTo());
        pojo.setBeakerVacuumFrom(elem.getBeakerVacuumFrom());
        pojo.setLabPrep(elem.getLabPrep());
        pojo.setBeakerVacuumTo(elem.getBeakerVacuumTo());
        pojo.setVacuumCoverFrom(elem.getVacuumCoverFrom());
        pojo.setCylinder1Sum(elem.getCylinder1Sum());
        pojo.setVacuumCoverTo(elem.getVacuumCoverTo());
        pojo.setCylinder2Sum(elem.getCylinder2Sum());
        pojo.setSoakUnderWaterFrom(elem.getSoakUnderWaterFrom());
        pojo.setCylinder3Sum(elem.getCylinder3Sum());
        pojo.setSoakUnderWaterTo(elem.getSoakUnderWaterTo());
        pojo.setSetAverage(elem.getSetAverage());
        pojo.setCorrDiameter(elem.getCorrDiameter());
        pojo.setCorrCharge(elem.getCorrCharge());
        pojo.setAgeDays(elem.getAgeDays());
        pojo.setPenetrability(elem.getPenetrability());
        pojo.setCuringMethod(elem.getCuringMethod());
        pojo.setCylinder1SpecimenNo(elem.getCylinder1SpecimenNo());
        pojo.setCylinder2SpecimenNo(elem.getCylinder2SpecimenNo());
        pojo.setCylinder3SpecimenNo(elem.getCylinder3SpecimenNo());
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
        pojo.setMixdesignno(elem.getMixdesignno());
        pojo.setFunction(elem.getFunction());
        pojo.setTestno(elem.getTestno());
        pojo.setSampleTcn(elem.getSampleTcn());
        pojo.setTechId(elem.getTechId());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        return pojo;
    }
}
