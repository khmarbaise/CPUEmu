package test.com.soebes.jacem.register;

import com.soebes.jacem.register.CStatusRegister;

import junit.framework.TestCase;

public class CStatusRegisterTest extends TestCase {

	private CStatusRegister reg;

	protected void setUp() throws Exception {
		super.setUp();
		reg = new CStatusRegister ();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsCarry() {
		reg.setCarry();
		assertEquals (true, reg.isCarry());
	}

	public void testGetSetCarryFlag() {
		reg.setCarry();
		assertEquals (true, reg.getCarryFlag());
	}

	public void testIsZero() {
		fail ("Not implemented!");
	}

	public void testGetZeroFlag() {
		fail ("Not implemented!");
	}

	public void testSetZero() {
		fail ("Not implemented!");
	}

	public void testIsSign() {
		fail ("Not implemented!");
	}

	public void testGetSignFlag() {
		fail ("Not implemented!");
	}

	public void testGetValue() {
		fail ("Not implemented!");
	}

	public void testSetValue() {
		fail ("Not implemented!");
	}

}
