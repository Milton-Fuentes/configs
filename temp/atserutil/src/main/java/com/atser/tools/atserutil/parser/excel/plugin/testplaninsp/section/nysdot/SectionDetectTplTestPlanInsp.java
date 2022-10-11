/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.section.nysdot;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 3, end = 3)
public class SectionDetectTplTestPlanInsp {

    @ExcelField(position = 2)
    private String lineItem;
    @ExcelField(position = 3)
    private String itemCode;
    @ExcelField(position = 4)
    private String itemDescription;
    @ExcelField(position = 8)
    private String unitOfMeasure;
    @ExcelField(position = 9)
    private String unitPrice;
    @ExcelField(position = 10)
    private String contractQuantity;
    @ExcelField(position = 12)
    private String reportedQuantity;
    @ExcelField(position = 13)
    private String totalQtyUsedToDate;
    @ExcelField(position = 15)
    private String totalUsedToDate;

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getContractQuantity() {
        return contractQuantity;
    }

    public void setContractQuantity(String contractQuantity) {
        this.contractQuantity = contractQuantity;
    }

    public String getReportedQuantity() {
        return reportedQuantity;
    }

    public void setReportedQuantity(String reportedQuantity) {
        this.reportedQuantity = reportedQuantity;
    }

    public String getTotalQtyUsedToDate() {
        return totalQtyUsedToDate;
    }

    public void setTotalQtyUsedToDate(String totalQtyUsedToDate) {
        this.totalQtyUsedToDate = totalQtyUsedToDate;
    }

    public String getTotalUsedToDate() {
        return totalUsedToDate;
    }

    public void setTotalUsedToDate(String totalUsedToDate) {
        this.totalUsedToDate = totalUsedToDate;
    }

    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        int count = 1;
        for (Field it : this.getClass().getDeclaredFields()) {
            if (it.get(this) == null) {
                return Boolean.FALSE;
            } else if (!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
            if (count++ == 6) {
                return Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }
}
