/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test.documents;

import com.atser.tools.atserutil.document.write.csv.BuildCsv;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixdesignsTO;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author droldan
 */
public class GenerateCsvTest {

    public static void writeCsv() throws IOException {
        QaconcMixdesignsTO obj = new QaconcMixdesignsTO();
        obj.setMixdesignNo("I-239292");
        obj.setSupplier("John Smith");
        obj.setSupplierLoc("Houston");
        Writer writer = Files.newBufferedWriter(Paths.get("student.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("MixdesignNo", "Supplier", "SupplierLoc"));
        csvPrinter.printRecord(obj);
        csvPrinter.flush();
    }

    public static void writeJacksonCsv() throws JsonProcessingException, IOException {
        List<QaconcMixdesignsTO> objList = new ArrayList<>();
        QaconcMixdesignsTO ob1 = new QaconcMixdesignsTO();
        QaconcMixdesignsTO ob2 = new QaconcMixdesignsTO();
        ob1.setMixdesignNo("I-239292");
        ob1.setSupplier("John Smith");
        ob1.setSupplierLoc("Houston");
        ob1.setAdmixtureQty1(null);
        ob2.setMixdesignNo("J-39292");
        ob2.setSupplier("Dipath Kair");
        ob2.setSupplierLoc("Austin");
        ob2.setDesignAirContent(null);
        objList.add(ob1);
        objList.add(ob2);
        Writer writer = Files.newBufferedWriter(Paths.get("jacksonstudent.csv"));
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(QaconcMixdesignsTO.class);
        mapper.writer(schema.withUseHeader(true)).writeValue(writer, objList);
    }

    public static void writeJacksonCsv2() throws JsonProcessingException, IOException {
        List<QaconcMixdesignsTO> objList = new ArrayList<>();
        QaconcMixdesignsTO to = new QaconcMixdesignsTO();
        to.setMixdesignNo("19-01-29-11-49-47-7");
        to.setSupplier("CAPE COD");
        to.setSupplierLoc("Main Location");
        to.setMixdesignType("HP");
        to.setMixdesignDescription(null);
        to.setMixdesignRemark(null);
        to.setMaxAggSizeId("3/8");
        to.setDesignCompstr("4000.96");
        to.setDesignCompstrAge("28");
        to.setDesignCompstrAgeUnit(null);
        to.setDesignSlump("4");
        to.setDesignSlumpFlowScc(null);
        to.setDesignAirContent("6.5");
        to.setTotalCoarseAgg("1750");
        to.setCoarseAgg1(null);
        to.setCoarseAgg2(null);
        to.setTotalFineAgg("1270");
        to.setFineAgg1(null);
        to.setFineAgg2(null);
        to.setCement("433");
        to.setFlyAsh("117");
        to.setSlag("35");
        to.setSilicaFume("0");
        to.setTotalCementMat("585");
        to.setWater("25.5");
        to.setAdmixtureQty1("1.5");
        to.setAdmixtureType1(null);
        to.setAdmixtureQty2("29.3");
        to.setAdmixtureType2(null);
        to.setAdmixtureQty3("384");
        to.setAdmixtureType3(null);
        to.setAdmixtureQty4("0");
        to.setAdmixtureType4(null);
        to.setAdmixtureQty5("0");
        to.setAdmixtureType5(null);
        to.setAdmixtureQty6("0");
        to.setAdmixtureType6(null);
        to.setAdmixtureQty7("0");
        to.setAdmixtureType7(null);
        to.setAdmixtureQty8("0");
        to.setAdmixtureType8(null);
        to.setWaterCementRatio("0.36");
        to.setWaterCementMax(null);
        to.setTheoreticalAirContent("5.8");
        to.setVolumenPaste("26.2");
        to.setSpecLimitSlumpMin("2");
        to.setSpecLimitSlumpMax("6");
        to.setEngLimitSlumpMin("2");
        to.setEngLimitSlumpMax("6");
        to.setSpecLimitAirContentMin("5");
        to.setSpecLimitAirContentMax("8");
        to.setEngLimitAirContentMin("5");
        to.setEngLimitAirContentMax("8");
        to.setSpecLimitCompstrMin(null);
        to.setSpecLimitCompstrMax("");
        to.setEngLimitCompstrMin("6");
        to.setEngLimitCompstrMax(null);
        to.setSpecLimitSlumpFlowsccMin("");
        to.setSpecLimitSlumpFlowsccMax("4.56");
        to.setEngLimitSlumpFlowsccMin(null);
        to.setEngLimitSlumpFlowsccMax("");
        to.setTrialOverdesignCompstrMin(null);
        to.setTrialOverdesignCompstrMax(null);
        to.setDesignTensileStr("");
        to.setDesignTensileStrAge("");
        to.setDesignTensileStrAgeUnit(null);
        to.setDesignFlexStr("78.53");
        to.setDesignFlexStrAge("28");
        to.setDesignFlexStrAgeUnit("34.6");
        to.setSpecLimitTensileStrMin(null);
        to.setSpecLimitTensileStrMax(null);
        to.setEngLimitTensileStrMin(null);
        to.setEngLimitTensileStrMax("");
        to.setSpecLimitFlexStrMin("32.6");
        to.setSpecLimitFlexStrMax("");
        to.setEngLimitFlexStrMin("");
        to.setEngLimitFlexStrMax(null);
        to.setConcreteClass("C");
        to.setSpecSlumpSuspension(null);
        to.setSpecSlumpAction(null);
        to.setSpecAircontentSuspension(null);
        to.setSpecAircontentAction(null);
        to.setReqtk(null);
        to.setSpecFlexSuspension(null);
        to.setSpecFlexAction(null);
        to.setSpecTkSuspension(null);
        to.setSpecTkAction(null);
        to.setSpecConcTempMin(null);
        to.setSpecConcTempMax(null);
        to.setSpecResidualStr1(null);
        to.setSpecResidualStr2(null);
        to.setSpecResidualStr3(null);
        to.setSpecResidualStrPeak(null);
        to.setBoiledabsorption(null);
        to.setExpirationDate("2019-11-13 00:00:00.0");
        to.setMixStatus("PENDING");
        objList.add(to);
        BuildCsv doc = new BuildCsv("C:/atser/filesys/dcs/temporal/example_081220200835.csv", QaconcMixdesignsTO.class);
        doc.writeCsv(objList);
    }

    public static void main(String[] args) {
        /*try {
            writeCsv();
            } catch (IOException ex) {
            Logger.getLogger(GenerateCsvTest.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 /*try {
            writeJacksonCsv2();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(GenerateCsvTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateCsvTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        List<String> line = new ArrayList<>();
        line.add("D1,Maria,Shoes,Air,3");
        line.add("D2,Rolando,Shoes,Nike,2");
        line.add("D3,Dayron,Shirt,Lop,1");
        line.add("D4,Mairim,Shoes,Air,2");
        line.add("D5,Daynel,Pants,Qeur,1");
        List<String[]> ds = line.stream().map(m -> m.split(",")).collect(Collectors.toList());
        System.out.println(ds.stream().mapToDouble(m -> Double.valueOf(m[4])).sum());
        ds.stream().collect(Collectors.groupingBy(p -> p[2], Collectors.summarizingDouble(s -> Double.valueOf(s[4])))).forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.getAverage());
            System.out.println(v.getCount());
            System.out.println(v.getMax());
            System.out.println(v.getMin());
            System.out.println(v.getSum());
        });
//----------------------- Write File--------------------------------------------
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("pepe", true));
            writer.append("value");
            writer.append("value");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GenerateCsvTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
