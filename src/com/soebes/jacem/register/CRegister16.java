/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.register;
/**
* This will give you the oportunity to have
* a register which comprises of two 8 bit registers
* which can be used as a single register.
*/
public class CRegister16 extends CRegister8 {

	public static final int REGISTER_MIN_VALUE = 0;
	public static final int REGISTER_MAX_VALUE = 65535;

	private CRegister8 regL;
	private CRegister8 regH;

	public void setValue (int val) 
	throws ERegister16OutOfRangeExecption {
		if (val > REGISTER_MAX_VALUE || val < REGISTER_MIN_VALUE) {
			throw new ERegister16OutOfRangeExecption ();
		} else {
			this.regL.setValue (val & 0x00ff);
			this.regH.setValue ((val & 0xff00) >> 8);
		}
	}

	public int getValue () {
		return this.regL.getValue() + 256 * this.regH.getValue();
	}

	public CRegister16 (CRegister8 regL, CRegister8 regH) {
		this.regL = regL;
		this.regH = regH;
	}
	
	public CRegister8 getRegL () {
		return this.regL;
	}
	public CRegister8 getRegH () {
		return this.regH;
	}

	public void incValue () {
		if (this.getValue() == REGISTER_MAX_VALUE) {
			this.wraparound = true;
			this.setValue (REGISTER_MIN_VALUE);
		} else {
			this.setValue (this.getValue() + 1);
			this.wraparound = false;
		}
	}

	public void decValue () {
		if (this.getValue () == REGISTER_MIN_VALUE) {
			this.wraparound = true;
			this.setValue(REGISTER_MAX_VALUE);
		} else {
			this.wraparound = false;
			this.setValue (this.getValue() - 1);
		}
	}

}
