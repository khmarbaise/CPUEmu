/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.regex.Matcher;

import com.soebes.jacem.cpu.CCPU8085;

public class IParseImpl implements IParse {

	private String label;

	/**
	 * 
	 */
	public IParseImpl() {
		super();
	}

	protected int convertRegister (String reg) {
		if (reg.equals("A")) {
			return CCPU8085.REG_A;
		} else if (reg.equals("B")) {
			return CCPU8085.REG_B;
		} else if (reg.equals("C")) {
			return CCPU8085.REG_C;
		} else if (reg.equals("D")) {
			return CCPU8085.REG_D;
		} else if (reg.equals("E")) {
			return CCPU8085.REG_E;
		} else if (reg.equals("H")) {
			return CCPU8085.REG_H;
		} else if (reg.equals("L")) {
			return CCPU8085.REG_L;
		} else {
			// Value for Register M
			return CCPU8085.REG_M;
		}
	}
	
	public int convertRegister16 (String reg) {
		if (reg.equals("B")) {
			return CCPU8085.REG_BC;
		} else if (reg.equals("D")) {
			return CCPU8085.REG_DE;
		} else if (reg.equals("SP")) {
			return CCPU8085.REG_SP;
		} else {
			return CCPU8085.REG_HL;
		}
	}
	public int convertRegister16PSW (String reg) {
		if (reg.equals("B")) {
			return CCPU8085.REG_BC;
		} else if (reg.equals("D")) {
			return CCPU8085.REG_DE;
		} else if (reg.equals("PSW")) {
			return CCPU8085.REG_PSW;
		} else {
			return CCPU8085.REG_HL;
		}
	}

	public boolean hasLabel (String line) {
		Matcher m = ParserPattern.patternLabel.matcher(line);
		if (m.matches ()) {
			return true;
		} else {
			return false;
		}
	}

	public String parseLabel (String line) {
		Matcher m = ParserPattern.patternLabel.matcher(line);
		if (m.matches ()) {
			this.setLabel(m.group(1));
			return m.group(2);
		}
		return line;
	}

	public IOPCImpl parse (String line) {
		return null;
	}
	
	public boolean isValid (String line) {
		if (this.hasLabel(line)) {
			return true;
		} else {
			return false;
		}
	}
	public String getLabel () {
		return this.label;
	}

	public Label asLabel() {
		return new Label (this.getLabel(), 0);
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
