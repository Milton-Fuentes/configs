/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaInspectionSimpleCat;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class QaInspectionSimpleCatDaoImpl extends GenericDao<BigDecimal, QaInspectionSimpleCat> implements QaInspectionSimpleCatDao {
}
