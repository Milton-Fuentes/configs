/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwQaLabEquipInfoTestV2;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.atser.tools.atserejb.dao.view.VwQaLabEquipInfoTestV2Dao;

@Stateless
public class VwQaLabEquipInfoTestV2ServiceImpl implements VwQaLabEquipInfoTestV2Service, IBaseEJBException {

    @Inject
    private VwQaLabEquipInfoTestV2Dao dao;

    @Override
    public List<VwQaLabEquipInfoTestV2> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwQaLabEquipInfoTestV2> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VwQaLabEquipInfoTestV2> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

}
