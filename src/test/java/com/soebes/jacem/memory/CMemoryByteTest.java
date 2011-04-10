/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS
 */
package com.soebes.jacem.memory;

import com.soebes.jacem.memory.CMemoryByte;

import junit.framework.TestCase;


public class CMemoryByteTest extends TestCase {

    public static final int MEMORY_START = 0;
    public static final int MEMORY_END = 799;

    private CMemoryByte m;

    public static void main(String[] args) {
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.m = new CMemoryByte (MEMORY_START, MEMORY_END);
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Constructor for CMemoryByteTest.
     * @param arg0
     */
    public CMemoryByteTest(String arg0) {
        super(arg0);
    }

    public void testSetGetMem() {
        for (int i=MEMORY_START; i<MEMORY_END; i++) {
            this.m.setMem(i, i & 0x00ff);
            assertEquals(i & 0x00ff, this.m.getMem(i));
        }
    }

    public void testSetMemExceptionUpperLimit () {
        try {
            // This must result in an Exception!!
            this.m.setMem(MEMORY_END + 1, 21);
            // If we got no Exception let the test FAIL
            fail ("The setMem() does not produce an Exception as expected at the upper limit!");
        } catch (Exception e) {
            //we got the test. This means we got an exception
        }
    }

    public void testSetMemExceptionLowerLimit () {
        try {
            // This must result in an Exception!!
            this.m.setMem(MEMORY_START - 1, 21);
            // If we got no Exception let the test FAIL
            fail ("The setMem() does not produce an Exception as expected at the lower limit!");
        } catch (Exception e) {
            //we got the test. This means we got an exception
        }
    }

//	public void testIncMem() {
//		fail();
//	}

//	public void testDecMem() {
//		fail();
//	}

    public void testGetStart() {
        assertEquals (MEMORY_START, this.m.getStart());
    }

    public void testGetEnd() {
        assertEquals (MEMORY_END, this.m.getEnd());
    }

}
