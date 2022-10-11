package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleLocationRecord.class)
public abstract class QaSampleLocationRecord_ {

	public static volatile SingularAttribute<QaSampleLocationRecord, Date> dateTime;
	public static volatile SingularAttribute<QaSampleLocationRecord, BigInteger> contactId;
	public static volatile SingularAttribute<QaSampleLocationRecord, BigInteger> sampleId;
	public static volatile SingularAttribute<QaSampleLocationRecord, String> locationId;
	public static volatile SingularAttribute<QaSampleLocationRecord, String> active;
	public static volatile SingularAttribute<QaSampleLocationRecord, String> remark;
	public static volatile SingularAttribute<QaSampleLocationRecord, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleLocationRecord, BigInteger> version;

	public static final String DATE_TIME = "dateTime";
	public static final String CONTACT_ID = "contactId";
	public static final String SAMPLE_ID = "sampleId";
	public static final String LOCATION_ID = "locationId";
	public static final String ACTIVE = "active";
	public static final String REMARK = "remark";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

