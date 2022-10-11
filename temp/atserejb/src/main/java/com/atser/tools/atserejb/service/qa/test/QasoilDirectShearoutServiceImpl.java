/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QasoilDirectShearoutDao;
import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTest;
import com.atser.tools.atserejb.model.QasoilDirectShearout;
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
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

@Stateless
@LabTest(type = eLabSpecification.AASHTO_T236)
public class QasoilDirectShearoutServiceImpl implements QasoilDirectShearoutService, ILabTestStorageStrategy, IBaseEJBException {

    @Inject
    private QasoilDirectShearoutDao dao;

    @Override
    public QasoilDirectShearout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QasoilDirectShearout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QasoilDirectShearout findBySampleAndSampleTestId(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
        if (sampleId != null && sampletestId != null) {
            return dao.findBySampleAndSampleTestId(sampleId, sampletestId, specNo);
        }
        return null;
    }

    @Override
    public void save(QasoilDirectShearout elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QasoilDirectShearout elem) {
        if (elem != null) {
            QasoilDirectShearout model = findById(elem.getId());
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
    public List<QasoilDirectShearout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existsQasoilDirectShearout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
        if (sampleId != null && sampletestId != null) {
            return dao.existsQasoilDirectShearout(sampleId, sampletestId, specNo);
        }
        return Boolean.FALSE;
    }

    private Field getFieldByFieldName(Class persistentClass, String fieldName) {
        Field field;
        try {
            field = persistentClass.getDeclaredField(fieldName);
            if (field != null) {
                return field;
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }

    private Boolean getCsvSingleValue(CSVRecord record, String keyname, QasoilDirectShearout model, String fieldName) {
        if (StringSupport.isNotNullAndNotEmpty(record.get(0)) && record.get(0).equals(keyname)) {
            if (StringSupport.isNotNullAndNotEmpty(record.get(1))) {
                Field versionField = getFieldByFieldName(model.getClass(), fieldName);
                if (versionField != null) {
                    versionField.setAccessible(true);
                    try {
                        versionField.set(model, StringSupport.getString(record.get(1)));
                        return Boolean.TRUE;
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        return Boolean.FALSE;
                    }
                }
            } else {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public void parseCsvAndSave(String pPath, Map<String, Object> params) {
        if (!params.containsKey("sampleId") || StringSupport.isNullOrEmpty(params.get("sampleId")) || !params.containsKey("sampletestId") || StringSupport.isNullOrEmpty(params.get("sampletestId")) || !params.containsKey("specId") || StringSupport.isNullOrEmpty(params.get("specId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request. Missing parameters !");
        }
        try {
            QasoilDirectShearout model = parseCsvForT236(pPath);
            updateFromCsv(NumberSupport.getBigInteger(params.get("sampleId")), NumberSupport.getBigInteger(params.get("sampletestId")), NumberSupport.getBigInteger(params.get("specId").toString()), model, StringSupport.getString(params.get("user")), StringSupport.getString(params.get("modIp")));
        } catch (TemplateDifferentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    private void updateFromCsv(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo, QasoilDirectShearout elem, String user, String modIp) {
        if (elem == null || !existsQasoilDirectShearout(sampleId, sampletestId, specNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Test not found to update!");
        }
        QasoilDirectShearout model = findBySampleAndSampleTestId(sampleId, sampletestId, specNo);
        if (!model.equals(elem)) {
            model.setDateTest(elem.getDateTest());
            model.setConsolidationNoStages(elem.getConsolidationNoStages());
            model.setConsolidationSettlement(elem.getConsolidationSettlement());
            model.setBeforeTestDiameter(elem.getBeforeTestDiameter());
            model.setBeforeTestHeight(elem.getBeforeTestHeight());
            model.setBeforeTestWaterContent(elem.getBeforeTestWaterContent());
            model.setBeforeTestArea(elem.getBeforeTestArea());
            model.setBeforeTestWetDensity(elem.getBeforeTestWetDensity());
            model.setBeforeTestDryDensity(elem.getBeforeTestDryDensity());
            model.setBeforeTestVoidRatio(elem.getBeforeTestVoidRatio());
            model.setBeforeTestSaturation(elem.getBeforeTestSaturation());
            model.setShearNoStages(elem.getShearNoStages());
            model.setShearMaxShearStress(elem.getShearMaxShearStress());
            model.setShearMaxShearForce(elem.getShearMaxShearForce());
            model.setBeforeTestVolumeSolids(elem.getBeforeTestVolumeSolids());
            model.setShearMaxDisplacement(elem.getShearMaxDisplacement());
            model.setShearTravel(elem.getShearTravel());
            model.setShearAvgRate(elem.getShearAvgRate());
            model.setShearHeightChange(elem.getShearHeightChange());
            model.setShearFinalHeight(elem.getShearFinalHeight());
            model.setShearFinalVolume(elem.getShearFinalVolume());
            model.setAfterTestWaterContent(elem.getAfterTestWaterContent());
            model.setAfterTestDryDensity(elem.getAfterTestDryDensity());
            model.setAfterTestWetDensity(elem.getAfterTestWetDensity());
            model.setAfterTestVoidRatio(elem.getAfterTestVoidRatio());
            model.setAfterTestSaturation(elem.getAfterTestSaturation());
            model.setBoringNo(elem.getBoringNo());
            model.setDepth(elem.getDepth());
            model.setDescription(elem.getDescription());
            model.setSpecificGravity(elem.getSpecificGravity());
            model.setPrep(elem.getPrep());
            model.setSpecimenType(elem.getSpecimenType());
            model.setShearAvgNormalStress(elem.getShearAvgNormalStress());
            model.setUscsClass(elem.getUscsClass());
            model.setAashtoClass(elem.getAashtoClass());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(user);
            model.setLastModIp(modIp);
            dao.update(model);
        }
    }

    private QasoilDirectShearout parseCsvForT236(String filePath) throws TemplateDifferentException {
        QasoilDirectShearout model = new QasoilDirectShearout();
        List<Double> normalStressAvg = new ArrayList<>();
        File fcsv = new File(filePath);
        CsvContext ctx;
        Boolean validateCsv = Boolean.FALSE;
        try {
            ctx = new CsvContext(fcsv);
            CSVFormat csvFormat = CSVFormat.DEFAULT.withAllowMissingColumnNames(false).withIgnoreEmptyLines().withFirstRecordAsHeader().withSkipHeaderRecord().withTrim();
            try {
                Iterable<CSVRecord> records = ctx.getpCsvDoc().getRecords(csvFormat);
                for (CSVRecord record : records) {
                    if (record.size() == 2) {
                        if (getCsvSingleValue(record, "CONSOLIDATION.START_DATETIME", model, "dateTest")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "CONSOLIDATION.NO_STAGES", model, "consolidationNoStages")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "CONSOLIDATION.MAX_SETTLEMENT", model, "consolidationSettlement")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "FILE_INFO.SHEAR_BOX_DIA", model, "beforeTestDiameter")) {
                            validateCsv = Boolean.TRUE;
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.INITIAL_HT", model, "beforeTestHeight")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.MOISTURE", model, "beforeTestWaterContent")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.VOL_SOLIDS", model, "beforeTestVolumeSolids")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.AREA", model, "beforeTestArea")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.WD", model, "beforeTestWetDensity")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.DD", model, "beforeTestDryDensity")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.VOID_RATION", model, "beforeTestVoidRatio")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SAMPLE_SETUP.SATURATION", model, "beforeTestSaturation")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.NO_STAGES", model, "shearNoStages")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.MAX_SSTRESS", model, "shearMaxShearStress")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.MAX_SLOAD", model, "shearMaxShearForce")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.MAX_SDISPLACE", model, "shearMaxDisplacement")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.CUM_TRAVEL", model, "shearTravel")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.AVG_RATE", model, "shearAvgRate")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.HT_CHANGE", model, "shearHeightChange")) {
                            validateCsv = Boolean.TRUE;
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.HT_FINAL", model, "shearFinalHeight")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.VOL_FINAL", model, "shearFinalVolume")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.FINAL_PERCMOIST", model, "afterTestWaterContent")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.FINAL_DD", model, "afterTestDryDensity")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.FINAL_WD", model, "afterTestWetDensity")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.VOID_RATIO", model, "afterTestVoidRatio")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "SHEAR.SATURATION", model, "afterTestSaturation")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.BORING_NO", model, "boringNo")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.SAMPLE_DEPTH", model, "depth")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.SAMPLE_DESC", model, "description")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.SPGR_SOLIDS", model, "specificGravity")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.SAMPLE_PREP", model, "prep")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.SPECIMEN_TYPE", model, "specimenType")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.USCS_CLASS", model, "uscsClass")) {
                            continue;
                        }
                        if (getCsvSingleValue(record, "TEST_INFO.AASHTO_CLASS", model, "aashtoClass")) {
                            continue;
                        }
                    }

                    if (record.size() > 2 && StringSupport.isNotNullAndNotEmpty(record.get(0)) && record.get(0).equals("{SHEAR}")) {
                        normalStressAvg.add((StringSupport.isNullOrEmpty(record.get(14)) ? 0d : NumberSupport.getBigDecimal(record.get(14)).doubleValue()));
                    }
                }
                DoubleSummaryStatistics sum = normalStressAvg.stream().mapToDouble((x) -> x).summaryStatistics();
                model.setShearAvgNormalStress(StringSupport.getString(sum.getAverage()));
            } catch (IOException ex) {
                throw new TemplateDifferentException("Wrong CSV Format !");
            }
            if (!validateCsv) {
                throw new TemplateDifferentException("Wrong CSV Format !");
            }
            return model;
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
