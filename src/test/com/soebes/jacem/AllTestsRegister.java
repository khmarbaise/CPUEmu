package test.com.soebes.jacem;

import test.com.soebes.jacem.register.CRegister16MemoryTest;
import test.com.soebes.jacem.register.CRegister16Test;
import test.com.soebes.jacem.register.CRegister8Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class AllTestsRegister extends TestCase {

	public AllTestsRegister (String name) {
		super (name);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite ();
		suite.addTest(new TestSuite (CRegister8Test.class));
		suite.addTest(new TestSuite (CRegister16Test.class));
		suite.addTest(new TestSuite (CRegister16MemoryTest.class));
		return suite;
	}
}
