/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QalabCaliblogV2;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class QalabCaliblogV2DaoImpl extends GenericDao<BigDecimal, QalabCaliblogV2> implements QalabCaliblogV2Dao {
}
