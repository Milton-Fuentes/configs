package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaTicket.class)
public abstract class QaTicket_ {

	public static volatile SingularAttribute<QaTicket, Double> costUnit;
	public static volatile SingularAttribute<QaTicket, BigInteger> supplierId;
	public static volatile SingularAttribute<QaTicket, String> lastModBy;
	public static volatile SingularAttribute<QaTicket, String> deliveryTime;
	public static volatile SingularAttribute<QaTicket, Double> costOther;
	public static volatile SingularAttribute<QaTicket, String> lonGps;
	public static volatile SingularAttribute<QaTicket, String> loadUnit;
	public static volatile SingularAttribute<QaTicket, String> biditemNo;
	public static volatile SingularAttribute<QaTicket, String> latGps;
	public static volatile SingularAttribute<QaTicket, String> lastModIp;
	public static volatile SingularAttribute<QaTicket, String> ticketNo;
	public static volatile SingularAttribute<QaTicket, Date> paidDate;
	public static volatile SingularAttribute<QaTicket, BigDecimal> id;
	public static volatile SingularAttribute<QaTicket, String> docControlno;
	public static volatile SingularAttribute<QaTicket, Date> deliveryDate;
	public static volatile SingularAttribute<QaTicket, String> receivedBy;
	public static volatile SingularAttribute<QaTicket, BigInteger> clientId;
	public static volatile SingularAttribute<QaTicket, String> orderNo;
	public static volatile SingularAttribute<QaTicket, String> routeFrom;
	public static volatile SingularAttribute<QaTicket, String> loadDescript;
	public static volatile SingularAttribute<QaTicket, Character> active;
	public static volatile SingularAttribute<QaTicket, String> altGps;
	public static volatile SingularAttribute<QaTicket, String> version;
	public static volatile SingularAttribute<QaTicket, String> createByIp;
	public static volatile SingularAttribute<QaTicket, String> field1;
	public static volatile SingularAttribute<QaTicket, String> createBy;
	public static volatile SingularAttribute<QaTicket, String> routeTo;
	public static volatile SingularAttribute<QaTicket, Double> loadWt;
	public static volatile SingularAttribute<QaTicket, Date> field6;
	public static volatile SingularAttribute<QaTicket, String> invoiceStatus;
	public static volatile SingularAttribute<QaTicket, String> field3;
	public static volatile SingularAttribute<QaTicket, BigInteger> projectId;
	public static volatile SingularAttribute<QaTicket, Date> orderDate;
	public static volatile SingularAttribute<QaTicket, String> field2;
	public static volatile SingularAttribute<QaTicket, String> lastMod;
	public static volatile SingularAttribute<QaTicket, Double> costInvoice;
	public static volatile SingularAttribute<QaTicket, String> remarks;
	public static volatile SingularAttribute<QaTicket, Double> field5;
	public static volatile SingularAttribute<QaTicket, String> catg;
	public static volatile SingularAttribute<QaTicket, Double> costLoad;
	public static volatile SingularAttribute<QaTicket, String> field4;

	public static final String COST_UNIT = "costUnit";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DELIVERY_TIME = "deliveryTime";
	public static final String COST_OTHER = "costOther";
	public static final String LON_GPS = "lonGps";
	public static final String LOAD_UNIT = "loadUnit";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String LAT_GPS = "latGps";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String TICKET_NO = "ticketNo";
	public static final String PAID_DATE = "paidDate";
	public static final String ID = "id";
	public static final String DOC_CONTROLNO = "docControlno";
	public static final String DELIVERY_DATE = "deliveryDate";
	public static final String RECEIVED_BY = "receivedBy";
	public static final String CLIENT_ID = "clientId";
	public static final String ORDER_NO = "orderNo";
	public static final String ROUTE_FROM = "routeFrom";
	public static final String LOAD_DESCRIPT = "loadDescript";
	public static final String ACTIVE = "active";
	public static final String ALT_GPS = "altGps";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String FIELD1 = "field1";
	public static final String CREATE_BY = "createBy";
	public static final String ROUTE_TO = "routeTo";
	public static final String LOAD_WT = "loadWt";
	public static final String FIELD6 = "field6";
	public static final String INVOICE_STATUS = "invoiceStatus";
	public static final String FIELD3 = "field3";
	public static final String PROJECT_ID = "projectId";
	public static final String ORDER_DATE = "orderDate";
	public static final String FIELD2 = "field2";
	public static final String LAST_MOD = "lastMod";
	public static final String COST_INVOICE = "costInvoice";
	public static final String REMARKS = "remarks";
	public static final String FIELD5 = "field5";
	public static final String CATG = "catg";
	public static final String COST_LOAD = "costLoad";
	public static final String FIELD4 = "field4";

}

