package com.handeware.algorithms.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlgorithmsService {

    public String sayHello(String something);

    public Boolean containsDuplicate(int[] numbers);

}
