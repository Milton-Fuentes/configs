/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobUserDao;
import com.atser.tools.atserejb.model.CmPersoninfo;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobClientModules;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobFunctions;
import com.atser.tools.atserejb.model.GlobLabsMaster;
import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserejb.model.GlobProfiles;
import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserejb.model.GlobRoles;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.service.bpm.BpmOperatorService;
import com.atser.tools.atserejb.service.cm.CmPersoninfoService;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.to.glob.ImportUserTO;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.GlobUserPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.bonitasoft.engine.exception.BonitaException;

@Stateless
public class GlobUserServiceImpl implements GlobUserService, IBaseEJBException {

    @Inject
    private GlobUserDao dao;

    @Inject
    private GlobClientModulesService globClientModulesService;

    @Inject
    private GlobRolesService globRolesService;

    @Inject
    private GlobClientService globClient;

    @Inject
    private GlobProfilesService globProfilesService;

    @Inject
    private GlobFunctionsService globFunctionsService;

    @Inject
    private GlobProjectPersonnelService globProjectPersonnelService;

    @Inject
    private BpmOperatorService bpmOperatorService;

    @Inject
    private CmPersoninfoService cmPersoninfoService;

    @Inject
    private WsDocTemplateService wsDocTemplateService;

    @Inject
    private GlobLabsMasterService globLabsMasterService;

    @Inject
    private GlobLabsService globLabsService;

