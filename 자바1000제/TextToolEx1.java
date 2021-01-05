package 자바1000제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * 이번엔 간단한 AWT프로그램을 이용해서... Text데이터를 편집하는데 도움이 되는 기능들을 하나씩 구현해나제가는 예제입니다.
 * 이 문제들을 응용해서 필요한 기능들을 추가해서 사용하면 Text데이터를 처리하는데 도움이 될 것입니다.
 * [문제1] 짝수 줄을 삭제하는 버튼의 기능을 구현하세요.
 * [문제2] 작업 이전 상태로 되돌리는 Undo기능을 구현하여라. 예를 들어 짝수줄 삭제버튼을 누른 다음에 Undo버튼을 누르면 TextArea의 내용이 짝수줄삭제버튼을 누르기 이전의 상태로 되돌아가야한다.
 * [문제3] TextArea의 데이터 중에서 Param1에 입력된 문자 또는 문자들을 제거하는 기능의 '문자삭제' 버튼의 기능을 완성하세요.
 * [문제4] TextArea의 데이터에서 각 라인의 앞뒤 공백을 제거하는 버튼 'trim'과 빈 줄을 제거하는 기능의 '빈줄삭제' 버튼의 기능을 완성하세요.
 * [문제5] TextArea의 각 라인의 앞에는 param1에 입력된 문자열을, 뒤에는 param2에 입력된 문자열을 붙이는 기능의 '접두사추가' 버튼을 구현하세요.
 * [문제6] TextArea의 각 라인의 앞에는 param1에 입력된 문자열을, 뒤에는 param2에 입력된 문자열을 제거 기능의 'substring'버튼을 구현하세요.
 * [문제7] TextArea의 각 라인에서 param1에 입력된 문자열과 param2에 입력된 문자열을 찾아서 두 문자열 사이의 텍스트만 남기고 삭제하는 기능의 'substring2'버튼을 구현하여라.
 */
public class TextToolEx1 extends Frame implements WindowListener
{
    TextArea ta;
    TextField tfParam1, tfParam2;
    Panel pNorth, pSouth;
    Label lb1, lb2;

    String[] btnName = {
            "Undo",    //작업이전 상태로 되돌림.
            "짝수줄삭제", // btn[0] - 짝수줄을 삭제하는 기능
            "문자삭제", //param1에 지정된 문자들을 삭제하는 기능
            "trim",
            "빈줄 삭제",
            "접두사추가", //Param1,Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능
            "substring", //Param1,Param2에 지정된 문자열을 각 라인에서 제거하는 기능
            "substring2" //Param1,Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능
    };

    Button[] btn = new Button[btnName.length];

    /**
     * 시스템마다 달라지는 자바의 행구분자 처리방법은 아래와 같습니다.
     * 윈도우의 경우는 "\r\n'이 행구분자이고
     * 유닉스같은 경우는 "\n"이 행구분자입니다.
     * 이런것들은 알아내기 위해서는 line.separator 라는 시스템속성을 사용해서 쉽게 이용할수 있습니다.
     */
    private final String CR_LF = System.getProperty("line.separator"); // 개행문자(줄바꿈문자)
    private String preText = ""; //TextArea ta의 내용을 저장하기 위한 변수.

