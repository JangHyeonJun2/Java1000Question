package 자바1000제;

import java.util.Scanner;

public class WordScrambleEx1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] strArr = {"CHANGE","LOVE","HOPE","VIEW"};

//        String answer = getAnswer(strArr);
//        String question = getScrambledWord(answer);


        while(true){
            System.out.println("---바깥쪽 while문---");
            String answer = getAnswer(strArr);
            String question = getScrambledWord(answer);
            char[] hint = new char[answer.length()];

            //hint를 '-'로 초기화 환다. 정답이 LOVE라면 hint는 "____"이 된다.
            for (int i=0; i<hint.length; i++) {
                hint[i] = '_';
            }
            while (true) {
                System.out.println("===안쪽 while문===");
                System.out.println("Question: " + question);
                System.out.print("Your answer is : ");
                //1.화면을 통해 사용자의 입력을 받는다(Scanner클래스 사용)
                String userValue = sc.next();
                //2.사용자가 q 또는 Q를 입력하면 프로그램 종료한다.
                if (userValue.equals("q") || userValue.equals("Q"))
                    System.exit(0);
                //3.사용자가 정답을 맞출때까지 반복하다요가 사용자가 정답을 맞추면, while문을 빠져나간다.
                if (userValue.equalsIgnoreCase(answer)){
                    System.out.println("정답입니다.");
                    break;
                }else {
                    System.out.println(userValue + "은/는 정답이 아닙니다. 다시 시도해보세요");
                    System.out.println("Hint: " + getHint(answer,hint));
                }

            }
        }

    }

    private static String getHint(String answer, char[] hint) {
        char[] chars = answer.toCharArray();

        int count = 0; //힌트에 포함된 '_'의 갯수
        //1. 반복문을 이용해서 hint에 포함된 '_'의 개수를 센다.
        for (int i=0; i<hint.length; i++) {
            if (hint[i] == '_')
                count+=1;
        }
        //2. count의 값이 2보다 클 때만 정답의 한 글자를 hint에 넣는다
        //  - 정답을 다 알려주는 상황이 되지 않게 하기 위함.

        //[주의] 반드시 이전 힌트 보다 한 글자를 더 보여줘야함.
        // 예를 들어 정답이 "LOVE"이고 이전 힌트가 "L___"이었다면 그 다음 힌트는 "L__E" or "L_V_"와 같은 식이어야한다. Math.random()을 사용해서 정답의 한글자를 골라서 힌트에 넣으면 된다.
        if (count > 2){
            int num;
            while (true){
                num = (int) (Math.random() * answer.length());
                if (hint[num] == '_')
                    break;
            }
            hint[num] = chars[num];
        }
        return new String(hint);
    }

    private static String getScrambledWord(String answer) {
        char[] splitValue = answer.toCharArray();//만약에 CHANGE이면 C,H,A,N,G,E

        for (int i=0; i<answer.length(); i++) {
            int idx = (int)(Math.random()*answer.length());

            char tmp = splitValue[0];
            splitValue[0] = splitValue[idx];
            splitValue[idx] = tmp;
        }

        return new String(splitValue);
    }



    private static String getAnswer(String[] strArr) {
        int num = (int)((Math.random()*strArr.length));
        return strArr[num];
    }
}
