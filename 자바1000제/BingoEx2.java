package 자바1000제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BingoEx2 extends Frame {
    final int SIZE = 5; //빙고판의 크기
    int bingoCnt = 0; //완성된 라인의 수

    Button[] btnArr = null;
    boolean[][] bArr = new boolean[SIZE][SIZE]; //빙고판 체크여부 확인을 위한 배열

    String[] values = {
            "글쎄", "기로로", "김창우", "김천대표", "까꿍",
            "남궁성", "낭군이", "넓게보기", "네라주리", "다밀",
            "더클레오", "들개", "디벨로", "레몬", "루션",
            "루이지노", "무색이", "문학청년", "사천사", "상상",
            "세피룸", "스쿨쥐", "쌩", "쏭양", "씨드",
            "양수호", "에노야", "에비츄", "에이스", "엔즈",
            "오이날다", "오케클릭", "용주니", "우기파파", "잠탱이",
            "제러스", "조땜", "지냔", "카라", "캉스",
            "태연", "파티쉐", "페르소마", "폭풍", "핏빛노을",
            "핑크팬더", "하늘이", "하루", "한경훈", "헐레벌떡",
            "화염병", "흑빛"
    };

    BingoEx2() {
        this("Bingo Game Ver1.0");
    }

    BingoEx2(String title) {
        super(title);

        setLayout(new GridLayout(SIZE, SIZE));

        BingoEx2.MyEventHandler handler = new BingoEx2.MyEventHandler();
        addWindowListener(handler);

        btnArr = new Button[SIZE * SIZE];

        shuffle();

        //Frame에 버튼을 추가한다.
        for (int i = 0; i < SIZE * SIZE; i++) {
            btnArr[i] = new Button(values[i]);
            add(btnArr[i]);
            btnArr[i].addActionListener(handler);
        }

        setBounds(500, 200, 300, 300);
        setVisible(true);
    }

    void shuffle() {
        /*
            1.반복문을 사용해서 문자열 배열 values의 각 요소의 위치를 뒤바꾼다.
         */

        for (int i=0; i<values.length; i++) {
            int r1 = (int)(Math.random()*values.length);
            int r2 = (int)(Math.random()*values.length);

            String tmp = values[r1];
            values[r1] = values[r2];
            values[r2] = tmp;
        }
    }

    void print() {

//        System.out.println(bingoCnt);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (bArr[i][j])
                    System.out.print("O");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }


    boolean checkBingo() { //빙고가 완성되었는지를 확인한다.
        bingoCnt = 0;
        int aroCnt = 0;
        int seroCnt = 0;
        int crossCnt1 = 0;//대각선의 0의 개수
        int crossCnt2 = 0;//역대각선의 0의 개수

        /*
            1.이중 반복문을 이용해서 배열 bArr의 값을 체크한다.
            2.완성된 라인의 수를 세어서 SIZE의 개수보다 크거나 같으면 true를 그렇지 않으면 false를 반환한다.
         */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (bArr[i][j] == true) { //가로 체크
                    aroCnt++;
                }

                if (bArr[j][i] == true) { //세로 체크
                    seroCnt++;
                }
            }

            if (aroCnt == 5) {
                bingoCnt++;
                for (int k=0; k<SIZE; k++) {
                    btnArr[(i*5)+k].setBackground(Color.GREEN);
                }
            }
            if (seroCnt == 5) {
                bingoCnt++;
                for (int k=0; k<SIZE; k++) {
                    btnArr[(k*5)+i].setBackground(Color.GREEN);
                }
            }

            //가로 & 세로 개수를 다시 0으로 초기화!
            aroCnt = 0;
            seroCnt = 0;

            if (bArr[i][i] == true) { //대각선 체크
                crossCnt1++;
            }

            if (bArr[4 - i][i] == true) {
                crossCnt2++;
            }
        }

        if (crossCnt1 == 5) {
            bingoCnt++;
            for (int k=0; k<SIZE; k++) {
                btnArr[(k*5)+k].setBackground(Color.GREEN);
            }
        }
        if (crossCnt2 == 5) {
            bingoCnt++;
            for (int k=0; k<SIZE; k++) {
                btnArr[((4-k)*5)+k].setBackground(Color.GREEN);
            }
        }

        if (bingoCnt == SIZE || bingoCnt > SIZE)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        BingoEx2 win = new BingoEx2("Bingo Game Ver1.0");
    }

    class MyEventHandler extends WindowAdapter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Button btn = (Button) e.getSource();
            System.out.println(btn.getLabel()); //눌려진 버튼의 Label을 콘솔에 출력한다.

            for (int i = 0; i < btnArr.length; i++) {
                if (btnArr[i] == btn) {
                    bArr[i / SIZE][i % SIZE] = true;
                    break;
                }
            }
            btn.setBackground(Color.YELLOW);
            print();
            if (checkBingo()) {
                System.out.println("bingo~!!!");
                JOptionPane.showMessageDialog(null, "빙고를 완성했습니다!!!"); //메세지 출력
            }

        }
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
            System.exit(0);
        }
    }
}

