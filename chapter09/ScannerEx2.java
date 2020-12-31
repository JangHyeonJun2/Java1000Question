package chapter09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./src/data2.txt"));
            int sum = 0;
            int cnt = 0;

            while(sc.hasNextInt()){
                sum += sc.nextInt();
                cnt++;
            }
            System.out.println("sum = "+ sum);
            System.out.println("average=" +(double)sum/cnt);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
