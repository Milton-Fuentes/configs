package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectPersonnel.class)
public abstract class GlobProjectPersonnel_ {

	public static volatile SingularAttribute<GlobProjectPersonnel, Character> showdispatch;
	public static volatile SingularAttribute<GlobProjectPersonnel, BigInteger> clientId;
	public static volatile SingularAttribute<GlobProjectPersonnel, GlobContact> contactId;
	public static volatile SingularAttribute<GlobProjectPersonnel, Character> active;
	public static volatile SingularAttribute<GlobProjectPersonnel, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectPersonnel, BigInteger> projectId;

	public static final String SHOWDISPATCH = "showdispatch";
	public static final String CLIENT_ID = "clientId";
	public static final String CONTACT_ID = "contactId";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

