package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotMiscSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotMiscSampleDaoImpl extends GenericDao<BigDecimal, DotMiscSample> implements DotMiscSampleDao {
}
