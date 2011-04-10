/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.regex.Matcher;

import com.soebes.jacem.cpu.CCPU8085;

/**
 */
public class ParseLXI extends IParseImpl {

	private int register;
	private int value;
	/**
	 * 
	 */
	public ParseLXI() {
		super();
		this.register = 0;
		this.value = 0;
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternLXI.matcher(line);
		if (m.matches ()) {
			register = this.convertRegister16(m.group(1));
			value = Integer.parseInt(m.group(3));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			IOPCImpl opc = new IOPCImpl (CCPU8085.OPC_LXI | (register << 4), 1);
			opc.addByte(value);
			return opc;
		} else {
			return null;
		}
	}

}
