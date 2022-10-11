/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.qualifiers.inspection;

import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author droldan
 */
public class InspectionTestAnnotationLiteral extends AnnotationLiteral<InspectionTest> implements InspectionTest {

    private String type;

    public InspectionTestAnnotationLiteral(String type) {
        this.type = type;
    }

    @Override
    public String type() {
        return type;
    }
}
