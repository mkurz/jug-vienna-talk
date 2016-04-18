import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings {

	@Override
	public void onStart(final play.Application app) {
		Logger.info("onStart");
	}
	
	@Override
	public void onStop(final play.Application app) {
		Logger.info("onStop");
	}
}