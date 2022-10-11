/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.read.pdf;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author dperez
 */
public class PdfDocument {

    private File filePdf;

    public PdfDocument(File filePdf) {
        this.filePdf = filePdf;
    }

    public File getFilePdf() {
        return filePdf;
    }

    public void setFilePdf(File filePdf) {
        this.filePdf = filePdf;
    }
    
    public Integer getTotalPages() throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(filePdf);
        return doc.getNumberOfPages();
    }

}
