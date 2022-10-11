/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbConBatchInspDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbConBatchInsp;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbConBatchInspPojo;
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
public class ScbConBatchInspServiceImpl implements ScbConBatchInspService, IBaseEJBException {

    @Inject
    private ScbConBatchInspDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbConBatchInsp> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbConBatchInsp> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbConBatchInsp> finalList = list(request);
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
    public DataTableWrapper<ScbConBatchInsp> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbConBatchInsp> finalList = list(request);
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
        List<ScbConBatchInspPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_ConBatchInsp_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Concrete Batch Inspection", ScbConBatchInspPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbConBatchInspPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbConBatchInsp> filterList = list(request);
        List<ScbConBatchInspPojo> rList = new ArrayList<>();
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

    private ScbConBatchInspPojo generatePojo(ScbConBatchInsp elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbConBatchInspPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbConBatchInspPojo();
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setStatus(elem.getStatus());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setNumPoints(StringSupport.getString(elem.getNumPoints()));
            response.setMixdesignno(elem.getMixdesignno());
            response.setLabname(elem.getLabname());
            response.setTicketno(elem.getTicketno());
            response.setTruckno(elem.getTruckno());
            response.setBatchtime(elem.getBatchtime());
            response.setVolume(elem.getVolume());
            response.setTotalCuYd(elem.getTotalCuYd());
            response.setCement(elem.getCement());
            response.setFlyash(elem.getFlyash());
            response.setTotalCementitious(elem.getTotalCementitious());
            response.setSupplier(elem.getSupplier());
            response.setCoarseAgg(elem.getCoarseAgg());
            response.setFineAgg(elem.getFineAgg());
            response.setTotalAgg(elem.getTotalAgg());
            response.setCoarseAggMoist(elem.getCoarseAggMoist());
            response.setFineAggMoist(elem.getFineAggMoist());
            response.setCoarseAggWater(elem.getCoarseAggWater());
            response.setFineAggWater(elem.getFineAggWater());
            response.setIce(elem.getIce());
            response.setWaterAdded(elem.getWaterAdded());
            response.setTotalWater(elem.getTotalWater());
            response.setAdmix1(elem.getAdmix1());
            response.setAdmix2(elem.getAdmix2());
            response.setAdmix3(elem.getAdmix3());
            response.setWaterCementRatio(elem.getWaterCementRatio());
            response.setContractNo(elem.getContractNo());
            response.setNotice(elem.getNotice());
            response.setWaterWithheld(elem.getWaterWithheld());
            response.setRejected(elem.getRejected());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
