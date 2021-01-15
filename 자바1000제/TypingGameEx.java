package 자바1000제;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class TypingGameEx {
    Vector words = new Vector();
    String[] data = {"태연","유리","윤아","효현","수영","서현","티파니","써니","제시카"};
    int interval = 2 * 1000; //2초

    WordGenerator wg = new WordGenerator();

    public static void main(String[] args) {
        TypingGameEx game = new TypingGameEx();

        game.wg.start();

        Vector words = game.words;

        while(true) {
            System.out.println(words);

            String prompt = ">>";
            System.out.print(prompt);

            //화면으로부터 라인단위로 입력받는다.
            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();

            /*
                1.사용자가 입력한 값을 words에서 찾아 제거한다.
             */

            Iterator iterator = words.iterator();
            if (iterator.hasNext()) {
                if (input.equals(iterator.next())) {
                    iterator.remove();
                }
            }
        }
    }// main

    public void delay(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class WordGenerator extends Thread {
        @Override
        public void run() {
            /*
                WordGenerator는 일정시간(interval)간격으로 data배열의 한 요소를 골라서 words(Vector인스턴스)에 저장하는 일을 수행한다.

                1.문자열 배열 data의 임의의 요소를 골라서 Words(Vector인스턴스)에 저장한다.
                2.인스턴스 변수 interval의 값만큼 시간간격을 둔다.
                3.반복문을 이용해서 1,2의 작업이 반복적으로 이루어지게 한다.
             */
            while (true) {
                int randomNum = (int) (Math.random() * data.length);

                words.add(data[randomNum]);
                delay(interval);
            }
        }
    }
}

