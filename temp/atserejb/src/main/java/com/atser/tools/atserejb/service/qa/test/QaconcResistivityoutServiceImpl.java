/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QaconcResistivityoutDao;
import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTest;
import com.atser.tools.atserejb.model.QaconcResistivityout;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.read.csv.CsvContext;
import com.atser.tools.atserutil.enumerator.eLabSpecification;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
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
@LabTest(type = eLabSpecification.AASHTO_T358)
public class QaconcResistivityoutServiceImpl implements QaconcResistivityoutService, ILabTestStorageStrategy, IBaseEJBException {

    @Inject
    private QaconcResistivityoutDao dao;

    @Override
    public QaconcResistivityout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaconcResistivityout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaconcResistivityout findBySampleIdAndCylinderNo(BigInteger sampleId, BigInteger sampletestId, Integer cNo) {
        if (sampleId != null && cNo != null) {
            return dao.findBySampleIdAndCylinderNo(sampleId, sampletestId, cNo);
        }
        return null;
    }

    @Override
    public void save(QaconcResistivityout elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaconcResistivityout elem) {
        if (elem != null) {
            QaconcResistivityout model = findById(elem.getId());
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
    public List<QaconcResistivityout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existsQaconcResistivityout(BigInteger sampleId, BigInteger sampletestId, Integer cNo) {
        if (sampleId != null && cNo != null) {
            return dao.existsQaconcResistivityout(sampleId, sampletestId, cNo);
        }
        return Boolean.FALSE;
    }

    @Override
    public void parseCsvAndSave(String pPath, Map<String, Object> params) {
        if (!params.containsKey("sampleId") || StringSupport.isNullOrEmpty(params.get("sampleId")) || !params.containsKey("sampletestId") || StringSupport.isNullOrEmpty(params.get("sampletestId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
        }
        try {
            AtserLinkedHashMap<Integer, QaconcResistivityout> cylinders = parseCsvForT358(pPath);
            cylinders.entrySet().forEach((entry) -> {
                Integer key = entry.getKey();
                QaconcResistivityout value = entry.getValue();
                updateFromCsv(NumberSupport.getBigInteger(params.get("sampleId")), NumberSupport.getBigInteger(params.get("sampletestId")), key, value, StringSupport.getString(params.get("user")), StringSupport.getString(params.get("modIp")));
            });
        } catch (TemplateDifferentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    private void updateFromCsv(BigInteger sampleId, BigInteger sampletestId, Integer cNo, QaconcResistivityout elem, String user, String modIp) {
        if (elem == null || !existsQaconcResistivityout(sampleId, sampletestId, cNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Test not found to update!");
        }
        QaconcResistivityout model = findBySampleIdAndCylinderNo(sampleId, sampletestId, cNo);
        if (!model.equals(elem)) {
            model.setAngle1(elem.getAngle1());
            model.setAngle2(elem.getAngle2());
            model.setAngle3(elem.getAngle3());
            model.setAngle4(elem.getAngle4());
            model.setAngle5(elem.getAngle5());
            model.setAngle6(elem.getAngle6());
            model.setAngle7(elem.getAngle7());
            model.setAngle8(elem.getAngle8());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(user);
            model.setLastModIp(modIp);
            dao.update(model);
        }
    }

    private AtserLinkedHashMap<Integer, QaconcResistivityout> parseCsvForT358(String filePath) throws TemplateDifferentException {
        AtserLinkedHashMap<Integer, QaconcResistivityout> response = new AtserLinkedHashMap<>();
        File fcsv = new File(filePath);
        CsvContext ctx;
        try {
            ctx = new CsvContext(fcsv);
            CSVFormat csvFormat = CSVFormat.DEFAULT.withAllowMissingColumnNames(false).withIgnoreEmptyLines().withFirstRecordAsHeader().withSkipHeaderRecord().withDelimiter(',');
            try {
                Iterable<CSVRecord> records = ctx.getpCsvDoc().getRecords(csvFormat);
                for (CSVRecord record : records) {
                    if (record.get(0).equals("A")) {
                        QaconcResistivityout c1 = new QaconcResistivityout();
                        c1.setAngle1(record.get(1));
                        c1.setAngle2(record.get(2));
                        c1.setAngle3(record.get(3));
                        c1.setAngle4(record.get(4));
                        c1.setAngle5(record.get(5));
                        c1.setAngle6(record.get(6));
                        c1.setAngle7(record.get(7));
                        c1.setAngle8(record.get(8));
                        response.put(1, c1);
                    }
                    if (record.get(0).equals("B")) {
                        QaconcResistivityout c2 = new QaconcResistivityout();
                        c2.setAngle1(record.get(1));
                        c2.setAngle2(record.get(2));
                        c2.setAngle3(record.get(3));
                        c2.setAngle4(record.get(4));
                        c2.setAngle5(record.get(5));
                        c2.setAngle6(record.get(6));
                        c2.setAngle7(record.get(7));
                        c2.setAngle8(record.get(8));
                        response.put(2, c2);
                    }
                    if (record.get(0).equals("C")) {
                        QaconcResistivityout c3 = new QaconcResistivityout();
                        c3.setAngle1(record.get(1));
                        c3.setAngle2(record.get(2));
                        c3.setAngle3(record.get(3));
                        c3.setAngle4(record.get(4));
                        c3.setAngle5(record.get(5));
                        c3.setAngle6(record.get(6));
                        c3.setAngle7(record.get(7));
                        c3.setAngle8(record.get(8));
                        response.put(3, c3);
                    }
                }
            } catch (IOException ex) {
                throw new TemplateDifferentException("Wrong CSV Format !");
            }
            if (response.isEmpty()) {
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
