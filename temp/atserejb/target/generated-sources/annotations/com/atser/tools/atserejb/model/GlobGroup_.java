package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobGroup.class)
public abstract class GlobGroup_ {

	public static volatile SingularAttribute<GlobGroup, String> gName;
	public static volatile SingularAttribute<GlobGroup, Character> hasrootfolder;
	public static volatile SingularAttribute<GlobGroup, Character> system;
	public static volatile SingularAttribute<GlobGroup, BigInteger> contractId;
	public static volatile SingularAttribute<GlobGroup, String> description;
	public static volatile SingularAttribute<GlobGroup, BigDecimal> id;
	public static volatile SingularAttribute<GlobGroup, BigInteger> parentId;

	public static final String G_NAME = "gName";
	public static final String HASROOTFOLDER = "hasrootfolder";
	public static final String SYSTEM = "system";
	public static final String CONTRACT_ID = "contractId";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PARENT_ID = "parentId";

}

