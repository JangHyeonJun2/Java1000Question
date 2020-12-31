package 람다.메서드참조;

import java.util.Arrays;
import java.util.List;

public class ForEachEx3 {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        ls.forEach(s -> System.out.println("람다식 기반" + s));
        ls.forEach(System.out::println);
    }
}
