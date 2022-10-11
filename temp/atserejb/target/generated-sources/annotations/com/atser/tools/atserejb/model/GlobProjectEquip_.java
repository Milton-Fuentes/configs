package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectEquip.class)
public abstract class GlobProjectEquip_ {

	public static volatile SingularAttribute<GlobProjectEquip, String> field1;
	public static volatile SingularAttribute<GlobProjectEquip, BigInteger> typeId;
	public static volatile SingularAttribute<GlobProjectEquip, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectEquip, String> descript;
	public static volatile SingularAttribute<GlobProjectEquip, BigInteger> field3;
	public static volatile SingularAttribute<GlobProjectEquip, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectEquip, String> field2;
	public static volatile SingularAttribute<GlobProjectEquip, String> serialno;
	public static volatile SingularAttribute<GlobProjectEquip, Date> field4;

	public static final String FIELD1 = "field1";
	public static final String TYPE_ID = "typeId";
	public static final String ID = "id";
	public static final String DESCRIPT = "descript";
	public static final String FIELD3 = "field3";
	public static final String PROJECT_ID = "projectId";
	public static final String FIELD2 = "field2";
	public static final String SERIALNO = "serialno";
	public static final String FIELD4 = "field4";

}

