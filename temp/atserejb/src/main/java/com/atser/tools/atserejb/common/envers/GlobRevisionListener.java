/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.envers;

import com.atser.tools.atserejb.model.GlobRevInfo;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import org.hibernate.envers.RevisionListener;

/**
 *
 * @author droldan
 */
public class GlobRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        GlobRevInfo revInfo = (GlobRevInfo) revisionEntity;
        ManageITHeader currentInfo = CurrentUser.INSTANCE.get();
        if (currentInfo != null) {
            revInfo.setUsername(currentInfo.getUser());
            revInfo.setRole(currentInfo.getRole());
            revInfo.setModip(currentInfo.getModIp());
        }
    }
}
