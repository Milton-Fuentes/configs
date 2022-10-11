/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabCaliblogV2;
import com.atser.tools.atserejb.model.QalabEquipinfoV2;
import com.atser.tools.atserejb.model.QalabEquipinfoProjectV2;
import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.view.VwClientTestsService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.CalibLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.MaintLogPojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.labcompliance.EquipLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.labcompliance.MaintLogWithEquipLogTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.atser.tools.atserejb.dao.qa.QalabEquipinfoProjectV2Dao;

@Stateless
public class QalabEquipinfoProjectV2ServiceImpl implements QalabEquipinfoProjectV2Service, IBaseEJBException {

    @Inject
    private QalabEquipinfoProjectV2Dao dao;

    @Inject
    private QalabEquipinfoV2Service qalabEquipinfoService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private VwClientTestsService vwClientTestsService;

    @Inject
    private QalabCaliblogV2Service qalabCaliblogService;

    @Override
    public QalabEquipinfoProjectV2 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabEquipinfoProjectV2 findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QalabEquipinfoProjectV2 elem) {
        if (elem != null) {
            if (!dao.exists(elem.getEquipId().getId().toBigInteger(), elem.getProjectId())) {
                QalabEquipinfoV2 equipId = qalabEquipinfoService.findById(StringSupport.getString(elem.getEquipId().getId()));
                elem.setEquipId(equipId);
                dao.save(elem);
            } else {
                throwBaseException(Response.Status.CONFLICT, "This Equipment already exists.");
            }
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QalabEquipinfoProjectV2 elem) {
        if (elem != null) {
            QalabEquipinfoProjectV2 model = findById(elem.getId());
            if (!model.equals(elem)) {
                model = populate(model, elem);
                if (model != null) {
                    dao.update(model);
                }
            }
        }
    }

    private QalabEquipinfoProjectV2 populate(QalabEquipinfoProjectV2 model, QalabEquipinfoProjectV2 elem) {
        model.setEquipId(elem.getEquipId());
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
    public List<QalabEquipinfoProjectV2> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QalabEquipinfoProjectV2> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QalabEquipinfoProjectV2> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QalabEquipinfoProjectV2> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabEquipinfoProjectV2> finalList = list(request);
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
    public Boolean exists(BigInteger equipId, BigInteger projectId) {
        if (equipId == null || projectId == null) {
            throwBaseException(Response.Status.CONFLICT, "Wrong Parameters.");
        }
        return dao.exists(equipId, projectId);
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_qalabcompliance", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "EqLogExp":
                case "EqLogTableCalib": {
                    return generateEquipLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "EqLogTableMaint": {
                    return generateMaintLogWithEquipLogReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateEquipLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<EquipLogTO> pResult = generateEquipLogReportData(request);

        String targetPath = docpathsegment + "QAEquipLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QalabEquipinfoProjectV2ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<EquipLogTO> generateEquipLogReportData(ManageITBodyRequest request) {
        List<QalabEquipinfoProjectV2> filterList = list(request);
        List<EquipLogTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(convertToEquipLogTO(it.getEquipId()));
        });
        return rList;
    }

    private EquipLogTO convertToEquipLogTO(QalabEquipinfoV2 info) {
        EquipLogTO result = new EquipLogTO();
        result.setEquipment(convertToEquipLogPojo(info));
        result.setCalib(convertToCalibLogPojo(info));
        result.setMaintListByPart(qalabEquipinfoService.listMaintDueDate(info.getId().toString()));
        return result;
    }

    private EquipLogPojo convertToEquipLogPojo(QalabEquipinfoV2 info) {
        EquipLogPojo result = new EquipLogPojo();
        result.setEqElectronicTag(info.getEquipElectronictag());
        result.setEqRMSTag(info.getEquipRmstag());
        result.setEqName(info.getEquipId().getItem());
        result.setEqItemDescription(info.getEquipItemDescrip());
        if (info.getPurchasedDate() != null) {
            result.setEqPurchasedDate(DateSupport.formatDate(info.getPurchasedDate(), DateSupport.FORMAT_US));
        }
        result.setEqManufacturer(info.getManufact());
        result.setEqModel(info.getModel());
        result.setEqSerialNo(info.getSerialNo());
        result.setEqLabAssigned(info.getLabId().getLabName());
        result.setEqRoom(info.getEquipRoom());
        result.setEqNo(StringSupport.emptyOnNull(info.getEquipNo()));
        result.setEqCurrentCond(StringSupport.emptyOnNull(info.getCurrentCondition()));
        StringJoiner testMethods = new StringJoiner(",");
        if (info.getQalabEquipclienttestList() != null && info.getQalabEquipclienttestList().size() > 0) {
            info.getQalabEquipclienttestList().forEach(it -> {
                VwClientTests testMethod = vwClientTestsService.findById(it.getClienttestid().toString());
                if (testMethod != null) {
                    testMethods.add(testMethod.getFinalTestName());
                }
            });
        }
        result.setEqTestMethodFor(testMethods.toString());
        if (info.getEquipOrigCost() != null) {
            result.setEqOriginalCost("$ " + CurrencySupport.formatDoubleToString(info.getEquipOrigCost(), 2));
        }
        if (info.getEquipReceivedDate() != null) {
            result.setEqReceivedDate(DateSupport.formatDate(info.getEquipReceivedDate(), DateSupport.FORMAT_US));
        }
        result.setEqCondWhenReceived(info.getConditionReceived());
        if (info.getInserviceDate() != null) {
            result.setEqInServiceDate(DateSupport.formatDate(info.getInserviceDate(), DateSupport.FORMAT_US));
        }
        return result;
    }

    private CalibLogPojo convertToCalibLogPojo(QalabEquipinfoV2 info) {
        CalibLogPojo result = new CalibLogPojo();
        result.setCalibMethod(info.getEquipId().getCalibMethod());
        result.setCalibFreqMonths(info.getEquipId().getIntervalM().toString() + " Months");
        if (info.getLogDate() != null) {
            result.setCalibDate(DateSupport.formatDate(info.getLogDate(), DateSupport.FORMAT_US));
        }
        QalabCaliblogV2 lastCalibLog = qalabCaliblogService.getLastCalibrationLog(info.getId());
        if (lastCalibLog != null) {
            result.setCalibPerformedBy(lastCalibLog.getPerformedby());
        }
        if (info.getExpirationDate() != null) {
            result.setCalibDueDate(DateSupport.formatDate(info.getExpirationDate(), DateSupport.FORMAT_US));
        }
        result.setCalibProcedure(info.getEquipId().getProcedure());

        return result;
    }

    private String generateMaintLogWithEquipLogReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<MaintLogWithEquipLogTO> pResult = generateMaintLogWithEquipLogReportData(request);

        String targetPath = docpathsegment + "QAEquipLogWithMaint_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(QalabEquipinfoProjectV2ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<MaintLogWithEquipLogTO> generateMaintLogWithEquipLogReportData(ManageITBodyRequest request) {
        List<QalabEquipinfoProjectV2> filterList = list(request);
        List<MaintLogWithEquipLogTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.addAll(convertToMaintLogWithEquipLogTO(it.getEquipId()));
        });
        return rList;
    }

    private List<MaintLogWithEquipLogTO> convertToMaintLogWithEquipLogTO(QalabEquipinfoV2 info) {
        List<MaintLogWithEquipLogTO> rList = new ArrayList<>();
        List<MaintLogPojo> maintList = qalabEquipinfoService.listMaintDueDate(info.getId().toString());
        maintList.forEach(it -> {
            MaintLogWithEquipLogTO item = new MaintLogWithEquipLogTO();
            item.setEquipment(convertToEquipLogPojo(info));
            item.setMaintPart(it);
            rList.add(item);
        });
        return rList;
    }

}
