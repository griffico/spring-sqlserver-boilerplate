#!/usr/bin/env bash

set -e

run_cmd="/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -l 30 -d master -i createdb.sql"

until (sleep 10 && $run_cmd) & /opt/mssql/bin/sqlservr; do
    echo "This should not be executing!"
done;
