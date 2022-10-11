/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobNotfUser;
import com.atser.tools.atserejb.model.GlobNotfUserModel;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface GlobNotfUserService {

    GlobNotfUser findById(String id);

    void save(GlobNotfUser elem);
    
    void update(GlobNotfUser elem);

    void delete(String id);

    List<GlobNotfUser> list(ManageITBodyRequest request);

    List<GlobNotfUserModel> findAllUserModelInPendingStatus(String module, String functionality, BigInteger clientId, BigInteger userId);
    
    BpmMailMessage getPackMailMessageByUser(TemplateEngine engine, String module, String functionality, BigInteger clientId, BigInteger userId, String email, String subject, String emailFrom);
    
    void updateUserModelStatus(String module, String functionality, BigInteger clientId, BigInteger userId);
}
