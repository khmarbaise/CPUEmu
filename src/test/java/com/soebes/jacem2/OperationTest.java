package com.soebes.jacem2;

import org.testng.annotations.Test;

import com.soebes.jacem.memory.CMemoryByte;

/**
 * 
 * http://www.pastraiser.com/cpu/i8085/i8085_opcodes.html
 * 
 * @author Karl Heinz Marbaise
 *
 */
public class OperationTest {

	@Test
	public void operationTest() {
		int pc = 0;
		int cycles = 0;
	
		CMemoryByte mem = new CMemoryByte(0, 1023);
		RegisterSet register8Bit = new RegisterSet (mem);

		OperationCode opcNOP = new OperationCodeNOP(mem, register8Bit);

		OperationCode opcINR = new OperationCodeINR(mem, register8Bit);
		OperationCode opcDCR = new OperationCodeDCR(mem, register8Bit);
		OperationCode opcMOV = new OperationCodeMOV(mem, register8Bit);
		
		OperationCode[] operationCodes = {
				
			// 0x00
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			
			// 0x08
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,

			// 0x10
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			
			// 0x18
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,

			// 0x20
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			
			// 0x28
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,

			// 0x30
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			
			// 0x38
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,
			opcNOP,

			// 0x40
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,

			// 0x48
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			
			// 0x50
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,

			// 0x58
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			
			// 0x60
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,

			// 0x68
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,

			// 0x70
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcNOP, // opcHLT,
			opcMOV,

			// 0x78
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV,
			opcMOV

		};


		while (true) {
			int opc = mem.getMem(pc);
			OperationCode opCode = operationCodes[opc];
			opCode.setOperationCode(opc);
			opCode.execute();
			cycles += opCode.getCycles();
			pc += opCode.getNumberOfBytes();
			System.out.println(opCode.getMnemonic() + " " + opCode.getOperators());
		}
		
	}
}
