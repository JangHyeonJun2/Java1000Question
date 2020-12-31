package 문자열다루기;

import java.io.*;
import java.util.Scanner;

public class Code22 {

    static String[] words = new String[1000000];
    static int[] count = new int[100000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("$ ");
            String command = sc.next();

            if(command.equals("read")){

                String fileName = sc.next();
                makeIndex(fileName);

            }else if(command.equals("find")){

                String str = sc.next();
                int index = findWord(str);
                if(index > -1)
                    System.out.println("The word "+words[index]+" appears " + count[index] + " times.");
                else
                    System.out.println("The word " + str + "does not appear.");

            }else if (command.equals("saveas")){
                String fileName = sc.next();
                saveAs(fileName);
            }else if(command.equals("exit"))
                break;

        }
        sc.close();
        for(int i=0; i<n; i++){
            System.out.println(words[i] + " " + count[i]);
        }
    }
    public static void saveAs(String fileName){
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));

            for (int i=0; i<n; i++){
                out.println(words[i] + " " + count[i]);
            }

            out.close();
        } catch (IOException e) {
            System.out.println("Fail Save!!!");
        }
    }
    public static void makeIndex(String fileName){
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()){
                String str = inFile.next();
                addWord(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("no File");
            return;
        }
    }
    public static void addWord(String str){
        int index = findWord(str); //returns -1 if not found
        if(index != -1){//found
            count[index]++;
        }else { //not found
            words[n] = str;
            count[n] = 1;
            n++;
        }
    }
    public static int findWord(String str){
        for(int i=0;i<n;i++){
            if(words[i].equals(str))
                return i;
        }
        return -1;
    }
}
