/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QaconcCompstroutDao;
import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTest;
import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserejb.model.QaSampleTestDaysSpec;
import com.atser.tools.atserejb.model.QaconcCompstr;
import com.atser.tools.atserejb.model.QaconcCompstrout;
import com.atser.tools.atserejb.service.glob.GlobDataGatewayLogService;
import com.atser.tools.atserejb.service.qa.QaSampleService;
import com.atser.tools.atserejb.service.qa.QaSampleTestDaysSpecService;
import com.atser.tools.atserejb.service.qa.QaSampleTestService;
import com.atser.tools.atserejb.service.qa.QaconcCompstrService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.eLabSpecification;
import com.atser.tools.atserutil.enumerator.parser.eT22Test;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.T22TestPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model.T22TestDef;
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
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.openxml4j.util.ZipSecureFile;

@Stateless
@LabTest(type = eLabSpecification.AASHTO_T22)
public class QaconcCompstroutServiceImpl implements QaconcCompstroutService, ILabTestStorageStrategy, IBaseEJBException {

    @Inject
    private QaconcCompstroutDao dao;

    @Inject
    private QaconcCompstrService qaconcCompstrService;

    @Inject
    private QaSampleService qaSampleService;

    @Inject
    private QaSampleTestDaysSpecService qaSampleTestDaysSpecService;

    @Inject
    private QaSampleTestService qaSampleTestService;

    @Inject
    private GlobDataGatewayLogService globDataGatewayLogService;

    @Override
    public QaconcCompstrout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaconcCompstrout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaconcCompstrout findByTestIdAndNo(BigInteger testId, String no) {
        if (testId == null || StringSupport.isNullOrEmpty(no)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findByTestIdAndNo(testId, no);
    }

    @Override
    public void save(QaconcCompstrout elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaconcCompstrout elem) {
        if (elem != null) {
            QaconcCompstrout model = findById(elem.getId());
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
    public List<QaconcCompstrout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void parseCsvAndSave(String pPath, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenericStatusPojo> parseExcelAndSave(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("projectId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GenericStatusPojo> importErrors = new ArrayList<>();
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        T22TestPluginDirector director;
        director = new T22TestPluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eT22Test.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<T22TestDef> model = director.getModelAllSheets();
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.emptyOnNull(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        if (model != null) {
            Integer totalImport = model.size();
            for (T22TestDef it : model) {
                GenericStatusPojo response = importT22SaveOrUpdate(header, StringSupport.getString(params.get("projectId")), it);
                if (response != null) {
                    importErrors.add(response);
                    totalImport--;
                }
            }
            // Track Import By Project
            globDataGatewayLogService.save(new GlobDataGatewayLog(NumberSupport.getBigInteger(params.get("clientId")),
                    NumberSupport.getBigInteger(params.get("projectId")),
                    StringSupport.getString(params.get("functionality")),
                    StringSupport.getString(metaDataFile.get("ofilename")),
                    NumberSupport.getBigInteger(totalImport),
                    StringSupport.emptyOnNull(params.get("sessionUser")),
                    StringSupport.emptyOnNull(params.get("modIp"))));
        }

        return importErrors;
    }

    private GenericStatusPojo importT22SaveOrUpdate(ManageITHeader header, String projectId, T22TestDef def) {
        if (def != null) {
            // Find Sample
            QaSample sampleDb = qaSampleService.findBySampleNo(def.getSampleNumber(), NumberSupport.getBigInteger(projectId));
            if (sampleDb == null) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Sample Not Found.");
            }
            try {
                // Find Sample Test
                QaSampleTest sampleTest = qaSampleTestService.createEmptyTestOrGetTest(header, sampleDb, "concrete", "qaconc_compstr");
                if (sampleTest == null) {
                    return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Sample Test Not Found.");
                }
                QaconcCompstr concComp = qaconcCompstrService.createEmptyOrGet(header, sampleDb, sampleTest.getId().toBigInteger());
                QaconcCompstrout concCompOut = dao.findByTestIdAndNo(concComp.getId().toBigInteger(), def.getSerialNo());
                if (concCompOut != null) {
                    // Update
                    return performT22TestUpdate(header, def, concCompOut, sampleTest);
                } else {
                    // Save
                    return performT22TestSave(header, def, concComp);
                }
            } catch (BaseException ex) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
            }
        }
        return null;
    }

    private GenericStatusPojo performT22TestSave(ManageITHeader header, T22TestDef def, QaconcCompstr concComp) {
        try {
            // Creating QaconcCompstrout
            QaconcCompstrout concCompOut = new QaconcCompstrout();
            concCompOut.setTestId(NumberSupport.getBigInteger(concComp.getId()));
            concCompOut.setNo(def.getSerialNo());
            Boolean isHours = (def.getTestAgeType() != null && (def.getTestAgeType().equals("hour") || def.getTestAgeType().equals("hours")));
            if (isHours) {
                concCompOut.setTestageHours(def.getTestAge());
            } else {
                concCompOut.setTestage(def.getTestAge());
            }
            concCompOut.setDatetest(def.getTestDate());
            concCompOut.setDiameter(def.getDiameter());
            concCompOut.setArea(def.getArea());
            concCompOut.setMaximumload(def.getMaxLoad());
            concCompOut.setCompressStrength(def.getCompressiveStr());
            concCompOut.setDiscard("N");
            concCompOut.setDiscardCompleted('N');
            concCompOut.setDiscardRequired('N');
            concCompOut.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            concCompOut.setCreateBy(header.getUser());
            concCompOut.setCreateByIp(header.getModIp());
            concCompOut.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            concCompOut.setLastModIp(header.getModIp());
            concCompOut.setLastModBy(header.getUser());
            concCompOut.setActive('Y');
            concCompOut.setVersion("0");
            //Saving
            save(concCompOut);
            //Creating/Updating QaSampleTestDaysSpec
            if (StringSupport.isNullOrEmpty(def.getTestAge(), def.getTestAgeType())) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Age or Age Unit is Empty.");
            }
            createUpdateSampleTestDaySpec(header, def, concComp.getSampletestId(), isHours);
        } catch (BaseException ex) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
        }
        return null;
    }

    private GenericStatusPojo performT22TestUpdate(ManageITHeader header, T22TestDef def, QaconcCompstrout concCompOut, QaSampleTest sampleTest) {
        try {
            // Updating QaconcCompstrout
            Boolean isHours = (def.getTestAgeType() != null && (def.getTestAgeType().equals("hour") || def.getTestAgeType().equals("hours")));
            if (isHours) {
                concCompOut.setTestageHours(def.getTestAge());
            } else {
                concCompOut.setTestage(def.getTestAge());
            }
            concCompOut.setDatetest(def.getTestDate());
            concCompOut.setDiameter(def.getDiameter());
            concCompOut.setArea(def.getArea());
            concCompOut.setMaximumload(def.getMaxLoad());
            concCompOut.setCompressStrength(def.getCompressiveStr());
            concCompOut.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            concCompOut.setLastModIp(header.getModIp());
            concCompOut.setLastModBy(header.getUser());
            //updating
            dao.update(concCompOut);
            //Creating/Updating QaSampleTestDaysSpec
            if (StringSupport.isNullOrEmpty(def.getTestAge(), def.getTestAgeType())) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Age or Age Unit is Empty.");
            }
            createUpdateSampleTestDaySpec(header, def, sampleTest.getId().toBigInteger(), isHours);
        } catch (BaseException ex) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
        }
        return null;
    }

