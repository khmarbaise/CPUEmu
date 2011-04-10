/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.regex.Matcher;

import com.soebes.jacem.cpu.CCPU8085;

/**
 * @author kama
 *
 */
public class ParseINR extends IParseImpl {

	private int register;
	/**
	 * 
	 */
	public ParseINR() {
		super();
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternINR.matcher(line);
		if (m.matches ()) {
			register = this.convertRegister(m.group(1));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			return new IOPCImpl (
					CCPU8085.OPC_INR 
				|	(register << 3),
				1
			);
		} else {
			return null;
		}
	}

}
