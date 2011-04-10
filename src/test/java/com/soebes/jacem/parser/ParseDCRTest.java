package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseDCR;

public class ParseDCRTest extends TestCase {

    private ParseDCR pdcr;

    protected void setUp () throws Exception {
        this.pdcr = new ParseDCR ();
    }

    protected void tearDown () throws Exception {
        this.pdcr = null;
    }

    public ParseDCRTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.pdcr);
    }

    public void testIsValid1() {
        assertEquals (false, pdcr.isValid("\tDCR   A"));
    }
    public void testIsValid2() {
        assertEquals (true, pdcr.isValid("DCR   A"));
    }
    public void testIsValid3() {
        assertEquals (true, pdcr.isValid("DCR\tA"));
    }
    public void testIsValid4() {
        assertEquals (true, pdcr.isValid("DCR \tA"));
    }

    public void testParse1 () {
        IOPCImpl ti = pdcr.parse("DCR A");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pdcr.parse("DCS B");
        assertNull(ti);
    }

    public void testParseOPCDCRA () {
        IOPCImpl ti = pdcr.parse("DCR A");
        assertEquals (CCPU8085.OPC_DCRA, ti.getOpc());
    }
    public void testParseOPCDCRB () {
        IOPCImpl ti = pdcr.parse("DCR B");
        assertEquals (CCPU8085.OPC_DCRB, ti.getOpc());
    }
    public void testParseOPCDCRC () {
        IOPCImpl ti = pdcr.parse("DCR C");
        assertEquals (CCPU8085.OPC_DCRC, ti.getOpc());
    }
    public void testParseOPCDCRD () {
        IOPCImpl ti = pdcr.parse("DCR D");
        assertEquals (CCPU8085.OPC_DCRD, ti.getOpc());
    }
    public void testParseOPCDCRE () {
        IOPCImpl ti = pdcr.parse("DCR E");
        assertEquals (CCPU8085.OPC_DCRE, ti.getOpc());
    }
    public void testParseOPCDCRH () {
        IOPCImpl ti = pdcr.parse("DCR H");
        assertEquals (CCPU8085.OPC_DCRH, ti.getOpc());
    }
    public void testParseOPCDCRL () {
        IOPCImpl ti = pdcr.parse("DCR L");
        assertEquals (CCPU8085.OPC_DCRL, ti.getOpc());
    }
    public void testParseOPCDCRM () {
        IOPCImpl ti = pdcr.parse("DCR M");
        assertEquals (CCPU8085.OPC_DCRM, ti.getOpc());
    }
}
