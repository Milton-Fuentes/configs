/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.inspection;

import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionContractInfoPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionHeaderPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionNotUnusedVerifPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionSignaturePojo;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionUnusedItemPojo;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
public class QaInspectionNotunusedTO extends QaInspectionReportTO {

    private InspectionNotUnusedVerifPojo verifInfo;
    private List<InspectionUnusedItemPojo> unusedItemList;
    private String itemDetermination;
    private Map<String, InspectionSignaturePojo> signatureList;

    public QaInspectionNotunusedTO() {
        super();
        unusedItemList = new ArrayList<>();
        signatureList = new HashMap<>();
    }

    public QaInspectionNotunusedTO(InspectionHeaderPojo header, InspectionContractInfoPojo contractInfo) {
        super(header, contractInfo);
        unusedItemList = new ArrayList<>();
        signatureList = new HashMap<>();
    }

    public void addInspectionUnusedItemPojo(InspectionUnusedItemPojo item) {
        if (this.unusedItemList != null && item != null) {
            this.unusedItemList.add(item);
        }
    }

    public void addInspectionSignaturePojo(String key, InspectionSignaturePojo value) {
        if (signatureList != null && StringSupport.isNotNullAndNotEmpty(key) && value != null) {
            this.signatureList.put(key, value);
        }
    }

}
