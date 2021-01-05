package 자바1000제;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * 이번엔 간단한 AWT프로그램을 이용해서... Text데이터를 편집하는데 도움이 되는 기능들을 하나씩 구현해나가는 예제입니다.
 * 이 문제들을 응용해서 필요한 기능들을 추가해서 사용하면 Text데이터를 처리하는데 도움이 될 것입니다.
 * [문제1] 짝수 줄을 삭제하는 버튼의 기능을 구현하세요.
 */
public class TextToolEx1 extends Frame implements WindowListener
{
    TextArea ta;
    TextField tfParam1, tfParam2;
    Panel pNorth, pSouth;
    Label lb1, lb2;

    String[] btnName = {
            "짝수줄삭제", // btn[0] - 짝수줄을 삭제하는 기능
    };

    Button[] btn = new Button[btnName.length];

    /**
     * 시스템마다 달라지는 자바의 행구분자 처리방법은 아래와 같습니다.
     * 윈도우의 경우는 "\r\n'이 행구분자이고
     * 유닉스같은 경우는 "\n"이 행구분자입니다.
     * 이런것들은 알아내기 위해서는 line.separator 라는 시스템속성을 사용해서 쉽게 이용할수 있습니다.
     */
    private final String CR_LF = System.getProperty("line.separator"); // 개행문자(줄바꿈문자)

    private void registerEventHandler() {
        addWindowListener(this);

        btn[0].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능
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

