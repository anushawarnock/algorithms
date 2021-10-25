package com.handeware.algorithms.service;


import java.util.HashSet;
import java.util.Set;

public class AlgorithmServiceImpl implements AlgorithmsService{


    @Override
    public String sayHello(String something) {
        return "Hello " +something;
    }

    @Override
    public Boolean containsDuplicate(int[] numbers) {
        boolean result = false;
        Set<Integer> numsSet = new HashSet<>(numbers.length);
        for (int i : numbers) {
            if (numsSet.contains(i)) {
                result = true;
                return result;
            }
            numsSet.add(i);
        }
        return result;
    }
}
