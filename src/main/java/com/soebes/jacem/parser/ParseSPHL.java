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
public class ParseSPHL extends IParseImpl {

	/**
	 * 
	 */
	public ParseSPHL() {
		super();
	}

	public boolean isValid (String line) {
		line = super.parseLabel (line);
		Matcher m = ParserPattern.patternSPHL.matcher(line);
		if (m.matches ()) {
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			return new IOPCImpl (CCPU8085.OPC_SPHL, 1);
		} else {
			return null;
		}
	}

}
