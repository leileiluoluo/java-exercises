import java.util.stream.Collectors;

public class StringAPIEnhancementsTest {

    public static void main(String[] args) {
        // isBlank() 使用：换行符、制表符、半角空格、全角空格等都会被认为是空字符
        System.out.println(" \n\t ".isBlank());

        // lines() 使用：会将字符串以 \n 或 \r\n 分割为一个 Stream
        System.out.println("Hello\nWorld!".lines()
                .collect(Collectors.joining(", "))); // Hello, World!

        // strip() 使用：首尾的换行符、制表符、半角空格、全角空格等都会被处理掉
        System.out.println("　\n\t\n\r   你好，世界！　".strip()); // "你好世界"

        // stripLeading() 使用：头部的换行符、制表符、半角空格、全角空格等都会被处理掉
        System.out.println("　\n\t\n\r   你好，世界！　".stripLeading()); // "你好，世界！　"

        // stripTrailing() 使用：尾部的换行符、制表符、半角空格、全角空格等都会被处理掉
        System.out.println("　\n\t\n\r   你好，世界！　".stripTrailing()); // "　\n\t\n\r   你好，世界！"

        // repeat() 使用：将一个字符串重复两次
        System.out.println("Hello World!".repeat(2)); // Hello World!Hello World!
    }

}
