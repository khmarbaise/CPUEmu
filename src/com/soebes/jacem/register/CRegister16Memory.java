/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.register;

import com.soebes.jacem.memory.CMemoryByte;

/**
 * This Class represents a Register which is indirectly
 * addresse through the given 16 bit register.
 */
public class CRegister16Memory extends CRegister16 {
	
	private CMemoryByte mem;

	public CRegister16Memory (CRegister16 reg16, CMemoryByte mem) {
		super (reg16.getRegL (), reg16.getRegH());
		this.mem = mem;
	}

	public CRegister16Memory (CRegister8 regL, CRegister8 regH, CMemoryByte mem) {
		super (regL, regH);
		this.mem = mem;
	}

	/**
	 * This will store an 8 bit value into the
	 * memory address which is given through
	 * the register value.
	 * @param	integer	Give the value of the memory address.
	 */
	public void setValueIndirect (int val) {
		this.mem.setMem (this.getValue (), val);
	}

	public int getValueIndirect () {
		return this.mem.getMem (this.getValue());
	}

	public void incValueIndirect () {
		this.mem.incMem (this.getValue());
	}
	public void decValueIndirect () {
		this.mem.decMem (this.getValue());
	}
	
	public void pushByteIndirect (int val) {
		this.setValueIndirect(val);
		this.decValue ();
	}

	public void pushWordIndirect (int val) {
		this.pushByteIndirect (val & 0x00ff);
		this.pushByteIndirect ((val&0xff00) >> 8);
	}

	public int popByteIndirect () {
		this.incValue();
		return this.getValueIndirect();
	}

	public int popWordIndirect () {
		return this.popByteIndirect() * 256 + this.popByteIndirect();
	}

}
