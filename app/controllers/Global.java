package controllers;

import org.pac4j.core.client.Clients;
import org.pac4j.http.client.BasicAuthClient;
import org.pac4j.http.client.FormClient;
import org.pac4j.http.credentials.SimpleTestUsernamePasswordAuthenticator;
import org.pac4j.http.profile.UsernameProfileCreator;
import org.pac4j.oauth.client.Google2Client;
import org.pac4j.oauth.client.TwitterClient;
import org.pac4j.oidc.client.OidcClient;
import org.pac4j.play.Config;

import play.Application;
import play.GlobalSettings;
import play.Play;



public class Global extends GlobalSettings {


    @Override
    public void onStart(final Application app) {
        Config.setErrorPage401(views.html.error401.render().toString());
        Config.setErrorPage403(views.html.error403.render().toString());
        final String baseUrl = Play.application().configuration().getString("baseUrl");

        final TwitterClient twitterClient = new TwitterClient("a4XXQuB33nLXv9ZVyYqmOFEIw",
                "lAJWohkdFcuCwMhC69XcW8nnwSVQgWkdILcue8yl1n0C68PvA6");

        Google2Client oidcClient = new Google2Client("760339641030-r9vlqmov030avl9suok71k2kdi8ivt44.apps.googleusercontent.com", "vfKpbAUnUSheMWBq6Q7qOaYf");
        oidcClient.setScope(Google2Client.Google2Scope.EMAIL);
        // OpenID Connect
//        final OidcClient oidcClient = new OidcClient();
//        oidcClient.setClientID("760339641030-r9vlqmov030avl9suok71k2kdi8ivt44.apps.googleusercontent.com");
//        oidcClient.setSecret("vfKpbAUnUSheMWBq6Q7qOaYf");
//        oidcClient.setDiscoveryURI("https://accounts.google.com/.well-known/openid-configuration");
//        oidcClient.addCustomParam("prompt", "consent");


        final Clients clients = new Clients(baseUrl + "/callback",   twitterClient,  oidcClient);
        Config.setClients(clients);


    }
}
