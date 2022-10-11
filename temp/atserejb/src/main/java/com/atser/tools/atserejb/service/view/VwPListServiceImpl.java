/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.VwPListDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.QaPlist;
import com.atser.tools.atserejb.model.VwPList;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.qa.QaPlistService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.punchlist.QaPunchDetailTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.punchlist.QaPunchMainListTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class VwPListServiceImpl implements VwPListService, IBaseEJBException {

    @Inject
    private VwPListDao dao;

    @Inject
    private QaPlistService qaPlistService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private GlobProjectService projectService;

    @Override
    public List<VwPList> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwPList> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VwPList> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String projectId, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(projectId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_qaplistlog", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "QaPListLogTable": {
                    return generateQaPListLogTableReport(tplbasePath, tplpath, docpathsegment, docType, projectId, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateQaPListLogTableReport(String tplbasePath, String tplpath, String docpathsegment, String docType, String projectId, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        GlobProject project = projectService.findById(projectId);
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        paramsJasper.put("PROJECT_LOGO", projectLogoImage);

        List<QaPunchDetailTO> pPartialResult = generateQaPunchMainListReportData(request);

        List<QaPunchMainListTO> pResult = new ArrayList<>();

        QaPunchMainListTO mainObj = new QaPunchMainListTO();
        mainObj.setProjectName(project.getPName());
        mainObj.setProjectNo(project.getPNumber());
        mainObj.setQapDetailList(pPartialResult);
        pResult.add(mainObj);

        String targetPath = docpathsegment + "QaPListLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(VwPListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<QaPunchDetailTO> generateQaPunchMainListReportData(ManageITBodyRequest request) {
        List<QaPlist> filterList = qaPlistService.list(request);
        List<QaPunchDetailTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.convertToQaPunchDetailTO());
        });
        return rList;
    }

}
