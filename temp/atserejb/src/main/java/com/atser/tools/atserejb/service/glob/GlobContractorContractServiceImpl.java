/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobContractorContractDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.GlobContractorContract;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.GlobClientInfoDefaults;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobClientInfoDefaultsService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobContractorContractServiceImpl implements GlobContractorContractService, IBaseEJBException {

    @Inject
    private GlobContractorService contractorService;
    @Inject
    private GlobContractorContractDao dao;
    @Inject
    private GlobClientInfoDefaultsService globClientInfoDefaultsService;
    @Inject
    private GlobLabsService globLabsService;

    @Override
    public GlobContractorContract findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobContractorContract findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobContractorContract elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobContractorContract elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void saveDefault(GlobProject elem) {
        GlobClientInfoDefaults df = globClientInfoDefaultsService.findByClientId(NumberSupport.getBigInteger(elem.getClientId().getId()));

        GlobContractorContract contractor = new GlobContractorContract();
        contractor.setProjectId(elem);
        contractor.setContractId(df.getContractId());
        if (df.getId() != null) {
            contractor.setLabId(globLabsService.findById(df.getId()));
        }
        if (df.getContractorId() != null) {
            contractor.setContractorId(contractorService.findById(StringSupport.getString(df.getContractorId())));
        }
        contractor.setFunctionId(df.getFunctionId());
        contractor.setDisciplineId(df.getDisciplineId());
        this.save(contractor);

    }

    @Override
    public void update(GlobContractorContract elem) {
        if (elem != null) {
            GlobContractorContract model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobContractorContract elem) {
        if (elem != null) {
            GlobContractorContract model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobContractorContract populate(GlobContractorContract model, GlobContractorContract elem) {
        model.setContractorId(elem.getContractorId());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobContractorContract> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobContractorContract> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobContractorContract> finalList = list(request);
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
    public Boolean exists(BigInteger clientId, BigInteger projectId, BigInteger labId, BigInteger functionId) {
        return dao.exists(clientId, projectId, labId, functionId);
    }

    @Override
    public BigDecimal findInfoId(BigInteger projectId, String functionName) {
        if (projectId == null || StringSupport.isNullOrEmpty(functionName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findInfoId(projectId, functionName);
    }

    @Override
    public GlobContractorContract findByIdAndExtend(BigDecimal id, String extend) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findByIdAndExtend(id, extend);
    }

    @Override
    public DataGridWrapper<GlobContractorContract> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
