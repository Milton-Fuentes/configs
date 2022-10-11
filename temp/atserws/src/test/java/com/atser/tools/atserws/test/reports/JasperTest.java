/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test.reports;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport.ScbAllReportPojo;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;

/**
 *
 * @author droldan
 */
public class JasperTest {

    /* private JRDesignStaticText buildJRDesignStaticText() {
        JRDesignStaticText statictext = 
    }*/
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        List<ReportGridColumnsTO> columns = new ArrayList<>();
        columns.add(new ReportGridColumnsTO("testNo", "TCN", "center", 125));
        columns.add(new ReportGridColumnsTO("dateOfTest", "Test Date Mass date for testing in this example", "left", 125));
        columns.add(new ReportGridColumnsTO("testName", "Test Name", "left", 275));
        columns.add(new ReportGridColumnsTO("testReportNo", "Lab Report No.", "center", 175));
        columns.add(new ReportGridColumnsTO("labname", "Lab Name", "left", 125));
        columns.add(new ReportGridColumnsTO("testingTech", "Technician", "left", 275));
        columns.add(new ReportGridColumnsTO("cmLocation", "Location", "left", 125));
        columns.add(new ReportGridColumnsTO("traceNo", "Traceability", "left", 150));
        columns.add(new ReportGridColumnsTO("peReview", "PE", "center", 75));
        columns.add(new ReportGridColumnsTO("testClosed", "Closed", "center", 100));
        columns.add(new ReportGridColumnsTO("passfail", "Pass/Fail", "center", 125));
        columns.add(new ReportGridColumnsTO("status", "Status", "center", 100));

        List<ScbAllReportPojo> ds = new ArrayList<>();
        ScbAllReportPojo response = new ScbAllReportPojo();
        response.setTestNo("69");
        response.setDateOfTest("09/19/2019");
        response.setTestName("Stressing Report");
        response.setTestReportNo("");
        response.setLabname("Atser, L.P.");
        response.setTestingTech("Lead Inspector (Lead Inspector)");
        response.setCmLocation("BR2017");
        response.setTraceNo("01-APP-100");
        response.setPeReview('N');
        response.setTestClosed('N');
        response.setPassfail("Pass");
        response.setStatus("Pending");
        response.setProjectNo("");
        response.setpName("");
        response.setTestId("");
        ds.add(response);
        // Build Report
        eDocExtension extension = eDocExtension.excel;
        String targetPath = "PrintExample_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        String targetPathJasper = "PrintExample_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + ".jasper";
        BuildJasper pdf = new BuildJasper();

        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple("hctra_text", OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "All Tests", ScbAllReportPojo.class, columns);
            pdf.exportDesignToJasperFile(tpl, targetPathJasper);
            targetPath = pdf.exportDocument(tpl, params, ds, targetPath, "excel", Boolean.FALSE);
            System.out.println("Document Path: " + targetPath);

        } catch (Exception ex) {
            Logger.getLogger(JasperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
