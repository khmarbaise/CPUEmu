/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem.cpu;

import java.util.LinkedList;

import com.soebes.jacem.CFormat;
import com.soebes.jacem.memory.CMemoryByte;
import com.soebes.jacem.register.CRegister16;
import com.soebes.jacem.register.CRegister16Memory;
import com.soebes.jacem.register.CRegister8;
import com.soebes.jacem.register.CStatusRegister;

/**
 * This class is intended to simulate a Intel 8085 CPU
 * with its register etc.
 *
 * Infos:
 */
public class CCPU8085 {

	private CMemoryByte mem;
	private String mnemonic;

	public static final int RESET_ADDRESS = 0x0000;

	private int programCounter;

	public static final int REG_B = 0x00;
	public static final int REG_C = 0x01;
	public static final int REG_D = 0x02;
	public static final int REG_E = 0x03;
	public static final int REG_H = 0x04;
	public static final int REG_L = 0x05;
	public static final int REG_M = 0x06;
	public static final int REG_A = 0x07;

	public static final int REG_BC = 0x00;
	public static final int REG_DE = 0x01;
	public static final int REG_HL = 0x02;
	public static final int REG_SP = 0x03;

	public static final int REG_PSW = 0x03;

	public static final int OPC_JMP = 0xC3;

	public static final int OPC_MOVBB = 0x40;
	public static final int OPC_MOVBC = 0x41;
	public static final int OPC_MOVBD = 0x42;
	public static final int OPC_MOVBE = 0x43;
	public static final int OPC_MOVBH = 0x44;
	public static final int OPC_MOVBL = 0x45;
	public static final int OPC_MOVBM = 0x46;
	public static final int OPC_MOVBA = 0x47;

	public static final int OPC_MOVCB = 0x48;
	public static final int OPC_MOVCC = 0x49;
	public static final int OPC_MOVCD = 0x4A;
	public static final int OPC_MOVCE = 0x4B;
	public static final int OPC_MOVCH = 0x4C;
	public static final int OPC_MOVCL = 0x4D;
	public static final int OPC_MOVCM = 0x4E;
	public static final int OPC_MOVCA = 0x4F;

	public static final int OPC_MOVDB = 0x50;
	public static final int OPC_MOVDC = 0x51;
	public static final int OPC_MOVDD = 0x52;
	public static final int OPC_MOVDE = 0x53;
	public static final int OPC_MOVDH = 0x54;
	public static final int OPC_MOVDL = 0x55;
	public static final int OPC_MOVDM = 0x56;
	public static final int OPC_MOVDA = 0x57;

	public static final int OPC_MOVEB = 0x58;
	public static final int OPC_MOVEC = 0x59;
	public static final int OPC_MOVED = 0x5A;
	public static final int OPC_MOVEE = 0x5B;
	public static final int OPC_MOVEH = 0x5C;
	public static final int OPC_MOVEL = 0x5D;
	public static final int OPC_MOVEM = 0x5E;
	public static final int OPC_MOVEA = 0x5F;

	public static final int OPC_MOVHB = 0x60;
	public static final int OPC_MOVHC = 0x61;
	public static final int OPC_MOVHD = 0x62;
	public static final int OPC_MOVHE = 0x63;
	public static final int OPC_MOVHH = 0x64;
	public static final int OPC_MOVHL = 0x65;
	public static final int OPC_MOVHM = 0x66;
	public static final int OPC_MOVHA = 0x67;

	public static final int OPC_MOVLB = 0x68;
	public static final int OPC_MOVLC = 0x69;
	public static final int OPC_MOVLD = 0x6A;
	public static final int OPC_MOVLE = 0x6B;
	public static final int OPC_MOVLH = 0x6C;
	public static final int OPC_MOVLL = 0x6D;
	public static final int OPC_MOVLM = 0x6E;
	public static final int OPC_MOVLA = 0x6F;

	public static final int OPC_MOVMB = 0x70;
	public static final int OPC_MOVMC = 0x71;
	public static final int OPC_MOVMD = 0x72;
	public static final int OPC_MOVME = 0x73;
	public static final int OPC_MOVMH = 0x74;
	public static final int OPC_MOVML = 0x75;
	public static final int OPC_MOVMA = 0x77;

