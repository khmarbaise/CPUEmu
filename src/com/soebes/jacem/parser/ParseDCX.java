/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.regex.Matcher;

import com.soebes.jacem.cpu.CCPU8085;

/**
 */
public class ParseDCX extends IParseImpl {

	private int register;
	/**
	 * 
	 */
	public ParseDCX() {
		super();
		this.register = 0;
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternDCX.matcher(line);
		if (m.matches ()) {
			register = this.convertRegister16(m.group(1));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			IOPCImpl opc = new IOPCImpl (CCPU8085.OPC_DCX | (register << 4), 1);
			return opc;
		} else {
			return null;
		}
	}

}
