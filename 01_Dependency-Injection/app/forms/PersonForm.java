package forms;

import java.util.Date;

import play.data.validation.Constraints.MaxLength;
import validators.IBAN;

public class PersonForm {

	@MaxLength(value=5)
	private String firstname;
	
	private String lastname;
	
	private Date birthdate;
	
	// E.g. AT02 1180 1444 8414 4484, AT02 1184 1449 4814 4948, AT02 1189 1455 2814 5528
	@IBAN
	private String iban;

	public PersonForm() {
	}
	
	public PersonForm(String firstname, String lastname, Date birthdate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
}