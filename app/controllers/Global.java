package controllers;

import org.pac4j.core.client.Clients;
import org.pac4j.http.credentials.SimpleTestUsernamePasswordAuthenticator;
import org.pac4j.http.profile.UsernameProfileCreator;
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

        final TwitterClient twitterClient = new TwitterClient("HVSQGAw2XmiwcKOTvZFbQ",
                "FSiO9G9VRR4KCuksky0kgGuo8gAVndYymr4Nl7qc8AA");


        // OpenID Connect
        final OidcClient oidcClient = new OidcClient();
        oidcClient.setClientID("343992089165-i1es0qvej18asl33mvlbeq750i3ko32k.apps.googleusercontent.com");
        oidcClient.setSecret("unXK_RSCbCXLTic2JACTiAo9");
        oidcClient.setDiscoveryURI("https://accounts.google.com/.well-known/openid-configuration");
        oidcClient.addCustomParam("prompt", "consent");

        final Clients clients = new Clients(baseUrl + "/callback",  twitterClient, oidcClient);
        Config.setClients(clients);

    }
}
