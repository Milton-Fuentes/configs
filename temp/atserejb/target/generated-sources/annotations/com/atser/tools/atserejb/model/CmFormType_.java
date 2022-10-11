package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormType.class)
public abstract class CmFormType_ {

	public static volatile SingularAttribute<CmFormType, String> exhibitNo;
	public static volatile SingularAttribute<CmFormType, BigInteger> maxRec;
	public static volatile SingularAttribute<CmFormType, String> fType;
	public static volatile SingularAttribute<CmFormType, Character> multiple;
	public static volatile SingularAttribute<CmFormType, String> description;
	public static volatile SingularAttribute<CmFormType, String> screenName;
	public static volatile SingularAttribute<CmFormType, BigInteger> parentId;
	public static volatile SingularAttribute<CmFormType, CmActivity> activityId;
	public static volatile SingularAttribute<CmFormType, String> fName;
	public static volatile SingularAttribute<CmFormType, String> jspName;
	public static volatile SingularAttribute<CmFormType, BigInteger> fOrder;
	public static volatile SingularAttribute<CmFormType, BigDecimal> id;
	public static volatile SingularAttribute<CmFormType, String> fFormat;
	public static volatile SingularAttribute<CmFormType, String> fFormType;

	public static final String EXHIBIT_NO = "exhibitNo";
	public static final String MAX_REC = "maxRec";
	public static final String F_TYPE = "fType";
	public static final String MULTIPLE = "multiple";
	public static final String DESCRIPTION = "description";
	public static final String SCREEN_NAME = "screenName";
	public static final String PARENT_ID = "parentId";
	public static final String ACTIVITY_ID = "activityId";
	public static final String F_NAME = "fName";
	public static final String JSP_NAME = "jspName";
	public static final String F_ORDER = "fOrder";
	public static final String ID = "id";
	public static final String F_FORMAT = "fFormat";
	public static final String F_FORM_TYPE = "fFormType";

}

