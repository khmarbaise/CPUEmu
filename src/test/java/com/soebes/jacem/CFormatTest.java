package com.soebes.jacem;

import junit.framework.TestCase;

public class CFormatTest extends TestCase {

    public CFormatTest(String arg0) {
        super(arg0);
    }

    public void testToHex16a() {
        int i = 1000;
        String t = CFormat.toHex16(i);
        assertEquals ("03E8", t);
    }
    public void testToHex16b() {
        int i = 240;
        String t = CFormat.toHex16(i);
        assertEquals ("00F0", t);
    }
    public void testToHex16c() {
        int i = 65535;
        String t = CFormat.toHex16(i);
        assertEquals ("FFFF", t);
    }

    public void testToHex16fail() {
        int i = 65536;
        try {
            String t = CFormat.toHex16(i);
            fail ("We didn't get an expected Exception!");
        } catch (Exception e) {
            //e.printStackTrace();
            // intentialy left blank everything went well!
        }
    }

    public void testToHex8V1() {
        int i = 255;
        String t = CFormat.toHex8(i);
        assertEquals ("FF", t);
    }
    public void testToHex8V2() {
        int i = 12;
        String t = CFormat.toHex8(i);
        assertEquals ("0C", t);
    }

    public void testToString2Digit1() {
        int i = 12;
        String t = CFormat.toString2Digit(i);
        assertEquals("12", t);
    }
    public void testToString2Digit2() {
        int i = 2;
        String t = CFormat.toString2Digit(i);
        assertEquals(" 2", t);
    }

    public void testToString2Digit3() {
        int i = 234;
        try {
            String t = CFormat.toString2Digit(i);
            fail ("We don't got an expected Exception!");
        } catch (Exception e) {
            // intentially left blank!
        }
    }

    public void testToString4Digit1() {
        int i = 2;
        String t = CFormat.toString4Digit(i);
        assertEquals("   2", t);
    }

    public void testFormatEng1() {
        double t = 3.759765625E-5;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("37,598E-6", tmp);
    }
    public void testFormatEng2() {
        double t = 12.345E-5;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("123,45E-6", tmp);
    }
    public void testFormatEng3() {
        double t = 0.1E-02;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("1,00E-3", tmp);
    }
    public void testFormatEng4() {
        double t = 0.1E-01;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("10,0E-3", tmp);
    }
    public void testFormatEng5() {
        double t = 0.1;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("100E-3", tmp);
    }

    public void testFormatEng6() {
        double t = 1E-4;
        String tmp = CFormat.FormatEng(t);
        assertEquals ("100E-6", tmp);
    }

}
