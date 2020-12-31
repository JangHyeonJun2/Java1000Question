package 날짜와시간_형식화.java.time패키지;

import java.text.MessageFormat;

public class MessageFormatEx2 {
    public static void main(String[] args) {
        String tableName = "CUST_INFO";
        String msg = "INSERT INTO" + tableName + " VALUES (''{0}'',''{1}'',''{2}'',''{3}'');";

        Object[][] argu = {
                {"이자바","02,1111-2222","27","07-09"},
                {"김프로","023-1111-2222","33","10-02"}
        };

        for(int i=0; i <argu.length; i++){
            String result = MessageFormat.format(msg,argu[i]);
            System.out.println(result);
            System.out.println(argu[i].length);
        }
    }
}
