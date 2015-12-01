package controllers;

import play.*;
import play.mvc.*;
import common.Global;

import views.html.*;

public class Test extends Controller {

    public Result index() {
        Logger.info("Current Domain:" + Global._DOMAIN);
        return ok(index.render("Your new application is ready.!!!!!!! - " + Global._DOMAIN));
    }
    public Result main() {
        return ok("Binh test");
    }

}
