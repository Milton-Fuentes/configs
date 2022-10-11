package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectLocation.class)
public abstract class GlobProjectLocation_ {

	public static volatile SingularAttribute<GlobProjectLocation, BigInteger> officeLocationId;
	public static volatile SingularAttribute<GlobProjectLocation, BigInteger> regionId;
	public static volatile SingularAttribute<GlobProjectLocation, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectLocation, BigInteger> projectId;

	public static final String OFFICE_LOCATION_ID = "officeLocationId";
	public static final String REGION_ID = "regionId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

