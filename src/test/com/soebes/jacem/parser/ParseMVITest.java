package test.com.soebes.jacem.parser;

import junit.framework.TestCase;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.ParseMVI;

public class ParseMVITest extends TestCase {

	private ParseMVI pmvi;

	protected void setUp () throws Exception {
		this.pmvi = new ParseMVI ();
	}

	protected void tearDown () throws Exception {
		this.pmvi = null;
	}

	public ParseMVITest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.pmvi);
	}

	public void testIsValid1() {
		assertEquals (false, pmvi.isValid("\tMVI   A,30"));
	}
	public void testIsValid2() {
		assertEquals (true, pmvi.isValid("MVI   A,30"));
	}
	public void testIsValid3() {
		assertEquals (true, pmvi.isValid("MVI\tA,30"));
	}
	public void testIsValid4() {
		assertEquals (true, pmvi.isValid("MVI \tA,30"));
	}
	public void testIsValid5() {
		assertEquals (true, pmvi.isValid("MVI \tA ,30"));
	}
	public void testIsValid6() {
		assertEquals (true, pmvi.isValid("MVI \tA\t,30"));
	}
	public void testIsValid7() {
		assertEquals (true, pmvi.isValid("MVI \tA\t, 30"));
	}
	public void testIsValid8() {
		assertEquals (true, pmvi.isValid("MVI \tA\t,\t30"));
	}
	public void testIsValid9() {
		assertEquals (true, pmvi.isValid("startlabel:MVI A,30"));
	}

	public void testParse1 () {
		IOPCImpl ti = pmvi.parse("MVI A,30");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = pmvi.parse("MOV A,B");
		assertNull(ti);
	}
	
	public void testParseOPCMVIA () {
		IOPCImpl ti = pmvi.parse("MVI A,10");
		assertEquals (CCPU8085.OPC_MVIA, ti.getOpc()); 
	}
	public void testParseOPCMVIB () {
		IOPCImpl ti = pmvi.parse("MVI B,10");
		assertEquals (CCPU8085.OPC_MVIB, ti.getOpc()); 
	}
	public void testParseOPCMVIC () {
		IOPCImpl ti = pmvi.parse("MVI C,10");
		assertEquals (CCPU8085.OPC_MVIC, ti.getOpc()); 
	}
	public void testParseOPCMVID () {
		IOPCImpl ti = pmvi.parse("MVI D,10");
		assertEquals (CCPU8085.OPC_MVID, ti.getOpc()); 
	}
	public void testParseOPCMVIE () {
		IOPCImpl ti = pmvi.parse("MVI E,10");
		assertEquals (CCPU8085.OPC_MVIE, ti.getOpc()); 
	}
	public void testParseOPCMVIH () {
		IOPCImpl ti = pmvi.parse("MVI H,10");
		assertEquals (CCPU8085.OPC_MVIH, ti.getOpc()); 
	}
	public void testParseOPCMVIL () {
		IOPCImpl ti = pmvi.parse("MVI L,10");
		assertEquals (CCPU8085.OPC_MVIL, ti.getOpc()); 
	}
	public void testParseOPCMVIM () {
		IOPCImpl ti = pmvi.parse("MVI M,10");
		assertEquals (CCPU8085.OPC_MVIM, ti.getOpc()); 
	}
}
