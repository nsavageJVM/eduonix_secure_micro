import play.core.server.NettyServer;
import scala.Option;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by ubu on 25.06.15.
 */
public class EntryPoint {

    private NettyServer server;
    private boolean serverRunning = false;


    public EntryPoint(String args[]) {

        System.setProperty("http.port", "9000");

        System.out.println("entry point is go");

        try {

            Option<NettyServer> serverOption = NettyServer.createServer(new File(""));
            server = serverOption.get();
            if (server != null)
                System.out.println("server != null");
                serverRunning = true;
        } catch (Exception e) {
            System.out.println("server !=oops "+e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * Shutdown Netty
     */
    private void shutdownServer() {
        if (server != null)
            server.stop();
        serverRunning = false;
        removePid();

    }

    /**
     * Remove the PID file
     */
    private void removePid(){
        File file = new File("PID");
        if (file.exists()) {
            file.delete();
        }
    }



    public static void main(String args[]) {
        new EntryPoint(args);
    }


}
