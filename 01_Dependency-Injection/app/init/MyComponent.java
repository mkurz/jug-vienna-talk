package init;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import play.Logger;
import play.inject.ApplicationLifecycle;

public class MyComponent {

	@Inject
	public MyComponent(ApplicationLifecycle appLifecycle) {
		Logger.info("I started up!");
		
		appLifecycle.addStopHook(() -> {
			Logger.info("I shut down!");
			return CompletableFuture.completedFuture(null);
		});
	}
	
}
