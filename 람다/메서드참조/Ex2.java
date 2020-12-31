package 람다.메서드참조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,3,5,7,9);
        ls = new ArrayList<>(ls);
        JustSort js = new JustSort(); //js is effectively final

        Consumer<List<Integer>> c = e -> js.sort(e);
        c.accept(ls);
        System.out.println(ls);
    }
}

class JustSort {
    public void sort(List<?> lst) {
        Collections.reverse(lst);
    }
}
