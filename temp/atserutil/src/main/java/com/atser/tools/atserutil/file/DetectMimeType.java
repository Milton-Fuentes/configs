package com.atser.tools.atserutil.file;


import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dropal.
 */
public class DetectMimeType {
    private Map<String, String> mimehash;

    public DetectMimeType(Map<String, String> mimehash) {
        this.mimehash = mimehash;
    }

    public DetectMimeType() {
        mimehash = new HashMap<>();
    }

    public void registerMimeType(String key,String value) {
        mimehash.put(key,value);
    }

    public void removeMimeType(String key) {
        mimehash.remove(key);
    }

    public void populateMimePdf() {
        mimehash.put("pdf", "application/pdf");
    }
    
    public void populateMimeExcel() {
        mimehash.put("xls", "application/vnd.ms-excel");
        mimehash.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        mimehash.put("xlsm", "application/vnd.ms-excel.sheet.macroenabled.12");
    }
    
    public void populateMimeCsv() {
        mimehash.put("csv", "text/csv");
        mimehash.put("txt", "text/plain");
    }

    public boolean isMimeAllowed(String mime) {
        for (Map.Entry<String, String> entry : mimehash.entrySet()) {
            if (entry.getValue().equals(mime)) {
                return true;
            }
        }
        return false;
    }

    public String getMimeExtension(String mime) throws NotFoundMimeTypeException {
        for (Map.Entry<String, String> entry : mimehash.entrySet()) {
            if (entry.getValue().equals(mime)) {
                return entry.getKey();
            }
        }
        throw new NotFoundMimeTypeException("Not found extension for MimeType: " + mime);
    }
}
