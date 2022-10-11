/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.dao.qm.QmClientRoleMatrixDao;
import com.atser.tools.atserejb.model.QmClientRoleMatrix;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QmClientRoleMatrixServiceImpl implements QmClientRoleMatrixService, IBaseEJBException {

    @Inject
    private QmClientRoleMatrixDao dao;

    @Override
    public QmClientRoleMatrix findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QmClientRoleMatrix findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QmClientRoleMatrix elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QmClientRoleMatrix elem) {
        if (elem != null) {
            QmClientRoleMatrix model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QmClientRoleMatrix> list(ManageITBodyRequest request) {
        List<QmClientRoleMatrix> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QmClientRoleMatrix> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QmClientRoleMatrix> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public Boolean hasRoleRigth(ManageITHeader header, Boolean isAdmin, String ruleName) {
        return hasRoleRigth(header.getClientid(), header.getRole(), isAdmin, ruleName);
    }

    @Override
    public Boolean hasRoleRigth(String clientId, String current_role, Boolean isAdmin, String ruleName) {
        if (StringSupport.isNullOrEmpty(clientId, current_role, ruleName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if ((StringSupport.isNotNullAndNotEmpty(current_role) && current_role.equals("client_admin")) || isAdmin) {
            return Boolean.TRUE;
        }
        return dao.getRoleRightMatrixList(NumberSupport.getBigInteger(clientId), current_role, ruleName);
    }

    @Override
    public Map<String, Boolean> hasRoleRigths(String clientId, String current_role, Boolean isAdmin, String rulesNames) {
        if (StringSupport.isNullOrEmpty(clientId, current_role, rulesNames)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        
        List<String> rules = new ArrayList<>(Arrays.asList(rulesNames.split(",")));

        HashMap<String, Boolean> result = new HashMap<>();
        if ((StringSupport.isNotNullAndNotEmpty(current_role) && current_role.equals("client_admin")) || isAdmin) {
            rules.forEach(rule -> {
                result.put(rule, Boolean.TRUE);
            });
            return result;
        }
        return dao.getRoleRightsMatrixList(NumberSupport.getBigInteger(clientId), current_role, rules);
    }
}
