package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFilter.class)
public abstract class GlobFilter_ {

	public static volatile SingularAttribute<GlobFilter, Character> fDnload;
	public static volatile SingularAttribute<GlobFilter, String> entryType;
	public static volatile SingularAttribute<GlobFilter, Character> fOwner;
	public static volatile SingularAttribute<GlobFilter, Character> fUpload;
	public static volatile SingularAttribute<GlobFilter, Character> fCreate;
	public static volatile SingularAttribute<GlobFilter, Character> fDelete;
	public static volatile SingularAttribute<GlobFilter, Character> fBrowse;
	public static volatile SingularAttribute<GlobFilter, BigDecimal> id;
	public static volatile SingularAttribute<GlobFilter, Character> fModify;
	public static volatile SingularAttribute<GlobFilter, BigInteger> entryId;

	public static final String F_DNLOAD = "fDnload";
	public static final String ENTRY_TYPE = "entryType";
	public static final String F_OWNER = "fOwner";
	public static final String F_UPLOAD = "fUpload";
	public static final String F_CREATE = "fCreate";
	public static final String F_DELETE = "fDelete";
	public static final String F_BROWSE = "fBrowse";
	public static final String ID = "id";
	public static final String F_MODIFY = "fModify";
	public static final String ENTRY_ID = "entryId";

}

