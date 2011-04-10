package test.com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseSPHL;

public class ParseSPHLTest extends TestCase {

	private ParseSPHL pSPHL;

	protected void setUp () throws Exception {
		this.pSPHL = new ParseSPHL ();
	}

	protected void tearDown () throws Exception {
		this.pSPHL = null;
	}

	public ParseSPHLTest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.pSPHL);
	}

	public void testIsValid1() {
		assertEquals (true, pSPHL.isValid("SPHL"));
	}
	public void testIsValid2() {
		assertEquals (true, pSPHL.isValid("startlabel:SPHL"));
	}

	public void testParse1 () {
		IOPCImpl ti = pSPHL.parse("SPHL");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = pSPHL.parse("CHG");
		assertNull(ti);
	}
	
	public void testParseOPCSPHL () {
		IOPCImpl ti = pSPHL.parse("SPHL");
		assertEquals (CCPU8085.OPC_SPHL, ti.getOpc()); 
	}
}
