/**
 * 
 */
package com.soebes.jacem.parser;

/**
 * @author kama
 *
 */
public interface IParse {

	public String parseLabel (String line);
	public Label asLabel();
	public String getLabel ();
	public void setLabel(String label);
	
	public boolean isValid (String line);
	public IOPCImpl parse (String line);
}
