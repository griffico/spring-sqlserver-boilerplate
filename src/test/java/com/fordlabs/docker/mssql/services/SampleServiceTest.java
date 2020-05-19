package com.fordlabs.docker.mssql.services;

import com.fordlabs.docker.mssql.models.SampleDatabaseModel;
import com.fordlabs.docker.mssql.repositories.SampleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SampleServiceTest {

    @Mock
    SampleRepository repository;

    @InjectMocks
    SampleService sampleService;

    @Test
    void getById() {
        long idToGet = 55L;

        SampleDatabaseModel expectedModel = SampleDatabaseModel.builder()
                .value("something")
                .build();

        Optional<SampleDatabaseModel> optionalModel = Optional.of(expectedModel);
        when(repository.findById(idToGet)).thenReturn(optionalModel);

        Object o = sampleService.findById(idToGet);
        assertThat(o).isEqualTo(expectedModel);
    }

    @Test
    void create() {

        SampleDatabaseModel modelToSave = SampleDatabaseModel.builder()
                .value("something")
                .build();
        SampleDatabaseModel expectedSavedModel = modelToSave.toBuilder()
                .id(33L)
                .build();

        when(repository.save(modelToSave)).thenReturn(expectedSavedModel);

        SampleDatabaseModel sampleDatabaseModel = sampleService.create(modelToSave);
        assertThat(sampleDatabaseModel).isEqualTo(expectedSavedModel);
    }
}