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
			opcNOP, // 00,
			opcNOP, // 01,
			opcNOP, // 02,
			opcNOP, // 03,
			opcNOP, // 04,
			opcNOP, // 05,
			opcNOP, // 06,
			opcNOP, // 07,

			opcNOP, // 08,
			opcNOP, // 09,
			opcNOP, // 0A,
			opcNOP, // 0B,
			opcNOP, // 0C,
			opcNOP, // 0D,
			opcNOP, // 0E,
			opcNOP, // 0F,

			opcNOP, // 10,
			opcNOP, // 11,
			opcNOP, // 12,
			opcNOP, // 13,
			opcNOP, // 14,
			opcNOP, // 15,
			opcNOP, // 16,
			opcNOP, // 17,

			opcNOP, // 18,
			opcNOP, // 19,
			opcNOP, // 1A,
			opcNOP, // 1B,
			opcNOP, // 1C,
			opcNOP, // 1D,
			opcNOP, // 1E,
			opcNOP, // 1F,

			opcNOP, // 20,
			opcNOP, // 21,
			opcNOP, // 22,
			opcNOP, // 23,
			opcNOP, // 24,
			opcNOP, // 25,
			opcNOP, // 26,
			opcNOP, // 27,

			opcNOP, // 28,
			opcNOP, // 29,
			opcNOP, // 2A,
			opcNOP, // 2B,
			opcNOP, // 2C,
			opcNOP, // 2D,
			opcNOP, // 2E,
			opcNOP, // 2F,

			opcNOP, // 30,
			opcNOP, // 31,
			opcNOP, // 32,
			opcNOP, // 33,
			opcNOP, // 34,
			opcNOP, // 35,
			opcNOP, // 36,
			opcNOP, // 37,

			opcNOP, // 38,
			opcNOP, // 39,
			opcNOP, // 3A,
			opcNOP, // 3B,
			opcNOP, // 3C,
			opcNOP, // 3D,
			opcNOP, // 3E,
			opcNOP, // 3F,

			opcNOP, // 40,
			opcNOP, // 41,
			opcNOP, // 42,
			opcNOP, // 43,
			opcNOP, // 44,
			opcNOP, // 45,
			opcNOP, // 46,
			opcNOP, // 47,

			opcNOP, // 48,
			opcNOP, // 49,
			opcNOP, // 4A,
			opcNOP, // 4B,
			opcNOP, // 4C,
			opcNOP, // 4D,
			opcNOP, // 4E,
			opcNOP, // 4F,

			opcNOP, // 50,
			opcNOP, // 51,
			opcNOP, // 52,
			opcNOP, // 53,
			opcNOP, // 54,
			opcNOP, // 55,
			opcNOP, // 56,
			opcNOP, // 57,

			opcNOP, // 58,
			opcNOP, // 59,
			opcNOP, // 5A,
			opcNOP, // 5B,
			opcNOP, // 5C,
			opcNOP, // 5D,
			opcNOP, // 5E,
			opcNOP, // 5F,

			opcNOP, // 60,
			opcNOP, // 61,
			opcNOP, // 62,
			opcNOP, // 63,
			opcNOP, // 64,
			opcNOP, // 65,
			opcNOP, // 66,
			opcNOP, // 67,

			opcNOP, // 68,
			opcNOP, // 69,
			opcNOP, // 6A,
			opcNOP, // 6B,
			opcNOP, // 6C,
			opcNOP, // 6D,
			opcNOP, // 6E,
			opcNOP, // 6F,

			opcNOP, // 70,
			opcNOP, // 71,
			opcNOP, // 72,
			opcNOP, // 73,
			opcNOP, // 74,
			opcNOP, // 75,
			opcNOP, // 76,
			opcNOP, // 77,

			opcNOP, // 78,
			opcNOP, // 79,
			opcNOP, // 7A,
			opcNOP, // 7B,
			opcNOP, // 7C,
			opcNOP, // 7D,
			opcNOP, // 7E,
			opcNOP, // 7F,

			opcNOP, // 80,
			opcNOP, // 81,
			opcNOP, // 82,
			opcNOP, // 83,
			opcNOP, // 84,
			opcNOP, // 85,
			opcNOP, // 86,
			opcNOP, // 87,

			opcNOP, // 88,
			opcNOP, // 89,
			opcNOP, // 8A,
			opcNOP, // 8B,
			opcNOP, // 8C,
			opcNOP, // 8D,
			opcNOP, // 8E,
			opcNOP, // 8F,

			opcNOP, // 90,
			opcNOP, // 91,
			opcNOP, // 92,
			opcNOP, // 93,
			opcNOP, // 94,
			opcNOP, // 95,
			opcNOP, // 96,
			opcNOP, // 97,

			opcNOP, // 98,
			opcNOP, // 99,
			opcNOP, // 9A,
			opcNOP, // 9B,
			opcNOP, // 9C,
			opcNOP, // 9D,
			opcNOP, // 9E,
			opcNOP, // 9F,

			opcNOP, // A0,
			opcNOP, // A1,
			opcNOP, // A2,
			opcNOP, // A3,
			opcNOP, // A4,
			opcNOP, // A5,
			opcNOP, // A6,
			opcNOP, // A7,

			opcNOP, // A8,
			opcNOP, // A9,
			opcNOP, // AA,
			opcNOP, // AB,
			opcNOP, // AC,
			opcNOP, // AD,
			opcNOP, // AE,
			opcNOP, // AF,

			opcNOP, // B0,
			opcNOP, // B1,
			opcNOP, // B2,
			opcNOP, // B3,
			opcNOP, // B4,
			opcNOP, // B5,
			opcNOP, // B6,
			opcNOP, // B7,

			opcNOP, // B8,
			opcNOP, // B9,
			opcNOP, // BA,
			opcNOP, // BB,
			opcNOP, // BC,
			opcNOP, // BD,
			opcNOP, // BE,
			opcNOP, // BF,

			opcNOP, // C0,
			opcNOP, // C1,
			opcNOP, // C2,
			opcNOP, // C3,
			opcNOP, // C4,
			opcNOP, // C5,
			opcNOP, // C6,
			opcNOP, // C7,

			opcNOP, // C8,
			opcNOP, // C9,
			opcNOP, // CA,
			opcNOP, // CB,
			opcNOP, // CC,
			opcNOP, // CD,
			opcNOP, // CE,
			opcNOP, // CF,

			opcNOP, // D0,
			opcNOP, // D1,
			opcNOP, // D2,
			opcNOP, // D3,
			opcNOP, // D4,
			opcNOP, // D5,
			opcNOP, // D6,
			opcNOP, // D7,

			opcNOP, // D8,
			opcNOP, // D9,
			opcNOP, // DA,
			opcNOP, // DB,
			opcNOP, // DC,
			opcNOP, // DD,
			opcNOP, // DE,
			opcNOP, // DF,

			opcNOP, // E0,
			opcNOP, // E1,
			opcNOP, // E2,
			opcNOP, // E3,
			opcNOP, // E4,
			opcNOP, // E5,
			opcNOP, // E6,
			opcNOP, // E7,

			opcNOP, // E8,
			opcNOP, // E9,
			opcNOP, // EA,
			opcNOP, // EB,
			opcNOP, // EC,
			opcNOP, // ED,
			opcNOP, // EE,
			opcNOP, // EF,

			opcNOP, // F0,
			opcNOP, // F1,
			opcNOP, // F2,
			opcNOP, // F3,
			opcNOP, // F4,
			opcNOP, // F5,
			opcNOP, // F6,
			opcNOP, // F7,

			opcNOP, // F8,
			opcNOP, // F9,
			opcNOP, // FA,
			opcNOP, // FB,
			opcNOP, // FC,
			opcNOP, // FD,
			opcNOP, // FE,
			opcNOP, // FF,
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
