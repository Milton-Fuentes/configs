/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.VwProctorAttLimit;
import java.math.BigInteger;
import javax.ejb.Stateless;

@Stateless
public class VwProctorAttLimitDaoImpl extends GenericDao<BigInteger, VwProctorAttLimit> implements VwProctorAttLimitDao {
}
