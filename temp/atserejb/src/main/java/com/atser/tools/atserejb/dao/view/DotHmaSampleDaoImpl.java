package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotHmaSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotHmaSampleDaoImpl extends GenericDao<BigDecimal, DotHmaSample> implements DotHmaSampleDao {
}
