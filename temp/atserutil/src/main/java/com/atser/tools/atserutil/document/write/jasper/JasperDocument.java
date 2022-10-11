/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.jasper;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author droldan
 */
public interface JasperDocument {

    String exportDocument(String tplPath, Map<String, Object> params, String targetPath, String type) throws JRException, Exception;
    
    String exportDocument(String tplPath, Map<String, Object> params, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception;

    String exportDocument(String tplPath, Map<String, Object> params, List<?> ds, String targetPath, String type) throws JRException, Exception;
    
    String exportDocument(String tplPath, Map<String, Object> params, List<?> ds, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception;
    
    String exportDocument(JasperDesign design, Map<String, Object> params, String targetPath, String type) throws JRException, Exception;
    
    String exportDocument(JasperDesign design, Map<String, Object> params, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception;

    String exportDocument(JasperDesign design, Map<String, Object> params, List<?> ds, String targetPath, String type) throws JRException, Exception;
    
    String exportDocument(JasperDesign design, Map<String, Object> params, List<?> ds, String targetPath, String type, Boolean excelOnePage) throws JRException, Exception;

    String createWaterMarkToPdf(String targetPath, String watermark);
    
    void exportDesignToJasperFile(JasperDesign design, String targetPath) throws JRException, FileNotFoundException;

}
