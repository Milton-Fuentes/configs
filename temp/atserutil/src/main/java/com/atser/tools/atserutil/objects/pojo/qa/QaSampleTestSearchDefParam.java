/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa;

import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.atser.tools.atserutil.objects.pojo.IDefParamValidation;
import com.atser.tools.atserutil.string.StringSupport;

/**
 *
 * @author droldan
 */
public class QaSampleTestSearchDefParam extends DefaultDefParam implements IDefParamValidation {

    public String userId;
    public String currentRole;
    public String clientId;
    public String projectId;
    public String testId;
    public String functionId;
    public String startDate;
    public String endDate;
    public String themeCompany;
    public String labLocationId;
    public String category;
    public String sampleMatCodeId;
    public String sampleMaterialUseId;
    public String sampleRandomCode;
    public boolean isAdmin;
    public boolean multiproject;
    public boolean usesWorkorder;
    public boolean isAllDateActive;
    public boolean showInactive;
    public boolean showLabReportno;
    public boolean usesContractorReportSequence;
    public boolean useGlobalProfiles;
    public boolean usesRoleMatrix;
    public boolean usesReviewerShowUnapproved;
    public boolean testViewUnacknowledged;
    public boolean testlogShowacknowledgeByproject;
    public boolean testlogShowacknowledge;
    public boolean testlogShowstateengineer;
    public boolean showMaterialuse;
    public boolean showDistributionHold;
    public boolean useDistributionHold;
    public AtserLinkedHashMap<String, Object> statusMap;

    @Override
    public Boolean isDataValid() {
        if ((startIndex == null || startIndex < 0) || (maxResults == null || maxResults < 0)
                || StringSupport.isNullOrEmpty(userId, currentRole, clientId, dt, themeCompany, projectId)) {
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
