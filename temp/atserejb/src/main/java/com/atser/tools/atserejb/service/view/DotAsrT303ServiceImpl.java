package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotAsrT303Dao;
import com.atser.tools.atserejb.model.DotAsrT303;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotAsrT303Pojo;
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
public class DotAsrT303ServiceImpl implements DotAsrT303Service, IBaseEJBException {

    @Inject
    private DotAsrT303Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotAsrT303> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotAsrT303> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotAsrT303> finalList = list(request);
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
    public DataTableWrapper<DotAsrT303> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotAsrT303> finalList = list(request);
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
        List<DotAsrT303Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotAsrT303_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 303/C1567 Alkali-Silica Reactivity (Accelerated Mortar-Bar Method)", DotAsrT303Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotAsrT303ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotAsrT303Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotAsrT303> filterList = list(request);
        List<DotAsrT303Pojo> rList = new ArrayList<>();
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

    private DotAsrT303Pojo generatePojo(DotAsrT303 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotAsrT303Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotAsrT303Pojo populatePojo(DotAsrT303 elem) {
        DotAsrT303Pojo pojo = new DotAsrT303Pojo();
        pojo.setStatus(elem.getStatus());
        pojo.setSilicaFumeLocation(elem.getSilicaFumeLocation());
        pojo.setSilicaFumeType(elem.getSilicaFumeType());
        pojo.setGaugeLength(elem.getGaugeLength());
        pojo.setA1(elem.getA1());
        pojo.setA0(elem.getA0());
        pojo.setR2(elem.getR2());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setLabPrep(elem.getLabPrep());
        pojo.setPctExpansionDays(elem.getPctExpansionDays());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setResult(elem.getResult());
        pojo.setPassfail(elem.getPassfail());
        pojo.setClassification(elem.getClassification());
        pojo.setPctExpansion(elem.getPctExpansion());
        pojo.setBestfitTime1(elem.getBestfitTime1());
        pojo.setBestfitPctExp1(elem.getBestfitPctExp1());
        pojo.setBestfitExp1(elem.getBestfitTime1() + "-" + elem.getBestfitPctExp1());
        pojo.setBestfitTime2(elem.getBestfitTime2());
        pojo.setBestfitPctExp2(elem.getBestfitPctExp2());
        pojo.setBestfitExp2(elem.getBestfitTime2() + "-" + elem.getBestfitPctExp2());
        pojo.setBestfitTime3(elem.getBestfitTime3());
        pojo.setBestfitPctExp3(elem.getBestfitPctExp3());
        pojo.setBestfitExp3(elem.getBestfitTime3() + "-" + elem.getBestfitPctExp3());
        pojo.setBestfitTime4(elem.getBestfitTime4());
        pojo.setBestfitPctExp4(elem.getBestfitPctExp4());
        pojo.setBestfitExp4(elem.getBestfitTime4() + "-" + elem.getBestfitPctExp4());
        pojo.setBestfitTime5(elem.getBestfitTime5());
        pojo.setBestfitPctExp5(elem.getBestfitPctExp5());
        pojo.setBestfitExp5(elem.getBestfitTime5() + "-" + elem.getBestfitPctExp5());
        pojo.setBestfitTime6(elem.getBestfitTime6());
        pojo.setBestfitPctExp6(elem.getBestfitPctExp6());
        pojo.setBestfitExp6(elem.getBestfitTime6() + "-" + elem.getBestfitPctExp6());
        pojo.setBestfitTime7(elem.getBestfitTime7());
        pojo.setBestfitPctExp7(elem.getBestfitPctExp7());
        pojo.setBestfitExp7(elem.getBestfitTime7() + "-" + elem.getBestfitPctExp7());
        pojo.setBestfitTime8(elem.getBestfitTime8());
        pojo.setBestfitPctExp8(elem.getBestfitPctExp8());
        pojo.setBestfitExp8(elem.getBestfitTime8() + "-" + elem.getBestfitPctExp8());
        pojo.setTime1(elem.getTime1());
        pojo.setLengthA(elem.getLengthA());
        pojo.setLengthB(elem.getLengthB());
        pojo.setLengthC(elem.getLengthC());
        pojo.setTime2(elem.getTime2());
        pojo.setPctA(elem.getPctA());
        pojo.setPctB(elem.getPctB());
        pojo.setPctC(elem.getPctC());
        pojo.setAverage(elem.getAverage());
        pojo.setRemarks(elem.getRemarks());
        pojo.setTestResults(elem.getTestResults());
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
        pojo.setSampleTestno(elem.getSampleTestno());
        pojo.setSampleTcn(elem.getSampleTcn());
        pojo.setTechId(elem.getTechId());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setFineAggInfo(elem.getFineAggInfo());
        pojo.setCoarseAggInfo(elem.getCoarseAggInfo());
        pojo.setCementInfo(elem.getCementInfo());
        pojo.setFlyAshInfo(elem.getFlyAshInfo());
        pojo.setSlagInfo(elem.getSlagInfo());
        pojo.setSilicaFumeInfo(elem.getSilicaFumeInfo());
        pojo.setCement(elem.getCement());
        pojo.setFlyAsh(elem.getFlyAsh());
        pojo.setSlag(elem.getSlag());
        pojo.setSilicaFume(elem.getSilicaFume());
        pojo.setFineAggSource(elem.getFineAggSource());
        pojo.setFineAggLocation(elem.getFineAggLocation());
        pojo.setFineAggType(elem.getFineAggType());
        pojo.setCoarseAggSource(elem.getCoarseAggSource());
        pojo.setCoarseAggLocation(elem.getCoarseAggLocation());
        pojo.setCoarseAggType(elem.getCoarseAggType());
        pojo.setCementSource(elem.getCementSource());
        pojo.setCementLocation(elem.getCementLocation());
        pojo.setCementType(elem.getCementType());
        pojo.setFlyAshSource(elem.getFlyAshSource());
        pojo.setFlyAshLocation(elem.getFlyAshLocation());
        pojo.setFlyAshType(elem.getFlyAshType());
        pojo.setSlagSource(elem.getSlagSource());
        pojo.setSlagLocation(elem.getSlagLocation());
        pojo.setSlagType(elem.getSlagType());
        pojo.setSilicaFumeSource(elem.getSilicaFumeSource());
        return pojo;
    }
}
