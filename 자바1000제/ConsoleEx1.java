package 자바1000제;

import java.util.Scanner;

public class ConsoleEx1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            String prompt = ">>";
            System.out.print(prompt);

            //1.화면으로부터 라인단위로 입력받는다.
            String userValue = sc.nextLine();
            System.out.println(userValue);
            //2.q or Q를 입력하면 실행 종료한다.
            if (userValue.equalsIgnoreCase("q"))
                System.exit(0);
        }//while(true)
    }//main
}//class
