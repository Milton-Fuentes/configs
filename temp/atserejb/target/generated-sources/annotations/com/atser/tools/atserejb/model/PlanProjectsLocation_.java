package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PlanProjectsLocation.class)
public abstract class PlanProjectsLocation_ {

	public static volatile SingularAttribute<PlanProjectsLocation, String> locationKey;
	public static volatile SingularAttribute<PlanProjectsLocation, String> groupName;
	public static volatile SingularAttribute<PlanProjectsLocation, String> locationName;
	public static volatile SingularAttribute<PlanProjectsLocation, BigInteger> clientId;
	public static volatile SingularAttribute<PlanProjectsLocation, BigInteger> locSequence;
	public static volatile SingularAttribute<PlanProjectsLocation, BigInteger> locVisible;
	public static volatile SingularAttribute<PlanProjectsLocation, String> lNumber;
	public static volatile SingularAttribute<PlanProjectsLocation, String> groupKey;

	public static final String LOCATION_KEY = "locationKey";
	public static final String GROUP_NAME = "groupName";
	public static final String LOCATION_NAME = "locationName";
	public static final String CLIENT_ID = "clientId";
	public static final String LOC_SEQUENCE = "locSequence";
	public static final String LOC_VISIBLE = "locVisible";
	public static final String L_NUMBER = "lNumber";
	public static final String GROUP_KEY = "groupKey";

}

