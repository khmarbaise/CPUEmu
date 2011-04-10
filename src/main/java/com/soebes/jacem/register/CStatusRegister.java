/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.register;
import java.util.*;
/**
* Java CPU Emulator (c) 2005 by SoEBeS
* Infos:
* http://www.cpu-world.com/Arch/8085.html
* http://www.bbs-winsen.de/projekte/wilusim/
*/
public class CStatusRegister {

	public static final int CARRY = 0;
	public static final int PARITY = 2;
	public static final int AUXILIARYCARRY = 4;
	public static final int ZERO = 6;
	public static final int SIGN = 7;

	private BitSet Flags;

	public CStatusRegister () {
		this.Flags = new BitSet (8);
		this.Flags.set (ZERO);
		this.Flags.set (CARRY);
		this.Flags.set (SIGN);
	}

	protected int getBitAsValue (int bit) {
		if (this.Flags.get(bit)) {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean isCarry () {
		return this.Flags.get(CARRY);		
	}

	public boolean getCarryFlag () {
		return this.Flags.get(CARRY);
	}

	public void setCarry () {
		this.Flags.set(CARRY);
	}

	public boolean isZero () {
		return this.Flags.get (ZERO);
	}

	public boolean getZeroFlag () {
		return this.Flags.get(ZERO);
	}

	public void setZero () {
		this.Flags.set (ZERO);
	}

	public boolean isSign () {
		return this.Flags.get(SIGN);
	}
	
	public boolean getSignFlag () {
		return this.Flags.get(SIGN);
	}

	public int getValue () {
		return this.asInt();
	}

	
	/**
	 * @param val
	 * @todo	Exception if value out of range!
	 * @todo	Complete it, cause it's not ready yet!
	 */
	public void setValue (int val) {
		//
		if ((val & CARRY) > 0) {
			this.Flags.set(CARRY);
		} else {
			this.Flags.clear(CARRY);
		}

		if ((val & ZERO) > 0) {
			this.Flags.set(ZERO);
		} else {
			this.Flags.clear(ZERO);
		}

		if ((val & SIGN) > 0) {
			this.Flags.set(SIGN);
		} else {
			this.Flags.clear(SIGN);
		}

		if ((val & PARITY) > 0) {
			this.Flags.set(PARITY);
		} else {
			this.Flags.clear(PARITY);
		}
	}

	public int asInt () {
		int tmp = 0;
		for (int i=0; i<8; i++) {
			tmp *= 2;
			tmp += this.getBitAsValue (i);
		}
		return tmp;
	}
}
