/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotConCompDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.DotConComp;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConCompPojo;
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
public class DotConCompServiceImpl implements DotConCompService, IBaseEJBException {

    @Inject
    private DotConCompDao dao;

    @Inject
    private GlobProjectService projectService;
    
    @Inject
    private GenericHelperService genericHelperService;
 
    @Override
    public List<DotConComp> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConComp> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConComp> finalList = list(request);
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
    public DataTableWrapper<DotConComp> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConComp> finalList = list(request);
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
        List<DotConCompPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_ConComp_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Concrete Compressive Strength", DotConCompPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConCompPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConComp> filterList = list(request);
        List<DotConCompPojo> rList = new ArrayList<>();
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

    private DotConCompPojo generatePojo(DotConComp elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConCompPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotConCompPojo();
            response.setEquipList(elem.getEquipList());
            response.setSamplesperset(elem.getSamplesperset());
            response.setRemarks(elem.getRemarks());
            response.setCuringMethod(elem.getCuringMethod());
            response.setSpecimenCovered(elem.getSpecimenCovered());
            response.setLabPrep(elem.getLabPrep());
            response.setMintemp(StringSupport.getString(elem.getMintemp()));
            response.setMaxtemp(StringSupport.getString(elem.getMaxtemp()));
            response.setCylinderNo(elem.getCylinderNo());
            response.setLabStampNo(elem.getLabStampNo());
            response.setTestage(StringSupport.getString(elem.getTestage()));
            response.setTestageHours(StringSupport.getString(elem.getTestageHours()));
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setDiameter(elem.getDiameter());
            response.setWeight(elem.getWeight());
            response.setArea(elem.getArea());
            response.setMaximumload(StringSupport.getString(elem.getMaximumload()));
            response.setLifting(StringSupport.getString(elem.getLifting()));
            response.setTypeoffracture(elem.getTypeoffracture());
            response.setTech(elem.getTech());
            response.setCompressivestrength(StringSupport.getString(elem.getCompressivestrength()));
            response.setBreakLocation(elem.getBreakLocation());
            response.setRequiredstrength(elem.getRequiredstrength());
            response.setDiscardRequired(elem.getDiscardRequired());
            response.setDiscardCompleted(elem.getDiscardCompleted());
            response.setDiscard(elem.getDiscard());
            response.setResultTestage(elem.getResultTestage());
            response.setResultTestageHours(elem.getResultTestageHours());
            response.setResultSpecMin(elem.getResultSpecMin());
            response.setResultSpecMax(elem.getResultSpecMax());
            response.setResult(elem.getResult());
            response.setReportStampType(elem.getReportStampType());
            response.setResultAverage(elem.getResultAverage());
            response.setCompletedBy(elem.getCompletedBy());
            response.setReviewBy(elem.getReviewBy());
            response.setSignoffBy(elem.getSignoffBy());
            response.setDraft(elem.getDraft());
            if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && elem.getHasPhoto().length() > 2) {
                response.setHasPhoto("Yes");
            } else if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && (elem.getHasPhoto().toLowerCase().equals("n") || elem.getHasPhoto().toLowerCase().equals("no"))) {
                response.setHasPhoto("No");
            }
            response.setSpecifiedstrength(StringSupport.getString(elem.getSpecifiedstrength()));
            response.setAppvd(elem.getAppvd());
            response.setSampleTcnSp(elem.getSampleTcnSp());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setStatus(elem.getStatus());
            response.setLabFunction(elem.getLabFunction());
            response.setItemNo(elem.getItemNo());
            response.setItemMat(elem.getItemMat());
            response.setItemClass(elem.getItemClass());
            response.setLocation(elem.getLocation());
            response.setBatchSize(elem.getBatchSize());
            response.setConcreteClass(elem.getConcreteClass());
            response.setCompstr28day(StringSupport.getString(elem.getCompstr28day()));
            response.setAvg28dayStrength(StringSupport.getString(elem.getAvg28dayStrength()));
            response.setTestcontrol(elem.getTestcontrol());
            response.setLotno(StringSupport.getString(elem.getLotno()));
            response.setSublotno(StringSupport.getString(elem.getSublotno()));
            response.setTicketno(elem.getTicketno());
            response.setStation(elem.getStation());
            response.setSplitno(elem.getSplitno());
            response.setSplitsample(elem.getSplitsample());
            response.setFunction(elem.getFunction());
            response.setSampleno(elem.getSampleno());
            response.setReportdate(DateSupport.formatDate(elem.getReportdate(), DateSupport.FORMAT_US));
            response.setTestdate(DateSupport.formatDate(elem.getTestdate(), DateSupport.FORMAT_US));
            response.setSetnumber(elem.getSetnumber());
            response.setMixdesignno(elem.getMixdesignno());
            response.setpName(elem.getpName());
            response.setProjectNo(elem.getProjectNo());
            response.setLabname(elem.getLabname());
            response.setBiditemNo(elem.getBiditemNo());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
