/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.glob;

import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ImportUserTO {

    private String password;
    private String confirmPwd;
    private String customerId;
    private String moduleId;
    private String functionId;
    private String labId;
    
    private List<UserInformationDef> users;

    public ImportUserTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public List<UserInformationDef> getUsers() {
        return users;
    }

    public void setUsers(List<UserInformationDef> users) {
        this.users = users;
    }

}
