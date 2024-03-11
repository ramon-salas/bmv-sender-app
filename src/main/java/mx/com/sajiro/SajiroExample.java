package mx.com.sajiro;

import java.util.function.Function;

public class SajiroExample {
	
	public String transformText(final Function<String, String> transformer, final String text) {
		return transformer.apply(text);
	}
	
}
