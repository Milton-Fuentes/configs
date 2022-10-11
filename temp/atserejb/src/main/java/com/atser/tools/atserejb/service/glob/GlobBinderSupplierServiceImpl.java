/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobBinderSupplierDao;
import com.atser.tools.atserejb.model.GlobBinderSupplier;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author author
 */
@Stateless
public class GlobBinderSupplierServiceImpl implements GlobBinderSupplierService, IBaseEJBException {

    @Inject
    private GlobBinderSupplierDao dao;

    @Inject
    private WsReportService wsReportService;

    @Override
    public GlobBinderSupplier findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobBinderSupplier findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobBinderSupplier elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobBinderSupplier elem) {
        if (elem != null) {
            GlobBinderSupplier model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobBinderSupplier> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_glob_binder_supplier", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "globBinderSupplierLog": {
                    return generateBinderSupplierLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateBinderSupplierLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobSupplierTO> pResult = generateBinderSupplierReportData(request);

        String targetPath = docpathsegment + "BinderSupplierLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobBinderSupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobSupplierTO> generateBinderSupplierReportData(ManageITBodyRequest request) {
        List<GlobBinderSupplier> filterList = list(request);
        List<GlobSupplierTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateTo());
        });
        return rList;
    }

}
