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
        suite.addTest(AllTestsMemory.suite());
        suite.addTest(AllTestsRegister.suite());
        suite.addTest(AllTestsParser.suite());
        return suite;
    }

}
