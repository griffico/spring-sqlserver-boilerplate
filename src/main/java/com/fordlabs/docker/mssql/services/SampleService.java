package com.fordlabs.docker.mssql.services;

import com.fordlabs.docker.mssql.models.SampleDatabaseModel;
import com.fordlabs.docker.mssql.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleService {
    SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public SampleDatabaseModel findById(long id) {
        Optional<SampleDatabaseModel> sampleData = sampleRepository.findById(id);
        return sampleData.get();
    }

    public SampleDatabaseModel create(SampleDatabaseModel modelToSave) {
        return sampleRepository.save(modelToSave);
    }
}
