package controllers;

import java.io.File;

import play.mvc.Controller;
import play.mvc.RangeResults;
import play.mvc.Result;
import views.html.*;

public class VideoController extends Controller {

    public Result video() {
    	return ok(video.render());
    }

    /*
     * Request Header:
     * Range: bytes=82784410-
     * 
     * Response Header:
     * Content-Range:bytes 82784410-131600468/131600469
     * 
     * Stop/continue downloads, HTML5 video, etc.
     */
    public Result videoData() {
    	return RangeResults.ofFile(new File("/home/mkurz/work/jug-talk/video.mp4"));
    }
    
}
