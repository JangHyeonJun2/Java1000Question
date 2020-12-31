package optional;

import java.util.Optional;

public class StringOptional2 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("Optional String");
        System.out.println("적용전: " + os1.get());
        Optional<String> os2 = os1.map(s -> s.toUpperCase());
        System.out.println("적용후: "+os2.get());

        Optional<String> os3 = os2.map(s -> s.toLowerCase()).map(s -> s.replace(' ','_'));
        System.out.println("한번더 적용후: "+os3.get());
    }
}
