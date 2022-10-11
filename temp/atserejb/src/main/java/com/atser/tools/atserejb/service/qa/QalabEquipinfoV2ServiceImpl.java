/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QalabEquipinfoV2Dao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.model.QalabCaliblogV2;
import com.atser.tools.atserejb.model.QalabEquipAlert;
import com.atser.tools.atserejb.model.QalabEquipclienttestV2;
import com.atser.tools.atserejb.model.QalabEquipinfoV2;
import com.atser.tools.atserejb.model.QalabEquipinfoProjectV2;
import com.atser.tools.atserejb.model.QalabMaintlogV2;
import com.atser.tools.atserejb.model.QalabMainttypeV2;
import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.glob.GlobClientService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobLabsMasterService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.view.VwClientTestsService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.QalabEquiptypeV2;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.CalibLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipCalibAlertPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipInfoBarcodePojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipMaintAlertPojo;
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Session;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Stateless
@Slf4j
public class QalabEquipinfoV2ServiceImpl implements QalabEquipinfoV2Service, IBaseEJBException {

    private final String rootFolderName = "Equipments";

    @Inject
    private QalabEquipinfoV2Dao dao;

    @Inject
    private VwClientTestsService vwClientTestsService;

    @Inject
    private QalabCaliblogV2Service qalabCaliblogService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private QalabEquiptypeV2Service equipTypeService;

    @Inject
    private GlobLabsMasterService globLabsMasterService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private QalabEquipAlertService qalabEquipAlertService;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private QalabEquipinfoProjectV2Service qalabEquipinfoProjectService;

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Override
    public QalabEquipinfoV2 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QalabEquipinfoV2 findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(ManageITHeader header, QalabEquipinfoV2 elem) {
        if (elem != null) {
            elem.setLabId(globLabsMasterService.findById(elem.getLabId().getId()));
            elem.buildReferences();
            elem.setActive("Y");
            dao.save(elem);
            createEquipFolderStruct(header.getUserid(), header.getClientid(), elem);
        }
    }

    @Override
    public void update(QalabEquipinfoV2 elem) {
        update(null, elem);
    }

    @Override
    public void update(ManageITHeader header, QalabEquipinfoV2 elem) {
        if (elem != null) {
            QalabEquipinfoV2 model = findById(elem.getId());
            if (header != null) { // comes from internal request
                updateEquipFolderName(header.getClientid(), model, elem);
            }
            model.setEquipElectronictag(elem.getEquipElectronictag());
            model.setEquipRmstag(elem.getEquipRmstag());
            model.setEquipRoom(elem.getEquipRoom());
            model.setLabId(globLabsMasterService.findById(elem.getLabId().getId()));
            model.setEquipId(elem.getEquipId());
            model.setManufact(elem.getManufact());
            model.setModel(elem.getModel());
            model.setSerialNo(elem.getSerialNo());
            model.setEquipNo(elem.getEquipNo());
            model.setEquipOrigCost(elem.getEquipOrigCost());
            model.setConditionReceived(elem.getConditionReceived());
            model.setPurchasedDate(elem.getPurchasedDate());
            model.setEquipReceivedDate(elem.getEquipReceivedDate());
            model.setInserviceDate(elem.getInserviceDate());
            model.setEquipItemDescrip(elem.getEquipItemDescrip());
            model.setCurrentCondition(elem.getCurrentCondition());

            if (model.getQalabCaliblogList().isEmpty()) {
                model.setExpirationDate(elem.getExpirationDate());
            }

            List<QalabEquipclienttestV2> currentList = new ArrayList<>();
            currentList.addAll(model.getQalabEquipclienttestList());

            currentList.forEach(it -> {
                model.removeQalabEquipclienttestList(it);
            });

            elem.getQalabEquipclienttestList().forEach(it -> {
                model.addQalabEquipclienttestList(it);
            });
            dao.update(model);
        }
    }

