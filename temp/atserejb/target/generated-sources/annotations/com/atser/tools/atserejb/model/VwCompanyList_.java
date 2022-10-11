package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwCompanyList.class)
public abstract class VwCompanyList_ {

	public static volatile SingularAttribute<VwCompanyList, String> firm;
	public static volatile SingularAttribute<VwCompanyList, BigInteger> clientId;
	public static volatile SingularAttribute<VwCompanyList, String> name;
	public static volatile SingularAttribute<VwCompanyList, BigInteger> coId;
	public static volatile SingularAttribute<VwCompanyList, String> id;
	public static volatile SingularAttribute<VwCompanyList, String> tableName;

	public static final String FIRM = "firm";
	public static final String CLIENT_ID = "clientId";
	public static final String NAME = "name";
	public static final String CO_ID = "coId";
	public static final String ID = "id";
	public static final String TABLE_NAME = "tableName";

}

