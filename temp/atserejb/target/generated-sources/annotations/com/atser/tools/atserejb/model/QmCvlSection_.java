package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmCvlSection.class)
public abstract class QmCvlSection_ {

	public static volatile SingularAttribute<QmCvlSection, String> sectionName;
	public static volatile SingularAttribute<QmCvlSection, String> createBy;
	public static volatile SingularAttribute<QmCvlSection, BigInteger> clientId;
	public static volatile SingularAttribute<QmCvlSection, String> lastModBy;
	public static volatile SingularAttribute<QmCvlSection, String> lastModIp;
	public static volatile ListAttribute<QmCvlSection, QmCvlField> qmCvlFieldList;
	public static volatile SingularAttribute<QmCvlSection, Character> active;
	public static volatile SingularAttribute<QmCvlSection, BigDecimal> id;
	public static volatile SingularAttribute<QmCvlSection, String> lastMod;
	public static volatile SingularAttribute<QmCvlSection, String> version;
	public static volatile SingularAttribute<QmCvlSection, String> createByIp;
	public static volatile SingularAttribute<QmCvlSection, Date> createDate;

	public static final String SECTION_NAME = "sectionName";
	public static final String CREATE_BY = "createBy";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String QM_CVL_FIELD_LIST = "qmCvlFieldList";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_DATE = "createDate";

}

