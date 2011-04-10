/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package test.com.soebes.jacem.register;

import com.soebes.jacem.register.CRegister8;

import junit.framework.TestCase;

public class CRegister8Test extends TestCase {

	private CRegister8 reg;

	public static void main(String[] args) {
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.reg = new CRegister8 ();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Constructor for CRegisterTest.
	 * @param arg0
	 */
	public CRegister8Test(String arg0) {
		super(arg0);
	}

	public void testSetGetValue() {
		for (int i=CRegister8.REGISTER_MIN_VALUE; i<CRegister8.REGISTER_MAX_VALUE; i++) {
			this.reg.setValue(i);
			assertEquals (this.reg.getValue(), i);
		}
	}

	public void testSetValueExceptionUpperLimit () {
		try {
			int testvalue = CRegister8.REGISTER_MAX_VALUE + 1;
			this.reg.setValue (testvalue);
			fail ("We don't get an exception based on the given value of " + testvalue + "!");
		} catch (Exception e) {
			// Everything well. We got an exception as expected.
		}
	}

	public void testSetValueExceptionLowerLimit () {
		try {
			int testvalue = CRegister8.REGISTER_MIN_VALUE - 1;
			this.reg.setValue (testvalue);
			fail ("We don't get an exception based on the given value of " + testvalue + "!");
		} catch (Exception e) {
			// Everything well. We got an exception as expected.
		}
	}


	public void testIncValue() {
		for (int i=CRegister8.REGISTER_MIN_VALUE; i<CRegister8.REGISTER_MAX_VALUE; i++) {
			this.reg.setValue(i);
			this.reg.incValue();
			assertEquals (i + 1, this.reg.getValue());
		}
	}

	public void testDecValue() {
		for (int i=CRegister8.REGISTER_MAX_VALUE; i>CRegister8.REGISTER_MIN_VALUE; i--) {
			this.reg.setValue(i);
			this.reg.decValue();
			assertEquals (i-1, this.reg.getValue());
		}
	}

}
