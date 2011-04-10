package com.soebes.jacem.register;

import com.soebes.jacem.memory.CMemory;

/**
* Java CPU Emulator (c) 2005 by SoEBeS
*/
public class CRegisterMemory extends CRegister8 {
	private int val;

	private CRegister8 regL;
	private CRegister8 regH;
	private CMemory mem;

	public CRegisterMemory (CRegister8 regL, CRegister8 regH, CMemory mem) {
		this.regL = regL;
		this.regH = regH;
		this.mem = mem;
	}

	private int getAdr () {
		return regL.getValue () + 256 * regH.getValue ();
	}
	public void setValue (int val) {
		this.mem.setMem (this.getAdr (), val);
	}

	public int getValue () {
		return this.mem.getMem (this.getAdr ());
	}

	public void incValue () {
		this.mem.incMem (this.getAdr ());
	}
	public void decValue () {
		this.mem.decMem (this.getAdr ());
	}
}
