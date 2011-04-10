package test.com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseINX;

public class ParseINXTest extends TestCase {

	private ParseINX pinx;

	protected void setUp () throws Exception {
		this.pinx = new ParseINX ();
	}

	protected void tearDown () throws Exception {
		this.pinx = null;
	}

	public ParseINXTest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.pinx);
	}

	public void testIsValid1() {
		assertEquals (false, pinx.isValid("\tINX B"));
	}
	public void testIsValid2() {
		assertEquals (true, pinx.isValid("INX    H"));
	}
	public void testIsValid3() {
		assertEquals (true, pinx.isValid("INX\tD"));
	}
	public void testIsValid4() {
		assertEquals (true, pinx.isValid("inx b"));
	}

	public void testParse1 () {
		IOPCImpl ti = pinx.parse("INX B");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = pinx.parse("INXA");
		assertNull(ti);
	}
	
	public void testParseOPCINXB () {
		IOPCImpl ti = pinx.parse("INX B");
		assertEquals (CCPU8085.OPC_INXB, ti.getOpc()); 
	}
	public void testParseOPCINXD () {
		IOPCImpl ti = pinx.parse("INX D");
		assertEquals (CCPU8085.OPC_INXD, ti.getOpc()); 
	}
	public void testParseOPCINXH () {
		IOPCImpl ti = pinx.parse("INX H");
		assertEquals (CCPU8085.OPC_INXH, ti.getOpc()); 
	}
	public void testParseOPCINXSP () {
		IOPCImpl ti = pinx.parse("INX SP");
		assertEquals (CCPU8085.OPC_INXSP, ti.getOpc()); 
	}
}
