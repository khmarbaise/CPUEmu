package com.soebes.jacem.parser;

import java.util.ArrayList;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.Label;
import com.soebes.jacem.parser.Parser;

import junit.framework.TestCase;

public class ParserTest extends TestCase {

    private Parser parser;

    public ParserTest(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.parser = new Parser ();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        this.parser = null;
    }

    public void testParserOneLine () {
        String line = "MVI A, 20";
        this.parser.parse(line);
        ArrayList opcs = this.parser.getOPCS ();
        assertTrue(opcs.size() > 0);
    }

    public void testParserTwoLine () {
        String[] lines = { "MVI A,30", "MVI B,22"};
        for (int i=0; i<lines.length; i++) {
            this.parser.parse(lines[i]);
        }
        ArrayList opcs = this.parser.getOPCS ();
        assertTrue(opcs.size() == 2);
    }

    public void testParserTwoLineLabel1 () {
        String[] lines = { "MVI A,30", "stoplabel: MVI B,22"};
        for (int i=0; i<lines.length; i++) {
            this.parser.parse(lines[i]);
        }
        ArrayList labels = this.parser.getLabels();
        assertTrue(labels.size() == 1);
    }

    public void testParserTwoLineLabel2 () {
        String[] lines = { "startlabel: MVI A,30", "midlabel:\tMVI B,22", "stoplabel: MVI B,22"};
        for (int i=0; i<lines.length; i++) {
            this.parser.parse(lines[i]);
        }
        ArrayList labels = this.parser.getLabels();
        assertTrue(labels.size() == 3);
    }

    public void testParserTwoLineLabel3 () {
        String[] lines = { "startlabel: MVI A,30", "stoplabel: MVI B,22"};
        for (int i=0; i<lines.length; i++) {
            this.parser.parse(lines[i]);
        }
        ArrayList labels = this.parser.getLabels();
        Label l1 = (Label)labels.get(0);
        Label l2 = (Label)labels.get(1);
        assertTrue((l1.getValue() + 2) == l2.getValue());
    }

    public void testParserOneLineOPC1 () {
        String line = "MVI A,30";
        this.parser.parse(line);
        ArrayList opcs = this.parser.getOPCS();
        IOPCImpl l1 = (IOPCImpl)opcs.get(0);
        assertTrue (l1.getOpc() == CCPU8085.OPC_MVIA);
    }

    public void testParserOneLineOPC2 () {
        String line = "MVI A,30";
        this.parser.parse(line);
        ArrayList opcs = this.parser.getOPCS();
        IOPCImpl l1 = (IOPCImpl)opcs.get(0);
        int opcbyte = ((Integer)l1.getBytes().iterator().next()).intValue();
        assertEquals (30, opcbyte);
    }

    public void testParserTwoLineOPC () {
        String[] lines = { "startlabel: MVI A,30", "stoplabel: MVI A,22"};
        for (int i=0; i<lines.length; i++) {
            this.parser.parse(lines[i]);
        }
        ArrayList opcs = this.parser.getOPCS();
        IOPCImpl l1 = (IOPCImpl)opcs.get(0);
        IOPCImpl l2 = (IOPCImpl)opcs.get(1);
        assertEquals (l1.getOpc(), l2.getOpc());
    }
}
