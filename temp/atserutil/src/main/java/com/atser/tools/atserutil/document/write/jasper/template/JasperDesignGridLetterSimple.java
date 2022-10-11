/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.jasper.template;

import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.jasper.eJasperBandType;
import com.atser.tools.atserutil.enumerator.jasper.eJasperTextFont;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.ExpressionTypeEnum;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.PositionTypeEnum;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.type.StretchTypeEnum;
import net.sf.jasperreports.engine.type.TextAdjustEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

/**
 * Template With Title and SubTitle. Simple Column Header and Simple Details
 * with Footer
 *
 * @author droldan
 */
public class JasperDesignGridLetterSimple extends JasperDesignGridTemplate {

    private final Boolean enableCleanExcel;
    private final TextAdjustEnum excelTextAdjust;

    public JasperDesignGridLetterSimple(String documentName, OrientationEnum documentOrientation, int width, int height, int columnWidth, int margin, eDocExtension extension) throws JRException {
        super(documentName, documentOrientation, width, height, columnWidth, margin, extension);
        enableCleanExcel = Boolean.FALSE;
        excelTextAdjust = TextAdjustEnum.CUT_TEXT;
    }

    public JasperDesignGridLetterSimple(String documentName, OrientationEnum documentOrientation, int width, int height, int columnWidth, int margin, eDocExtension extension, Boolean cleanExcel) throws JRException {
        super(documentName, documentOrientation, width, height, columnWidth, margin, extension);
        this.enableCleanExcel = cleanExcel;
        excelTextAdjust = TextAdjustEnum.CUT_TEXT;
    }
    
    public JasperDesignGridLetterSimple(String documentName, OrientationEnum documentOrientation, int width, int height, int columnWidth, int margin, eDocExtension extension, Boolean cleanExcel, TextAdjustEnum excelTextAdjust) throws JRException {
        super(documentName, documentOrientation, width, height, columnWidth, margin, extension);
        this.enableCleanExcel = cleanExcel;
        this.excelTextAdjust = excelTextAdjust;
    }

    public JasperDesign buildTemplate(String title, String subtitle, Class fields, String clientName) throws Exception {
        List<ReportGridColumnsTO> columnsdef = document.generateReportColumns(fields, clientName);
        if (columnsdef == null || columnsdef.isEmpty()) {
            throw new Exception("Report Columns Definition is Empty or Null");
        }
        if (enableCleanExcel && (document.getExtension() == eDocExtension.excel || document.getExtension() == eDocExtension.csv)) {
            initExcelBands();
            initVariables();
            initFields(fields);
            //initExcelTitle(title, subtitle);
            addExcelTitleFields(columnsdef);
            addExcelDetailsField(columnsdef);
        } else {
            initBands();
            initVariables();
            initFields(fields);
            initTitle(title, subtitle);
            addColumnHeaderFields(columnsdef);
            addDetailsField(columnsdef);
            initFooter();
        }
        return document.getJasperDesign();
    }

    public JasperDesign buildTemplate(String title, String subtitle, Class fields, List<ReportGridColumnsTO> columnsdef) throws Exception {
        if (columnsdef == null || columnsdef.isEmpty()) {
            throw new Exception("Report Columns Definition is Empty or Null");
        }
        if (enableCleanExcel && (document.getExtension() == eDocExtension.excel || document.getExtension() == eDocExtension.csv)) {
            initExcelBands();
            initVariables();
            initFields(fields);
            //initExcelTitle(title, subtitle);
            addExcelTitleFields(columnsdef);
            addExcelDetailsField(columnsdef);
        } else {
            initBands();
            initVariables();
            initFields(fields);
            initTitle(title, subtitle);
            addColumnHeaderFields(columnsdef);
            addDetailsField(columnsdef);
            initFooter();
        }
        return document.getJasperDesign();
    }

    /**
     * Set Defaults Band for this Template
     */
    @Override
    protected void initBands() {
        if (document != null) {
            document.addBand(eJasperBandType.background, document.getJRDesignBand(SplitTypeEnum.STRETCH))
                    .addBand(eJasperBandType.title, document.getJRDesignBand(SplitTypeEnum.STRETCH, 59))
                    .addBand(eJasperBandType.columnHeader, document.getJRDesignBand(SplitTypeEnum.STRETCH, 29))
                    .addBand(eJasperBandType.detail, document.getJRDesignBand(SplitTypeEnum.STRETCH, 14))
                    .addBand(eJasperBandType.pageFooter, document.getJRDesignBand(SplitTypeEnum.STRETCH, 27));
        }

    }

