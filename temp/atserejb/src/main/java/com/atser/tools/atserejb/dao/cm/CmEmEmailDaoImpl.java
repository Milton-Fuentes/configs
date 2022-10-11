/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmEmEmail;
import java.math.BigDecimal;
import javax.ejb.Stateless;

/**
 *
 * @author dperez
 */
@Stateless
public class CmEmEmailDaoImpl extends GenericDao<BigDecimal, CmEmEmail> implements CmEmEmailDao {    
}
