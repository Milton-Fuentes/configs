/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobDispatchcallLogDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobProjectSpecsSoilcomp;
import com.atser.tools.atserejb.model.GlobServicesField;
import com.atser.tools.atserejb.model.GlobServicesLab;
import com.atser.tools.atserejb.model.GlobServicesLabCat;
import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.model.VwDispatchMainLog;
import com.atser.tools.atserejb.model.VwProctorAttLimit;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.bpm.BpmDispatchServiceImpl;
import com.atser.tools.atserejb.service.cm.CmContractActivityService;
import com.atser.tools.atserejb.service.cm.CmDailyLocationService;
import com.atser.tools.atserejb.service.qa.QaTestImagestoreService;
import com.atser.tools.atserejb.service.qa.QaconcMixdesignsService;
import com.atser.tools.atserejb.service.view.VwDispatchMainLogService;
import com.atser.tools.atserejb.service.view.VwProctorAttLimitService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.service.qa.QaSampleTestAddInfoService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eServiceType;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.GlobProjectSpecsSoilCompBO;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestFailureLogBO;
import com.atser.tools.atserutil.objects.bo.qa.QaconcMixdesignsBO;
import com.atser.tools.atserutil.objects.bo.view.VwProctorAttLimitBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.pojo.jasper.DispatchBarcodePojo;
import com.atser.tools.atserutil.objects.pojo.jasper.DispatchPrintWOPojo;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.objects.to.calendar.report.CalendarResourcesTO;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchCalllogSpecimenTO;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchRequestTO;
import com.atser.tools.atserutil.objects.to.dispatch.EngServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.FieldServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.LabServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GlobDispatchcallLogServiceImpl implements GlobDispatchcallLogService, IBaseEJBException {

    @Inject
    private GlobDispatchcallLogDao dao;

    @Inject
    private CmContractActivityService cmContractActivity;

    @Inject
    private CmDailyLocationService cmDailyLocationService;

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobContactService contactService;

    @Inject
    private GlobWorkorderService workorderService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private GlobProjectPersonnelService projPersonnelService;

    @Inject
    private GlobDispatchcallServicesService dispatchServicesService;

    @Inject
    private GlobServicesLabService labService;

    @Inject
    private GlobServicesLabCatService labCatService;

    @Inject
    private GlobServicesFieldService fieldService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private VwDispatchMainLogService vwDispatchMainLogService;

    @Inject
    private GlobProjectSpecsSoilcompService globProjectSpecsSoilcompService;

    @Inject
    private VwProctorAttLimitService vwProctorAttLimitService;

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private QaTestImagestoreService qaTestImagestoreService;

    @Inject
    private QaSampleTestAddInfoService qaSampleTestAddInfoService;

    @Override
    public GlobDispatchcallLog findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobDispatchcallLog findById(BigInteger id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobDispatchcallLog findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public DispatchRequestTO findDispatchRequestTOById(ManageITHeader header, String id) {
        try {
            if (StringSupport.isNotNullAndNotEmpty(id)) {
                return toDispatchRequestTO(header, NumberSupport.getBigInteger(id));
            }
        } catch (ParseException ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private DispatchRequestTO toDispatchRequestTO(ManageITHeader header, BigInteger callId) throws ParseException {
        if (callId != null) {
            GlobDispatchcallLog dcl = findById(NumberSupport.getBigDecimal(callId));
            if (dcl != null) {
                GlobProject project = projectService.findById(dcl.getProjectId().toString());
                GlobWorkorder wo = dcl.getWoId();
                if (project != null) {
                    List<GlobDispatchcallServices> servList = dispatchServicesService.findByCallLogId(dcl.getId().toBigInteger());
                    DispatchRequestTO to = new DispatchRequestTO();
                    to.setId(dcl.getId().toBigInteger());
                    if (wo != null) {
                        to.setWoId(wo.getId().toBigInteger());
                        to.setWoLong(wo.getWoLong());
                        to.setWonumber(wo.getWoNo());
                        to.setActivityId(wo.getActivityId());
                        to.setCertification(wo.getCertification());
                        to.setContactperson(wo.getContact());
                        to.setContactrefId(wo.getContactRefId());
                        to.setContacttelephone(wo.getContactTelephone());
                        to.setTimeatoffice(wo.getArriveLabTime());
                        to.setTravelTime(wo.getTravelTime());
                        to.setWoIscancel(StringSupport.isNotNullAndNotEmpty(wo.getCancelled()) && wo.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
                    }
                    to.setRegionId(project.getRegionId() != null ? project.getRegionId().getId().toBigInteger() : null);
                    to.setProjectId(project.getId().toBigInteger());
                    to.setDepartmentId(project.getDepartmentId());
                    to.setPersonProjectManager(project.getPersonProjectManager());
                    to.setProjectClientId(project.getProjectClientId());
                    to.setTechId(dcl.getTechRefId());
                    to.setLabFuncId(dcl.getInfoId());
                    to.setTimeatsite(dcl.getTimeSite());
                    to.setHours(dcl.getHours());
                    to.setAssigment(dcl.getAssignment());
                    to.setCalledInBy(dcl.getRequestedBy());
                    to.setDatetimeCalledIn(DateSupport.formatString(dcl.getRequestedDate() + " " + dcl.getRequestedTime(), DateSupport.factorySimpleDateFormat("MM-dd-yyyy HH:mm"), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm")));
                    to.setPaperwork(String.valueOf(dcl.getPaperworkReceived()));

                    servList.forEach((svList) -> {
                        if (svList.getType().equals(eServiceType.eEng.getValue())) {
                            to.addEngService(new EngServiceTO(svList.getServiceDesc()));
                        } else if (svList.getType().equals(eServiceType.eField.getValue())) {
                            to.addFieldService(new FieldServiceTO(NumberSupport.getBigInteger(svList.getService()), fieldService.findById(svList.getService()).getServiceFullName()));
                        } else if (svList.getType().equals(eServiceType.eLab.getValue())) {
                            GlobServicesLab lbsrv = labService.findById(svList.getService());
                            GlobServicesLabCat lbcat = labCatService.findById(lbsrv.getLabCategoryId().toString());
                            to.addLabService(new LabServiceTO(lbsrv.getLabCategoryId(), lbcat.getCategory(), NumberSupport.getBigInteger(svList.getService()), lbsrv.getLabServiceFullName()));
                        }
                    });

                    to.setSpecialinstruction(dcl.getSpecInstr());
                    to.setServiceList(dcl.getServicesRequested());
                    to.setDispatchIscancel(StringSupport.isNotNullAndNotEmpty(dcl.getCancelled()) && dcl.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
                    to.setCallServiceDate(DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US));
                    to.setTechFullName(dcl.getTechnician());

                    if (dcl.getFolderId() == null) {
                        BigDecimal fId = createDispatchFolderStruct(header, dcl);
                        if (fId != null) {
                            to.setFolderId(NumberSupport.getBigInteger(fId));
                            dcl.setFolderId(NumberSupport.getBigInteger(fId));
                            dao.update(dcl);
                        }

                    } else {
                        to.setFolderId(dcl.getFolderId());
                    }
                    return to;
                }
            }
        }
        return null;
    }

    public BigDecimal createDispatchFolderStruct(ManageITHeader header, GlobDispatchcallLog elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Dispatch Reports Folder
        BigDecimal dispatchFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId(), "Dispatch");
        if (dispatchFolderId != null) {
            try {
                // String stepName = folderService.getNextFolderNameByIncrementalStep(elem.getProjectId(), BigInteger.ZERO, "Dispatch");
                String stepName = elem.getWoId().getWoNo();
                return folderService.createTrackITFolder(dispatchFolderId, elem.getProjectId(), owner, BigInteger.ZERO, 'Y', "Y", 'N', stepName, new BigInteger("2"));
            } catch (BaseException ex) {
                return null;
            }
        }
        return null;
    }

    @Override
    public BigInteger save(GlobDispatchcallLog elem) {
        return save(null, elem);
    }

    /**
     * Don't Modify is to use it with BPM
     *
     * @param header
     * @param elem
     * @return
     */
    @Override
    public BigInteger save(ManageITHeader header, GlobDispatchcallLog elem) {
        if (elem != null) {
            if (header != null) {
                elem.setCreateBy(header.getUser());
                elem.setCreateByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
            }
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void updateDecisionFlag(GlobDispatchcallLog elem) {
        if (elem != null) {
            GlobDispatchcallLog model = findById(elem.getId());
            model.setDecisionFlag(elem.getDecisionFlag());
            dao.update(model);
        }
    }

    @Override
    public void updateDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem) {
        if (elem != null) {
            try {
                GlobDispatchcallLog model = findById(elem.getId());
                GlobProject project = projectService.findById(elem.getProjectId().toString());
                model.setServiceDate(DateSupport.parseString(elem.getCallServiceDate(), DateSupport.FORMAT_US));
                model.setProjectId(elem.getProjectId());
                model.setServicesRequested(buildStringServicesRequested(elem));
                model.setTimeSite(elem.getTimeatsite());
                model.setHours(elem.getHours());
                model.setTechnician(contactService.findById(elem.getTechId().toString()).getFullName());
                model.setSpecInstr(elem.getSpecialinstruction());
                model.setRequestedBy(elem.getCalledInBy());
                model.setRequestedTime(DateSupport.formatString(elem.getDatetimeCalledIn(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
                model.setRequestedDate(DateSupport.formatString(elem.getDatetimeCalledIn(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("MM-dd-yyyy")));
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setPaperworkReceived(elem.getPaperwork() == null ? 'N' : elem.getPaperwork().charAt(0));
                model.setAssignment(elem.getAssigment());
                model.setTechRefId(elem.getTechId());
                model.setDept(project.getDepartmentId());
                model.setInfoId(elem.getLabFuncId());
                if (elem.getWoId() != null) {
                    model.getWoId().setProjectId(elem.getProjectId());
                    model.getWoId().setCertification(elem.getCertification());
                } else {
                    GlobWorkorder woId;
                    woId = initWorkOrder(elem);
                    workorderService.save(header, woId);
                    model.setWoId(woId);
                }

                if (header != null) {
                    model.setLastModIp(header.getModIp());
                    model.setLastModBy(header.getUser());
                }

                dao.update(model);
                if (dispatchServicesService.getCountCallLogRecords(elem.getId()) > 0) {
                    dispatchServicesService.deleteAllByCallLogId(elem.getId());
                }
                List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(elem, header, elem.getId());
                dispatchServicesService.saveAll(lserv);
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateCalendarResourcesDataTO(ManageITHeader header, CalendarResourcesDataTO elem) {
        if (elem != null) {
            try {
                GlobDispatchcallLog model = findById(elem.getId());
                GlobProject project = projectService.findById(elem.getProjectId().toString());
                model.setServiceDate(DateSupport.parseString(elem.getStartTime(), DateSupport.FORMAT_US));
                model.setProjectId(elem.getProjectId());
                model.setServicesRequested(buildStringServicesRequested(elem));
                model.setTimeSite(DateSupport.formatString(elem.getStartTime(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
                model.setHours(elem.getHours());
                if (StringSupport.isNotNullAndNotEmpty(elem.getOwnerId()) && !elem.getOwnerId().equals("-1")) {
                    model.setTechnician(contactService.findById(elem.getOwnerId()).getFullName());
                    model.setTechRefId(NumberSupport.getBigInteger(elem.getOwnerId()));
                    model.setEmailStatus("PENDING");
                    model.setEmailReason("Notify Technician");
                    model.setStatus("Created");
                } else {
                    model.setStatus("Draft");
                    model.setTechRefId(NumberSupport.getBigInteger("-1"));
                    model.setEmailStatus("");
                    model.setEmailReason("");
                }
                model.setSpecInstr(elem.getSpecialInstr());
                model.setCancelledReason(elem.getCancelledReason());
                model.setRequestedBy(elem.getRequestedBy());
                model.setRequestedTime(DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("HH:mm")));
                model.setRequestedDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_US_DASH));
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setPaperworkReceived('N');
                model.setAssignment("Full-Time");
                model.setDept(project.getDepartmentId());
                model.setInfoId(elem.getInfoId());
                if (model.getWoId() != null) {
                    model.getWoId().setProjectId(elem.getProjectId());
                    model.getWoId().setContact(elem.getSiteContact());
                    model.getWoId().setContactTelephone(elem.getSitePhone());
                    model.getWoId().setTravelTime(elem.getTravelTime());
                    model.getWoId().setServiceDate(DateSupport.parseString(elem.getStartTime(), DateSupport.FORMAT_US));
                    model.getWoId().setMaterialUseId(elem.getMaterialUseId());
                    model.getWoId().setCertification(elem.getCertification());
                }
                if (header != null) {
                    model.setLastModIp(header.getModIp());
                    model.setLastModBy(header.getUser());
                }
                dao.update(model);
                List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(elem, header, NumberSupport.getBigInteger(elem.getId()));
                if (lserv != null && !lserv.isEmpty()) {
                    if (dispatchServicesService.getCountCallLogRecords(NumberSupport.getBigInteger(elem.getId())) > 0) {
                        dispatchServicesService.deleteAllByCallLogId(NumberSupport.getBigInteger(elem.getId()));
                    }
                    dispatchServicesService.saveAll(lserv);
                }

                // Schedule Next Cilinder Pickup
                if (StringSupport.isNotNullAndNotEmpty(elem.getCylinderPickupStatus(), elem.getCylinderPickupDate()) && StringSupport.getBoolean(elem.getCylinderPickupStatus())) {
                    saveNextDayCilindirPickupWO(header, elem, model.getId().toBigInteger());
                }
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateWoFromDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem) {
        if (elem != null) {
            try {
                GlobDispatchcallLog model = findById(elem.getId());
                model.setServicesRequested(buildStringServicesRequested(elem));
                model.setTimeSite(elem.getTimeatsite());
                model.setTechnician(contactService.findById(elem.getTechId().toString()).getFullName());
                model.setSpecInstr(elem.getSpecialinstruction());
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setTechRefId(elem.getTechId());
                model.setInfoId(elem.getLabFuncId());
                if (elem.getWoId() != null) {
                    GlobWorkorder woId = model.getWoId();
                    woId.setServiceDate(DateSupport.parseString(elem.getWoServiceDate(), DateSupport.FORMAT_US));
                    woId.setContact(elem.getContactperson());
                    woId.setArriveLabTime(elem.getTimeatoffice());
                    woId.setActivityId(elem.getActivityId());
                    woId.setCertification(elem.getCertification());
                    woId.setContactTelephone(elem.getContacttelephone());
                    woId.setTravelTime(elem.getTravelTime());
                    workorderService.frontUpdate(header, woId);
                }

                if (header != null) {
                    model.setLastModIp(header.getModIp());
                    model.setLastModBy(header.getUser());
                }

                dao.update(model);
                if (dispatchServicesService.getCountCallLogRecords(elem.getId()) > 0) {
                    dispatchServicesService.deleteAllByCallLogId(elem.getId());
                }
                List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(elem, header, elem.getId());
                dispatchServicesService.saveAll(lserv);
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Don't Modify is to use it with BPM
     *
     * @param elem
     */
    @Override
    public void update(GlobDispatchcallLog elem) {
        if (elem != null) {
            GlobDispatchcallLog model = findById(elem.getId());
            model.setServiceDate(elem.getServiceDate());
            model.setServicesRequested(elem.getServicesRequested());
            model.setTimeSite(elem.getTimeSite());
            model.setHours(elem.getHours());
            model.setTechnician(elem.getTechnician());
            model.setCancelled(elem.getCancelled());
            model.setSpecInstr(elem.getSpecInstr());
            model.setLastMod(elem.getLastMod());
            model.setLastModBy(elem.getLastModBy());
            Integer v = Integer.valueOf(model.getVersion()) + 1;
            model.setVersion(v.toString());
            model.setPaperworkReceived(elem.getPaperworkReceived());
            model.setAssignment(elem.getAssignment());
            model.setInfoId(elem.getInfoId());
            model.setTechRefId(elem.getTechRefId());
            model.setDecisionFlag(elem.getDecisionFlag());
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
    public void saveDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem) {
        if (elem != null) {
            try {
                BigInteger dispatchId;
                GlobWorkorder woId;
                GlobProject project = projectService.findById(elem.getProjectId().toString());
                GlobDispatchcallLog rp = new GlobDispatchcallLog();
                rp.setServiceDate(DateSupport.parseString(elem.getCallServiceDate(), DateSupport.FORMAT_US));
                rp.setProjectId(elem.getProjectId());
                rp.setServicesRequested(buildStringServicesRequested(elem));
                rp.setTimeSite(elem.getTimeatsite());
                rp.setHours(elem.getHours());
                rp.setTechnician(contactService.findById(elem.getTechId().toString()).getFullName());
                rp.setCancelled("No");
                rp.setSpecInstr(elem.getSpecialinstruction());
                rp.setRequestedBy(elem.getCalledInBy());
                rp.setRequestedTime(DateSupport.formatString(elem.getDatetimeCalledIn(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
                rp.setActive('Y');
                rp.setVersion("1");
                rp.setRequestedDate(DateSupport.formatString(elem.getDatetimeCalledIn(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("MM-dd-yyyy")));
                rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                rp.setCreateDate(new Date());
                rp.setPaperworkReceived(elem.getPaperwork() == null ? 'N' : elem.getPaperwork().charAt(0));
                rp.setAssignment(elem.getAssigment());
                rp.setTechRefId(elem.getTechId());
                rp.setDept(project.getDepartmentId());
                rp.setInfoId(elem.getLabFuncId());
                rp.setReqLocation("-1");
                woId = initWorkOrder(elem);
                workorderService.save(header, woId);
                if (woId != null) {
                    rp.setWoId(woId);
                    dispatchId = save(header, rp);
                    if (dispatchServicesService.getCountCallLogRecords(dispatchId) > 0) {
                        dispatchServicesService.deleteAllByCallLogId(dispatchId);
                    }
                    List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(elem, header, dispatchId);
                    dispatchServicesService.saveAll(lserv);
                }
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private GlobWorkorder initWorkOrder(DispatchRequestTO elem) throws ParseException {
        GlobWorkorder rp = new GlobWorkorder();
        rp.setServiceDate(DateSupport.parseString(elem.getCallServiceDate(), DateSupport.FORMAT_US));
        rp.setProjectId(elem.getProjectId());
        rp.setCertification(elem.getCertification());
        rp.setCancelled("No");
        rp.setActive('Y');
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setCreateDate(new Date());
        rp.setWoToken(UUID.randomUUID().toString());
        rp.setTravelTime(elem.getTravelTime());
        rp.setVersion("1");
        return rp;
    }

    private GlobWorkorder initWorkOrder(GlobDispatchcallLog elem) throws ParseException {
        GlobWorkorder rp = new GlobWorkorder();
        rp.setServiceDate(elem.getServiceDate());
        rp.setProjectId(elem.getProjectId());
        rp.setCancelled("No");
        rp.setActive('Y');
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setCreateDate(new Date());
        rp.setWoToken(UUID.randomUUID().toString());
        rp.setTravelTime("None");
        rp.setVersion("1");
        return rp;
    }

    private GlobWorkorder initWorkOrder(CalendarResourcesDataTO elem) throws ParseException {
        GlobWorkorder rp = new GlobWorkorder();
        Map<String, String> woNumb = workorderService.getNextWorkOrderNumbers(elem.getProjectId());
        rp.setWoNo(woNumb.get("woNo"));
        rp.setWoLong(woNumb.get("woLong"));
        rp.setWoShort(NumberSupport.getBigInteger(woNumb.get("woNo")));
        rp.setServiceDate(DateSupport.parseString(elem.getStartTime(), DateSupport.FORMAT_US));
        rp.setProjectId(elem.getProjectId());
        //rp.setCertification(elem.getCertification());
        rp.setCancelled("No");
        rp.setContact(elem.getSiteContact());
        rp.setContactTelephone(elem.getSitePhone());
        rp.setActive('Y');
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setCreateDate(new Date());
        rp.setWoToken(UUID.randomUUID().toString());
        rp.setTravelTime(elem.getTravelTime());
        rp.setMaterialUseId(elem.getMaterialUseId());
        rp.setVersion("0");
        return rp;
    }

    private List<GlobDispatchcallServices> toGlobDispatchcallServices(DispatchRequestTO wo, ManageITHeader header, BigInteger dispatchId) {
        List<GlobDispatchcallServices> rpl = new ArrayList<>();
        BigInteger counter = BigInteger.ZERO;

        for (EngServiceTO it : wo.getEngService()) {
            if (it != null && StringSupport.isNotNullAndNotEmpty(it.getTypeofservice())) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, null, it.getTypeofservice(), eServiceType.eEng.getValue(), header.getUser(), header.getModIp(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (FieldServiceTO it : wo.getFieldService()) {
            if (it != null && it.getServiceId() != null) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, it.getServiceId().toString(), null, eServiceType.eField.getValue(), header.getUser(), header.getModIp(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (LabServiceTO it : wo.getLabService()) {
            if (it != null && it.getTestTypeId() != null) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, it.getTestTypeId().toString(), null, eServiceType.eLab.getValue(), header.getUser(), header.getModIp(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        return rpl;
    }

    private List<GlobDispatchcallServices> toGlobDispatchcallServices(CalendarResourcesDataTO wo, ManageITHeader header, BigInteger dispatchId) {
        List<GlobDispatchcallServices> rpl = new ArrayList<>();
        BigInteger counter = BigInteger.ZERO;

        for (FieldServiceTO it : wo.getFieldService()) {
            if (it != null && it.getServiceId() != null) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, it.getServiceId().toString(), null, eServiceType.eField.getValue(), header.getUser(), header.getModIp(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        return rpl;
    }

    @Override
    public BigDecimal copyRequest(ManageITHeader header, String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobDispatchcallLog model = findById(NumberSupport.getBigDecimal(id));
        GlobDispatchcallLog dclCopy = model.clone();
        if (model.getWoId() == null) {
            throwBaseException(Response.Status.EXPECTATION_FAILED, "Operation not allowed. Request does not contains a valid WO.");
        }
        // Work Order Copy
        GlobWorkorder woCopy = model.getWoId().clone();
        woCopy.setId(null);
        Map<String, String> woNumb = workorderService.getNextWorkOrderNumbers(model.getProjectId());
        woCopy.setWoNo(woNumb.get("woNo"));
        woCopy.setWoLong(woNumb.get("woLong"));
        woCopy.setWoShort(NumberSupport.getBigInteger(woNumb.get("woNo")));
        woCopy.setCreateDate(new Date());
        woCopy.setWoToken(UUID.randomUUID().toString());
        woCopy.setVersion("0");
        workorderService.save(header, woCopy);
        // DispatchCallLog Copy
        dclCopy.setId(null);
        dclCopy.setWoId(woCopy);
        dclCopy.setServicesRequested(null);
        dclCopy.setFolderId(null);
        dclCopy.setEmailStatus(null);
        dclCopy.setEmailReason(null);
        dclCopy.setParentId(null);
        dclCopy.setCreateDate(new Date());
        dclCopy.setVersion("0");
        if (header != null) {
            dclCopy.setCreateBy(header.getUser());
            dclCopy.setCreateByIp(header.getModIp());
            dclCopy.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            dclCopy.setLastModIp(header.getModIp());
            dclCopy.setLastModBy(header.getUser());
        }
        return dao.save(dclCopy).getId();
    }

    @Override
    public void saveCalendarResourcesDataTO(ManageITHeader header, CalendarResourcesDataTO elem) {
        if (StringSupport.isNullOrEmpty(elem.getRecurrenceDates())) {
            saveCalendarResourcesDataTO(header, elem, null);
        } else {
            String[] dateArray = elem.getRecurrenceDates().split(",");
            try {
                String currentServiceDate = DateSupport.formatString(elem.getStartTime(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("MM/dd/yyyy"));
                String timeSite = DateSupport.formatString(elem.getStartTime(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm"));
                elem.setRecurrence("false");
                saveCalendarResourcesDataTO(header, elem, null);
                for (String serviceDate : dateArray) {
                    if (currentServiceDate.equals(serviceDate)) {
                        continue;
                    }
                    elem.setStartTime(serviceDate + " " + timeSite);
                    elem.setRecurrence("true");
                    if (StringSupport.isNotNullAndNotEmpty(elem.getCylinderPickupStatus(), elem.getCylinderPickupDate()) && StringSupport.getBoolean(elem.getCylinderPickupStatus())) {
                        elem.setCylinderPickupDate(DateSupport.formatDate(DateSupport.addChronoUnitToDate(DateSupport.parseString(serviceDate, DateSupport.FORMAT_US), ChronoUnit.DAYS, 1L), DateSupport.FORMAT_US) + " " + timeSite);
                    }
                    saveCalendarResourcesDataTO(header, elem, null);
                }
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void saveCalendarResourcesDataTO(ManageITHeader header, CalendarResourcesDataTO elem, BigInteger parentId) {
        if (elem != null) {
            try {
                BigInteger dispatchId;
                GlobWorkorder woId;
                GlobProject project = projectService.findById(elem.getProjectId().toString());
                GlobDispatchcallLog rp = new GlobDispatchcallLog();
                rp.setServiceDate(DateSupport.parseString(elem.getStartTime(), DateSupport.FORMAT_US));
                rp.setProjectId(elem.getProjectId());
                rp.setServicesRequested(buildStringServicesRequested(elem));
                rp.setTimeSite(DateSupport.formatString(elem.getStartTime(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
                rp.setHours(elem.getHours());
                if (StringSupport.isNotNullAndNotEmpty(elem.getOwnerId()) && !elem.getOwnerId().equals("-1")) {
                    rp.setTechnician(contactService.findById(elem.getOwnerId()).getFullName());
                    rp.setTechRefId(NumberSupport.getBigInteger(elem.getOwnerId()));
                    rp.setStatus("Created");
                    rp.setEmailStatus("PENDING");
                    rp.setEmailReason("Notify Technician");
                } else {
                    rp.setStatus("Draft");
                    rp.setTechRefId(NumberSupport.getBigInteger("-1"));
                }
                rp.setCancelled("No");
                rp.setSpecInstr(elem.getSpecialInstr());
                rp.setRequestedBy(elem.getRequestedBy());
                rp.setRequestedTime(DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("HH:mm")));
                rp.setActive('Y');
                rp.setVersion("0");
                rp.setRequestedDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_US_DASH));
                rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                rp.setCreateDate(new Date());
                rp.setPaperworkReceived('N');
                rp.setAssignment("Full-Time");
                rp.setDept(project.getDepartmentId());
                rp.setInfoId(elem.getInfoId());
                rp.setReqLocation("-1");
                if (parentId != null) {
                    rp.setParentId(parentId);
                }
                woId = initWorkOrder(elem);
                workorderService.save(header, woId);
                if (woId != null) {
                    rp.setWoId(woId);
                    dispatchId = save(header, rp);
                    // Check Flags
                    Map<String, Boolean> clientFlags = globClientService.getMapFlags(header.getClientid());
                    if (clientFlags != null && clientFlags.get("dispatch_auto_assign_daily_report")) {
                        GlobServicesField dailyServ = fieldService.findByAbbrvAndClientId("DFR", NumberSupport.getBigInteger(header.getClientid()));
                        if (elem.getFieldService() != null && dailyServ != null) {
                            Optional<FieldServiceTO> matchDailyServ = elem.getFieldService().stream().filter(p -> p.getServiceId().equals(dailyServ.getId().toBigInteger())).findFirst();
                            if (!matchDailyServ.isPresent()) {
                                elem.getFieldService().add(new FieldServiceTO(dailyServ.getId().toBigInteger(), null));
                            }
                        }
                    }

                    List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(elem, header, dispatchId);
                    if (lserv != null && !lserv.isEmpty()) {
                        if (dispatchServicesService.getCountCallLogRecords(dispatchId) > 0) {
                            dispatchServicesService.deleteAllByCallLogId(dispatchId);
                        }
                        dispatchServicesService.saveAll(lserv);
                    }

                    // Schedule Next Cilinder Pickup
                    if (StringSupport.isNotNullAndNotEmpty(elem.getCylinderPickupStatus(), elem.getCylinderPickupDate()) && StringSupport.getBoolean(elem.getCylinderPickupStatus())) {
                        saveNextDayCilindirPickupWO(header, elem, dispatchId);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void saveNextDayCilindirPickupWO(ManageITHeader header, CalendarResourcesDataTO elem, BigInteger dispatchId) throws ParseException {
        CalendarResourcesDataTO elemc = elem.clone();
        List<GlobServicesField> dbServList = fieldService.list(new ManageITBodyRequest(0, 0).filter("clientId", header.getClientid()).filter("serviceAbbrev", "CPU"));
        if (dbServList == null || dbServList.isEmpty()) {
            return;
        }
        List<FieldServiceTO> fServList = dbServList.stream().map(it -> new FieldServiceTO(it.getId().toBigInteger())).collect(Collectors.toList());
        elemc.setFieldService(fServList);
        elemc.setStartTime(elem.getCylinderPickupDate());
        elemc.setCylinderPickupDate(null);
        elemc.setCylinderPickupStatus(null);
        saveCalendarResourcesDataTO(header, elemc, dispatchId);
    }

    @Override
    public List<GlobDispatchcallLog> list(ManageITBodyRequest request) {
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
    public List<GlobDispatchcallLog> findByRequestOrigID(BigInteger id) {
        return dao.findByRequestOrigID(id);
    }

    @Override
    public List<GlobDispatchcallLog> findByProjectID(BigInteger id) {
        return dao.findByProjectID(id);
    }

    @Override
    public GlobDispatchcallLog findByWOID(BigInteger id) {
        return dao.findByWOID(id);
    }

    @Override
    public List<WorkOrderTO> listTo(ManageITBodyRequest request) {
        List<GlobDispatchcallLog> wolist = list(request);
        List<WorkOrderTO> responseList = new ArrayList<>();
        wolist.forEach((dcl) -> {
            if (dcl.getId() != null && dcl.getWoId() != null && dcl.getWoId().getId() != null) {
                try {
                    responseList.add(toWorkOrderTO(dcl));
                } catch (ParseException ex) {
                    Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return responseList;
    }

    @Override
    public DataTableWrapper<WorkOrderTO> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<WorkOrderTO> finalList = listTo(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    /**
     * Convert to WorkOrderTO
     *
     * @param calllog
     * @return
     * @throws ParseException
     */
    private WorkOrderTO toWorkOrderTO(GlobDispatchcallLog calllog) throws ParseException {
        GlobWorkorder wo = calllog.getWoId();
        WorkOrderTO woTo = new WorkOrderTO();
        woTo.setLogId(calllog.getId().toBigInteger());
        woTo.setWoId(wo.getId().toBigInteger());
        woTo.setHours(calllog.getHours());
        woTo.setSpecialinstruction(calllog.getSpecInstr());
        woTo.setTechRefId(calllog.getTechRefId());
        woTo.setTechFullName(calllog.getTechnician());
        woTo.setDecisionFlag(calllog.getDecisionFlag());
        woTo.setServiceDate(DateSupport.formatDate(calllog.getServiceDate(), DateSupport.FORMAT_US));
        woTo.setPaperworkReceived(String.valueOf(calllog.getPaperworkReceived()));
        woTo.setAssigment(calllog.getAssignment());
        woTo.setInfo_id(calllog.getInfoId());
        woTo.setWonumber(wo.getWoNo());
        woTo.setCertification(wo.getCertification());
        woTo.setContactperson(wo.getContact());
        woTo.setContacttelephone(wo.getContactTelephone());
        if (wo.getArriveLabTime() != null && !wo.getArriveLabTime().isEmpty()) {
            woTo.setTimeatoffice(DateSupport.formatString(wo.getArriveLabTime(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
        }
        if (calllog.getTimeSite() != null && !calllog.getTimeSite().isEmpty()) {
            woTo.setTimeatsite(DateSupport.formatString(calllog.getTimeSite(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
        }
        if (wo.getCancelled() != null && !wo.getCancelled().isEmpty()) {
            woTo.setIscancel(wo.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
        }
        woTo.setServiceList(calllog.getServicesRequested());
        woTo.setTraceDescription(cmContractActivity.getActivityName(wo.getActivityId(), "nd"));
        woTo.setRlocation(cmDailyLocationService.getDailyLocation(calllog.getReqLocation()));
        return woTo;
    }

    @Override
    public void discardNotification(ManageITBodyRequest request) {
        if (request == null || request.getParams() == null || !request.getParams().isContainsAllKeysAndNotNull(new String[]{"callIdList"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String callIdList = StringSupport.getString(request.getParams().get("callIdList"));
        if (StringSupport.isNotNullAndNotEmpty(callIdList)) {
            String[] idList = callIdList.split(",");
            for (String callId : idList) {
                GlobDispatchcallLog dcl = findById(callId);
                if (dcl != null) {
                    dcl.setEmailStatus("DISCARDED");
                    dao.update(dcl);
                }
            }
        }
    }

    @Override
    public void notifyTechnicians(ManageITBodyRequest request, String server_domain, TemplateEngine engine) {
        if (request == null || request.getParams() == null || !request.getParams().isContainsAllKeysAndNotNull(new String[]{"callIdList"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String callIdList = StringSupport.getString(request.getParams().get("callIdList"));
        String status = StringSupport.getString(request.getParams().get("status"));
        if (StringSupport.isNotNullAndNotEmpty(callIdList)) {
            String[] idList = callIdList.split(",");
            for (String callId : idList) {
                GlobDispatchcallLog dcl = findById(callId);
                if (dcl != null) {
                    GlobProject project = projectService.findById(dcl.getProjectId().toString());
                    GlobWorkorder wo = dcl.getWoId();
                    if (wo != null) {
                        if (StringSupport.isNullOrEmpty(wo.getWoToken())) {
                            wo.setWoToken(UUID.randomUUID().toString());
                            workorderService.updateWoToken(wo);
                        }
                        Map<String, Boolean> clientFlags = globClientService.getMapFlags(StringSupport.getString(project.getClientId().getId()));
                        notifyTechnician(callId, status, server_domain, engine, dcl, wo, project, clientFlags);
                    }
                }
            }
        }
    }

    /**
     * Notify Technician
     *
     * @param persistenceId
     * @param server_domain
     * @param engine
     * @param dbo
     * @param dcl
     * @param wo
     * @param project
     */
    private void notifyTechnician(String callId, String status, String server_domain, TemplateEngine engine, GlobDispatchcallLog dcl, GlobWorkorder wo, GlobProject project, Map<String, Boolean> clientFlags) {
        log.info("@ATSER - Execution Notification Email Method.");
        Boolean isCancel = (StringSupport.isNotNullAndNotEmpty(wo.getCancelled()) && wo.getCancelled().toLowerCase().equals("yes"));
        if (StringSupport.isNullOrEmpty(dcl.getTechnician())) {
            throwBaseException(Response.Status.EXPECTATION_FAILED, "To send emails you must assign a technician first.");
        }
        if (dcl.getTechRefId() != null && (dcl.getTechRefId().compareTo(new BigInteger("-1")) != 0)) {
            GlobContact techContact = contactService.findById(dcl.getTechRefId().toString());
            if (techContact == null || StringSupport.isNullOrEmpty(techContact.getEmail())) {
                log.error(String.format("@ATSER - The technician's email '%s' could not be found.", techContact.getEmail()));
                throwBaseException(Response.Status.EXPECTATION_FAILED, "The technician's email could not be found.");
            }
            // Notify by Email
            notifyByEmail(callId, status, techContact, server_domain, engine, dcl, wo, project, isCancel, clientFlags);
            // Notify by MMS
            if (StringSupport.getBoolean(techContact.getNotfSmsActive())) {
                notifyByMMS(callId, techContact, dcl, wo, project, isCancel);
            }
        } else {
            log.error("@ATSER - Please assign a Technician to this request.");
            throwBaseException(Response.Status.EXPECTATION_FAILED, "Please assign a Technician to this request.");
        }
    }

    private void notifyByMMS(String callId, GlobContact techContact, GlobDispatchcallLog dcl, GlobWorkorder wo, GlobProject project, Boolean isCancel) {
        log.info("@ATSER - Notifying by MMS.");
        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom("wwwmail@atser.com");
        String smsEmail = MailSender.getSmsEmail(techContact.getNotfPhone(), techContact.getNotfMCarrier());
        List<String> ntfEmail = new ArrayList<>();
        StringBuilder smsbody = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(smsEmail)) {
            ntfEmail.add(smsEmail);
            if (!isCancel) {
                msg.setSubject("Work Assignment");
                msg.setStatus("SENDED");
                msg.setToken(null);
            } else {
                msg.setSubject("Work Assignment was cancelled");
                msg.setStatus("SENDED");
                msg.setToken(null);
            }
            msg.setRefId(callId);
            msg.setTo(ntfEmail.stream().toArray(String[]::new));
            smsbody.append("Project No: ").append(project.getPNumber()).append("\n");
            smsbody.append("WO Number: ").append(wo.getWoNo()).append("\n");
            smsbody.append("Service Date: ").append(DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US)).append(" ").append(dcl.getTimeSite()).append("\n");
            smsbody.append("Please review your email for details.");
            msg.setMessageText(smsbody.toString());

            Boolean status = MailSender.sendEmailDefault(mailSession, msg);

            if (status) {
                ntfTrackService.save("qm", "basic_dispatch", msg, "MMS");
            }
        }
    }

    private void notifyByEmail(String callId, String status, GlobContact techContact, String server_domain, TemplateEngine engine, GlobDispatchcallLog dcl, GlobWorkorder wo, GlobProject project, Boolean isCancel, Map<String, Boolean> clientFlags) {
        log.info("@ATSER - Notifying by Email.");
        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom(project.getClientId().getEmailFrom());
        log.info(String.format("@ATSER - Using '%s' email as Sent From.", project.getClientId().getEmailFrom()));

        // Variable Map
        Map<String, Object> map = new HashMap<>();
        String token = UUID.randomUUID().toString().replace("-", "");
        if (!isCancel) {
            msg.setSubject("Dispatch Request - Work Assignment");
            msg.setStatus("WAITING");
            msg.setToken(token);
        } else {
            msg.setSubject("Dispatch Request - Work Assignment was cancelled");
            msg.setStatus("SENDED");
            msg.setToken(null);
        }

        msg.setRefId(callId);
        List<String> ntfEmail = new ArrayList<>();
        if (StringSupport.isNotNullAndNotEmpty(techContact.getEmail())) {
            ntfEmail.add(techContact.getEmail());
            msg.setTo(ntfEmail.stream().toArray(String[]::new));
            map.put("vTechName", dcl.getTechnician());
            map.put("showButtons", !isCancel);
            map.put("isCancel", isCancel);
            map.put("vProjectName", project.getPName());
            map.put("vProjectAddress", project.getFullProjectAddress());
            map.put("vWoNo", wo.getWoNo());
            map.put("vRequestedBy", dcl.getRequestedBy());
            map.put("vServicesRequested", dcl.getServicesRequested());
            map.put("vServiceDate", DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US));
            map.put("vArriveLabTime", wo.getArriveLabTime());
            map.put("vTimeSite", dcl.getTimeSite());
            map.put("vSpecialInstructions", dcl.getSpecInstr());
            map.put("vURLYes", "https://" + server_domain + "/ws/rs/form/bdispatch/technician?t=" + token + "&r=Y&k=" + dcl.getId());
            map.put("vURLNo", "https://" + server_domain + "/ws/rs/form/bdispatch/technician?t=" + token + "&r=N&k=" + dcl.getId());
            map.put("vURLDownloadWO", "https://" + server_domain + "/ws/rs/glob/dispatchcalllog/generate/workorder/external?t=" + wo.getWoToken() + "&rId=DispatchCallLogPrintAllWO&h=" + StringSupport.getString(project.getClientId().getId()));
            map.put("vURLImagesList", "https://" + server_domain + "/cc/fileserver.jsp?tk=" + wo.getWoToken() + "&rpath=testimg");
            map.put("vURLWorkOrderDocumentList", "https://" + server_domain + "/cc/fileserver.jsp?tk=" + wo.getWoToken() + "&rpath=wodoc");
            map.put("vUseFailureLog", clientFlags.get("use_failure_log_notification"));
            map.put("vURLWorkOrderFailureList", "https://" + server_domain + "/ws/rs/glob/dispatchcalllog/generate/workorder/external?t=" + wo.getWoToken() + "&rId=DispatchCallLogPrintFailureLog&h=" + StringSupport.getString(project.getClientId().getId()));

            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);

            final String emailBody = engine.process("Dispatch/email-techBasicNotification.html", ctx);
            if (emailBody != null && !emailBody.isEmpty()) {
                msg.setMessageText(emailBody);
            } else {
                log.error("@ATSER - Email Template not Found.");
                throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                return;
            }

            Boolean emailstatus = MailSender.sendEmailDefault(mailSession, msg);
            log.info("@ATSER - Email Status: " + emailstatus);
            if (emailstatus) {
                ntfTrackService.save("qm", "basic_dispatch", msg);
                if (StringSupport.isNotNullAndNotEmpty(status)) {
                    dcl.setEmailStatus(status);
                    dao.update(dcl);
                }
            } else {
                log.error(String.format("@ATSER - The Email could not be sended. BpmMailMsg: '%s'", msg.toString()));
                log.error(String.format("@ATSER - The Email could not be sended. MailMessage: '%s'", ((MailMessage) msg).toString()));
            }
        } else {
            log.error(String.format("@ATSER - The technician's email '%s' could not be found.", techContact.getEmail()));
            throwBaseException(Response.Status.EXPECTATION_FAILED, "The technician's email could not be found.");
        }
    }

    @Override
    public String generateGlobalBarcodes(String tplbasePath, String docpathsegment, ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null || !body.getParams().isContainsAllKeysAndNotNull(new String[]{
            "docType", "printType", "reportId", "functionId"}) || StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), StringSupport.getString(body.getParams().get("functionId")), StringSupport.getString(body.getParams().get("reportId")));
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (StringSupport.getString(body.getParams().get("reportId"))) {
                case "DispatchBarcodePrintReport": {
                    return generateBarcodeBySpecimensPrintLog(tplbasePath, tplpath, docpathsegment, header, body, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateBarcodeBySpecimensPrintLog(String tplbasePath, String tplpath, String docpathsegment, ManageITHeader header, ManageITBodyRequest<Object> body, Map<String, Object> paramsJasper) {
        if (body.getParams() == null || !body.getParams().isContainsAllKeysAndNotNull(new String[]{"docType", "specList"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        eDocExtension extension;
        if (StringSupport.getString(body.getParams().get("docType")) == null || StringSupport.getString(body.getParams().get("docType")).isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(StringSupport.getString(body.getParams().get("docType")));
        }
        List<DispatchBarcodePojo> pResult = generateBarcodeDataBySpecimens(StringSupport.emptyOnNull(StringSupport.getString(body.getParams().get("specList"))));
        String targetPath = docpathsegment + "BarcodeReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DispatchBarcodePojo> generateBarcodeDataBySpecimens(String specList) {
        if (StringSupport.isNullOrEmpty(specList)) {
            return null;
        }
        List<DispatchCalllogSpecimenTO> dispatchList = dao.findBySpecimenList(specList);
        if (dispatchList == null) {
            return null;
        }
        List<DispatchBarcodePojo> rp = new ArrayList<>();
        dispatchList.forEach(it -> {
            GlobDispatchcallLog callLog = findById(it.getCalllogId());
            if (callLog != null) {
                GlobProject project = projectService.findById(StringSupport.emptyOnNull(callLog.getProjectId()));
                if (project != null) {
                    rp.add(new DispatchBarcodePojo(callLog.getWoId().getWoNo(), project.getPNumber(), it.getSpecNo(), callLog.getTechnician(), DateSupport.formatDate(callLog.getServiceDate(), DateSupport.FORMAT_US)));
                }
            }
        });
        return rp;
    }

    @Override
    public String generateScheduleBarcodeReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request, String reqId, String setNo, String specNo) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId) || StringSupport.isNullOrEmpty(reqId, setNo, specNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_dispatchbarcodereport", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "DispatchBarcodePrintReport": {
                    BigInteger rId = NumberSupport.getBigInteger(reqId);
                    Integer sNo = NumberSupport.getInteger(setNo);
                    Integer spNo = NumberSupport.getInteger(specNo);
                    return generateDispatchBarcodeDataLog(tplbasePath, tplpath, docpathsegment, docType, rId, sNo, spNo, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateDispatchBarcodeDataLog(String tplbasePath, String tplpath, String docpathsegment, String docType, BigInteger reqId, Integer setNo, Integer specNo, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        GlobDispatchcallLog model = findById(reqId);
        if (model == null) {
            return null;
        }
        GlobProject project = projectService.findById(StringSupport.emptyOnNull(model.getProjectId()));
        if (project == null) {
            return null;
        }
        List<GlobDispatchcallServices> servList = dispatchServicesService.findByCallLogId(reqId);
        if (servList == null || servList.isEmpty()) {
            return null;
        }
        List<DispatchBarcodePojo> pResult = generateBarcodeData(project.getPNumber(), model, setNo, specNo, servList);
        String targetPath = docpathsegment + "DispatchBarcode_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DispatchBarcodePojo> generateBarcodeData(String projectNo, GlobDispatchcallLog callLog, Integer setNo, Integer specNo, List<GlobDispatchcallServices> servList) {
        List<DispatchBarcodePojo> rp = new ArrayList<>();
        List<String> typeList = new ArrayList<>();
        servList.forEach((it) -> {
            if (it.getType().equals(eServiceType.eField.getValue())) {
                if (StringSupport.isNotNullAndNotEmpty(it.getService())) {
                    GlobServicesField fieldServ = fieldService.findById(it.getService());
                    if (StringSupport.isNotNullAndNotEmpty(fieldServ.getServiceAbbrev())) {
                        switch (fieldServ.getServiceAbbrev()) {
                            case "CFI":
                            case "CFO": {
                                typeList.add("C");
                                break;
                            }
                            case "MFT": {
                                typeList.add("M");
                                break;
                            }
                            case "GFT": {
                                typeList.add("G");
                                break;
                            }
                            case "BFT": {
                                typeList.add("B");
                                break;
                            }
                        }
                    }
                }
            }
        });

        typeList.forEach(it -> {
            for (int i = 1; i <= setNo; i++) {
                for (int j = 1; j <= specNo; j++) {
                    String bcode = projectNo + callLog.getWoId().getWoNo() + it + "S" + i + j;
                    rp.add(new DispatchBarcodePojo(callLog.getWoId().getWoNo(), projectNo, bcode, callLog.getTechnician(), DateSupport.formatDate(callLog.getServiceDate(), DateSupport.FORMAT_US)));
                }
            }
        });
        return rp;
    }

    @Override
    public String generateScheduleReport(String tplbasePath, String docpathsegment, ManageITHeader header, GlobSheduleSearchDefParam defParam) {
        if (defParam == null || StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(defParam.reportId, defParam.functionId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), defParam.functionId, defParam.reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (defParam.reportId) {
                case "DispatchSchedulePrintReport": {
                    return generateDispatchSchedulePrintLog(tplbasePath, tplpath, docpathsegment, header, defParam, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateDispatchSchedulePrintLog(String tplbasePath, String tplpath, String docpathsegment, ManageITHeader header, GlobSheduleSearchDefParam defParam, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (defParam.docType == null || defParam.docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(defParam.docType);
        }

        GlobProject project = projectService.findById(StringSupport.emptyOnNull(defParam.projectId));
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        paramsJasper.put("PROJECT_LOGO", projectLogoImage);

        // Get Data for Build the TO
        List<CalendarResourceTO> rList = buildAllDispatchCalendarResources(header, defParam);
        List<CalendarResourcesDataTO> rData = buildDispatchSchedule(header, defParam, Boolean.FALSE);

        // Fill Calendar WO TO
        List<CalendarResourcesTO> pResult = new ArrayList<>();

        rList.forEach(rIt -> {
            List<CalendarResourcesDataTO> tmpData = rData.stream().filter((robj) -> (robj.getOwnerId().equals(rIt.getId()))).collect(Collectors.toList());
            if (!tmpData.isEmpty()) {
                CalendarResourcesTO crTo = new CalendarResourcesTO(rIt.getId(), rIt.getText());
                crTo.buildCalendarDates(tmpData);
                pResult.add(crTo);
            }
        });
        String targetPath = docpathsegment + "DispatchScheduleLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_dispatchcalllog", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "DispatchCallLogPrintLog": {
                    return generateDispatchCallLogPrintLog(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
                case "DispatchCallLogPrintAllWO": {
                    return generateDispatchCallLogPrintAllWO(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    @Override
    public List<QaTestImagestore> getImageListByWoToken(String wotoken) {
        GlobWorkorder wo = workorderService.findByWoToken(wotoken);
        if (wo == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        GlobDispatchcallLog calllog = findByWOID(wo.getId().toBigInteger());
        if (calllog == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        if (calllog.getParentId() != null) {
            GlobDispatchcallLog parentCalllog = findById(calllog.getParentId());
            return qaTestImagestoreService.getImageListByWoId(parentCalllog.getWoId().getId().toBigInteger());
        }
        return qaTestImagestoreService.getImageListByWoId(wo.getId().toBigInteger());
    }

    @Override
    public String generateExternalWoReport(String reportId, String tplbasePath, String docpathsegment, String woToken, String docType, String clientId) throws IOException, Exception {
        GlobWorkorder wo = workorderService.findByWoToken(woToken);
        if (wo == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        GlobDispatchcallLog reqLog = findByWOID(NumberSupport.getBigInteger(wo.getId()));
        if (reqLog == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_dispatchcalllog", reportId);

        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "DispatchCallLogPrintAllWO": {
                    return generateWO(tplpath, docpathsegment, StringSupport.getString(reqLog.getId()), docType, paramsJasper);
                }
                case "DispatchCallLogPrintFailureLog": {
                    return generateFailureLog(tplpath, docpathsegment, wo.getProjectId(), docType, paramsJasper);
                }
            }

        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateFailureLog(String tplpath, String docpathsegment, BigInteger projectId, String docType, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        GlobProject project = projectService.findById(StringSupport.emptyOnNull(projectId));
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        paramsJasper.put("PROJECT_LOGO", projectLogoImage);

        List<QaSampleTestFailureLogBO> ds = qaSampleTestAddInfoService.getFailureLog(StringSupport.getString(projectId));

        String targetPath = docpathsegment + "FailureLogReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, ds, targetPath, extension.getValue());
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Generate WO
     *
     * @param tplpath
     * @param docpathsegment
     * @param logId
     * @param docType
     * @return String
     * @throws IOException
     * @throws Exception
     */
    private String generateWO(String tplpath, String docpathsegment, String logId, String docType, Map<String, Object> paramsJasper) throws IOException, Exception {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<DispatchPrintWOPojo> dwo = new ArrayList<>();
        DispatchPrintWOPojo response = generateWOPojo(logId);

        if (Objects.nonNull(response)) {
            dwo.add(response);
            String targetPath = docpathsegment + "WorkOrderReport_" + response.getWoNo() + "_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
            BuildJasper pdf = new BuildJasper();
            try {
                targetPath = pdf.exportDocument(tplpath, paramsJasper, dwo, targetPath, extension.getValue());
                return targetPath;
            } catch (Exception ex) {
                Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Generate WO Pojo
     *
     * @param logId
     * @return DispatchPrintWOPojo
     */
    private DispatchPrintWOPojo generateWOPojo(String logId) {
        if (logId == null || logId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return generateWOPojo(vwDispatchMainLogService.findById(logId));

    }

    private DispatchPrintWOPojo generateWOPojo(VwDispatchMainLog reqLog) {
        DispatchPrintWOPojo response = null;
        if (reqLog == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobProject project = projectService.findById(StringSupport.emptyOnNull(reqLog.getProjectId()));
        List<GlobProjectSpecsSoilcomp> soilCompList = globProjectSpecsSoilcompService.list(new ManageITBodyRequest(0, 3).filter("projectId", reqLog.getProjectId()).sorted("id", "desc"));
        List<VwProctorAttLimit> proctorList = vwProctorAttLimitService.list(new ManageITBodyRequest(0, 3).filter("projectId", reqLog.getProjectId()).sorted("sampleNo", "desc"));
        List<QaconcMixdesigns> concMixDesigList = qaconcMixdesignsService.list(new ManageITBodyRequest(0, 3).filter("projectId", reqLog.getProjectId()).sorted("id", "desc"));
        String PMFullName = "";
        if (project.getPersonProjectManager() != null) {
            GlobContact projectManager = contactService.findById(project.getPersonProjectManager().toString());
            PMFullName = projectManager.getFullName();
        }

        String clientId, reqQty, mixDesigId, batchPlant, rlocation;
        clientId = project.getClientId().getId().toString();
        reqQty = "";
        mixDesigId = "";
        batchPlant = "";
        rlocation = "N/A";
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        if (Objects.nonNull(project)) {
            GlobWorkorder wo = workorderService.findById(StringSupport.getString(reqLog.getWoId()));
            if (wo != null) {
                response = new DispatchPrintWOPojo();
                response.setTechnician(reqLog.getTechnician());
                response.setServiceDate(DateSupport.formatDate(reqLog.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")));
                response.setServiceDateCall(DateSupport.formatDate(wo.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")));
                response.setTimeReqOffice(wo.getArriveLabTime());
                response.setTimeReqSite(reqLog.getTimeSite());
                response.setRequestedBy(reqLog.getRequestedBy());
                response.setProjectManager(PMFullName);
                response.setProjectNo(project.getName());
                response.setWoNo(wo.getWoNo());
                response.setContactPerson(wo.getContact());
                response.setContactTelephone(wo.getContactTelephone());
                response.setProjectDescription(project.getPName());
                response.setServicesRequested(reqLog.getServicesRequested());
                response.setSpecialInstructions(reqLog.getSpecInstr());
                response.setReqQty(reqQty);
                response.setMixDesign(mixDesigId);
                response.setBatchPlant(batchPlant);
                response.setProjectLogo(projectLogoImage);
                response.setTraceNo("");
                response.setIsCancel(wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("yes"));
                response.setIsCallCancel(reqLog.getCancelledCall() != null && reqLog.getCancelledCall().toLowerCase().equals("yes"));
                response.setTechCertification(wo.getCertification());
                response.setLocation(rlocation);
                response.setHours(StringSupport.getString(reqLog.getHours()));
                response.setTotalhours(StringSupport.getString(reqLog.getTotalHours()));
                response.setPaperwork(reqLog.getPaperworkReceived().toString());
                response.setProjectClientName(reqLog.getProjectClientName());
                response.setLabFunction(reqLog.getLabFunction());
                response.setAssigment(reqLog.getAssigment());
                response.setWoLong(wo.getWoLong());
                response.setProjectDirections(project.getDirections());
                response.setProjectAddress(project.getFullProjectAddress());
                response.setDateCalledIn(reqLog.getRequestedDate());
                response.setTimeCalledIn(reqLog.getRequestedTime());
                if (soilCompList != null && !soilCompList.isEmpty()) {
                    response.setSoilCompList(soilCompList.stream().map(it -> new GlobProjectSpecsSoilCompBO(it.getMaterial(), it.getCompaction(), it.getAstmProctor(), it.getMoistureReq())).collect(Collectors.toList()));
                }

                if (proctorList != null && !proctorList.isEmpty()) {
                    response.setProctorList(proctorList.stream().map(it -> new VwProctorAttLimitBO(it.getDescription(), it.getSource(), it.getStructure(), it.getSampleNo(), it.getMaxDryDensity(), it.getOptMoistContent(), it.getPI())).collect(Collectors.toList()));
                }

                if (concMixDesigList != null && !concMixDesigList.isEmpty()) {
                    response.setConcMixDesigList(concMixDesigList.stream().map(it -> new QaconcMixdesignsBO(it.getMixDesign(), StringSupport.getString(it.getSpecSlumpMin()), StringSupport.getString(it.getSpecSlumpMax()), StringSupport.getString(it.getSpecAircontMin()), StringSupport.getString(it.getSpecAircontMax()))).collect(Collectors.toList()));
                }
            }
        }
        return response;
    }

    private String generateDispatchCallLogPrintLog(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<DispatchPrintWOPojo> pResult = generateDispatchCallLogPrintLogData(request);
        String targetPath = docpathsegment + "DispatchLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String generateDispatchCallLogPrintAllWO(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<DispatchPrintWOPojo> pResult = generateDispatchCallLogPrintLogData(request);
        String targetPath = docpathsegment + "DispatchWOLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DispatchPrintWOPojo> generateDispatchCallLogPrintLogData(ManageITBodyRequest request) {
        List<VwDispatchMainLog> filterList = vwDispatchMainLogService.list(request);
        List<DispatchPrintWOPojo> rList = new ArrayList<>();
        filterList.forEach(it -> {
            rList.add(generateWOPojo(it));
        });
        return rList;
    }

    @Override
    public void createWoWithNumbers(String callId) {
        GlobDispatchcallLog model = findById(NumberSupport.getBigInteger(callId));
        try {
            if (model.getWoId() == null) {
                GlobWorkorder woId = initWorkOrder(model);
                Map<String, String> woNumb = workorderService.getNextWorkOrderNumbers(model.getProjectId());
                woId.setWoNo(woNumb.get("woNo"));
                woId.setWoLong(woNumb.get("woLong"));
                woId.setWoShort(NumberSupport.getBigInteger(woNumb.get("woNo")));
                workorderService.save(woId);
                model.setWoId(woId);
                dao.update(model);
            } else {
                if (StringSupport.isNullOrEmpty(model.getWoId().getWoNo())) {
                    Map<String, String> woNumb = workorderService.getNextWorkOrderNumbers(model.getProjectId());
                    model.getWoId().setWoNo(woNumb.get("woNo"));
                    model.getWoId().setWoLong(woNumb.get("woLong"));
                    model.getWoId().setWoShort(NumberSupport.getBigInteger(woNumb.get("woNo")));
                    dao.update(model);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Dispatch Calendar Parameters: projectId : Is the Project
     * Selected.CurrentAction: [Load, Previous, ViewChange,DateNavigation].
     * CurrentDate: Selected date. CurrentView: [agenda, month,week, day]
     *
     * @param header
     * @param request
     * @return List<CalendarResourcesDataTO>
     */
    @Override
    public List<CalendarResourceTO> buildDispatchCalendarResources(ManageITHeader header, ManageITBodyRequest<Object> request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "resourceFilter"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String projectId = StringSupport.getString(request.getParams().get("projectId"));
        String rFilter = StringSupport.emptyOnNull(request.getParams().get("resourceFilter"));
        return projPersonnelService.getDispatchCalendarResources(header.getClientid(), projectId, rFilter);
    }

    @Override
    public List<CalendarResourceTO> buildAllDispatchCalendarResources(ManageITHeader header, GlobSheduleSearchDefParam defParam) {
        if (defParam == null || StringSupport.isNullOrEmpty(defParam.projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return projPersonnelService.getAllDispatchCalendarResources(defParam);
    }

    @Override
    public List<CalendarResourcesDataTO> buildDispatchCalendar(ManageITHeader header, ManageITBodyRequest<Object> request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "CurrentDate", "CurrentView"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<CalendarResourcesDataTO> calData = new ArrayList<>();
        List<CalendarResourceTO> rsList = buildDispatchCalendarResources(header, request);
        GlobSheduleSearchDefParam woFilter = new GlobSheduleSearchDefParam();
        woFilter.clientId = header.getClientid();
        woFilter.projectId = StringSupport.getString(request.getParams().get("projectId"));
        woFilter.CurrentView = StringSupport.getString(request.getParams().get("CurrentView"));
        woFilter.CurrentDate = StringSupport.getString(request.getParams().get("CurrentDate"));
        woFilter.CurrentAction = StringSupport.getString(request.getParams().get("CurrentAction"));
        List<WorkOrderTO> woList = workorderService.filterAndGetWorkOrderTO(woFilter);
        rsList.stream().filter((it) -> (it.getId() != null && !it.getId().isEmpty())).forEachOrdered((it) -> {
            List<CalendarResourcesDataTO> prtCalData = woList.stream()
                    .filter(p -> (p.getTechRefId() != null && p.getTechRefId().compareTo(NumberSupport.getBigInteger(it.getId())) == 0))
                    .map(n -> produce_CalendarResourcesDataTO(n, it))
                    .collect(Collectors.toList());
            calData.addAll(prtCalData);
        });
        return calData;
    }

    private CalendarResourcesDataTO produce_CalendarResourcesDataTO(WorkOrderTO p, CalendarResourceTO it) {
        return new CalendarResourcesDataTO(StringSupport.getString(p.getWoId()), "WO # " + p.getWonumber(),
                buildCalendarDescription(p.getServiceList(), StringSupport.emptyOnNull(p.getSpecialinstruction())), p.getServiceDate(), p.getTimeatsite(),
                StringSupport.getString(p.getHours()), it.getId(), "1", p.getTraceDescription(), p.getRlocation(), p.getSpecialinstruction());
    }

    public List<CalendarResourcesDataTO> buildDispatchSchedule(ManageITHeader header, GlobSheduleSearchDefParam defParam, Boolean includeAll) {
        if (defParam == null || StringSupport.isNullOrEmpty(defParam.projectId, defParam.CurrentDate, defParam.CurrentView)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<CalendarResourcesDataTO> calData = new ArrayList<>();
        List<CalendarResourceTO> rsList = buildAllDispatchCalendarResources(header, defParam);
        if (includeAll) {
            rsList.add(new CalendarResourceTO("-1", "Draft"));
        }
        List<WorkOrderTO> woList = workorderService.filterAndGetWorkOrderTO(defParam);
        rsList.stream().filter((it) -> (it.getId() != null && !it.getId().isEmpty())).forEachOrdered((it) -> {
            List<CalendarResourcesDataTO> prtCalData = woList.stream()
                    .filter(p -> (p.getTechRefId() != null && p.getTechRefId().compareTo(NumberSupport.getBigInteger(it.getId())) == 0))
                    .map(n -> new CalendarResourcesDataTO(n, it.getId()))
                    .collect(Collectors.toList());
            calData.addAll(prtCalData);
        });
        return calData;
    }

    @Override
    public List<CalendarResourcesDataTO> buildDispatchSchedule(ManageITHeader header, GlobSheduleSearchDefParam defParam) {
        return buildDispatchSchedule(header, defParam, Boolean.TRUE);
    }

    private String buildCalendarDescription(String services, String instructions) {
        StringBuilder result = new StringBuilder();
        result.append("Services Requested:\n");
        result.append(services);
        result.append("\n\nSpecial Instructions:\n");
        result.append(instructions);
        return result.toString();
    }

    /**
     * Build String Services Requested
     *
     * @param wo
     * @return String
     */
    private String buildStringServicesRequested(DispatchRequestTO wo) {
        List<String> services = new ArrayList<>();

        wo.getEngService().forEach((it) -> {
            if (it != null && StringSupport.isNotNullAndNotEmpty(it.getTypeofservice())) {
                services.add(it.getTypeofservice());
            }
        });

        wo.getFieldService().forEach((it) -> {
            if (it != null && it.getServiceId() != null) {
                services.add(fieldService.findById(it.getServiceId().toString()).getServiceFullName());
            }
        });

        wo.getLabService().forEach((it) -> {
            if (it != null && it.getTestTypeId() != null) {
                services.add(labService.findById(it.getTestTypeId().toString()).getLabServiceFullName());
            }
        });

        return String.join(",", services);
    }

    private String buildStringServicesRequested(CalendarResourcesDataTO wo) {
        List<String> services = new ArrayList<>();
        wo.getFieldService().forEach((it) -> {
            if (it != null && it.getServiceId() != null) {
                services.add(fieldService.findById(it.getServiceId().toString()).getServiceFullName());
            }
        });
        return String.join(",", services);
    }

    @Override
    public String generateCalendarReport(String tplbasePath, String tplpath, String docpathsegment, ManageITBodyRequest<Object> request, ManageITHeader header) {
        AtserLinkedHashMap<String, Object> params = request.getParams();
        Map<String, Object> paramsJasper = new HashMap<>();
        paramsJasper.put("SUB_RPT_DATES", FileSupport.FicheroAByteArrayIS(tplbasePath + "calendar/dispatch_agenda_dates.jasper"));
        paramsJasper.put("SUB_RPT_WO", FileSupport.FicheroAByteArrayIS(tplbasePath + "calendar/dispatch_agenda_workorders.jasper"));

        String docType = params.get("docType").toString();

        GlobProject project = projectService.findById(StringSupport.emptyOnNull(request.getParams().get("projectId")));
        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        paramsJasper.put("PROJECT_LOGO", projectLogoImage);

        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        // Get Data for Build the TO
        List<CalendarResourceTO> rList = buildDispatchCalendarResources(header, request);
        List<CalendarResourcesDataTO> rData = buildDispatchCalendar(header, request);

        // Fill Calendar WO TO
        List<CalendarResourcesTO> rListResource = new ArrayList<>();

        rList.forEach(rIt -> {
            List<CalendarResourcesDataTO> tmpData = rData.stream().filter((robj) -> (robj.getOwnerId().equals(rIt.getId()))).collect(Collectors.toList());
            if (!tmpData.isEmpty()) {
                CalendarResourcesTO crTo = new CalendarResourcesTO(rIt.getId(), rIt.getText());
                crTo.buildCalendarDates(tmpData);
                rListResource.add(crTo);
            }
        });

        String targetPath = docpathsegment + "CalendarReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, rListResource, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(BpmDispatchServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void cancelCallLog(ManageITHeader header, String callId, String value) {
        GlobDispatchcallLog model = findById(callId);
        if (model != null) {
            if (model.getWoId() == null) {
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModIp(header.getModIp());
                model.setLastModBy(header.getUser());
                model.setCancelled(value);
                dao.update(model);
            } else {
                if (model.getWoId() != null && StringSupport.isNullOrEmpty(model.getWoId().getWoNo())) {
                    model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                    model.setLastModIp(header.getModIp());
                    model.setLastModBy(header.getUser());
                    model.setCancelled(value);
                    model.getWoId().setActive((value.equals("Yes") ? 'N' : 'Y'));
                    model.getWoId().setCancelled(value);
                    dao.update(model);
                }
            }

        }
    }

    @Override
    public void cancelWo(ManageITHeader header, String callId, String value, String cancelReason) {
        GlobDispatchcallLog model = findById(callId);
        if (model != null) {
            List<GlobDispatchcallLog> cancelList;
            cancelList = list(new ManageITBodyRequest(0, 0).filter("cancelled", "No").filter("active", "Y").filter("parentId", model.getId().toBigInteger()));
            if (cancelList == null) {
                cancelList = new ArrayList<>();
            }
            cancelList.add(model);
            cancelList.forEach(it -> {
                if (it.getWoId() != null && StringSupport.isNotNullAndNotEmpty(it.getWoId().getWoNo())) {
                    it.getWoId().setCancelled(value);
                    it.getWoId().setWoCompleted(StringSupport.getActiveAsCharacter(value));
                    it.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                    it.setLastModIp(header.getModIp());
                    it.setLastModBy(header.getUser());
                    it.setEmailStatus("DISCARDED");
                    if (StringSupport.isNotNullAndNotEmpty(cancelReason) && value.equals("Yes")) {
                        it.setCancelledReason(cancelReason);
                    }
                    /*if (value.equals("Yes")) {
                        it.setEmailReason("WO Cancelled");
                    } else {
                        it.setEmailReason("Notify Technician");
                    }*/
                    it.setVersion(StringSupport.getNextVersion(it.getVersion()));
                    dao.update(it);
                }
            });
        }

    }

    @Override
    public void woCompleted(ManageITHeader header, String callId, String value) {
        GlobDispatchcallLog model = findById(callId);
        if (model != null) {
            if (model.getWoId() != null && StringSupport.isNotNullAndNotEmpty(model.getWoId().getWoNo())) {
                model.getWoId().setWoCompleted(StringSupport.getActiveAsCharacter(value));
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModIp(header.getModIp());
                model.setLastModBy(header.getUser());
                model.setVersion(StringSupport.getNextVersion(model.getVersion()));
                dao.update(model);
            }
        }
    }

    @Override
    public void moveWOSchedule(ManageITHeader header, String id, String startTime, BigDecimal hours, BigInteger ownerId, String event) {
        if (StringSupport.isNullOrEmpty(id, startTime, event) || hours == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobDispatchcallLog model = findById(id);
        if (model != null) {
            if (model.getWoId() != null) {
                try {
                    model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                    model.setLastModIp(header.getModIp());
                    model.setLastModBy(header.getUser());
                    model.setVersion(StringSupport.getNextVersion(model.getVersion()));
                    model.setServiceDate(DateSupport.parseString(startTime, DateSupport.FORMAT_US));
                    model.setTimeSite(DateSupport.formatString(startTime, DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
                    model.setHours(CurrencySupport.formatBigDecimal(hours, 2));
                    if (event.equals("draganddrop_resource")) {
                        if (ownerId == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
                            return;
                        }
                        if (ownerId.compareTo(NumberSupport.getBigInteger("-1")) == 0) {
                            throwBaseException(Response.Status.BAD_REQUEST, "This operation is not allowed on Drafts.");
                        }
                        model.setTechnician(contactService.findById(ownerId).getFullName());
                        model.setTechRefId(ownerId);
                    }
                    if (ownerId != null && ownerId.compareTo(NumberSupport.getBigInteger("-1")) != 0) {
                        model.setEmailStatus("PENDING");
                        model.setEmailReason("Notify Technician");
                    }
                    dao.update(model);
                } catch (ParseException ex) {
                    Logger.getLogger(GlobDispatchcallLogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<DataSelectWrapper> getDispatchSelectList(BigInteger clientId) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getDispatchSelectList(clientId);
    }
}
