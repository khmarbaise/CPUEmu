package test.com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseLXI;

public class ParseLXITest extends TestCase {

	private ParseLXI plxi;

	protected void setUp () throws Exception {
		this.plxi = new ParseLXI ();
	}

	protected void tearDown () throws Exception {
		this.plxi = null;
	}

	public ParseLXITest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.plxi);
	}

	public void testIsValid1() {
		assertEquals (false, plxi.isValid("\tLXI   A,30"));
	}
	public void testIsValid2() {
		assertEquals (true, plxi.isValid("LXI   B,30"));
	}
	public void testIsValid3() {
		assertEquals (true, plxi.isValid("LXI\tD,30"));
	}
	public void testIsValid4() {
		assertEquals (true, plxi.isValid("LXI \tH,30"));
	}
	public void testIsValid5() {
		assertEquals (true, plxi.isValid("LXI \tSP ,30"));
	}
	public void testIsValid6() {
		assertEquals (true, plxi.isValid("LXI \tB\t,30"));
	}
	public void testIsValid7() {
		assertEquals (true, plxi.isValid("LXI \tD\t, 30"));
	}
	public void testIsValid8() {
		assertEquals (true, plxi.isValid("LXI \tH\t,\t30"));
	}
	public void testIsValid9() {
		assertEquals (true, plxi.isValid("startlabel:LXI SP,30"));
	}

	public void testParse1 () {
		IOPCImpl ti = plxi.parse("LXI B,30");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = plxi.parse("MOV A,B");
		assertNull(ti);
	}
	
	public void testParseOPCLXIB () {
		IOPCImpl ti = plxi.parse("LXI B,10");
		assertEquals (CCPU8085.OPC_LXIB, ti.getOpc()); 
	}
	public void testParseOPCLXID () {
		IOPCImpl ti = plxi.parse("LXI D,10");
		assertEquals (CCPU8085.OPC_LXID, ti.getOpc()); 
	}
	public void testParseOPCLXIH () {
		IOPCImpl ti = plxi.parse("LXI H,10");
		assertEquals (CCPU8085.OPC_LXIH, ti.getOpc()); 
	}
	public void testParseOPCLXISP () {
		IOPCImpl ti = plxi.parse("LXI SP,10");
		assertEquals (CCPU8085.OPC_LXISP, ti.getOpc()); 
	}

	public void testParseOperand () {
		String line = "LXI SP,32767";
		IOPCImpl ti = plxi.parse(line);
		int opcbyte = ((Integer)ti.getBytes().iterator().next()).intValue();
		assertEquals (32767, opcbyte);
	}

}
