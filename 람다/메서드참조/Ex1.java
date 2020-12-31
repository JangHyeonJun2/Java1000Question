package 람다.메서드참조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * static 메소드의 참조: 람다식 기반 예제
 * Collections 클래스의 reverse 메소드 기반 예제
 */
public class Ex1 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,3,5,7,9);
        ls = new ArrayList<>(ls);

        Consumer<List<Integer>> c =
                //람다식
//                l -> Collections.reverse(l);
                Collections::reverse; //메서드 참조식
        c.accept(ls);
        System.out.println(ls);
    }
}
