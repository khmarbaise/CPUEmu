package test.com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParsePCHL;

public class ParsePCHLTest extends TestCase {

	private ParsePCHL pPCHL;

	protected void setUp () throws Exception {
		this.pPCHL = new ParsePCHL ();
	}

	protected void tearDown () throws Exception {
		this.pPCHL = null;
	}

	public ParsePCHLTest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.pPCHL);
	}

	public void testIsValid1() {
		assertEquals (true, pPCHL.isValid("PCHL"));
	}
	public void testIsValid2() {
		assertEquals (true, pPCHL.isValid("startlabel:PCHL"));
	}

	public void testParse1 () {
		IOPCImpl ti = pPCHL.parse("PCHL");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = pPCHL.parse("CHG");
		assertNull(ti);
	}
	
	public void testParseOPCPCHL () {
		IOPCImpl ti = pPCHL.parse("PCHL");
		assertEquals (CCPU8085.OPC_PCHL, ti.getOpc()); 
	}
}
