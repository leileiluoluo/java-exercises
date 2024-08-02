import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesTest {

    public static void testJava7ReadFileWithMultipleResources() throws IOException {
        String filePath = TryWithResourcesTest.class.getResource("test.txt").getPath();

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            System.out.println(br.readLine());
        }
    }

    public static void testJava9ReadFileWithMultipleResources() throws IOException {
        String filePath = TryWithResourcesTest.class.getResource("test.txt").getPath();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        try (fr; br) {
            System.out.println(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        // java 7
        testJava7ReadFileWithMultipleResources();

        // java 9
        testJava9ReadFileWithMultipleResources();
    }

}
