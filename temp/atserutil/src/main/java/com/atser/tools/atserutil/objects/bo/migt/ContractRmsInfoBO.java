/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.migt;

import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class ContractRmsInfoBO implements Serializable{

    private Long id;
    private String contractNo;
    private String itemNo;
    private String itemType;
    private String itemDescription;
    private String itemBidQuantity;
    private String itemProjectedQuantity;
    private String itemQtd;
    private String unitOfMeasurement;
    private String status;
    private String rejectReason;
    private Long oClientId;
    private Long oProjectId;
    private Long oTestPlanId;
    private Long oItemId;
    private Boolean oTestPlanApv;
    private Long totalItem;
    private Boolean wbs;
    private String projectType;

    public ContractRmsInfoBO() {
    }

    public ContractRmsInfoBO(String itemNo, String itemType, String itemDescription) {
        this.itemNo = itemNo;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemBidQuantity() {
        return itemBidQuantity;
    }

    public void setItemBidQuantity(String itemBidQuantity) {
        this.itemBidQuantity = itemBidQuantity;
    }

    public String getItemProjectedQuantity() {
        return itemProjectedQuantity;
    }

    public void setItemProjectedQuantity(String itemProjectedQuantity) {
        this.itemProjectedQuantity = itemProjectedQuantity;
    }

    public String getItemQtd() {
        return itemQtd;
    }

    public void setItemQtd(String itemQtd) {
        this.itemQtd = itemQtd;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getoClientId() {
        return oClientId;
    }

    public void setoClientId(Long oClientId) {
        this.oClientId = oClientId;
    }

    public Long getoProjectId() {
        return oProjectId;
    }

    public void setoProjectId(Long oProjectId) {
        this.oProjectId = oProjectId;
    }

    public Long getoTestPlanId() {
        return oTestPlanId;
    }

    public void setoTestPlanId(Long oTestPlanId) {
        this.oTestPlanId = oTestPlanId;
    }

    public Long getoItemId() {
        return oItemId;
    }

    public void setoItemId(Long oItemId) {
        this.oItemId = oItemId;
    }

    public Boolean getoTestPlanApv() {
        return oTestPlanApv;
    }

    public void setoTestPlanApv(Boolean oTestPlanApv) {
        this.oTestPlanApv = oTestPlanApv;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public Boolean getWbs() {
        return wbs;
    }

    public void setWbs(Boolean wbs) {
        this.wbs = wbs;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    
    @Override
    public String toString() {
        return status;
    }

}
