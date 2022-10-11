package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectRole.class)
public abstract class GlobProjectRole_ {

	public static volatile SingularAttribute<GlobProjectRole, GlobContact> contactId;
	public static volatile SingularAttribute<GlobProjectRole, String> roleName;
	public static volatile SingularAttribute<GlobProjectRole, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectRole, BigInteger> projectId;

	public static final String CONTACT_ID = "contactId";
	public static final String ROLE_NAME = "roleName";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

