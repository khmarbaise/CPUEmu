package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeINX extends AbstractOperationCode {

	public OperationCodeINX(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);

		setNumberOfBytes(1);
		setMnemonic("INX");
	}

	@Override
	public void execute() {
		
		Register16Bit register = convertToRegister16Bit((getOperationCode() & 0x70) >> 4);

		getRegisterSet().increment(register);

		setOperators(register.name());
	}

}
