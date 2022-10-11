/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.glob;

import com.atser.tools.atserutil.jackson.deserializer.JsonAtserLinkedHashMapDeserialize;
import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.atser.tools.atserutil.objects.pojo.IDefParamValidation;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author droldan
 */
public class GlobRequirementLogSearchDefParam extends DefaultDefParam implements IDefParamValidation {

    public String userId;
    public String currentRole;
    public String clientId;
    public String projectId;
    public String categoryId;
    public String classificationId;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllDateActive;
    public String startDate;
    public String endDate;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllDateVerificationActive;
    public String startDateVerification;
    public String endDateVerification;
    public String themeCompany;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAdmin;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean showInactive;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean multiproject;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean useGlobalProfiles;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean usesRoleMatrix;
    @JsonDeserialize(using = JsonAtserLinkedHashMapDeserialize.class)
    public AtserLinkedHashMap<String, Object> statusMap;

    @Override
    public Boolean isDataValid() {
        if ((startIndex == null || startIndex < 0) || (maxResults == null || maxResults < 0)
                || StringSupport.isNullOrEmpty(userId, currentRole, clientId, dt)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean isReportValid() {
        if (StringSupport.isNullOrEmpty(userId, currentRole, clientId, dt, docType, printType, reportId, functionId, themeCompany)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
