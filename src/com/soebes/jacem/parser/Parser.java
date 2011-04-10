/**
 * 
 */
package com.soebes.jacem.parser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Karl Heinz Marbaise
 *
 */
public class Parser {

	private ArrayList parser;
	
	private ArrayList labels;

	private ArrayList opcs;

	private int pc;

	/**
	 * 
	 */
	public Parser() {
		super();
		this.parser = new ArrayList ();
		this.opcs = new ArrayList ();
		this.labels = new ArrayList ();
		this.pc = 0;

		this.addParser (new ParseMVI());
		this.addParser (new ParseMOV());
		this.addParser (new ParseINR());
		this.addParser (new ParseDCR());
		this.addParser (new ParseINX());
		this.addParser (new ParseDCX());
		this.addParser (new ParseLXI());
		this.addParser (new ParsePUSH());
		this.addParser (new ParsePCHL());
		this.addParser (new ParseSPHL());
		this.addParser (new ParseXCHG());
		this.addParser (new ParseXTHL());
	}

	public void addOPC (IOPCImpl opc) {
		this.opcs.add(opc);
	}

	public void addParser (IParseImpl el) {
		this.parser.add(el);
	}

	public void addLabel (Label l) {
		this.labels.add (l);
	}

	public ArrayList getLabels () {
		return this.labels;
	}

	public ArrayList getOPCS () {
		return this.opcs;
	}

	public void parse (String line) {
		for (Iterator it=parser.iterator(); it.hasNext(); ) {
	        IParseImpl pars = (IParseImpl)it.next();
	        // first step to parse label of the line
	        if (pars.hasLabel(line)) {
	        	line = pars.parseLabel(line);
	        	Label lab = pars.asLabel ();
	        	lab.setValue(this.pc);
	        	this.addLabel(lab);
	        }
	        if (pars.isValid(line)) {
	        	IOPCImpl ti = pars.parse(line);
	        	if (!this.opcs.contains(ti)) {
	        		this.addOPC (ti);
	        		this.pc += ti.getSize();
	        	}
	        }
	    }
	}

}
