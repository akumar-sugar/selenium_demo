package test.java;

import static org.junit.Assert.*;
import main.java.Calculator;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		assertEquals("adding 3 and 2;", 5, c.add(3, 2));
	}

}
