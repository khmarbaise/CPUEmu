package com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParsePUSH;

public class ParsePUSHTest extends TestCase {

    private ParsePUSH ppush;

    protected void setUp () throws Exception {
        this.ppush = new ParsePUSH ();
    }

    protected void tearDown () throws Exception {
        this.ppush = null;
    }

    public ParsePUSHTest(String arg0) {
        super(arg0);
    }

    public void testNotNull() {
        assertNotNull (this.ppush);
    }

    public void testIsValid1() {
        assertEquals (true, ppush.isValid("push B"));
    }
    public void testIsValid2() {
        assertEquals (true, ppush.isValid("push d"));
    }
    public void testIsValid3() {
        assertEquals (true, ppush.isValid("push h"));
    }
    public void testIsValid4() {
        assertEquals (true, ppush.isValid("push psw"));
    }
    public void testIsValid51() {
        assertEquals (true, ppush.isValid("push\tb"));
    }
    public void testIsValid52() {
        assertEquals (true, ppush.isValid("push  b"));
    }
    public void testIsValid53() {
        assertEquals (true, ppush.isValid("push \tb"));
    }

    public void testIsValid6() {
        assertEquals (true, ppush.isValid("startlabel:push psw"));
    }

    public void testParse1 () {
        IOPCImpl ti = ppush.parse("PUSH PSW");
        assertNotNull(ti);
    }

    public void testParse2 () {
        IOPCImpl ti = ppush.parse("PUSH A");
        assertNull(ti);
    }

    public void testParseOPCPUSHB () {
        IOPCImpl ti = ppush.parse("PUSH B");
        assertEquals (CCPU8085.OPC_PUSHB, ti.getOpc());
    }
    public void testParseOPCPUSHD () {
        IOPCImpl ti = ppush.parse("PUSH D");
        assertEquals (CCPU8085.OPC_PUSHD, ti.getOpc());
    }
    public void testParseOPCPUSHH () {
        IOPCImpl ti = ppush.parse("PUSH H");
        assertEquals (CCPU8085.OPC_PUSHH, ti.getOpc());
    }
    public void testParseOPCPUSHPSW () {
        IOPCImpl ti = ppush.parse("PUSH PSW");
        assertEquals (CCPU8085.OPC_PUSHPSW, ti.getOpc());
    }

}
