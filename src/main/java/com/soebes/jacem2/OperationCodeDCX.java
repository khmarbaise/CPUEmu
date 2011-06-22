package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeDCX extends AbstractOperationCode {

	public OperationCodeDCX(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);

		setNumberOfBytes(1);
		setMnemonic("DCX");
	}

	@Override
	public void execute() {
		Register16Bit register = convertToRegister16Bit((getOperationCode() & 0x0b) >> 4);

		getRegisterSet().decrement(register);

		setOperators(register.name());
	}

}
