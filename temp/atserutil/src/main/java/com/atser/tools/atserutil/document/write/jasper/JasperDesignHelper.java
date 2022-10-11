/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.jasper;

import com.atser.tools.atserutil.annotation.ReportColumnDef;
import com.atser.tools.atserutil.annotation.ReportColumnMapping;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.jasper.eJasperBandType;
import com.atser.tools.atserutil.enumerator.jasper.eJasperBorder;
import com.atser.tools.atserutil.enumerator.jasper.eJasperTextFont;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRSection;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignElementGroup;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignFrame;
import net.sf.jasperreports.engine.design.JRDesignImage;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextElement;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;
import net.sf.jasperreports.engine.type.ExpressionTypeEnum;
import net.sf.jasperreports.engine.type.HorizontalImageAlignEnum;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.PositionTypeEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.type.TextAdjustEnum;
import net.sf.jasperreports.engine.type.VerticalImageAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

/**
 *
 * @author droldan
 */
public class JasperDesignHelper {

    protected JasperDesign jasperDesign;
    protected eDocExtension extension;

    public JasperDesignHelper(eDocExtension extension) {
        this.jasperDesign = new JasperDesign();
        this.extension = extension;
    }

    public JasperDesign getJasperDesign() {
        return jasperDesign;
    }

    public void setJasperDesign(JasperDesign jasperDesign) {
        this.jasperDesign = jasperDesign;
    }

    public eDocExtension getExtension() {
        return extension;
    }

    public void setExtension(eDocExtension extension) {
        this.extension = extension;
    }

    /**
     * Get HorizontalTextAlignEnum
     *
     * @param textalign
     * @return
     */
    public HorizontalTextAlignEnum convertHorizontalTextAlignEnum(String textalign) {
        switch (textalign) {
            case "left":
            case "LEFT": {
                return HorizontalTextAlignEnum.LEFT;
            }
            case "right":
            case "RIGHT": {
                return HorizontalTextAlignEnum.RIGHT;
            }
            case "center":
            case "CENTER": {
                return HorizontalTextAlignEnum.CENTER;
            }
        }
        return HorizontalTextAlignEnum.LEFT;
    }

    /**
     * Proxy Java Class
     *
     * @param fieldType
     * @return
     */
    private Class getFieldType(Class fieldType) {
        if (fieldType != null) {
            String type = fieldType.getTypeName();
            switch (type) {
                case "java.lang.String":
                case "java.lang.Long":
                case "java.lang.Character":
                case "java.math.BigInteger":
                case "java.lang.Integer":
                case "java.lang.Double":
                case "java.math.BigDecimal":
                case "java.lang.Short":
                case "java.lang.Boolean":
                case "java.util.Date":
                    return fieldType;
            }
        }
        return Object.class;
    }

