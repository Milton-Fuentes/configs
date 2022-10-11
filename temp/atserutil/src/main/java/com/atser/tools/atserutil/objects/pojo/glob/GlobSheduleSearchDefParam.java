/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.glob;

import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author droldan
 */
public class GlobSheduleSearchDefParam extends DefaultDefParam {

    public String clientId;
    public String projectId;
    public String CurrentDate;
    public String CurrentView;
    public String CurrentAction;
    public String labLocationId;
    public String regionId;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isEnableCancelWo;
    public String isWoCompleted;
    public String trackEmailStatus;
    public String serviceList;
    public String reqStatus;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isEnablePendingWoReports;
    public String resourceFilter;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isEnableSentReports;
}
