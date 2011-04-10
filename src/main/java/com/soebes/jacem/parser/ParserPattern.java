package com.soebes.jacem.parser;

import java.util.regex.Pattern;

public class ParserPattern {

	public final static String patternRegister8 = "([ABCDEHLM])";
	public final static String patternRegister16 = "([BDH]|(SP))";
	public final static String patternRegister16PSW = "([BDH]|(PSW))";

	public final static Pattern patternLabel = Pattern.compile(
		"^\\s*?(\\w+):\\s*(.*)$", 
		Pattern.CASE_INSENSITIVE
	);

	public final static Pattern patternComment = Pattern.compile(
		";.*$",
		Pattern.CASE_INSENSITIVE
	);
	
	public final static Pattern patternMVI = Pattern.compile (
		"^MVI\\s+" + patternRegister8 + "\\s*,\\s*" + "(.*)",
		Pattern.CASE_INSENSITIVE
	);

	public final static Pattern patternMOV = Pattern.compile (
		"^MOV\\s+" + patternRegister8 + "\\s*,\\s*" + patternRegister8,
		Pattern.CASE_INSENSITIVE
	);

	public final static Pattern patternINR = Pattern.compile (
		"^INR\\s+" + patternRegister8,
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternDCR = Pattern.compile (
		"^DCR\\s+" + patternRegister8,
		Pattern.CASE_INSENSITIVE
	);

	public final static Pattern patternINX = Pattern.compile (
		"^INX\\s+" + patternRegister16,
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternDCX = Pattern.compile (
		"^DCX\\s+" + patternRegister16,
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternLXI = Pattern.compile (
		"^LXI\\s+" + patternRegister16 + "\\s*,\\s*(.*)\\s*",
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternPUSH = Pattern.compile (
		"^PUSH\\s+" + patternRegister16PSW,
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternXCHG = Pattern.compile (
		"^XCHG",
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternPCHL = Pattern.compile (
		"^PCHL",
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternXTHL = Pattern.compile (
		"^XTHL",
		Pattern.CASE_INSENSITIVE
	);
	public final static Pattern patternSPHL = Pattern.compile (
		"^SPHL",
		Pattern.CASE_INSENSITIVE
	);

	public ParserPattern() {
		super();
	}

}
