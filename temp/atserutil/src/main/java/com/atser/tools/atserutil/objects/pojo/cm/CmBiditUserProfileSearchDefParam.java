/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.cm;

import com.atser.tools.atserutil.jackson.deserializer.JsonAtserLinkedHashMapDeserialize;
import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author droldan
 */
public class CmBiditUserProfileSearchDefParam extends DefaultDefParam {

    public String userId;
    public String currentRole;
    public String clientId;
    public String companyId;
    public String startDate;
    public String endDate;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllDateActive = false;
    public String bidStartIssueDate;
    public String bidEndIssueDate;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllBidIssueDateActive = false;
    public String bidStartClosingDate;
    public String bidEndClosingDate;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllBidClosingDate = false;
    public String bidStartPublishDate;
    public String bidEndPublishDate;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAllBidPublishDate = false;
    public String themeCompany;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean bidPublished = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean bidClosed = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAdmin = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean showInactive = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean multiproject = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean useGlobalProfiles = false;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean usesRoleMatrix = false;
    @JsonDeserialize(using = JsonAtserLinkedHashMapDeserialize.class)
    public AtserLinkedHashMap<String, Object> statusMap;
}
