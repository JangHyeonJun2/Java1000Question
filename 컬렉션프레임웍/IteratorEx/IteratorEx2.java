package 컬렉션프레임웍.IteratorEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorEx2 {
    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("원숭이" ,"바나나");
        map.put("뉴턴","사과");
        map.put("카카오","초콜릿");
        map.put(1,"jang");

        //Solution1: entrySet()
        for (Map.Entry<Object,Object> entry : map.entrySet()) {
            System.out.println("[key]: "+ entry.getKey() + ", [value]: "+entry.getValue());
        }
        System.out.println();

        //Solution2: KeySet()
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            System.out.println("[key]:"+key+", [value]:"+value);
        }
        System.out.println();

        //Solution3: entrySet().iterator()
        Iterator<Map.Entry<Object,Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object,Object> entry = iterator.next();
            System.out.println("[key]: "+ entry.getKey() + ", [value]: "+entry.getValue());
        }
        System.out.println();

        //Solution4: KeySet().iterator()
        Iterator<Object> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            Object key = iterator1.next();
            Object value = map.get(key);
            System.out.println("[key]:"+key+", [value]:"+value);
        }
    }
}
