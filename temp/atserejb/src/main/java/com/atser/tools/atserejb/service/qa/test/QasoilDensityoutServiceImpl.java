/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QasoilDensityoutDao;
import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTest;
import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserejb.model.GlobSpecItemMat;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaSampleCatg;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserejb.model.QasoilDensity;
import com.atser.tools.atserejb.model.QasoilDensityout;
import com.atser.tools.atserejb.service.glob.GlobContractorContractService;
import com.atser.tools.atserejb.service.glob.GlobDataGatewayLogService;
import com.atser.tools.atserejb.service.glob.GlobSpecItemMatService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.service.qa.QaSampleCatgService;
import com.atser.tools.atserejb.service.qa.QaSampleService;
import com.atser.tools.atserejb.service.qa.QaSampleTestService;
import com.atser.tools.atserejb.service.qa.QasoilDensityService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.eLabSpecification;
import com.atser.tools.atserutil.enumerator.parser.eT310Test;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.T310TestPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model.SoilTestDef;
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
@LabTest(type = eLabSpecification.AASHTO_T310)
public class QasoilDensityoutServiceImpl implements QasoilDensityoutService, ILabTestStorageStrategy, IBaseEJBException {

    @Inject
    private QasoilDensityoutDao dao;

    @Inject
    private QaSampleService qaSampleService;

    @Inject
    private GlobDataGatewayLogService globDataGatewayLogService;

    @Inject
    private QasoilDensityService qasoilDensityService;

    @Inject
    private GlobContractorContractService globContractorContractService;

    @Inject
    private GlobSupplierService globSupplierService;

    @Inject
    private QaSampleCatgService qaSampleCatgService;

    @Inject
    private QaSampleTestService qaSampleTestService;
    
    @Inject
    private GlobSpecItemMatService globSpecItemMatService;

