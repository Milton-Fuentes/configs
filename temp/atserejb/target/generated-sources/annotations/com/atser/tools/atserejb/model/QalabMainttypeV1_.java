package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabMainttypeV1.class)
public abstract class QalabMainttypeV1_ {

	public static volatile SingularAttribute<QalabMainttypeV1, String> deleted;
	public static volatile SingularAttribute<QalabMainttypeV1, BigInteger> intervalM;
	public static volatile SingularAttribute<QalabMainttypeV1, QalabEquiptypeV1> equiptypeid;
	public static volatile ListAttribute<QalabMainttypeV1, QalabMaintlogV1> qalabMaintlogList;
	public static volatile SingularAttribute<QalabMainttypeV1, BigDecimal> id;
	public static volatile SingularAttribute<QalabMainttypeV1, String> procedure;
	public static volatile SingularAttribute<QalabMainttypeV1, String> equippartName;

	public static final String DELETED = "deleted";
	public static final String INTERVAL_M = "intervalM";
	public static final String EQUIPTYPEID = "equiptypeid";
	public static final String QALAB_MAINTLOG_LIST = "qalabMaintlogList";
	public static final String ID = "id";
	public static final String PROCEDURE = "procedure";
	public static final String EQUIPPART_NAME = "equippartName";

}

