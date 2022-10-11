package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientRegions.class)
public abstract class GlobClientRegions_ {

	public static volatile SingularAttribute<GlobClientRegions, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientRegions, String> name;
	public static volatile SingularAttribute<GlobClientRegions, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientRegions, GlobClientDivisions> divisionId;
	public static volatile SingularAttribute<GlobClientRegions, String> shortName;
	public static volatile SingularAttribute<GlobClientRegions, BigInteger> catgColorId;
	public static volatile SingularAttribute<GlobClientRegions, String> regionNo;

	public static final String CLIENT_ID = "clientId";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String DIVISION_ID = "divisionId";
	public static final String SHORT_NAME = "shortName";
	public static final String CATG_COLOR_ID = "catgColorId";
	public static final String REGION_NO = "regionNo";

}

