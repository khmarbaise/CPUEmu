/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.memory.CMemoryByte;


/**
 * Das ist ein Klassenkommentar bis zum ersten Punkt.
 * 
 * Hier geht die Beschreibung der Daten weiter.
 * Und noch ein Satz.
 * @author	Java CPU Emulator (c) 2005 by SoEBeS
 */
public class JaCEm {

/*
 CMemoryByte muss hier initialisiert werden
 mit den Adressbereichen und den Speichertype, die
 Verwendung finden sollen.....
mal �berlegen wie ich das mache...

*/
	protected void Initialize () {
	}

	public static void main (String[] args) {
		double fc = 6.144E06; // Clock 6.144 MHz
		double tc = 1.0 / fc; // Cycle time 
		System.out.println ("JaCEm Java CPU Emulator (c) 2005 by SoEBeS " + new Release());
		System.out.println("Emulation of Intel 8085");
		CMemoryByte cm = new CMemoryByte (0, 1023); // Create 1 KByte memory for using
		cm.setMem (0, CCPU8085.OPC_LDA);
		cm.setMem (1, 0x60);
		cm.setMem (2, 00);
		cm.setMem (0x60, 0x42);
		cm.setMem (3, CCPU8085.OPC_INRA);
		cm.setMem (4, CCPU8085.OPC_INRB);
		cm.setMem (5, CCPU8085.OPC_DCRC);
		cm.setMem (6, CCPU8085.OPC_MOVAA);
		cm.setMem (7, CCPU8085.OPC_MOVCC);
		cm.setMem (8, CCPU8085.OPC_MOVDD);
		cm.setMem (9, CCPU8085.OPC_MOVEE);
		cm.setMem (10, CCPU8085.OPC_MOVHH);
		cm.setMem (11, CCPU8085.OPC_MOVLL);
		cm.setMem (12, CCPU8085.OPC_MOVMA);
		cm.setMem (13, CCPU8085.OPC_MOVAM);
		cm.setMem (14, CCPU8085.OPC_MVIA);
		cm.setMem (15, 0x55);
		cm.setMem (16, CCPU8085.OPC_MVIB);
		cm.setMem (17, 0x66);
		cm.setMem (18, CCPU8085.OPC_MVIM);
		cm.setMem (19, 0xF5);
		cm.setMem (20, CCPU8085.OPC_INXB);
		cm.setMem (21, CCPU8085.OPC_INXD);
		cm.setMem (22, CCPU8085.OPC_INXH);
		cm.setMem (23, CCPU8085.OPC_DCXB);
		cm.setMem (24, CCPU8085.OPC_DCXD);
		cm.setMem (25, CCPU8085.OPC_DCXH);
		cm.setMem (26, CCPU8085.OPC_LXIB);
		cm.setMem (27, 0x6f);
		cm.setMem (28, 0x02);
		cm.setMem (29, CCPU8085.OPC_LDAXB);
		cm.setMem (30, CCPU8085.OPC_LXISP);
		cm.setMem (31, 0xff);
		cm.setMem (32, 0x03);
		cm.setMem (33, CCPU8085.OPC_CALL);
		cm.setMem (34, 0x00);
		cm.setMem (35, 0x02);
		cm.setMem (36, CCPU8085.OPC_INRA);
		cm.setMem (37, CCPU8085.OPC_HLT);

		cm.setMem (0x200, CCPU8085.OPC_MVIM);
		cm.setMem (0x201, 0x45);
		cm.setMem (0x202, CCPU8085.OPC_LHLD);
		cm.setMem (0x203, 0x00);
		cm.setMem (0x204, 0x03);
		cm.setMem (0x205, CCPU8085.OPC_SHLD);
		cm.setMem (0x206, 0x02);
		cm.setMem (0x207, 0x03);
		cm.setMem (0x208, CCPU8085.OPC_LXIH);
		cm.setMem (0x209, 36);
		cm.setMem (0x20a, 0x00);
		cm.setMem (0x20b, CCPU8085.OPC_XTHL);

		cm.setMem (0x20c, CCPU8085.OPC_RET);

		cm.setMem (0x026f, 0x21);
		
		cm.setMem (0x0300, 0x6f);
		cm.setMem (0x0301, 0x02);

		System.out.println ("memory dump");
		System.out.println (cm.dump());

		CCPU8085 cpu = new CCPU8085 (cm);
		cpu.reset ();
		int cycles = 0;
		int instuction = 0;
		int currCycles = 1;
		int pc = 0;
		boolean bEnd = false;
		long start = System.currentTimeMillis ();
		while (!bEnd) {
			pc = cpu.getPC ();
			bEnd = cpu.cycle ();
			currCycles = cpu.getCycles ();
			cycles += currCycles;
			System.out.print (
					CFormat.toString4Digit (currCycles) + " " 
				+	CFormat.toHex16 (pc) + " " 
				+	cpu.showRegister ()
			);
			System.out.println (" " + cpu.getMnemonic());
			instuction++;
/*			if (bEnd) {
				continue;
			} */
		}
		long end = System.currentTimeMillis ();
		long emulationtime = end - start;
		double runtime = (double)cycles * tc;
		System.out.println ("Cycles " + cycles);
		System.out.println ("Run Time " + CFormat.FormatEng(runtime));
		System.out.println ("Emulation Time " + emulationtime);
		System.out.println ("Instructions " + instuction);

		long xis = ( instuction * 1000 ) / emulationtime;
		double mips = ( instuction * 1000000.0 ) / (runtime * 1000000);
		System.out.println ("Instructions/s " + xis);
		System.out.println ("MIPS " + mips);
	}
}
