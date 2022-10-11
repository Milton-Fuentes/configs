/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.read.pdf;

import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.file.DetectMimeType;
import com.atser.tools.atserutil.file.FileSupport;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author dperez
 */
public class PdfContext {

    private PdfDocument pPdfDoc;
    private DetectMimeType pmimeType;

    public PdfContext(String file) throws FileNotFoundException, FormatDocumentNotAllowedException {
        File cFile = new File(file);
        pmimeType = new DetectMimeType();
        pmimeType.populateMimePdf();
        String mime = FileSupport.getFileTypeMime(cFile);
        if (mime.equals("-1")) {
            throw new FileNotFoundException();
        }
        if (!pmimeType.isMimeAllowed(mime)) {
            throw new FormatDocumentNotAllowedException("Document format not allowed.");
        }
        pPdfDoc = new PdfDocument(cFile);
    }

    public PdfContext(File file) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        pmimeType = new DetectMimeType();
        pmimeType.populateMimePdf();
        String mime = FileSupport.getFileTypeMime(file);
        if (mime.equals("-1")) {
            throw new FileNotFoundException();
        }
        if (!pmimeType.isMimeAllowed(mime)) {
            throw new FormatDocumentNotAllowedException("Document format not allowed.");
        }
        pPdfDoc = new PdfDocument(file);
    }

    public PdfDocument getpPdfDoc() {
        return pPdfDoc;
    }

}
