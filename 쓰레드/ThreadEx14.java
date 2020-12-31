package 쓰레드;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 " + input +"입니다.");
        th1.interrupt();//interrupt()를 호출하면, interrupted상태가 true가 된다!.
        System.out.println("isInterrupted() : " +th1.isInterrupted());
    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i=10;
        while(i!=0 && !isInterrupted()){

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}

        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
