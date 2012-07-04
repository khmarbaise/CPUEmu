package com.soebes.jacem2;

import org.testng.annotations.Test;

import com.soebes.jacem.CFormat;
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
        int cycles = 0;

        CMemoryByte mem = new CMemoryByte(0, 1023);
        RegisterSet register8Bit = new RegisterSet(mem);

        OperationCode opcNOP = new OperationCodeNOP(mem, register8Bit);

        OperationCode opcINR = new OperationCodeINR(mem, register8Bit);
        OperationCode opcDCR = new OperationCodeDCR(mem, register8Bit);
        OperationCode opcMOV = new OperationCodeMOV(mem, register8Bit);

        OperationCode opcINX = new OperationCodeINX(mem, register8Bit);
        OperationCode opcDCX = new OperationCodeDCX(mem, register8Bit);

        OperationCode opcMVI = new OperationCodeMVI(mem, register8Bit);
        OperationCode opcHLT = new OperationCodeHLT(mem, register8Bit);

        OperationCode[] operationCodes = {
                opcNOP, // A00,
                opcNOP, // A01,
                opcNOP, // A02,
                opcINX, // INX B
                opcINR, // INR B
                opcNOP, // A05,
                opcNOP, // A06,
                opcNOP, // A07,

                opcNOP, // A08,
                opcNOP, // A09,
                opcNOP, // A0A,
                opcNOP, // A0B,
                opcINR, // INR C
                opcNOP, // A0D,
                opcNOP, // A0E,
                opcNOP, // A0F,

                opcNOP, // A10,
                opcNOP, // A11,
                opcNOP, // A12,
                opcNOP, // A13,
                opcINR, // INR D
                opcNOP, // A15,
                opcNOP, // A16,
                opcNOP, // A17,

                opcNOP, // A18,
                opcNOP, // A19,
                opcNOP, // A1A,
                opcNOP, // A1B,
                opcINR, // INR E
                opcNOP, // A1D,
                opcNOP, // A1E,
                opcNOP, // A1F,

                opcNOP, // A20,
                opcNOP, // A21,
                opcNOP, // A22,
                opcNOP, // A23,
                opcINR, // INR H
                opcNOP, // A25,
                opcNOP, // A26,
                opcNOP, // A27,

                opcNOP, // A28,
                opcNOP, // A29,
                opcNOP, // A2A,
                opcNOP, // A2B,
                opcINR, // INR L
                opcNOP, // A2D,
                opcNOP, // A2E,
                opcNOP, // A2F,

                opcNOP, // A30,
                opcNOP, // A31,
                opcNOP, // A32,
                opcNOP, // A33,
                opcINR, // INR M
                opcNOP, // A35,
                opcNOP, // A36,
                opcNOP, // A37,

                opcNOP, // A38,
                opcNOP, // A39,
                opcNOP, // A3A,
                opcNOP, // A3B,
                opcINR, // INR A
                opcNOP, // A3D,
                opcNOP, // A3E,
                opcNOP, // A3F,

                // 0x40
                opcMOV, // MOV_B_B
                opcMOV, // MOV_B_C
                opcMOV, // MOV_B_D
                opcMOV, // MOV_B_E
                opcMOV, // MOV_B_H
                opcMOV, // MOV_B_L
                opcMOV, // MOV_B_M
                opcMOV, // MOV_B_A

                // 0x48
                opcMOV, // MOV_C_B
                opcMOV, // MOV_C_C
                opcMOV, // MOV_C_D
                opcMOV, // MOV_C_E
                opcMOV, // MOV_C_H
                opcMOV, // MOV_C_L
                opcMOV, // MOV_C_M
                opcMOV, // MOV_C_A

                // 0x50
                opcMOV, // MOV_D_B
                opcMOV, // MOV_D_C
                opcMOV, // MOV_D_D
                opcMOV, // MOV_D_E
                opcMOV, // MOV_D_H
                opcMOV, // MOV_D_L
                opcMOV, // MOV_D_M
                opcMOV, // MOV_D_A

                // 0x58
                opcMOV, // MOV_E_B
                opcMOV, // MOV_E_C
                opcMOV, // MOV_E_D
                opcMOV, // MOV_E_E
                opcMOV, // MOV_E_H
                opcMOV, // MOV_E_L
                opcMOV, // MOV_E_M
                opcMOV, // MOV_E_A

                // 0x60
                opcMOV, // MOV_H_B
                opcMOV, // MOV_H_C
                opcMOV, // MOV_H_D
                opcMOV, // MOV_H_E
                opcMOV, // MOV_H_H
                opcMOV, // MOV_H_L
                opcMOV, // MOV_H_M
                opcMOV, // MOV_H_A

                // 0x68
                opcMOV, // MOV_L_B
                opcMOV, // MOV_L_C
                opcMOV, // MOV_L_D
                opcMOV, // MOV_L_E
                opcMOV, // MOV_L_H
                opcMOV, // MOV_L_L
                opcMOV, // MOV_L_M
                opcMOV, // MOV_L_A

                // 0x70
                opcMOV, // MOV_M_B
                opcMOV, // MOV_M_C
                opcMOV, // MOV_M_D
                opcMOV, // MOV_M_E
                opcMOV, // MOV_M_H
                opcMOV, // MOV_M_L
                opcHLT,
                opcMOV, // MOV_M_A

                // 0x78
                opcMOV, // MOV_A_B
                opcMOV, // MOV_A_C
                opcMOV, // MOV_A_D
                opcMOV, // MOV_A_E
                opcMOV, // MOV_A_H
                opcMOV, // MOV_A_L
                opcMOV, // MOV_A_M
                opcMOV, // MOV_A_A

                opcNOP, // A80,
                opcNOP, // A81,
                opcNOP, // A82,
                opcNOP, // A83,
                opcNOP, // A84,
                opcNOP, // A85
                opcNOP, // A86
                opcNOP, // A87

                opcNOP, // A88
                opcNOP, // A89
                opcNOP, // A8A
                opcNOP, // A8B
                opcNOP, // A8C
                opcNOP, // A8D
                opcNOP, // A8E
                opcNOP, // A8F

                opcNOP, // A90
                opcNOP, // A91
                opcNOP, // A92
                opcNOP, // A93
                opcNOP, // A94
                opcNOP, // A95
                opcNOP, // A96
                opcNOP, // A97

                opcNOP, // A98
                opcNOP, // A99
                opcNOP, // A9A
                opcNOP, // A9B
                opcNOP, // A9C
                opcNOP, // A9D
                opcNOP, // A9E
                opcNOP, // A9F

                opcNOP, // AA0
                opcNOP, // AA1
                opcNOP, // AA2
                opcNOP, // AA3
                opcNOP, // AA4
                opcNOP, // AA5
                opcNOP, // AA6
                opcNOP, // AA7

                opcNOP, // AA8
                opcNOP, // AA9
                opcNOP, // AAA
                opcNOP, // AAB
                opcNOP, // AAC
                opcNOP, // AAD
                opcNOP, // AAE
                opcNOP, // AAF

                opcNOP, // AB0
                opcNOP, // AB1
                opcNOP, // AB2
                opcNOP, // AB3
                opcNOP, // AB4
                opcNOP, // AB5
                opcNOP, // AB6
                opcNOP, // AB7

                opcNOP, // AB8
                opcNOP, // AB9
                opcNOP, // ABA
                opcNOP, // ABB
                opcNOP, // ABC
                opcNOP, // ABD
                opcNOP, // ABE
                opcNOP, // ABF

                opcNOP, // AC0
                opcNOP, // AC1
                opcNOP, // AC2
                opcNOP, // AC3
                opcNOP, // AC4
                opcNOP, // AC5
                opcNOP, // AC6
                opcNOP, // AC7

                opcNOP, // AC8
                opcNOP, // AC9
                opcNOP, // ACA
                opcNOP, // ACB
                opcNOP, // ACC
                opcNOP, // ACD
                opcNOP, // ACE
                opcNOP, // ACF

                opcNOP, // AD0
                opcNOP, // AD1
                opcNOP, // AD2
                opcNOP, // AD3
                opcNOP, // AD4
                opcNOP, // AD5
                opcNOP, // AD6
                opcNOP, // AD7

                opcNOP, // AD8
                opcNOP, // AD9
                opcNOP, // ADA
                opcNOP, // ADB
                opcNOP, // ADC
                opcNOP, // ADD
                opcNOP, // ADE
                opcNOP, // ADF

                opcNOP, // AE0
                opcNOP, // AE1
                opcNOP, // AE2
                opcNOP, // AE3
                opcNOP, // AE4
                opcNOP, // AE5
                opcNOP, // AE6
                opcNOP, // AE7

                opcNOP, // AE8
                opcNOP, // AE9
                opcNOP, // AEA
                opcNOP, // AEB
                opcNOP, // AEC
                opcNOP, // AED
                opcNOP, // AEE
                opcNOP, // AEF

                opcNOP, // AF0
                opcNOP, // AF1
                opcNOP, // AF2
                opcNOP, // AF3
                opcNOP, // AF4
                opcNOP, // AF5
                opcNOP, // AF6
                opcNOP, // AF7

                opcNOP, // AF8
                opcNOP, // AF9
                opcNOP, // AFA
                opcNOP, // AFB
                opcNOP, // AFC
                opcNOP, // AFD
                opcNOP, // AFE
                opcNOP, // AFF
        };

        // Define reset address.
        register8Bit.setProgrammCounter(0);

        mem.setMem(0, OperationCodes.INR_A);
        mem.setMem(1, OperationCodes.INR_B);
        mem.setMem(2, OperationCodes.INR_C);
        mem.setMem(3, OperationCodes.INX_B);
        mem.setMem(4, OperationCodes.MOV_C_A);

        mem.setMem(5, OperationCodes.MOV_D_B);
        mem.setMem(6, OperationCodes.HLT);
        mem.setMem(7, OperationCodes.HLT);
        mem.setMem(8, OperationCodes.HLT);
        mem.setMem(9, OperationCodes.HLT);
        mem.setMem(10, OperationCodes.HLT);
        while (true) {
            int opc = mem.getMem(register8Bit.getProgrammCounter());
            OperationCode opCode = operationCodes[opc];
            opCode.setOperationCode(opc);

            opCode.execute();

            cycles += opCode.getCycles();

            System.out.printf("%4s ", CFormat.toHex16(register8Bit.getProgrammCounter()));
            System.out.print(register8Bit.show() + " ");
            System.out.printf("%-4s", opCode.getMnemonic());
            if (opCode.hasOperators()) {
                System.out.println(" " + opCode.getOperators());
            } else {
                System.out.println();
            }

            if (opCode.getNumberOfBytes() > 0) {
                register8Bit.incrementPC(opCode.getNumberOfBytes());
            } else {
                break;
            }
        }

    }
}
