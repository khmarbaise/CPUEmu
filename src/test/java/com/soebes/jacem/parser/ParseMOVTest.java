package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseMOV;

public class ParseMOVTest extends TestCase {

    private ParseMOV pmov;

    protected void setUp() throws Exception {
        super.setUp();
        pmov = new ParseMOV ();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        pmov = null;
    }

    public void testMOVAA () {
        pmov.parse("MOV A,A");
    }


    public void testNotNull() {
        assertNotNull (this.pmov);
    }

    public void testIsValid1() {
        assertEquals (false, pmov.isValid("\tMOV   A,A"));
    }
    public void testIsValid2() {
        assertEquals (true, pmov.isValid("MOV   A,A"));
    }
    public void testIsValid3() {
        assertEquals (true, pmov.isValid("MOV\tA,A"));
    }
    public void testIsValid4() {
        assertEquals (true, pmov.isValid("MOV \tA,A"));
    }
    public void testIsValid5() {
        assertEquals (true, pmov.isValid("MOV \tA ,A"));
    }
    public void testIsValid6() {
        assertEquals (true, pmov.isValid("MOV \tA\t,A"));
    }
    public void testIsValid7() {
        assertEquals (true, pmov.isValid("MOV \tA\t, A"));
    }
    public void testIsValid8() {
        assertEquals (true, pmov.isValid("MOV \tA\t,\tA"));
    }
    public void testIsValid9() {
        assertEquals (true, pmov.isValid("startlabel:MOV A,A"));
    }

    public void testParse1 () {
        IOPCImpl ti = pmov.parse("MOV A,A");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = pmov.parse("MOV A,BT");
        assertNull(ti);
    }

    public void testParseOPCMOVAA () {
        IOPCImpl ti = pmov.parse("MOV A,A");
        assertEquals (CCPU8085.OPC_MOVAA, ti.getOpc());
    }
    public void testParseOPCMOVAB () {
        IOPCImpl ti = pmov.parse("MOV A,B");
        assertEquals (CCPU8085.OPC_MOVAB, ti.getOpc());
    }
    public void testParseOPCMOVAC () {
        IOPCImpl ti = pmov.parse("MOV A,C");
        assertEquals (CCPU8085.OPC_MOVAC, ti.getOpc());
    }
    public void testParseOPCMOVAD () {
        IOPCImpl ti = pmov.parse("MOV A,D");
        assertEquals (CCPU8085.OPC_MOVAD, ti.getOpc());
    }
    public void testParseOPCMOVAE () {
        IOPCImpl ti = pmov.parse("MOV A,E");
        assertEquals (CCPU8085.OPC_MOVAE, ti.getOpc());
    }
    public void testParseOPCMOVAH () {
        IOPCImpl ti = pmov.parse("MOV A,H");
        assertEquals (CCPU8085.OPC_MOVAH, ti.getOpc());
    }
    public void testParseOPCMOVAL () {
        IOPCImpl ti = pmov.parse("MOV A,L");
        assertEquals (CCPU8085.OPC_MOVAL, ti.getOpc());
    }
    public void testParseOPCMOVAM () {
        IOPCImpl ti = pmov.parse("MOV A,M");
        assertEquals (CCPU8085.OPC_MOVAM, ti.getOpc());
    }


    public void testParseOPCMOVBA () {
        IOPCImpl ti = pmov.parse("MOV B,A");
        assertEquals (CCPU8085.OPC_MOVBA, ti.getOpc());
    }
    public void testParseOPCMOVBB () {
        IOPCImpl ti = pmov.parse("MOV B,B");
        assertEquals (CCPU8085.OPC_MOVBB, ti.getOpc());
    }
    public void testParseOPCMOVBC () {
        IOPCImpl ti = pmov.parse("MOV B,C");
        assertEquals (CCPU8085.OPC_MOVBC, ti.getOpc());
    }
    public void testParseOPCMOVBD () {
        IOPCImpl ti = pmov.parse("MOV B,D");
        assertEquals (CCPU8085.OPC_MOVBD, ti.getOpc());
    }
    public void testParseOPCMOVBE () {
        IOPCImpl ti = pmov.parse("MOV B,E");
        assertEquals (CCPU8085.OPC_MOVBE, ti.getOpc());
    }
    public void testParseOPCMOVBH () {
        IOPCImpl ti = pmov.parse("MOV B,H");
        assertEquals (CCPU8085.OPC_MOVBH, ti.getOpc());
    }
    public void testParseOPCMOVBL () {
        IOPCImpl ti = pmov.parse("MOV B,L");
        assertEquals (CCPU8085.OPC_MOVBL, ti.getOpc());
    }
    public void testParseOPCMOVBM () {
        IOPCImpl ti = pmov.parse("MOV B,M");
        assertEquals (CCPU8085.OPC_MOVBM, ti.getOpc());
    }


