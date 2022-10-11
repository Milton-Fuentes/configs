package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmCompany.class)
public abstract class CmCompany_ {

	public static volatile SingularAttribute<CmCompany, String> field1;
	public static volatile ListAttribute<CmCompany, CmProject> cmProjectList;
	public static volatile SingularAttribute<CmCompany, String> cpName;
	public static volatile SingularAttribute<CmCompany, Date> field7;
	public static volatile SingularAttribute<CmCompany, String> field6;
	public static volatile SingularAttribute<CmCompany, BigDecimal> id;
	public static volatile SingularAttribute<CmCompany, Date> field8;
	public static volatile SingularAttribute<CmCompany, String> field3;
	public static volatile SingularAttribute<CmCompany, String> field2;
	public static volatile SingularAttribute<CmCompany, String> field5;
	public static volatile SingularAttribute<CmCompany, String> field4;

	public static final String FIELD1 = "field1";
	public static final String CM_PROJECT_LIST = "cmProjectList";
	public static final String CP_NAME = "cpName";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String ID = "id";
	public static final String FIELD8 = "field8";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

