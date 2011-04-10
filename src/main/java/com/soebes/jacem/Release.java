/*
 * Java CPU Emulator JaCEm (c) 2005 by SoftwareEntwicklung Beratung Schulung SoEBeS 
 */
package com.soebes.jacem;
/**
* Java CPU Emulator (c) 2005 by SoEBeS
*/
public class Release {
	private final byte major = 0;
	private final byte minor = 0;
	private final byte patch = 9;

	public Release () {
	}

	public String toString () {
		return this.major + "." + this.minor + "." + this.patch;
	}

	public byte getMajor() {
		return major;
	}

	public byte getMinor() {
		return minor;
	}

	public byte getPatch() {
		return patch;
	}
}
