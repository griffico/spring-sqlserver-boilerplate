package com.fordlabs.docker.mssql.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sample", produces = "application/json")
public class SampleRestController {

    @GetMapping(consumes = "application/json")
    public Object sampleGet(){
        return 2;
    }
}
