package chapter09;

import java.io.File;
import java.util.Scanner;

public class ScannerEx3 {
    public static void main(String[] args) throws Exception{
        Scanner sc2 = new Scanner(new File("./src/data3.txt"));
        int total_sum = 0;
        int cnt = 0;
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
            Scanner sc3 = new Scanner(line).useDelimiter(",");
            int sum=0;
//            파일로부터 데이터를 읽어서 계산하는 예제이다. ','를 구분자로 한 라인에 여러 데이터가 저장되어 있다. 이럴 때는 파일의 내용을 먼저 라인별로 읽은 다음에 다시 ','를 구분자로 하는 Scanner를 이용해서
//            각각의 데이터를 읽어야 한다.
            while(sc3.hasNextInt()){
                sum += sc3.nextInt();
            }
            System.out.println(line+", sum = "+ sum);
            total_sum += sum;
            cnt++;
        }
        System.out.println("Line: "+cnt+", Total: "+total_sum);
    }
}
