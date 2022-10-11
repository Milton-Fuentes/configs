/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.VwGlobLedgerDao;
import com.atser.tools.atserejb.model.VwGlobLedger;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobLedgerTO;

import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class VwGlobLedgerServiceImpl implements VwGlobLedgerService, IBaseEJBException {

    @Inject
    private VwGlobLedgerDao dao;

    @Inject
    private WsReportService wsReportService;

    @Override
    public List<VwGlobLedger> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwGlobLedger> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VwGlobLedger> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<VwGlobLedger> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwGlobLedger> finalList = list(request);
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
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_glob_ledger", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "globLedgerExpenseSummary": {
                    return generateMasterLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateMasterLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobLedgerTO> pResult = generateReportData(request);

        String targetPath = docpathsegment + "LedgerExpenseLogReportLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(VwGlobLedgerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<GlobLedgerTO> generateReportData(ManageITBodyRequest request) {
        List<VwGlobLedger> filterList = list(request);
        List<GlobLedgerTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(generateTO(it));
        });
        return rList;
    }

    private GlobLedgerTO generateTO(VwGlobLedger elem) {
        DecimalFormat df = new DecimalFormat("0.00");
        GlobLedgerTO to = new GlobLedgerTO();
        to.setPname(elem.getPname());
        to.setName(elem.getName());
        to.setPnumber(elem.getPnumber());
        to.setInspector(elem.getInspector());
        to.setOperationDate(DateSupport.formatDate(elem.getOperationDate(), DateSupport.FORMAT_US));
        to.setDescription(elem.getDescription());
        to.setAccount(elem.getAccount());
        to.setIncome(elem.getIncome().toString());
        to.setExpense(df.format(elem.getExpense()).toString());
        to.setMiles(elem.getMiles().toString());
        to.setMileageExpense(df.format(elem.getMileageExpense()).toString());
        to.setTotalExpense(df.format(elem.getTotalExpense()).toString());
        to.setBalance(elem.getBalance().toString());
        to.setCreated(DateSupport.formatDate(elem.getCreated(), DateSupport.FORMAT_US));
        to.setCreatedBy(elem.getCreatedBy());
        to.setLastMod(DateSupport.formatDate(elem.getLastMod(), DateSupport.FORMAT_US));
        to.setLastModBy(elem.getLastModBy());
        to.setVersion(elem.getVersion().toString());
        return to;
    }

}
