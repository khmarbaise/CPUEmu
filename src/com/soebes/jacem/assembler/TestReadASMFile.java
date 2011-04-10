/**
 * 
 */
package com.soebes.jacem.assembler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.soebes.jacem.memory.CMemoryByte;
import com.soebes.jacem.parser.IOPCImpl;
import com.soebes.jacem.parser.Parser;

/**
 * @author kama
 *
 */
public class TestReadASMFile {

	public static void ReadFile (String filename) {
		System.out.print ("Reading File...");
		Parser p = new Parser ();
		try {
	        BufferedReader in = new BufferedReader(new FileReader(filename));
	        String str;
	        while ((str = in.readLine()) != null) {
	        	System.out.println("Line: " + str);
	        	p.parse(str);
	        }
	        in.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		ArrayList opcs = p.getOPCS ();
		if (opcs.size() > 0) {
			System.out.println("HALLLO");
		}
		for (Iterator it=opcs.iterator(); it.hasNext(); ) {
			IOPCImpl op = (IOPCImpl) it.next();
			System.out.println("OPC: " + op);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java CPU Emulator Assembler JaCEmAble");
		CMemoryByte cm = new CMemoryByte (0, 1023); // Create 1 KByte memory for using
		ReadFile ("test.asm");
//		System.out.println ("memory dump");
//		System.out.println (cm.dump());
	}

}
