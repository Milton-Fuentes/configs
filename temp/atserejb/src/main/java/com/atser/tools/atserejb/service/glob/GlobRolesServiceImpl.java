/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobRolesDao;
import com.atser.tools.atserejb.model.GlobRoles;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.BpmTaskMatrix;
import com.atser.tools.atserejb.model.GlobClientRoles;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobRolesServiceImpl implements GlobRolesService, IBaseEJBException {

    @Inject
    private GlobRolesDao dao;

    @Override
    public GlobRoles findById(String id) {
        return findById(NumberSupport.getBigDecimal(id));
    }

    public GlobRoles findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(GlobRoles elem) {
        return dao.save(elem).getId().toBigInteger();
    }

    @Override
    public void update(GlobRoles elem) {
        if (elem != null) {
            GlobRoles model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        if (!id.isEmpty()) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobRoles> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobRoles> listAll() {
        return dao.findAll();
    }

    @Override
    public List<Object[]> getModuleRoles(BigInteger clientId) {
        if (clientId != null) {
            return dao.getModuleRoles(clientId);
        }
        return null;
    }

    @Override
    public List<DataSelectWrapper> getModuleRolesForSelect(BigInteger clientId) {
        List<Object[]> roles = getModuleRoles(clientId);
        if (roles == null || roles.isEmpty()) {
            return new ArrayList<>();
        }
        return roles.stream().map(p -> new DataSelectWrapper(p[0], StringSupport.emptyOnNull(p[1]))).collect(Collectors.toList());
    }

    @Override
    public Optional<GlobRoles> findByRoleName(String roleName) {
        if (StringSupport.isNullOrEmpty(roleName)) {
            return Optional.empty();
        }
        return dao.findByRoleName(roleName);
    }

}
