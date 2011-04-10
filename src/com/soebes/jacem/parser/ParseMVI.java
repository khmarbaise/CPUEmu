/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.regex.Matcher;

import com.soebes.jacem.cpu.CCPU8085;

/**
 */
public class ParseMVI extends IParseImpl {

	private int register;
	private int value;
	/**
	 * 
	 */
	public ParseMVI() {
		super();
		this.register = 0;
		this.value = 0;
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternMVI.matcher(line);
		if (m.matches ()) {
			register = this.convertRegister(m.group(1));
			value = Integer.parseInt(m.group(2));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			IOPCImpl opc = new IOPCImpl (CCPU8085.OPC_MVI | (register << 3), 2);
			opc.addByte(value);
			return opc;
		} else {
			return null;
		}
	}

}