	public static final int OPC_MOVAB = 0x78;
	public static final int OPC_MOVAC = 0x79;
	public static final int OPC_MOVAD = 0x7A;
	public static final int OPC_MOVAE = 0x7B;
	public static final int OPC_MOVAH = 0x7C;
	public static final int OPC_MOVAL = 0x7D;
	public static final int OPC_MOVAM = 0x7E;
	public static final int OPC_MOVAA = 0x7F;

	public static final int OPC_MOV = 0x40;

	public static final int OPC_INRA = 0x3C;
	public static final int OPC_INRB = 0x04;
	public static final int OPC_INRC = 0x0C;
	public static final int OPC_INRD = 0x14;
	public static final int OPC_INRE = 0x1C;
	public static final int OPC_INRH = 0x24;
	public static final int OPC_INRL = 0x2C;
	public static final int OPC_INRM = 0x34;

	public static final int OPC_INR = 0x04;
	
	public static final int OPC_DCRA = 0x3D;
	public static final int OPC_DCRB = 0x05;
	public static final int OPC_DCRC = 0x0D;
	public static final int OPC_DCRD = 0x15;
	public static final int OPC_DCRE = 0x1D;
	public static final int OPC_DCRH = 0x25;
	public static final int OPC_DCRL = 0x2D;
	public static final int OPC_DCRM = 0x35;

	public static final int OPC_DCR = 0x05;

	public static final int OPC_INXB = 0x03;
	public static final int OPC_INXD = 0x13;
	public static final int OPC_INXH = 0x23;
	public static final int OPC_INXSP = 0x33;
	
	public static final int OPC_INX = 0x03;


	public static final int OPC_DCXB = 0x0B;
	public static final int OPC_DCXD = 0x1B;
	public static final int OPC_DCXH = 0x2B;
	public static final int OPC_DCXSP = 0x3B;

	public static final int OPC_DCX = 0x0B;


	public static final int OPC_LDA = 0x32;
	public static final int OPC_STA = 0x3A;

	public static final int OPC_LXIB = 0x01 | (REG_BC << 4);
	public static final int OPC_LXID = 0x01 | (REG_DE << 4);
	public static final int OPC_LXIH = 0x01 | (REG_HL << 4);
	public static final int OPC_LXISP = 0x01 | (REG_SP << 4);

	public static final int OPC_LXI = 0x01;

	public static final int OPC_LDAXB = 0x0A | (REG_BC << 4);
	public static final int OPC_LDAXD = 0x0A | (REG_DE << 4);

	public static final int OPC_STAXB = 0x02 | (REG_BC << 4);
	public static final int OPC_STAXD = 0x02 | (REG_DE << 4);

	public static final int OPC_HLT = 0x76;

	public static final int OPC_MVIB = 0x06;
	public static final int OPC_MVIC = 0x0E;
	public static final int OPC_MVID = 0x16;
	public static final int OPC_MVIE = 0x1E;
	public static final int OPC_MVIH = 0x26;
	public static final int OPC_MVIL = 0x2E;
	public static final int OPC_MVIM = 0x36;
	public static final int OPC_MVIA = 0x3E;

	public static final int OPC_MVI  = 0x06;

	public static final int OPC_CALL = 0xCD;

	public static final int OPC_SHLD = 0x22;
	public static final int OPC_LHLD = 0x2A;
	
	public static final int OPC_XCHG = 0xEB;
	public static final int OPC_PCHL = 0xE9;
	public static final int OPC_XTHL = 0xE3;
	public static final int OPC_SPHL = 0xF9;

	public static final int OPC_RET	= 0xC9;

	public static final int OPC_PUSHB = 0xC5;
	public static final int OPC_PUSHD = 0xD5;
	public static final int OPC_PUSHH = 0xE5;
	public static final int OPC_PUSHPSW = 0xF5;

	public static final int OPC_PUSH = 0xC5;

	private CStatusRegister regF;

	// Stack Pointer (Low, High) Part
	private CRegister8 regSPL;
	private CRegister8 regSPH;

	private LinkedList regs; // 8 Bit registers
	private LinkedList regs16; // 16 Bit registers
	
	private String[] regsDescription;
	private String[] regsDescription16;


	private CRegister8[] register;
	
	private int cycles;
	private int size;

