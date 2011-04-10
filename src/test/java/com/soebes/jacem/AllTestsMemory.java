package com.soebes.jacem;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.soebes.jacem.memory.CMemoryByteTest;
import com.soebes.jacem.memory.CMemoryTest;



public class AllTestsMemory extends TestCase {

    public AllTestsMemory (String name) {
        super (name);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite ();
        suite.addTest(new TestSuite (CMemoryTest.class));
        suite.addTest(new TestSuite (CMemoryByteTest.class));
        return suite;
    }
}
