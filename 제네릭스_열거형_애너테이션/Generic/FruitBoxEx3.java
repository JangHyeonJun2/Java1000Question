package 제네릭스_열거형_애너테이션.Generic;

import java.util.ArrayList;

class Fruit3{
    public String toString(){
        return "Fruit3";
    }
}

class Apple3 extends Fruit3{
    public String toString(){
        return "Apple3";
    }
}

class Grape3 extends Fruit3{
    public String toString(){
        return "Grape3";
    }
}

class Juice {
    String name;
    Juice (String name){
        this.name = name + "Juice";
    }
    public String toString(){
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox3<? extends Fruit3> box3){
        String tmp = "";
        for(Fruit3 f : box3.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}
public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox3<Fruit3> fruit3FruitBox3 = new FruitBox3<>();
        FruitBox3<Apple3> apple3FruitBox3 = new FruitBox3<>();

        fruit3FruitBox3.add(new Apple3());
        fruit3FruitBox3.add(new Grape3());
        apple3FruitBox3.add(new Apple3());
        apple3FruitBox3.add(new Apple3());

        System.out.println(Juicer.makeJuice(fruit3FruitBox3));
        System.out.println(Juicer.makeJuice(apple3FruitBox3));
    }
}

class FruitBox3<T extends Fruit3> extends Box3<T>{}

class Box3<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item){
        list.add(item);
    }

    T get(int i){
        return list.get(i);
    }

    ArrayList<T> getList(){
        return list;
    }

    int size(){
        return list.size();
    }

    public String toString(){
        return list.toString();
    }
}
