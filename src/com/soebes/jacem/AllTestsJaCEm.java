package com.soebes.jacem;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTestsJaCEm extends TestCase {

	public AllTestsJaCEm (String name) {
		super (name);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite ();
		suite.addTest(new TestSuite (CFormatTest.class));
		return suite;
	}

}
