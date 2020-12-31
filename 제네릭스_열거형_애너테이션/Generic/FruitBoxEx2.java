package 제네릭스_열거형_애너테이션.Generic;

import java.util.ArrayList;

class Fruit2 implements Eatable{
    public String toString(){
        return "Fruit";
    }
}

class Apple2 extends Fruit2{
    public String toString(){
        return "Apple";
    }
}

class Grape2 extends Fruit2{
    public String toString(){
        return "Grape";
    }
}
class Toy2{
    public String toString(){
        return "Toy";
    }
}
public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit2> fruit2FruitBox = new FruitBox<>();
        FruitBox<Apple2> apple2FruitBox = new FruitBox<>();
        FruitBox<Grape2> grape2FruitBox = new FruitBox<>();
        // FruitBox<Grape2> grape2FruitBox1 = new FruitBox<Apple2>(); Error. 타입 불일치
        // FruitBox<Toy> toy2FruitBox = new FruitBox<Toy>(); Error.

        fruit2FruitBox.add(new Fruit2());
        fruit2FruitBox.add(new Apple2());
        fruit2FruitBox.add(new Grape2());
        apple2FruitBox.add(new Apple2());
        // apple2FruitBox.add(new Grape2()); Error. Grape는 Apple의 자손이 아님

        System.out.println("fruit2Box-" + fruit2FruitBox);
        System.out.println("apple2Box-" + apple2FruitBox);
        System.out.println("grape2Box-" + grape2FruitBox);
    }
}

interface Eatable{

}

class FruitBox<T extends Fruit2 & Eatable> extends Box2<T>{

}

class Box2<T>{
    ArrayList<T> list = new ArrayList<>();

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