    @Override
    public QasoilDensityout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QasoilDensityout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QasoilDensityout findByTestIdAndNo(BigInteger testId, String no) {
        if (testId == null || StringSupport.isNullOrEmpty(no)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findByTestIdAndNo(testId, no);
    }

    @Override
    public void save(QasoilDensityout elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QasoilDensityout elem) {
        if (elem != null) {
            QasoilDensityout model = findById(elem.getId());
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
    public List<QasoilDensityout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void parseCsvAndSave(String pPath, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // **************** Import Soil Sample/Test [BEGIN] *************************
    @Override
    public List<GenericStatusPojo> parseExcelAndSave(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("projectId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GenericStatusPojo> importErrors = new ArrayList<>();
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        T310TestPluginDirector director;
        director = new T310TestPluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eT310Test.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<SoilTestDef> model = director.getModelAllSheets();
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.emptyOnNull(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        if (model != null) {
            Integer totalImport = model.size();
            for (SoilTestDef it : model) {
                GenericStatusPojo response = importT310SaveOrUpdate(header, StringSupport.getString(params.get("projectId")), it);
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

    private GenericStatusPojo importT310SaveOrUpdate(ManageITHeader header, String projectId, SoilTestDef def) {
        if (def != null) {
            try {
                if(StringSupport.isNullOrEmpty(def.getTestNo())) {
                    return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Soil Test No is Required.");
                }
                // Find Sample
                QaSample sampleDb = createSampleOrGet(header, projectId, def);
                if (sampleDb == null) {
                    return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "We were not able to create the sample.");
                }
                // Find Sample Test
                QaSampleTest sampleTest = qaSampleTestService.createEmptyTestOrGetTest(header, sampleDb, "soil", "qasoil_density");
                if (sampleTest == null) {
                    return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Sample Test Not Found.");
                }
                // Create or Find Soil Density
                QasoilDensity soilDensity = createSoilDensityOrGet(header, projectId, sampleDb, sampleTest.getId().toBigInteger(), def);
                // Create or Update Soil Density Out
                QasoilDensityout soilDensityOut = dao.findByTestIdAndNo(soilDensity.getId().toBigInteger(), def.getTestNo());
                if (soilDensityOut != null) {
                    // Update
                    return performT310TestUpdate(header, def, soilDensityOut);
                } else {
                    // Save
                    return performT310TestSave(header, def, soilDensity);
                }
            } catch (BaseException ex) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
            }
        }
        return null;
    }
    
    private GenericStatusPojo performT310TestSave(ManageITHeader header, SoilTestDef def, QasoilDensity soilDensity) {
        try {
            // Creating QasoilDensityout
            QasoilDensityout soilDensityOut = new QasoilDensityout();
            soilDensityOut.setTestId(NumberSupport.getBigInteger(soilDensity.getId()));
            soilDensityOut.setTestNo(def.getTestNo());
            soilDensityOut.setMaxdrydensity(def.getMaxDryDensity());
            soilDensityOut.setOptmoisture(def.getOptimunMoistureContent());
            soilDensityOut.setWetdensity(def.getWetDensity());
            soilDensityOut.setDrydensity(def.getDryDensity());
            soilDensityOut.setMoisturecontent(def.getMoistureContent());
            soilDensityOut.setCompaction(def.getPctCompaction());
            soilDensityOut.setRetest("No");
            soilDensityOut.setOnePointTaken("No");
            soilDensityOut.setSuperceded('N');
            soilDensityOut.setEngDecision("No");
            soilDensityOut.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            soilDensityOut.setCreateBy(header.getUser());
            soilDensityOut.setCreateByIp(header.getModIp());
            soilDensityOut.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            soilDensityOut.setLastModIp(header.getModIp());
            soilDensityOut.setLastModBy(header.getUser());
            soilDensityOut.setActive('Y');
            soilDensityOut.setVersion("0");
            //Saving
            save(soilDensityOut);
        } catch (BaseException ex) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
        }
        return null;
    }
    
    private GenericStatusPojo performT310TestUpdate(ManageITHeader header, SoilTestDef def, QasoilDensityout soilDensityOut) {
        try {
            // Updating QasoilDensityout
            soilDensityOut.setMaxdrydensity(def.getMaxDryDensity());
            soilDensityOut.setOptmoisture(def.getOptimunMoistureContent());
            soilDensityOut.setWetdensity(def.getWetDensity());
            soilDensityOut.setDrydensity(def.getDryDensity());
            soilDensityOut.setMoisturecontent(def.getMoistureContent());
            soilDensityOut.setCompaction(def.getPctCompaction());
            soilDensityOut.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            soilDensityOut.setLastModIp(header.getModIp());
            soilDensityOut.setLastModBy(header.getUser());
            //Updating
            dao.update(soilDensityOut);
        } catch (BaseException ex) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, ex.getError());
        }
        return null;
    }
    
    private BigDecimal getSampleInfoIdFromDef(String contId, String projectId) {
        if (StringSupport.isNullOrEmpty(contId)) {
            return null;
        }
        Character lab = contId.charAt(0);
        switch (lab) {
            case 'D':
            case 'd': {
                return globContractorContractService.findInfoId(NumberSupport.getBigInteger(projectId), "QC");
            }
            case 'Q':
            case 'q': {
                return globContractorContractService.findInfoId(NumberSupport.getBigInteger(projectId), "QA");
            }
        }
        return null;
    }

    private QaSample createSampleOrGet(ManageITHeader header, String projectId, SoilTestDef def) {
        QaSample sample = qaSampleService.findBySampleNo(def.getSampleNumber(), NumberSupport.getBigInteger(projectId));
        if (sample != null) {
            return sample;
        }
        sample = new QaSample();
        sample.setSampleNo(def.getSampleNumber());
        sample.setCollectionDate(def.getSampleDate());
        sample.setProjectId(NumberSupport.getBigInteger(projectId));
        //Info_id
        BigDecimal infoId = getSampleInfoIdFromDef(def.getProjectNo(), projectId);
        if (infoId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Lab/Function not Found.");
        }
        sample.setInfoId(infoId.toBigInteger());
        // SpecItem/Material/Class
         String specItem = "203";
        if (StringSupport.isNotNullAndNotEmpty(def.getSpecItem())) {
            specItem = def.getSpecItem();
        }
        List<GlobSpecItemMat> specItemMatList = globSpecItemMatService.getSpecItemMatByItemNo(NumberSupport.getBigInteger(projectId), "soil", specItem);
        if(specItemMatList != null && !specItemMatList.isEmpty()) {
            GlobSpecItemMat specItemMat = specItemMatList.get(0);
            sample.setItemId(specItemMat.getItemId());
            sample.setMatId(specItemMat.getMatId());
            sample.setClassId(specItemMat.getClassId());
        }
        // Supplier Name
        GlobSupplier supplierId = globSupplierService.findByImpCode(def.getSupplierId());
        if (supplierId != null) {
            sample.setSupplierId(supplierId.getId().toBigInteger());
        }
        // Set Sample Material Catg
        List<QaSampleCatg> catgList = qaSampleCatgService.list(new ManageITBodyRequest(0, 1).filter("name", "soil"));
        if (catgList != null && !catgList.isEmpty()) {
            sample.setSampleCatgId(StringSupport.getString(catgList.get(0).getId()));
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Soil Material Category Not Found.");
        }
        sample.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        sample.setCreateBy(header.getUser());
        sample.setCreateByIp(header.getModIp());
        sample.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        sample.setLastModIp(header.getModIp());
        sample.setLastModBy(header.getUser());
        sample.setActive('Y');
        sample.setVersion("0");
        // Saving Sample
        qaSampleService.save(sample);
        return sample;
    }
    
    private QasoilDensity createSoilDensityOrGet(ManageITHeader header, String projectId, QaSample sampleId, BigInteger sampleTestId, SoilTestDef def) {
        if (sampleId == null || header == null || sampleTestId == null || StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QasoilDensity soilDensity = qasoilDensityService.findBySampleTestId(sampleTestId);
        if (soilDensity != null) {
            return soilDensity;
        }
        // Creating New QasoilDensity
        soilDensity = new QasoilDensity();
        soilDensity.setSampletestId(sampleTestId);
        soilDensity.setSplitsample('N');
        soilDensity.setStdctdensity(def.getStandardCountDensity());
        soilDensity.setStdctmoisture(def.getStandardCountMoisture());
        soilDensity.setTesttype(def.getDepth());
        soilDensity.setCategory(globSpecItemMatService.getSpecItemMatNameByItemNo(NumberSupport.getBigInteger(projectId), "soil", def.getSpecItem()));
        qasoilDensityService.save(header, soilDensity);
        return soilDensity;
    }

    // **************** Import Soil Sample/Test [END] *************************
}
