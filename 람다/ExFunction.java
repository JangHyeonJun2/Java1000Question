package 람다;

import java.util.function.Function;

public class ExFunction {
    public static void main(String[] args) {
        Function<String,Integer> f = s -> s.length();
        System.out.println(f.apply("PineApple"));
        System.out.println(f.apply("abcdefghijklmnop"));
    }
}