    public void testParseOPCMOVCA () {
        IOPCImpl ti = pmov.parse("MOV C,A");
        assertEquals (CCPU8085.OPC_MOVCA, ti.getOpc());
    }
    public void testParseOPCMOVCB () {
        IOPCImpl ti = pmov.parse("MOV C,B");
        assertEquals (CCPU8085.OPC_MOVCB, ti.getOpc());
    }
    public void testParseOPCMOVCC () {
        IOPCImpl ti = pmov.parse("MOV C,C");
        assertEquals (CCPU8085.OPC_MOVCC, ti.getOpc());
    }
    public void testParseOPCMOVCD () {
        IOPCImpl ti = pmov.parse("MOV C,D");
        assertEquals (CCPU8085.OPC_MOVCD, ti.getOpc());
    }
    public void testParseOPCMOVCE () {
        IOPCImpl ti = pmov.parse("MOV C,E");
        assertEquals (CCPU8085.OPC_MOVCE, ti.getOpc());
    }
    public void testParseOPCMOVCH () {
        IOPCImpl ti = pmov.parse("MOV C,H");
        assertEquals (CCPU8085.OPC_MOVCH, ti.getOpc());
    }
    public void testParseOPCMOVCL () {
        IOPCImpl ti = pmov.parse("MOV C,L");
        assertEquals (CCPU8085.OPC_MOVCL, ti.getOpc());
    }
    public void testParseOPCMOVCM () {
        IOPCImpl ti = pmov.parse("MOV C,M");
        assertEquals (CCPU8085.OPC_MOVCM, ti.getOpc());
    }


    public void testParseOPCMOVDA () {
        IOPCImpl ti = pmov.parse("MOV D,A");
        assertEquals (CCPU8085.OPC_MOVDA, ti.getOpc());
    }
    public void testParseOPCMOVDB () {
        IOPCImpl ti = pmov.parse("MOV D,B");
        assertEquals (CCPU8085.OPC_MOVDB, ti.getOpc());
    }
    public void testParseOPCMOVDC () {
        IOPCImpl ti = pmov.parse("MOV D,C");
        assertEquals (CCPU8085.OPC_MOVDC, ti.getOpc());
    }
    public void testParseOPCMOVDD () {
        IOPCImpl ti = pmov.parse("MOV D,D");
        assertEquals (CCPU8085.OPC_MOVDD, ti.getOpc());
    }
    public void testParseOPCMOVDE () {
        IOPCImpl ti = pmov.parse("MOV D,E");
        assertEquals (CCPU8085.OPC_MOVDE, ti.getOpc());
    }
    public void testParseOPCMOVDH () {
        IOPCImpl ti = pmov.parse("MOV D,H");
        assertEquals (CCPU8085.OPC_MOVDH, ti.getOpc());
    }
    public void testParseOPCMOVDL () {
        IOPCImpl ti = pmov.parse("MOV D,L");
        assertEquals (CCPU8085.OPC_MOVDL, ti.getOpc());
    }
    public void testParseOPCMOVDM () {
        IOPCImpl ti = pmov.parse("MOV D,M");
        assertEquals (CCPU8085.OPC_MOVDM, ti.getOpc());
    }


