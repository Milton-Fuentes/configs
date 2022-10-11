package com.atser.tools.atserutil.document.read.excel;

import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.file.DetectMimeType;
import com.atser.tools.atserutil.file.FileSupport;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by dropal.
 */
public class ExcelContext {

    private ExcelDocument pExcelDoc;
    private DetectMimeType pmimeType;

    public ExcelContext(File file) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        pmimeType = new DetectMimeType();
        pmimeType.populateMimeExcel();
        String mime = FileSupport.getFileTypeMime(file);
        if (mime.equals("-1")) {
            throw new FileNotFoundException();
        }
        if (!pmimeType.isMimeAllowed(mime)) {
            throw new FormatDocumentNotAllowedException("Document format not allowed.");
        }
        InitializeExcelDocument(pmimeType.getMimeExtension(mime), file);
    }

    private void InitializeExcelDocument(String ext, File file) throws FileNotFoundException {
        if (ext.equalsIgnoreCase("xls")) {
            pExcelDoc = new ExcelDocumentXLS(file);
        } else if (ext.equalsIgnoreCase("xlsx") || ext.equalsIgnoreCase("xlsm")) {
            pExcelDoc = new ExcelDocumentXLSX(file);
        }
    }

    public ExcelDocument getPExcelDoc() {
        return pExcelDoc;
    }
}
