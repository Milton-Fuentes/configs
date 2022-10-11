package com.atser.tools.atserutil.document.read.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dropal
 */
public class ExcelDocumentXLS extends ExcelDocument {

    private HSSFWorkbook pdocXLS;

    public ExcelDocumentXLS(File file) throws FileNotFoundException {
        super(file);
        try {
            pdocXLS = new HSSFWorkbook(pInputStream);
        } catch (IOException ex) {
            pdocXLS = null;
            Logger.getLogger(ExcelDocumentXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ExcelDocumentXLS(InputStream file) {
        super(file);
        try {
            pdocXLS = new HSSFWorkbook(pInputStream);
        } catch (IOException ex) {
            pdocXLS = null;
            Logger.getLogger(ExcelDocumentXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Sheet> getListPages() {
        List<Sheet> resultlist = new ArrayList<>();
        for (int i = 0; i < pdocXLS.getNumberOfSheets(); i++) {
            resultlist.add(pdocXLS.getSheetAt(i));
        }
        return resultlist;
    }

    @Override
    public void write() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
