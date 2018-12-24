package com.JunitTesting.Eample1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.JunitTesting.Eample1.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(JUnitPlatform.class)
public class CalculatorTests {
	
	private Calculator calculator;
	
	@BeforeAll
	static void intiAll(){
		
	}
	@BeforeEach
	void init() throws Exception{
		calculator = new Calculator();
	}
	
	@Test
	@DisplayName("positive tests")
	void addsTwoNumbers() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
		
		assertAll(()-> {
			int expectedSum = 5;
			int actualSum = calculator.add(2, 3);
			assertEquals(expectedSum,actualSum);
		},
		()->{
			int expectedSum = 7;
			int actualSum = calculator.add(2, 5);
			assertEquals(expectedSum,actualSum);
		});
	}
	
	@AfterEach
	void tearDown(){
		calculator = null;
	}

	@Test
	void shouldThrowException() {
	    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    assertEquals(exception.getMessage(), "Not supported");
	}
	
	 
	@Test
	void assertThrowsException() {
	    String str = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	      Integer.valueOf(str);
	    });
	}

}
