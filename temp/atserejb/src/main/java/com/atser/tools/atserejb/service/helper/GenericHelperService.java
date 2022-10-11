/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITToken;
import java.awt.image.BufferedImage;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GenericHelperService {

    BufferedImage getProjectLogo(GlobProject project);

    BufferedImage getProjectLogo(BigInteger clientId, BigInteger projectId);

    BufferedImage getProjectLogo(String clientId, String projectId);

    BufferedImage getClientLogo(GlobProject project);

    BufferedImage getClientLogo(BigInteger clientId);

    BufferedImage getClientLogo(String clientId);

    Boolean isTokenValid(ManageITToken token);
}
