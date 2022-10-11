/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.ScbAggDecan;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class ScbAggDecanDaoImpl extends GenericDao<BigDecimal, ScbAggDecan> implements ScbAggDecanDao {
}
