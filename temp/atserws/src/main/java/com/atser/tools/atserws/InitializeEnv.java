/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws;

import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.ws.WsAppOauthService;
import com.atser.tools.atserejb.service.ws.WsOauthService;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.bpm.BpmConfiguration;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.common.WSProperties;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.engine.exception.BonitaException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

/**
 *
 * @author droldan
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Slf4j
public class InitializeEnv {

    private TemplateEngine emailTplEngine;
    private Map<String, String> propertiesMap;
    private Boolean notification_bpm_track_enable;
    private Map<String, File> jasperMap;
    private String defaultUploadPath;
    private String defaultTplPath;
    private BpmConfiguration bpmConfiguration;
    private BonitaBpmSupport bonitaBpm;

    @EJB
    private WsOauthService wsOauthService;

    @EJB
    private WsAppOauthService wsAppOauthService;

    @EJB
    private GlobUserService globUserService;

    @EJB
    private GlobFileService globFileService;

    @PostConstruct
    private void init() {
        log.info("***** Init WS Env *****");
        propertiesMap = new HashMap<>();
        try {
            for (Object key : WSProperties.getWSProperty().stringPropertyNames()) {
                String value = WSProperties.getWSProperty(key.toString());
                propertiesMap.put(key.toString(), value);
            }
            bpmConfiguration = new BpmConfiguration(StringSupport.getBoolean(propertiesMap.get("bpm_active")), propertiesMap.get("bpm_path"),
                    propertiesMap.get("bpm_context"), propertiesMap.get("bpm_username"), propertiesMap.get("bpm_pwd"));
            defaultUploadPath = propertiesMap.get("upload_drive") + propertiesMap.get("upload_folder");
            defaultTplPath = propertiesMap.get("tpl_drive") + propertiesMap.get("tpl_folder");
            jasperMap = FileSupport.getMapFilesInFolder(new File(defaultTplPath + "/jasper"));
            notification_bpm_track_enable = (propertiesMap.get("notification_bpm_track_enable") == null) ? Boolean.FALSE : Boolean.valueOf(propertiesMap.get("notification_bpm_track_enable"));
            initEmailTemplateEngine();
            cleanTemporalFiles();
        } catch (IOException ex) {
            notification_bpm_track_enable = Boolean.FALSE;
            log.error(ex.getMessage());
        }

        initBpmCtx();
    }

    @PreDestroy
    private void destroy() {
        log.info("***** Destroy WS Sessions *****");
        try {
            cleanTemporalFiles();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        if (bpmConfiguration.getIsEnabled()) {
            bonitaBpm.doTenantLogout();
        }
    }

    @Schedule(hour = "*", minute = "*/30", persistent = false)
    public void verifyOauthToken() {
        wsOauthService.verifyAccessToken();
    }

    @Schedule(hour = "*", minute = "*/35", persistent = false)
    public void unlockUserAccounts() {
        globUserService.unlockUserAccounts();
    }

    @Schedule(hour = "*", minute = "*/25", persistent = false)
    public void verifyAppOauthToken() {
        wsAppOauthService.verifyAccessToken();
    }

    @Schedule(hour = "*", minute = "*/3", persistent = false)
    public void refreshBPMSession() {
        if (bpmConfiguration.getIsEnabled()) {
            bonitaBpm.refreshBonitaBpmSession();
        }
    }

    @Schedule(hour = "*", minute = "*/10", persistent = false)
    public void unlockFiles() {
        globFileService.unlockFile(null);
    }

    private void cleanTemporalFiles() throws IOException {
        String docpathsegment = getPropertiesMap().get("upload_drive") + getPropertiesMap().get("upload_folder") + "/temporal/";
        FileSupport.cleanDirectory(new File(docpathsegment));
    }

    /**
     * Connect to BPM Server
     */
    public void initBpmCtx() {
        if (bpmConfiguration.getIsEnabled()) {
            try {
                bonitaBpm = new BonitaBpmSupport(bpmConfiguration);
            } catch (BonitaException | ConnectException ex) {
                try {
                    bpmConfiguration.setIsEnabled(false);
                    bonitaBpm = new BonitaBpmSupport(bpmConfiguration);
                } catch (BonitaException | ConnectException ex1) {
                    log.error(ex.getMessage());
                }
            }
        }
    }

    /**
     * Load Engine for Email Templates
     */
    private void initEmailTemplateEngine() {
        this.emailTplEngine = new TemplateEngine();
        final FileTemplateResolver emailTplResolver = new FileTemplateResolver();
        emailTplResolver.setOrder(2);
        emailTplResolver.setResolvablePatterns(Collections.singleton("*.html"));
        emailTplResolver.setPrefix(defaultTplPath + "/email" + File.separatorChar);
        emailTplResolver.setSuffix(".html");
        emailTplResolver.setTemplateMode(TemplateMode.HTML);
        emailTplResolver.setCharacterEncoding("UTF-8");
        emailTplResolver.setCacheable(false);
        this.emailTplEngine.addTemplateResolver(emailTplResolver);
    }

    @Lock(LockType.READ)
    public TemplateEngine getEmailTplEngine() {
        return emailTplEngine;
    }

    @Lock(LockType.READ)
    public Map<String, String> getPropertiesMap() {
        return propertiesMap;
    }

    @Lock(LockType.READ)
    public Map<String, File> getJasperMap() {
        return jasperMap;
    }

    @Lock(LockType.READ)
    public BonitaBpmSupport getBonitaBpmSession() {
        return bonitaBpm;
    }

    @Lock(LockType.READ)
    public Boolean isNotification_bpm_track_enable() {
        return notification_bpm_track_enable;
    }

    @Lock(LockType.READ)
    public String getDefaultUploadPath() {
        return defaultUploadPath;
    }

    @Lock(LockType.READ)
    public String getDefaultTplPath() {
        return defaultTplPath;
    }

}
