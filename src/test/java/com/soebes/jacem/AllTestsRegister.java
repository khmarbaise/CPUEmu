package com.soebes.jacem;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.soebes.jacem.register.CRegister16MemoryTest;
import com.soebes.jacem.register.CRegister16Test;
import com.soebes.jacem.register.CRegister8Test;



public class AllTestsRegister extends TestCase {

    public AllTestsRegister (String name) {
        super (name);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite ();
        suite.addTest(new TestSuite (CRegister8Test.class));
        suite.addTest(new TestSuite (CRegister16Test.class));
        suite.addTest(new TestSuite (CRegister16MemoryTest.class));
        return suite;
    }
}
