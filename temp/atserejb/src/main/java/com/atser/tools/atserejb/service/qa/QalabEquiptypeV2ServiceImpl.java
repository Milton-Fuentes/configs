/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QalabEquiptypeV2Dao;
import com.atser.tools.atserejb.model.GlobClientEquipcatg;
import com.atser.tools.atserejb.model.QalabEquiptypeV2;
import com.atser.tools.atserejb.service.glob.GlobClientEquipcatgService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QalabEquiptypeV2ServiceImpl implements QalabEquiptypeV2Service, IBaseEJBException {

    @Inject
    private QalabEquiptypeV2Dao dao;

    @Inject
    private GlobClientEquipcatgService globClientEquipcatgService;

    @Override
    public QalabEquiptypeV2 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabEquiptypeV2 findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, QalabEquiptypeV2 elem) {
        save(elem);
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QalabEquiptypeV2 elem) {
        update(elem);
    }

    @Override
    public void save(QalabEquiptypeV2 elem) {
        if (elem != null) {
            elem.buildReferences();
            elem.setActive("Y");
            dao.save(elem);
        }
    }

    @Override
    public void update(QalabEquiptypeV2 elem) {
        if (elem != null) {
            QalabEquiptypeV2 model = findById(elem.getId());
            model.setCatgId(elem.getCatgId());
            model.setItem(elem.getItem());
            model.setIntervalM(elem.getIntervalM());
            model.setComments(elem.getComments());
            model.setProcedure(elem.getProcedure());
            model.setCalibMethod(elem.getCalibMethod());
            elem.getQalabMainttypeList().stream().filter(p -> (p.getEquiptypeid() == null)).forEachOrdered(it -> {
                model.addQalabMainttypeList(it);
            });
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
    public void delete(BigDecimal id) {
        delete(StringSupport.getString(id));
    }

    @Override
    public List<QalabEquiptypeV2> list(ManageITHeader header, ManageITBodyRequest body) {
        List<QalabEquiptypeV2> list;
        if (body != null && (body.getFilter() != null || body.getSorted() != null)) {
            list = dao.filter(body.getFilter(), body.getSorted(), body.getPaging());
        } else {
            list = dao.findAll();
        }
        list.forEach(it -> {
            if (it.getQalabEquipInfoList() != null && it.getQalabEquipInfoList().size() > 0) {
                it.setCanbeDeleted("false");
                it.setQalabEquipInfoList(null);
            }
        });
        if (header != null && StringSupport.isNotNullAndNotEmpty(header.getClientid())) {
            List<GlobClientEquipcatg> catgList = globClientEquipcatgService.list(new ManageITBodyRequest(0, 0).filter("clientId", header.getClientid()).filter("equipCatgTitle", "null", "!="));
            if (catgList != null && catgList.size() > 0) {
                list.forEach(it -> {
                    Optional<GlobClientEquipcatg> match = catgList.stream().filter(p -> p.getEquipCatgId().equals(it.getCatgId())).findFirst();
                    GlobClientEquipcatg lc = match.orElse(null);
                    if (lc != null) {
                        it.getCatgId().setCategory(lc.getEquipCatgTitle());
                    }
                });
            }
        }
        return list;
    }

    @Override
    public List<QalabEquiptypeV2> list(ManageITBodyRequest request) {
        return list(null, request);
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QalabEquiptypeV2> dataTableList(ManageITBodyRequest request) {
        return dataTableList(null, request);
    }

    @Override
    public DataTableWrapper<QalabEquiptypeV2> dataTableList(ManageITHeader header, ManageITBodyRequest body) {
        if (body != null && (body.getFilter() != null || body.getSorted() != null)) {
            Long count = dao.getTotal(body.getFilterWithOutLikes());
            Long filtered;
            List<QalabEquiptypeV2> finalList = list(header, body);
            if (body.isSearchFilterActive()) {
                filtered = dao.getTotal(body.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QalabEquiptypeV2 model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
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
    public DataGridWrapper<QalabEquiptypeV2> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
