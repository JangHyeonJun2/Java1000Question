package 자바1000제;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.*;
/**
 * 문제1: 예제를 실행하면 '>>' 와 같은 프롬프트가 나타나서 사용자의 입력을 기다리고, 사용자가 입력한 내용을 화면에 출력한다. 만일 사용자가 'q' or 'Q'를 입력하면 프로그램을 종료한다.
 * 문제2: 사용자가 입력한 명령라인을 공백(' ')을 구분자로 해서 잘라서 배열에 저장한 다음에 배열의 내용을 출력하는 예제 코드를 완성하여라.
 * 문제3: 사용자가 입력한 명령라인의 내용을 저장하는 save(String input)메서드와 사용자가 입력한 명령라인의 이력을 보여주는 history()메서드를 완성하시오.
 * 문제4: 사용자 입력을 받는 프로프트에 현재 작업중인 폴더(디렉토리)의 경로를 표시하는 예제의 코드를 완성하여라
 * 문제5: 현재 디렉토리의 파일과 디렉토리의 목록을 보여주는 명령어 dir을 구현하여라. dir만 입력하면 모든 파일과 디렉토리를, dir *ex?.*와 같이 패턴을 입력하면 패턴과 일치하는 파일 또는 디렉터리의 목록을 보여줘야한다.
 *       (패턴에서 '*'와'?'는 와일드 카드로 '*'는 임의의 여러 글자가 올 수 있으며, '?'는 임의의 한 글자를 의미한다.)
 * 문제6: 지정된 파일의 내용을 보여주는 type명령을 구현하라. type명령의 형식은 'type FILE_NAME'이며, FILE_NAME으로 지정된 파일을 찾아서 그 내용을 화면에 보여줘야한다.
 * 문제7: 지정된 키워드를 지정된 파일에서 찾아서 화면에 보여주는 find명령어를 구현하라.(해당 KEYWORD가 포함된 라인과 라인번호를 화면에 출력,실행결과 참고)
 *       명령어의 형식은 'find KEYWORD FILE_NAME' 이며 , 형식에 맞지 않을때는 사용법을 보여준다.
 *       KEYWORD - 지정된 파일에서 찾기 원하는 문자열
 *       FILE_NAME - KEYWORD가 포함된 내용을 찾을 파일(console*.*과 같은 패턴 지원하지 않음)
 */
public class ConsoleEx1 {
    static Scanner sc = new Scanner(System.in);
    static String[] argArr; //입력한 매개변수를 담기위한 문자열 배열
    static Queue q = new LinkedList();//사용자가 입력한 내용을 저장할 큐(Queue)
    static final int MAX_SIZE = 5; //큐에 저장될 수 있는 값의 개수

    static File curDir; //current Directory

