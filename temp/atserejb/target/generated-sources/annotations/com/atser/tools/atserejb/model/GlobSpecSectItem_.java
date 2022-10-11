package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecSectItem.class)
public abstract class GlobSpecSectItem_ {

	public static volatile SingularAttribute<GlobSpecSectItem, BigInteger> itemId;
	public static volatile SingularAttribute<GlobSpecSectItem, String> field1;
	public static volatile SingularAttribute<GlobSpecSectItem, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecSectItem, BigInteger> sectionId;
	public static volatile SingularAttribute<GlobSpecSectItem, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecSectItem, String> field2;
	public static volatile SingularAttribute<GlobSpecSectItem, Date> field4;

	public static final String ITEM_ID = "itemId";
	public static final String FIELD1 = "field1";
	public static final String ID = "id";
	public static final String SECTION_ID = "sectionId";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

