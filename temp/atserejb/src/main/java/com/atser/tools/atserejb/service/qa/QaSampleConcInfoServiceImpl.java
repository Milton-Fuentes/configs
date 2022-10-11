/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleConcInfoDao;
import com.atser.tools.atserejb.dao.qa.QaSampleDao;
import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserejb.model.GlobSpecItemMat;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaSampleCatg;
import com.atser.tools.atserejb.model.QaSampleConcInfo;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.service.glob.GlobContractorContractService;
import com.atser.tools.atserejb.service.glob.GlobDataGatewayLogService;
import com.atser.tools.atserejb.service.glob.GlobSpecItemMatService;
import com.atser.tools.atserejb.service.glob.GlobSupplierService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.parser.eConcSample;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.ConcSamplePluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model.ConcSampleDef;
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
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.openxml4j.util.ZipSecureFile;

@Stateless
public class QaSampleConcInfoServiceImpl implements QaSampleConcInfoService, IBaseEJBException {

    @Inject
    private QaSampleConcInfoDao dao;

    @Inject
    private QaSampleDao sampledao;

    @Inject
    private QaSampleService qaSampleService;

    @Inject
    private GlobDataGatewayLogService globDataGatewayLogService;

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

    @Inject
    private GlobContractorContractService globContractorContractService;

    @Inject
    private GlobSupplierService globSupplierService;

    @Inject
    private QaSampleCatgService qaSampleCatgService;

    @Inject
    private GlobSpecItemMatService globSpecItemMatService;

