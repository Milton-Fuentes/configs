package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmRoleMapping.class)
public abstract class BpmRoleMapping_ {

	public static volatile SingularAttribute<BpmRoleMapping, BigInteger> clientId;
	public static volatile SingularAttribute<BpmRoleMapping, String> bpmRoleName;
	public static volatile SingularAttribute<BpmRoleMapping, String> bpmGroupName;
	public static volatile SingularAttribute<BpmRoleMapping, Character> isadmin;
	public static volatile SingularAttribute<BpmRoleMapping, BigDecimal> id;
	public static volatile SingularAttribute<BpmRoleMapping, String> manageitRoleName;

	public static final String CLIENT_ID = "clientId";
	public static final String BPM_ROLE_NAME = "bpmRoleName";
	public static final String BPM_GROUP_NAME = "bpmGroupName";
	public static final String ISADMIN = "isadmin";
	public static final String ID = "id";
	public static final String MANAGEIT_ROLE_NAME = "manageitRoleName";

}

