package 람다;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExRemoveIf {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,-2,3,-4);
        list1 = new ArrayList<>(list1);

        List<Double> list2 = Arrays.asList(-1.1,2.2,-3.3,4.4);
        list2 = new ArrayList<>(list2);

        //여기서 Number가 중요하다! Number를 안쓰면 Predicate<Integer>, Predicate<Double> 두개를 만들어야하는데 Number를 쓰므로써 하나의 코드만 작성하면 된다.
        Predicate<Number> p = n -> n.doubleValue() < 0.0; //삭제의 조건
        list1.removeIf(p); //List<Integer> 인스턴스에 전달
        list2.removeIf(p); //List<Double> 인스턴스에 전달

        System.out.println(list1);
        System.out.println(list2);
    }
}
