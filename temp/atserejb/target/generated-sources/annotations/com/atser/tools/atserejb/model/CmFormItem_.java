package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormItem.class)
public abstract class CmFormItem_ {

	public static volatile SingularAttribute<CmFormItem, String> lastModBy;
	public static volatile SingularAttribute<CmFormItem, BigInteger> cmFormId;
	public static volatile SingularAttribute<CmFormItem, Character> active;
	public static volatile SingularAttribute<CmFormItem, String> itemNo;
	public static volatile SingularAttribute<CmFormItem, String> itemDesc;
	public static volatile SingularAttribute<CmFormItem, String> version;
	public static volatile SingularAttribute<CmFormItem, String> createByIp;
	public static volatile SingularAttribute<CmFormItem, String> noCopies;
	public static volatile SingularAttribute<CmFormItem, String> createBy;
	public static volatile SingularAttribute<CmFormItem, String> lastModIp;
	public static volatile SingularAttribute<CmFormItem, BigDecimal> id;
	public static volatile SingularAttribute<CmFormItem, String> lastMod;
	public static volatile SingularAttribute<CmFormItem, String> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CM_FORM_ID = "cmFormId";
	public static final String ACTIVE = "active";
	public static final String ITEM_NO = "itemNo";
	public static final String ITEM_DESC = "itemDesc";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String NO_COPIES = "noCopies";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

