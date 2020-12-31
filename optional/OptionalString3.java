package optional;

import java.util.Optional;

public class OptionalString3 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.empty();
        Optional<String> os2 = Optional.of("So Basic");
        Optional<String> os3 = Optional.ofNullable(null);

        String s1 = os1.map(s -> s.toString()).orElse("비었다");
        String s2 = os2.map(s -> s.toString()).orElse("empty");
        String s3 = os3.map(s -> s.toString()).orElse("null");
        System.out.println("s1: " + s1 + ", s2: " + s2 + ", s3: " + s3);
    }
}
