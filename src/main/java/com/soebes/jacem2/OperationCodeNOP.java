package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeNOP extends AbstractOperationCode {

	public OperationCodeNOP(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);
	}

	@Override
	public void execute() {
		setNumberOfBytes(1);
		setMnemonic("NOP");
		setCycles(4);
		setOperators(null);
	}

}
