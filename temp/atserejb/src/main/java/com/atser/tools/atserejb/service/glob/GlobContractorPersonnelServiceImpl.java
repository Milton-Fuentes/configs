/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobContractorPersonnelDao;
import com.atser.tools.atserejb.model.GlobContractorPersonnel;
import com.atser.tools.atserejb.model.QmPersonnel;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobContractorPersonnelServiceImpl implements GlobContractorPersonnelService, IBaseEJBException {

    @Inject
    private GlobContractorPersonnelDao dao;
    
    @Inject
    private WsReportService wsReportService;

    @Override
    public GlobContractorPersonnel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobContractorPersonnel findById(BigDecimal id) {
        return dao.findById(id);
    }

    private Boolean checkMultipleMain(List<QmPersonnel> list) {
        if (list != null && !list.isEmpty()) {
            List<QmPersonnel> listMatch = list.stream().filter(f -> f.getMain() == 'Y').collect(Collectors.toList());
            return (listMatch.size() >= 2);
        }
        return Boolean.FALSE;
    }

    @Override
    public void save(GlobContractorPersonnel elem) {
        if (elem != null) {
            if (checkMultipleMain(elem.getQmPersonnelList())) {
                throwBaseException(Response.Status.CONFLICT, "Multiple Main Contacts.");
            }
            //elem.buildReferences();
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobContractorPersonnel elem) {
        if (elem != null) {
            GlobContractorPersonnel model = findById(elem.getId());
            if (model != null) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private GlobContractorPersonnel populateForUpdate(GlobContractorPersonnel elem, GlobContractorPersonnel model) {
        model.setContractor(elem.getContractor());
        model.setFirstname(elem.getFirstname());
        model.setLastname(elem.getLastname());
        model.setTitle(elem.getTitle());
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setZip(elem.getZip());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setFax(elem.getFax());
        model.setEmail(elem.getEmail());
        model.setContractorCode(elem.getContractorCode());

        /*List<QmPersonnel> currentList = new ArrayList<>();
        currentList.addAll(model.getQmPersonnelList());

        currentList.forEach(it -> {
            model.removeQmPersonnelList(it);
        });

        elem.getQmPersonnelList().forEach(it -> {
            model.addQmPersonnelList(it);
        });*/
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobContractorPersonnel> list(ManageITBodyRequest request) {
        List<GlobContractorPersonnel> list;
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
    public DataTableWrapper<GlobContractorPersonnel> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobContractorPersonnel> finalList = list(request);
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
    public void changeEnabled(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("enabled"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobContractorPersonnel model = findById(request.getParams().get("id").toString());
        model.setEnabled(request.getParams().get("enabled").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
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
    public Boolean existItem(String contractor_name, BigInteger clientId) {
        if(StringSupport.isNotNullAndNotEmpty(contractor_name) && clientId != null) {
            return dao.existItem(contractor_name, clientId);
        }
        return Boolean.FALSE;
    }

     @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_glob_contractor", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "globContractorLog": {
                    return generateContractorLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateContractorLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobContractorTO> pResult = generateContractorReportData(request);

        String targetPath = docpathsegment + "ContractorLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobSupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobContractorTO> generateContractorReportData(ManageITBodyRequest request) {
        List<GlobContractorPersonnel> filterList = list(request);
        List<GlobContractorTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(it.generateTo());
        });
        return rList;
    }

    
    
}
