/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbConCompDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbConComp;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbConCompPojo;
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
public class ScbConCompServiceImpl implements ScbConCompService, IBaseEJBException {

    @Inject
    private ScbConCompDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbConComp> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbConComp> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbConComp> finalList = list(request);
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
    public DataTableWrapper<ScbConComp> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbConComp> finalList = list(request);
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
        List<ScbConCompPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_ConComp_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Concrete Compressive Strength", ScbConCompPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbConCompPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbConComp> filterList = list(request);
        List<ScbConCompPojo> rList = new ArrayList<>();
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

    private ScbConCompPojo generatePojo(ScbConComp elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbConCompPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbConCompPojo();
            response.setDiscard(elem.getDiscard());
            response.setDraft(elem.getDraft());
            if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && elem.getHasPhoto().length() > 2) {
                response.setHasPhoto("Yes");
            } else if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && (elem.getHasPhoto().toLowerCase().equals("n") || elem.getHasPhoto().toLowerCase().equals("no"))) {
                response.setHasPhoto("No");
            }
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setTestage(StringSupport.getString(elem.getTestage()));
            response.setCompressivestrength(StringSupport.getString(elem.getCompressivestrength()));
            response.setSpecifiedstrength(StringSupport.getString(elem.getSpecifiedstrength()));
            response.setStatus(elem.getStatus());
            response.setCylinderNo(elem.getCylinderNo());
            response.setLabFunction(elem.getLabFunction());
            response.setItemNo(elem.getItemNo());
            response.setItemMat(elem.getItemMat());
            response.setItemClass(elem.getItemClass());
            response.setLocation(elem.getLocation());
            response.setBatchSize(elem.getBatchSize());
            response.setConcreteClass(elem.getConcreteClass());
            response.setCompstr28day(StringSupport.getString(elem.getCompstr28day()));
            response.setAvg28dayStrength(StringSupport.getString(elem.getAvg28dayStrength()));
            response.setAppvd(elem.getAppvd());
            response.setTestcontrol(elem.getTestcontrol());
            response.setSampleTcnSp(elem.getSampleTcnSp());
            response.setActive(elem.getActive());
            response.setLotno(StringSupport.getString(elem.getLotno()));
            response.setSublotno(StringSupport.getString(elem.getSublotno()));
            response.setTicketno(elem.getTicketno());
            response.setSplitno(elem.getSplitno());
            response.setSplitsample(elem.getSplitsample());
            response.setFunction(elem.getFunction());
            response.setSampleno(elem.getSampleno());
            response.setReportdate(DateSupport.formatDate(elem.getReportdate(), DateSupport.FORMAT_US));
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setTestdate(DateSupport.formatDate(elem.getTestdate(), DateSupport.FORMAT_US));
            response.setSetnumber(elem.getSetnumber());
            response.setMixdesignno(elem.getMixdesignno());
            response.setSampleidno(elem.getSampleidno());
            response.setpName(elem.getpName());
            response.setCompanyid(elem.getCompanyid());
            response.setProjectNo(elem.getProjectNo());
            response.setLabname(elem.getLabname());
            response.setStation(elem.getStation());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
