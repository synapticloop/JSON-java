package org.json;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CookieTest {
	@BeforeClass
	public static void beforeClass() {
		Cookie cookie = new Cookie();
	}

	@Test
	public void testEscape() {
		// trimming all of the spaces
		assertEquals("", Cookie.escape(" \t\n\r    "));

		assertEquals("this%09is a tab", Cookie.escape("this\tis a tab"));

		assertEquals("this is a valid cookie name?", Cookie.escape("this is a valid cookie name?"));

		assertEquals("%2b", Cookie.escape("+"));
		assertEquals("%25", Cookie.escape("%"));
		assertEquals("%3d", Cookie.escape("="));
		assertEquals("%3b", Cookie.escape(";"));
	}

	@Test
	public void testUnescape() {
		assertEquals("this\tis a tab", Cookie.unescape("this%09is a tab"));

		assertEquals("this is a valid cookie name?", Cookie.unescape("this+is+a+valid+cookie+name?"));

		assertEquals("+", Cookie.unescape("%2b"));
		assertEquals("%", Cookie.unescape("%25"));
		assertEquals("=", Cookie.unescape("%3d"));
		assertEquals(";", Cookie.unescape("%3b"));
	}
}
