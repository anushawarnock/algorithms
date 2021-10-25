package com.handeware.algorithms.controller;

import com.handeware.algorithms.service.AlgorithmsService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Algorithms")
@RequestMapping(value = "/algorithms")
public class AlgorithmsController {

    private static final Logger logger = LoggerFactory.getLogger(AlgorithmsService.class);

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @Autowired
    private AlgorithmsService service;

    @PostMapping(path = "/say_hello/{something}")
    public ResponseEntity<String> sayHello(@PathVariable("something") String something) {
        return new ResponseEntity<>(service.sayHello(something), HttpStatus.OK);
    }

    @PostMapping(path = "/check_duplicates", consumes = {MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> containsDuplicate(@RequestBody int[] numbers) {
        return new ResponseEntity<>(service.containsDuplicate(numbers), HttpStatus.OK);
    }

}
