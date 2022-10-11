/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotConflexDao;
import com.atser.tools.atserejb.model.DotConflex;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConflexPojo;
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
public class DotConflexServiceImpl implements DotConflexService, IBaseEJBException {

    @Inject
    private DotConflexDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotConflex> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConflex> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConflex> finalList = list(request);
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
    public DataTableWrapper<DotConflex> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConflex> finalList = list(request);
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
        List<DotConflexPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotConflex_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T  97/C78 Concrete Flexural Strength (Third-Point Loading)", DotConflexPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotConflexServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConflexPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConflex> filterList = list(request);
        List<DotConflexPojo> rList = new ArrayList<>();
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

    private DotConflexPojo generatePojo(DotConflex elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConflexPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotConflexPojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setSplitsample(elem.getSplitsample());
            response.setPeReview(elem.getPeReview());
            response.setDiscardCompleted(elem.getDiscardCompleted());
            response.setTestClosed(elem.getTestClosed());
            response.setDiscardRequired(elem.getDiscardRequired());
            response.setReportdate(DateSupport.formatDate(elem.getReportdate(), DateSupport.FORMAT_US));
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setTestdate(DateSupport.formatDate(elem.getTestdate(), DateSupport.FORMAT_US));
            response.setSpecifiedstrength(StringSupport.getString(elem.getSpecifiedstrength()));
            response.setFlexstrength(StringSupport.getString(elem.getFlexstrength()));
            response.setMaximumload(StringSupport.getString(elem.getMaximumload()));
            response.setTestage(StringSupport.getString(elem.getTestage()));
            response.setMaxtemp(StringSupport.getString(elem.getMaxtemp()));
            response.setMintemp(StringSupport.getString(elem.getMintemp()));
            response.setLotno(StringSupport.getString(elem.getLotno()));
            response.setSublotno(StringSupport.getString(elem.getSublotno()));
            response.setId(StringSupport.getString(elem.getId()));
            response.setCompstr28day(StringSupport.getString(elem.getCompstr28day()));
            response.setAvg28dayStrength(StringSupport.getString(elem.getAvg28dayStrength()));
            response.setOutsideMiddle(elem.getOutsideMiddle());
            response.setDiscard(elem.getDiscard());
            response.setTicketNo(elem.getTicketNo());
            response.setConcreteClass(elem.getConcreteClass());
            response.setBatchSize(elem.getBatchSize());
            response.setSampleTcnSp(elem.getSampleTcnSp());
            response.setCuringMethod(elem.getCuringMethod());
            response.setTestcontrol(elem.getTestcontrol());
            response.setTestNo(elem.getTestNo());
            response.setVersion(elem.getVersion());
            response.setBiditemNo(elem.getBiditemNo());
            response.setTestNoLink(elem.getTestNoLink());
            response.setProjectNo(elem.getProjectNo());
            response.setItemClass(elem.getItemClass());
            response.setItemNo(elem.getItemNo());
            response.setItemMat(elem.getItemMat());
            response.setTestingmachine(elem.getTestingmachine());
            response.setCaliper(elem.getCaliper());
            response.setLabname(elem.getLabname());
            response.setLabid(elem.getLabid());
            response.setpName(elem.getpName());
            response.setLocation(elem.getLocation());
            response.setDefects(elem.getDefects());
            response.setCmLocation(elem.getCmLocation());
            response.setTraceNo(elem.getTraceNo());
            response.setDraft(elem.getDraft());
            response.setStatus(elem.getStatus());
            response.setRemarks(elem.getRemarks());
            response.setEquipList(elem.getEquipList());
            response.setStation(elem.getStation());
            response.setSignoffBy(elem.getSignoffBy());
            response.setReviewBy(elem.getReviewBy());
            response.setCompletedBy(elem.getCompletedBy());
            response.setSplitno(elem.getSplitno());
            response.setFunction(elem.getFunction());
            response.setSampleno(elem.getSampleno());
            response.setSetnumber(elem.getSetnumber());
            response.setMixdesignno(elem.getMixdesignno());
            response.setCompanyid(elem.getCompanyid());
            response.setSampleidno(elem.getSampleidno());
            response.setTestdesign(elem.getTestdesign());
            response.setSamplesperset(elem.getSamplesperset());
            response.setCuringhistory(elem.getCuringhistory());
            response.setMoistcondition(elem.getMoistcondition());
            response.setLabPrep(elem.getLabPrep());
            response.setAgetransport(elem.getAgetransport());
            response.setBeamNo(elem.getBeamNo());
            response.setSpecimenLength(elem.getSpecimenLength());
            response.setSpanLength(elem.getSpanLength());
            response.setWidth(elem.getWidth());
            response.setDepth(elem.getDepth());
            response.setWeightLoad(elem.getWeightLoad());
            response.setUnitWeight(elem.getUnitWeight());
            response.setContactSurfaceType(elem.getContactSurfaceType());
            response.setTech(elem.getTech());
            response.setBreakLocation(elem.getBreakLocation());
            response.setRequiredstrength(elem.getRequiredstrength());
            response.setResultTestage(elem.getResultTestage());
            response.setResultTestageHours(elem.getResultTestageHours());
            response.setResultSpecMin(elem.getResultSpecMin());
            response.setResultSpecMax(elem.getResultSpecMax());
            response.setResult(elem.getResult());
            response.setReportStampType(elem.getReportStampType());
            response.setResultAverage(elem.getResultAverage());
            response.setAppvd(elem.getAppvd());
            response.setLabFunction(elem.getLabFunction());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setProjectLogo(projectLogoImage);

        }
        return response;
    }

}
