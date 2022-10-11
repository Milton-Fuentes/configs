/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectDao extends ICrudDao<BigDecimal, GlobProject>{
    
    BigDecimal findIdByClientAndPNumber(BigDecimal clientId, String contractNo);
    
    /**
     * Get Project List in Lab
     *
     * @param clientId
     * @return [ID, PROJECT_NO, PROJECT_NAME]
     */
    List<Object[]> getProjectListInLab(BigInteger clientId);

    List<ProjectBO> getFrontEndProjectListByCurrentProfile(String userId, String clientId, String currentRole, boolean isAdmin, boolean multiproject, boolean project_uses_multiple_location, boolean uses_global_profiles, boolean ProjectSetup, boolean uses_allow_readonly_labs, String status);
    
    /* Methods to Build Native Queries*/
    String filterByProfile(String parentFieldFilter, boolean isAdmin, boolean usesGlobalProfiles, String clientId, String userId);

    List<GlobProject> getFrontEndProjectListByFunctionProfile(String userId, String clientId, boolean isAdmin, boolean uses_global_profiles, String functionId, String projectClientId);

    public Boolean exists(String clientId, String pNumberCode, Boolean useProjectCode);
    
}
