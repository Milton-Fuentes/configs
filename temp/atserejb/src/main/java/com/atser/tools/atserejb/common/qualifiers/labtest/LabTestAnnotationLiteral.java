/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.qualifiers.labtest;

import com.atser.tools.atserutil.enumerator.eLabSpecification;
import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author droldan
 */
public class LabTestAnnotationLiteral extends AnnotationLiteral<LabTest> implements LabTest {

    private eLabSpecification type;

    private LabTestAnnotationLiteral(eLabSpecification type) {
        this.type = type;
    }

    @Override
    public eLabSpecification type() {
        return type;
    }

    public static LabTestAnnotationLiteral test(eLabSpecification type) {
        return new LabTestAnnotationLiteral(type);
    }

}
