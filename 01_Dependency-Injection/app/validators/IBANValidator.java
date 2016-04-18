package validators;

import javax.validation.ConstraintValidator;

import org.iban4j.IbanFormatException;
import org.iban4j.IbanUtil;
import org.iban4j.InvalidCheckDigitException;
import org.iban4j.UnsupportedCountryException;

import play.data.validation.Constraints.Validator;
import play.libs.F;

public class IBANValidator extends Validator<Object> implements ConstraintValidator<IBAN, Object> {

	/**
	 * Default error message
	 */
	public static final String MESSAGE = "error.iban";

	/**
	 * Validator init can be used to initialize the validation based on parameters passed to the annotation.
	 */
	@Override
	public void initialize(final IBAN constraintAnnotation) {
	}

	/**
	 * The validation itself
	 */
	@Override
	public boolean isValid(final Object object) {
		if(object == null) {
			return true;
		}

		if(!(object instanceof String)) {
			return false;
		}
		
		final String value = ((String)object).trim().replace(" ", "");
		
		if(value.length() == 0) {
			return true;
		}
		
		try {
			IbanUtil.validate(value);
		} catch (IbanFormatException | InvalidCheckDigitException | UnsupportedCountryException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public F.Tuple<String, Object[]> getErrorMessageKey() {
		return F.Tuple(MESSAGE, new Object[] {});
	}
}