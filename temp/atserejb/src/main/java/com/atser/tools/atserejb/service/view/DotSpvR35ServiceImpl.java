package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotSpvR35Dao;
import com.atser.tools.atserejb.model.DotSpvR35;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSpvR35Pojo;
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
public class DotSpvR35ServiceImpl implements DotSpvR35Service, IBaseEJBException {

    @Inject
    private DotSpvR35Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSpvR35> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSpvR35> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSpvR35> finalList = list(request);
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
    public DataTableWrapper<DotSpvR35> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSpvR35> finalList = list(request);
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
        List<DotSpvR35Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSpvR35_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "R 35 Superpave Volumetric Design for Asphalt Mixtures", DotSpvR35Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotSpvR35ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSpvR35Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSpvR35> filterList = list(request);
        List<DotSpvR35Pojo> rList = new ArrayList<>();
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

    private DotSpvR35Pojo generatePojo(DotSpvR35 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSpvR35Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotSpvR35Pojo populatePojo(DotSpvR35 elem) {
        DotSpvR35Pojo pojo = new DotSpvR35Pojo();
        pojo.setVfa(elem.getVfa());
        pojo.setVfaResult(elem.getVfaResult());
        pojo.setVfaReason(elem.getVfaReason());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
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
        pojo.setAggSpecGrav(elem.getAggSpecGrav());
        pojo.setBinderSpecGrav(elem.getBinderSpecGrav());
        pojo.setPctPgBinder(elem.getPctPgBinder());
        pojo.setPctPassingNo200(elem.getPctPassingNo200());
        pojo.setGmm(elem.getGmm());
        pojo.setVoidsLowerEngLimit(elem.getVoidsLowerEngLimit());
        pojo.setVoidsLowerSpecLimit(elem.getVoidsLowerSpecLimit());
        pojo.setVoidsUpperSpecLimit(elem.getVoidsUpperSpecLimit());
        pojo.setVoidsUpperEngLimit(elem.getVoidsUpperEngLimit());
        pojo.setVmaLowerEngLimit(elem.getVmaLowerEngLimit());
        pojo.setVmaLowerSpecLimit(elem.getVmaLowerSpecLimit());
        pojo.setVmaUpperSpecLimit(elem.getVmaUpperSpecLimit());
        pojo.setVmaUpperEngLimit(elem.getVmaUpperEngLimit());
        pojo.setVfaLowerEngLimit(elem.getVfaLowerEngLimit());
        pojo.setVfaLowerSpecLimit(elem.getVfaLowerSpecLimit());
        pojo.setVfaUpperSpecLimit(elem.getVfaUpperSpecLimit());
        pojo.setVfaUpperEngLimit(elem.getVfaUpperEngLimit());
        pojo.setEffectiveSpecGravAgg(elem.getEffectiveSpecGravAgg());
        pojo.setPctAbsorbedAsphalt(elem.getPctAbsorbedAsphalt());
        pojo.setPctEffectiveAsphalt(elem.getPctEffectiveAsphalt());
        pojo.setDustBinderRatio(elem.getDustBinderRatio());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setRemarks(elem.getRemarks());
        pojo.setSpecimenNo(elem.getSpecimenNo());
        pojo.setGmb(elem.getGmb());
        pojo.setAirVoids(elem.getAirVoids());
        pojo.setVoidsResult(elem.getVoidsResult());
        pojo.setVoidsReason(elem.getVoidsReason());
        pojo.setVma(elem.getVma());
        pojo.setVmaResult(elem.getVmaResult());
        pojo.setVmaReason(elem.getVmaReason());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        pojo.setMixDesignNo(elem.getMixDesignNo());
        return pojo;
    }
}