	// collection von registern f�r die Anzeige
	// Die CPU selbst wei� welche Register da sind und wie die hei�en
	public CCPU8085 (CMemoryByte mem) {
		this.cycles = 0;
		this.size = 0;
		this.mem = mem;
		this.mnemonic = "";
		this.reset ();

		this.regF = new CStatusRegister ();

		this.regSPL = new CRegister8 ();
		this.regSPH = new CRegister8 ();

		this.regs = new LinkedList ();
		this.regs.add (REG_B, new CRegister8 ());
		this.regs.add (REG_C, new CRegister8 ());
		this.regs.add (REG_D, new CRegister8 ());
		this.regs.add (REG_E, new CRegister8 ());
		this.regs.add (REG_H, new CRegister8 ());
		this.regs.add (REG_L, new CRegister8 ());
		this.regs.add (REG_M, new CRegister16Memory ((CRegister8)this.regs.get(REG_L), (CRegister8)this.regs.get(REG_H), mem));
		this.regs.add (REG_A, new CRegister8 ());

		this.regs16 = new LinkedList ();
		this.regs16.add (REG_BC, new CRegister16Memory ((CRegister8)this.regs.get(REG_C), (CRegister8)this.regs.get(REG_B), mem));
		this.regs16.add (REG_DE, new CRegister16Memory ((CRegister8)this.regs.get(REG_E), (CRegister8)this.regs.get(REG_D), mem));
		this.regs16.add (REG_HL, new CRegister16Memory ((CRegister8)this.regs.get(REG_L), (CRegister8)this.regs.get(REG_H), mem));
		this.regs16.add (REG_SP, new CRegister16Memory (regSPL, regSPH, mem));
		
		this.regsDescription = new String[8];
		this.regsDescription[REG_B] = "B";
		this.regsDescription[REG_C] = "C";
		this.regsDescription[REG_D] = "D";
		this.regsDescription[REG_E] = "E";
		this.regsDescription[REG_H] = "H";
		this.regsDescription[REG_L] = "L";
		this.regsDescription[REG_M] = "M";
		this.regsDescription[REG_A] = "A";
		
		this.regsDescription16 = new String[4];
		this.regsDescription16[REG_BC] = "B";
		this.regsDescription16[REG_DE] = "D";
		this.regsDescription16[REG_HL] = "H";
		this.regsDescription16[REG_SP] = "SP";

	}

	protected CRegister8 getReg (int reg) {
		return (CRegister8)this.regs.get(reg);
	}
	protected CRegister16Memory getRegMem (int reg) {
		return (CRegister16Memory)this.regs16.get(reg);
	}
	protected CRegister16 getReg16 (int reg) {
		return (CRegister16)this.regs16.get(reg);
	}

	public int getCycles () {
		return this.cycles;
	}

	public int getPC () {
		return this.programCounter;
	}

	public int getSize () {
		return this.size;
	}

	public String getMnemonic () {
		return this.mnemonic;
	}

	public void setCycles (int cycles) {
		this.cycles = cycles;
	}

	public void setSize (int size) {
		this.size = size;
	}

	public LinkedList getRegister () {
		return this.regs;
	}
	public String[] getRegisterDescription () {
		return this.regsDescription;
	}

	public boolean cycle () {
		// Read one byte from memory the operation code
		int opc = this.mem.getMem (this.programCounter);
		int NrOfBytes = this.InterpretOPC (opc);
		this.programCounter += NrOfBytes;
		//TODO: Change the following
		//		We should use RST 1 or something like this.
		if (NrOfBytes == -1) {
			return true;
		} else {
			return false;
		}
	}

	public String showRegister () {
		String tmp = "";
		for (int i=0; i<this.regs.size (); i++) {
			if (tmp.length() > 0) {
				tmp += " ";
			}
			if (i == REG_M) {
				//tmp += this.regsDescription[i] + CFormat.toHex8(this.getRegMem(i).getValueIndirect());
				tmp += this.regsDescription[i] + CFormat.toHex8(
						((CRegister16Memory)this.regs.get(i)).getValueIndirect()
					);
			} else {
				tmp += this.regsDescription[i] + CFormat.toHex8(this.getReg (i).getValue());
			}
		}
		tmp += " SP" + CFormat.toHex16(this.getReg16 (REG_SP).getValue());
		return tmp;
	}

	public int read16BitFromMem (int opc) {
		return this.mem.getMem (opc) + 256 * this.mem.getMem (opc+1); 
	}

