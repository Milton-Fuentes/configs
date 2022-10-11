/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.jasper.template;

import com.atser.tools.atserutil.document.write.jasper.JasperDesignHelper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.type.OrientationEnum;

/**
 *
 * @author droldan
 */
public abstract class JasperDesignGridTemplate {

    protected JasperDesignHelper document;

    /**
     * Build Document by Parameters
     * @param documentName
     * @param documentOrientation
     * @param width
     * @param height
     * @param columnWidth
     * @param margin
     * @param extension
     * @throws JRException 
     */
    public JasperDesignGridTemplate(String documentName, OrientationEnum documentOrientation, int width, int height, int columnWidth, int margin, eDocExtension extension) throws JRException {
        document = new JasperDesignHelper(extension);
        document.generateDesignWithDefaultProperties(documentName, documentOrientation, width, height, columnWidth, margin);
    }
    
    public JasperDesignGridTemplate(String documentName, OrientationEnum documentOrientation, int width, int height, int margin, eDocExtension extension) throws JRException {
        document = new JasperDesignHelper(extension);
        document.generateDesignWithDefaultProperties(documentName, documentOrientation, width, height, (width - (margin * 2)), margin);
    }
    
    public JasperDesignGridTemplate(eDocExtension extension) throws JRException {
        document = new JasperDesignHelper(extension);
    }

    /**
     * Method to add the bands
     */
    protected abstract void initBands();

    /**
     * Method to Add Variables
     */
    protected abstract void initVariables();

    /**
     * Method to Add Fields By Class (Usually will be a Pojo Class)
     *
     * @param clazz
     */
    protected abstract void initFields(Class clazz);

    protected abstract void initTitle(String title);

    protected abstract void initTitle(String title, String subtitle);
    
    protected abstract void addColumnHeaderFields(List<ReportGridColumnsTO> columnsdef);

    protected abstract void addDetailsField(List<ReportGridColumnsTO> columnsdef);

    protected abstract void initFooter();

}
