/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception;

/**
 *
 * @author droldan
 */
public class EmptyDocumentException extends Exception {

    public EmptyDocumentException(String message) {
        super(message);
    }

    public EmptyDocumentException(String message, Exception exception) {
        super(message, exception);
    }
}