    /**
     * Generate a Jasper Design With Default Properties
     *
     * @param documentName
     * @param documentOrientation
     * @param width
     * @param height
     * @param columnWidth
     * @param margin
     * @return JasperDesign
     * @throws JRException
     */
    public JasperDesignHelper generateDesignWithDefaultProperties(String documentName, OrientationEnum documentOrientation, int width, int height, int columnWidth, int margin) throws JRException {
        jasperDesign.setName(documentName);
        jasperDesign.setPageWidth(width);
        jasperDesign.setPageHeight(height);
        jasperDesign.setOrientation(documentOrientation);
        jasperDesign.setColumnWidth(columnWidth);
        jasperDesign.setLeftMargin(margin);
        jasperDesign.setRightMargin(margin);
        jasperDesign.setTopMargin(margin);
        jasperDesign.setBottomMargin(margin);
        jasperDesign.setUUID(UUID.randomUUID());
        jasperDesign.setProperty("com.jaspersoft.studio.data.defaultdataadapter", "One Empty Record");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.pageHeight", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.pageWidth", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.topMargin", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.bottomMargin", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.leftMargin", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.rightMargin", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.columnWidth", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.unit.columnSpacing", "pixel");
        jasperDesign.setProperty("com.jaspersoft.studio.report.description", "");
        jasperDesign.setProperty("", "pixel");
        return this;
    }

    /**
     * Add Band
     *
     * @param bandtype
     * @param band
     * @return
     */
    public JasperDesignHelper addBand(eJasperBandType bandtype, JRDesignBand band) {
        if (band != null) {
            switch (bandtype) {
                case background: {
                    jasperDesign.setBackground(band);
                    break;
                }
                case title: {
                    jasperDesign.setTitle(band);
                    break;
                }
                case pageHeader: {
                    jasperDesign.setPageHeader(band);
                    break;
                }
                case columnHeader: {
                    jasperDesign.setColumnHeader(band);
                    break;
                }
                case detail: {
                    ((JRDesignSection) jasperDesign.getDetailSection()).addBand(band);
                    break;
                }
                case pageFooter: {
                    jasperDesign.setPageFooter(band);
                    break;
                }
            }
        }
        return this;
    }

    /**
     * Add Style
     *
     * @param style
     * @return
     */
    public JasperDesignHelper addStyle(JRDesignStyle style) {
        if (style != null) {
            try {
                jasperDesign.addStyle(style);
            } catch (JRException ex) {
                Logger.getLogger(JasperDesignHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this;
    }

    /**
     * Add JRDesignElement
     *
     * @param bandtype
     * @param element
     * @return
     */
    public JasperDesignHelper addJRDesignElement(eJasperBandType bandtype, JRDesignElement element) {
        return addJRDesignElement(bandtype, element, 0);
    }

    /**
     * Add JRDesignElement
     *
     * @param bandtype
     * @param element
     * @param detailband
     * @return
     */
    public JasperDesignHelper addJRDesignElement(eJasperBandType bandtype, JRDesignElement element, int detailband) {
        if (element != null) {
            switch (bandtype) {
                case background: {
                    ((JRDesignElementGroup) jasperDesign.getBackground()).addElement(element);
                    break;
                }
                case title: {
                    ((JRDesignElementGroup) jasperDesign.getTitle()).addElement(element);
                    break;
                }
                case pageHeader: {
                    ((JRDesignElementGroup) jasperDesign.getPageHeader()).addElement(element);
                    break;
                }
                case columnHeader: {
                    ((JRDesignElementGroup) jasperDesign.getColumnHeader()).addElement(element);
                    break;
                }
                case detail: {
                    JRSection detail = jasperDesign.getDetailSection();
                    if (detail != null && detail.getBands() != null && detail.getBands().length > 0) {
                        ((JRDesignElementGroup) detail.getBands()[detailband]).addElement(element);
                    }
                    break;
                }
                case pageFooter: {
                    ((JRDesignElementGroup) jasperDesign.getPageFooter()).addElement(element);
                    break;
                }
            }
        }
        return this;
    }

    public JasperDesignHelper addDefaultLogo(JRDesignExpression expression) {
        this.addJRDesignElement(eJasperBandType.title, getJRDesignImage(4, 3, 59, 56, HorizontalImageAlignEnum.CENTER, VerticalImageAlignEnum.MIDDLE, ScaleImageEnum.RETAIN_SHAPE, ModeEnum.TRANSPARENT, expression));
        return this;
    }

    /**
     * Add Default Title
     *
     * @param title
     * @return
     */
    public JasperDesignHelper addDefaultTitle(String title) {
        return addDefaultTitle(title, null);
    }

    /**
     * Add Default Title
     *
     * @param title
     * @param subtitle
     * @return
     */
    public JasperDesignHelper addDefaultTitle(String title, String subtitle) {
        if (StringSupport.isNotNullAndNotEmpty(title)) {
            this.addJRDesignElement(eJasperBandType.title, this.getJRDesignStaticText(68, 2, 639, 23, HorizontalTextAlignEnum.CENTER, VerticalTextAlignEnum.MIDDLE, "SansSerif", 15f, null, eJasperTextFont.bold, title));
        }

        if (StringSupport.isNotNullAndNotEmpty(subtitle)) {
            this.addJRDesignElement(eJasperBandType.title, this.getJRDesignStaticText(69, 25, 639, 23, HorizontalTextAlignEnum.CENTER, VerticalTextAlignEnum.MIDDLE, "SansSerif", 11f, null, eJasperTextFont.bold, subtitle));
        }
        return this;
    }

    /**
     * Add Default Page Footer
     *
     * @return
     */
    public JasperDesignHelper addDefaultPageFooter() {
        this.addJRDesignElement(eJasperBandType.pageFooter, this.getJRDesignFrame(0, 3, 750, 24, Color.decode("#5E5D5C"), new Color(255, 255, 255, 0), ModeEnum.OPAQUE));
        // Report Date
        JRDesignTextField txtFooterDate = this.getJRDesignTextField(2, 2, 197, 20, Color.decode("#524E45"), null, HorizontalTextAlignEnum.LEFT, VerticalTextAlignEnum.MIDDLE, "SansSerif", 10f, null, eJasperTextFont.normal, TextAdjustEnum.CUT_TEXT, this.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "new java.util.Date()"));
        txtFooterDate.setPattern("EEEEE dd MMMMM yyyy");
        // Pagination
        JRDesignTextField pagOf = this.getJRDesignTextField(627, 2, 80, 20, Color.decode("#524E45"), null, HorizontalTextAlignEnum.RIGHT, VerticalTextAlignEnum.MIDDLE, "SansSerif", 10f, null, eJasperTextFont.normal, TextAdjustEnum.CUT_TEXT, this.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "\"Page \"+$V{PAGE_NUMBER}+\" of\""));
        pagOf.setEvaluationTime(EvaluationTimeEnum.NOW);
        this.addJRDesignElement(eJasperBandType.pageFooter, pagOf);
        JRDesignTextField pagNum = this.getJRDesignTextField(707, 2, 40, 20, Color.decode("#524E45"), null, HorizontalTextAlignEnum.LEFT, VerticalTextAlignEnum.MIDDLE, "SansSerif", 10f, null, eJasperTextFont.normal, TextAdjustEnum.CUT_TEXT, this.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "\" \" + $V{PAGE_NUMBER}"));
        pagNum.setEvaluationTime(EvaluationTimeEnum.REPORT);
        this.addJRDesignElement(eJasperBandType.pageFooter, pagNum);
        this.addJRDesignElement(eJasperBandType.pageFooter, txtFooterDate);
        return this;
    }

    /**
     * Add Variable
     *
     * @param variable
     * @return
     */
    public JasperDesignHelper addVariable(JRDesignVariable variable) {
        if (variable != null) {
            try {
                jasperDesign.addVariable(variable);
            } catch (JRException ex) {
                Logger.getLogger(JasperDesignHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this;
    }

    /**
     * Add Field
     *
     * @param field
     * @return
     */
    public JasperDesignHelper addField(JRDesignField field) {
        if (field != null) {
            try {
                jasperDesign.addField(field);
            } catch (JRException ex) {
                Logger.getLogger(JasperDesignHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this;
    }

    /**
     * Set Border
     *
     * @param border
     * @param element
     * @param lineColor
     * @param lineStyle
     * @param LineWidth
     */
    public void setBorder(eJasperBorder border, JRDesignTextElement element, Color lineColor, LineStyleEnum lineStyle, Float LineWidth) {
        if (element != null) {
            switch (border) {
                case left: {
                    element.getLineBox().getLeftPen().setLineColor(lineColor);
                    element.getLineBox().getLeftPen().setLineStyle(lineStyle);
                    element.getLineBox().getLeftPen().setLineWidth(LineWidth);
                    break;
                }
                case right: {
                    element.getLineBox().getRightPen().setLineColor(lineColor);
                    element.getLineBox().getRightPen().setLineStyle(lineStyle);
                    element.getLineBox().getRightPen().setLineWidth(LineWidth);
                    break;
                }
                case bottom: {
                    element.getLineBox().getBottomPen().setLineColor(lineColor);
                    element.getLineBox().getBottomPen().setLineStyle(lineStyle);
                    element.getLineBox().getBottomPen().setLineWidth(LineWidth);
                    break;
                }
                case top: {
                    element.getLineBox().getTopPen().setLineColor(lineColor);
                    element.getLineBox().getTopPen().setLineStyle(lineStyle);
                    element.getLineBox().getTopPen().setLineWidth(LineWidth);
                    break;
                }
            }
        }
    }

    /**
     * Produce a Variable
     *
     * @param name
     * @param className
     * @return
     */
    public JRDesignVariable getJRDesignVariable(String name, String className) {
        JRDesignVariable var = new JRDesignVariable();
        var.setName(name);
        var.setValueClassName(className);
        return var;
    }

    /**
     * Produce a Variable
     *
     * @param name
     * @param clazz
     * @return
     */
    public JRDesignVariable getJRDesignVariable(String name, Class clazz) {
        JRDesignVariable var = new JRDesignVariable();
        var.setName(name);
        var.setValueClass(clazz);
        return var;
    }

    /**
     * Produce a Field
     *
     * @param name
     * @param className
     * @return
     */
    public JRDesignField getJRDesignField(String name, String className) {
        JRDesignField field = new JRDesignField();
        field.setName(name);
        field.setValueClassName(className);
        return field;
    }

    /**
     * Produce a Field
     *
     * @param name
     * @param clazz
     * @return
     */
    public JRDesignField getJRDesignField(String name, Class clazz) {
        JRDesignField field = new JRDesignField();
        field.setName(name);
        field.setValueClass(getFieldType(clazz));
        return field;
    }

    /**
     * Produce Static Text Component
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param fontName
     * @param fontSize
     * @param fontColor
     * @param fonttype
     * @param text
     * @return
     */
    public JRDesignStaticText getJRDesignStaticText(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, String fontName, Float fontSize, Color fontColor, eJasperTextFont fonttype, String text) {
        JRDesignStaticText statictext = new JRDesignStaticText();
        statictext.setX(x);
        statictext.setY(y);
        statictext.setWidth(width);
        statictext.setHeight(height);
        statictext.setUUID(UUID.randomUUID());
        statictext.setHorizontalTextAlign(halign);
        statictext.setVerticalTextAlign(valign);

        switch (fonttype) {
            case bold: {
                statictext.setBold(Boolean.TRUE);
                break;
            }
            case italic: {
                statictext.setItalic(Boolean.TRUE);
                break;
            }
        }

        if (StringSupport.isNotNullAndNotEmpty(fontName)) {
            statictext.setFontName(fontName);
        }

        if (fontSize != null) {
            statictext.setFontSize(fontSize);
        }

        if (fontColor != null) {
            statictext.setForecolor(fontColor);
        }
        statictext.setText(text);
        return statictext;
    }

    /**
     * Produce Static Text Component
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param style
     * @param text
     * @return JRDesignStaticText
     */
    public JRDesignStaticText getJRDesignStaticTextWithStyle(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, JRDesignStyle style, String text) {
        JRDesignStaticText statictext = new JRDesignStaticText();
        statictext.setX(x);
        statictext.setY(y);
        statictext.setWidth(width);
        statictext.setHeight(height);
        statictext.setUUID(UUID.randomUUID());
        statictext.setHorizontalTextAlign(halign);
        statictext.setVerticalTextAlign(valign);
        statictext.setStyle(style);
        statictext.setText(text);
        return statictext;
    }

    /**
     * Produce Static Text Component
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param styleName
     * @param text
     * @return
     */
    public JRDesignStaticText getJRDesignStaticTextWithStyle(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, String styleName, String text) {
        return getJRDesignStaticTextWithStyle(x, y, width, height, halign, valign, (JRDesignStyle) jasperDesign.getStylesMap().get(styleName), text);
    }

    /**
     * Produce a JRDesignImage
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param scaleImage
     * @param mode
     * @param expression
     * @return
     */
    public JRDesignImage getJRDesignImage(int x, int y, int width, int height, HorizontalImageAlignEnum halign, VerticalImageAlignEnum valign, ScaleImageEnum scaleImage, ModeEnum mode, JRDesignExpression expression) {
        JRDesignImage image = new JRDesignImage(jasperDesign);
        image.setX(x);
        image.setY(y);
        image.setWidth(width);
        image.setHeight(height);
        image.setHorizontalImageAlign(halign);
        image.setVerticalImageAlign(valign);
        if (scaleImage != null) {
            image.setScaleImage(scaleImage);
        }
        if (mode != null) {
            image.setMode(mode);
        }
        image.setExpression(expression);
        return image;
    }

    /**
     * Produce a Text Field
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param foreColor
     * @param backColor
     * @param halign
     * @param valign
     * @param fontName
     * @param fontSize
     * @param fontColor
     * @param fonttype
     * @param textAdjust
     * @param expression
     * @return
     */
    public JRDesignTextField getJRDesignTextField(int x, int y, int width, int height, Color foreColor, Color backColor, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, String fontName, Float fontSize, Color fontColor, eJasperTextFont fonttype, TextAdjustEnum textAdjust, JRDesignExpression expression) {
        JRDesignTextField textfield = new JRDesignTextField();
        textfield.setX(x);
        textfield.setY(y);
        textfield.setWidth(width);
        textfield.setHeight(height);
        textfield.setUUID(UUID.randomUUID());
        textfield.setHorizontalTextAlign(halign);
        textfield.setVerticalTextAlign(valign);

        switch (fonttype) {
            case bold: {
                textfield.setBold(Boolean.TRUE);
                break;
            }
            case italic: {
                textfield.setItalic(Boolean.TRUE);
                break;
            }
        }

        if (StringSupport.isNotNullAndNotEmpty(fontName)) {
            textfield.setFontName(fontName);
        }

        if (fontSize != null) {
            textfield.setFontSize(fontSize);
        }

        if (fontColor != null) {
            textfield.setForecolor(fontColor);
        }

        if (foreColor != null) {
            textfield.setForecolor(foreColor);
        }
        if (backColor != null) {
            textfield.setBackcolor(backColor);
        }

        if (expression != null) {
            textfield.setExpression(expression);
        }
        textfield.setTextAdjust(textAdjust);
        textfield.setBlankWhenNull(true);
        return textfield;
    }

    /**
     * Produce a Text Field
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param foreColor
     * @param backColor
     * @param halign
     * @param valign
     * @param style
     * @return
     */
    public JRDesignTextField getJRDesignTextFieldWithStyle(int x, int y, int width, int height, Color foreColor, Color backColor, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, JRDesignStyle style, TextAdjustEnum textAdjust, JRDesignExpression expression) {
        JRDesignTextField textfield = new JRDesignTextField();
        textfield.setX(x);
        textfield.setY(y);
        textfield.setWidth(width);
        textfield.setHeight(height);
        textfield.setUUID(UUID.randomUUID());
        textfield.setHorizontalTextAlign(halign);
        textfield.setVerticalTextAlign(valign);
        textfield.setStyle(style);
        if (foreColor != null) {
            textfield.setForecolor(foreColor);
        }
        if (backColor != null) {
            textfield.setBackcolor(backColor);
        }

        if (expression != null) {
            textfield.setExpression(expression);
        }
        textfield.setTextAdjust(textAdjust);
        textfield.setBlankWhenNull(true);
        return textfield;
    }

    /**
     * Produce a Text Field
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param styleName
     * @param textAdjust
     * @param expression
     * @return
     */
    public JRDesignTextField getJRDesignTextFieldWithStyle(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, String styleName, TextAdjustEnum textAdjust, JRDesignExpression expression) {
        return getJRDesignTextFieldWithStyle(x, y, width, height, null, null, halign, valign, (JRDesignStyle) jasperDesign.getStylesMap().get(styleName), textAdjust, expression);
    }

    /**
     * Produce a Text Field
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param style
     * @param textAdjust
     * @return
     */
    public JRDesignTextField getJRDesignTextFieldWithStyle(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, JRDesignStyle style, TextAdjustEnum textAdjust, JRDesignExpression expression) {
        return getJRDesignTextFieldWithStyle(x, y, width, height, null, null, halign, valign, style, textAdjust, expression);
    }

    /**
     * Set JRDesignExpression
     *
     * @param type
     * @param text
     * @return
     */
    public JRDesignExpression getJRDesignExpression(ExpressionTypeEnum type, String text) {
        JRDesignExpression exp = new JRDesignExpression();
        exp.setType(type);
        exp.setText(text);
        return exp;
    }

    /**
     * Produce a Design Style
     *
     * @param styleName
     * @param fontName
     * @param fontsize
     * @param fonttype
     * @return
     */
    public JRDesignStyle getJRDesignStyle(String styleName, String fontName, Float fontsize, eJasperTextFont fonttype) {
        return getJRDesignStyle(styleName, fontName, fontsize, fonttype, Boolean.FALSE);
    }

    /**
     * Produce a Design Style
     *
     * @param fontsize
     * @param fonttype
     * @return
     */
    public JRDesignStyle getJRDesignStyle(Float fontsize, eJasperTextFont fonttype) {
        return getJRDesignStyle(null, null, fontsize, fonttype, Boolean.FALSE);
    }

    /**
     * Produce Design Style
     *
     * @param styleName
     * @param fontName
     * @param fontsize
     * @param fonttype
     * @param isdefault
     * @return JRDesignStyle
     */
    public JRDesignStyle getJRDesignStyle(String styleName, String fontName, Float fontsize, eJasperTextFont fonttype, Boolean isdefault) {
        JRDesignStyle defstyle = new JRDesignStyle();
        if (StringSupport.isNotNullAndNotEmpty(styleName)) {
            defstyle.setName(styleName);
        } else {
            defstyle.setName(jasperDesign.getDefaultStyle().getName());
        }
        defstyle.setDefault(isdefault);
        if (StringSupport.isNotNullAndNotEmpty(fontName)) {
            defstyle.setFontName(fontName);
        } else {
            defstyle.setFontName(jasperDesign.getDefaultStyle().getFontName());
        }
        defstyle.setFontSize(fontsize);
        switch (fonttype) {
            case bold: {
                defstyle.setBold(Boolean.TRUE);
                break;
            }
            case italic: {
                defstyle.setItalic(Boolean.TRUE);
                break;
            }
        }
        return defstyle;
    }

    /**
     * Produce Band
     *
     * @param splitType
     * @return
     */
    public JRDesignBand getJRDesignBand(SplitTypeEnum splitType) {
        return getJRDesignBand(splitType, -1);
    }

    /**
     * Produce Band
     *
     * @param splitType
     * @param height
     * @return
     */
    public JRDesignBand getJRDesignBand(SplitTypeEnum splitType, int height) {
        JRDesignBand band = new JRDesignBand();
        band.setSplitType(splitType);
        if (height > 0) {
            band.setHeight(height);
        }
        return band;
    }

    /**
     * Produce a Frame
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param foreColor
     * @param backColor
     * @param mode
     * @return
     */
    public JRDesignFrame getJRDesignFrame(int x, int y, int width, int height, Color foreColor, Color backColor, ModeEnum mode) {
        JRDesignFrame frame = new JRDesignFrame();
        frame.setX(x);
        frame.setY(y);
        frame.setWidth(width);
        frame.setHeight(height);
        frame.setForecolor(foreColor);
        frame.setBackcolor(backColor);
        frame.setMode(mode);
        frame.setUUID(UUID.randomUUID());
        return frame;
    }

    /**
     * Produce a Line
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param foreColor
     * @param positionType
     * @return
     */
    public JRDesignLine getJRDesignLine(int x, int y, int width, int height, Color foreColor, PositionTypeEnum positionType, Float lineWidth, Color lineColor, LineStyleEnum lineStyle) {
        JRDesignLine line = new JRDesignLine();
        line.setX(x);
        line.setY(y);
        line.setWidth(width);
        line.setHeight(height);
        if (foreColor != null) {
            line.setForecolor(foreColor);
        }
        line.setPositionType(positionType);
        line.getLinePen().setLineWidth(lineWidth);
        line.getLinePen().setLineColor(lineColor);
        line.getLinePen().setLineStyle(lineStyle);
        line.setUUID(UUID.randomUUID());
        return line;
    }

    /**
     * Produce a Line
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param lineWidth
     * @param lineColor
     * @param lineStyle
     * @return
     */
    public JRDesignLine getJRDesignLine(int x, int y, int width, int height, Float lineWidth, Color lineColor, LineStyleEnum lineStyle) {
        JRDesignLine line = new JRDesignLine();
        line.setX(x);
        line.setY(y);
        line.setWidth(width);
        line.setHeight(height);
        line.getLinePen().setLineWidth(lineWidth);
        line.getLinePen().setLineColor(lineColor);
        line.getLinePen().setLineStyle(lineStyle);
        line.setUUID(UUID.randomUUID());
        return line;
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param halign
     * @param valign
     * @param fontName
     * @param fontSize
     * @param fontColor
     * @param fonttype
     * @param text
     * @return
     */
    public JRDesignStaticText getDefaultJRDesignStaticTextWithBorder(int x, int y, int width, int height, HorizontalTextAlignEnum halign, VerticalTextAlignEnum valign, String fontName, Float fontSize, Color fontColor, eJasperTextFont fonttype, String text) {
        JRDesignStaticText stext = this.getJRDesignStaticText(0, 3, 30, 11, HorizontalTextAlignEnum.LEFT, VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.bold, "TCN");
        this.setBorder(eJasperBorder.left, stext, Color.BLACK, LineStyleEnum.SOLID, 1.0f);
        this.setBorder(eJasperBorder.right, stext, Color.BLACK, LineStyleEnum.SOLID, 1.0f);
        this.setBorder(eJasperBorder.top, stext, Color.BLACK, LineStyleEnum.SOLID, 1.0f);
        this.setBorder(eJasperBorder.bottom, stext, Color.BLACK, LineStyleEnum.SOLID, 1.0f);
        this.addJRDesignElement(eJasperBandType.columnHeader, stext);
        return stext;
    }

    public List<ReportGridColumnsTO> generateReportColumns(Class clazz, String clientName) {
        List<ReportGridColumnsTO> columns = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ReportColumnMapping.class)) {
                ReportColumnMapping columnMap = field.getAnnotation(ReportColumnMapping.class);
                ReportGridColumnsTO defaultValue = null;
                for (ReportColumnDef reportColumnDef : columnMap.column()) {
                    if (!reportColumnDef.ignore() && (reportColumnDef.client().equals("default") || reportColumnDef.client().equals(clientName))) {
                        defaultValue = new ReportGridColumnsTO(field.getName(), reportColumnDef.caption(), reportColumnDef.textAlign(), reportColumnDef.width());
                    }
                }
                if (defaultValue != null) {
                    columns.add(defaultValue);
                }
            }
        }
        return columns;
    }
}
