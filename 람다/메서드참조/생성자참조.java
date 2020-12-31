package 람다.메서드참조;

import java.util.function.Function;

/**
 * 람다식을 작성 시 인스턴스 생성 후 이의 탐조 값을 반환하는 경우가 있다. 이 경우 메소드 참조 방식을 쓸 수 있다.
 */
public class 생성자참조 {
    public static void main(String[] args) {
        Function<char[], String> f = arr -> new String(arr);
        Function<Integer,String> l = integer -> integer.toString();
        char[] src = {'R','o','b','o','t'};
        Integer i = 2;
        System.out.println(l.apply(i));
        String newArr = f.apply(src);
        System.out.println(newArr);
    }
}
