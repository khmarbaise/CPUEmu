/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.ArrayList;

/**
 * @author kama
 *
 */
public class IOPCImpl implements IOPC {

	private int opc;
	private int size;

	private ArrayList bytes;
	/**
	 * 
	 */
	public IOPCImpl(int opc, int size) {
		setOpc (opc);
		setSize (size);
		this.bytes = new ArrayList ();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void addByte (int onebyte) {
		this.bytes.add(new Integer(onebyte));
	}
	public ArrayList getBytes () {
		return this.bytes;
	}

	public int getOpc() {
		return opc;
	}

	public void setOpc(int opc) {
		this.opc = opc;
	}
}
