package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmCvlField.class)
public abstract class QmCvlField_ {

	public static volatile SingularAttribute<QmCvlField, String> fieldName;
	public static volatile SingularAttribute<QmCvlField, String> lastModBy;
	public static volatile SingularAttribute<QmCvlField, String> fieldCode;
	public static volatile SingularAttribute<QmCvlField, Character> active;
	public static volatile SingularAttribute<QmCvlField, QmCvlSection> sectionId;
	public static volatile SingularAttribute<QmCvlField, String> version;
	public static volatile SingularAttribute<QmCvlField, String> createByIp;
	public static volatile ListAttribute<QmCvlField, QmCvlFieldData> qmCvlFieldDataList;
	public static volatile SingularAttribute<QmCvlField, String> createBy;
	public static volatile SingularAttribute<QmCvlField, String> lastModIp;
	public static volatile SingularAttribute<QmCvlField, BigDecimal> id;
	public static volatile SingularAttribute<QmCvlField, String> lastMod;
	public static volatile SingularAttribute<QmCvlField, Date> createDate;

	public static final String FIELD_NAME = "fieldName";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String FIELD_CODE = "fieldCode";
	public static final String ACTIVE = "active";
	public static final String SECTION_ID = "sectionId";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String QM_CVL_FIELD_DATA_LIST = "qmCvlFieldDataList";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

