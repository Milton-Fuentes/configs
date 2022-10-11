/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.document;

import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.atser.tools.atserutil.objects.pojo.IDefParamValidation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author dperez
 */
public class DocumentSearchDefParam extends DefaultDefParam implements IDefParamValidation {

    public String folderId;
    public String clientId;
    public String projectId;
    public String userId;
    public String currentRole;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean isAdmin;

    @Override
    public Boolean isDataValid() {
        return true;
    }

    @Override
    public Boolean isReportValid() {
        return true;
    }

}
