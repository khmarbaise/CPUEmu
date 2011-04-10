package test.com.soebes.jacem.parser;

import com.soebes.jacem.parser.IParseImpl;

import junit.framework.TestCase;

public class IParseImplTest extends TestCase {

	private IParseImpl ipi;

	public IParseImplTest (String name) {
		super (name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		ipi = new IParseImpl ();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		ipi = null;
	}

	public void testHasLabel1 () {
		String line = "test: mvi a,0 ; test";
		assertEquals (true, ipi.hasLabel(line));
	}

	public void testHasLabel2 () {
		String line = " test: mvi a,0 ; test";
		assertEquals (true, ipi.hasLabel(line));
	}
	
	public void testHasLabel21 () {
		String line = "\ttest: mvi a,0 ; test";
		assertEquals (true, ipi.hasLabel(line));
	}
	public void testHasLabel3 () {
		String line = "egonmaierlist2345t:mvi b,1 ;test";
		assertEquals (true, ipi.hasLabel(line));
	}

	public void testHasLabel4 () {
		String line = "egonmaierlist2345t:";
		assertEquals (true, ipi.hasLabel(line));
	}
	
	public void testParseLabel1 () {
		String mvi = "mvi a,0";
		String label = "startlabel";
		String line = label + ": " + mvi;
		assertEquals (mvi, ipi.parseLabel(line));
	}
	
	public void testParseLable () {
		String label = "test:";
		String opc = "mvi b,34 ;test";
		String line = label + opc;
		assertEquals (true, ipi.hasLabel (line));
	}
}