	private void opcLDA () {
		int adr = this.read16BitFromMem (this.programCounter+1);
		int val = this.mem.getMem (adr);
		this.getReg(REG_A).setValue (val);
		this.setCycles (13);
		this.mnemonic = "LDA  " + CFormat.toHex16 (adr) + " Val: " + CFormat.toHex8 (val);
	}

	private void opcSTA () {
		int adr = this.read16BitFromMem (this.programCounter+1);
		int val = this.getReg(REG_A).getValue ();
		this.mem.setMem (adr, val);
		this.setCycles (13);
		this.mnemonic = "STA  " + CFormat.toHex16(adr);
	}

	private void opcMOV (int dest, int src) {
		if (src == REG_M) {
			this.setCycles (7);
			//this.getReg (dest).setValue (this.getRegMem(src).getValueIndirect());
			this.getReg (dest).setValue (
					((CRegister16Memory)this.regs.get(src)).getValueIndirect()
				);
		} else if (dest == REG_M) {
			this.setCycles (7);
			((CRegister16Memory)this.regs.get(dest)).setValueIndirect(this.getReg(src).getValue());
			//this.getRegMem(dest).setValueIndirect (this.getReg(src).getValue());
		} else {
			this.setCycles (4);
			this.getReg (dest).setValue (this.getReg(src).getValue());
		}
		this.mnemonic = "MOV  " + this.regsDescription[dest] + "," + this.regsDescription[src];
	}

	private void opcMVI (int reg) {
		int mvivalue = this.mem.getMem (this.programCounter+1);
		if (reg == REG_M) {
			this.setCycles (10);
			((CRegister16Memory)this.regs.get(reg)).setValueIndirect(mvivalue);
			//this.getRegMem(reg).setValueIndirect(mvivalue);
		} else {
			this.setCycles (7);
			this.getReg (reg).setValue(mvivalue);
		}
		this.mnemonic = "MVI  " + this.regsDescription[reg] + "," + CFormat.toHex8 (mvivalue);
	}

	private void opcINR (int reg) {
		if (reg == REG_M) {
			this.setCycles (10);
			this.getRegMem(reg).incValueIndirect();
			//if (((CRegister16Memory)this.regs.get(reg)).isZero ()) {
			//	this.regF.setZero ();
			//}

		} else {
			this.setCycles (4);
			this.getReg (reg).incValue();
		}
		this.mnemonic = "INR  " + regsDescription[reg];
	}

	private void opcDCR (int reg) {
		if (reg == REG_M) {
			this.setCycles (10);
			this.getRegMem (reg).decValueIndirect();
		} else {
			this.setCycles (4);
			this.getReg (reg).decValue();
		}
		this.mnemonic = "DCR  " + regsDescription[reg];
	}

	private void opcINX (int reg) {
		this.setCycles (6);
		this.getReg16(reg).incValue();
		this.mnemonic = "INX  " + regsDescription16[reg];
	}

	private void opcDCX (int reg) {
		this.setCycles (6);
		this.getReg16 (reg).decValue();
		this.mnemonic = "DCX  " + regsDescription16[reg];
	}

	private void opcLXI (int reg) {
		this.setCycles (10);
		int val = this.read16BitFromMem (this.programCounter + 1);
		this.getReg16 (reg).setValue(val);
		this.mnemonic = "LXI  " + regsDescription16[reg] + "," + CFormat.toHex16 (val);
	}

	private void opcLDAX (int reg) {
		this.setCycles (10);
		int adr = this.getReg16(reg).getValue();
		int val = this.getRegMem(reg).getValueIndirect();
		this.getReg(REG_A).setValue(val); 
		this.mnemonic = "LDAX " + regsDescription16[reg];
	}

	private void opcSTAX (int reg) {
		this.setCycles (10);
		int val = this.getReg(REG_A).getValue();
		this.getRegMem(reg).setValueIndirect(val);
		this.mnemonic = "STAX " + regsDescription16[reg];
	}

	private void opcCALL () {
		this.setCycles (18);
		int adr = this.read16BitFromMem (this.programCounter + 1);
		int pushadr = this.programCounter + 3;
		this.getRegMem (REG_SP).pushWordIndirect(pushadr);
		this.programCounter = adr - 3;	
		this.mnemonic = "CALL " + CFormat.toHex16(adr); 
	}

