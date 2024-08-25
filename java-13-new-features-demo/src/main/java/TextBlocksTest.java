public class TextBlocksTest {

    public static void main(String[] args) {
        // Java 13 之前，多行字符串的表示
        String text = "Goals of Text Blocks\n" +
                "Simplify the task of writing Java programs by making it easy to express strings that span several lines of source code, while avoiding escape sequences in common cases.\n" +
                "Enhance the readability of strings in Java programs that denote code written in non-Java languages.\n" +
                "Support migration from string literals by stipulating that any new construct can express the same set of strings as a string literal, and interpret the same escape sequences, and be manipulated like a string literal.";

        // Java 13，引入文本块后，多行字符串的表示
        String text1 = """
                Goals of Text Blocks
                Simplify the task of writing Java programs by making it easy to express strings that span several lines of source code, while avoiding escape sequences in common cases.
                Enhance the readability of strings in Java programs that denote code written in non-Java languages.
                Support migration from string literals by stipulating that any new construct can express the same set of strings as a string literal, and interpret the same escape sequences, and be manipulated like a string literal.
                """;
    }
}