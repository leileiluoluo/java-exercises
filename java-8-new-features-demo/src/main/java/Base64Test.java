import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) {
        String text = "java8";
        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        System.out.println(encoded); // amF2YTg=
        byte[] decoded = Base64.getDecoder().decode(encoded);
        System.out.println(new String(decoded)); // java8

        String url = "https://leileiluoluo.com/posts/java-8-new-features.html";
        String urlEncoded = Base64.getUrlEncoder().encodeToString(url.getBytes());
        System.out.println(urlEncoded); // aHR0cHM6Ly9sZWlsZWlsdW9sdW8uY29tL3Bvc3RzL2phdmEtOC1uZXctZmVhdHVyZXMuaHRtbA==
        byte[] urlDecoded = Base64.getUrlDecoder().decode(urlEncoded);
        System.out.println(new String(urlDecoded)); // https://leileiluoluo.com/posts/java-8-new-features.html
    }

}
