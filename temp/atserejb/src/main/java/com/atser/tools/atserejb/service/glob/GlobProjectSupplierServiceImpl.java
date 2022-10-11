/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjectSupplierDao;
import com.atser.tools.atserejb.model.GlobProjectSupplier;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobProjectSupplierServiceImpl implements GlobProjectSupplierService, IBaseEJBException {

    @Inject
    private GlobProjectSupplierDao dao;

    @Inject
    private WsReportService wsReportService;

    @Override
    public GlobProjectSupplier findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjectSupplier findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjectSupplier elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProjectSupplier elem) {
        if (elem != null) {
            GlobProjectSupplier model = findById(elem.getId());
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
    public List<GlobProjectSupplier> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public BigInteger getProjectSupplierId(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("projectId")) || StringSupport.isNullOrEmpty(request.getParams().get("supId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobProjectSupplier> respList = list(new ManageITBodyRequest(0, 0).filter("projectId.id", request.getParams().get("projectId")).filter("supplierId.id", request.getParams().get("supId")).filter("active", "Y").filter("enabled", "Y"));
        if (respList != null && respList.size() == 1) {
            return respList.get(0).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_proj_supplier", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "projSupplierLog": {
                    return generateSupplierLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateSupplierLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobSupplierTO> pResult = generateSupplierReportData(request);

        String targetPath = docpathsegment + "ProjSupplierLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobSupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobSupplierTO> generateSupplierReportData(ManageITBodyRequest request) {
        List<GlobProjectSupplier> filterList = list(request);
        List<GlobSupplierTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateTo());
        });
        return rList;
    }

    @Override
    public Boolean exists(BigInteger projectId, BigInteger supplierId) {
        if (projectId == null || supplierId == null) {
            return false;
        }
        return dao.exists(projectId, supplierId);
    }
}
