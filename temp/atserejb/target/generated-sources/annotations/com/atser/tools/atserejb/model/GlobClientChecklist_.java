package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientChecklist.class)
public abstract class GlobClientChecklist_ {

	public static volatile SingularAttribute<GlobClientChecklist, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientChecklist, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientChecklist, BigInteger> checklistId;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String CHECKLIST_ID = "checklistId";

}

