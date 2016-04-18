package controllers;

import java.util.Date;

import javax.inject.Inject;

import forms.PersonForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.myform;

public class FormController extends Controller {

	
    public Result showForm() {
    	final Form<PersonForm> form = Form.form(PersonForm.class).fill(new PersonForm("Chuck", "Norris", new Date()));
    	return ok(myform.render(form));
    }

    public Result saveForm() {
    	final Form<PersonForm> form = Form.form(PersonForm.class).bindFromRequest();

    	if(form.hasErrors()) {
    		return badRequest(myform.render(form));
    	}
    	
//    	final PersonForm person = form.get();
    	
    	return ok(myform.render(form));
    }
    
}
