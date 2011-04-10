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
public class ParseMOV extends IParseImpl {

	private int registerDest;
	private int registerSrc;
	/**
	 * 
	 */
	public ParseMOV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternMOV.matcher(line);
		if (m.matches ()) {
			registerDest = this.convertRegister(m.group(1));
			registerSrc = this.convertRegister(m.group(2));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			return new IOPCImpl (
					CCPU8085.OPC_MOV 
				|	(registerDest << 3)
				|	(registerSrc), 1
			);
		} else {
			return null;
		}
	}

}
