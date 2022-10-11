package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCorrespd.class)
public abstract class GlobCorrespd_ {

	public static volatile SingularAttribute<GlobCorrespd, String> notes;
	public static volatile SingularAttribute<GlobCorrespd, String> deliveryMethod;
	public static volatile SingularAttribute<GlobCorrespd, String> toCompany;
	public static volatile SingularAttribute<GlobCorrespd, String> subject;
	public static volatile SingularAttribute<GlobCorrespd, GlobUsers> approvedBy;
	public static volatile SingularAttribute<GlobCorrespd, String> description;
	public static volatile SingularAttribute<GlobCorrespd, String> type;
	public static volatile SingularAttribute<GlobCorrespd, String> fromCompany;
	public static volatile SingularAttribute<GlobCorrespd, String> title;
	public static volatile SingularAttribute<GlobCorrespd, String> dcn;
	public static volatile SingularAttribute<GlobCorrespd, String> relatedTo;
	public static volatile SingularAttribute<GlobCorrespd, Date> sentDate;
	public static volatile SingularAttribute<GlobCorrespd, String> toPerson;
	public static volatile SingularAttribute<GlobCorrespd, BigDecimal> id;
	public static volatile SingularAttribute<GlobCorrespd, Date> receivedDate;
	public static volatile SingularAttribute<GlobCorrespd, String> trackingNumber;
	public static volatile SingularAttribute<GlobCorrespd, GlobClient> clientId;
	public static volatile SingularAttribute<GlobCorrespd, GlobFolder> requestedFolderId;
	public static volatile SingularAttribute<GlobCorrespd, String> active;
	public static volatile ListAttribute<GlobCorrespd, GlobFile> globFileList;
	public static volatile SingularAttribute<GlobCorrespd, String> version;
	public static volatile SingularAttribute<GlobCorrespd, Date> approvedDate;
	public static volatile SingularAttribute<GlobCorrespd, String> fromPerson;
	public static volatile SingularAttribute<GlobCorrespd, Date> createdDate;
	public static volatile SingularAttribute<GlobCorrespd, GlobUsers> createdBy;
	public static volatile SingularAttribute<GlobCorrespd, GlobUsers> proccesedBy;
	public static volatile SingularAttribute<GlobCorrespd, String> category;
	public static volatile SingularAttribute<GlobCorrespd, GlobProject> projectId;
	public static volatile SingularAttribute<GlobCorrespd, String> status;
	public static volatile SingularAttribute<GlobCorrespd, GlobFile> fileId;

	public static final String NOTES = "notes";
	public static final String DELIVERY_METHOD = "deliveryMethod";
	public static final String TO_COMPANY = "toCompany";
	public static final String SUBJECT = "subject";
	public static final String APPROVED_BY = "approvedBy";
	public static final String DESCRIPTION = "description";
	public static final String TYPE = "type";
	public static final String FROM_COMPANY = "fromCompany";
	public static final String TITLE = "title";
	public static final String DCN = "dcn";
	public static final String RELATED_TO = "relatedTo";
	public static final String SENT_DATE = "sentDate";
	public static final String TO_PERSON = "toPerson";
	public static final String ID = "id";
	public static final String RECEIVED_DATE = "receivedDate";
	public static final String TRACKING_NUMBER = "trackingNumber";
	public static final String CLIENT_ID = "clientId";
	public static final String REQUESTED_FOLDER_ID = "requestedFolderId";
	public static final String ACTIVE = "active";
	public static final String GLOB_FILE_LIST = "globFileList";
	public static final String VERSION = "version";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String FROM_PERSON = "fromPerson";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String PROCCESED_BY = "proccesedBy";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String FILE_ID = "fileId";

}

