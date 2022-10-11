/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception;

/**
 *
 * @author droldan
 */
public class NotFoundMimeTypeException extends Exception {

    public NotFoundMimeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundMimeTypeException(String message) {
        super(message);
    }
}
