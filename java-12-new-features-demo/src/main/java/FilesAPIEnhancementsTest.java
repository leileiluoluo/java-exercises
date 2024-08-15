import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAPIEnhancementsTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource1 = FilesAPIEnhancementsTest.class.getResource("test1.txt");
        URL resource2 = FilesAPIEnhancementsTest.class.getResource("test2.txt");

        Path path1 = Paths.get(resource1.toURI());
        Path path2 = Paths.get(resource2.toURI());
        System.out.println(Files.mismatch(path1, path2));
    }

}
