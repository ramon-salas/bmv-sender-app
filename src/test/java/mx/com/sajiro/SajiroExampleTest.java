/**
 * 
 */
package mx.com.sajiro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class SajiroExampleTest {

	@Test
	void test() {
		final String textToExample = "text";
		assertEquals("TEXT",
				new SajiroExample().transformText(text -> text.toUpperCase(), textToExample));
	}

}
