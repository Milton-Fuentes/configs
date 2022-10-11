package com.atser.tools.atserutil.document.read.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
public class ExcelDocumentXLSX extends ExcelDocument {

    private XSSFWorkbook pdocXLSX;

    public ExcelDocumentXLSX(File file) throws FileNotFoundException {
        super(file);
        try {
            pdocXLSX = new XSSFWorkbook(pInputStream);
        } catch (IOException ex) {
            pdocXLSX = null;
            Logger.getLogger(ExcelDocumentXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ExcelDocumentXLSX(InputStream file) {
        super(file);
        try {
            pdocXLSX = new XSSFWorkbook(pInputStream);
        } catch (IOException ex) {
            pdocXLSX = null;
            Logger.getLogger(ExcelDocumentXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Sheet> getListPages() {
        List<Sheet> resultlist = new ArrayList<>();
        for (int i = 0; i < pdocXLSX.getNumberOfSheets(); i++) {
            resultlist.add(pdocXLSX.getSheetAt(i));
        }
        return resultlist;
    }

    @Override
    public void write() throws IOException {
       pdocXLSX.write(pOutputStream);
    }
}
