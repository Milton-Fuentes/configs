/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.common.objects.to.GlobProjectInfoTO;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobProjectService extends ICrudService<BigDecimal, GlobProject> {

    void save(GlobProject elem);

    void saveTo(ManageITHeader header, GlobProjectInfoTO elem);

    void update(GlobProject elem);

    public void updateTo(ManageITHeader header, GlobProjectInfoTO data);

    Long getTotal(ManageITBodyRequest request);

    BigDecimal findIdByClientAndPNumber(String clientId, String contractNo);

    void changeStatus(ManageITBodyRequest request);

    List<Object[]> getProjectListInLab(BigInteger clientId);

    List<DataSelectWrapper> getProjectListInLabForSelect(BigInteger clientId);

    Object getFrontEndProjectListByCurrentProfile(ManageITHeader header, ManageITBodyRequest body);

    List<ProjectBO> getProjectListByCurrentProfile(String userId, String clientId, String currentRole, AtserLinkedHashMap<String, Object> params);

    Object getFrontEndProjectListByFunctionProfile(ManageITHeader header, ManageITBodyRequest<Object> body);

    Map<String, Object> getProjectDetails(String id);

    List<DataSelectWrapper> getAllProjectsForSelect(ManageITBodyRequest request);

    ProjectBO toProjectBO(GlobProject project);

    Boolean exists(String clientId, String pNumberCode, Boolean useProjectCode);    
    

}
