/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package test.com.soebes.jacem.register;
import com.soebes.jacem.register.CRegister16;
import com.soebes.jacem.register.CRegister8;

import junit.framework.TestCase;

public class CRegister16Test extends TestCase {
	
	private CRegister16 reg16;
	private CRegister8 regL;
	private CRegister8 regH;

	public static void main(String[] args) {
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.regL = new CRegister8 ();
		this.regH = new CRegister8 ();
		this.reg16 = new CRegister16 (this.regL, this.regH);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Constructor for CRegister16Test.
	 * @param arg0
	 */
	public CRegister16Test(String arg0) {
		super(arg0);
	}

	public void testIncValue16() {
		for (int i=CRegister16.REGISTER_MIN_VALUE; i<CRegister16.REGISTER_MAX_VALUE; i++) {
			this.reg16.setValue(i);
			assertEquals(i, this.reg16.getValue());
		}
	}

	public void testIncValueUperLimitException () {
		try {
			this.reg16.setValue(CRegister16.REGISTER_MAX_VALUE + 1);
			fail("We don't get an expected Exception for Upper Limit!");
		} catch (Exception e) {
			// intentially left blank
			// Everything wen't well.
		}
	}

	public void testDecValueLowerLimitException () {
		try {
			this.reg16.setValue(CRegister16.REGISTER_MIN_VALUE - 1);
			fail ("We don't get an expected Exception for lower limit!");
		} catch(Exception e) {
			// intentially left blank
			// Everything wen't well.
		}
	}

	public void testDecValue() {
		this.reg16.setValue (CRegister16.REGISTER_MAX_VALUE);
		this.reg16.decValue();
		assertEquals (CRegister16.REGISTER_MAX_VALUE - 1, this.reg16.getValue());
	}

	public void testDecValueWrap () {
		this.reg16.setValue (CRegister16.REGISTER_MIN_VALUE);
		this.reg16.decValue();
		assertEquals (CRegister16.REGISTER_MAX_VALUE, this.reg16.getValue());
	}

	public void testSetGetValue16() {
		for (int i = CRegister16.REGISTER_MIN_VALUE; i<CRegister16.REGISTER_MAX_VALUE; i++) {
			this.reg16.setValue(i);
			assertEquals (i, this.reg16.getValue ());
		}
	}
}
