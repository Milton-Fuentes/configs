/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbDrilledPierSlurryDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbDrilledPierSlurry;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbDrilledPierSlurryPojo;
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
public class ScbDrilledPierSlurryServiceImpl implements ScbDrilledPierSlurryService, IBaseEJBException {

    @Inject
    private ScbDrilledPierSlurryDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbDrilledPierSlurry> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbDrilledPierSlurry> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbDrilledPierSlurry> finalList = list(request);
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
    public DataTableWrapper<ScbDrilledPierSlurry> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbDrilledPierSlurry> finalList = list(request);
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
        List<ScbDrilledPierSlurryPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DrilledPierSlurry_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Drilled Shaft Slurry Report", ScbDrilledPierSlurryPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbDrilledPierSlurryPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbDrilledPierSlurry> filterList = list(request);
        List<ScbDrilledPierSlurryPojo> rList = new ArrayList<>();
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

    private ScbDrilledPierSlurryPojo generatePojo(ScbDrilledPierSlurry elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbDrilledPierSlurryPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbDrilledPierSlurryPojo();
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setLabname(elem.getLabname());
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setLabFunction(elem.getLabFunction());
            if (StringSupport.isNotNullAndNotEmpty(elem.getTestNo())) {
                String testNo = StringSupport.getString(elem.getTestNo());
                if (StringSupport.isNotNullAndNotEmpty(elem.getNo())) {
                    response.setTestNo(testNo + "-" + elem.getNo());
                } else {
                    response.setTestNo(testNo);
                }
            }
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setTestReportNo(elem.getTestReportNo());
            response.setStatus(elem.getStatus());
            response.setCmLocation(elem.getCmLocation());
            response.setTraceNo(elem.getTraceNo());
            response.setRemarks(elem.getRemarks());
            response.setTestingTech(elem.getTestingTech());
            response.setTestType(elem.getTestType());
            response.setNoShafts(elem.getNoShafts());
            response.setPumpPressure(elem.getPumpPressure());
            response.setBentoniteType(elem.getBentoniteType());
            response.setActualSlurry(elem.getActualSlurry());
            response.setNo(elem.getNo());
            response.setDrilledPierLocation(elem.getDrilledPierLocation());
            response.setShaftdiameter(elem.getShaftdiameter());
            response.setBelldiameter(elem.getBelldiameter());
            response.setDepth(elem.getDepth());
            response.setSampleDepth(elem.getSampleDepth());
            response.setWetTimeTaken(elem.getWetTimeTaken());
            response.setWetTemp(elem.getWetTemp());
            response.setWetAmbSample(elem.getWetAmbSample());
            response.setWetSg(elem.getWetSg());
            response.setWetViscosity(elem.getWetViscosity());
            response.setWetPh(elem.getWetPh());
            response.setWetSandContent(elem.getWetSandContent());
            response.setTestRemarks(elem.getTestRemarks());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
