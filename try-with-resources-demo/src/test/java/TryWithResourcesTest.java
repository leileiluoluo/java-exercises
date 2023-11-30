import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesTest {

    @Test
    public void testJava6ReadFileWithFinallyBlock() throws IOException {
        String filePath = this.getClass().getResource("test.txt").getPath();

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            System.out.println(br.readLine());
        } finally {
            if (null != fr) {
                fr.close();
            }
            if (null != br) {
                br.close();
            }
        }
    }

    @Test
    public void testJava7ReadFileWithSingleResource() throws IOException {
        String filePath = this.getClass().getResource("test.txt").getPath();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println(br.readLine());
        }
    }

    @Test
    public void testJava7ReadFileWithMultipleResources() throws IOException {
        String filePath = this.getClass().getResource("test.txt").getPath();

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            System.out.println(br.readLine());
        }
    }

    @Test
    public void testJava9ReadFileWithMultipleResources() throws IOException {
        String filePath = this.getClass().getResource("test.txt").getPath();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        try (fr; br) {
            System.out.println(br.readLine());
        }
    }

}
