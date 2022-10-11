/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa;

import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;

/**
 *
 * @author droldan
 */
public class QaInspectionSearchDefParam extends DefaultDefParam {

    public String userId;
    public String currentRole;
    public String clientId;
    public String projectId;
    public String regionId;
    public String startDate;
    public String endDate;
    public String themeCompany;
    public boolean isAdmin;
    public boolean showInactive;
    public boolean multiproject;
    public boolean isAllDateActive;
    public boolean useGlobalProfiles;
    public boolean usesRoleMatrix;
    public AtserLinkedHashMap<String, Object> statusMap;
}
