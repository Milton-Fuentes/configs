/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.jasper;

import com.atser.tools.atserutil.file.FileSupport;
import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleCsvReportConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 *
 * @author droldan
 */
public class BuildJasper implements JasperDocument {

    /**
     *
     * @param tplPath
     * @param params
     * @param targetPath
     * @param type
     * @param excelOnePage
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(String tplPath, Map<String, Object> params, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception {
        try {
            File initialFile = new File(tplPath);
            if (targetPath != null && !targetPath.isEmpty()) {
                File docUrl = new File(FileSupport.getFolderPathFromFileNoEndSeparator(targetPath));
                if (!docUrl.exists()) {
                    docUrl.mkdirs();
                }
                InputStream strIn = new FileInputStream(initialFile);
                JasperReport jReport = (JasperReport) JRLoader.loadObject(strIn);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, params, new JREmptyDataSource());
                documentProxy(jPrint, type, targetPath, excelOnePage);
            }

        } catch (JRException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return targetPath;
    }

    /**
     *
     * @param tplPath
     * @param params
     * @param targetPath
     * @param type
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(String tplPath, Map<String, Object> params, String targetPath, String type) throws JRException, Exception {
        return exportDocument(tplPath, params, targetPath, type, Boolean.TRUE);
    }

    /**
     *
     * @param tplPath
     * @param params
     * @param ds
     * @param targetPath
     * @param type
     * @param excelOnePage
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(String tplPath, Map<String, Object> params, List<?> ds, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception {
        try {
            File initialFile = new File(tplPath);
            if (targetPath != null && !targetPath.isEmpty()) {
                File docUrl = new File(FileSupport.getFolderPathFromFileNoEndSeparator(targetPath));
                if (!docUrl.exists()) {
                    docUrl.mkdirs();
                }
                InputStream strIn = new FileInputStream(initialFile);
                JasperReport jReport = (JasperReport) JRLoader.loadObject(strIn);
                JRBeanCollectionDataSource jds = new JRBeanCollectionDataSource(ds);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, params, jds);
                documentProxy(jPrint, type, targetPath, excelOnePage);
            }

        } catch (JRException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return targetPath;
    }

    /**
     *
     * @param tplPath
     * @param params
     * @param ds
     * @param targetPath
     * @param type
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(String tplPath, Map<String, Object> params, List<?> ds, String targetPath, String type) throws JRException, Exception {
        return exportDocument(tplPath, params, ds, targetPath, type, Boolean.TRUE);
    }

    /**
     *
     * @param design
     * @param params
     * @param targetPath
     * @param type
     * @param excelOnePage
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(JasperDesign design, Map<String, Object> params, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception {
        try {
            if (targetPath != null && !targetPath.isEmpty()) {
                File docUrl = new File(FileSupport.getFolderPathFromFileNoEndSeparator(targetPath));
                if (!docUrl.exists()) {
                    docUrl.mkdirs();
                }
                JasperReport jReport = JasperCompileManager.compileReport(design);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, params, new JREmptyDataSource());
                documentProxy(jPrint, type, targetPath, excelOnePage);
            }

        } catch (JRException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return targetPath;
    }

    /**
     *
     * @param design
     * @param params
     * @param targetPath
     * @param type
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(JasperDesign design, Map<String, Object> params, String targetPath, String type) throws JRException, Exception {
        return exportDocument(design, params, targetPath, type, Boolean.TRUE);
    }

    /**
     *
     * @param design
     * @param targetPath
     * @throws JRException
     * @throws FileNotFoundException
     */
    @Override
    public void exportDesignToJasperFile(JasperDesign design, String targetPath) throws JRException, FileNotFoundException {
        try {
            if (targetPath != null && !targetPath.isEmpty()) {
                JasperCompileManager.compileReportToFile(design, targetPath);
            }
        } catch (JRException ex) {
            throw ex;
        }
    }

    /**
     *
     * @param design
     * @param params
     * @param ds
     * @param targetPath
     * @param type
     * @param excelOnePage
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(JasperDesign design, Map<String, Object> params, List<?> ds, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception {
        try {
            if (targetPath != null && !targetPath.isEmpty()) {
                File docUrl = new File(FileSupport.getFolderPathFromFileNoEndSeparator(targetPath));
                if (!docUrl.exists()) {
                    docUrl.mkdirs();
                }
                JasperReport jReport = JasperCompileManager.compileReport(design);
                JRBeanCollectionDataSource jds = new JRBeanCollectionDataSource(ds);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, params, jds);
                documentProxy(jPrint, type, targetPath, excelOnePage);
            }

        } catch (JRException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return targetPath;
    }

    /**
     *
     * @param design
     * @param params
     * @param ds
     * @param targetPath
     * @param type
     * @return
     * @throws JRException
     * @throws Exception
     */
    @Override
    public String exportDocument(JasperDesign design, Map<String, Object> params, List<?> ds, String targetPath, String type) throws JRException, Exception {
        return exportDocument(design, params, ds, targetPath, type, Boolean.TRUE);
    }

