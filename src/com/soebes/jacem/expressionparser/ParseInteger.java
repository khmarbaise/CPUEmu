/**
 * 
 */
package com.soebes.jacem.expressionparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.soebes.jacem.cpu.CCPU8085;
import com.soebes.jacem.parser.IOPCImpl;

/**
 * @author kama
 *
 */
public class ParseInteger {

	private int value;

	public final static Pattern patternInteger = Pattern.compile (
		"^(\\d+)(.*)$",
		Pattern.CASE_INSENSITIVE
	);

	public boolean isValid (String line) {
		Matcher m = patternInteger.matcher(line);
		if (m.matches ()) {
			value = Integer.parseInt(m.group(1));
			return true;
		}
		return false;
	}

	public IOPCImpl parse(String line) {
		if (this.isValid (line)) {
			return new IOPCImpl (CCPU8085.OPC_DCR, 3); 
		} else {
			return null;
		}
	}

	public ParseInteger () {
		super ();
		value = 0;
	}

}
