package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwProctorAttLimit.class)
public abstract class VwProctorAttLimit_ {

	public static volatile SingularAttribute<VwProctorAttLimit, String> approvedBy;
	public static volatile SingularAttribute<VwProctorAttLimit, String> description;
	public static volatile SingularAttribute<VwProctorAttLimit, String> sampleNo;
	public static volatile SingularAttribute<VwProctorAttLimit, String> source;
	public static volatile SingularAttribute<VwProctorAttLimit, Date> collectionDate;
	public static volatile SingularAttribute<VwProctorAttLimit, String> structure;
	public static volatile SingularAttribute<VwProctorAttLimit, String> optMoistContent;
	public static volatile SingularAttribute<VwProctorAttLimit, String> liquidLimit;
	public static volatile SingularAttribute<VwProctorAttLimit, String> plasticIndex;
	public static volatile SingularAttribute<VwProctorAttLimit, String> plasticLimit;
	public static volatile SingularAttribute<VwProctorAttLimit, String> category;
	public static volatile SingularAttribute<VwProctorAttLimit, BigInteger> projectId;
	public static volatile SingularAttribute<VwProctorAttLimit, String> maxDryDensity;

	public static final String APPROVED_BY = "approvedBy";
	public static final String DESCRIPTION = "description";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String SOURCE = "source";
	public static final String COLLECTION_DATE = "collectionDate";
	public static final String STRUCTURE = "structure";
	public static final String OPT_MOIST_CONTENT = "optMoistContent";
	public static final String LIQUID_LIMIT = "liquidLimit";
	public static final String PLASTIC_INDEX = "plasticIndex";
	public static final String PLASTIC_LIMIT = "plasticLimit";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";
	public static final String MAX_DRY_DENSITY = "maxDryDensity";

}

