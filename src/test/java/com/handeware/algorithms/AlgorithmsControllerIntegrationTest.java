package com.handeware.algorithms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.handeware.algorithms.controller.AlgorithmsController;
import com.handeware.algorithms.service.AlgorithmsService;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AlgorithmsController.class)
public class AlgorithmsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlgorithmsService service;

    @Before
    public void setUp() throws Exception {
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    @Test
    public void givenSomething_sayHello() throws Exception {
        given(service.sayHello("John")).willReturn("Hello John");
        mockMvc.perform(post("/algorithms/say_hello/John").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        verify(service, VerificationModeFactory.times(1)).sayHello(Mockito.anyString());

    }

    @Test
    public void givenSomething_checkDuplicatesInAList() throws Exception {
        given(service.containsDuplicate(Mockito.any())).willReturn(Boolean.TRUE);
        mockMvc.perform(post("/algorithms/check_duplicates").contentType(MediaType.APPLICATION_JSON).content("[1,2,3]")).andExpect(status().isOk());
        verify(service, VerificationModeFactory.times(1)).containsDuplicate(Mockito.any());

    }
}
