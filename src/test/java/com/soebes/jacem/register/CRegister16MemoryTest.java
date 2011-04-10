/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS
 */
package com.soebes.jacem.register;

import com.soebes.jacem.memory.CMemoryByte;
import com.soebes.jacem.register.CRegister16;
import com.soebes.jacem.register.CRegister16Memory;
import com.soebes.jacem.register.CRegister8;

import junit.framework.TestCase;

public class CRegister16MemoryTest extends TestCase {

    public final static int MEMORY_MIN = 0;
    public final static int MEMORY_MAX = 768;

    private CRegister8 regL;
    private CRegister8 regH;
    private CRegister16 reg;
    private CRegister16Memory regmem;
    private CMemoryByte mem;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(CRegister16MemoryTest.class);
    }

    public CRegister16MemoryTest(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.regL = new CRegister8 ();
        this.regH = new CRegister8 ();
        this.reg = new CRegister16 (this.regL, this.regH);
        this.mem = new CMemoryByte (MEMORY_MIN, MEMORY_MAX);
        this.regmem = new CRegister16Memory (this.reg, this.mem);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSetGetValue () {
        for (int i=MEMORY_MIN; i<MEMORY_MAX; i++) {
            for (int val=CMemoryByte.MEMORY_CONTENT_MIN; val<CMemoryByte.MEMORY_CONTENT_MAX; val++) {
                this.regmem.setValueIndirect(val);
                assertEquals (val, this.regmem.getValueIndirect());
            }
            // go one cell forward in memory
            this.reg.incValue();
        }
    }
}
