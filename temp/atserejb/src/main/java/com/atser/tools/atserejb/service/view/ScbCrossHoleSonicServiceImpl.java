/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.ScbCrossHoleSonicDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.ScbCrossHoleSonic;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbCrossHoleSonicPojo;
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
public class ScbCrossHoleSonicServiceImpl implements ScbCrossHoleSonicService, IBaseEJBException {

    @Inject
    private ScbCrossHoleSonicDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<ScbCrossHoleSonic> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<ScbCrossHoleSonic> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbCrossHoleSonic> finalList = list(request);
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
    public DataTableWrapper<ScbCrossHoleSonic> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<ScbCrossHoleSonic> finalList = list(request);
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
        List<ScbCrossHoleSonicPojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_CrossHoleSonic_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Cross-Hole Sonic Log", ScbCrossHoleSonicPojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(ScbAllReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<ScbCrossHoleSonicPojo> generatePrintLogData(ManageITBodyRequest request) {
        List<ScbCrossHoleSonic> filterList = list(request);
        List<ScbCrossHoleSonicPojo> rList = new ArrayList<>();
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

    private ScbCrossHoleSonicPojo generatePojo(ScbCrossHoleSonic elem, GlobProject project, BufferedImage projectLogoImage) {
        ScbCrossHoleSonicPojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new ScbCrossHoleSonicPojo();
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            if (StringSupport.isNotNullAndNotEmpty(elem.getTestDoc()) && elem.getTestDoc().length() > 2) {
                response.setTestDoc("Yes");
            } else if (StringSupport.isNotNullAndNotEmpty(elem.getTestDoc()) && (elem.getTestDoc().toLowerCase().equals("n") || elem.getTestDoc().toLowerCase().equals("no"))) {
                response.setTestDoc("No");
            }
            response.setLabname(elem.getLabname());
            response.setProjectNo(elem.getProjectNo());
            response.setpName(elem.getpName());
            response.setLabFunction(elem.getLabFunction());
            response.setTestNo(StringSupport.getString(elem.getTestNo()));
            response.setDateOfTest(DateSupport.formatDate(elem.getDateOfTest(), DateSupport.FORMAT_US));
            response.setTestReportNo(elem.getTestReportNo());
            response.setStatus(elem.getStatus());
            response.setCmLocation(elem.getCmLocation());
            response.setTraceNo(elem.getTraceNo());
            response.setRemarks(elem.getRemarks());
            response.setTestingTech(elem.getTestingTech());
            response.setNoTubes(elem.getNoTubes());
            response.setDrilledShaftNo(elem.getDrilledShaftNo());
            response.setGrade(elem.getGrade());
            response.setTcnTrialNo(elem.getTcnTrialNo());
            response.setPile(elem.getPile());
            response.setProf(elem.getProf());
            response.setDistance(elem.getDistance());
            response.setAvgAt(elem.getAvgAt());
            response.setAvgWs(elem.getAvgWs());
            response.setStandardDev(elem.getStandardDev());
            response.setDiscreteCoeff(elem.getDiscreteCoeff());
            response.setMaxPsd(elem.getMaxPsd());
            response.setTestRemarks(elem.getTestRemarks());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
