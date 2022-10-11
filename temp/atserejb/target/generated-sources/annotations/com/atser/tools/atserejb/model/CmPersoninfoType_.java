package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmPersoninfoType.class)
public abstract class CmPersoninfoType_ {

	public static volatile SingularAttribute<CmPersoninfoType, String> roleName;
	public static volatile SingularAttribute<CmPersoninfoType, String> shortdesc;
	public static volatile SingularAttribute<CmPersoninfoType, String> description;
	public static volatile SingularAttribute<CmPersoninfoType, Character> active;
	public static volatile SingularAttribute<CmPersoninfoType, BigDecimal> id;
	public static volatile SingularAttribute<CmPersoninfoType, Character> isAdmin;

	public static final String ROLE_NAME = "roleName";
	public static final String SHORTDESC = "shortdesc";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String IS_ADMIN = "isAdmin";

}

