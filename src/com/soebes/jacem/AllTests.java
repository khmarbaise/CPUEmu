package com.soebes.jacem;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	/**
	 * @return a suite containing all tests in this package
	 * and subpackages.
	 */
	public static TestSuite suite( ) {
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
		TestSuite suite = new TestSuite( );
		suite.addTest(AllTestsJaCEm.suite());
		suite.addTest(test.com.soebes.jacem.AllTestsMemory.suite());
		suite.addTest(test.com.soebes.jacem.AllTestsRegister.suite());
		suite.addTest(test.com.soebes.jacem.AllTestsParser.suite());
		return suite;
	}

}
