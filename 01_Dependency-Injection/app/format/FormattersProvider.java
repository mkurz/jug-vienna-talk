package format;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import play.data.format.Formatters;
import play.i18n.MessagesApi;

/**
 * Defines several custom formatters.
 */
@Singleton
public class FormattersProvider implements Provider<Formatters> {

	private final MessagesApi messagesApi;

	@Inject
	public FormattersProvider(final MessagesApi messagesApi) {
		this.messagesApi = messagesApi;
	}

	@Override
	public Formatters get() {
		return new Formatters(this.messagesApi)
				.register(String.class, new AnnotationCustomFormatFormatter());
	}
		
	
	

	// -- A custom formatter:
	
	/**
	 * Defines the format for a Url field.
	 */
	@Target({FIELD})
	@Retention(RUNTIME)
	public static @interface CustomFormat {
	}
	
	/**
	 * Annotation formatter, triggered by the <code>@Url</code> annotation.
	 */
	public static class AnnotationCustomFormatFormatter extends Formatters.AnnotationFormatter<CustomFormat, String> {
		
//		@Inject
//		private MessagesApi ma;
		
		/**
		 * Binds the field - constructs a concrete value from submitted data.
		 *
		 * @param annotation the annotation that trigerred this formatter
		 * @param text the field text
		 * @param locale the current <code>Locale</code>
		 * @return a new value
		 */
		@Override
		public String parse(final CustomFormat annotation, String text, final Locale locale) throws java.text.ParseException {
			if(text == null || text.trim().isEmpty()) {
				return null;
			}
			// modify value...
			return text;
		}
		
		/**
		 * Unbinds this field - converts a concrete value to plain string
		 *
		 * @param annotation the annotation that trigerred this formatter
		 * @param value the value to unbind
		 * @param locale the current <code>Locale</code>
		 * @return printable version of the value
		 */
		@Override
		public String print(final CustomFormat annotation, final String value, final Locale locale) {
			if(value == null) {
				return "";
			}
			// modify value...
			return value.trim();
		}
		
	}
}