    @Override
    public QaSampleConcInfo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleConcInfo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaSampleConcInfo elem) {
        if (elem != null) {
            return dao.save(elem).getSampleId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaSampleConcInfo elem) {
        if (elem != null) {
            QaSampleConcInfo model = findById(elem.getSampleId());
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
    public List<QaSampleConcInfo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    // **************** Import Conc Sample [BEGIN] *************************
    @Override
    public List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("projectId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GenericStatusPojo> importErrors = new ArrayList<>();
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcSamplePluginDirector director;
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.getString(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        director = new ConcSamplePluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eConcSample.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<ConcSampleDef> model = director.getModelAllSheets();
        if (model != null) {
            Integer totalImport = model.size();
            for (ConcSampleDef it : model) {
                try {
                    GenericStatusPojo response = importConcSampleSaveOrUpdate(header, StringSupport.getString(params.get("projectId")), it);
                    if (response != null) {
                        importErrors.add(response);
                        totalImport--;
                    }
                } catch (BaseException ex) {
                    importErrors.add(new GenericStatusPojo(it.getSampleNumber(), "ERROR", null, it, ex.getError()));
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

    private GenericStatusPojo importConcSampleSaveOrUpdate(ManageITHeader header, String projectId, ConcSampleDef def) {
        if (def != null) {
            QaSample sampleDb = qaSampleService.findBySampleNo(def.getSampleNumber(), NumberSupport.getBigInteger(projectId));
            if (sampleDb != null) {
                // Update
                return performQaConcSampleUpdate(header, projectId, sampleDb, def);
            } else {
                // Save
                return performQaConcSampleSave(header, projectId, def);
            }
        }
        return null;
    }

    private GenericStatusPojo performQaConcSampleSave(ManageITHeader header, String projectId, ConcSampleDef def) {
        QaSample sample = new QaSample();
        sample.setSampleNo(def.getSampleNumber());
        sample.setCollectionDate(def.getSampleDate());
        sample.setProjectId(NumberSupport.getBigInteger(projectId));
        //Info_id
        BigDecimal infoId = getSampleInfoIdFromDef(def.getProjectNo(), projectId);
        if (infoId == null) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Lab/Function not Found.");
        }
        sample.setInfoId(infoId.toBigInteger());
        // SpecItem/Material/Class
        String specItem = "501";
        if (StringSupport.isNotNullAndNotEmpty(def.getSpecItem())) {
            specItem = def.getSpecItem();
        }
        List<GlobSpecItemMat> specItemMatList = globSpecItemMatService.getSpecItemMatByItemNo(NumberSupport.getBigInteger(projectId), "concrete", specItem);
        if (specItemMatList != null && !specItemMatList.isEmpty()) {
            GlobSpecItemMat specItemMat = specItemMatList.get(0);
            sample.setItemId(specItemMat.getItemId());
            sample.setMatId(specItemMat.getMatId());
            sample.setClassId(specItemMat.getClassId());
        }
        // Mix Design
        if (StringSupport.isNullOrEmpty(def.getMixDesignNo())) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Mix Design Not Entered.");
        } else {
            QaconcMixdesigns mixdesign = qaconcMixdesignsService.findByMixdesignNo(NumberSupport.getBigInteger(projectId), def.getMixDesignNo());
            if (mixdesign == null) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Mix Design Not Found.");
            }
            sample.setMixDesignId(mixdesign.getId().toBigInteger());
        }
        // Supplier Name
        GlobSupplier supplierId = globSupplierService.findByImpCode(def.getSupplierId());
        if (supplierId != null) {
            sample.setSupplierId(supplierId.getId().toBigInteger());
        }

        // Set Sample Material Catg
        List<QaSampleCatg> catgList = qaSampleCatgService.list(new ManageITBodyRequest(0, 1).filter("name", "concrete"));
        if (catgList != null && !catgList.isEmpty()) {
            sample.setSampleCatgId(StringSupport.getString(catgList.get(0).getId()));
        } else {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Concrete Material Category Not Found.");
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
        QaSampleConcInfo concInfo = new QaSampleConcInfo(sample.getId());
        concInfo.setSlump(def.getSlump1());
        concInfo.setAirContent(def.getAirTemp());
        concInfo.setActive('Y');
        concInfo.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        concInfo.setCreateBy(header.getUser());
        concInfo.setCreateByIp(header.getModIp());
        concInfo.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        concInfo.setLastModIp(header.getModIp());
        concInfo.setLastModBy(header.getUser());
        concInfo.setVersion("0");
        // Saving ConcSample
        save(header, concInfo);
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

    private GenericStatusPojo performQaConcSampleUpdate(ManageITHeader header, String projectId, QaSample model, ConcSampleDef def) {
        //if (!isSampleDefEqualsSample(def, model)) {}
        model.setCollectionDate(def.getSampleDate());
        // Mix Design
        try {
            QaconcMixdesigns mixdesign = qaconcMixdesignsService.findByMixdesignNo(NumberSupport.getBigInteger(projectId), def.getMixDesignNo());
            if (mixdesign == null) {
                return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Mix Design Not Found.");
            }
            model.setMixDesignId(mixdesign.getId().toBigInteger());
        } catch (BaseException ex) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Mix Design Not Found.");
        }

        // Supplier Name
        GlobSupplier supplierId = globSupplierService.findByImpCode(def.getSupplierId());
        if (supplierId != null) {
            model.setSupplierId(supplierId.getId().toBigInteger());
        }
        model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        model.setLastModIp(header.getModIp());
        model.setLastModBy(header.getUser());
        // update sample
        sampledao.update(model);
        // update Concrete Sample
        QaSampleConcInfo concInfo = findById(model.getId());
        if (concInfo == null) {
            return new GenericStatusPojo(def.getSampleNumber(), "ERROR", null, def, "Concrete Sample Information Not Found.");
        }
        concInfo.setSlump(def.getSlump1());
        concInfo.setAirContent(def.getAirTemp());
        concInfo.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        concInfo.setLastModIp(header.getModIp());
        concInfo.setLastModBy(header.getUser());
        dao.update(concInfo);
        return null;
    }

    private Boolean isSampleDefEqualsSample(ConcSampleDef def, QaSample elem) {
        if (!Objects.equals(def.getSampleDate(), elem.getCollectionDate())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    // **************** Import Conc Sample [END] *************************
}
