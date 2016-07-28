#!/bin/bash
#set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE docker;
CREATE DATABASE postgres;
    CREATE USER docker PASSWORD 'docker';
    GRANT ALL PRIVILEGES ON DATABASE docker TO docker;

    \connect docker;

    CREATE TABLE connector(id BIGINT PRIMARY KEY NOT NULL, status CHARACTER VARYING(255));

    INSERT INTO connector(id, status) VALUES (1, 'unregister');
    INSERT INTO connector(id, status) VALUES (2, 'registered');
    INSERT INTO connector(id, status) VALUES (3, 'unknown');

EOSQL

echo