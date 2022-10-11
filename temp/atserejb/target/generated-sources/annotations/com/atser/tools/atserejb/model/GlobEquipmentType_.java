package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobEquipmentType.class)
public abstract class GlobEquipmentType_ {

	public static volatile SingularAttribute<GlobEquipmentType, String> equipType;
	public static volatile SingularAttribute<GlobEquipmentType, String> description;
	public static volatile SingularAttribute<GlobEquipmentType, BigDecimal> id;

	public static final String EQUIP_TYPE = "equipType";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

