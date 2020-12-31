package 자바1000제;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제1: 예제를 실행하면 '>>' 와 같은 프롬프트가 나타나서 사용자의 입력을 기다리고, 사용자가 입력한 내용을 화면에 출력한다. 만일 사용자가 'q' or 'Q'를 입력하면 프로그램을 종료한다.
 * 문제2: 사용자가 입력한 명령라인을 공백(' ')을 구분자로 해서 잘라서 배열에 저장한 다음에 배열의 내용을 출력하는 예제 코드를 완성하여라.
 * 문제3: 사용자가 입력한 명령라인의 내용을 저장하는 save(String input)메서드와 사용자가 입력한 명령라인의 이력을 보여주는 history()메서드를 완성하시오.
 */
public class ConsoleEx1 {
    static Scanner sc = new Scanner(System.in);
    static String[] argArr; //입력한 매개변수를 담기위한 문자열 배열
    static Queue q = new LinkedList();//사용자가 입력한 내용을 저장할 큐(Queue)
    static final int MAX_SIZE = 5; //큐에 저장될 수 있는 값의 개수

    public static void main(String[] args) {
        while(true) {
            String prompt = ">>";
            System.out.print(prompt);

            //1.화면으로부터 라인단위로 입력받는다.
            String userValue = sc.nextLine();

            save(userValue);
            //1-1. 입력받은 값에서 앞뒤 공백을 제거한다.(String클래스의 trim()사용)
            String returnValue = userValue.trim().replaceAll(" +"," ");

            if (userValue.equals(""))
                continue;

            userValue = userValue.toLowerCase();// 사용자가 입력한 문자열을 소물자로 변경

            //1-2. 입력받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다. String클래스의 split(String regex)를 사용 - 공백이 하나 이상인 경우에도 하나의 공백으로 간주해야한다.
            argArr = returnValue.split(" ");


            //2.q or Q를 입력하면 실행 종료한다.
            if (userValue.equalsIgnoreCase("q")) {
                System.exit(0);
            }else if (userValue.equals("history")){
                history();
            } else {
                for (String value : argArr) {
                    System.out.println(value);
                }
            }
        }//while(true)
    }//main


    /**
     * 사용자가 입력한 최근 명령을 보여주는 메서드
     */
    private static void history() {
        Iterator<String> iter = q.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * 사용자가 입력한 값을 큐에 저장하는 메서드
     * @param userValue
     */
    private static void save(String userValue) {
        if (userValue == null || "".equals(userValue))
            return;

        //1.queue에 저장한다.
        if (q.size() == 5){
            q.remove();
            q.add(userValue);
        }else {
            q.add(userValue);
        }
        //2.queue의 쵀대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
    }
}//class
