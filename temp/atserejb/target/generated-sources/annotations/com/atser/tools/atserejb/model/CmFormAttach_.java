package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormAttach.class)
public abstract class CmFormAttach_ {

	public static volatile SingularAttribute<CmFormAttach, BigInteger> owner;
	public static volatile SingularAttribute<CmFormAttach, String> extension;
	public static volatile SingularAttribute<CmFormAttach, String> fName;
	public static volatile SingularAttribute<CmFormAttach, Date> fDate;
	public static volatile SingularAttribute<CmFormAttach, CmForm> cmFormId;
	public static volatile SingularAttribute<CmFormAttach, BigDecimal> id;
	public static volatile SingularAttribute<CmFormAttach, String> fTitle;
	public static volatile SingularAttribute<CmFormAttach, String> sourcePath;

	public static final String OWNER = "owner";
	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String F_DATE = "fDate";
	public static final String CM_FORM_ID = "cmFormId";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String SOURCE_PATH = "sourcePath";

}

