package com.handeware.algorithms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.handeware.algorithms.service.AlgorithmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<Boolean> containsDuplicate(@RequestBody List<Integer> numbersList) throws JsonProcessingException {

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson= ow.writeValueAsString(numbersList);

        // Todo need to fix this mapping for postman
        List<Integer> readList = new ObjectMapper().readValue(requestJson, new TypeReference<List<Integer>>() {});

        int[] intNumbers = readList.stream().mapToInt(i -> i).toArray();

        return new ResponseEntity<>(service.containsDuplicate(intNumbers), HttpStatus.OK);
    }

}
