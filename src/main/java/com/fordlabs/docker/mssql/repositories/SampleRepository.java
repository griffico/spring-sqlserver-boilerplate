package com.fordlabs.docker.mssql.repositories;

import com.fordlabs.docker.mssql.models.SampleDatabaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends CrudRepository<SampleDatabaseModel, Long> {
}
