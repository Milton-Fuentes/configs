/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.batch;

import com.atser.tools.atserejb.dao.batch.JobExecutionDao;
import com.atser.tools.atserejb.model.JobExecution;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class JobExecutionServiceImpl implements JobExecutionService, IBaseEJBException {

    @Inject
    JobExecutionDao dao;

    @Override
    public JobExecution findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public JobExecution findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(JobExecution elem) {
        if (elem != null) {
            dao.save(elem).getJobexecutionid();
        }
        return null;
    }
    
    @Override
    public BigDecimal save(ManageITHeader header, JobExecution elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(JobExecution elem) {
        if (elem != null) {
            JobExecution model = findById(elem.getJobexecutionid());
            dao.update(model);
        }
    }
    
    @Override
    public void update(ManageITHeader header, JobExecution elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }
    
    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JobExecution> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<JobExecution> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<JobExecution> finalList = list(request);
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
    public DataGridWrapper<JobExecution> dataGridList(ManageITBodyRequest request) {
         if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
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
