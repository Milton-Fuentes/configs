package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotAggSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotAggSampleDaoImpl extends GenericDao<BigDecimal, DotAggSample> implements DotAggSampleDao {
}
