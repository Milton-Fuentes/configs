/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbStrandCoilInspDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbStrandCoilInsp;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbStrandCoilInspPojo;
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
public class ScbStrandCoilInspServiceImpl implements ScbStrandCoilInspService, IBaseEJBException {

    @Inject
    private ScbStrandCoilInspDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbStrandCoilInsp> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbStrandCoilInsp> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbStrandCoilInsp> finalList = list(request);
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
    public DataTableWrapper<ScbStrandCoilInsp> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbStrandCoilInsp> finalList = list(request);
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
        List<ScbStrandCoilInspPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_StrandCoilInspReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Strand Coil Inspection Report", ScbStrandCoilInspPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbStrandCoilInspPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbStrandCoilInsp> filterList = list(request);
        List<ScbStrandCoilInspPojo> rList = new ArrayList<>();
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

    private ScbStrandCoilInspPojo generatePojo(ScbStrandCoilInsp elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbStrandCoilInspPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbStrandCoilInspPojo();
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setStatus(elem.getStatus());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setSupplier(elem.getSupplier());
            response.setNumPoints(StringSupport.getString(elem.getNumPoints()));
            response.setDeliveryDate(elem.getDeliveryDate());
            response.setMaterialType(elem.getMaterialType());
            response.setTestMethod(elem.getTestMethod());
            response.setDesignDiameter(elem.getDesignDiameter());
            response.setDesignArea(elem.getDesignArea());
            response.setDesignTolPlus(elem.getDesignTolPlus());
            response.setDesignTolMinus(elem.getDesignTolMinus());
            response.setRemarks(elem.getRemarks());
            response.setFarSummary(elem.getFarSummary());
            response.setGrade(elem.getGrade());
            if (StringSupport.isNotNullAndNotEmpty(elem.getTestNo())) {
                String testNo = StringSupport.getString(elem.getTestNo());
                if (StringSupport.isNotNullAndNotEmpty(elem.getNo())) {
                    response.setTestNo(testNo + "-" + elem.getNo());
                } else {
                    response.setTestNo(testNo);
                }
            }
            if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && elem.getHasPhoto().length() > 2) {
                response.setHasPhoto("Yes");
            } else if (StringSupport.isNotNullAndNotEmpty(elem.getHasPhoto()) && (elem.getHasPhoto().toLowerCase().equals("n") || elem.getHasPhoto().toLowerCase().equals("no"))) {
                response.setHasPhoto("No");
            }
            response.setTestingTech(elem.getTestingTech());
            response.setLabname(elem.getLabname());
            response.setNo(elem.getNo());
            response.setCoilNo(elem.getCoilNo());
            response.setHeatNo(elem.getHeatNo());
            response.setDiameter(elem.getDiameter());
            response.setAreaActual(elem.getAreaActual());
            response.setEmodActual(elem.getEmodActual());
            response.setCoilTestReport(elem.getCoilTestReport());
            response.setProdNo(elem.getProdNo());
            response.setLength(elem.getLength());
            response.setRejected(elem.getRejected());
            response.setNotice(elem.getNotice());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
