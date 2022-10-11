package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaWizardItem.class)
public abstract class QaWizardItem_ {

	public static volatile SingularAttribute<QaWizardItem, String> conditionIn;
	public static volatile SingularAttribute<QaWizardItem, String> code;
	public static volatile SingularAttribute<QaWizardItem, String> conditionOut;
	public static volatile SingularAttribute<QaWizardItem, String> name;
	public static volatile SingularAttribute<QaWizardItem, String> description;
	public static volatile SingularAttribute<QaWizardItem, String> active;
	public static volatile SingularAttribute<QaWizardItem, BigDecimal> id;
	public static volatile SingularAttribute<QaWizardItem, String> source;
	public static volatile SingularAttribute<QaWizardItem, String> page;
	public static volatile SingularAttribute<QaWizardItem, String> cmodule;
	public static volatile SingularAttribute<QaWizardItem, String> breadcrumbs;
	public static volatile SingularAttribute<QaWizardItem, Integer> order;

	public static final String CONDITION_IN = "conditionIn";
	public static final String CODE = "code";
	public static final String CONDITION_OUT = "conditionOut";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String SOURCE = "source";
	public static final String PAGE = "page";
	public static final String CMODULE = "cmodule";
	public static final String BREADCRUMBS = "breadcrumbs";
	public static final String ORDER = "order";

}

