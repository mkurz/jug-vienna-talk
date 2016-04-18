package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import javax.inject.Inject;

import akka.actor.ActorSystem;
import play.Logger;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.ExecutionContext;

public class Java8Controller extends Controller {

    public Result index() {
    	/*
    	 * Replaced
    	 * F.Callback0			->		java.lang.Runnable
    	 * F.Callback<A>		->		java.util.function.Consumer<A>
    	 * F.Callback2<A,B>		->		java.util.function.BiConsumer<A,B>
    	 * F.Callback3<A,B,C> 	->		No counterpart in Java 8, consider using akka.japi.function.Function3
    	 * F.Predicate<A>		-> 		java.util.function.Predicate<A>
    	 * F.Function0<A>		->		java.util.function.Supplier<A>
    	 * F.Function1<A,R>		->		java.util.function.Function<A,R>
    	 * F.Function2<A,B,R>	->		java.util.function.BiFunction<A,B,R> 
    	 */
    	
    	/*
    	 * Replaced
    	 * F.Option 			->		java.util.Optional
    	 * F.Option.None()		->		Optional.empty()
    	 * F.Option.Some(v)		->		Optional.ofNullable(v)
    	 * o.isDefined()		->		o.isPresent()
    	 * o.isEmpty()			->		!o.isPresent()
    	 * o.get()				->		o.get()
    	 * o.getOrElse(f)		->		o.orElseGet(f) or o.orElse(v)
    	 * o.map(f)				->		o.map(f)
    	 */
    	
    	/*
    	 * Still here, but deprecated!
    	 * F.Promise			->		java.util.concurrent.CompletionStage
    	 */
    	
    	final String result = doSomething((mystring) -> {
    		return mystring.trim();
    	});
    	
    	return ok(result);
    }
    
    
    private String doSomething(final Function<String, String> block) {
    	return block.apply("      hello!     ");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	@Inject
	HttpExecutionContext ec;
	
	@Inject
	ActorSystem actorSystem;
    
	public CompletionStage<Result> asyncIndex() {
		
		return CompletableFuture.supplyAsync(() -> {
			
			Http.Context.current(); // null!
			
			return ok("Hello world!");
		});
		
		
		
//		}, HttpExecution.defaultContext());
//		}, this.ec.current());

		
		
//		}, HttpExecution.fromThread((ExecutionContext)this.actorSystem.dispatchers().lookup("custom-execution-contexts.expensive-cpu-operations")));
//		}, this.actorSystem.dispatchers().lookup("custom-execution-contexts.expensive-cpu-operations"));
	}
    

    
}
