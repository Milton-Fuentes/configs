package com.atser.tools.atserutil.document.read.excel;

import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.List;

/**
 * Created by dropal on 19/08/2015.
 */
public abstract class ExcelDocument {

    protected InputStream pInputStream;
    protected FileOutputStream pOutputStream;

    public ExcelDocument(File file) throws FileNotFoundException {
        this.pInputStream = new FileInputStream(file);
    }

    public ExcelDocument(InputStream file) {
        this.pInputStream = file;
    }

    public void closeInput() throws IOException {
        if (pInputStream != null) {
            pInputStream.close();
        }
    }

    public void closeOutput() throws IOException {
        if (pOutputStream != null) {
            pOutputStream.flush();
            pOutputStream.close();
        }
    }

    public void buildOutputDocument(File file) throws FileNotFoundException {
        this.pOutputStream = new FileOutputStream(file);
    }

    public abstract List<Sheet> getListPages();

    public abstract void write() throws IOException;
}
