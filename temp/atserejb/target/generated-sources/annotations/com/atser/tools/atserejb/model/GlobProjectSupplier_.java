package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectSupplier.class)
public abstract class GlobProjectSupplier_ {

	public static volatile SingularAttribute<GlobProjectSupplier, GlobSupplier> supplierId;
	public static volatile SingularAttribute<GlobProjectSupplier, Character> active;
	public static volatile SingularAttribute<GlobProjectSupplier, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectSupplier, GlobProject> projectId;
	public static volatile SingularAttribute<GlobProjectSupplier, BigInteger> folderId;
	public static volatile SingularAttribute<GlobProjectSupplier, Character> enabled;

	public static final String SUPPLIER_ID = "supplierId";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String FOLDER_ID = "folderId";
	public static final String ENABLED = "enabled";

}

