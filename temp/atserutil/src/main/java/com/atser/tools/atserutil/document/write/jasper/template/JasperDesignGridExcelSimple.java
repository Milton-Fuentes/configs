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
import java.lang.reflect.Field;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.ExpressionTypeEnum;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.type.TextAdjustEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

/**
 *
 * @author droldan
 */
public class JasperDesignGridExcelSimple extends JasperDesignGridTemplate {

    private final String documentName;
    private final OrientationEnum documentOrientation;

    public JasperDesignGridExcelSimple(String documentName, OrientationEnum documentOrientation, eDocExtension extension) throws JRException {
        super(extension);
        this.documentName = documentName;
        this.documentOrientation = documentOrientation;
    }

    public JasperDesign buildTemplate(String title, Class fields, String clientName) throws Exception {
        List<ReportGridColumnsTO> columnsdef = document.generateReportColumns(fields, clientName);
        if (columnsdef == null || columnsdef.isEmpty()) {
            throw new Exception("Report Columns Definition is Empty or Null");
        }
        int width = columnsdef.stream().mapToInt(ReportGridColumnsTO::getWidth).sum();
        document.generateDesignWithDefaultProperties(documentName, documentOrientation, width, 612, (width - 40), 20);
        initBands();
        initVariables();
        initFields(fields);
        addColumnHeaderFields(columnsdef);
        addDetailsField(columnsdef);
        return document.getJasperDesign();
    }

    public JasperDesign buildTemplate(String title, Class fields, List<ReportGridColumnsTO> columnsdef) throws Exception {
        if (columnsdef == null || columnsdef.isEmpty()) {
            throw new Exception("Report Columns Definition is Empty or Null");
        }
        int width = columnsdef.stream().mapToInt(ReportGridColumnsTO::getWidth).sum();
        document.generateDesignWithDefaultProperties(documentName, documentOrientation, width, 612, (width - 40), 20);
        initBands();
        initVariables();
        initFields(fields);
        addColumnHeaderFields(columnsdef);
        addDetailsField(columnsdef);
        return document.getJasperDesign();
    }

    @Override
    protected void initBands() {
        if (document != null) {
            document.addBand(eJasperBandType.title, document.getJRDesignBand(SplitTypeEnum.STRETCH, 75))
                    .addBand(eJasperBandType.detail, document.getJRDesignBand(SplitTypeEnum.STRETCH, 14));
        }
    }

    @Override
    protected void initVariables() {
        if (document != null) {
            // Adding Variables
            document.addVariable(document.getJRDesignVariable("stringSupport", "com.atser.tools.atserutil.string.StringSupport"));
        }
    }

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
    }

    @Override
    protected void addColumnHeaderFields(List<ReportGridColumnsTO> columnsdef) {
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

    @Override
    protected void addDetailsField(List<ReportGridColumnsTO> columnsdef) {
        double colsum = columnsdef.stream().mapToInt(p -> p.getWidth()).sum();
        double pagewidth = document.getJasperDesign().getColumnWidth();
        double r = colsum / pagewidth;
        int x = 1;
        int y = 1;
        for (ReportGridColumnsTO it : columnsdef) {
            int w = ((int) (it.getWidth() / r));
            JRDesignTextField field = document.getJRDesignTextField(x, y, w, 11, null, null, document.convertHorizontalTextAlignEnum(it.getTextAlign()), VerticalTextAlignEnum.MIDDLE, "SansSerif", 8f, null, eJasperTextFont.normal, TextAdjustEnum.CUT_TEXT, document.getJRDesignExpression(ExpressionTypeEnum.DEFAULT, "$F{" + it.getField() + "}"));
            document.addJRDesignElement(eJasperBandType.detail, field);
            x += w;
        }
    }

    @Override
    protected void initFooter() {
        if (document != null) {
            document.addDefaultPageFooter();
        }
    }

}
