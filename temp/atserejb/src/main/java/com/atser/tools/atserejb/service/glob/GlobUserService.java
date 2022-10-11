/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.to.glob.ImportUserTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface GlobUserService {

    GlobUsers findById(String id);

    GlobUsers findById(BigDecimal id);

    void save(ManageITHeader header, GlobUsers elem);

    void update(ManageITHeader header, GlobUsers elem);

    void delete(String id);

    List<GlobUsers> list(ManageITBodyRequest request);

    String generateExcelTemplate(String paramClientId, String tplbasePath, String docpathsegment);

    List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportUserTO data, BonitaBpmSupport bpmSession);

    Boolean existByUserName(String username);

    GlobUsers authUser(String username, String pwd);

    void unlockUserAccounts();

    String getUserEmail(BigDecimal userId);
}
