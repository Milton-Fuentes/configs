/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjContrPersonnelDao;
import com.atser.tools.atserejb.model.GlobProjContrPersonnel;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobContractorTO;
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

@Stateless
public class GlobProjContrPersonnelServiceImpl implements GlobProjContrPersonnelService, IBaseEJBException {

    @Inject
    private GlobProjContrPersonnelDao dao;

    @Inject
    private WsReportService wsReportService;

    @Override
    public GlobProjContrPersonnel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjContrPersonnel findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjContrPersonnel elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProjContrPersonnel elem) {
        if (elem != null) {
            GlobProjContrPersonnel model = findById(elem.getId());
            if (model != null) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private GlobProjContrPersonnel populateForUpdate(GlobProjContrPersonnel elem, GlobProjContrPersonnel model) {
        model.setContractorPersonnelId(elem.getContractorPersonnelId());
        model.setContractorTypeId(elem.getContractorTypeId());
        model.setProjectId(elem.getProjectId());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobProjContrPersonnel> list(ManageITBodyRequest request) {
        List<GlobProjContrPersonnel> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobProjContrPersonnel> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobProjContrPersonnel> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

     @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_proj_contractor", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "projContractorLog": {
                    return generateProjContractorLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateProjContractorLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobContractorTO> pResult = generateProjContractorReportData(request);

        String targetPath = docpathsegment + "ProjContractorLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobSupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobContractorTO> generateProjContractorReportData(ManageITBodyRequest request) {
        List<GlobProjContrPersonnel> filterList = list(request);
        List<GlobContractorTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateTo());
        });
        return rList;
    }
}
