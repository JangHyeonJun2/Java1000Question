package 쓰레드;

import javax.swing.*;

public class ThreadEx6 {
    public static void main(String[] args) throws Exception{
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input +"입니다.");

        for (int i=10; i>0; i--){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }

    }
}
/*
 * 이 예제는 하나의 쓰레드로 사용자의 입력을 받는 작업과 화면에 숫자를 출력하는 작업을 처리하기 때문에 사용자가 입력을 마치기 전까지는 화면에 숫자가 출력되지 않다가 사용자가 입력을
 * 마치고 나서야 화면에 숫자가 출력된다.
 */
