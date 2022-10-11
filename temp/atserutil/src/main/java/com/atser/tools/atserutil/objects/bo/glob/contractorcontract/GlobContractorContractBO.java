/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.contractorcontract;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public class GlobContractorContractBO {

    private BigInteger projectId;
    private BigInteger masterlabId;
    private List<BigInteger> functionIdList;

    public GlobContractorContractBO() {
    }

    public GlobContractorContractBO(BigInteger projectId, BigInteger masterlabId, List<BigInteger> functionIdList) {
        this.projectId = projectId;
        this.masterlabId = masterlabId;
        this.functionIdList = functionIdList;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getMasterlabId() {
        return masterlabId;
    }

    public void setMasterlabId(BigInteger masterlabId) {
        this.masterlabId = masterlabId;
    }

    public List<BigInteger> getFunctionIdList() {
        return functionIdList;
    }

    public void setFunctionIdList(List<BigInteger> functionIdList) {
        this.functionIdList = functionIdList;
    }
}