    static {
        //1.시스템속성"user.dir" 값을 읽어서 File객체를 만들고, curDir에 할당하여라.
        //2.1의 코드를 간단히 예외처리하여라.
        try {
            String path = System.getProperty("user.dir");
            curDir = new File(path);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        while(true) {
            try {
                String prompt = curDir.getCanonicalPath()+">>";
                System.out.print(prompt);

                //1.화면으로부터 라인단위로 입력받는다.
                String userValue = sc.nextLine();
                if (userValue.equals(""))
                    continue;

                save(userValue);
                //1-1. 입력받은 값에서 앞뒤 공백을 제거한다.(String클래스의 trim()사용)
                String returnValue = userValue.trim().replaceAll(" +", " ");

                //1-2. 입력받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다. String클래스의 split(String regex)를 사용 - 공백이 하나 이상인 경우에도 하나의 공백으로 간주해야한다.
                argArr = returnValue.split(" ");



                String command = argArr[0].toLowerCase();// 사용자가 입력한 문자열에서 공백을 제거하고 제일 앞부분 문자를 소물자로 변경




                //2.q or Q를 입력하면 실행 종료한다.
                if (command.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if (command.equals("history")) {
                    history();
                } else if(command.equals("dir")){
                    dir();
                } else if (command.equals("type")){
                    type();
                } else if(command.equals("find")){
                    find();
                } else {
                    for (String value : argArr) {
                        System.out.println(value);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("입력오류입니다.");
            }
        }//while(true)
    }//main

    private static void find() throws IOException {
        if (argArr.length !=3) {
            System.out.println("Usage : find KEYWORD FILE_NAME");
            return;
        }

        String keyword = argArr[1];
        String fileName = argArr[2];

        File tmp = new File(fileName);

        /*
            다음의 코드를 완성하세요.
            1.파일(tmp)이 존재하면,
              1.1 반복문을 이용해서 라인별로 읽어서 KEYWORD가 포함되었는지 확인한다.
                  (BufferedReader의 readLine()사용)
              1.2 keyword가 포함된 라인을 발견하면,라인번호와 함께 해당 라인을 화면에 출력한다.

            2.존재하지 않으면, 존재하지 않는 파일이라고 하면에 출력한다.
         */

        if (tmp.exists()){
            BufferedReader br = new BufferedReader(new FileReader(tmp));
            LineNumberReader lr = new LineNumberReader(br);
            String line = null;
            int count = 1;

            //1.2 출력하는 첫 번째 방법
            while((line = br.readLine())!= null){
                count++;
                if (line.contains(keyword)){
                    System.out.println(count + " " + line);
                }

            }
            //1.2 출력하는 두 번째 방법

//            for (int i=1; (line = br.readLine())!=null; i++) {
//                //keyword를 포함한 라인을 출력한다.
//                if (line.indexOf(keyword)!=-1)
//                    System.out.println(i+" : "+line);
//            }
        }else {
            System.out.println(tmp+"는/은 존재하지 않는 파일입니다.");
            return;
        }


    }

    private static void type() throws IOException {
        if (argArr.length != 2){
            System.out.println("Usage : type FILE_NAME");
            return;
        }

        String fileName = argArr[1];

        File tmp = new File(fileName);
        /*
            1.파일(tmp)가 존재하는지 확인하고,
              1-1. 존재하면 파일의 내용을 화면에 출력한다.(FileReader와 BufferdReader를 사용)
              1-2. 존재하지 않으면, 존재하지 않는 파일이라고 출력한다.
         */



        //type메서드 첫번쨰 방법
//        for (int i=0; i<curDir.listFiles().length; i++) {
//            if (fileName.equals(curDir.listFiles()[i].getName())){
//                BufferedReader br = new BufferedReader(new FileReader(curDir.listFiles()[i]));
//                String line = null;
//                while((line = br.readLine()) != null){
//                    System.out.println(line);
//                }
//                br.close();
//            }
//        }

        //type메서드 두번쨰 방법
        if (tmp.exists()){
            BufferedReader br = new BufferedReader(new FileReader(tmp));
            String line = null;
            int count = 1;
            while((line = br.readLine()) != null){
                System.out.println(count++ + " " +line);
            }
            br.close();
        }else
            System.out.println(fileName+" 는/은 존재하지 않는 파일입니다.");


    }

    private static void dir() {
        String pattern = "";

        switch(argArr.length) {
            case 1 :  // dir만 입력한 경우 현재 디렉토리의 모든 파일과 디렉토리를 보여준다.

                        /*

                            다음의 코드를 완성하세요.

                            1. 반복문을 이용해서 현재디렉토리의 모든 파일의 목록을 출력한다.(File클래스의 listFiles()사용)

                            2. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.

                                (File클래스의 isDirectory()를 사용해서 체크)

'                       */

                /**
                 * 재귀로 다시 구현하
                 */
                for (File f : curDir.listFiles()) {
                    if (f.isDirectory()){
                        System.out.println("[" + f.getName() + "]");
                        String newPath = curDir.getPath() + "/" + f.getName();
                        File sec = new File(newPath);
                        if (newPath.length() > 0){
                            for (File f2 : sec.listFiles()) {
                                if (f2.isDirectory()) {
                                    System.out.println("   [" + f2.getName() + "]");
                                }else {
                                    System.out.println("   "+f2.getName());
                                }
                            }
                        }
                    }else {
                        System.out.println(f.getName());
                    }
                }
                break;
            case 2 :  // dir과 패턴을 같이 입력한 경우, 예를 들면 dir *.class
                pattern = argArr[1];
                pattern = pattern.toUpperCase(); // 패턴에서 대소문자를 구별하지 않도록 대문자로 변경한다.



                /*

                   다음의 코드를 완성하세요.

                   1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.

                       String클래스의 String replace(CharSequence target, CharSequence replacement)를 사용하자.

                       예를 들면, pattern = pattern.replace("A","AA")는 pattern의 "A"를 "AA"로 치환한다.



                   2. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들만 출력한다.

                      이때, 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.

                      (File클래스의 isDirectory()를 사용해서 체크)



                      대소문자구별을 하지 않기 위해서, 패턴과 마찬가지로 파일이나 디렉토리명을 대문자로 변경해야한다.

                      String tmp = f.getName().toUpperCase();
               */

                pattern = argArr[1];
//                pattern = pattern.toUpperCase();
                pattern = pattern.replace(".","\\.");
                pattern = pattern.replace("*"," *");
                pattern = pattern.replace("?","{1}");

//                Pattern p = Pattern.compile(pattern);

                String newPath = curDir+"/"+"src";

                File sec = new File(newPath);

                for (File f : sec.listFiles()){
                    String tmp ="";
                    if (f.getName().contains("."))
                        tmp = f.getName().substring(f.getName().indexOf("."));
//                    Matcher m = p.matcher(tmp);
                    boolean flag = Pattern.matches(pattern,tmp);

                    if (flag){
                        if (f.isDirectory()) {
                            System.out.println("[" + f.getName() + "]");
                        }else {
                            System.out.println(f.getName());
                        }
                    }
                }



                break;
            default :
                System.out.println("USAGE : dir [FILENAME]");
        } // switch
    }


    /**
     * 사용자가 입력한 최근 명령을 보여주는 메서드
     */
    private static void history() {
        Iterator<String> iter = q.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * 사용자가 입력한 값을 큐에 저장하는 메서드
     * @param userValue
     */
    private static void save(String userValue) {
        if (userValue == null || "".equals(userValue))
            return;

        //1.queue에 저장한다.
        if (q.size() == 5){
            q.remove();
            q.add(userValue);
        }else {
            q.add(userValue);
        }
        //2.queue의 쵀대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
    }
}//class
