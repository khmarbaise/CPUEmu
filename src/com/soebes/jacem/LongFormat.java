/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem;
/**
 * This class has been created to have a OO like
 * format interface. I can't extend it from Long
 * cause Long is final.
 * 
 * @author Karl Heinz Marbaise
 *
 */
public class LongFormat {


	/**
	 * I have to save the given object
	 * here cause we can't extend from Long
	 */
	private Long longObject;
	
	/**
	 * The char which will be used to pad the output 
	 * string on the left side.
	 */
	private char paddingLeftChar;

	/**
	 * The size of the field to which allways will be padded to.
	 */
	private int fieldWidth;


	/**
	 * @return give back the fieldWidth.
	 */
	public int getFieldWidth() {
		return fieldWidth;
	}

	/**
	 * @return Returns the character which is used to padd left.
	 */
	public char getPaddingLeftChar() {
		return paddingLeftChar;
	}

	/**
	 * @return Returns the longObject.
	 */
	public Long getLongObject() {
		return longObject;
	}
	/**
	 * @param longObject The longObject to set.
	 */
	public void setLongObject(Long longObject) {
		this.longObject = longObject;
	}

	/**
	 * @param fieldWidth The fieldWidth to set.
	 */
	public void setFieldWidth(int fieldWidth) {
		this.fieldWidth = fieldWidth;
	}

	/**
	 * @param paddingLeftChar The paddingLeftChar to set.
	 */
	public void setPaddingLeftChar(char paddingLeftChar) {
		this.paddingLeftChar = paddingLeftChar;
	}

	/**
	 * The default constructor
	 */
	public LongFormat() {
		this.init();
	}

	/**
	 * @param longObject
	 */
	public LongFormat (Long longObject) {
		this.init ();
		this.longObject = longObject;
	}

	/**
	 * @param fieldWidth
	 */
	public LongFormat(int fieldWidth) {
		this.init();
		this.fieldWidth = fieldWidth;
	}

	/**
	 * @param longVal
	 */
	public LongFormat (long longVal) {
		this.init ();
		this.longObject = new Long (longVal);
	}

	/**
	 * @param paddingLeftChar
	 * @param fieldWidth
	 */
	public LongFormat(char paddingLeftChar, int fieldWidth) {
		this.init();
		this.paddingLeftChar = paddingLeftChar;
		this.fieldWidth = fieldWidth;
	}


	/**
	 * 
	 */
	private void init() {
		// default padding character space
		this.paddingLeftChar = ' ';
		this.fieldWidth = 0;
		this.longObject = null;
	}


	/**
	 * return the formated string.
	 * @return	String	The formatted string (left padded to fieldWidth)
	 */
	public String toString () {
		// this should be.
		// this.formatLong (this.longObject);
		return new String ();
	}


	/**
	 * This will fill a StringBuffer based on the given fieldWidth
	 * with the particular number of characters.
	 * @param fieldWidth
	 * @return StringBuffer filled with the number of padding characters.
	 */
	private StringBuffer fillPadding (int fieldWidth) {
		StringBuffer sb = new StringBuffer();
		sb.setLength(fieldWidth);
		// Fill it with the padding character
		for (int i = 0; i < fieldWidth; i++) {
			sb.setCharAt(i, this.paddingLeftChar);
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
	public String Format(long val, int fw) {
		StringBuffer sb = this.fillPadding (fw);
		String sval = new Long(val).toString();
		// -1 cause the length will give back the real length
		// but we access zero based
		for (int k = 0, i = sval.length() - 1; i >= 0; i--, k++) {
			sb.setCharAt(fw - i - 1, sval.charAt(k));
		}
		return sb.toString();
	}

}
