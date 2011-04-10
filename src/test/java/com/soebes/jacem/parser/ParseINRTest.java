package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseINR;

public class ParseINRTest extends TestCase {

    private ParseINR pinr;

    protected void setUp () throws Exception {
        this.pinr = new ParseINR ();
    }

    protected void tearDown () throws Exception {
        this.pinr = null;
    }

    public ParseINRTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.pinr);
    }

    public void testIsValid1() {
        assertEquals (false, pinr.isValid("\tINR   A"));
    }
    public void testIsValid2() {
        assertEquals (true, pinr.isValid("INR   A"));
    }
    public void testIsValid3() {
        assertEquals (true, pinr.isValid("INR\tA"));
    }
    public void testIsValid4() {
        assertEquals (true, pinr.isValid("INR \tA"));
    }

    public void testParse1 () {
        IOPCImpl ti = pinr.parse("INR A");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pinr.parse("INC B");
        assertNull(ti);
    }

    public void testParseOPCINRA () {
        IOPCImpl ti = pinr.parse("INR A");
        assertEquals (CCPU8085.OPC_INRA, ti.getOpc());
    }
    public void testParseOPCINRB () {
        IOPCImpl ti = pinr.parse("INR B");
        assertEquals (CCPU8085.OPC_INRB, ti.getOpc());
    }
    public void testParseOPCINRC () {
        IOPCImpl ti = pinr.parse("INR C");
        assertEquals (CCPU8085.OPC_INRC, ti.getOpc());
    }
    public void testParseOPCINRD () {
        IOPCImpl ti = pinr.parse("INR D");
        assertEquals (CCPU8085.OPC_INRD, ti.getOpc());
    }
    public void testParseOPCINRE () {
        IOPCImpl ti = pinr.parse("INR E");
        assertEquals (CCPU8085.OPC_INRE, ti.getOpc());
    }
    public void testParseOPCINRH () {
        IOPCImpl ti = pinr.parse("INR H");
        assertEquals (CCPU8085.OPC_INRH, ti.getOpc());
    }
    public void testParseOPCINRL () {
        IOPCImpl ti = pinr.parse("INR L");
        assertEquals (CCPU8085.OPC_INRL, ti.getOpc());
    }
    public void testParseOPCINRM () {
        IOPCImpl ti = pinr.parse("INR M");
        assertEquals (CCPU8085.OPC_INRM, ti.getOpc());
    }
}
