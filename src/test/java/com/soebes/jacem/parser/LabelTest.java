package com.soebes.jacem.parser;

import com.soebes.jacem.parser.Label;

import junit.framework.TestCase;

public class LabelTest extends TestCase {

    private Label label;

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.label = new Label ("TestLabel", 200);
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        this.label = null;
    }

    public void testNotNull () {
        assertNotNull(this.label);
    }

    public void testName () {
        String expected = "Das Ist EinTest";
        this.label.setName(expected);
        assertEquals(expected, this.label.getName());
    }

    public void testValue () {
        int expected = 24678;
        this.label.setValue(expected);
        assertEquals(expected, this.label.getValue());
    }
}
