package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileExtension.class)
public abstract class GlobFileExtension_ {

	public static volatile SingularAttribute<GlobFileExtension, String> extension;
	public static volatile SingularAttribute<GlobFileExtension, String> iconFile;
	public static volatile SingularAttribute<GlobFileExtension, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileExtension, String> contentType;
	public static volatile SingularAttribute<GlobFileExtension, String> inSearchList;

	public static final String EXTENSION = "extension";
	public static final String ICON_FILE = "iconFile";
	public static final String ID = "id";
	public static final String CONTENT_TYPE = "contentType";
	public static final String IN_SEARCH_LIST = "inSearchList";

}

