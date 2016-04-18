package composition;

import java.util.concurrent.CompletionStage;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;

public class DoSomethingAction extends Action<DoSomething> {

	@Override
	public CompletionStage<Result> call(Context ctx) {
		
		Logger.info(this.configuration.value());
		
//		ctx.args.put("admin", true);
		
		return this.delegate.call(ctx);
	}
	

}