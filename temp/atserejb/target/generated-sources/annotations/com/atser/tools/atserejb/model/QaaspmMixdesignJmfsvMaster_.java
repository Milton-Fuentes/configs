package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaaspmMixdesignJmfsvMaster.class)
public abstract class QaaspmMixdesignJmfsvMaster_ {

	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, BigDecimal> jmfPercPassing;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> createdByIp;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> lastModBy;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, BigInteger> sieveId;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, BigInteger> ordering;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, Date> created;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> active;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, Long> version;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> lastModIp;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> deleted;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, String> createdBy;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, QaaspmMixdesignJmfMaster> jmfId;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, BigDecimal> id;
	public static volatile SingularAttribute<QaaspmMixdesignJmfsvMaster, Date> lastMod;

	public static final String JMF_PERC_PASSING = "jmfPercPassing";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SIEVE_ID = "sieveId";
	public static final String ORDERING = "ordering";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String JMF_ID = "jmfId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

