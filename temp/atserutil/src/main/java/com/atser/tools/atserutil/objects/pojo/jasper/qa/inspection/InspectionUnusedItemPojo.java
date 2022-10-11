/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@NoArgsConstructor
public class InspectionUnusedItemPojo {

    private String wbsItemNo;
    private String wbsItemDescription;
    private String itemNo;
    private String itemDescription;
    private String reason;

    public InspectionUnusedItemPojo(String itemNo, String itemDescription, String reason) {
        this.wbsItemNo = null;
        this.wbsItemDescription = null;
        this.itemNo = itemNo;
        this.itemDescription = itemDescription;
        this.reason = reason;
    }

    public InspectionUnusedItemPojo(String wbsItemNo, String wbsItemDescription, String itemNo, String itemDescription, String reason) {
        this.wbsItemNo = wbsItemNo;
        this.wbsItemDescription = wbsItemDescription;
        this.itemNo = itemNo;
        this.itemDescription = itemDescription;
        this.reason = reason;
    }
}
