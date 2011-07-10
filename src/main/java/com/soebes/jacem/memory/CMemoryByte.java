/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.memory;

import com.soebes.jacem.CFormat;
import com.soebes.jacem2.OperationCodes;

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
* Alle JMemory von CMemoryByte abgeleitet bzw. Interface definieren.
* �berlegen, ob man CMemoryByte, CMemoryWord, CMemoryDWord,
* oder CMemory14Bit machen kann sinn und zweck?
*/
public class CMemoryByte {

	public final static int MEMORY_CONTENT_MIN = 0;
	public final static int MEMORY_CONTENT_MAX = 255;

	private	int startOfMemory;
	private	int endOfMemory;

	private int[] mem;

	public CMemoryByte (int start, int end) {
		this.startOfMemory = start;
		this.endOfMemory = end;
		this.mem = new int[(int)(this.endOfMemory - this.startOfMemory + 1)];
	}

	public CMemoryByte () {
		this.startOfMemory = 0;
		this.endOfMemory = 127;
		this.mem = new int[(int)(this.endOfMemory - this.startOfMemory + 1L)];
	}

	public void setMem (int address, int val) {
		if (val > MEMORY_CONTENT_MAX || val < MEMORY_CONTENT_MIN) {
			throw new EMemoryOutOfRangeException ();
		} else {
			this.mem[address] = val;
		}
	}

	public void setMem (int address, OperationCodes opc) {
		this.mem[address] = opc.ordinal();
	}

	public void setMem16 (int address, int val) {
		this.setMem(address, val & 0x00ff);
		this.setMem(address, (val & 0xff00) >> 8);
	}
	public int getMem (int address) {
		return this.mem[address];
	}

	public int getMem16 (int adress) {
		return this.getMem(adress) + 256 * this.getMem(adress+1);
	}
	public void incMem (int address) {
		if (this.mem[address] == MEMORY_CONTENT_MAX) {
			this.mem[address] = MEMORY_CONTENT_MIN;
			// this.wrap = true;
		} else {
			this.mem[address]++;
			// this.wrap = false;
		}
	}

	public void decMem (int address) {
		if (this.mem[address] == MEMORY_CONTENT_MIN) {
			this.mem[address] = MEMORY_CONTENT_MAX;
			// this.wrap = true
		} else {
			this.mem[address]--;
			// this.wrap = false;
		}
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
