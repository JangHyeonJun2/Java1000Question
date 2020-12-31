package 컬렉션프레임웍.TreeSetEx;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        String from = "b";
        String to = "d";

        treeSet.add("abc");
        treeSet.add("car");
        treeSet.add("dance");
        treeSet.add("elephant");
        treeSet.add("flower");
        treeSet.add("alien");
        treeSet.add("Car");
        treeSet.add("dZZZZ");
        treeSet.add("elevator");
        treeSet.add("bat");
        treeSet.add("disc");
        treeSet.add("dzzzz");
        treeSet.add("fan");


        System.out.println(treeSet);
        System.out.println("range search : from " + from +" to "+ to);
        System.out.println("result1 : " + treeSet.subSet(from, to));
        System.out.println("result2 : " + treeSet.subSet(from, to + "zzz"));
    }
}
