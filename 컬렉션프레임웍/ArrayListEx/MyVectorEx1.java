package 컬렉션프레임웍.ArrayListEx;

public class MyVectorEx1 {
    public static void main(String[] args) {
        MyVector v = new MyVector(2);

        v.add("AAA");
        v.add("BBB");
        v.add("CCC");
        v.add("DDD");
        v.add(2,"EEE");

        Object[] objArr = v.toArray();


        for(int i=0; i < v.size();i++){
            System.out.print(v.get(i)+",");
        }
        System.out.println();

        System.out.println("size : " + v.size());
        System.out.println("capacity: " + v.capacity());
        System.out.println("isEmpty: " + v.isEmpty());
        System.out.println();


        v.remove(1);//BBB를 삭제
        v.remove("CCC");

        System.out.println(v); // System.out.println(v.toString());
        System.out.println("size:"+v.size());
        System.out.println("capacity:"+v.capacity());
        System.out.println("isEmpty:"+v.isEmpty());
        System.out.println();

        v.clear();
        System.out.println(v);
        System.out.println("size:"+v.size());
        System.out.println("capacity:"+v.capacity());
        System.out.println("isEmpty:"+v.isEmpty());
    }
}