	private void opcRET () {
		this.setCycles(10);
		int retadr = this.getRegMem (REG_SP).popWordIndirect();
		//int retadr = retadrl + 256 * retadrh;
		this.programCounter = retadr - 1;
		this.mnemonic = "RET"; 
	}

	private void opcPUSH (int reg) {
		this.setCycles(12);
		if (reg == REG_PSW) {
			int val = this.getReg(REG_A).getValue() + this.regF.getValue();
			this.getRegMem (REG_SP).pushWordIndirect(this.getRegMem (reg).getValue());
		} else {
			this.getRegMem (REG_SP).pushWordIndirect(this.getRegMem (reg).getValue());
		}
		this.mnemonic = "PUSH " + this.regsDescription16[reg];
	}

	private void opcPOP (int reg) {
		// 
		this.setCycles(12);
		int val = this.getRegMem (REG_SP).popWordIndirect();
		this.getRegMem (reg).setValue(val);
		this.mnemonic = "POP  " + this.regsDescription16[reg];
	}

	private void opcSHLD () {
		int adr = this.read16BitFromMem (this.programCounter+1);
		int valHL = this.getRegMem(REG_HL).getValue();
		this.mem.setMem16(adr, valHL);
		this.setCycles (16);
		this.mnemonic = "SHLD " + CFormat.toHex16 (adr);
	}

	private void opcLHLD () {
		int adr = this.read16BitFromMem (this.programCounter+1);
		this.getRegMem(REG_HL).setValue(this.mem.getMem16(adr));
		this.setCycles (16);
		this.mnemonic = "LHLD " + CFormat.toHex16 (adr);
	}
	
	private void opcXCHG () {
		int valHL = this.getRegMem(REG_HL).getValue();
		int valDE = this.getRegMem(REG_DE).getValue();
		this.getRegMem(REG_HL).setValue(valDE);
		this.getRegMem(REG_DE).setValue(valHL);
		this.setCycles(4);
		this.mnemonic = "XCHG";
	}
	
	private void opcPCHL () {
		this.programCounter = this.getRegMem(REG_HL).getValue();
		this.setCycles(6);
		this.mnemonic = "PCHL";
	}

	private void opcXTHL () {
		int valHL = this.getRegMem(REG_HL).getValue();
		int valStack = this.getRegMem (REG_SP).popWordIndirect();
		this.getRegMem (REG_SP).pushWordIndirect(valHL);
		this.getRegMem(REG_HL).setValue(valStack);
		this.setCycles (16);
		this.mnemonic = "XTHL";
	}
	
	private void opcSPHL () {
		int valSP = this.getRegMem(REG_SP).getValue();
		this.getRegMem (REG_HL).setValue (valSP);
		this.setCycles(6);
	}

