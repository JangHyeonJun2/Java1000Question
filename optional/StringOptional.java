package optional;

import java.util.Optional;

public class StringOptional {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1")); //of는 null을 허용하지 않는다.
        Optional<String> os2 = Optional.of(new String()); // ofNullable은 null허용

        os1.ifPresent(s -> System.out.println(s + "입니다."));
        os2.ifPresent(System.out::println);
    }
}
