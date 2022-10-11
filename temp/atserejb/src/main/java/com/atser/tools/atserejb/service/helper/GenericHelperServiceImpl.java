/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserejb.model.GlobLogos;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobLogosService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.service.glob.GlobFileTkService;
import com.atser.tools.atserejb.service.glob.GlobWorkorderService;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITToken;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GenericHelperServiceImpl implements GenericHelperService, IBaseEJBException {

    @Inject
    private GlobLogosService logoService;

    @Inject
    private GlobFileTkService globFileTkService;

    @Inject
    private GlobWorkorderService globWorkorderService;

    /**
     * Generate ProjectLogo
     *
     * @param project
     * @return
     */
    @Override
    public BufferedImage getProjectLogo(GlobProject project) {
        if (project == null) {
            return null;
        }
        return getProjectLogo(NumberSupport.getBigInteger(project.getClientId().getId().toString()), project.getId().toBigInteger());
    }

    @Override
    public BufferedImage getProjectLogo(String clientId, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId, projectId)) {
            return null;
        }
        return getProjectLogo(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(projectId));
    }

    @Override
    public BufferedImage getProjectLogo(BigInteger clientId, BigInteger projectId) {
        List<GlobLogos> listPLogo = logoService.findSystemLogoByFilter(clientId, projectId, null, null, null, null, null);
        //Get Project Logo
        GlobLogos projectLogo = null;
        BufferedImage projectLogoImage = null;
        if (listPLogo != null && listPLogo.size() > 0) {
            projectLogo = listPLogo.get(0);
        }
        if (Objects.nonNull(projectLogo)) {
            try {
                projectLogoImage = ImageSupport.convertByteArrayToBufferedImage(projectLogo.getLogo());
            } catch (IOException ex) {
                projectLogoImage = null;
                Logger.getLogger(GenericHelperServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return projectLogoImage;
    }

    @Override
    public BufferedImage getClientLogo(BigInteger clientId) {
        List<GlobLogos> listPLogo = logoService.findSystemLogoByFilter(clientId, null, null, null, null, null, null);
        //Get Client Logo
        GlobLogos clientLogo = null;
        BufferedImage logoImage = null;
        if (listPLogo != null && listPLogo.size() > 0) {
            clientLogo = listPLogo.get(0);
        }
        if (Objects.nonNull(clientLogo)) {
            try {
                logoImage = ImageSupport.convertByteArrayToBufferedImage(clientLogo.getLogo());
            } catch (IOException ex) {
                logoImage = null;
                Logger.getLogger(GenericHelperServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return logoImage;
    }

    @Override
    public BufferedImage getClientLogo(String clientId) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            return null;
        }
        return getClientLogo(NumberSupport.getBigInteger(clientId));
    }

    @Override
    public BufferedImage getClientLogo(GlobProject project) {
        if (project == null) {
            return null;
        }
        return getClientLogo(NumberSupport.getBigInteger(project.getClientId().getId().toString()));
    }

    @Override
    public Boolean isTokenValid(ManageITToken token) {
        if (token == null) {
            return Boolean.FALSE;
        }
        switch (token.getType()) {
            case "file": {
                return globFileTkService.validateTokenAndGetFileId(token.getToken()).isPresent();
            }
            case "workorder": {
                return globWorkorderService.validateWoToken(token.getToken());
            }
        }
        return Boolean.FALSE;
    }

}
