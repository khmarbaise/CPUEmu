package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeINR extends AbstractOperationCode {

	public OperationCodeINR(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);

		setNumberOfBytes(1);
		setMnemonic("INR");
	}

	@Override
	public void execute() {

		Register8Bit register = convertToRegister8Bit((getOperationCode() & 0x38) >> 3);

		if (register == Register8Bit.M){
			setCycles(10);
		} else {
			setCycles(4);
		}

		getRegisterSet().increment(register);

		setOperators(register.name());

	}

}
