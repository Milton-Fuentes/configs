/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.dao.ws.WsUsersDao;
import com.atser.tools.atserejb.model.WsRigths;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.crypt.CryptSupport;
import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class WsUsersServiceImpl implements WsUsersService, IBaseEJBException {

    @Inject
    private WsUsersDao dao;

    @Override
    public WsUsers findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public WsUsers findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, WsUsers elem) {
        if (elem != null) {
            String salt = UUID.randomUUID().toString();
            elem.setPassword(CryptSupport.cryptHMACSHA256(elem.getPassword(), salt));
            elem.setSalt(salt);
            if (StringSupport.isNotNullAndNotEmpty(elem.getCategory())) {
                if (elem.getCookie_xtime() == null) {
                    switch (elem.getCategory().toLowerCase()) {
                        case "internal": {
                            elem.setCookie_xtime(3600);
                            break;
                        }
                        case "external": {
                            elem.setCookie_xtime(900);
                            break;
                        }
                        default: {
                            elem.setCookie_xtime(3600);
                        }
                    }
                }
            } else {
                elem.setCategory("EXTERNAL");
                elem.setCookie_xtime(900);
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, WsUsers elem) {
        if (elem != null) {
            WsUsers model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private WsUsers populate(WsUsers model, WsUsers elem) {
        model.setName(elem.getName());
        model.setLastName(elem.getLastName());
        model.setEmail(elem.getEmail());
        model.setPhonenumber(elem.getPhonenumber());
        model.setLocked(elem.getLocked());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public List<WsUsers> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void inactiveUser(String id, Boolean active) {
        if (id == null || id.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return;
        }
        WsUsers model = findById(id);
        model.setActive(active ? 'Y' : 'N');
        dao.update(model);
    }

    @Override
    public WsUsers authUser(String username, String pwd, eWsUserCategory category) {
        if (username == null || pwd == null || username.isEmpty() || pwd.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }

        WsUsers user = dao.findBySSO(username, category);
        if (user != null) {
            if (user.getLocked() == 'Y') {
                log.error("This user is currently locked.", username);
                throwBaseException(Response.Status.UNAUTHORIZED, "You do not have access.");
            }
            String pwdsalted = CryptSupport.cryptHMACSHA256(pwd, user.getSalt());
            boolean isauth = user.getPassword().equals(pwdsalted);
            if (isauth) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Map<String, List<WsRigths>> getMapRigths() {
        return dao.getMapRigths();
    }

    @Override
    public List<WsRigths> getRigthsByUserId(BigInteger userid) {
        if (userid == null) {
            log.error("getRigthsByUserId - userid is null");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getRigthsByUserId(userid);
    }

    @Override
    public WsUsers findBySSO(String username, eWsUserCategory category) {
        return dao.findBySSO(username, category);
    }

    @Override
    public List<WsUsers> getUserGraph(String graph) {
        return dao.getUserGraph(graph);
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
    public DataTableWrapper<WsUsers> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<WsUsers> finalList = list(request);
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
    public DataGridWrapper<WsUsers> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
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
}
