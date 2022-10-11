package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaTicketDocs.class)
public abstract class QaTicketDocs_ {

	public static volatile SingularAttribute<QaTicketDocs, String> extension;
	public static volatile SingularAttribute<QaTicketDocs, String> fName;
	public static volatile SingularAttribute<QaTicketDocs, BigDecimal> id;
	public static volatile SingularAttribute<QaTicketDocs, String> fTitle;
	public static volatile SingularAttribute<QaTicketDocs, String> note1;
	public static volatile SingularAttribute<QaTicketDocs, BigInteger> ticketId;
	public static volatile SingularAttribute<QaTicketDocs, String> sourcePath;

	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String NOTE1 = "note1";
	public static final String TICKET_ID = "ticketId";
	public static final String SOURCE_PATH = "sourcePath";

}

