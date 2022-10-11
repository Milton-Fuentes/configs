/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobPortfolioBktDao;
import com.atser.tools.atserejb.model.GlobPortfolioBkt;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.PlanProjects;
import com.atser.tools.atserejb.service.plan.PlanProjectsService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobPortfolioBktServiceImpl implements GlobPortfolioBktService, IBaseEJBException {

    @Inject
    private GlobPortfolioBktDao dao;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private PlanProjectsService planProjectsService;

    @Override
    public GlobPortfolioBkt findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobPortfolioBkt findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobPortfolioBkt elem) {
        if (elem != null) {
            if (elem.getPortfolioId() == null || elem.getProjectId() == null || StringSupport.isNullOrEmpty(elem.getProjectType())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
            }
            if (dao.exists(elem.getPortfolioId(), elem.getProjectId(), elem.getProjectType())) {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "This relation already exists !");
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void saveList(ManageITHeader header, GlobPortfolioBkt elem) {
        if (elem != null) {
            if (elem.getProgramId() == null || elem.getProjectList() == null || elem.getProjectList().isEmpty() || StringSupport.isNullOrEmpty(elem.getProjectType())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
            }
            if (elem.getProjectList().size() == 1 && elem.getProjectList().contains(new BigInteger("-1"))) {
                if (elem.getProjectType().equals("construction_design")) {
                    saveAllGlobProjectByProgram(header, elem);
                } else if (elem.getProjectType().equals("plan_project")) {
                    saveAllPlanProjectByProgram(header, elem);
                }
            } else {
                elem.getProjectList().forEach(it -> {
                    if (!it.equals(new BigInteger("-1"))) {
                        saveGlobPortfolioBkt(header, elem, it);
                    }
                });
            }
        }
    }

    private void saveAllGlobProjectByProgram(ManageITHeader header, GlobPortfolioBkt elem) {
        List<GlobProject> projectList = globProjectService.list(new ManageITBodyRequest(0, 0).filter("active", "Y").filter("programId", elem.getProgramId()).filter("clientId.id", NumberSupport.getBigDecimal(header.getClientid())));
        if (projectList != null && !projectList.isEmpty()) {
            projectList.forEach(it -> {
                saveGlobPortfolioBkt(header, elem, it.getId().toBigInteger());
            });
        }
    }

    private void saveAllPlanProjectByProgram(ManageITHeader header, GlobPortfolioBkt elem) {
        List<PlanProjects> projectList = planProjectsService.list(new ManageITBodyRequest(0, 0).filter("projectProgId", elem.getProgramId()).filter("clientId", NumberSupport.getBigInteger(header.getClientid())));
        if (projectList != null && !projectList.isEmpty()) {
            projectList.forEach(it -> {
                saveGlobPortfolioBkt(header, elem, it.getId().toBigInteger());
            });
        }
    }

    private void saveGlobPortfolioBkt(ManageITHeader header, GlobPortfolioBkt elem, BigInteger projectId) {
        GlobPortfolioBkt item = new GlobPortfolioBkt();
        item.setPortfolioId(elem.getPortfolioId());
        item.setProjectId(projectId);
        item.setProjectType(elem.getProjectType());
        item.setCreated(new Date());
        item.setCreatedBy(header.getUserid());
        item.setCreatedByIp(header.getModIp());
        item.setLastMod(new Date());
        item.setLastModBy(header.getUserid());
        item.setLastModIp(header.getModIp());
        item.setActive('Y');
        item.setDeleted('N');
        if (!dao.exists(item.getPortfolioId(), item.getProjectId(), item.getProjectType())) {
            dao.save(item);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobPortfolioBkt elem) {
        if (elem != null) {
            GlobPortfolioBkt model = findById(elem.getId());
            if (!model.equals(elem)) {
                if (dao.exists(elem.getPortfolioId(), elem.getProjectId(), elem.getProjectType())) {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "This relation already exists !");
                }
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobPortfolioBkt populate(GlobPortfolioBkt model, GlobPortfolioBkt elem) {
        model.setPortfolioId(elem.getPortfolioId());
        model.setProjectId(elem.getProjectId());
        model.setProjectType(elem.getProjectType());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobPortfolioBkt> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobPortfolioBkt> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobPortfolioBkt> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public DataGridWrapper<GlobPortfolioBkt> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public Boolean exists(BigInteger portfolioId, BigInteger projectId, String projectType) {
        return dao.exists(portfolioId, projectId, projectType);
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
