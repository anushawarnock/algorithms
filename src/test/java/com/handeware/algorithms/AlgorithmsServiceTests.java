package com.handeware.algorithms;

import com.handeware.algorithms.service.AlgorithmsService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AlgorithmsServiceTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AlgorithmsService service;

	@Test
	public void sayHelloTest(){
		assertTrue("Hello John".equals(service.sayHello("John")));
	}

	@Test
	public void sayHelloTestNull(){
		assertTrue("Hello ".equals(service.sayHello("")));
		assertTrue("Hello null".equals(service.sayHello(null)));
	}

	@Test
	public void containsDuplicateTest(){
		int[] uniqueNumbers = {1, 2, 3, 4, 5};
		int[] dupeNumbers = {1,1,1,1};
		int[] emptyList = {};
 		assertFalse(service.containsDuplicate(uniqueNumbers));
		assertTrue(service.containsDuplicate(dupeNumbers));
		assertFalse(service.containsDuplicate(emptyList));
	}
}
