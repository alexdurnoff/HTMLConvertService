package url;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TestUrl {

    @Test
    public void test1() throws URISyntaxException, MalformedURLException {
        String path = "/home/alexej/Документы/Работа/test_url.txt";
        File file = new File(path);
        System.out.println(file.getName());
        URI uri = new URI(path);
        System.out.println(uri);
        URL url = new URL("http", "192.168.1.196", 8080, path);
        System.out.println(url);
        URL url1 = new URL("file", "192.168.1.196", 8080, path);
        System.out.println(url1);
    }
}
