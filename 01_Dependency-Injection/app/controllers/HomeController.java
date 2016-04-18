package controllers;

import javax.inject.Inject;

import composition.DoSomething;
import play.Configuration;
import play.Environment;
import play.Logger;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

//	@Inject
//	private MessagesApi messagesApi;
	
//	@Inject
//	private Environment env;
	
//	@Inject
//	private Configuration config;
	
	// Not static anymore!
    public Result index() {
    	
    	Logger.info("Inside index action");
    	
    	if(play.Play.isDev()) {
    		// do something only for dev mode
    	}
    	
    	// Read config
    	play.Play.application().configuration().getString("mykey");
    	
    	return ok(Messages.get("hello"));
    }

}
