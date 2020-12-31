package 컬렉션프레임웍.HashMapEx;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("kimjava",new Integer(90));
        map.put("kimjava",new Integer(100));
        map.put("leejava",new Integer(100));
        map.put("kangjava",new Integer(80));
        map.put("anjava",new Integer(90));


        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            Map.Entry e = (Map.Entry)iterator.next();
            System.out.println("이름: "+e.getKey() +", 점수: "+e.getValue());
        }

        set = map.keySet();
        System.out.println("참가자 명단: " +set);
        Collection values = map.values();
        iterator = values.iterator();

        int total = 0;

        while(iterator.hasNext()){
            Integer i = (Integer)iterator.next();
            total += i.intValue();
        }

        System.out.println("totalScore= " +total);
        System.out.println("average= " +(float)total/set.size());
        System.out.println("numberOneScore= "+Collections.max(values));
        System.out.println("lowerestScore= "+Collections.min(values));
    }
}
