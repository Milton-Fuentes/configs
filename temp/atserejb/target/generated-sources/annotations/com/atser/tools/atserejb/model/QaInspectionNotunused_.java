package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionNotunused.class)
public abstract class QaInspectionNotunused_ {

	public static volatile SingularAttribute<QaInspectionNotunused, Character> deleted;
	public static volatile SingularAttribute<QaInspectionNotunused, String> verifiedByJobtitle;
	public static volatile SingularAttribute<QaInspectionNotunused, Date> verifiedDate;
	public static volatile SingularAttribute<QaInspectionNotunused, String> verifiedByName;
	public static volatile SingularAttribute<QaInspectionNotunused, QaInspection> id;
	public static volatile SingularAttribute<QaInspectionNotunused, BigInteger> verifiedBy;
	public static volatile SingularAttribute<QaInspectionNotunused, Integer> version;
	public static volatile SingularAttribute<QaInspectionNotunused, String> remarks;

	public static final String DELETED = "deleted";
	public static final String VERIFIED_BY_JOBTITLE = "verifiedByJobtitle";
	public static final String VERIFIED_DATE = "verifiedDate";
	public static final String VERIFIED_BY_NAME = "verifiedByName";
	public static final String ID = "id";
	public static final String VERIFIED_BY = "verifiedBy";
	public static final String VERSION = "version";
	public static final String REMARKS = "remarks";

}

