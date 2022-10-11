package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotPozzolanSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotPozzolanSampleDaoImpl extends GenericDao<BigDecimal, DotPozzolanSample> implements DotPozzolanSampleDao {
}
