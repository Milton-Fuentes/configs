/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.atser.tools.atserutil.exception;

/**
 *
 * @author droldan
 */
public class TemplateDifferentException extends Exception {

    public TemplateDifferentException(String message) {
        super(message);
    }

    public TemplateDifferentException(String message, Exception exception) {
        super(message, exception);
    }
}