/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QmProjContrPers;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class QmProjContrPersDaoImpl extends GenericDao<BigDecimal, QmProjContrPers> implements QmProjContrPersDao {    
}
