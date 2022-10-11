/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.cm;

import java.io.Serializable;
import java.math.BigInteger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class CmFormRFIBO implements Serializable{

    private BigInteger id;
    private String rfiNo;
    private String location;
    private String rfiDate;
    private String generatedBy;
    private String specNo;
    private String drawNo;
    private String rfiQuestion;
    private Character responseCode;
    private String dateResponseRequired;
    private String response;
    private String responseBy;
    private String dateReceived;
    private String responderName;
    private String responderFirm;
    private String dateToDesignConsultant;
    private String dateFromDesignConsultant;
    private String dateResponded;
    private String reviewRequired;
    private String responseFinal;
    private String submitTo;
    private Character status;
}
