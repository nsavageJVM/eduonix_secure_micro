
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import play.core.server.NettyServer;

/**
 * Created by ubu on 25.06.15.
 */
public class EntryPoint {



    public EntryPoint(String args[]) {

        System.setProperty("http.port", "9001");

        System.out.println("entry point is go");



    }


    public static void main(String args[]) {
        new EntryPoint(args);
    }



}
