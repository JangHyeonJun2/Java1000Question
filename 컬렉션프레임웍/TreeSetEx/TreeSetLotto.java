package 컬렉션프레임웍.TreeSetEx;

import java.util.Set;
import java.util.TreeSet;
/*
 * HashSetLotto.java를 TreeSet을 사용해서 바꾸었다. 이전 예제와는 달리 정렬하는 코드가 빠져 있다. 이유는 TreeSet은 저장할 때 이미 정렬하기 때문에 읽어올 때 따로 정렬할 필요가 없기 때문이다.
 */
public class TreeSetLotto {
    public static void main(String[] args) {
        Set set = new TreeSet();

        for (int i = 0; set.size() < 6; i++){ // Set의 특징에 따라 중복된 값은 허용이 안되기 때문에 범위를 set.size() < 6으로 한다.
            int num = (int)(Math.random()*45)+1;
            set.add(num); // set.add(new Integer(num)) auto boxing
        }
        System.out.println(set);
    }

}
