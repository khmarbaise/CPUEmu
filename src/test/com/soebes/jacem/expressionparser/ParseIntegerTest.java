package test.com.soebes.jacem.expressionparser;

import junit.framework.TestCase;

import com.soebes.jacem.expressionparser.ParseInteger;
import com.soebes.jacem.parser.IOPCImpl;

public class ParseIntegerTest extends TestCase {
	private ParseInteger pint;

	protected void setUp () throws Exception {
		this.pint = new ParseInteger ();
	}

	protected void tearDown () throws Exception {
		this.pint = null;
	}

	public ParseIntegerTest(String arg0) {
		super(arg0);
	}

	public void testNotNull() {
		assertNotNull (this.pint);
	}

	public void testIsValid1() {
		assertEquals (true, pint.isValid("34+56"));
	}
	public void testIsValid2() {
		assertEquals (true, pint.isValid("66*7"));
	}
	public void testIsValid3() {
		assertEquals (true, pint.isValid("66/7743"));
	}
	public void testIsValid4() {
		assertEquals (true, pint.isValid("123+123"));
	}

	public void testParse1 () {
		IOPCImpl ti = pint.parse("34+56");
		assertNotNull(ti);
	}
	
	public void testParse2 () {
		IOPCImpl ti = pint.parse("34+56");
		assertNull(ti);
	}
	
}
