/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbAggDelmDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbAggDelm;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbAggDelmPojo;
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
public class ScbAggDelmServiceImpl implements ScbAggDelmService, IBaseEJBException {

    @Inject
    private ScbAggDelmDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbAggDelm> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbAggDelm> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbAggDelm> finalList = list(request);
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
    public DataTableWrapper<ScbAggDelm> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbAggDelm> finalList = list(request);
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
        List<ScbAggDelmPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_AggrDelm_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Aggregate Deleterious", ScbAggDelmPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbAggDelmPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbAggDelm> filterList = list(request);
        List<ScbAggDelmPojo> rList = new ArrayList<>();
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

    private ScbAggDelmPojo generatePojo(ScbAggDelm elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbAggDelmPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbAggDelmPojo();
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setStatus(elem.getStatus());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setTestReportNo(elem.getTestReportNo());
            response.setLabname(elem.getLabname());
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setTestingTech(elem.getTestingTech());
            response.setTotalWeight(elem.getTotalWeight());
            response.setWeight1(elem.getWeight1());
            response.setWeight2(elem.getWeight2());
            response.setWeight3(elem.getWeight3());
            response.setWeight4(elem.getWeight4());
            response.setDeleterious(elem.getDeleterious());
            response.setRemarks(elem.getRemarks());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
