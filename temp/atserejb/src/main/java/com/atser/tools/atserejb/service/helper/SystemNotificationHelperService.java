/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface SystemNotificationHelperService {

    void notify(ManageITHeader header, TemplateEngine engine, SystemMessage notf);

    void notify(ManageITHeader header, TemplateEngine engine, SystemMessage notf, String templateCode);
}