    private void createUpdateSampleTestDaySpec(ManageITHeader header, T22TestDef def, BigInteger sampleTestId, Boolean isHours) {
        QaSampleTestDaysSpec sampleTestDaySpec = qaSampleTestDaysSpecService.findBySampleTestIdAndTestAge(sampleTestId, def.getTestAge(), isHours);
        if (sampleTestDaySpec == null) { // Creating QaSampleTestDaysSpec
            sampleTestDaySpec = new QaSampleTestDaysSpec();
            sampleTestDaySpec.setSampleTestId(sampleTestId);
            if (isHours) {
                sampleTestDaySpec.setTestageHours(def.getTestAge());
            } else {
                sampleTestDaySpec.setTestage(def.getTestAge());
            }
            sampleTestDaySpec.setSpecMin(def.getSpecMin());
            sampleTestDaySpec.setSpecMax(def.getSpecMax());
            sampleTestDaySpec.setResult(def.getPassfail());
            sampleTestDaySpec.setAverage(def.getCompressiveStr());
            qaSampleTestDaysSpecService.save(header, sampleTestDaySpec);
        } else { // Updating QaSampleTestDaysSpec
            if (isHours) {
                sampleTestDaySpec.setTestageHours(def.getTestAge());
            } else {
                sampleTestDaySpec.setTestage(def.getTestAge());
            }
            sampleTestDaySpec.setSpecMin(def.getSpecMin());
            sampleTestDaySpec.setSpecMax(def.getSpecMax());
            sampleTestDaySpec.setResult(def.getPassfail());
            sampleTestDaySpec.setAverage(def.getCompressiveStr());
            qaSampleTestDaysSpecService.update(header, sampleTestDaySpec);
        }
    }

}
