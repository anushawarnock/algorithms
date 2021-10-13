package com.handeware.algorithms.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmServiceImpl implements AlgorithmsService{


    @Override
    public String sayHello(String something) {
        return "Hello " +something;
    }

    @Override
    public Boolean containsDuplicate(int[] numbers) {
        boolean result = false;
        try {
            Set<Integer> numsSet = new HashSet<>(numbers.length);
            for (int i : numbers) {
                if (numsSet.contains(i)){
                    result = true;
                }
                numsSet.add(i);
            }
        } catch (Exception e) {
            System.out.println("Failed with an exception : "+e);
        }
        return result;
    }
}
