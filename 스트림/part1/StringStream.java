package 스트림;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream {
    public static void main(String[] args) {
        String[] names = {"Yoon","Jang","Hyeon"};
        Stream<String> stm = Arrays.stream(names); //스트림 생성
        stm.forEach(s -> System.out.print(s + ", ")); //최종 연산 진행
    }
}
