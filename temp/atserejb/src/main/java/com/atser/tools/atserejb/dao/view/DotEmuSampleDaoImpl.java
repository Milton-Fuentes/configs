package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.DotEmuSample;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class DotEmuSampleDaoImpl extends GenericDao<BigDecimal, DotEmuSample> implements DotEmuSampleDao {
}
