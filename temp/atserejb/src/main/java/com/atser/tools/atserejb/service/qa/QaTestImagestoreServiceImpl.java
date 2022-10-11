/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTestImagestoreDao;
import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.document.read.pdf.PdfContext;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaTestImagestoreServiceImpl implements QaTestImagestoreService, IBaseEJBException {

    @Inject
    private QaTestImagestoreDao dao;

    @Override
    public QaTestImagestore findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaTestImagestore findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaTestImagestore elem) {
        if (elem != null) {
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaTestImagestore elem) {
        if (elem != null) {
            QaTestImagestore model = findById(elem.getId());
            model.setFNote(elem.getFNote());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigInteger id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(new BigDecimal(id));
    }

    @Override
    public void delete(String id, String reportPath) {
        delete(id);
        deleteReportCache(reportPath);
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        delete(id);
    }

    @Override
    public List<QaTestImagestore> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params) {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename")) || params == null || !params.containsKey("standard") || !params.containsKey("spec")) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(params.get("standard")) || StringSupport.isNullOrEmpty(params.get("spec"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        saveFileToDb(metaDataFile, params, NumberSupport.getBigInteger(params.get("specId")), StringSupport.getString(params.get("standard")), StringSupport.getString(params.get("spec")));
    }

    @Override
    public void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params, BigInteger refId, String standard, String spec) {
        QaTestImagestore elem = new QaTestImagestore();
        if (!params.containsKey("sampletestId") || StringSupport.isNullOrEmpty(params.get("sampletestId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger clientId = (params.containsKey("clientId") && StringSupport.isNotNullAndNotEmpty(params.get("clientId"))) ? NumberSupport.getBigInteger(params.get("clientId").toString()) : null;
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        // Header
        ManageITHeader header = new ManageITHeader();
        header.setUser(StringSupport.getString(params.get("user")));
        header.setModIp(StringSupport.getString(params.get("modIp")));
        header.setClientid(StringSupport.getString(params.get("clientId")));
        // File Data
        elem.setClientId(clientId);
        elem.setSampleid(NumberSupport.getBigInteger(params.get("sampleId")));
        elem.setSampletestId(NumberSupport.getBigInteger(params.get("sampletestId")));
        elem.setRefId(refId);
        elem.setSourceName(StringSupport.emptyOnNull(metaDataFile.get("ofilename")));
        elem.setServerPath(StringSupport.emptyOnNull(metaDataFile.get("filename")));
        elem.setFName(StringSupport.emptyOnNull(metaDataFile.get("timename")));
        elem.setFSize(NumberSupport.getBigInteger(StringSupport.emptyOnNull(metaDataFile.get("size"))));
        elem.setMetadata(populateMetadata(StringSupport.emptyOnNull(metaDataFile.get("filename"))));
        elem.setTotalPages(NumberSupport.getInteger(getMetadata(elem).get("totalPages")));
        elem.setWidth(NumberSupport.getInteger(metaDataFile.get("width")));
        elem.setHeight(NumberSupport.getInteger(metaDataFile.get("height")));
        elem.setReportStatus(StringSupport.getActiveAsCharacter(StringSupport.getString(params.get("reportStatus"))));
        //elem.setFNote();
        elem.setExtension(StringSupport.emptyOnNull(metaDataFile.get("ext")));
        elem.setStandard(standard);
        elem.setSpec(spec);
        //docType
        elem.setDocType(StringSupport.getString(params.get("docType")));
        save(header, elem);

        if (params.containsKey("reportpath")) {
            deleteReportCache(params.get("reportpath").toString());
        }
    }

    private Map<String, Object> getMetadata(QaTestImagestore elem) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> readmap = new HashMap<>();
        try {
            readmap = mapper.readValue(elem.getMetadata(), Map.class);
            return readmap;
        } catch (IOException ex) {
            Logger.getLogger(QaTestImagestoreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readmap;
    }

    private String populateMetadata(String filePath) {
        String json = "{}";
        try {
            PdfContext contextPdf = new PdfContext(filePath);

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode metadataNode = mapper.createObjectNode();
            metadataNode.put("totalPages", StringSupport.getString(contextPdf.getpPdfDoc().getTotalPages()));

            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(metadataNode);
        } catch (FileNotFoundException ex) {
            return "{}";
        } catch (FormatDocumentNotAllowedException ex) {
            return "{}";
        } catch (IOException ex) {
            return "{}";
        }
        return json;
    }

    private void deleteReportCache(String reportPath) {
        if (StringSupport.isNotNullAndNotEmpty(reportPath)) {
            try {
                FileSupport.removeFile(reportPath);
            } catch (IOException ex) {
                return;
            }
        }
    }

    @Override
    public void updateReportStatus(String id, String reportStatus, String reportPath) {
        if (StringSupport.isNotNullAndNotEmpty(id, reportStatus, reportPath) && NumberSupport.isNumeric(id)) {
            QaTestImagestore model = findById(id);
            if (model != null) {
                model.setReportStatus(StringSupport.getActiveAsCharacter(reportStatus));
                dao.update(model);
                deleteReportCache(reportPath);
            }
        }
    }

    @Override
    public List<QaTestImagestore> getImageListByWoId(BigInteger woId) {
        if (woId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getImageListByWoId(woId);
    }

    @Override
    public void rotateImage(BigDecimal id, String side) {
        if (id == null && StringSupport.isNullOrEmpty(side)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        try {
            QaTestImagestore testImage = findById(id);
            ImageSupport.rotateImage(testImage.getServerPath(), testImage.getServerPath(), side);
        } catch (Exception ex) {
            Logger.getLogger(QaTestImagestoreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
