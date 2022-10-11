/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobSupplierDao;
import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobProjectSupplier;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.model.GlobSupplierPersonnel;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.parser.eTemplateSupplier;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.SupplierPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.openxml4j.util.ZipSecureFile;

@Stateless
public class GlobSupplierServiceImpl implements GlobSupplierService, IBaseEJBException {

    @Inject
    private GlobSupplierDao dao;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GlobDataGatewayLogService globDataGatewayLogService;

    @Inject
    private GlobProjectSupplierService globProjectSupplierService;

    @Inject
    private GlobSupplierAddressService globSupplierAddressService;

    @Inject
    private GlobProjectService globProjectService;

    @Override
    public GlobSupplier findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobSupplier findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobSupplier findByImpCode(String code) {
        return dao.findByImpCode(code);
    }

    @Override
    public void save(GlobSupplier elem) {
        if (elem != null) {
            elem.buildReferences();
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobSupplier elem) {
        if (elem != null) {
            GlobSupplier model = findById(elem.getId());
            if (model != null) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private GlobSupplier populateForUpdate(GlobSupplier elem, GlobSupplier model) {
        model.setSupplier(elem.getSupplier());
        model.setService(elem.getService());
        model.setContactName(elem.getContactName());
        model.setContactTitle(elem.getContactTitle());
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setZip(elem.getZip());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setFax(elem.getFax());
        model.setEmail(elem.getEmail());
        model.setLocation(elem.getLocation());

        List<GlobSupplierPersonnel> currentList = new ArrayList<>();
        currentList.addAll(model.getGlobSupplierPersonnelList());

        currentList.forEach(it -> {
            model.removeQmSupplierPersonnelList(it);
        });

        elem.getGlobSupplierPersonnelList().forEach(it -> {
            model.addQmSupplierPersonnelList(it);
        });
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobSupplier> list(ManageITBodyRequest request) {
        List<GlobSupplier> list;
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
    public DataTableWrapper<GlobSupplier> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobSupplier> finalList = list(request);
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
        GlobSupplier model = findById(request.getParams().get("id").toString());
        model.setEnabled(request.getParams().get("enabled").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N');
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
    public List<GlobSupplier> filterByMaterialType(String clientId, String materialType) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(materialType)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.filterByMaterialType(NumberSupport.getBigInteger(clientId), materialType);
    }

    @Override
    public List<GlobSupplier> filterByMaterialTypeByProject(String clientId, String projectId, String materialType) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(projectId) || StringSupport.isNullOrEmpty(materialType)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.filterByMaterialTypeAndProject(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(projectId), materialType);
    }

    @Override
    public List<GlobSupplier> filterSupplierByProject(String clientId, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.filterSupplierByProject(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(projectId));
    }

    @Override
    public List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType) {
        if (clientId != null && StringSupport.isNotNullAndNotEmpty(materialType)) {
            return dao.getSupplierAndLocation(clientId, materialType);
        }
        return null;
    }

    @Override
    public List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType, BigDecimal supplierId) {
        if (clientId != null && StringSupport.isNotNullAndNotEmpty(materialType)) {
            return dao.getSupplierAndLocation(clientId, materialType, supplierId);
        }
        return null;
    }

    @Override
    public List<DataSelectWrapper> getSupplierAndLocationForSelect(BigInteger clientId, String materialType) {
        List<Object[]> list = getSupplierAndLocation(clientId, materialType);
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(p -> new DataSelectWrapper(p[0], StringSupport.emptyOnNull(p[1]))).collect(Collectors.toList());
    }

    @Override
    public String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(clientId), "fc_glob_supplier", reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            switch (reportId) {
                case "globSupplierLog": {
                    return generateSupplierLogReport(clientId, tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper);
                }
            }
            return tplpath;
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    private String generateSupplierLogReport(String clientId, String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<GlobSupplierTO> pResult = dao.listSupplierAndLocation(NumberSupport.getBigInteger(clientId));

        String targetPath = docpathsegment + "SupplierLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();

        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue(), true);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(GlobSupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<GlobSupplier> filterBinderSupplierByProject(String clientId, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.filterBinderSupplierByProject(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(projectId));
    }

    // ********************** Import Suppliers [BEGIN] *************************
    @Override
    public Object processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("matCatg"), params.get("filetpl"), params.get("projectId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<String> projectList = Arrays.asList(StringSupport.getString(params.get("projectId")).split(","));
        if (projectList == null || projectList.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        SupplierPluginDirector director;
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.emptyOnNull(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        director = new SupplierPluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eTemplateSupplier.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<SupplierDef> model = director.getModel();
        if (model != null) {
            model.forEach(it -> {
                importSupplierSaveOrUpdate(header, projectList, StringSupport.emptyOnNull(params.get("matCatg")), it);
            });

            // Track Import By Project
            projectList.forEach(it -> {
                globDataGatewayLogService.save(new GlobDataGatewayLog(NumberSupport.getBigInteger(params.get("clientId")),
                        NumberSupport.getBigInteger(it),
                        StringSupport.getString(params.get("functionality")),
                        StringSupport.getString(metaDataFile.get("ofilename")),
                        NumberSupport.getBigInteger(model.size()),
                        StringSupport.emptyOnNull(params.get("sessionUser")),
                        StringSupport.emptyOnNull(params.get("modIp"))));
            });
        }

        return model;
    }

    private void importSupplierSaveOrUpdate(ManageITHeader header, List<String> projectIdList, String matCatg, SupplierDef def) {
        if (def != null) {
            GlobSupplier elem = dao.findByImpCode(def.getImpCode());
            GlobSupplier elemDef = new GlobSupplier(NumberSupport.getBigInteger(header.getClientid()), matCatg, header.getUser(), header.getModIp(), def);
            if (elem != null) {
                //if (!isSupplierDefEqualsSupplier(elemDef, elem)) {
                importUpdate(header, elem, def, matCatg, projectIdList);
                //}
            } else {
                dao.save(elemDef);
                if (elemDef.getId() != null) {
                    globSupplierAddressService.save(new GlobSupplierAddress(elemDef.getId().toBigInteger(), 'Y', null, null, null, null, BigInteger.ONE, elemDef.getLocation()));
                }
                // Join Glob_Project_Supplier
                projectIdList.stream().map((it) -> globProjectService.findById(it)).filter((project) -> (project != null)).forEachOrdered((project) -> {
                    globProjectSupplierService.save(new GlobProjectSupplier(project, elemDef));
                });
            }
        }
    }

    private void importUpdate(ManageITHeader header, GlobSupplier model, SupplierDef elem, String matCatg, List<String> projectIdList) {
        if (model != null) {
            model.setSupplier(elem.getSupplier() + " [ " + elem.getImpCode() + " ] ");
            model.setService(matCatg);
            model.setAddress(elem.getAddress());
            model.setImpVendorId(elem.getImpVendorId());
            model.setLocation(elem.getLocation());
            model.setActive(elem.getActive());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            dao.update(model);
            if (model.getId() != null) {
                globSupplierAddressService.updateMainLocationBySupplierId(model.getId().toBigInteger(), elem.getLocation());
            }
            projectIdList.forEach(it -> {
                // Join Glob_Project_Supplier
                if (!globProjectSupplierService.exists(NumberSupport.getBigInteger(it), NumberSupport.getBigInteger(model.getId()))) {
                    GlobProject project = globProjectService.findById(it);
                    if (project != null) {
                        globProjectSupplierService.save(new GlobProjectSupplier(project, model));
                    }
                }
            });
        }
    }

    private Boolean isSupplierDefEqualsSupplier(GlobSupplier def, GlobSupplier elem) {
        if (!StringSupport.compareString(def.getSupplier(), elem.getSupplier())) {
            return Boolean.FALSE;
        }
        if (!StringSupport.compareString(def.getService(), elem.getService())) {
            return Boolean.FALSE;
        }
        if (!StringSupport.compareString(def.getAddress(), elem.getAddress())) {
            return Boolean.FALSE;
        }
        if (!StringSupport.compareString(def.getImpVendorId(), elem.getImpVendorId())) {
            return Boolean.FALSE;
        }
        if (!StringSupport.compareString(def.getLocation(), elem.getLocation())) {
            return Boolean.FALSE;
        }
        if (!StringSupport.compareCharacter(def.getActive(), elem.getActive())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    // ********************** Import Suppliers [END] *************************
}
