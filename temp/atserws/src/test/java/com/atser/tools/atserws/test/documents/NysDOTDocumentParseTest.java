/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test.documents;

import com.atser.tools.atserutil.enumerator.parser.eAspmMixDesign;
import com.atser.tools.atserutil.enumerator.parser.eConcMixDesign;
import com.atser.tools.atserutil.enumerator.parser.eConcSample;
import com.atser.tools.atserutil.enumerator.parser.eT22Test;
import com.atser.tools.atserutil.enumerator.parser.eT310Test;
import com.atser.tools.atserutil.enumerator.parser.eTemplateSupplier;
import com.atser.tools.atserutil.enumerator.parser.eTestPlanInsp;
import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.GlobUserPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.AspmMixDesignPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.ConcMixDesignPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.ConcSamplePluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model.ConcSampleDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.T22TestPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model.T22TestDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.T310TestPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model.SoilTestDef;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.SupplierPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.TestPlanInspPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model.TestPlanInspDef;
import com.atser.tools.atserws.test.WSTestMain;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/**
 *
 * @author droldan
 */
public class NysDOTDocumentParseTest {

    public static void excelPluginTestSupplier(String pPath, eTemplateSupplier tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        SupplierPluginDirector director;
        try {
            director = new SupplierPluginDirector(new File(pPath), tpl);
            List<SupplierDef> model = director.getModel();
            model.forEach(it -> {
                System.out.printf("Supplier Code: %s\n", it.getImpCode());
                System.out.printf("Supplier Name: %s\n", it.getSupplier());
                System.out.printf("Supplier Loc: %s\n", it.getLocation());
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginTestConcrete(String pPath, eConcMixDesign tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcMixDesignPluginDirector director;
        try {
            director = new ConcMixDesignPluginDirector(new File(pPath), tpl);
            List<ConcMixDesignDef> model = director.getModelAllSheets();
            model.forEach(it -> {
                System.out.printf("Mix Design ID: %s\n", it.getMixdesignNo());
                System.out.printf("Producer ID: %s\n", it.getProducedBy());
                System.out.printf("Mix Type: %s\n", it.getMixdesignType());
                System.out.printf("Expiration Date: %s\n", it.getExpirationDate());
                System.out.printf("Spec. Min f'c Compressive Str: %s\n", it.getSpecLimitCompstrMin());
                System.out.printf("Design Compressive Str: %s\n", it.getDesignCompstr());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginConcreteSample(String pPath, eConcSample tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcSamplePluginDirector director;
        try {
            director = new ConcSamplePluginDirector(new File(pPath), tpl);
            List<ConcSampleDef> model = director.getModelAllSheets();
            model.forEach(it -> {
                System.out.printf("Project No: %s\n", it.getProjectNo());
                System.out.printf("Spec Item: %s\n", it.getSpecItem());
                System.out.printf("Sample No: %s\n", it.getSampleNumber());
                System.out.printf("Sample Date: %s\n", it.getSampleDate());
                System.out.printf("MixDesign No: %s\n", it.getMixDesignNo());
                System.out.printf("Logged Date: %s\n", it.getLoggedDate());
                System.out.printf("Approved Date: %s\n", it.getApprovedDate());
                System.out.printf("Supplier ID: %s\n", it.getSupplierId());
                System.out.printf("Approved By: %s\n", it.getApprovedBy());
                System.out.printf("Material: %s\n", it.getMaterial());
                System.out.printf("Air Temp: %s\n", it.getAirTemp());
                System.out.printf("Slump: %s\n", it.getSlump1());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginT22Test(String pPath, eT22Test tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        T22TestPluginDirector director;
        try {
            director = new T22TestPluginDirector(new File(pPath), tpl);
            List<T22TestDef> model = director.getModelAllSheets();
            model.forEach(it -> {
                System.out.printf("Project No: %s\n", it.getProjectNo());
                System.out.printf("Sample No: %s\n", it.getSampleNumber());
                System.out.printf("Serial No: %s\n", it.getSerialNo());
                System.out.printf("Test Date: %s\n", it.getTestDate());
                System.out.printf("Age: %s\n", it.getTestAge());
                System.out.printf("Age Type: %s\n", it.getTestAgeType());
                System.out.printf("Average: %s\n", it.getAverage());
                System.out.printf("Min Spec: %s\n", it.getSpecMin());
                System.out.printf("Pass/Fail: %s\n", it.getPassfail());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginT310Test(String pPath, eT310Test tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        T310TestPluginDirector director;
        try {
            director = new T310TestPluginDirector(new File(pPath), tpl);
            List<SoilTestDef> model = director.getModelAllSheets();
            model.forEach(it -> {
                System.out.printf("SampleID: %s\n", it.getSampleNumber());
                System.out.printf("SampleDate: %s\n", it.getSampleDate());
                System.out.printf("Supplier Code: %s\n", it.getSupplierId());
                System.out.printf("ContractId: %s\n", it.getProjectNo());
                System.out.printf("Item: %s\n", it.getSpecItem());
                System.out.printf("Material Code: %s\n", it.getMaterial());
                System.out.printf("Test No: %s\n", it.getTestNo());
                System.out.printf("CompationMethod: %s\n", it.getCompactionMethod());
                System.out.printf("Standard Counts (Density): %s\n", it.getStandardCountDensity());
                System.out.printf("Standard Counts (Moisture): %s\n", it.getStandardCountMoisture());
                System.out.printf("Depth: %s\n", it.getDepth());
                System.out.printf("Moisture Content: %s\n", it.getMoistureContent());
                System.out.printf("Wet Density: %s\n", it.getWetDensity());
                System.out.printf("Dry Density: %s\n", it.getDryDensity());
                System.out.printf("Maximum Dry Density: %s\n", it.getMaxDryDensity());
                System.out.printf("Optimum Dry Density: %s\n", it.getOptimunMoistureContent());
                System.out.printf("Compaction: %s\n", it.getPctCompaction());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginAtserConcMixDesign(String pPath, eConcMixDesign tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcMixDesignPluginDirector director;
        try {
            director = new ConcMixDesignPluginDirector(new File(pPath), tpl);
            List<ConcMixDesignDef> model = director.getModel();
            model.forEach(it -> {
                System.out.printf("Mix Design No: %s\n", it.getMixdesignNo());
                System.out.printf("Produced By: %s\n", it.getProducedBy());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginImportUsers(String pPath, eUserInformation tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        GlobUserPluginDirector director;
        try {
            director = new GlobUserPluginDirector(new File(pPath), tpl);
            List<UserInformationDef> model = director.getUserInformationModel();
            System.out.printf("Total Read: %s\n", model.size());
            model.forEach(it -> {
                System.out.printf("UserID: %s\n", it.getUserId());
                System.out.printf("Module: %s\n", it.getModule());
                System.out.printf("Role: %s\n", it.getRole());
                System.out.printf("First Name: %s\n", it.getFirstName());
                System.out.printf("Middle Initial: %s\n", it.getMiddleInitial());
                System.out.printf("Last Name: %s\n", it.getLastName());
                System.out.printf("Email: %s\n", it.getEmail());
                System.out.printf("HR Title: %s\n", it.getHrTitle());
                System.out.printf("Address: %s\n", it.getAddress());
                System.out.printf("City: %s\n", it.getCity());
                System.out.printf("State: %s\n", it.getState());
                System.out.printf("Work Phone: %s\n", it.getWorkPhone());
                System.out.printf("Cell Phone: %s\n", it.getCellPhone());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginTestPlanInsp(String pPath, eTestPlanInsp tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        TestPlanInspPluginDirector director;
        try {
            director = new TestPlanInspPluginDirector(new File(pPath), tpl);
            List<TestPlanInspDef> model = director.getModelAllSheets();
            System.out.printf("Total Read: %s\n", model.size());
            model.forEach(it -> {
                System.out.printf("Line Item: %s\n", it.getLineItem());
                System.out.printf("Item Code: %s\n", it.getItemNo());
                System.out.printf("Unit: %s\n", it.getUnit());
                System.out.printf("Qty To Date: %s\n", it.getActualQty());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excelPluginAtserAspmMixDesign(String pPath, eAspmMixDesign tpl) {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        AspmMixDesignPluginDirector director;
        try {
            director = new AspmMixDesignPluginDirector(new File(pPath), tpl);
            List<AspmMixDesignDef> model = director.getModel();
            model.forEach(it -> {
                System.out.printf("Mix Design No: %s\n", it.getMixdesignNo());
                System.out.printf("Produced By: %s\n", it.getSupplier());
                System.out.println("************************************");
            });
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException | TemplateDifferentException | ExcelParsingException | IOException | EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        //excelPluginTestSupplier("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Concrete Suppliers_1.xlsx", eTemplateSupplier.NysDOTSupplierTpl);
        //excelPluginTestConcrete("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\Concrete Mix Designs.xlsx", eConcMixDesign.NysDOTImportConcMixDesignTpl);
        //excelPluginConcreteSample("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\SlumpAir_900043_02272020.xlsx", eConcSample.NysDOTConcSampleTpl);
        //excelPluginConcreteSample("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\TestDocuments\\SlumpAir_900043_10132020_short.xlsx", eConcSample.NysDOTConcSampleTpl);
        excelPluginConcreteSample("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\TestDocuments\\SlumpAir_900043_10132020.xlsx", eConcSample.NysDOTConcSampleTpl);
        //excelPluginT310Test("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\Soil Density_FixExcelVersion.xlsx", eT310Test.NysDOTT310Tpl);
        // Concrete Test (T22)
        //excelPluginT22Test("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\Final_Output_Format_for_28_Day_Cylinder_Breaks_to_ATSER_MIXID_C021219031.xlsx", eT22Test.NysDOTT22Tpl);
        //excelPluginT22Test("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Final_Output_Format_for_28_Day_Cylinder_Breaks_to_ATSER_MIXID_C021219031.xlsx", eT22Test.NysDOTT22Tpl);
        //excelPluginT22Test("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\TestingFiles\\Cylinder_900043_05052020_Organized.xlsx", eT22Test.NysDOTT22Tpl);
        //excelPluginT22Test("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\ASqryAtserCyls20200528.xlsx", eT22Test.NysDOTT22Tpl);
        // Import Atser Conc Mix Design
        //excelPluginAtserConcMixDesign("C:\\Users\\droldan\\Documents\\MassDOT\\test.xlsx", eConcMixDesign.AtserConcMixDesignTpl);
        // Import MassDOT Aspm Mix Design
        //excelPluginAtserAspmMixDesign("C:\\Users\\droldan\\Downloads\\AspmMixDesignTemplate_062220201338.xlsx", eAspmMixDesign.AtserAspmMixDesignTpl);
        // Import Users
        //excelPluginImportUsers("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\rone_users_import_list.xlsx", eUserInformation.AtserUserInformationTpl);
        // Test Plan Insp Plugin
        //excelPluginTestPlanInsp("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\D900047_ConR22_TP_1.xlsx", eTestPlanInsp.NysDOTTestPlanInsp);
        //excelPluginTestPlanInsp("C:\\Users\\droldan\\Documents\\07.2 NYSDOT_Requests\\Documents\\Import\\D900047_ConR22_TP_2.xlsx", eTestPlanInsp.NysDOTTestPlanInsp);        

    }
}
