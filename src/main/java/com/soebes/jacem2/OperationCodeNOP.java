package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeNOP extends AbstractOperationCode {

	public OperationCodeNOP(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);

		setNumberOfBytes(1);
		setMnemonic("NOP");

		setCycles(4);
	}

	@Override
	public void execute() {
		setOperators(null);
	}

}
