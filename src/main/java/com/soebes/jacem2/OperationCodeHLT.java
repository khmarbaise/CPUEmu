package com.soebes.jacem2;

import com.soebes.jacem.memory.CMemoryByte;

public class OperationCodeHLT extends AbstractOperationCode {

    public OperationCodeHLT(CMemoryByte memory, RegisterSet registerSet) {
        super(memory, registerSet);

        setNumberOfBytes(0); // Only a trick currently.
        setMnemonic("HLT");
    }

    @Override
    public void execute() {
        setCycles(4);

    }

}
