package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotSoilSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotSoilSampleDaoImpl extends GenericDao<BigDecimal, DotSoilSample> implements DotSoilSampleDao {
}