    /**
     *
     * @param jPrint
     * @param targetPath
     * @throws JRException
     * @throws Exception
     */
    private void buildFromJasperTpl(JasperPrint jPrint, String targetPath) throws JRException, Exception {
        JasperExportManager.exportReportToPdfFile(jPrint, targetPath);
    }

    /**
     *
     * @param jPrint
     * @param type
     * @param targetPath
     * @param excelOnePage
     * @throws JRException
     * @throws Exception
     */
    private void documentProxy(JasperPrint jPrint, String type, String targetPath, Boolean excelOnePage) throws JRException, Exception {
        switch (type) {
            case "pdf":
                buildFromJasperTpl(jPrint, targetPath);
                break;
            case "xlsx":
                buildXLSFromJasperTpl(jPrint, targetPath, excelOnePage);
                break;
            case "csv":
                buildCsvFromJasperTpl(jPrint, targetPath);
                break;
            case "doc":
                buildDocFromJasperTpl(jPrint, targetPath);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param jPrint
     * @param targetPath
     * @param excelOnePage
     * @throws JRException
     * @throws Exception
     */
    private void buildXLSFromJasperTpl(JasperPrint jPrint, String targetPath, Boolean excelOnePage) throws JRException, Exception {
        JRXlsxExporter exporter = new JRXlsxExporter();
        // JRPrint List
        List<JasperPrint> jasperPrintList = new ArrayList<>();
        jasperPrintList.add(jPrint);
        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(targetPath));

        // Configuration
        SimpleXlsxReportConfiguration exporterConfig = new SimpleXlsxReportConfiguration();
        exporterConfig.setOnePagePerSheet(excelOnePage);
        exporterConfig.setRemoveEmptySpaceBetweenColumns(Boolean.TRUE);
        exporterConfig.setRemoveEmptySpaceBetweenRows(Boolean.TRUE);
        exporterConfig.setWhitePageBackground(Boolean.FALSE);
        exporter.setConfiguration(exporterConfig);
        exporter.exportReport();
    }
    
    private void buildCsvFromJasperTpl(JasperPrint jPrint, String targetPath) throws JRException, Exception {
        JRCsvExporter exporter = new JRCsvExporter();
        // JRPrint List
        List<JasperPrint> jasperPrintList = new ArrayList<>();
        jasperPrintList.add(jPrint);
        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(targetPath));
        
        // Configuration
        SimpleCsvReportConfiguration exporterConfig = new SimpleCsvReportConfiguration();
        exporter.setConfiguration(exporterConfig);
        exporter.exportReport();
    }

    /**
     *
     * @param jPrint
     * @param targetPath
     * @throws JRException
     * @throws Exception
     */
    private void buildDocFromJasperTpl(JasperPrint jPrint, String targetPath) throws JRException, Exception {
        JRDocxExporter exporter = new JRDocxExporter();
        // JRPrint List
        List<JasperPrint> jasperPrintList = new ArrayList<>();
        jasperPrintList.add(jPrint);
        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(targetPath));
        // Configuration
        SimpleDocxReportConfiguration exporterConfig = new SimpleDocxReportConfiguration();
        exporter.setConfiguration(exporterConfig);
        exporter.exportReport();
    }

    /**
     *
     * @param targetPath
     * @param watermark
     * @return
     */
    @Override
    public String createWaterMarkToPdf(String targetPath, String watermark) {
        try {
            PdfReader reader = new PdfReader(targetPath);
            String output = targetPath.replaceAll(".pdf", "_marked.pdf");
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(output));

            int count = reader.getNumberOfPages();

            for (int i = 1; i <= count; i++) {
                PdfContentByte ctb = stamp.getOverContent(i);
                // Fonts
                BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                // Open Flush
                ctb.beginText();
                ctb.setFontAndSize(bf, 65);

                // Text Rotation
                AffineTransform at = new AffineTransform();
                at.rotate(Math.toRadians(40), -410, 395);
                ctb.setTextMatrix(at);
                // Text Color
                ctb.setRGBColorFill(192, 80, 77);
                // Text to Write
                ctb.showText(watermark);

                // Close Flush
                ctb.endText();
            }

            stamp.close();

            return output;

        } catch (DocumentException | IOException ex) {
            return null;
        }
    }
}
