/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QaaspmFractureScboutDao;
import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTest;
import com.atser.tools.atserejb.model.QaaspmFractureScbout;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.read.csv.CsvContext;
import com.atser.tools.atserutil.enumerator.eLabSpecification;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

@Stateless
@LabTest(type = eLabSpecification.AASHTO_TP124)
public class QaaspmFractureScboutServiceImpl implements QaaspmFractureScboutService, ILabTestStorageStrategy, IBaseEJBException {

    @Inject
    private QaaspmFractureScboutDao dao;

    @Override
    public QaaspmFractureScbout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaaspmFractureScbout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaaspmFractureScbout findBySampleIdAndSpecimenNo(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
        if (sampleId != null && specNo != null) {
            return dao.findBySampleIdAndSpecimenNo(sampleId, sampletestId, specNo);
        }
        return null;
    }

    @Override
    public void save(QaaspmFractureScbout elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaaspmFractureScbout elem) {
        if (elem != null) {
            QaaspmFractureScbout model = findById(elem.getId());
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
    public List<QaaspmFractureScbout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existsQaaspmFractureScbout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
        if (sampleId != null && specNo != null) {
            return dao.existsQaaspmFractureScbout(sampleId, sampletestId, specNo);
        }
        return Boolean.FALSE;
    }

    @Override
    public void parseCsvAndSave(String pPath, Map<String, Object> params) {
        if (!params.containsKey("sampleId") || StringSupport.isNullOrEmpty(params.get("sampleId")) || !params.containsKey("sampletestId") || StringSupport.isNullOrEmpty(params.get("sampletestId")) || !params.containsKey("specId") || StringSupport.isNullOrEmpty(params.get("specId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request. Missing parameters !");
        }
        try {
            QaaspmFractureScbout model = parseCsvForTP124(pPath);
            updateFromCsv(NumberSupport.getBigInteger(params.get("sampleId")), NumberSupport.getBigInteger(params.get("sampletestId")), NumberSupport.getBigInteger(params.get("specId").toString()), model, StringSupport.getString(params.get("user")), StringSupport.getString(params.get("modIp")));
        } catch (TemplateDifferentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    private void updateFromCsv(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo, QaaspmFractureScbout elem, String user, String modIp) {
        if (elem == null || !existsQaaspmFractureScbout(sampleId, sampletestId, specNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Test not found to update!");
        }
        QaaspmFractureScbout model = findBySampleIdAndSpecimenNo(sampleId, sampletestId, specNo);
        if (!model.equals(elem)) {
            model.setPeakLoad(elem.getPeakLoad());
            model.setRecordedTimePeakLoad(elem.getRecordedTimePeakLoad());
            model.setLoadLineDisplacePeakLoad(elem.getLoadLineDisplacePeakLoad());
            model.setCriticalDisplacement(elem.getCriticalDisplacement());
            model.setPostPeakSlope(elem.getPostPeakSlope());
            model.setFractureEnergy(elem.getFractureEnergy());
            model.setFlexibilityIndex(elem.getFlexibilityIndex());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(user);
            model.setLastModIp(modIp);
            dao.update(model);
        }
    }

    private QaaspmFractureScbout parseCsvForTP124(String filePath) throws TemplateDifferentException {
        QaaspmFractureScbout response = new QaaspmFractureScbout();
        File fcsv = new File(filePath);
        Boolean validateCsv = Boolean.FALSE;
        CsvContext ctx;
        try {
            ctx = new CsvContext(fcsv);
            CSVFormat csvFormat = CSVFormat.DEFAULT.withAllowMissingColumnNames(false).withIgnoreEmptyLines().withFirstRecordAsHeader().withSkipHeaderRecord().withTrim();
            try {
                Iterable<CSVRecord> records = ctx.getpCsvDoc().getRecords(csvFormat);
                for (CSVRecord record : records) {
                    if (record.getRecordNumber() == 15) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setPeakLoad(rdv[0]);
                        } else {
                            response.setPeakLoad(null);
                        }
                    }
                    if (record.getRecordNumber() == 16) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setRecordedTimePeakLoad(rdv[0]);
                        } else {
                            response.setRecordedTimePeakLoad(null);
                        }
                    }
                    if (record.getRecordNumber() == 17) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setLoadLineDisplacePeakLoad(rdv[0]);
                        } else {
                            response.setLoadLineDisplacePeakLoad(null);
                        }
                    }
                    if (record.getRecordNumber() == 30) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setCriticalDisplacement(rdv[0]);
                        } else {
                            response.setCriticalDisplacement(null);
                        }
                    }
                    if (record.getRecordNumber() == 26) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setPostPeakSlope(rdv[0]);
                        } else {
                            response.setPostPeakSlope(null);
                        }
                    }
                    if (record.getRecordNumber() == 25) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setFractureEnergy(rdv[0]);
                        } else {
                            response.setFractureEnergy(null);
                        }
                    }
                    if (record.getRecordNumber() == 28) {
                        String[] rd = record.get(0).split(":");
                        if (rd.length == 2 && StringSupport.isNotNullAndNotEmpty(rd[1])) {
                            validateCsv = Boolean.TRUE;
                            String[] rdv = rd[1].trim().split(" ");
                            response.setFlexibilityIndex(rdv[0]);
                        } else {
                            response.setFlexibilityIndex(null);
                        }
                    }
                }
            } catch (IOException ex) {
                throw new TemplateDifferentException("Wrong CSV Format !");
            }
            if (!validateCsv) {
                throw new TemplateDifferentException("Wrong CSV Format !");
            }
            return response;
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
        } catch (FileNotFoundException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "File not found.");
        }
        return null;
    }

    @Override
    public List<GenericStatusPojo> parseExcelAndSave(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
