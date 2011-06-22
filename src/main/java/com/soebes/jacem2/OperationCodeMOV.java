package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeMOV extends AbstractOperationCode {

	public OperationCodeMOV(CMemoryByte memory, RegisterSet registerSet) {
		super(memory, registerSet);

		setNumberOfBytes(1);
		setMnemonic("MOV");
	}

	@Override
	public void execute() {

		Register8Bit registerSrc = convertToRegister8Bit(getOperationCode() & 0x07);
		Register8Bit registerDest = convertToRegister8Bit((getOperationCode() & 0x38) >> 3);
		
		if (registerSrc == Register8Bit.M) {
			setCycles(7);
		} else if (registerDest == Register8Bit.M) {
			setCycles(7);
		} else {
			setCycles(4);
		}

		int value = getRegisterSet().getRegister(registerSrc);
		getRegisterSet().setRegister(registerDest, value);

		setOperators(registerDest.name() + "," + registerSrc.name());

	}

}
