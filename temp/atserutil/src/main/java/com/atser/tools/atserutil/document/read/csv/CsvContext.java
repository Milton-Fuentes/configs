/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.read.csv;

import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.file.DetectMimeType;
import com.atser.tools.atserutil.file.FileSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;

/**
 *
 * @author droldan
 */
public class CsvContext {

    private CsvDocument pCsvDoc;
    private DetectMimeType pmimeType;

    public CsvContext(File file) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        pmimeType = new DetectMimeType();
        pmimeType.populateMimeCsv();
        String mime = FileSupport.getFileTypeMime(file);
        if (mime.equals("-1")) {
            throw new FileNotFoundException();
        }
        if (!pmimeType.isMimeAllowed(mime)) {
            throw new FormatDocumentNotAllowedException("Document format not allowed.");
        }
        pCsvDoc = new CsvDocument(file);
    }

    public CsvContext(Reader reader) {
        pCsvDoc = new CsvDocument(reader);
    }

    public CsvDocument getpCsvDoc() {
        return pCsvDoc;
    }

}
