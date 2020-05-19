package com.fordlabs.docker.mssql.controllers;

import com.fordlabs.docker.mssql.models.SampleDatabaseModel;
import com.fordlabs.docker.mssql.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "sample", produces = "application/json")
public class SampleRestController {

    SampleService service;

    @Autowired
    public SampleRestController(SampleService service) {
        this.service = service;
    }

    @GetMapping(consumes = "application/json")
    public Object sampleGet(@RequestParam long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = "application/json")
    public Object samplePost(@RequestBody SampleDatabaseModel model) {
        return service.create(model);
    }
}
