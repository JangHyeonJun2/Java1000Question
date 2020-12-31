package 제네릭스_열거형_애너테이션.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Computer{
    String name;
    int weight;

    public Computer(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return name+"("+weight+")";
    }
}

class Ms extends Computer {
    public Ms(String name, int weight) {
        super(name, weight);
    }
}

class Asus extends Computer{
    public Asus(String name, int weight) {
        super(name, weight);
    }
}

class MsComp implements Comparator<Ms>{
    @Override
    public int compare(Ms o1, Ms o2) {
        return (o2.weight - o1.weight);
    }
}

class AsusComp implements Comparator<Asus>{
    @Override
    public int compare(Asus o1, Asus o2) {
        return (o2.weight - o1.weight);
    }
}

class ComputerComp implements Comparator<Computer>{
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.weight - o2.weight;
    }
}
public class ComputerBoxEx1 {
    public static void main(String[] args) {
        ComputerBox<Ms> msComputerBox = new ComputerBox<>();
        ComputerBox<Asus> asusComputerBox = new ComputerBox<>();

        msComputerBox.add(new Ms("Window98",100));
        msComputerBox.add(new Ms("Window2000",95));
        msComputerBox.add(new Ms("WindowXP",90));

        asusComputerBox.add(new Asus("stie-98",200));
        asusComputerBox.add(new Asus("stie-200", 100));

        Collections.sort(msComputerBox.getList(),new MsComp());
        Collections.sort(asusComputerBox.getList(),new AsusComp());

        System.out.println(msComputerBox);
        System.out.println(asusComputerBox);
        System.out.println();

        Collections.sort(msComputerBox.getList(),new ComputerComp());
        Collections.sort(asusComputerBox.getList(),new ComputerComp());

        System.out.println(msComputerBox);
        System.out.println(asusComputerBox);
    }
}
class ComputerBox<T extends Computer> extends Kit<T>{

}

class Kit<T>{
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
