----------------------------------------------------------------------------------------
---------------------------------DATABASE CONFIGURATION-------------------------------
----------------------------------------------------------------------------------------
CREATE DATABASE report_ms
    WITH 
    OWNER = postgres
    TEMPLATE = template0
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE report_ms
    IS 'Manage MS DB';

-- Create User
CREATE USER report_admin WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'postgres10';

-- Database GRANT 
GRANT ALL ON DATABASE report_ms TO postgres;
GRANT ALL ON DATABASE report_ms TO report_admin WITH GRANT OPTION;

----------------------------------------------------------------------------------------
---------------------------------VERSIONING CONFIGURATION-------------------------------
----------------------------------------------------------------------------------------
CREATE SEQUENCE public.hibernate_sequence;

ALTER SEQUENCE public.hibernate_sequence OWNER TO report_admin;

CREATE TABLE public.revinfo
(
    rev integer NOT NULL,
    revtstmp bigint,
    CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
)
WITH ( OIDS = FALSE ) TABLESPACE pg_default;

ALTER TABLE public.revinfo OWNER to report_admin;
