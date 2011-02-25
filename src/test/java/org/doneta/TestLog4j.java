package org.doneta;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class TestLog4j extends TestCase {

	public static final Logger log = Logger.getLogger(TestLog4j.class);

	public void test() {
		log.info("Test");
		assertTrue(true);
	}
	
}
