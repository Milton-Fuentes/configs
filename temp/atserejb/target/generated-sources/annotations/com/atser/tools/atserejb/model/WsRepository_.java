package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsRepository.class)
public abstract class WsRepository_ {

	public static volatile SingularAttribute<WsRepository, String> path;
	public static volatile SingularAttribute<WsRepository, String> name;
	public static volatile SingularAttribute<WsRepository, String> httpmethod;
	public static volatile SingularAttribute<WsRepository, String> description;
	public static volatile SingularAttribute<WsRepository, String> requestExample;
	public static volatile SingularAttribute<WsRepository, BigDecimal> id;
	public static volatile SingularAttribute<WsRepository, String> parameters;
	public static volatile ListAttribute<WsRepository, WsRigths> wsRigthsList;

	public static final String PATH = "path";
	public static final String NAME = "name";
	public static final String HTTPMETHOD = "httpmethod";
	public static final String DESCRIPTION = "description";
	public static final String REQUEST_EXAMPLE = "requestExample";
	public static final String ID = "id";
	public static final String PARAMETERS = "parameters";
	public static final String WS_RIGTHS_LIST = "wsRigthsList";

}

