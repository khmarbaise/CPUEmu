package com.soebes.jacem2;

import org.testng.annotations.Test;

public class XTest {

	@Test
	public void testFirst() {
		for(int i = 0; i<256; i++) {
			if (i % 8 == 0) {
				System.out.println();
			}
			System.out.printf("A%02X,\n", i);
		}
	}

	@Test
	public void testSecond() {
		for(int i = 0; i<256; i++) {
			if (i % 8 == 0) {
				System.out.println();
			}
			System.out.printf("opcNOP, //%02X,\n", i);
		}
	}
}
