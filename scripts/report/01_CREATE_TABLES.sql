
------------------------------------------------------------------------------
----- SYSTEM -----------------------------------------------------------------
------------------------------------------------------------------------------

-- adm_report
CREATE TABLE report
(
    id             BIGSERIAL    NOT NULL,			
	functionality  VARCHAR(100),
	code           VARCHAR(100),
	ref_id 		   VARCHAR(100),
	name           VARCHAR(255),
	path           VARCHAR(4000),		
    created_by     BIGINT,
    creation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    enabled        BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN NOT NULL DEFAULT FALSE,
    version        INT4,
    UNIQUE (functionality,ref_id,code, deleted),
    PRIMARY KEY (id)
);
CREATE UNIQUE INDEX idx_report_function_ref_id_code ON report (functionality,ref_id,code);


-- subreport
CREATE TABLE subreport
(
    id             	BIGSERIAL    NOT NULL,	
	report_id       BIGINT       NOT NULL,
	name 			VARCHAR(255),
	path 			VARCHAR(4000),				
    created_by     	BIGINT,
    creation_date  	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update    	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by 	BIGINT,
    enabled        	BOOLEAN NOT NULL DEFAULT TRUE,
    deleted        	BOOLEAN NOT NULL DEFAULT FALSE,
    version        	INT4,
    UNIQUE (report_id, deleted),
    PRIMARY KEY (id)
);
ALTER TABLE subreport ADD CONSTRAINT fk_report_subreport_id FOREIGN KEY (report_id) REFERENCES report (id);
