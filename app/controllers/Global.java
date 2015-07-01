package controllers;

import org.pac4j.core.client.Clients;
import org.pac4j.oauth.client.FacebookClient;
import org.pac4j.oauth.client.Google2Client;
import org.pac4j.oauth.client.TwitterClient;
import org.pac4j.play.Config;

import play.Application;
import play.GlobalSettings;
import play.Play;



public class Global extends GlobalSettings {


    @Override
    public void onStart(final Application app) {
        Config.setErrorPage401(views.html.error401.render().toString());
        Config.setErrorPage403(views.html.error403.render().toString());
        Config.setSessionTimeout(240);

        final String baseUrl = Play.application().configuration().getString("baseUrl");
        final String fbId = Play.application().configuration().getString("fbId");
        final String fbSecret = Play.application().configuration().getString("fbSecret");

        final FacebookClient facebookClient = new FacebookClient(fbId, fbSecret);

        final TwitterClient twitterClient = new TwitterClient("xxxxxxxxxxxxxxxxxx",
                "xxxxxxxxxxxxxxxxxx");

        Google2Client oidcClient = new Google2Client("xxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxx");
        oidcClient.setScope(Google2Client.Google2Scope.EMAIL);


        final Clients clients = new Clients(baseUrl + "/callback",  facebookClient,  twitterClient,  oidcClient);
        Config.setClients(clients);


    }
}
