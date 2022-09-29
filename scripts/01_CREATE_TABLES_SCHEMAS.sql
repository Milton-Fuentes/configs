------------------------------------------------------------------------------
----- SCHEMAS ----------------------------------------------------------------
------------------------------------------------------------------------------

CREATE SCHEMA admin AUTHORIZATION postgres;
CREATE SCHEMA trackit AUTHORIZATION postgres;
CREATE SCHEMA assureit AUTHORIZATION postgres;
CREATE SCHEMA common AUTHORIZATION postgres;


------------------------------------------------------------------------------
----- SYSTEM -----------------------------------------------------------------
------------------------------------------------------------------------------

-- adm_module
CREATE TABLE admin.adm_module
(
    id             BIGSERIAL NOT NULL,
	code           VARCHAR(50) NOT NULL,
    name           VARCHAR(150),
	description    VARCHAR(255),
    start_page     VARCHAR(255),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);


-- adm_functionality
CREATE TABLE admin.adm_functionality
(
    id             BIGSERIAL NOT NULL,
	code           VARCHAR(50) NOT NULL,
    name           VARCHAR(150),
    description    VARCHAR(255),
	display        VARCHAR(150),
	url            VARCHAR(2000),    
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, name, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_functionality_name ON admin.adm_functionality (name);

-- adm_user
CREATE TABLE admin.adm_user
(
    id                      BIGSERIAL    NOT NULL,
    username                VARCHAR(255) NOT NULL,
    email                   VARCHAR(255),
    password                VARCHAR(255),
    first_name              VARCHAR(255),
	middle_name             VARCHAR(255),
    last_name               VARCHAR(255),
    title                   VARCHAR(50),
    job_title               VARCHAR(255),
	profile_image_url       VARCHAR(512),
    last_login_date         TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,
    last_login_date_display TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    joined_date             TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,    
    locked                  BOOLEAN     DEFAULT FALSE,
	created_by              BIGINT,
    creation_date           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by          BIGINT,
    enabled                 BOOLEAN NOT NULL DEFAULT TRUE,
    deleted                 BOOLEAN NOT NULL DEFAULT FALSE,
    version                 INT4,
    UNIQUE (username, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_user_name ON admin.adm_user (username);


-- adm_role
CREATE TABLE admin.adm_role
(
    id             BIGSERIAL    NOT NULL,
    code           VARCHAR(50) NOT NULL,
    name           VARCHAR(150),
    description    VARCHAR(255),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_role_name ON admin.adm_role (name);


-- adm_authority
CREATE TABLE admin.adm_authority
(
    id             		BIGSERIAL    NOT NULL,
    role_id        		BIGINT       NOT NULL,
	functionality_id    BIGINT       NOT NULL,    
    has_right      		BOOLEAN      NOT NULL DEFAULT FALSE,
    created_by     		BIGINT,
    creation_date  		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 		BIGINT,
    enabled        		BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        		BOOLEAN NOT NULL DEFAULT FALSE,
    version        		INT4,
    UNIQUE (functionality_id, role_id, deleted),
    PRIMARY KEY (id)
);
ALTER TABLE admin.adm_authority ADD CONSTRAINT fk_auth_role_id FOREIGN KEY (role_id) REFERENCES admin.adm_role (id);
ALTER TABLE admin.adm_authority ADD CONSTRAINT fk_auth_function_id FOREIGN KEY (functionality_id) REFERENCES admin.adm_functionality (id);


-- adm_company
CREATE TABLE admin.adm_company
(
    id             BIGSERIAL    NOT NULL,	
	code           VARCHAR(50) NOT NULL,
	name           VARCHAR(150),
	description    VARCHAR(255),			
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, name, deleted),
    PRIMARY KEY (id)
);


-- adm_client
CREATE TABLE admin.adm_client
(
    id             BIGSERIAL    NOT NULL,	
	company_id	   BIGINT    NOT NULL,	
	code           VARCHAR(50) NOT NULL,
	name           VARCHAR(150),
	description    VARCHAR(255),			
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_client_code ON admin.adm_client (code);
ALTER TABLE admin.adm_client ADD CONSTRAINT fk_client_company_id FOREIGN KEY (company_id) REFERENCES admin.adm_company (id);


-- adm_client_role
CREATE TABLE admin.adm_client_role
(
    id             BIGSERIAL    NOT NULL,							  
	role_id        BIGINT    NOT NULL,			
	client_id      BIGINT    NOT NULL,		
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (client_id, role_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_client_role ON admin.adm_client_role (client_id, role_id);
ALTER TABLE admin.adm_client_role ADD CONSTRAINT fk_client_role_id FOREIGN KEY (role_id) REFERENCES admin.adm_role (id);
ALTER TABLE admin.adm_client_role ADD CONSTRAINT fk_client_role_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_client_module
CREATE TABLE admin.adm_client_module
(
    id             BIGSERIAL    NOT NULL,							  	
	module_id      BIGINT    NOT NULL,			
	client_id      BIGINT    NOT NULL,	
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (client_id, module_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_client_module ON admin.adm_client_module (client_id, module_id);
ALTER TABLE admin.adm_client_module ADD CONSTRAINT fk_client_module_id FOREIGN KEY (module_id) REFERENCES admin.adm_module (id);
ALTER TABLE admin.adm_client_module ADD CONSTRAINT fk_client_role_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_profile
CREATE TABLE admin.adm_profile
(
    id             BIGSERIAL NOT NULL,
    user_id        BIGINT    NOT NULL,
    role_id        BIGINT    NOT NULL,
	client_id      BIGINT    NOT NULL,
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (user_id, role_id, deleted),
    PRIMARY KEY (id)
);
ALTER TABLE admin.adm_profile ADD CONSTRAINT fk_profile_user_id FOREIGN KEY (user_id) REFERENCES admin.adm_user (id);
ALTER TABLE admin.adm_profile ADD CONSTRAINT fk_profile_role_id FOREIGN KEY (role_id) REFERENCES admin.adm_role (id);
ALTER TABLE admin.adm_profile ADD CONSTRAINT fk_profile_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_report
CREATE TABLE admin.adm_report
(
    id             BIGSERIAL    NOT NULL,			
	functionality  VARCHAR(100),
	code           VARCHAR(100),
	name           VARCHAR(255),
	path           VARCHAR(4000),		
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_report_function ON admin.adm_report (functionality);


-- adm_subreport
CREATE TABLE admin.adm_subreport
(
    id             	BIGSERIAL    NOT NULL,			
	code           	VARCHAR(100),
	name 			VARCHAR(255),
	path 			VARCHAR(4000),				
    created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);


-- adm_report_subreport
CREATE TABLE admin.adm_report_subreport
(
    id             	BIGSERIAL    NOT NULL,		
	report_id      	BIGINT    NOT NULL,	
	subreport_id  	BIGINT    NOT NULL,				
    created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    UNIQUE (report_id, subreport_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_report_subreport ON admin.adm_report_subreport (report_id, subreport_id);
ALTER TABLE admin.adm_report_subreport ADD CONSTRAINT fk_report_subreport_report_id FOREIGN KEY (report_id) REFERENCES admin.adm_report (id);
ALTER TABLE admin.adm_report_subreport ADD CONSTRAINT fk_report_subreport_subreport_id FOREIGN KEY (subreport_id) REFERENCES admin.adm_subreport (id);


-- adm_client_report
CREATE TABLE admin.adm_client_report
(
    id             	BIGSERIAL    NOT NULL,							  	
	report_id       BIGINT    NOT NULL,			
	client_id      	BIGINT    NOT NULL,	
    created_by     	INT8,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    UNIQUE (client_id, report_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_client_report ON admin.adm_client_report (client_id, report_id);
ALTER TABLE admin.adm_client_report ADD CONSTRAINT fk_client_module_id FOREIGN KEY (report_id) REFERENCES admin.adm_report (id);
ALTER TABLE admin.adm_client_report ADD CONSTRAINT fk_client_role_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_simple_catalog
CREATE TABLE admin.adm_simple_catalog
(
    id             BIGSERIAL    NOT NULL,	 
	parent_id      BIGINT,    
	client_id      BIGINT,   
    code           VARCHAR(50) NOT NULL,
    name           VARCHAR(150),
    description    VARCHAR(255),
	editable       BOOLEAN,
    c_order        INT4,
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, name, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_simple_catalog_parent ON admin.adm_simple_catalog (parent_id);
ALTER TABLE admin.adm_simple_catalog ADD CONSTRAINT fk_simple_catalog_parent_id FOREIGN KEY (parent_id) REFERENCES admin.adm_simple_catalog (id);
ALTER TABLE admin.adm_simple_catalog ADD CONSTRAINT fk_simple_catalog_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_menu
CREATE TABLE admin.adm_menu
(
    id             		BIGSERIAL    NOT NULL,							  
	parent_id      		BIGINT    NOT NULL,		
	module_id      		BIGINT    NOT NULL,
	client_id      		BIGINT    NOT NULL,	
	type_id        		BIGINT    NOT NULL,	
	functionality_id    BIGINT    NOT NULL,	
	code           		VARCHAR(50) NOT NULL,
	name           		VARCHAR(150),
	description    		VARCHAR(255),	
	ordering       		INT4,
	icon           		VARCHAR(50),	
    created_by     		BIGINT,
    creation_date  		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 		BIGINT,
    enabled        		BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        		BOOLEAN NOT NULL DEFAULT FALSE,
    version        		INT4,
    UNIQUE (code, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_menu_client ON admin.adm_menu (client_id);
ALTER TABLE admin.adm_menu ADD CONSTRAINT fk_menu_parent_id FOREIGN KEY (parent_id) REFERENCES admin.adm_menu (id);
ALTER TABLE admin.adm_menu ADD CONSTRAINT fk_menu_module_id FOREIGN KEY (module_id) REFERENCES admin.adm_module (id);
ALTER TABLE admin.adm_menu ADD CONSTRAINT fk_menu_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);
ALTER TABLE admin.adm_menu ADD CONSTRAINT fk_menu_type_id FOREIGN KEY (type_id) REFERENCES admin.adm_simple_catalog (id);
ALTER TABLE admin.adm_menu ADD CONSTRAINT fk_menu_functionality_id FOREIGN KEY (functionality_id) REFERENCES admin.adm_functionality (id);


-- adm_notification
CREATE TABLE admin.adm_notification (
	id 				BIGSERIAL NOT NULL,    
	client_id		BIGINT NOT NULL,
	reference_id    BIGINT NOT NULL,
	type_id			BIGINT NOT NULL,	
	title  			VARCHAR(255),
	content			TEXT,	
	created_by      BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (client_id, reference_id, type_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_notification_client ON admin.adm_notification (type_id, client_id);
CREATE INDEX idx_notification_reference ON admin.adm_notification (type_id, reference_id);
ALTER TABLE admin.adm_notification ADD CONSTRAINT fk_notification_type_id FOREIGN KEY (type_id) REFERENCES admin.adm_simple_catalog (id);
ALTER TABLE admin.adm_notification ADD CONSTRAINT fk_notification_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- adm_notification
CREATE TABLE admin.adm_notification_user (
	id 				BIGSERIAL NOT NULL,    
	user_id			BIGINT NOT NULL,
	notification_id BIGINT NOT NULL,	
	created_by      BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (user_id, notification_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_notification_user ON admin.adm_notification_user (notification_id, user_id);
ALTER TABLE admin.adm_notification_user ADD CONSTRAINT fk_notification_user_user_id FOREIGN KEY (user_id) REFERENCES admin.adm_user (id);
ALTER TABLE admin.adm_notification_user ADD CONSTRAINT fk_notification_user_notification_id FOREIGN KEY (notification_id) REFERENCES admin.adm_notification (id);


------------------------------------------------------------------------------
----- COMMON -----------------------------------------------------------------
------------------------------------------------------------------------------

-- glob_contact
CREATE TABLE common.glob_contact (
	id 				BIGSERIAL NOT NULL,	
	client_id      	BIGINT    NOT NULL,	
	sex_id      	BIGINT    NOT NULL,	
	nick_name		VARCHAR(50) NOT NULL,
	first_name		VARCHAR(50) NOT NULL,
	middle_name		VARCHAR(50) NOT NULL,
	last_name		VARCHAR(50) NOT NULL,
	dob 			TIMESTAMP,		
	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    PRIMARY KEY (id)
);
ALTER TABLE common.glob_contact ADD CONSTRAINT fk_contact_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);
ALTER TABLE common.glob_contact ADD CONSTRAINT fk_contact_sex_id FOREIGN KEY (sex_id) REFERENCES admin.adm_simple_catalog (id);



-- glob_country
CREATE TABLE common.glob_country
(
    id             BIGSERIAL    NOT NULL,
    code           VARCHAR(50) NOT NULL,
    name           VARCHAR(150),
    description    VARCHAR(255),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, name, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_country_name ON common.glob_country (name);

-- glob_state
CREATE TABLE common.glob_state
(
    id             BIGSERIAL    NOT NULL,
	country_id     BIGINT       NOT NULL,
    code           VARCHAR(50)  NOT NULL,
    name           VARCHAR(150),
    description    VARCHAR(255),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (code, name, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_state_country ON common.glob_state (country_id);
ALTER TABLE common.glob_state ADD CONSTRAINT fk_state_country_id FOREIGN KEY (country_id) REFERENCES common.glob_country (id);


-- glob_address
CREATE TABLE common.glob_address (
	id 				BIGSERIAL NOT NULL,
    contact_id      BIGINT    NOT NULL,
	state_id 		BIGINT    NOT NULL,-- state, province, region
	country_id		BIGINT    NOT NULL,
	type_id			BIGINT    NOT NULL,
	street 			VARCHAR(255),-- street number and name
	apt 			VARCHAR(25),-- apartment , suite, unit, building, floor, etc.
	zip 			VARCHAR(10),-- zip/postal code
	city 			VARCHAR(50),-- city or town	
	created_by      BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	PRIMARY KEY (id)
);
ALTER TABLE common.glob_address ADD CONSTRAINT fk_address_contact_id FOREIGN KEY (contact_id) REFERENCES common.glob_contact (id);
ALTER TABLE common.glob_address ADD CONSTRAINT fk_address_state_id FOREIGN KEY (state_id) REFERENCES common.glob_state (id);
ALTER TABLE common.glob_address ADD CONSTRAINT fk_address_country_id FOREIGN KEY (country_id) REFERENCES common.glob_country (id);
ALTER TABLE common.glob_address ADD CONSTRAINT fk_address_type_id FOREIGN KEY (type_id) REFERENCES admin.adm_simple_catalog (id);


-- glob_phone
CREATE TABLE common.glob_phone (
	id 				BIGSERIAL NOT NULL,    
	contact_id      BIGINT NOT NULL,
	type_id			BIGINT NOT NULL,
	number          VARCHAR(50) NOT NULL,
	description     VARCHAR(255) NOT NULL,			
	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (contact_id, number, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_phone_number ON common.glob_phone (number);
ALTER TABLE common.glob_phone ADD CONSTRAINT fk_phone_contact_id FOREIGN KEY (contact_id) REFERENCES common.glob_contact (id);
ALTER TABLE common.glob_phone ADD CONSTRAINT fk_phone_type_id FOREIGN KEY (type_id) REFERENCES admin.adm_simple_catalog (id);


-- glob_email
CREATE TABLE common.glob_email (
	id 				BIGSERIAL NOT NULL,    
	contact_id      BIGINT NOT NULL,
	type_id			BIGINT NOT NULL,
	address         VARCHAR(50) NOT NULL,
	description     VARCHAR(255) NOT NULL,			
	created_by      BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (contact_id, address, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_email_address ON common.glob_email (address);
ALTER TABLE common.glob_email ADD CONSTRAINT fk_email_contact_id FOREIGN KEY (contact_id) REFERENCES common.glob_contact (id);
ALTER TABLE common.glob_email ADD CONSTRAINT fk_email_type_id FOREIGN KEY (type_id) REFERENCES admin.adm_simple_catalog (id);


-- glob_project
CREATE TABLE common.glob_project (
	id 				BIGSERIAL NOT NULL,   
	client_id		BIGINT NOT NULL,	
	code            VARCHAR(50)  NOT NULL,
    name            VARCHAR(150),
    description     VARCHAR(255),
    created_by      BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (code, name, client_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_project_code ON common.glob_project (code, client_id);
ALTER TABLE common.glob_project ADD CONSTRAINT fk_project_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


------------------------------------------------------------------------------
----- MODEL ------------------------------------------------------------------
------------------------------------------------------------------------------

CREATE TABLE common.glob_model (
	id 				BIGSERIAL NOT NULL,	
	first_name      VARCHAR(100),
	middle_name     VARCHAR(100),
	last_name       VARCHAR(100),
	dob             TIMESTAMP,
	email           VARCHAR(50),
	contact_number  VARCHAR(20),
   	created_by     	BIGINT,
    creation_date  	timestamp          DEFAULT current_timestamp,
    last_update    	timestamp          DEFAULT current_timestamp,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN   NOT NULL DEFAULT FALSE,
    version       	INT4,
	UNIQUE (email),
	PRIMARY KEY (id)
);


------------------------------------------------------------------------------
----- TRACKIT ----------------------------------------------------------------
------------------------------------------------------------------------------

-- tk_folder_default
CREATE TABLE trackit.tk_folder_default
(
    id             BIGSERIAL NOT NULL,				
	name           VARCHAR(255),
	description    VARCHAR(4000),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
	UNIQUE (name, deleted),	
    PRIMARY KEY (id)
);


-- tk_folder_default_link
CREATE TABLE trackit.tk_folder_default_link
(
    id        		BIGSERIAL NOT NULL,
	child_id  		BIGINT    NOT NULL,	
	parent_id 		BIGINT    NOT NULL,		
    created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    UNIQUE (child_id, parent_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_folder_default_link ON trackit.tk_folder_default_link (child_id, parent_id);
ALTER TABLE trackit.tk_folder_default_link ADD CONSTRAINT fk_folder_default_link_child_id FOREIGN KEY (child_id) REFERENCES trackit.tk_folder_default(id);
ALTER TABLE trackit.tk_folder_default_link ADD CONSTRAINT fk_folder_default_link_parent_id FOREIGN KEY (parent_id) REFERENCES trackit.tk_folder_default (id);


-- tk_folder
CREATE TABLE trackit.tk_folder
(
    id             BIGSERIAL NOT NULL,
	parent_id	   BIGINT    NOT NULL,	
	default_id     BIGINT    NOT NULL,	
	project_id     BIGINT    NOT NULL,	
	client_id      BIGINT    NOT NULL,	
	name           VARCHAR(255),
	description    VARCHAR(4000),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
	UNIQUE (name, parent_id, deleted),	
    PRIMARY KEY (id)
);
CREATE INDEX idx_folder_parent_id ON trackit.tk_folder (parent_id);
ALTER TABLE trackit.tk_folder ADD CONSTRAINT fk_folder_parent_id FOREIGN KEY (parent_id) REFERENCES trackit.tk_folder(id);
ALTER TABLE trackit.tk_folder ADD CONSTRAINT fk_folder_default_id FOREIGN KEY (default_id) REFERENCES trackit.tk_folder_default (id);
ALTER TABLE trackit.tk_folder ADD CONSTRAINT fk_folder_project_id FOREIGN KEY (project_id) REFERENCES common.glob_project (id);
ALTER TABLE trackit.tk_folder ADD CONSTRAINT fk_folder_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);


-- tk_folder_map
CREATE TABLE trackit.tk_folder_map
(
    id             		BIGSERIAL NOT NULL,
	folder_default_id  	BIGINT    NOT NULL,	
	functionality_id    BIGINT    NOT NULL,	
	client_id			BIGINT    NOT NULL,	
    created_by     		BIGINT,
    creation_date  		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 		BIGINT,
    enabled        		BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        		BOOLEAN NOT NULL DEFAULT FALSE,
    version        		INT4,
    PRIMARY KEY (id)
);
ALTER TABLE trackit.tk_folder_map ADD CONSTRAINT fk_folder_map_folder_default_id FOREIGN KEY (folder_default_id) REFERENCES trackit.tk_folder_default(id);
ALTER TABLE trackit.tk_folder_map ADD CONSTRAINT fk_folder_map_functionality_id FOREIGN KEY (functionality_id) REFERENCES admin.adm_functionality(id);
ALTER TABLE trackit.tk_folder_map ADD CONSTRAINT fk_folder_map_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client(id);


-- tk_folder_subscription
CREATE TABLE trackit.tk_folder_subscription
(
    id             BIGSERIAL NOT NULL,
	folder_id      BIGINT    NOT NULL,
	subscriber_id  BIGINT    NOT NULL,
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (folder_id, subscriber_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_folder_subscription ON trackit.tk_folder_subscription (folder_id, subscriber_id);
ALTER TABLE trackit.tk_folder_subscription ADD CONSTRAINT fk_folder_subscription_file_id FOREIGN KEY (folder_id) REFERENCES trackit.tk_folder (id);
ALTER TABLE trackit.tk_folder_subscription ADD CONSTRAINT fk_folder_subscription_subscriber_id FOREIGN KEY (subscriber_id) REFERENCES admin.adm_user (id);


-- tk_file
CREATE TABLE trackit.tk_file
(
    id             BIGSERIAL NOT NULL,
	folder_id      BIGINT    NOT NULL,	
	project_id     BIGINT    NOT NULL,		
	extension_id   BIGINT    NOT NULL,	
	title          VARCHAR(255),
	name           VARCHAR(255),
	extension      VARCHAR(10),
	size           DOUBLE PRECISION,
	path           VARCHAR(4000),
	source_name    VARCHAR(255),
	source_path    VARCHAR(4000),
	dcn            VARCHAR(100),	
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (name, folder_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_file_folder_id ON trackit.tk_file (folder_id); 
ALTER TABLE trackit.tk_file ADD CONSTRAINT tk_file_folder_id FOREIGN KEY (folder_id) REFERENCES trackit.tk_folder (id);
ALTER TABLE trackit.tk_file ADD CONSTRAINT tk_file_project_id FOREIGN KEY (project_id) REFERENCES common.glob_project (id);
ALTER TABLE trackit.tk_file ADD CONSTRAINT tk_file_extension_id FOREIGN KEY (extension_id) REFERENCES admin.adm_simple_catalog (id);


-- tk_file_version
CREATE TABLE trackit.tk_file_version
(
    id             BIGSERIAL NOT NULL,
	file_id        BIGINT    NOT NULL,	
	extension_id   BIGINT    NOT NULL,
	title          VARCHAR(255),
	name           VARCHAR(255),
	extension      VARCHAR(10),
	size           DOUBLE PRECISION,
	path           VARCHAR(4000),
	source_name    VARCHAR(255),
	source_path    VARCHAR(4000),
	dcn            VARCHAR(100),	
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    PRIMARY KEY (id)
);
CREATE INDEX idx_file_version ON trackit.tk_file_version (file_id);
ALTER TABLE trackit.tk_file_version ADD CONSTRAINT fk_file_version_file_id FOREIGN KEY (file_id) REFERENCES trackit.tk_file (id);
ALTER TABLE trackit.tk_file_version ADD CONSTRAINT fk_file_version_extension_id FOREIGN KEY (extension_id) REFERENCES admin.adm_simple_catalog (id);


-- tk_file_subscription
CREATE TABLE trackit.tk_file_subscription
(
    id             BIGSERIAL NOT NULL,
	file_id        BIGINT    NOT NULL,
	subscriber_id  BIGINT    NOT NULL,
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (file_id, subscriber_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_file_subscription ON trackit.tk_file_subscription (file_id, subscriber_id);
ALTER TABLE trackit.tk_file_subscription ADD CONSTRAINT fk_file_subscription_file_id FOREIGN KEY (file_id) REFERENCES trackit.tk_file (id);
ALTER TABLE trackit.tk_file_subscription ADD CONSTRAINT fk_file_subscription_subscriber_id FOREIGN KEY (subscriber_id) REFERENCES admin.adm_user (id);


-- tk_annotation
CREATE TABLE trackit.tk_annotation
(
    id             BIGSERIAL NOT NULL,
	file_id        BIGINT    NOT NULL,	
	name           VARCHAR(100),
	title          VARCHAR(255),
	remarks        VARCHAR(500),
	subject        VARCHAR(50),
	type           VARCHAR(50),
	sub_type       VARCHAR(50),
	page_number    INT8,
	metadata       TEXT,
	created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (name, file_id, deleted),
    PRIMARY KEY (id)
);
CREATE INDEX idx_annotation_file_id ON trackit.tk_annotation (file_id);
ALTER TABLE trackit.tk_annotation ADD CONSTRAINT fk_annotation_file_id FOREIGN KEY (file_id) REFERENCES trackit.tk_file (id);


-- tk_annotation_remark
CREATE TABLE trackit.tk_annotation_remark
(
    id             BIGSERIAL NOT NULL,
	annotation_id  BIGINT    NOT NULL,	
	content        VARCHAR(500),
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    PRIMARY KEY (id)
);
CREATE INDEX idx_annotation_remark ON trackit.tk_annotation_remark (annotation_id);
ALTER TABLE trackit.tk_annotation_remark ADD CONSTRAINT fk_annotation_remark_annotation_id FOREIGN KEY (annotation_id) REFERENCES trackit.tk_annotation (id);

------------------------------------------------------------------------------
----- ASSUREIT ---------------------------------------------------------------
------------------------------------------------------------------------------

-- qa_material_category
CREATE TABLE assureit.qa_material_category (
	id 				BIGSERIAL NOT NULL,
	code            VARCHAR(50) NOT NULL,
    name            VARCHAR(150),
    description     VARCHAR(255),		
	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (code, deleted),
	PRIMARY KEY (id)
);


-- qa_test_method
CREATE TABLE assureit.qa_test_method
(
    id 			    BIGSERIAL NOT NULL,
	category_id 	BIGINT,
    code            VARCHAR(50) NOT NULL,
    name            VARCHAR(150),
    description     VARCHAR(255),
    use_sample 		BOOLEAN,		
	created_by      BIGINT,
    creation_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by  BIGINT,
    enabled         BOOLEAN NOT NULL DEFAULT TRUE,
    deleted         BOOLEAN NOT NULL DEFAULT FALSE,
    version         INT4,
	UNIQUE (code, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_test_method_category ON assureit.qa_test_method (category_id);
ALTER TABLE assureit.qa_test_method ADD CONSTRAINT fk_test_method_category_id FOREIGN KEY (category_id) REFERENCES assureit.qa_material_category (id);


-- qa_test_method_client
CREATE TABLE assureit.qa_test_method_client (
	id 				BIGSERIAL NOT NULL,
	client_id       BIGINT,
	test_method_id  BIGINT,
   	created_by      BIGINT,
    creation_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by  BIGINT,
    enabled         BOOLEAN NOT NULL DEFAULT TRUE,
    deleted         BOOLEAN NOT NULL DEFAULT FALSE,
    version         INT4,
	UNIQUE (test_method_id, client_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_test_method_client ON assureit.qa_test_method_client (test_method_id, client_id);
ALTER TABLE assureit.qa_test_method_client ADD CONSTRAINT fk_test_method_client_client_id FOREIGN KEY (client_id) REFERENCES admin.adm_client (id);
ALTER TABLE assureit.qa_test_method_client ADD CONSTRAINT fk_test_method_client_test_method_id FOREIGN KEY (test_method_id) REFERENCES assureit.qa_test_method (id);


-- qa_work_order
CREATE TABLE assureit.qa_work_order (
	id 				BIGSERIAL NOT NULL,
	project_id		BIGINT,	
	number          VARCHAR(50) NOT NULL,	
	service_date	TIMESTAMP,	
	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (number, project_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_work_order_project ON assureit.qa_work_order (project_id);
ALTER TABLE assureit.qa_work_order ADD CONSTRAINT fk_work_order_project_id FOREIGN KEY (project_id) REFERENCES common.glob_project (id);


-- qa_sample
CREATE TABLE assureit.qa_sample (
	id 				BIGSERIAL NOT NULL,
	project_id 		BIGINT,
	material_category_id 	BIGINT,
	work_order_id 	BIGINT,
	-- supplier_id 	BIGINT,
	-- mix_design_id 	BIGINT,
	-- lab_id 			BIGINT,	
	number 		VARCHAR(100),
	sampled_date 	DATE,		
   	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (number, project_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_sample_project ON assureit.qa_sample (project_id);
ALTER TABLE assureit.qa_sample ADD CONSTRAINT fk_sample_project_id FOREIGN KEY (project_id) REFERENCES common.glob_project (id);
ALTER TABLE assureit.qa_sample ADD CONSTRAINT fk_sample_category_id FOREIGN KEY (material_category_id) REFERENCES assureit.qa_material_category (id);
ALTER TABLE assureit.qa_sample ADD CONSTRAINT fk_sample_work_order_id FOREIGN KEY (work_order_id) REFERENCES assureit.qa_work_order (id);


-- qa_sample_specimen
CREATE TABLE assureit.qa_sample_specimen (
	id 					 BIGSERIAL NOT NULL,
	sample_id			 BIGINT,
	material_category_id BIGINT,
	number				 VARCHAR(50),	
   	created_by     		 BIGINT,
    creation_date  		 timestamp          DEFAULT current_timestamp,
    last_update    		 timestamp          DEFAULT current_timestamp,
    last_update_by 		 BIGINT,
    enabled        		 BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        		 BOOLEAN   NOT NULL DEFAULT FALSE,
    version       		 INT4,
	UNIQUE (number, sample_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_sample_specimen ON assureit.qa_sample_specimen (sample_id);
ALTER TABLE assureit.qa_sample_specimen ADD CONSTRAINT fk_sample_specimen_sample_id FOREIGN KEY (sample_id) REFERENCES assureit.qa_sample (id);
ALTER TABLE assureit.qa_sample_specimen ADD CONSTRAINT fk_sample_specimen_material_category_id FOREIGN KEY (material_category_id) REFERENCES assureit.qa_material_category (id);


-- qa_sample_test
CREATE TABLE assureit.qa_sample_test (
	id 				BIGSERIAL NOT NULL,
	sample_id 		BIGINT,
	work_order_id   BIGINT,
	status_id		BIGINT,
	test_method_id	BIGINT,
	-- lab_id			BIGINT,
	number 			VARCHAR(50),	
   	created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
	UNIQUE (number, sample_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_sample_test ON assureit.qa_sample_test (sample_id);
ALTER TABLE assureit.qa_sample_test ADD CONSTRAINT fk_sample_test_test_method_id FOREIGN KEY (test_method_id) REFERENCES assureit.qa_test_method (id);
ALTER TABLE assureit.qa_sample_test ADD CONSTRAINT fk_sample_test_sample_id FOREIGN KEY (sample_id) REFERENCES assureit.qa_sample (id);
ALTER TABLE assureit.qa_sample_test ADD CONSTRAINT fk_sample_test_work_order_id FOREIGN KEY (work_order_id) REFERENCES assureit.qa_work_order (id);
ALTER TABLE assureit.qa_sample_test ADD CONSTRAINT tk_sample_test_status_id FOREIGN KEY (status_id) REFERENCES admin.adm_simple_catalog (id);


-- qa_test
CREATE TABLE assureit.qa_test (
	id 				BIGSERIAL NOT NULL,	
	sample_test_id  BIGINT,
   	created_by     	BIGINT,
    creation_date  	timestamp          DEFAULT current_timestamp,
    last_update    	timestamp          DEFAULT current_timestamp,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN   NOT NULL DEFAULT FALSE,
    version       	INT4,
	UNIQUE (sample_test_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_test_sample_test ON assureit.qa_test (sample_test_id);
ALTER TABLE assureit.qa_test ADD CONSTRAINT fk_test_sample_test_id FOREIGN KEY (sample_test_id) REFERENCES assureit.qa_sample_test (id);


-- qa_testout
CREATE TABLE assureit.qa_testout (
	id 					BIGSERIAL NOT NULL,
	test_id				BIGINT,
	sample_specimen_id  BIGINT,	
   	created_by     		BIGINT,
    creation_date  		timestamp          DEFAULT current_timestamp,
    last_update    		timestamp          DEFAULT current_timestamp,
    last_update_by 		BIGINT,
    enabled        		BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        		BOOLEAN   NOT NULL DEFAULT FALSE,
    version       		INT4,
	UNIQUE (sample_specimen_id, test_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_testout_test ON assureit.qa_testout (test_id);
ALTER TABLE assureit.qa_testout ADD CONSTRAINT fk_testout_test_id FOREIGN KEY (test_id) REFERENCES assureit.qa_test (id);
ALTER TABLE assureit.qa_testout ADD CONSTRAINT fk_testout_sample_specimen_id FOREIGN KEY (sample_specimen_id) REFERENCES assureit.qa_sample_specimen (id);


-- qa_originator
CREATE TABLE assureit.qa_originator (
	id 				BIGSERIAL NOT NULL,
	code            VARCHAR(50)  NOT NULL,
    name            VARCHAR(150),
	standard_originator VARCHAR(50),
    description     VARCHAR(255),
   	created_by     	BIGINT,
    creation_date  	timestamp          DEFAULT current_timestamp,
    last_update    	timestamp          DEFAULT current_timestamp,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN   NOT NULL DEFAULT FALSE,
    version       	INT4,
	UNIQUE (code, deleted),
	PRIMARY KEY (id)
);


-- qa_specification
CREATE TABLE assureit.qa_specification (
	id 				BIGSERIAL NOT NULL,
	originator_id	BIGINT,
	code            VARCHAR(255)  NOT NULL,
    name            VARCHAR(150),
	reference       VARCHAR(255),
    description     VARCHAR(255),
   	created_by     	BIGINT,
    creation_date  	timestamp          DEFAULT current_timestamp,
    last_update    	timestamp          DEFAULT current_timestamp,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN   NOT NULL DEFAULT FALSE,
    version       	INT4,
	UNIQUE (code,originator_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_specification_originator ON assureit.qa_specification (originator_id);
ALTER TABLE assureit.qa_specification ADD CONSTRAINT fk_specification_originator_id FOREIGN KEY (originator_id) REFERENCES assureit.qa_originator (id);
--ALTER TABLE public.qa_specification    ALTER COLUMN code TYPE character varying(255) COLLATE pg_catalog."default";

-- qa_specification_test_method
CREATE TABLE assureit.qa_specification_test_method (
	id 				 BIGSERIAL NOT NULL,
	specification_id BIGINT,
	test_method_id	 BIGINT,
   	created_by     	 BIGINT,
    creation_date  	 timestamp          DEFAULT current_timestamp,
    last_update    	 timestamp          DEFAULT current_timestamp,
    last_update_by 	 BIGINT,
    enabled        	 BOOLEAN   NOT NULL DEFAULT TRUE,
    deleted        	 BOOLEAN   NOT NULL DEFAULT FALSE,
    version       	 INT4,
	UNIQUE (specification_id, test_method_id, deleted),
	PRIMARY KEY (id)
);
CREATE INDEX idx_specification_test_method ON assureit.qa_specification_test_method (specification_id, test_method_id);
ALTER TABLE assureit.qa_specification_test_method ADD CONSTRAINT fk_specification_test_method_specification_id FOREIGN KEY (specification_id) REFERENCES assureit.qa_specification (id);
ALTER TABLE assureit.qa_specification_test_method ADD CONSTRAINT fk_specification_test_method_test_method_id FOREIGN KEY (test_method_id) REFERENCES assureit.qa_test_method (id);

