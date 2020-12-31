package 날짜와시간_형식화.java.time패키지;

import java.text.MessageFormat;

public class MessageFormatEx3 {
    public static void main(String[] args) throws Exception{
        String[] argu = {
                "INSERT INTO CUST_INFO VALUES ('이자바','02,1111-2222','27','08-29');",
                "INSERT INTO CUST_INFO VALUES ('김프로','023-1111-2222','33','08-29');"
        };

        String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
        MessageFormat mf = new MessageFormat(pattern);

        for(int i = 0;i<argu.length;i++){
            Object[] ob = mf.parse(argu[i]);
            for(int j=0;j<ob.length;j++){
                System.out.print(ob[j]+", ");
            }
            System.out.println();
        }
    }
}
