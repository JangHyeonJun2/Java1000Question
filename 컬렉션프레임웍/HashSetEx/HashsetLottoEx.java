package 컬렉션프레임웍.HashSetEx;

import java.util.*;

public class HashsetLottoEx {
    public static void main(String[] args) {
        Set set = new HashSet();

        for(int i=0; set.size() < 6; i++){
            int num = (int)(Math.random()*45)+1;
            set.add(num);
        }




        System.out.println(set.getClass());
        List list = new LinkedList(set);

        System.out.println(list);
    }

}
