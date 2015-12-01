package common;

import static play.data.Form.*;
import play.*;
import play.mvc.*;
import views.html.*;

public class Global extends GlobalSettings {

    // Relative URLs of Domain
    public static String _DOMAIN = "www";
    public static int _AFFILIATE = 6; // WNOW client site
    public static int _HTTP_PORT = 80; // default
    
    @Override
    public void beforeStart(Application application) {
        super.beforeStart(application);
    }

    @Override
    public void onStart(Application application) {
        Logger.info("Application is started!!!");
        super.onStart(application);
    }

    @Override
    public void onStop(Application application) {
        Logger.error("good bye!");
        super.onStop(application);
    }
    
}   
