
------------------------------------------------------------------------------
----- SYSTEM -----------------------------------------------------------------
------------------------------------------------------------------------------

-- 
CREATE TABLE notification_track
(
    id             BIGSERIAL    NOT NULL,			
	functionality  VARCHAR(100),
	code           VARCHAR(100),
	ref_id 		   VARCHAR(100),
	sent_to        text,
	sent_from      text,
	ntf_type       VARCHAR(50),
	subject        text,
	content        text,
	unique_token   VARCHAR(255),
    status         VARCHAR(255),
    answer         VARCHAR(255),
	sender_info    VARCHAR(255),
	
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
CREATE UNIQUE INDEX idx_notification_function_ref_id_code ON notification_track (functionality,ref_id,code);

