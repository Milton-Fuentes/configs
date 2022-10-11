/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.VwRtpoBalanceDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.VwRtpoBalance;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.objects.pojo.jasper.view.VwRtpoBalancePojo;
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
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;

@Stateless
@Slf4j
public class VwRtpoBalanceServiceImpl implements VwRtpoBalanceService, IBaseEJBException {
    
    @Inject
    private VwRtpoBalanceDao dao;
    
    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<VwRtpoBalance> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwRtpoBalance> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<VwRtpoBalance> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwRtpoBalance> finalList = list(request);
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
        List<VwRtpoBalancePojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "POBalanceReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("PO Balance", "", VwRtpoBalancePojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
    
    private List<VwRtpoBalancePojo> generatePrintLogData(ManageITBodyRequest request) {
        List<VwRtpoBalance> filterList = list(request);
        List<VwRtpoBalancePojo> rList = new ArrayList<>();
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
    
    private VwRtpoBalancePojo generatePojo(VwRtpoBalance elem, GlobProject project, BufferedImage projectLogoImage) {
        VwRtpoBalancePojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new VwRtpoBalancePojo();
            response.setProgramName(elem.getProgramName());
            response.setPhase(elem.getPhase());
            response.setJobNo(elem.getJobNo());
            response.setPurchaseOrderNo(elem.getPurchaseOrderNo());
            response.setCnumber(elem.getCnumber());
            response.setCname(elem.getCname());
            response.setCstatus(elem.getCstatus());
            response.setCdescription(elem.getCdescription());
            response.setCamount("$" + CurrencySupport.formatDoubleToString(elem.getCamount(), 2));
            response.setPstatus(elem.getPstatus());
            response.setPnumber(elem.getPnumber());
            response.setProjectCode(elem.getProjectCode());
            response.setPdate(DateSupport.formatDate(elem.getPdate(), DateSupport.FORMAT_US));
            response.setPname(elem.getPname());
            response.setActive(elem.getActive());
            response.setBalance("$" + CurrencySupport.formatBigDecimalToString(elem.getBalance(), 2));
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }
    
}
