package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.Calculator;
import main.scientificCalculator;

class testCalculatorJunit {
	Calculator myCalc = new Calculator();
	scientificCalculator myScifi = new scientificCalculator(); 
	double expected;
	double actual;
	@Test
	void testScifiCalculatorSin() {
		
		expected = 0.5984721441039564;
		actual = myScifi.sin(2.5);
		System.out.println(actual);		
		
		Assert.assertEquals(expected, actual);		
	}
	@Test
	void testScifiCalculatorAddWithTwoIntegers() {
		
		expected = 9;
		actual = myScifi.add(2,7);
		System.out.println(actual);		
		
		Assert.assertEquals(expected, actual);		
	}
	
	
	@Test
	void testCalculatorAddWithTwoParams() {
		
		expected = 15;
		actual = myCalc.add(10, 5);
		
		Assert.assertEquals(expected, actual);		
	}
	@Test
	void testCalculatorAddWithThreeParams() {
		
		expected = 100;
		actual = myCalc.add(50, 30,20);
		
		Assert.assertEquals(expected, actual);		
	}
}
