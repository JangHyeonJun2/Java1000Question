package 컬렉션프레임웍.TreeSetEx;

import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80,90,50,25,35,89,19,100};

        for (int i=0; i < score.length; i++){
            set.add(score[i]);
        }

        System.out.println("50보다 작은 값: " + set.headSet(50));//원래는 객체를 비교하기 때문에 set.headSet(new Integer(50));
        System.out.println("50보다 큰 값: " +set.tailSet(50));//set.tailSet(new Integer(50));
    }
}
