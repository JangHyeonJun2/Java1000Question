package 컬렉션프레임웍.HashSetEx;

import java.util.HashSet;

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new Person2("David",10));
        set.add(new Person2("David",10));


        System.out.println(set);
    }
}

class Person2{
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person2){
            Person2 tmp = (Person2)obj;
            return name.equals(tmp.name) && age ==tmp.age;
        }

        return false;
    }
    //밑에코드 걍 외우기
    @Override
    public int hashCode() {
        return (name+age).hashCode();
    }
    public String toString(){
        return name +":"+ age;
    }
}
