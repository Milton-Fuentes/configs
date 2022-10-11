/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.inspection;

import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionContractInfoPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionHeaderPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionSignaturePojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionPrecaststressPojo;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
public class QaInspectionPrecaststressTO extends QaInspectionReportTO {

    private InspectionPrecaststressPojo precastInfo;
    private String itemDetermination;
    private Map<String, InspectionSignaturePojo> signatureList;

    public QaInspectionPrecaststressTO() {
        super();
        signatureList = new HashMap<>();
    }

    public QaInspectionPrecaststressTO(InspectionHeaderPojo header, InspectionContractInfoPojo contractInfo) {
        super(header, contractInfo);
        signatureList = new HashMap<>();
    }

    public void addInspectionSignaturePojo(String key, InspectionSignaturePojo value) {
        if (signatureList != null && StringSupport.isNotNullAndNotEmpty(key) && value != null) {
            this.signatureList.put(key, value);
        }
    }
}
