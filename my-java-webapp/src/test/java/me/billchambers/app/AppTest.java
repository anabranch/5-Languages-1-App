package me.billchambers.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class appTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public appTest(String testName) {

        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {

        return new TestSuite(appTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

        assertTrue(true);
    }
}
