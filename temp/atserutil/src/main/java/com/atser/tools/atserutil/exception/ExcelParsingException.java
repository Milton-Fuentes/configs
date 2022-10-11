package com.atser.tools.atserutil.exception;

/**
 * Created by dropal.
 */
public class ExcelParsingException extends Exception {

    public ExcelParsingException(String message) {
        super(message);
    }

    public ExcelParsingException(String message, Exception exception) {
        super(message, exception);
    }
}
