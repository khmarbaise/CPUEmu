package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseXCHG;

public class ParseXCHGTest extends TestCase {

    private ParseXCHG pxchg;

    protected void setUp () throws Exception {
        this.pxchg = new ParseXCHG ();
    }

    protected void tearDown () throws Exception {
        this.pxchg = null;
    }

    public ParseXCHGTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.pxchg);
    }

    public void testIsValid1() {
        assertEquals (true, pxchg.isValid("XCHG"));
    }
    public void testIsValid2() {
        assertEquals (true, pxchg.isValid("startlabel:xchg"));
    }

    public void testParse1 () {
        IOPCImpl ti = pxchg.parse("XCHG");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pxchg.parse("CHG");
        assertNull(ti);
    }

    public void testParseOPCXCHG () {
        IOPCImpl ti = pxchg.parse("XCHG");
        assertEquals (CCPU8085.OPC_XCHG, ti.getOpc());
    }
}