    public void testParseOPCMOVEA () {
        IOPCImpl ti = pmov.parse("MOV E,A");
        assertEquals (CCPU8085.OPC_MOVEA, ti.getOpc());
    }
    public void testParseOPCMOVEB () {
        IOPCImpl ti = pmov.parse("MOV E,B");
        assertEquals (CCPU8085.OPC_MOVEB, ti.getOpc());
    }
    public void testParseOPCMOVEC () {
        IOPCImpl ti = pmov.parse("MOV E,C");
        assertEquals (CCPU8085.OPC_MOVEC, ti.getOpc());
    }
    public void testParseOPCMOVED () {
        IOPCImpl ti = pmov.parse("MOV E,D");
        assertEquals (CCPU8085.OPC_MOVED, ti.getOpc());
    }
    public void testParseOPCMOVEE () {
        IOPCImpl ti = pmov.parse("MOV E,E");
        assertEquals (CCPU8085.OPC_MOVEE, ti.getOpc());
    }
    public void testParseOPCMOVEH () {
        IOPCImpl ti = pmov.parse("MOV E,H");
        assertEquals (CCPU8085.OPC_MOVEH, ti.getOpc());
    }
    public void testParseOPCMOVEL () {
        IOPCImpl ti = pmov.parse("MOV E,L");
        assertEquals (CCPU8085.OPC_MOVEL, ti.getOpc());
    }
    public void testParseOPCMOVEM () {
        IOPCImpl ti = pmov.parse("MOV E,M");
        assertEquals (CCPU8085.OPC_MOVEM, ti.getOpc());
    }


    public void testParseOPCMOVHA () {
        IOPCImpl ti = pmov.parse("MOV H,A");
        assertEquals (CCPU8085.OPC_MOVHA, ti.getOpc());
    }
    public void testParseOPCMOVHB () {
        IOPCImpl ti = pmov.parse("MOV H,B");
        assertEquals (CCPU8085.OPC_MOVHB, ti.getOpc());
    }
    public void testParseOPCMOVHC () {
        IOPCImpl ti = pmov.parse("MOV H,C");
        assertEquals (CCPU8085.OPC_MOVHC, ti.getOpc());
    }
    public void testParseOPCMOVHD () {
        IOPCImpl ti = pmov.parse("MOV H,D");
        assertEquals (CCPU8085.OPC_MOVHD, ti.getOpc());
    }
    public void testParseOPCMOVHE () {
        IOPCImpl ti = pmov.parse("MOV H,E");
        assertEquals (CCPU8085.OPC_MOVHE, ti.getOpc());
    }
    public void testParseOPCMOVHH () {
        IOPCImpl ti = pmov.parse("MOV H,H");
        assertEquals (CCPU8085.OPC_MOVHH, ti.getOpc());
    }
    public void testParseOPCMOVHL () {
        IOPCImpl ti = pmov.parse("MOV H,L");
        assertEquals (CCPU8085.OPC_MOVHL, ti.getOpc());
    }
    public void testParseOPCMOVHM () {
        IOPCImpl ti = pmov.parse("MOV H,M");
        assertEquals (CCPU8085.OPC_MOVHM, ti.getOpc());
    }


    public void testParseOPCMOVMA () {
        IOPCImpl ti = pmov.parse("MOV M,A");
        assertEquals (CCPU8085.OPC_MOVMA, ti.getOpc());
    }
    public void testParseOPCMOVMB () {
        IOPCImpl ti = pmov.parse("MOV M,B");
        assertEquals (CCPU8085.OPC_MOVMB, ti.getOpc());
    }
    public void testParseOPCMOVMC () {
        IOPCImpl ti = pmov.parse("MOV M,C");
        assertEquals (CCPU8085.OPC_MOVMC, ti.getOpc());
    }
    public void testParseOPCMOVMD () {
        IOPCImpl ti = pmov.parse("MOV M,D");
        assertEquals (CCPU8085.OPC_MOVMD, ti.getOpc());
    }
    public void testParseOPCMOVME () {
        IOPCImpl ti = pmov.parse("MOV M,E");
        assertEquals (CCPU8085.OPC_MOVME, ti.getOpc());
    }
    public void testParseOPCMOVMH () {
        IOPCImpl ti = pmov.parse("MOV M,H");
        assertEquals (CCPU8085.OPC_MOVMH, ti.getOpc());
    }
    public void testParseOPCMOVML () {
        IOPCImpl ti = pmov.parse("MOV M,L");
        assertEquals (CCPU8085.OPC_MOVML, ti.getOpc());
    }
}
