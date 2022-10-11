/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.punchlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class QaPunchDetailTO {

    private String itemNo;
    private String itemDate;
    private String checkedBy;
    private String itemType;
    private String structType;
    private String segment;
    private String detailLocation;
    private String itemDescription;
    private String resolvedDetail;
    private String itemStatus;
    List<QaPunchUpdateTO> qapUpdateList;

    public QaPunchDetailTO() {
        qapUpdateList = new ArrayList<>();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getStructType() {
        return structType;
    }

    public void setStructType(String structType) {
        this.structType = structType;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getResolvedDetail() {
        return resolvedDetail;
    }

    public void setResolvedDetail(String resolvedDetail) {
        this.resolvedDetail = resolvedDetail;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public List<QaPunchUpdateTO> getQapUpdateList() {
        return qapUpdateList;
    }

    public void setQapUpdateList(List<QaPunchUpdateTO> qapUpdateList) {
        this.qapUpdateList = qapUpdateList;
    }

    public void addQaPunchUpdate(QaPunchUpdateTO update) {
        if (update != null) {
            this.qapUpdateList.add(update);
        }

    }
}
