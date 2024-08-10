import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAPIEnhancementsTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // readString() 使用
        URL resource = FilesAPIEnhancementsTest.class.getResource("test.txt");
        Path path = Paths.get(resource.toURI());
        System.out.println(Files.readString(path, StandardCharsets.UTF_8)); // Hello, World!

        // writeString() 使用
        Files.writeString(path, "你好，世界！", StandardCharsets.UTF_8);
    }

}
