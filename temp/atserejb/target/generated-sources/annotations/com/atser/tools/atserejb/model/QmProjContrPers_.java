package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmProjContrPers.class)
public abstract class QmProjContrPers_ {

	public static volatile SingularAttribute<QmProjContrPers, Date> createdDate;
	public static volatile SingularAttribute<QmProjContrPers, Character> deleted;
	public static volatile SingularAttribute<QmProjContrPers, QmPersonnel> personnelId;
	public static volatile SingularAttribute<QmProjContrPers, GlobProjContrPersonnel> projContrPersId;
	public static volatile SingularAttribute<QmProjContrPers, Character> active;
	public static volatile SingularAttribute<QmProjContrPers, Date> lastModDate;
	public static volatile SingularAttribute<QmProjContrPers, Character> main;
	public static volatile SingularAttribute<QmProjContrPers, BigDecimal> id;
	public static volatile SingularAttribute<QmProjContrPers, BigInteger> version;

	public static final String CREATED_DATE = "createdDate";
	public static final String DELETED = "deleted";
	public static final String PERSONNEL_ID = "personnelId";
	public static final String PROJ_CONTR_PERS_ID = "projContrPersId";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_DATE = "lastModDate";
	public static final String MAIN = "main";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

