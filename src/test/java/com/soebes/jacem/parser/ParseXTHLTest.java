package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseXTHL;

public class ParseXTHLTest extends TestCase {

    private ParseXTHL pXTHL;

    protected void setUp () throws Exception {
        this.pXTHL = new ParseXTHL ();
    }

    protected void tearDown () throws Exception {
        this.pXTHL = null;
    }

    public ParseXTHLTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.pXTHL);
    }

    public void testIsValid1() {
        assertEquals (true, pXTHL.isValid("XTHL"));
    }
    public void testIsValid2() {
        assertEquals (true, pXTHL.isValid("startlabel:XTHL"));
    }

    public void testParse1 () {
        IOPCImpl ti = pXTHL.parse("XTHL");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pXTHL.parse("CHG");
        assertNull(ti);
    }

    public void testParseOPCXTHL () {
        IOPCImpl ti = pXTHL.parse("XTHL");
        assertEquals (CCPU8085.OPC_XTHL, ti.getOpc());
    }
}
