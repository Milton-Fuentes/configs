package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotLabrT96Dao;
import com.atser.tools.atserejb.model.DotLabrT96;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotLabrT96Pojo;
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
public class DotLabrT96ServiceImpl implements DotLabrT96Service, IBaseEJBException {

    @Inject
    private DotLabrT96Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotLabrT96> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotLabrT96> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotLabrT96> finalList = list(request);
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
    public DataTableWrapper<DotLabrT96> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotLabrT96> finalList = list(request);
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
        List<DotLabrT96Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotLabrT96_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 96/C131 Resistance to Abrasion in Los Angeles Machine", DotLabrT96Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotLabrT96ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotLabrT96Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotLabrT96> filterList = list(request);
        List<DotLabrT96Pojo> rList = new ArrayList<>();
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

    private DotLabrT96Pojo generatePojo(DotLabrT96 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotLabrT96Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotLabrT96Pojo populatePojo(DotLabrT96 elem) {
        DotLabrT96Pojo pojo = new DotLabrT96Pojo();
        pojo.setPercentloss1000(elem.getPercentloss1000());
        pojo.setTotalinitialwt2(elem.getTotalinitialwt2());
        pojo.setUniformHardnessRatio2(elem.getUniformHardnessRatio2());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setLaMachine(elem.getLaMachine());
        pojo.setCharges(elem.getCharges());
        pojo.setNo12Sieve(elem.getNo12Sieve());
        pojo.setScale(elem.getScale());
        pojo.setDryingOven(elem.getDryingOven());
        pojo.setSampleLocation(elem.getSampleLocation());
        pojo.setRemarks(elem.getRemarks());
        pojo.setTestDesignation(elem.getTestDesignation());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setMaterialType(elem.getMaterialType());
        pojo.setCompstrGreater(elem.getCompstrGreater());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setGrading(elem.getGrading());
        pojo.setSieve1(elem.getSieve1());
        pojo.setSieve12(elem.getSieve12());
        pojo.setSieve14(elem.getSieve14());
        pojo.setSieve34(elem.getSieve34());
        pojo.setSieve38(elem.getSieve38());
        pojo.setSieve4(elem.getSieve4());
        pojo.setSieve8(elem.getSieve8());
        pojo.setSieve12(elem.getSieve12());
        pojo.setPercentloss(elem.getPercentloss());
        pojo.setTotalinitialwt(elem.getTotalinitialwt());
        pojo.setSieve212(elem.getSieve212());
        pojo.setSieve2(elem.getSieve2());
        pojo.setSieve112(elem.getSieve112());
        pojo.setAggName(elem.getAggName());
        pojo.setPercentloss500(elem.getPercentloss500());
        pojo.setUniformHardnessRatio(elem.getUniformHardnessRatio());
        pojo.setWashedmass500(elem.getWashedmass500());
        pojo.setUnwashedmass200(elem.getUnwashedmass200());
        pojo.setWashedmass1000(elem.getWashedmass1000());
        pojo.setPercentloss200(elem.getPercentloss200());
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
        return pojo;
    }
}
