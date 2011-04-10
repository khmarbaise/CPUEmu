package test.com.soebes.jacem;

import test.com.soebes.jacem.parser.IParseImplTest;
import test.com.soebes.jacem.parser.LabelTest;
import test.com.soebes.jacem.parser.ParseDCRTest;
import test.com.soebes.jacem.parser.ParseDCXTest;
import test.com.soebes.jacem.parser.ParseINRTest;
import test.com.soebes.jacem.parser.ParseINXTest;
import test.com.soebes.jacem.parser.ParseLXITest;
import test.com.soebes.jacem.parser.ParseMOVTest;
import test.com.soebes.jacem.parser.ParseMVITest;
import test.com.soebes.jacem.parser.ParsePCHLTest;
import test.com.soebes.jacem.parser.ParsePUSHTest;
import test.com.soebes.jacem.parser.ParseSPHLTest;
import test.com.soebes.jacem.parser.ParseXCHGTest;
import test.com.soebes.jacem.parser.ParseXTHLTest;
import test.com.soebes.jacem.parser.ParserTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class AllTestsParser extends TestCase {

	public AllTestsParser (String name) {
		super (name);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite ();
		suite.addTest(new TestSuite (IParseImplTest.class));
		
		suite.addTest(new TestSuite (ParseDCRTest.class));
		suite.addTest(new TestSuite (ParseDCXTest.class));
		suite.addTest(new TestSuite (ParseINRTest.class));
		suite.addTest(new TestSuite (ParseINXTest.class));
		suite.addTest(new TestSuite (ParseMOVTest.class));
		suite.addTest(new TestSuite (ParseMVITest.class));
		suite.addTest(new TestSuite (ParseLXITest.class));
		suite.addTest(new TestSuite (ParsePUSHTest.class));

		suite.addTest(new TestSuite (ParseXCHGTest.class));
		suite.addTest(new TestSuite (ParsePCHLTest.class));
		suite.addTest(new TestSuite (ParseXTHLTest.class));
		suite.addTest(new TestSuite (ParseSPHLTest.class));

		suite.addTest(new TestSuite (LabelTest.class));
		suite.addTest(new TestSuite (ParserTest.class));
		return suite;
	}
}