    @Override
    public void updateExpirationDate(QalabEquipinfoV2 elem) {
        if (elem != null) {
            QalabEquipinfoV2 model = findById(elem.getId());
            model.setLogDate(elem.getLogDate());
            model.setExpirationDate(elem.getExpirationDate());
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
    public List<QalabEquipinfoV2> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QalabEquipinfoV2> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabEquipinfoV2> finalList = list(request);
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
    public DataGridWrapper<QalabEquipinfoV2> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QalabEquipinfoV2> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public List<MaintLogPojo> listMaintDueDate(String id) {
        List<MaintLogPojo> rlist = new ArrayList<>();
        QalabEquipinfoV2 einfo = findById(id);
        Comparator<QalabMaintlogV2> sByMaintDate = (QalabMaintlogV2 o1, QalabMaintlogV2 o2) -> o1.getMaintDate().compareTo(o2.getMaintDate());
        if (einfo != null) {
            List<QalabMainttypeV2> mainttypeList = einfo.getEquipId().getQalabMainttypeList();
            List<QalabMaintlogV2> maintlogList = einfo.getQalabMaintlogList();
            if (mainttypeList != null && !mainttypeList.isEmpty()) {
                if (maintlogList != null && !maintlogList.isEmpty()) {
                    mainttypeList.forEach(it -> {
                        List<QalabMaintlogV2> finalList = maintlogList.stream().filter(p -> p.getEquipMaintTypeid().equals(it)).collect(Collectors.toList());
                        if (finalList.isEmpty()) {
                            rlist.add(new MaintLogPojo(it.getEquippartName()));
                        } else {
                            finalList = finalList.stream().sorted(sByMaintDate.reversed()).collect(Collectors.toList());
                            rlist.add(new MaintLogPojo(it.getEquippartName(), finalList.get(0).getDescription(), it.getIntervalM().toString(),
                                    DateSupport.formatDate(finalList.get(0).getMaintDate(), DateSupport.FORMAT_US), finalList.get(0).getPerformedby(),
                                    DateSupport.formatDate(finalList.get(0).getMaintDueDate(), DateSupport.FORMAT_US)));
                        }
                    });
                } else {
                    mainttypeList.forEach(it -> {
                        rlist.add(new MaintLogPojo(it.getEquippartName()));
                    });
                }
            }
        }
        return rlist;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QalabEquipinfoV2 model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
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
            log.error(ex.getMessage());
        }
        return null;
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

    private List<EquipLogTO> generateEquipLogReportData(ManageITBodyRequest request) {
        List<QalabEquipinfoV2> filterList = list(request);
        List<EquipLogTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(convertToEquipLogTO(it));
        });
        return rList;
    }

