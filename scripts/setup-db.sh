#!/usr/bin/env bash

set -e

if [ ! -e /db.initialized ]; then

    echo "Database not initialized, attempting to created it"

    #run the setup script to create the DB and the schema in the DB
    /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d master -l 30 -i createdb.sql

    touch /db.initialized
fi


