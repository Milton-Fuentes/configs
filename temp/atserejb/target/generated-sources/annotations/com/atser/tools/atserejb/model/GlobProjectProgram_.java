package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectProgram.class)
public abstract class GlobProjectProgram_ {

	public static volatile SingularAttribute<GlobProjectProgram, BigInteger> clientId;
	public static volatile SingularAttribute<GlobProjectProgram, String> programName;
	public static volatile SingularAttribute<GlobProjectProgram, String> subName;
	public static volatile SingularAttribute<GlobProjectProgram, String> subCaption;
	public static volatile SingularAttribute<GlobProjectProgram, Character> active;
	public static volatile SingularAttribute<GlobProjectProgram, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectProgram, BigInteger> programOrder;
	public static volatile SingularAttribute<GlobProjectProgram, BigInteger> progId;

	public static final String CLIENT_ID = "clientId";
	public static final String PROGRAM_NAME = "programName";
	public static final String SUB_NAME = "subName";
	public static final String SUB_CAPTION = "subCaption";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String PROGRAM_ORDER = "programOrder";
	public static final String PROG_ID = "progId";

}

