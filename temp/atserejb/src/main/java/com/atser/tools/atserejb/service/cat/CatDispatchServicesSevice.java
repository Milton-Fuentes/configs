/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cat;

import com.atser.tools.atserejb.model.CatDispatchServices;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CatDispatchServicesSevice {

    CatDispatchServices findById(String id);

    void save(CatDispatchServices elem);

    void update(CatDispatchServices elem);

    void delete(String id);

    List<CatDispatchServices> list(ManageITBodyRequest request);
}
