package filters;

import javax.inject.Inject;

import play.filters.gzip.GzipFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

public class Filters implements HttpFilters {

	private final GzipFilter gzip;
	private final LoggingFilter logging;

	@Inject
	public Filters(GzipFilter gzip, LoggingFilter logging) {
		this.gzip = gzip;
		this.logging = logging;
	}

	@Override
	public EssentialFilter[] filters() {
		return new EssentialFilter[] { gzip.asJava(), logging.asJava() };
	}	
}