package 컬렉션프레임웍.ArrayListEx;

import java.util.ArrayList;
import java.util.Collections;



public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1,list2);
        System.out.println();

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1,list2);

        System.out.println("list1.containsAll(list2): " + list1.contains(list2));
        System.out.println();

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1,list2);

        list2.set(3,"AA");
        print(list1,list2);
        System.out.println();

        //list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2): " +list1.retainAll(list2));
        print(list1,list2);

        //list2에서 list1에 포함된 객체들을 삭제한다.
        for(int i = list2.size() - 1; i >= 0; i--){
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }
        /*
         * 밑에 코드가 안되는 이유는 i는 코드를 한번 돌때마다 증가하는데 이때 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동을 하기 때문에 올바른 결과x
         */
//        System.out.println("list2.size: " + list2.size());
//        for(int i = 0; i < list2.size(); i++){
//            if(list1.contains(list2.get(i)))
//                list2.remove(i);
//        }
        print(list1,list2);
    }
    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
    }
}
