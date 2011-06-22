package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class RegisterSet {

	private int programmCounter;

	private CMemoryByte mem;

	private int registerSet[] = new int[Register8Bit.values().length];
	private int registerSP = 0; 
	
	public RegisterSet(CMemoryByte mem) {
		this.setMem(mem);
	}
	
	public int getRegister(Register8Bit register) {
		if (register == Register8Bit.M) {
			return getMem().getMem(
				registerSet[Register8Bit.H.ordinal()] * 256 
			  + registerSet[Register8Bit.L.ordinal()]
			);
		} else {
			return registerSet[register.ordinal()];
		}
	}

	public int getRegister(Register16Bit register) {
		int result = 0;
		if (register == Register16Bit.SP) {
			return registerSP;
		} else {
			switch (register) {
			case B:
				result = registerSet[Register8Bit.B.ordinal()] * 256 + registerSet[Register8Bit.C.ordinal()];
				break;
			case D:
				result = registerSet[Register8Bit.D.ordinal()] * 256 + registerSet[Register8Bit.E.ordinal()];
				break;
			case H:
				result = registerSet[Register8Bit.H.ordinal()] * 256 + registerSet[Register8Bit.L.ordinal()];
				break;
			case SP:
				//already handled.
				break;
			}
			return result;
		}
	}
	
	public void setRegister(Register8Bit register, int value) {
		if (register == Register8Bit.M) {
			getMem().setMem(
				registerSet[Register8Bit.H.ordinal()] * 256 + registerSet[Register8Bit.L.ordinal()], 
				value
			);
		} else {
			registerSet[register.ordinal()] = value;
		}
	}

	public void setRegister(Register16Bit register, int value) {
		if (register == Register16Bit.SP) {
			registerSP = value;;
		} else {
			switch (register) {
			case B:
				registerSet[Register8Bit.B.ordinal()] = (value & 0xff00) >> 8;
				registerSet[Register8Bit.C.ordinal()] = (value & 0x00ff);
				break;
			case D:
				registerSet[Register8Bit.D.ordinal()] = (value & 0xff00) >> 8;
				registerSet[Register8Bit.E.ordinal()] = (value & 0x00ff);
				break;
			case H:
				registerSet[Register8Bit.H.ordinal()] = (value & 0xff00) >> 8;
				registerSet[Register8Bit.L.ordinal()] = (value & 0x00ff);
				break;
			case SP:
				//already handled.
				break;
			}
		}
	}

	public void increment(Register8Bit register) {
		if (register == Register8Bit.M) {
			int address = registerSet[Register8Bit.H.ordinal()] * 256 + registerSet[Register8Bit.L.ordinal()];
			int result = getMem().getMem(address);
			getMem().setMem(address, result + 1);
		} else {
			registerSet[register.ordinal()]++;
		}
	}

	public void increment(Register16Bit register) {
		int result = getRegister(register) + 1;
		setRegister(register, result);
	}

	public void decrement(Register8Bit register) {
		if (register == Register8Bit.M) {
			int address = registerSet[Register8Bit.H.ordinal()] * 256 + registerSet[Register8Bit.L.ordinal()];
			int result = getMem().getMem(address);
			getMem().setMem(address, result -1);
		} else {
			registerSet[register.ordinal()]--;
		}
	}

	public void decrement(Register16Bit register) {
		int result = getRegister(register) - 1;
		setRegister(register, result);
	}

	public void incrementPC() {
		setProgrammCounter(getProgrammCounter() + 1);
	}
	public void incrementPC(int value) {
		setProgrammCounter(getProgrammCounter() + value);
	}

	public void decrementPC() {
		setProgrammCounter(getProgrammCounter() - 1);
	}

	public void setMem(CMemoryByte mem) {
		this.mem = mem;
	}

	public CMemoryByte getMem() {
		return mem;
	}

	public void setProgrammCounter(int programmCounter) {
		this.programmCounter = programmCounter;
	}

	public int getProgrammCounter() {
		return programmCounter;
	}
}
