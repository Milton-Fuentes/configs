package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaaspmMixdesignJmfMaster.class)
public abstract class QaaspmMixdesignJmfMaster_ {

	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxvfa;
	public static volatile ListAttribute<QaaspmMixdesignJmfMaster, QaaspmMixdesignJmfsvMaster> qaaspmMixdesignJmfsvMasterList;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minvma;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> lastModBy;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> desac;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxvtm;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minac;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> main;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxengvtm;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> jmfAc;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxengvfa;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> desvma;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> lastModIp;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minengdpbr;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxdpbr;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> id;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> mindpbr;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minengvfa;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> desdpbr;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> createdByIp;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minvfa;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, QaaspmMixdesignMaster> mixId;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minvtm;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, Date> created;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minengvtm;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minengac;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxvma;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxengvma;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> active;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxac;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigInteger> jmfNo;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, Long> version;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, Date> approvedDate;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> pctAbsorption;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxengdpbr;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> deleted;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> desvtm;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, String> createdBy;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> desvfa;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> maxengac;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, BigDecimal> minengvma;
	public static volatile SingularAttribute<QaaspmMixdesignJmfMaster, Date> lastMod;

	public static final String MAXVFA = "maxvfa";
	public static final String QAASPM_MIXDESIGN_JMFSV_MASTER_LIST = "qaaspmMixdesignJmfsvMasterList";
	public static final String MINVMA = "minvma";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DESAC = "desac";
	public static final String MAXVTM = "maxvtm";
	public static final String MINAC = "minac";
	public static final String MAIN = "main";
	public static final String MAXENGVTM = "maxengvtm";
	public static final String JMF_AC = "jmfAc";
	public static final String MAXENGVFA = "maxengvfa";
	public static final String DESVMA = "desvma";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String MINENGDPBR = "minengdpbr";
	public static final String MAXDPBR = "maxdpbr";
	public static final String ID = "id";
	public static final String MINDPBR = "mindpbr";
	public static final String MINENGVFA = "minengvfa";
	public static final String DESDPBR = "desdpbr";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String MINVFA = "minvfa";
	public static final String MIX_ID = "mixId";
	public static final String MINVTM = "minvtm";
	public static final String CREATED = "created";
	public static final String MINENGVTM = "minengvtm";
	public static final String MINENGAC = "minengac";
	public static final String MAXVMA = "maxvma";
	public static final String MAXENGVMA = "maxengvma";
	public static final String ACTIVE = "active";
	public static final String MAXAC = "maxac";
	public static final String JMF_NO = "jmfNo";
	public static final String VERSION = "version";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String PCT_ABSORPTION = "pctAbsorption";
	public static final String MAXENGDPBR = "maxengdpbr";
	public static final String DELETED = "deleted";
	public static final String DESVTM = "desvtm";
	public static final String CREATED_BY = "createdBy";
	public static final String DESVFA = "desvfa";
	public static final String MAXENGAC = "maxengac";
	public static final String MINENGVMA = "minengvma";
	public static final String LAST_MOD = "lastMod";

}

