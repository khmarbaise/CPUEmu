package com.soebes.jacem.memory;

import com.soebes.jacem.CFormat;

/**
* Java CPU Emulator (c) 2005 by SoEBeS
*
* Diese Klasse soll alle Arten von Speicher darstellen
* Hierbei ist zu beachten, dass bestimmte Bereiche
* zu adressieren sind und dort unterschiedliche Speichertypen
* liegen..
*
* Mal weitere Klassen JMemorySRAM, JMemoryFlash, JMemoryEEPROM
* Adressierungsbereiche muss ich mir noch �berlegen, wie ich das 
* mache?
* Alle JMemory von CMemory abgeleitet bzw. Interface definieren.
* �berlegen, ob man CMemoryByte, CMemoryWord, CMemoryDWord,
* oder CMemory14Bit machen kann sinn und zweck?
*/
public class CMemory {

	private	int startOfMemory;
	private	int endOfMemory;

	private int[] mem;

	public CMemory (int start, int end) {
		this.startOfMemory = start;
		this.endOfMemory = end;
		this.mem = new int[(int)(this.endOfMemory - this.startOfMemory + 1L)];
	}

	public CMemory () {
		this.startOfMemory = 0;
		this.endOfMemory = 127;
		this.mem = new int[(int)(this.endOfMemory - this.startOfMemory + 1L)];
	}

	public void setMem (int address, int val) {
		this.mem[address] = val;
	}

	public int getMem (int address) {
		return this.mem[address];
	}

	public void incMem (int address) {
		this.mem[address]++;
	}
	public void decMem (int address) {
		this.mem[address]--;
	}

	public int getStart () {
		return this.startOfMemory;
	}

	public int getEnd () {
		return this.endOfMemory;
	}

	public String dump (int start, int end) {
		String tmp = "";
		for (int i=start; i<=end; i++) {
			if ((i%16) == 0) {
				tmp += "\n" + CFormat.toHex16 (i);
			}
			tmp += " " + CFormat.toHex8(this.mem[i]);
		}	
		return tmp;
	}

	public String dump () {
		return this.dump (startOfMemory, endOfMemory);
	}

}
