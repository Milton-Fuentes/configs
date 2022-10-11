/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.qa;

import java.math.BigInteger;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mfuentes
 */
@NoArgsConstructor
@Getter
@Setter
public class QaSampleTestFailureLogBO {

    private BigInteger sampleTestId;
    private BigInteger projectId;
    private String projectName;
    private String projectNumber;
    private String projectDescription;
    private String workOrderNo;
    private String technician;
    private String serviceDate;
    private String testName;
    private String workInspected;
    private String materialUnderRequirements;
    private String materialMetRequirements;
    private String observations;
}
