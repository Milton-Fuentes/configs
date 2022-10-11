package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabMainttypeV2.class)
public abstract class QalabMainttypeV2_ {

	public static volatile SingularAttribute<QalabMainttypeV2, String> deleted;
	public static volatile SingularAttribute<QalabMainttypeV2, BigInteger> intervalM;
	public static volatile SingularAttribute<QalabMainttypeV2, QalabEquiptypeV2> equiptypeid;
	public static volatile ListAttribute<QalabMainttypeV2, QalabMaintlogV2> qalabMaintlogList;
	public static volatile SingularAttribute<QalabMainttypeV2, BigDecimal> id;
	public static volatile SingularAttribute<QalabMainttypeV2, String> procedure;
	public static volatile SingularAttribute<QalabMainttypeV2, String> equippartName;

	public static final String DELETED = "deleted";
	public static final String INTERVAL_M = "intervalM";
	public static final String EQUIPTYPEID = "equiptypeid";
	public static final String QALAB_MAINTLOG_LIST = "qalabMaintlogList";
	public static final String ID = "id";
	public static final String PROCEDURE = "procedure";
	public static final String EQUIPPART_NAME = "equippartName";

}

