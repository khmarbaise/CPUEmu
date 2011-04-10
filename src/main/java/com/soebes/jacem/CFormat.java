/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem;

import java.text.DecimalFormat;

/**
 * This class has been created to have a OO like
 * format interface. I can't extend it from Long
 * cause Long is final.
 * 
 * @author Karl Heinz Marbaise
 *
 */
public class CFormat {


	public CFormat () {
	}

	public static String toHex16 (int value) {
		return Format (value, 16, 4, '0');
	}

	public static String toHex8 (int value) {
		return Format (value, 16, 2, '0');
	}

	public static String toString4Digit (int value) {
		return Format (value, 10, 4, ' ');
	}
	public static String toString2Digit (int value) {
		return Format (value, 10, 2, ' ');
	}

	/**
	 * This will fill a StringBuffer based on the given fieldWidth
	 * with the particular number of characters.
	 * @param fieldWidth
	 * @return StringBuffer filled with the number of padding characters.
	 */
	private static StringBuffer fillPadding (int fieldWidth, char fc) {
		StringBuffer sb = new StringBuffer();
		sb.setLength(fieldWidth);
		// Fill it with the padding character
		for (int i = 0; i < fieldWidth; i++) {
			sb.setCharAt(i, fc);
		}
		return sb;
	}

	/**
	 * This method will format a long value into a given field of the given
	 * width with right alignment.
	 * 
	 * @param long
	 *            val The value which will be formated for output
	 * @param int
	 *            fw Field width
	 */
	public static String Format(int val, int base, int fw, char fc) {
		StringBuffer sb = fillPadding (fw, fc);
		String sval = Integer.toString (val, base).toUpperCase();
		// -1 cause the length will give back the real length
		// but we access zero based
		for (int k = 0, i = sval.length() - 1; i >= 0; i--, k++) {
			sb.setCharAt(fw - i - 1, sval.charAt(k));
		}
		return sb.toString();
	}

	public static String FormatEng (double val) {
		//DecimalFormat form = new DecimalFormat ("##0.##E0"); 
		DecimalFormat form = new DecimalFormat ("##0.00E0"); 
		return form.format(val);
	}
}
