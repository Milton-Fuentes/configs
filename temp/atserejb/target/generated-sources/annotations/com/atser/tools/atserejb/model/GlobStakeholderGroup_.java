package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobStakeholderGroup.class)
public abstract class GlobStakeholderGroup_ {

	public static volatile ListAttribute<GlobStakeholderGroup, GlobStakeholder> globStakeholderList;
	public static volatile SingularAttribute<GlobStakeholderGroup, BigInteger> clientId;
	public static volatile SingularAttribute<GlobStakeholderGroup, String> name;
	public static volatile SingularAttribute<GlobStakeholderGroup, String> description;
	public static volatile SingularAttribute<GlobStakeholderGroup, BigDecimal> id;
	public static volatile SingularAttribute<GlobStakeholderGroup, Short> status;
	public static volatile SingularAttribute<GlobStakeholderGroup, Date> createDate;

	public static final String GLOB_STAKEHOLDER_LIST = "globStakeholderList";
	public static final String CLIENT_ID = "clientId";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String CREATE_DATE = "createDate";

}

