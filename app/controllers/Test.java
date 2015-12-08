package controllers;

import play.*;
import play.mvc.*;
import common.Global;

import views.html.*;

public class Test extends Controller {

    public Result test() {
        return ok("test basic");
    }
    public Result test2(String name) {
        return ok(name);
    }
    public Result test3() {
        return redirect("/test");
    }
    public Result test4(String page) {
        return ok(page);
    }
}
