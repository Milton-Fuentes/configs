/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.plan;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.PlanProjects;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface PlanProjectsService extends ICrudService<BigDecimal, PlanProjects> {

    List<DataSelectWrapper> getAllPlanProjectsForSelect(ManageITBodyRequest request);

    ProjectBO toProjectBO(PlanProjects project);
}
