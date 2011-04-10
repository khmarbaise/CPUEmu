package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseDCX;

public class ParseDCXTest extends TestCase {

    private ParseDCX pDCX;

    protected void setUp () throws Exception {
        this.pDCX = new ParseDCX ();
    }

    protected void tearDown () throws Exception {
        this.pDCX = null;
    }

    public ParseDCXTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.pDCX);
    }

    public void testIsValid1() {
        assertEquals (false, pDCX.isValid("\tDCX B"));
    }
    public void testIsValid2() {
        assertEquals (true, pDCX.isValid("DCX    H"));
    }
    public void testIsValid3() {
        assertEquals (true, pDCX.isValid("DCX\tD"));
    }
    public void testIsValid4() {
        assertEquals (true, pDCX.isValid("DCX b"));
    }

    public void testParse1 () {
        IOPCImpl ti = pDCX.parse("DCX B");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pDCX.parse("DCXA");
        assertNull(ti);
    }

    public void testParseOPCDCXB () {
        IOPCImpl ti = pDCX.parse("DCX B");
        assertEquals (CCPU8085.OPC_DCXB, ti.getOpc());
    }
    public void testParseOPCDCXD () {
        IOPCImpl ti = pDCX.parse("DCX D");
        assertEquals (CCPU8085.OPC_DCXD, ti.getOpc());
    }
    public void testParseOPCDCXH () {
        IOPCImpl ti = pDCX.parse("DCX H");
        assertEquals (CCPU8085.OPC_DCXH, ti.getOpc());
    }
    public void testParseOPCDCXSP () {
        IOPCImpl ti = pDCX.parse("DCX SP");
        assertEquals (CCPU8085.OPC_DCXSP, ti.getOpc());
    }
}
