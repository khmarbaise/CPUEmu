package com.soebes.jacem.expressionparser;

import org.testng.annotations.Test;

public class ParseExpressionTest {

	@Test
	public void deactivatedTest() {
		//Nothing to do.
	}
}
/*

  5+6 => 5 6 + (Stack using to evaluate expression)
  5*(3+4) 3 4 + 5 *

  Interface for operators (+,-,*,/,div,mod, low, high etc.)
  Interface for values (integer, label => value)

*/