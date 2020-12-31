package 자바1000제;

import java.util.Scanner;

public class QuizEx1 {
    public static void main(String[] args) {
        String[] data = {
                "다음 중 키워드가 아닌 것은?`2`final`Ture`if`public",
                "다음 중 자바의 연산자가 아닌 것은?`6`&`l`++`!=`/`^",
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false"
        };

        Scanner sc = new Scanner(System.in);
        int score = 0;

        shuffle(data); //문제를 섞는다.


        System.out.println("[실행결과]");
        for (int i=0; i<data.length; i++){
            //1.String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
            String[] tmp = data[i].split("`", 3);

            String question = tmp[0];
            String answer = tmp[1];

            //2.문제를 출력하세요.
            System.out.println("[" + (i+1) + "]" + question);
            //3.선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
            String[] choices = tmp[2].split("`");

            answer = choices[Integer.parseInt(answer)-1]; // 문제 3번

            shuffle(choices); //문제 3번

            //4.반복문을 이용해서 선택지를 출력하세요.
            for (int j=0; j<choices.length; j++) {
                System.out.print((j+1)+"."  + choices[j]+"  ");
            }
            System.out.println();

            System.out.print("[답]");

            String userValue = sc.nextLine();
            if (answer.equals(answer))
                score++;

            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("정답개수/전체 문항수 : " + score + "/" +data.length);
    }

    private static void shuffle(String[] data) {
        //1.배열 data의 개수가 0보다 같거나 적으면 메서드 전체를 빠져나간다.용
        if (data.length <= 0)
            return;
        //2. 선택지의 순서를 뒤바꾼다. 반복문과 Math.random()사용
        for (int i=0; i<data.length; i++) {
            int randomValue = (int)(Math.random()*data.length);

            String tmp = data[0];
            data[0] = data[randomValue];
            data[randomValue] = tmp;
        }

    }
}
