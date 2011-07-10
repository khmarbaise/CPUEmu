package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public abstract class AbstractOperationCode implements OperationCode {

	private int numberOfBytes;
	private int cycles;
	private int operationCode;
	
	private CMemoryByte memory;
	private RegisterSet registerSet;
	
	private String mnemonic;
	private String operators;


	public AbstractOperationCode(CMemoryByte memory, RegisterSet registerSet) {
		this.memory = memory;
		this.registerSet = registerSet;
	}

	public void setCycles(int cycles) {
		this.cycles = cycles;
	}

	public int getCycles() {
		return cycles;
	}

	public void setNumberOfBytes(int numberOfBytes) {
		this.numberOfBytes = numberOfBytes;
	}

	public int getNumberOfBytes() {
		return numberOfBytes;
	}
	
	public void setOperationCode(int operationCode) {
		this.operationCode = operationCode;
	}

	public int getOperationCode() {
		return operationCode;
	}

	public CMemoryByte getMemory() {
		return memory;
	}
	
	public void setMemory(CMemoryByte memory) {
		this.memory = memory;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public boolean hasOperators() {
		if (operators == null || operators.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public Register8Bit convertToRegister8Bit(int src) {
		return Register8Bit.values()[src];
	}

	public Register16Bit convertToRegister16Bit(int src) {
		return Register16Bit.values()[src];
	}
	public void setRegisterSet(RegisterSet registerSet) {
		this.registerSet = registerSet;
	}

	public RegisterSet getRegisterSet() {
		return registerSet;
	}
}


