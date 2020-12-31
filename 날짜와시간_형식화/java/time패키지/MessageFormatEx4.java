package 날짜와시간_형식화.java.time패키지;

import java.io.File;
import java.text.MessageFormat;
import java.util.Scanner;

public class MessageFormatEx4  {
    public static void main(String[] args) throws Exception{
        String tableName = "CUST_INFO";
        String fileName = "./src/날짜와시간_형식화/data4.txt";
        String msg = "INSERT INRO" + tableName + " VALUES ({0},{1},{2},{3});";

        Scanner sc = new Scanner(new File(fileName));

        String pattern = "{0},{1},{2},{3}";
        MessageFormat mf = new MessageFormat(pattern);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Object[] ob = mf.parse(line);
            System.out.println(MessageFormat.format(msg,ob));
        }
    }
}