    private EquipLogTO convertToEquipLogTO(QalabEquipinfoV2 info) {
        EquipLogTO result = new EquipLogTO();
        result.setEquipment(convertToEquipLogPojo(info));
        result.setCalib(convertToCalibLogPojo(info));
        result.setMaintListByPart(listMaintDueDate(info.getId().toString()));
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
            log.error(ex.getMessage());
        }
        return null;
    }

    private List<MaintLogWithEquipLogTO> generateMaintLogWithEquipLogReportData(ManageITBodyRequest request) {
        List<QalabEquipinfoV2> filterList = list(request);
        List<MaintLogWithEquipLogTO> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.addAll(convertToMaintLogWithEquipLogTO(it));
        });
        return rList;
    }

    private List<MaintLogWithEquipLogTO> convertToMaintLogWithEquipLogTO(QalabEquipinfoV2 info) {
        List<MaintLogWithEquipLogTO> rList = new ArrayList<>();
        List<MaintLogPojo> maintList = listMaintDueDate(info.getId().toString());
        maintList.forEach(it -> {
            MaintLogWithEquipLogTO item = new MaintLogWithEquipLogTO();
            item.setEquipment(convertToEquipLogPojo(info));
            item.setMaintPart(it);
            rList.add(item);
        });
        return rList;
    }

    @Override
    public BigDecimal createEquipFolderStruct(String userId, String clientId, String InfoId) {
        return createEquipFolderStruct(userId, clientId, findById(InfoId));
    }

    @Override
    public BigDecimal createEquipFolderStruct(String userId, String clientId, QalabEquipinfoV2 elem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QalabEquiptypeV2 equipType;
        if (elem.getEquipId().getCatgId() == null) {
            equipType = equipTypeService.findById(elem.getEquipId().getId().toString());
        } else {
            equipType = elem.getEquipId();
        }
        BigInteger cId = new BigInteger(clientId);
        BigInteger owner = NumberSupport.getBigInteger(userId);
        if (equipType == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        // Create Root Folder
        BigDecimal rootFolderId = folderService.getFolderIdByClientBy(clientId, eManageITFolder.eFLabCompliance);
        if (rootFolderId == null) {
            BigDecimal froot = folderService.getRootFolderIdByClient(cId);
            rootFolderId = folderService.createTrackITFolder(froot, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', eManageITFolder.eFLabCompliance.getValue(), new BigInteger("2"), folderService.getNextFolderNumber(froot.toBigInteger(), "##0.0"));
        }
        // Create Equipment Root Folder
        BigDecimal EquipRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName);
        if (EquipRootFolderId == null) {
            EquipRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }
        // Create Equipment Folder
        String equipFolderName = equipType.getCatgId().getCategory() + "-" + StringSupport.cutFromEnd(elem.getSerialNo(), 4);
        BigDecimal EquipFolderId = folderService.getFolderIdByClientBy(clientId, equipFolderName);
        if (EquipFolderId == null) {
            EquipFolderId = folderService.createTrackITFolder(EquipRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', equipFolderName, new BigInteger("2"));
        }

        return EquipFolderId;
    }

    private void updateEquipFolderName(String clientId, QalabEquipinfoV2 dbItem, QalabEquipinfoV2 updateItem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            return;
        }
        QalabEquiptypeV2 equipType;
        if (dbItem.getEquipId().getCatgId() == null) {
            equipType = equipTypeService.findById(dbItem.getEquipId().getId().toString());
        } else {
            equipType = dbItem.getEquipId();
        }
        if (equipType == null) {
            return;
        }
        // Get Root Folder
        BigDecimal rootFolderId = folderService.getFolderIdByClientBy(clientId, eManageITFolder.eFLabCompliance);
        if (rootFolderId == null) {
            return;
        }
        // Get Equipment Root Folder
        BigDecimal EquipRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName, rootFolderId.toBigInteger());
        if (EquipRootFolderId == null) {
            return;
        }
        // Get Equipment Folder
        String dbFolderName = equipType.getCatgId().getCategory() + "-" + StringSupport.cutFromEnd(dbItem.getSerialNo(), 4);
        String NewFolderName = equipType.getCatgId().getCategory() + "-" + StringSupport.cutFromEnd(updateItem.getSerialNo(), 4);
        if (!dbFolderName.equals(NewFolderName)) {
            GlobFolder dbEquipFolder = folderService.getFolderByClientBy(clientId, dbFolderName, EquipRootFolderId.toBigInteger());
            if (dbEquipFolder != null) {
                dbEquipFolder.setFName(NewFolderName);
                folderService.update(dbEquipFolder);
            }
        }
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
    public List<EquipCalibAlertPojo> getEquipCalibExpiredList(BigInteger clientId, Integer alertDays) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (alertDays == null || alertDays == 0) {
            alertDays = 3;
        }
        return dao.getEquipCalibExpiredList(clientId, alertDays);
    }

    @Override
    public List<EquipMaintAlertPojo> getEquipMainExpiredList(BigInteger clientId, Integer alertDays) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (alertDays == null || alertDays == 0) {
            alertDays = 3;
        }
        return dao.getEquipMainExpiredList(clientId, alertDays);
    }

    @Override
    public void sendCalibAlertNotification(BigInteger clientId, TemplateEngine engine) {
        if (clientId != null && engine != null) {
            GlobClient clientDbId = globClientService.findById(clientId.toString());
            List<QalabEquipAlert> alertList = qalabEquipAlertService.list(new ManageITBodyRequest(0, 1)
                    .filter("clientId", clientId)
                    .filter("active", 'Y')
                    .filter("alertType", "Calibration Expiration Alert"));
            if (alertList != null && !alertList.isEmpty()) {
                QalabEquipAlert calibAlert = alertList.get(0);
                String[] emailList = calibAlert.getQalabEquipAlertConctList().stream().map(c -> c.getContactId().getEmail()).toArray(String[]::new);
                if (emailList != null) {
                    List<EquipCalibAlertPojo> dataList = getEquipCalibExpiredList(clientId, calibAlert.getAlertAtDays());
                    if (dataList != null && !dataList.isEmpty()) {
                        BpmMailMessage msg = new BpmMailMessage();
                        msg.setFrom(clientDbId.getEmailFrom());
                        // Variable Map
                        Map<String, Object> map = new HashMap<>();
                        msg.setSubject("Calibration Expiration Alert");
                        msg.setStatus("SENDED");
                        msg.setToken(null);
                        msg.setRefId(calibAlert.getId().toString());
                        msg.setTo(emailList);
                        map.put("comments", "The following Equipment is approaching out of Calibration");
                        map.put("itemList", dataList);

                        final Context ctx = new Context(Locale.ENGLISH);
                        ctx.setVariables(map);

                        final String emailBody = engine.process("qm/LabCompliance/generic-calibAlertNotification.html", ctx);
                        if (emailBody != null && !emailBody.isEmpty()) {
                            msg.setMessageText(emailBody);
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                            return;
                        }
                        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

                        if (status) {
                            ntfTrackService.save("qm", "labcompliance_calibration_alert", msg);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void sendMaintAlertNotification(BigInteger clientId, TemplateEngine engine) {
        if (clientId != null && engine != null) {
            GlobClient clientDbId = globClientService.findById(clientId.toString());
            List<QalabEquipAlert> alertList = qalabEquipAlertService.list(new ManageITBodyRequest(0, 1)
                    .filter("clientId", clientId)
                    .filter("active", 'Y')
                    .filter("alertType", "Maintenance Expiration Alert"));
            if (alertList != null && !alertList.isEmpty()) {
                QalabEquipAlert maintAlert = alertList.get(0);
                String[] emailList = maintAlert.getQalabEquipAlertConctList().stream().map(c -> c.getContactId().getEmail()).toArray(String[]::new);
                if (emailList != null) {
                    List<EquipMaintAlertPojo> dataList = getEquipMainExpiredList(clientId, maintAlert.getAlertAtDays());
                    if (dataList != null && !dataList.isEmpty()) {
                        BpmMailMessage msg = new BpmMailMessage();
                        msg.setFrom(clientDbId.getEmailFrom());
                        // Variable Map
                        Map<String, Object> map = new HashMap<>();
                        msg.setSubject("Maintenance Expiration Alert");
                        msg.setStatus("SENDED");
                        msg.setToken(null);
                        msg.setRefId(maintAlert.getId().toString());
                        msg.setTo(emailList);
                        map.put("comments", "The following Equipment is in need of Maintenance");
                        map.put("itemList", dataList);

                        final Context ctx = new Context(Locale.ENGLISH);
                        ctx.setVariables(map);

                        final String emailBody = engine.process("qm/LabCompliance/generic-maintAlertNotification.html", ctx);
                        if (emailBody != null && !emailBody.isEmpty()) {
                            msg.setMessageText(emailBody);
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                            return;
                        }
                        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

                        if (status) {
                            ntfTrackService.save("qm", "labcompliance_maintenance_alert", msg);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void assignToProject(ManageITHeader header, String projectId, String equipId) {
        if (StringSupport.isNullOrEmpty(projectId, equipId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QalabEquipinfoV2 elem = findById(equipId);
        if (elem != null) {
            if (!qalabEquipinfoProjectService.exists(NumberSupport.getBigInteger(projectId), elem.getId().toBigInteger())) {
                qalabEquipinfoProjectService.save(header, new QalabEquipinfoProjectV2(elem, NumberSupport.getBigInteger(projectId)));
            } else {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This Equipment already exists.");
            }
        }
    }

    @Override
    public QalabEquipinfoV2 findBySerialNo(BigInteger clientId, String serialNo) {
        if (clientId == null || StringSupport.isNullOrEmpty(serialNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySerialNo(clientId, serialNo);
    }

    @Override
    public BigDecimal getIdBySerialNo(BigInteger clientId, String serialNo) {
        if (clientId == null || StringSupport.isNullOrEmpty(serialNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getIdBySerialNo(clientId, serialNo);
    }

    @Override
    public String generateEquipBarcode(String tplbasePath, String docpathsegment, String reportId, String docType, String clientId, ManageITBodyRequest request, String reqId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId) || StringSupport.isNullOrEmpty(reqId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_equipinfobarcodereport", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "DispatchBarcodePrintReport": {
                    BigInteger rId = NumberSupport.getBigInteger(reqId);
                    return generateEquipBarcodePrintLog(tplbasePath, tplpath, docpathsegment, docType, rId, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateEquipBarcodePrintLog(String tplbasePath, String tplpath, String docpathsegment, String docType, BigInteger reqId, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        QalabEquipinfoV2 model = findById(StringSupport.getString(reqId));
        if (model == null) {
            return null;
        }
        EquipLogTO equipLogTo = convertToEquipLogTO(model);
        List<EquipInfoBarcodePojo> pResult = new ArrayList<>();
        pResult.add(new EquipInfoBarcodePojo(equipLogTo.getEquipment().getEqName(),
                equipLogTo.getEquipment().getEqRMSTag(),
                equipLogTo.getEquipment().getEqLabAssigned(), 
                equipLogTo.getEquipment().getEqSerialNo(), 
                equipLogTo.getEquipment().getEqManufacturer(), 
                equipLogTo.getEquipment().getEqModel(), 
                equipLogTo.getCalib().getCalibDate(), 
                equipLogTo.getCalib().getCalibDueDate()));        
        String targetPath = docpathsegment + "EquipBarcode_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
}