    private void initExcelBands() {
        if (document != null) {
            document.addBand(eJasperBandType.title, document.getJRDesignBand(SplitTypeEnum.STRETCH, 75))
                    .addBand(eJasperBandType.detail, document.getJRDesignBand(SplitTypeEnum.STRETCH, 14));
        }
    }

    /**
     * Set Default Variables for this Template
     */
    @Override
    protected void initVariables() {
        if (document != null) {
            // Adding Variables
            document.addVariable(document.getJRDesignVariable("stringSupport", "com.atser.tools.atserutil.string.StringSupport"));
        }
    }

    /**
     * Set Default Fields for this Template
     *
     * @param clazz
     */
    @Override
    protected void initFields(Class clazz) {
        if (document != null) {
            for (Field field : clazz.getDeclaredFields()) {
                document.addField(document.getJRDesignField(field.getName(), field.getType()));
            }
        }
    }

    @Override
    protected void initTitle(String title) {
        initTitle(title, null);
    }

    @Override
    protected void initTitle(String title, String subtitle) {
        document.addDefaultTitle(title, subtitle);
        document.addDefaultLogo(document.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "$F{projectLogo}"));
    }

    private void initExcelTitle(String title) {
        initExcelTitle(title, null);
    }

    private void initExcelTitle(String title, String subtitle) {
        // Adding Logo
        //document.addJRDesignElement(eJasperBandType.title, document.getJRDesignImage(0, 0, 53, 46, HorizontalImageAlignEnum.CENTER, VerticalImageAlignEnum.MIDDLE, ScaleImageEnum.RETAIN_SHAPE, ModeEnum.TRANSPARENT, document.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "$F{projectLogo}")));
        // Adding Title and Subtitle
        if (StringSupport.isNotNullAndNotEmpty(title)) {
            document.addJRDesignElement(eJasperBandType.title, document.getJRDesignStaticText(1, 0, 752, 23, HorizontalTextAlignEnum.CENTER, VerticalTextAlignEnum.MIDDLE, "SansSerif", 15f, null, eJasperTextFont.bold, title));
        }
        if (StringSupport.isNotNullAndNotEmpty(subtitle)) {
            document.addJRDesignElement(eJasperBandType.title, document.getJRDesignStaticText(1, 23, 752, 23, HorizontalTextAlignEnum.CENTER, VerticalTextAlignEnum.MIDDLE, "SansSerif", 11f, null, eJasperTextFont.bold, subtitle));
        }
    }

    private void addExcelTitleFields(List<ReportGridColumnsTO> columnsdef) {
        double colsum = columnsdef.stream().mapToInt(p -> p.getWidth()).sum();
        double pagewidth = document.getJasperDesign().getColumnWidth();
        double r = colsum / pagewidth;
        int x = 1;
        int y = 46;
        for (ReportGridColumnsTO it : columnsdef) {
            int w = ((int) (it.getWidth() / r));
            JRDesignStaticText text = document.getJRDesignStaticText(x, y, w, 27, document.convertHorizontalTextAlignEnum(it.getTextAlign()), VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.bold, it.getHeaderText());
            document.addJRDesignElement(eJasperBandType.title, text);
            x += w;
        }
    }

    private void addExcelDetailsField(List<ReportGridColumnsTO> columnsdef) {
        double colsum = columnsdef.stream().mapToInt(p -> p.getWidth()).sum();
        double pagewidth = document.getJasperDesign().getColumnWidth();
        double r = colsum / pagewidth;
        int x = 1;
        int y = 1;
        for (ReportGridColumnsTO it : columnsdef) {
            int w = ((int) (it.getWidth() / r));
            JRDesignTextField field = document.getJRDesignTextField(x, y, w, 11, null, null, document.convertHorizontalTextAlignEnum(it.getTextAlign()), VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.normal, excelTextAdjust, document.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "$F{" + it.getField() + "}"));
            document.addJRDesignElement(eJasperBandType.detail, field);
            x += w;
        }
    }

    @Override
    protected void addColumnHeaderFields(List<ReportGridColumnsTO> columnsdef) {
        document.addJRDesignElement(eJasperBandType.columnHeader, document.getJRDesignLine(0, 0, 752, 1, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID)) // Top
                .addJRDesignElement(eJasperBandType.columnHeader, document.getJRDesignLine(0, 28, 752, 1, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID)) // Bottom
                .addJRDesignElement(eJasperBandType.columnHeader, document.getJRDesignLine(0, 0, 1, 28, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID)) // Left
                .addJRDesignElement(eJasperBandType.columnHeader, document.getJRDesignLine(752, 0, 1, 28, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID)); // Rigth
        double colsum = columnsdef.stream().mapToInt(p -> p.getWidth()).sum();
        double pagewidth = document.getJasperDesign().getColumnWidth();
        double r = colsum / pagewidth;
        int linespace = 1;
        int x = 1;
        int y = 1;
        int itnum = 1;

        for (ReportGridColumnsTO it : columnsdef) {
            int w = ((int) (it.getWidth() / r)) - linespace;
            JRDesignStaticText text = document.getJRDesignStaticText(x, y, w, 27, document.convertHorizontalTextAlignEnum(it.getTextAlign()), VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.bold, it.getHeaderText());
            text.getLineBox().setLeftPadding(new Integer(2));
            document.addJRDesignElement(eJasperBandType.columnHeader, text);
            if (itnum < columnsdef.size()) {
                document.addJRDesignElement(eJasperBandType.columnHeader, document.getJRDesignLine(x + w, y, 1, 28, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID));
            }
            x += w + linespace;
            itnum++;
        }
    }

    @Override
    protected void addDetailsField(List<ReportGridColumnsTO> columnsdef) {
        document.addJRDesignElement(eJasperBandType.detail, document.getJRDesignLine(0, 13, 752, 1, null, PositionTypeEnum.FLOAT, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID)); // Bottom
        JRDesignLine leftLine = document.getJRDesignLine(0, -1, 1, 14, null, PositionTypeEnum.FLOAT, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID);// Left
        leftLine.setStretchType(StretchTypeEnum.CONTAINER_HEIGHT);
        document.addJRDesignElement(eJasperBandType.detail, leftLine);
        JRDesignLine rigthLine = document.getJRDesignLine(752, -1, 1, 14, null, PositionTypeEnum.FLOAT, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID); // Rigth
        rigthLine.setStretchType(StretchTypeEnum.CONTAINER_HEIGHT);
        document.addJRDesignElement(eJasperBandType.detail, rigthLine);
        double colsum = columnsdef.stream().mapToInt(p -> p.getWidth()).sum();
        double pagewidth = document.getJasperDesign().getColumnWidth();
        double r = colsum / pagewidth;
        int linespace = 1;
        int x = 1;
        int y = 1;
        int itnum = 1;
        for (ReportGridColumnsTO it : columnsdef) {
            int w = ((int) (it.getWidth() / r)) - linespace;
            JRDesignTextField field = document.getJRDesignTextField(x, y, w, 11, null, null, document.convertHorizontalTextAlignEnum(it.getTextAlign()), VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.normal, TextAdjustEnum.CUT_TEXT, document.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "$F{" + it.getField() + "}"));
            field.getLineBox().setLeftPadding(new Integer(2));
            document.addJRDesignElement(eJasperBandType.detail, field);
            if (itnum < columnsdef.size()) {
                JRDesignLine line = document.getJRDesignLine(x + w, -y, 1, 14, null, PositionTypeEnum.FLOAT, 0.25f, Color.decode("#9E9E9E"), LineStyleEnum.SOLID);
                line.setStretchType(StretchTypeEnum.CONTAINER_HEIGHT);
                document.addJRDesignElement(eJasperBandType.detail, line);
            }
            x += w + linespace;
            itnum++;
        }
    }

    /**
     * Set Default Footer for this Template
     */
    @Override
    protected void initFooter() {
        if (document != null) {
            document.addDefaultPageFooter();
        }
    }

}
