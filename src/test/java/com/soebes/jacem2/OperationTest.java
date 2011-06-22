package com.soebes.jacem2;

import org.testng.annotations.Test;

import com.soebes.jacem.memory.CMemoryByte;

/**
 * 
 * http://de.wikipedia.org/wiki/Intel_8085
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
				A00,
				A01,
				A02,
				A03,
				INR_B,
				A05,
				A06,
				A07,

				A08,
				A09,
				A0A,
				A0B,
				INR_C,
				A0D,
				A0E,
				A0F,

				A10,
				A11,
				A12,
				A13,
				INR_D,
				A15,
				A16,
				A17,

				A18,
				A19,
				A1A,
				A1B,
				INR_E,
				A1D,
				A1E,
				A1F,

				A20,
				A21,
				A22,
				A23,
				INR_H,
				A25,
				A26,
				A27,

				A28,
				A29,
				A2A,
				A2B,
				INR_L,
				A2D,
				A2E,
				A2F,

				A30,
				A31,
				A32,
				A33,
				INR_M,
				A35,
				A36,
				A37,

				A38,
				A39,
				A3A,
				A3B,
				INR_A,
				A3D,
				A3E,
				A3F,

				// 0x40
				MOV_B_B,
				MOV_B_C,
				MOV_B_D,
				MOV_B_E,
				MOV_B_H,
				MOV_B_L,
				MOV_B_M,
				MOV_B_A,

				// 0x48
				MOV_C_B,
				MOV_C_C,
				MOV_C_D,
				MOV_C_E,
				MOV_C_H,
				MOV_C_L,
				MOV_C_M,
				MOV_C_A,

				// 0x50
				MOV_D_B,
				MOV_D_C,
				MOV_D_D,
				MOV_D_E,
				MOV_D_H,
				MOV_D_L,
				MOV_D_M,
				MOV_D_A,

				// 0x58
				MOV_E_B,
				MOV_E_C,
				MOV_E_D,
				MOV_E_E,
				MOV_E_H,
				MOV_E_L,
				MOV_E_M,
				MOV_E_A,

				// 0x60
				MOV_H_B,
				MOV_H_C,
				MOV_H_D,
				MOV_H_E,
				MOV_H_H,
				MOV_H_L,
				MOV_H_M,
				MOV_H_A,

				// 0x68
				MOV_L_B,
				MOV_L_C,
				MOV_L_D,
				MOV_L_E,
				MOV_L_H,
				MOV_L_L,
				MOV_L_M,
				MOV_L_A,

				// 0x70
				MOV_M_B,
				MOV_M_C,
				MOV_M_D,
				MOV_M_E,
				MOV_M_H,
				MOV_M_L,
				HLT,
				MOV_M_A,

				// 0x78
				MOV_A_B,
				MOV_A_C,
				MOV_A_D,
				MOV_A_E,
				MOV_A_H,
				MOV_A_L,
				MOV_A_M,
				MOV_A_A,

				A80,
				A81,
				A82,
				A83,
				A84,
				A85,
				A86,
				A87,

				A88,
				A89,
				A8A,
				A8B,
				A8C,
				A8D,
				A8E,
				A8F,

				A90,
				A91,
				A92,
				A93,
				A94,
				A95,
				A96,
				A97,

				A98,
				A99,
				A9A,
				A9B,
				A9C,
				A9D,
				A9E,
				A9F,

				AA0,
				AA1,
				AA2,
				AA3,
				AA4,
				AA5,
				AA6,
				AA7,

				AA8,
				AA9,
				AAA,
				AAB,
				AAC,
				AAD,
				AAE,
				AAF,

				AB0,
				AB1,
				AB2,
				AB3,
				AB4,
				AB5,
				AB6,
				AB7,

				AB8,
				AB9,
				ABA,
				ABB,
				ABC,
				ABD,
				ABE,
				ABF,

				AC0,
				AC1,
				AC2,
				AC3,
				AC4,
				AC5,
				AC6,
				AC7,

				AC8,
				AC9,
				ACA,
				ACB,
				ACC,
				ACD,
				ACE,
				ACF,

				AD0,
				AD1,
				AD2,
				AD3,
				AD4,
				AD5,
				AD6,
				AD7,

				AD8,
				AD9,
				ADA,
				ADB,
				ADC,
				ADD,
				ADE,
				ADF,

				AE0,
				AE1,
				AE2,
				AE3,
				AE4,
				AE5,
				AE6,
				AE7,

				AE8,
				AE9,
				AEA,
				AEB,
				AEC,
				AED,
				AEE,
				AEF,

				AF0,
				AF1,
				AF2,
				AF3,
				AF4,
				AF5,
				AF6,
				AF7,

				AF8,
				AF9,
				AFA,
				AFB,
				AFC,
				AFD,
				AFE,
				AFF,
		};

		//Define reset address.
		register8Bit.setProgrammCounter(0);

		mem.setMem(0, OperationCodes.INR_A);
		mem.setMem(1, OperationCodes.HLT);

		while (true) {
			int opc = mem.getMem(register8Bit.getProgrammCounter());
			OperationCode opCode = operationCodes[opc];
			opCode.setOperationCode(opc);
			register8Bit.incrementPC();

			opCode.execute();

			cycles += opCode.getCycles();

			if (opCode.getNumberOfBytes() > 1) {
				register8Bit.incrementPC(opCode.getNumberOfBytes());
			}
			System.out.println(opCode.getMnemonic() + " " + opCode.getOperators());
		}
		
	}
}