	public int InterpretOPC (int opc) {
		int size = 0;
		int reg = 0;
		int src = 0;
		int dest = 0;
		switch (opc) {
			case OPC_INRB:
			case OPC_INRC:
			case OPC_INRD:
			case OPC_INRE:
			case OPC_INRH:
			case OPC_INRL:
			case OPC_INRM:
			case OPC_INRA:
				reg = (opc & 0x38) >> 3;
				this.opcINR (reg);
				this.setSize (1);
				break;

			case OPC_DCRB:
			case OPC_DCRC:
			case OPC_DCRD:
			case OPC_DCRE:
			case OPC_DCRH:
			case OPC_DCRL:
			case OPC_DCRM:
			case OPC_DCRA:
				reg = (opc & 0x38) >> 3;
				this.opcDCR (reg);
				this.setSize (1);
				break;

			case OPC_MOVBB :
			case OPC_MOVBC :
			case OPC_MOVBD :
			case OPC_MOVBE :
			case OPC_MOVBH :
			case OPC_MOVBL :
			case OPC_MOVBM :
			case OPC_MOVBA :

			case OPC_MOVCB :
			case OPC_MOVCC :
			case OPC_MOVCD :
			case OPC_MOVCE :
			case OPC_MOVCH :
			case OPC_MOVCL :
			case OPC_MOVCM :
			case OPC_MOVCA :

			case OPC_MOVDB :
			case OPC_MOVDC :
			case OPC_MOVDD :
			case OPC_MOVDE :
			case OPC_MOVDH :
			case OPC_MOVDL :
			case OPC_MOVDM :
			case OPC_MOVDA :

			case OPC_MOVEB :
			case OPC_MOVEC :
			case OPC_MOVED :
			case OPC_MOVEE :
			case OPC_MOVEH :
			case OPC_MOVEL :
			case OPC_MOVEM :
			case OPC_MOVEA :

			case OPC_MOVHB :
			case OPC_MOVHC :
			case OPC_MOVHD :
			case OPC_MOVHE :
			case OPC_MOVHH :
			case OPC_MOVHL :
			case OPC_MOVHM :
			case OPC_MOVHA :

			case OPC_MOVLB :
			case OPC_MOVLC :
			case OPC_MOVLD :
			case OPC_MOVLE :
			case OPC_MOVLH :
			case OPC_MOVLL :
			case OPC_MOVLM :
			case OPC_MOVLA :

			case OPC_MOVMB :
			case OPC_MOVMC :
			case OPC_MOVMD :
			case OPC_MOVME :
			case OPC_MOVMH :
			case OPC_MOVML :
			case OPC_MOVMA :

			case OPC_MOVAB :
			case OPC_MOVAC :
			case OPC_MOVAD :
			case OPC_MOVAE :
			case OPC_MOVAH :
			case OPC_MOVAL :
			case OPC_MOVAM :
			case OPC_MOVAA :
				src = opc & 0x07;
				dest = (opc & 0x38) >> 3;
				this.opcMOV (dest, src);
				this.setSize (1);
				break;

			case OPC_MVIB :
			case OPC_MVIC :
			case OPC_MVID :
			case OPC_MVIE :
			case OPC_MVIH :
			case OPC_MVIL :
			case OPC_MVIM :
			case OPC_MVIA :
				reg = (opc & 0x38) >> 3;
				this.opcMVI (reg);
				this.setSize (2);
				break;

			case OPC_INXB:
			case OPC_INXD:
			case OPC_INXH:
			case OPC_INXSP:
				reg = (opc & 0x70) >> 4;
				this.opcINX (reg);
				this.setSize (1);
				break;

			case OPC_DCXB:
			case OPC_DCXD:
			case OPC_DCXH:
			case OPC_DCXSP:
				reg = (opc & 0x70) >> 4;
				this.opcDCX (reg);
				this.setSize (1);
				break;

			case OPC_LXIB:
			case OPC_LXID:
			case OPC_LXIH:
			case OPC_LXISP:
				reg = (opc & 0x70) >> 4;
				this.opcLXI (reg);
				this.setSize (3);
				break;

			case OPC_LDAXB:
			case OPC_LDAXD:
				reg = (opc & 0x70) >> 4;
				this.opcLDAX (reg);
				this.setSize (1);
				break;

			case OPC_STAXB:
			case OPC_STAXD:
				reg = (opc & 0x70) >> 4;
				this.opcSTAX(reg);
				this.setSize (1);
				break;

			case OPC_LDA:
				this.opcLDA ();
				this.setSize (3);
				break;

			case OPC_STA:
				opcSTA ();
				this.setSize (3);
				break;

			case OPC_CALL:
				this.opcCALL ();
				this.setSize (3);
				break;

			case OPC_RET:
				this.opcRET();
				this.setSize (1);
				break;
				
			case OPC_LHLD:
				this.opcLHLD();
				this.setSize(3);
				break;

			case OPC_SHLD:
				this.opcSHLD ();
				this.setSize (3);
				break;
			
			case OPC_XCHG:
				this.opcXCHG ();
				this.setSize(1);
				break;

			case OPC_PCHL:
				this.opcPCHL ();
				this.setSize(1);
				break;
				
			case OPC_XTHL:
				this.opcXTHL ();
				this.setSize (1);
				break;

			case OPC_SPHL:
				this.opcSPHL();
				this.setSize(1);
				break;

			case OPC_PUSHB:
			case OPC_PUSHD:
			case OPC_PUSHH:
			case OPC_PUSHPSW:
				reg = (opc & 0x38) >> 3;
				this.setSize(1);
				this.opcPUSH (reg);
				break;

			case OPC_HLT:
				// temporarly used to stop Emulation
				this.setSize (-1);
				this.mnemonic = "HLT";
				break;
		}
		return this.getSize ();
	}

	public void reset () {
		this.programCounter = 0;
	}
}
