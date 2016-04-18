package init;

import java.lang.reflect.Method;
import java.util.concurrent.CompletionStage;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class ActionCreator implements play.http.ActionCreator {

	@Override
	@SuppressWarnings("rawtypes")
	public Action createAction(Http.Request request, Method actionMethod) {
		return new Action.Simple() {
			
			
			@Override
			public CompletionStage<Result> call(Http.Context ctx) {
				
				Logger.info("createAction");
				
				// Put something in ctx.args
				
				return this.delegate.call(ctx).whenComplete((result, error) -> {
					Logger.info("Action completed");
				});
			}
		};
	}
}