    private void registerEventHandler() {
        addWindowListener(this);

        int n = 0;

        //Undo - 작업이전 상태로 되돌림
        btn[n++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = ta.getText();

                if (!preText.equals(""))
                    ta.setText(preText);

                preText = text;

            }
        });


        btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능
            public void actionPerformed(ActionEvent ae) {

                      /*
                       다음의 코드를 완성하세요.
                       1. TextArea ta의 텍스트를 가져온다.(getText()사용)\
                       2. 작업의 결과를 저장할 StringBuffer sb를 생성한다.
                       3. Scanner클래스와 반복문을 이용해서 1에서 가져온  텍스트를 라인단위로 읽는다.
                          (Scanner클래스의 hasNextLine(), nextLine()사용)
                       4. 조건문을 사용해서 짝수줄인 경우에만 sb에 담는다.
                       5. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                     */

                String text = ta.getText();
                preText = text;
                String line = "";
                int count = 0;
                StringBuffer sb = new StringBuffer(text.length());
                Scanner sc = new Scanner(text);
                while(sc.hasNextLine()){
                    line = sc.nextLine();
                    if (count%2 == 0) {
                        sb.append(line).append(CR_LF);
                    }
                    count++;
                }
                ta.setText(sb.toString());

            }
        });

        btn[n++].addActionListener(new ActionListener() {//문자 삭제 - Param1에 지정된 문자를 삭제하는 기능
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = ta.getText();
                StringBuffer sb = new StringBuffer(text.length());

                preText = text;

                /*
                    다음의 코드를 완성하시오.
                    1. TextField Param1의 값을 가져온다.(getText()사용)
                       2. 반복문을 이용해서 curText를 한글자씩 읽어서
                          Param1에서 가져온 문자열에 포함되어 있는지 확인한다.
                          2.1 만일 포함되어 있으면 sb에 저장하고
                          2.2 포함되어 있지 않으면 sb에 저장하지 않는다.
                       3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                 */

                String paramValue = tfParam1.getText();
                if (paramValue.equals("")){
                    JOptionPane.showMessageDialog(null,"Param1을 입력하세요"); //메세지 출력
                    return;
                }

                String[] splits = text.split(CR_LF);
                for (int i=0; i<splits.length; i++) {
                    String[] splitss = splits[i].split("");
                    for (int j=0; j<splitss.length; j++) {
                        if (!paramValue.contains(splitss[j]))
                            sb.append(splitss[j]);
                    }
                    sb.append(CR_LF);
                }
                ta.setText(sb.toString());
            }
        });

        btn[n++].addActionListener(new ActionListener() { //trim - 라인의 좌우공백을 제거하는 기능
            @Override
            public void actionPerformed(ActionEvent e) {
                String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                preText = curText;
                /*

                           다음의 코드를 완성하세요.
                            1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                               (Scanner클래스의 hasNextLine(), nextLine()사용)
                            2. 읽어온 라인의 왼쪼공백과 오른쪽 공백을 제거한다.(String클래스의 trim()사용)
                            3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                       */
                String line = "";
                Scanner sc = new Scanner(curText);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    sb.append(line.trim()).append(CR_LF);
                }
                ta.setText(sb.toString());
            }



        });

        btn[n++].addActionListener(new ActionListener() {//빈줄삭제 기능
            @Override
            public void actionPerformed(ActionEvent e) {
                String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                preText = curText;

                 /*
                            다음의 코드를 완성하세요.
                            1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                               (Scanner클래스의 hasNextLine(), nextLine()사용)
                            2. 읽어온 라인이 내용이 없는 빈 라인이면 sb에 저장하지 않는다.
                            3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                       */
                String line = "";
                Scanner sc = new Scanner(curText);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    if (!line.equals(""))
                        sb.append(line).append(CR_LF);
                }
                ta.setText(sb.toString());
            }
        });

        btn[n++].addActionListener(new ActionListener() { //접두사 - 각 라인에 접두사,접미사 붙이기
            @Override
            public void actionPerformed(ActionEvent e) {
                String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                preText = curText;

                /*
                   다음의 코드를 완성하세요.
                   1. param1과 param2의 값을 가져온다.(getText()사용)
                   2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                      (Scanner클래스의 hasNextLine(), nextLine()사용)
                   3. 읽어온 라인의 앞뒤에 param1과 param2의 값을 붙여서 sb에 담는다.
                   4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                 */
                String param1Value = tfParam1.getText();
                String param2Value = tfParam2.getText();

                String line = "";
                Scanner sc = new Scanner(curText);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    sb.append(param1Value.concat(line)).append(param2Value).append(CR_LF);
                }

                ta.setText(sb.toString());
            }
        });

        btn[n++].addActionListener(new ActionListener() { //substring - 문자열 자르기
            @Override
            public void actionPerformed(ActionEvent e) {
                String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                preText = curText;

                /*
                       다음의 코드를 완성하세요.
                       1. param1과 param2의 값을 가져온다.(getText()사용)
                       2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                          (Scanner클래스의 hasNextLine(), nextLine()사용)
                       3. 읽어온 라인을 substring으로 자른다. - param1과 param2의 내용에 관계없이 길이만큼 자른다.
                          (param1의 문자열길이와 param2의 문자열 길이를 이용)
                       4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
                 */
                String param1Value = tfParam1.getText();
                String param2Value = tfParam2.getText();
                String line = "";
                Scanner sc = new Scanner(curText);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    int startIndex = param1Value.length();
                    int endIndex = line.length()-(param2Value.length());

                    if (line.length() < startIndex + endIndex){
                        JOptionPane.showMessageDialog(null,"Param1, Param2의 라인이 너무 깁니다."); //메세지 출력
                        continue;
                    }

                    sb.append(line.substring(startIndex,endIndex)).append(CR_LF);
                }
                ta.setText(sb.toString());

            }
        });

        btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된 문자를 찾아서 그 위치까지 잘라내기
            public void actionPerformed(ActionEvent ae) {
                String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                preText = curText;

               /*
                       다음의 코드를 완성하세요.
                   1. param1과 param2의 값을 가져온다.(getText()사용)
                   2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                   3. 각 라인에서 param1, param2과 일치하는 문자열의 위치를 찾는다.
                      (param1은 라인의 왼쪽끝부터, param2는 라인의 오른쪽끝부터 찾기 시작한다.)
                       param1과 param2로 둘러쌓인 부분을 sb에 저장한다.
                   4. sb의 내용을 TextArea에 보여준다.
               */

                String param1Value = tfParam1.getText();
                String param2Value = tfParam2.getText();
                if (param1Value.equals("") || param2Value.equals("")){
                    JOptionPane.showMessageDialog(null,"Param1 or Param2값이 없습니다."); //메세지 출력
                    return;
                }

                String line = "";
                Scanner sc = new Scanner(curText);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    int num = param1Value.length(); //Indexof반환값이 만약에 param1이 (" 이것이면 ("문자의 (의 위치를 알려주기떄문에 ("문자열의 길이를 구해서 더 해준다.
                    int sIndex = line.indexOf(param1Value);
                    int eIndex = line.lastIndexOf(param2Value);
                    sb.append(line.substring(sIndex+num,eIndex)).append(CR_LF);
                }

                ta.setText(sb.toString());
            }
        });


    }       // end of registerEventHandler()

    public static void main(String[] args) {
        TextToolEx1 win = new TextToolEx1("Text Tool");
        win.show();
    }

    public TextToolEx1(String title) {
        super(title);
        lb1 = new Label("param1:", Label.RIGHT);
        lb2 = new Label("param2:", Label.RIGHT);
        tfParam1 = new TextField(15);
        tfParam2 = new TextField(15);

        ta = new TextArea();
        pNorth = new Panel();
        pSouth = new Panel();

        for(int i=0;i < btn.length;i++) {
            btn[i] = new Button(btnName[i]);
        }

        pNorth.setLayout(new FlowLayout());
        pNorth.add(lb1);
        pNorth.add(tfParam1);
        pNorth.add(lb2);
        pNorth.add(tfParam2);

        pSouth.setLayout(new GridLayout(2,10));

        for(int i=0; i < btn.length;i++) {             // 버튼배열을 하단 Panel에 넣는다.
            pSouth.add(btn[i]);
        }

        add(pNorth,"North");
        add(ta,"Center");
        add(pSouth,"South");

        setBounds(100, 100, 600, 300);
        ta.requestFocus();
        registerEventHandler();
        setVisible(true);
    } // public TextToolEx1(String title) {

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
} // end of class

