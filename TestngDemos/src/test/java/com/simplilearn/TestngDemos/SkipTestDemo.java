package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestDemo {

	@Test(enabled  = false)
	public void test1() {
		System.out.println("TestCase1 - This will not be executed");
	}
	
	@Test
	public void test2() {
		System.out.println("TestCase2 - Skip Exception Example");
		throw new SkipException("Skipping this test2");
	}
	
	@Test
	public void test3() {
		System.out.println("TestCase3 - Conditional Skip");
		boolean isDataAvailable = false;
		if(!isDataAvailable) {
			throw new SkipException("Skipping the test3 on a condition");
		}
	}
}
