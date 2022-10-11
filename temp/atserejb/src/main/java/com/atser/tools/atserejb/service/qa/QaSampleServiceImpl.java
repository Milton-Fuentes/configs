/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleDao;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridExcelSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import org.jboss.resteasy.spi.ResteasyUriInfo;

@Slf4j
@Stateless
public class QaSampleServiceImpl implements QaSampleService, IBaseEJBException {

    @Inject
    private QaSampleDao dao;

    @Override
    public QaSample findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaSample findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QaSample elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaSample elem) {
        if (elem != null) {
            QaSample model = findById(elem.getId());
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
    public List<QaSample> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existsConcMixDesign(BigInteger mixId) {
        return dao.existsConcMixDesign(mixId);
    }

    @Override
    public Boolean existsAspmMixDesign(BigInteger mixId) {
        return dao.existsAspmMixDesign(mixId);
    }

    @Override
    public String getSampleCategory(String clientId, String sampleNo) {
        if (StringSupport.isNotNullAndNotEmpty(clientId, sampleNo)) {
            return dao.getSampleCategory(clientId, sampleNo);
        }
        return null;
    }

    @Override
    public Object getFrontEndSearchSample(ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getSearchSampleInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
        } else {
            switch (datatype) {
                case "table": {
                    return getSearchSampleInbox(header.getUserid(), header.getClientid(), header.getRole(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private DataTableWrapper<QaSampleSearchBO> getSearchSampleInbox(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params) {
        // Define parameters
        QaSampleSearchDefParam tp = new QaSampleSearchDefParam();
        tp.dtSearchUrl = StringSupport.getString(params.get("dtSearchUrl"));
        tp.startIndex = NumberSupport.getInteger(params.get("startIndex"));
        tp.maxResults = NumberSupport.getInteger(params.get("maxResults"));
        tp.sortBy = StringSupport.getString(params.get("sortBy"));
        tp.sortDir = StringSupport.getString(params.get("sortDir"));
        tp.userId = userId;
        tp.currentRole = currentRole;
        tp.clientName = StringSupport.getString(params.get("clientName"));
        tp.clientId = clientId;
        tp.projectId = StringSupport.getString(params.get("projectId"));
        tp.functionId = StringSupport.getString(params.get("functionId"));
        tp.startDate = StringSupport.getString(params.get("startDate"));
        tp.endDate = StringSupport.getString(params.get("endDate"));
        tp.sampleRegionId = StringSupport.getString(params.get("sampleRegionId"));
        tp.labId = StringSupport.getString(params.get("labId"));
        tp.category = StringSupport.getString(params.get("category"));
        tp.isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        tp.multiproject = StringSupport.getBoolean(params.get("multiproject"));
        tp.usesWorkorder = StringSupport.getBoolean(params.get("useWorkorder"));
        tp.isAllDateActive = StringSupport.getBoolean(params.get("isAllDateActive"));
        tp.showInactive = StringSupport.getBoolean(params.get("showInactive"));
        tp.usesPayItem = StringSupport.getBoolean(params.get("usesPayItem"));
        tp.usesRoleMatrix = StringSupport.getBoolean(params.get("usesRoleMatrix"));
        tp.useGlobalProfiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        tp.sampleMatCodeId = StringSupport.getString(params.get("sampleMatCodeId"));
        tp.sampleRandomCode = StringSupport.getString(params.get("sampleRandomCode"));
        if (StringSupport.isNotNullAndNotEmpty(params.get("dtSearchUrl"))) {
            UriInfo pUriInfo = new ResteasyUriInfo("", StringSupport.getString(params.get("dtSearchUrl")), "");
            MultivaluedMap<String, String> queryParams = pUriInfo.getQueryParameters();
            Map<String, String> search = new HashMap();
            queryParams.get("f").stream().map((string) -> string.split("%=")).filter((split) -> (split.length == 2)).forEachOrdered((split) -> {
                search.put(split[0], split[1]);
            });
            tp.dtMapSearch = search;
        } else {
            tp.dtMapSearch = new HashMap<>();
        }
        return dao.getFrontEndSearchSampleInbox(tp);
    }

    @Override
    public void changeStatus(ManageITBodyRequest<Object> request) {
        log.info("@track changeStatus status {}", StringSupport.isNullOrEmpty(request.getParams().get("status")));
        log.info("@track changeStatus id {}", StringSupport.isNullOrEmpty(request.getParams().get("id")));
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (dao.existsSample(NumberSupport.getBigDecimal(request.getParams().get("id")), Boolean.FALSE)) {
            dao.updateStatus(NumberSupport.getBigDecimal(request.getParams().get("id")), request.getParams().get("status").toString().trim().toLowerCase().equals("y") ? "N" : "Y");
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Sample not found !");
        }
    }

    /**
     * Find QaSample by SampleNo and ProjectId
     *
     * @param sampleNo
     * @param projectId
     * @return Null on Error
     */
    @Override
    public QaSample findBySampleNo(String sampleNo, BigInteger projectId) {
        if (StringSupport.isNullOrEmpty(sampleNo) || projectId == null) {
            return null;
            //throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySampleNo(sampleNo, projectId);
    }

    @Override
    public String generateReport(ManageITHeader header, ManageITBodyRequest<ReportGridWrapper> body, String docpathsegment) {
        if (header == null || body == null || body.getParams() == null || body.getData() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return null;
        }

        AtserLinkedHashMap<String, Object> params = body.getParams();
        ReportGridWrapper reportGridWrapper = body.getData();
        String clientName = StringSupport.getString(params.get("themeCompany"));
        eDocExtension extension;
        if (reportGridWrapper.getDocType() == null || reportGridWrapper.getDocType().isEmpty()) {
            extension = eDocExtension.csv;
        } else {
            extension = eDocExtension.valueOf(reportGridWrapper.getDocType());
        }

        // Define parameters
        QaSampleSearchDefParam tp = new QaSampleSearchDefParam();
        tp.dtSearchUrl = StringSupport.getString(params.get("dtSearchUrl"));
        tp.startIndex = NumberSupport.getInteger(params.get("startIndex"));
        tp.maxResults = NumberSupport.getInteger(params.get("maxResults"));
        tp.sortBy = StringSupport.getString(params.get("sortBy"));
        tp.sortDir = StringSupport.getString(params.get("sortDir"));
        tp.userId = header.getUserid();
        tp.currentRole = header.getRole();
        tp.clientName = StringSupport.getString(params.get("clientName"));
        tp.clientId = header.getClientid();
        tp.projectId = StringSupport.getString(params.get("projectId"));
        tp.functionId = StringSupport.getString(params.get("functionId"));
        tp.startDate = StringSupport.getString(params.get("startDate"));
        tp.endDate = StringSupport.getString(params.get("endDate"));
        tp.sampleRegionId = StringSupport.getString(params.get("sampleRegionId"));
        tp.labId = StringSupport.getString(params.get("labId"));
        tp.category = StringSupport.getString(params.get("category"));
        tp.isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        tp.multiproject = StringSupport.getBoolean(params.get("multiproject"));
        tp.usesWorkorder = StringSupport.getBoolean(params.get("useWorkorder"));
        tp.isAllDateActive = StringSupport.getBoolean(params.get("isAllDateActive"));
        tp.showInactive = StringSupport.getBoolean(params.get("showInactive"));
        tp.usesPayItem = StringSupport.getBoolean(params.get("usesPayItem"));
        tp.usesRoleMatrix = StringSupport.getBoolean(params.get("usesRoleMatrix"));
        tp.useGlobalProfiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        tp.sampleMatCodeId = StringSupport.getString(params.get("sampleMatCodeId"));
        tp.sampleRandomCode = StringSupport.getString(params.get("sampleRandomCode"));
        if (StringSupport.isNotNullAndNotEmpty(params.get("dtSearchUrl"))) {
            UriInfo pUriInfo = new ResteasyUriInfo("", StringSupport.getString(params.get("dtSearchUrl")), "");
            MultivaluedMap<String, String> queryParams = pUriInfo.getQueryParameters();
            Map<String, String> search = new HashMap();
            queryParams.get("f").stream().map((string) -> string.split("%=")).filter((split) -> (split.length == 2)).forEachOrdered((split) -> {
                search.put(split[0], split[1]);
            });
            tp.dtMapSearch = search;
        } else {
            tp.dtMapSearch = new HashMap<>();
        }

        List<QaSampleSearchBO> ds = dao.getFrontEndSearchAllSampleInbox(tp);
        String targetPath = docpathsegment + "SampleLog_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridExcelSimple jd = new JasperDesignGridExcelSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, extension);
            JasperDesign tpl = jd.buildTemplate("Sample Dashboard", QaSampleSearchBO.class, reportGridWrapper.getColumns());
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(QaconcMixdesignMasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
