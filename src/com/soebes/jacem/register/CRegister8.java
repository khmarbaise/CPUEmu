/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.register;
/**
* 
*
* We use the int as internal type, cause byte 
* does not allow us unsigned values from 0..255.
* So we decided to use int.
*/
public class CRegister8 {
	public static final int REGISTER_MAX_VALUE = 255;
	public static final int REGISTER_MIN_VALUE = 0;

	protected boolean zero;
	protected boolean wraparound;
	
	private int val;

	private boolean isZero () {
		return this.zero;
	}

	private boolean hasWrap () {
		return this.wraparound;
	}

	private boolean isZero (int val) {
		if (val == REGISTER_MIN_VALUE) {
			return true;
		} else {
			return false;
		}
	}

	private void setZero () {
		this.zero = true;
	}

	private void unsetZero () {
		this.zero = false;
	}

	/**
	 * @todo	Produce an exception if val is not in valid range
	 * @param	int	def
	 */
	private CRegister8 (int def) {
		this.val = def;
		this.wraparound = false;
		if (this.isZero(def)) {
			this.setZero ();
		}
	}

	public CRegister8 () {
		this.val = 0;
		this.wraparound = false;
		this.setZero ();
	}

	/**
	 * @todo	Produce an exception if val is not in valid range
	 * @param val
	 */
	public void setValue (int val)
	throws ERegister8OutOfRangeException {
		if (val > REGISTER_MAX_VALUE || val < REGISTER_MIN_VALUE) {
			throw new ERegister8OutOfRangeException ();
		} else {
			this.val = val;
		}
	}

	public int getValue () {
		return this.val;
	}

	public void incValue () {
		if (this.val == REGISTER_MAX_VALUE) {
			this.wraparound = true;
			this.val = REGISTER_MIN_VALUE;
			this.setZero();
		} else {
			this.val ++;
			this.wraparound = false;
			this.unsetZero();
		}
	}
	public void decValue () {
		if (this.val == REGISTER_MIN_VALUE) {
			this.wraparound = true;
			this.val = REGISTER_MAX_VALUE;
		} else {
			this.val --;
			this.wraparound = false;
			this.isZero(this.val);
		}
	}

}
