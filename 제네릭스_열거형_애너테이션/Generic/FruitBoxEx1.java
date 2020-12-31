package 제네릭스_열거형_애너테이션.Generic;

import java.util.ArrayList;

class Fruit{
    public String toString(){
        return "Fruit";
    }
}

class Apple extends Fruit{
    public String toString(){
        return "Apple";
    }
}

class Grape extends Fruit{
    public String toString(){
        return "Grape";
    }
}
class Toy{
    public String toString(){
        return "Toy";
    }
}

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<Toy>();
        // Box<Grape> grapeBox = new Box<Apple>(); 에러. 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); //OK. void add(Fruit item)

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        // appleBox.add(new Toy()); Error. Box<Apple>에는 apple만 담을 수 있음.
        toyBox.add(new Toy());
        // toyBox.add(new Apple()); Error. Box<Toy>에는 Apple을 담을 수 없다.

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item){
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }

    int size(){
        return list.size();
    }

    public String toString(){
        return list.toString();
    }
}
