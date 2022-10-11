package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobEmployee.class)
public abstract class GlobEmployee_ {

	public static volatile SingularAttribute<GlobEmployee, String> createBy;
	public static volatile SingularAttribute<GlobEmployee, Date> temp;
	public static volatile SingularAttribute<GlobEmployee, String> lastModBy;
	public static volatile SingularAttribute<GlobEmployee, String> lastModIp;
	public static volatile SingularAttribute<GlobEmployee, Double> rate;
	public static volatile SingularAttribute<GlobEmployee, BigDecimal> id;
	public static volatile SingularAttribute<GlobEmployee, String> employeeNo;
	public static volatile SingularAttribute<GlobEmployee, String> lastMod;
	public static volatile SingularAttribute<GlobEmployee, String> version;
	public static volatile SingularAttribute<GlobEmployee, String> createByIp;
	public static volatile SingularAttribute<GlobEmployee, String> createDate;

	public static final String CREATE_BY = "createBy";
	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String RATE = "rate";
	public static final String ID = "id";
	public static final String EMPLOYEE_NO = "employeeNo";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_DATE = "createDate";

}

