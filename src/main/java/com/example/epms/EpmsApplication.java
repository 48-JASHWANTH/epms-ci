package com.example.epms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EpmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EpmsApplication.class, args);
    }
}

/*-- create DB & user if not created yet
CREATE DATABASE epmsdb;
CREATE USER epmsuser WITH ENCRYPTED PASSWORD 'epmspass';

-- make the user owner of the database
ALTER DATABASE epmsdb OWNER TO epmsuser;

-- grant schema privileges (important)
\c epmsdb            -- connect to the epmsdb database
ALTER SCHEMA public OWNER TO epmsuser;
GRANT ALL PRIVILEGES ON SCHEMA public TO epmsuser;
GRANT USAGE, CREATE ON SCHEMA public TO epmsuser;

-- (optional) grant default privileges on future objects
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO epmsuser;
*/