package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotIronsteelSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotIronsteelSampleDaoImpl extends GenericDao<BigDecimal, DotIronsteelSample> implements DotIronsteelSampleDao {
}