    @Override
    public GlobUsers findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobUsers findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(ManageITHeader header, GlobUsers elem) {
        if (elem != null) {
            elem.setActive('Y');
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, GlobUsers elem) {
        if (elem != null) {
            GlobUsers model = findById(elem.getId());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            model.setDefaultProfile(elem.getDefaultProfile());
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
    public List<GlobUsers> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existByUserName(String username) {
        if (StringSupport.isNotNullAndNotEmpty(username)) {
            return dao.existByUserName(username);
        }
        return Boolean.FALSE;
    }

    @Override
    public GlobUsers authUser(String username, String pwd) {
        if (username == null || pwd == null || username.isEmpty() || pwd.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return dao.findBySSO(username, pwd);
    }

    @Override
    public String generateExcelTemplate(String paramClientId, String tplbasePath, String docpathsegment) {
        GlobClient client = globClient.findById(paramClientId);
        if (client == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }

        WsDocTemplate rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(paramClientId), "fc_importuser", "excel");
        if (rp == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
        }

        Map<String, Boolean> ht = globClient.getMapFlags(paramClientId, "QMS");
        Boolean useMasterLabs = ht.get("USES_MASTER_LABS");
        eUserInformation docTpl = eUserInformation.valueOf(rp.getDocCode());
        List<GlobClientModules> moduleList = globClientModulesService.list(new ManageITBodyRequest(0, 0).filter("customerId.id", paramClientId));
        if (moduleList != null) {
            List<Object[]> roles = globRolesService.getModuleRoles(NumberSupport.getBigInteger(paramClientId));
            List<Object[]> cmTitleList = cmPersoninfoService.getCmTitles(NumberSupport.getBigInteger(paramClientId));
            List<Object[]> cmFirmList = cmPersoninfoService.getCmFirm(NumberSupport.getBigInteger(paramClientId));
            List<GlobLabsMaster> masterLabList = null;
            List<GlobLabs> labList = null;
            if (useMasterLabs) {
                masterLabList = globLabsMasterService.list(new ManageITBodyRequest(0, 0).filter("clientId", paramClientId).filter("active", "Y").sorted("labName", "ASC"));
            } else {
                labList = globLabsService.list(new ManageITBodyRequest(0, 0).filter("clientId", paramClientId).filter("active", "Y").sorted("labName", "ASC"));
            }
            if (roles != null) {
                String tplpath = tplbasePath + rp.getDocPath();
                String targetPath = docpathsegment + "UserTemplate_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + ".xlsx";
                try {
                    GlobUserPluginDirector director = new GlobUserPluginDirector(new File(tplpath), docTpl);
                    ExcelDocument doc = director.getpDoc();
                    if (!doc.getListPages().isEmpty() && doc.getListPages().size() == 2) {
                        Sheet catalog = doc.getListPages().get(1);
                        if (catalog.getSheetName().equals("Catalog")) {
                            int rowStart = 1;
                            // Write Modules
                            rowStart = 1;
                            for (GlobClientModules it : moduleList) {
                                Row row = catalog.getRow(rowStart++);
                                Cell cell = row.getCell(3);
                                cell.setCellValue(it.getModuleTitle());
                            }
                            // Write Roles
                            rowStart = 1;
                            for (Object[] it : roles) {
                                Row row = catalog.getRow(rowStart++);
                                Cell cellMod = row.getCell(5);
                                Cell cellRol = row.getCell(6);
                                cellMod.setCellValue(StringSupport.emptyOnNull(it[0]));
                                cellRol.setCellValue(StringSupport.emptyOnNull(it[1]));
                            }

                            // Write Cm Titles
                            if (cmTitleList != null && !cmTitleList.isEmpty()) {
                                rowStart = 1;
                                for (Object[] it : cmTitleList) {
                                    Row row = catalog.getRow(rowStart++);
                                    Cell cell = row.getCell(8);
                                    cell.setCellValue(StringSupport.emptyOnNull(it[1]));
                                }
                            }

                            // Write Cm Firm
                            if (cmFirmList != null && !cmFirmList.isEmpty()) {
                                rowStart = 1;
                                for (Object[] it : cmFirmList) {
                                    Row row = catalog.getRow(rowStart++);
                                    Cell cellT = row.getCell(10);
                                    Cell cellF = row.getCell(11);
                                    cellT.setCellValue(StringSupport.emptyOnNull(it[0]));
                                    cellF.setCellValue(StringSupport.emptyOnNull(it[1]));
                                }
                            }

                            // Write Designed Labs
                            if (useMasterLabs) {
                                if (masterLabList != null && !masterLabList.isEmpty()) {
                                    rowStart = 1;
                                    for (GlobLabsMaster it : masterLabList) {
                                        Row row = catalog.getRow(rowStart++);
                                        Cell cell = row.getCell(13);
                                        cell.setCellValue(it.getLabName());
                                    }
                                }
                            }
                            /*else {
                                if (labList != null && !labList.isEmpty()) {
                                    rowStart = 1;
                                    for (GlobLabs it : labList) {
                                        Row row = catalog.getRow(rowStart++);
                                        Cell cell = row.getCell(13);
                                        cell.setCellValue(it.getLabName());
                                    }
                                }
                            }*/
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
                        }
                    } else {
                        throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
                    }
                    doc.buildOutputDocument(new File(targetPath));
                    doc.write();
                    return targetPath;
                } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | FileNotFoundException ex) {
                    Logger.getLogger(GlobUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GlobUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportUserTO data, BonitaBpmSupport bpmSession) {
        if (data != null && data.getUsers() != null && !data.getUsers().isEmpty()) {
            GlobClient client = globClient.findById(header.getClientid());
            if (client == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            List<GenericStatusPojo> importErrors = new ArrayList<>();
            Map<String, Boolean> ht = globClient.getMapFlags(header.getClientid(), "QMS");
            Boolean useProjectPersonnel = ht.get("USES_PROJECTPERSONNEL");
            Boolean useGlobalProfile = ht.get("uses_global_profiles");
            Boolean useMasterLabs = ht.get("USES_MASTER_LABS");
            List<GlobClientModules> moduleList = globClientModulesService.list(new ManageITBodyRequest(0, 0).filter("customerId.id", header.getClientid()));
            List<Object[]> roleList = globRolesService.getModuleRoles(NumberSupport.getBigInteger(header.getClientid()));
            List<Object[]> cmTitleList = cmPersoninfoService.getCmTitles(NumberSupport.getBigInteger(header.getClientid()));
            List<Object[]> cmFirmList = cmPersoninfoService.getCmFirm(NumberSupport.getBigInteger(header.getClientid()));
            List<GlobLabs> labList = globLabsService.list(new ManageITBodyRequest(0, 0).filter("clientId", header.getClientid()).filter("active", "Y").sorted("labName", "ASC"));
            List<GlobLabsMaster> masterLabList = globLabsMasterService.list(new ManageITBodyRequest(0, 0).filter("clientId", header.getClientid()).filter("active", "Y").sorted("labName", "ASC"));

            // Define globalProfile
            GlobProfiles defaultP = buildDefaultProfile(data);
            data.getUsers().forEach(it -> {
                Boolean saveData = Boolean.TRUE;
                CmPersoninfo personInfo = null;
                if (StringSupport.isNotNullAndNotEmpty(it.getModule(), it.getRole())) {
                    Optional<GlobClientModules> matchModule = moduleList.stream().filter(p -> p.getModuleTitle().equals(it.getModule())).findFirst();
                    GlobClientModules fmodule = matchModule.orElse(null);
                    Optional<Object[]> matchRole = roleList.stream().filter(p -> p[1].equals(it.getRole())).findFirst();
                    Object[] frole = matchRole.orElse(null);
                    if (fmodule != null && frole != null) {
                        GlobRoles dbrole = globRolesService.findById(frole[2].toString());
                        // Insert User/Contact
                        if (!existByUserName(it.getUserId())) {
                            GlobUsers user = toGlobUser(header, data, it, client);
                            GlobProfiles currentProfile = new GlobProfiles();
                            currentProfile.setIsPreferred("Y");
                            currentProfile.setClientId(client);
                            currentProfile.setModuleId(fmodule.getModuleId().getId().toBigInteger());
                            currentProfile.setRoleId(dbrole);
                            currentProfile.setReadonly('N');
                            if (it.getModule().toLowerCase().equals("cms") || it.getModule().toLowerCase().equals("construct-it")) {
                                Optional<Object[]> matchTitle = cmTitleList.stream().filter(p -> p[1].equals(it.getFunctionalTitle())).findFirst();
                                Object[] fTitle = matchTitle.orElse(null);
                                Optional<Object[]> matchFirm = cmFirmList.stream().filter(p -> p[1].equals(it.getFirm())).findFirst();
                                Object[] fFirm = matchFirm.orElse(null);
                                if (fTitle != null && fFirm != null) {
                                    personInfo = new CmPersoninfo(user.getContactid(), NumberSupport.getBigInteger(client.getCompanyId().getId()), client.getId().toBigInteger(), StringSupport.getString(fFirm[1]), StringSupport.getString(fTitle[1]), NumberSupport.getBigInteger(fTitle[0]));
                                } else {
                                    saveData = Boolean.FALSE;
                                    importErrors.add(new GenericStatusPojo(it.getUserId(), "ERROR", null, it, "Error: [Company Name] or [Functional Title] are incorrect for the Construct-IT module !"));
                                }
                            } else if (it.getModule().toLowerCase().equals("qms") || it.getModule().toLowerCase().equals("assure-it")) {
                                currentProfile.setFunctionId(defaultP.getFunctionId());
                                currentProfile.setLabId(defaultP.getLabId());
                                if (useGlobalProfile) {
                                    currentProfile.setProjectId(NumberSupport.getBigInteger("-99"));
                                } else {
                                    currentProfile.setProjectId(BigInteger.ZERO);
                                }

                                if (useMasterLabs) {
                                    if (masterLabList != null) {
                                        Optional<GlobLabsMaster> matchMasterLab = masterLabList.stream().filter(p -> p.getLabName().equals(it.getDesignatedLab())).findFirst();
                                        GlobLabsMaster fmasterLab = matchMasterLab.orElse(null);
                                        if (fmasterLab != null) {
                                            user.getContactid().setDesignLab(fmasterLab.getId().toBigInteger());
                                        }
                                    }
                                } else {
                                    if (labList != null) {
                                        Optional<GlobLabs> matchLab = labList.stream().filter(p -> p.getLabName().equals(it.getDesignatedLab())).findFirst();
                                        GlobLabs fLab = matchLab.orElse(null);
                                        if (fLab != null) {
                                            user.getContactid().setDesignLab(fLab.getId().toBigInteger());
                                        }
                                    }
                                }

                            }

                            if (saveData) {
                                save(header, user);
                                currentProfile.setUserId(user.getId().toBigInteger());
                                switch (it.getModule().toLowerCase()) {
                                    case "qms":
                                    case "assure-it": {
                                        // Project Personnel
                                        if (useProjectPersonnel) {
                                            GlobProjectPersonnel pp = buildProjectPersonnel(client.getId().toBigInteger(), user.getContactid(), currentProfile.getProjectId());
                                            if (currentProfile.getProjectId().compareTo(BigInteger.ZERO) == 1) {
                                                globProjectPersonnelService.save(pp);
                                            } else if (useGlobalProfile && currentProfile.getProjectId().compareTo(NumberSupport.getBigInteger("-99")) == 0) {
                                                pp.setProjectId(BigInteger.ZERO);
                                                globProjectPersonnelService.saveGlobal(pp);
                                            }
                                        }
                                        break;
                                    }
                                    case "cms":
                                    case "construct-it": {
                                        if (personInfo != null) {
                                            cmPersoninfoService.save(personInfo);
                                            user.setPersoninfoId(personInfo);
                                        }
                                        break;
                                    }
                                }
                                globProfilesService.save(currentProfile);
                                user.setDefaultProfile(NumberSupport.getBigInteger(currentProfile.getId()));
                                update(header, user);
                                importErrors.add(new GenericStatusPojo(it.getUserId(), "DONE"));
                                // If we're using BPM, insert it. 
                                if (bpmSession != null && bpmSession.isSessionActive() && client.getHasBpm() == 'Y') {
                                    try {
                                        bpmOperatorService.InsertUserInformation(bpmSession, user.getId());
                                    } catch (BonitaException ex) {
                                        Logger.getLogger(GlobUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        } else {
                            it.setStatus("ERROR: User already exists !");
                            importErrors.add(new GenericStatusPojo(it.getUserId(), "ERROR", null, it, "User already exists !"));
                        }
                    } else {
                        it.setStatus("ERROR: Module or Role not Found !");
                        importErrors.add(new GenericStatusPojo(it.getUserId(), "ERROR", null, it, "[Module] or [Role] not Found !"));
                    }
                } else {
                    it.setStatus("ERROR: Module or Role are Null !");
                    importErrors.add(new GenericStatusPojo(it.getUserId(), "ERROR", null, it, "[Module] or [Role] are Null !"));
                }
            });
            return importErrors;
        }
        return null;
    }

    private GlobUsers toGlobUser(ManageITHeader header, ImportUserTO to, UserInformationDef udef, GlobClient client) {
        GlobUsers user = new GlobUsers();
        user.setStation("na");
        user.setPassValidDays((short) 180);
        user.setUserFilter("NO");
        user.setBookmark("main.jsp");
        user.setResetPass('N');
        user.setStatus((short) 0);
        user.setUserid(udef.getUserId());
        user.setPass(to.getPassword());
        user.setPersoninfoId(null);
        user.setContactid(toGlobContact(header, to, udef, client));
        return user;
    }

    private GlobContact toGlobContact(ManageITHeader header, ImportUserTO to, UserInformationDef udef, GlobClient client) {
        GlobContact ct = new GlobContact();
        ct.setFirstname(udef.getFirstName());
        ct.setMiddlename(udef.getMiddleInitial());
        ct.setLastname(udef.getLastName());
        ct.setEmail(udef.getEmail());
        ct.setSuffix(udef.getSuffix());
        ct.setTitle(udef.getFunctionalTitle());
        ct.setHrTitle(udef.getHrTitle());
        ct.setUnitCode(udef.getUnitCode());
        ct.setUnitDescription(udef.getUnitDescription());
        ct.setAddress(udef.getAddress());
        ct.setCity(udef.getCity());
        ct.setCountry(udef.getCountry());
        ct.setState(udef.getState());
        ct.setZip(udef.getZip());
        ct.setPhone(udef.getWorkPhone());
        ct.setCell(udef.getCellPhone());
        ct.setFax(udef.getFax());
        ct.setCompanyName(StringSupport.isNullOrEmpty(udef.getCompanyName()) ? client.getName() : udef.getCompanyName());
        ct.setCompanyLink(udef.getCompanyWebSite());
        if (StringSupport.isNullOrEmpty(udef.getPrintedSign())) {
            StringBuilder sign = new StringBuilder();
            sign.append(udef.getFirstName()).append(" ");
            if (StringSupport.isNotNullAndNotEmpty(udef.getMiddleInitial())) {
                sign.append(udef.getMiddleInitial()).append(" ");
            }
            sign.append(udef.getLastName());
            ct.setPrintedSign(sign.toString());
        } else {
            ct.setPrintedSign(udef.getPrintedSign());
        }
        ct.setClientId(NumberSupport.getBigInteger(client.getId()));
        ct.setActive('Y');
        return ct;
    }

    private GlobProfiles buildDefaultProfile(ImportUserTO to) {
        GlobProfiles p = new GlobProfiles();
        GlobFunctions functionId = globFunctionsService.findById(to.getFunctionId());
        p.setFunctionId(functionId);
        p.setLabId(NumberSupport.getBigInteger(to.getLabId()));
        return p;
    }

    private GlobProjectPersonnel buildProjectPersonnel(BigInteger clientId, GlobContact contact, BigInteger projectId) {
        GlobProjectPersonnel gp = new GlobProjectPersonnel();
        gp.setActive('Y');
        gp.setShowdispatch('Y');
        gp.setClientId(clientId);
        gp.setContactId(contact);
        gp.setProjectId(projectId);
        return gp;
    }

    @Override
    public void unlockUserAccounts() {
        dao.unlockUserAccounts();
    }
    
    @Override
    public String getUserEmail(BigDecimal userId) {
        return dao.getUserEmail(userId);
    }
}
