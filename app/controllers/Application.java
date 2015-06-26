package controllers;

import play.mvc.Result;
import org.pac4j.play.java.JavaController;

import model.JsonContent;

import org.pac4j.core.exception.TechnicalException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.play.Config;
import org.pac4j.play.java.JavaController;
import org.pac4j.play.java.RequiresAuthentication;

/**
 * Created by ubu on 26.06.15.
 */
public class Application extends JavaController {


    public static Result index() throws TechnicalException {
        // profile (maybe null if not authenticated)
        final CommonProfile profile = getUserProfile();

        final String urlTwitter = getRedirectAction("TwitterClient", "/?1").getLocation();

        final String urlOidc = getRedirectAction("OidcClient", "/?5").getLocation();

        return ok(views.html.index.render(profile, urlTwitter, urlOidc));
    }



    private static Result protectedIndex() {
        // profile
        final CommonProfile profile = getUserProfile();
        return ok(views.html.protectedIndex.render(profile));
    }

    @RequiresAuthentication(clientName = "TwitterClient")
    public static Result twitterIndex() {
        return protectedIndex();
    }


    @RequiresAuthentication(clientName = "OidcClient")
    public static Result oidcIndex() {
        return protectedIndex();
    }

}
