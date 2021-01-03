package 자바1000제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * 이번 예제는 성적처리 프로그램을 만드는 것이다. 총점계산, 반등수, 전교등수, 반, 반호별 정렬등을 다룬다.
 * [문제1] 다음의 예제에서 Student클래스를 작성하여라.
 * [문제2] Student클래스가 Comparable인터페이스를 구현해서, list를 총점(total) 내림차순으로 정렬되도록 하는 예제입니다.
 * [문제3] list를 다양한 기준으로 정렬하기 위해서 Comparator를 구현한 클래스를 구현하세요.
 *        ClassTotalComparator - 반별로 총점이 높은 순에서 낮은 순으로 정렬(반은 오름차순, 총점은 내림차순)
 *        ClassStudentNo - 반, 번호 순으로 내림차순 정렬
 * [문제4] 총점으로 전교등수를 계산하고 총점이 높은 순에서 낮은 수(내림차순)으로 정렬해서 list를 출력하세요. 전교등수를 저장할 수 있도록 Student클래스에 인스턴스변수 schoolRank가 추가되어 있습니다.
 * [문제5] 총점으로 반등수를 계산하고 반별로 총점이 높은 순에서 낮은 순(내림차순)으로 정렬해서 list를 출력하세요.
 *        반등수를 저장할 수 있도록 Student클래스에 인스턴수변수 classRank가 추가되어 있다.
 * [문제6] 데이터를 적절한 크기에 맞춰 정렬하는 format 메서드를 완성하고, 이 메서드를 이용해서 화면에 데이터를 실행결과와 같이 줄맞춰 출력하세요.
 *        String format(String str, int length, int alignment) - 주어진 문자열(str)을 지정된 길이(length)에 맞게 정렬(alignment)한다.
 *        예를 들어 format("이름",6,CENTER)의 결과는 " 이름 "이 된다.
 */
public class SumgJukEx1 {


    final static int LEFT = 0;
    final static int CENTER = 1;
    final static int RIGHT = 2;

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        //이름, 반, 번호, 국어, 수학, 영어
        list.add(new Student("남궁성", 3, 2, 100, 100, 100));
        list.add(new Student("완자바", 3, 1, 90, 100, 80));
        list.add(new Student("자바왕", 3, 3, 70, 40, 100));
        list.add(new Student("킹왕짱", 2, 1, 20, 80, 30));
        list.add(new Student("자바짱", 1, 5, 100, 100, 100));
        list.add(new Student("최고수", 6, 10, 90, 10, 70));
        list.add(new Student("홍길동", 5, 1, 100, 50, 60));
        list.add(new Student("일지매", 4, 16, 90, 10, 20));
        list.add(new Student("이원구", 1, 14, 100, 100, 100));
        list.add(new Student("오레오", 2, 2, 40, 80, 30));
        Collections.sort(list);
        printList(list);

        System.out.println("[반별 총점높은순으로 정렬]");
        Collections.sort(list, new ClassTotalComparator());
        printList(list);

        System.out.println();

        System.out.println("[반, 번호 순으로 정렬]");
        Collections.sort(list, new ClassStudentNoComparator());
        printList(list);

        System.out.println("[전교등수를 정렬하여 나타내기]");
        calculateSchoolRank(list);
        printList(list);

        System.out.println("[반등수를 정렬하여 나타내기]");
        calculateClassRank(list);
        printList(list);
    }

    private static void calculateClassRank(ArrayList<Student> list) {
        Collections.sort(list, new ClassTotalComparator()); // 먼저 반별 총점기준 내림차순으로 정렬한다.

        int prevClassNo = 0;
        int prevRank = 0;
        int prevTotal = 0;
        int length = list.size();



            /*

               list가 이미 정렬되어 있기 때문에... 이전 데이터하고만 총점과 반을 비교하면 된다.

                다음의 코드를 완성하세요.

                1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.

                    1.1 반이 달라지면,(classNo와 prevClassNo가 다르면)

                           이전등수(prevRank)와 이전총점(prevTotal)을 초기화 한다.

                    1.1 총점(total)이 이전총점(prevTotal)과 같으면

                            이전 등수(prevRank)를 등수(schoolRank)로 한다.

                    1.2 총점이 서로 다르면,

                          등수(schoolRank)의 값을 알맞게 계산해서 저장한다.

                          이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해서 계산되어야한다.

                          (실행결과 화면 참고)

                    1.3 현재 반과 총점과 등수를 이전반(prevClassNo)와 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.

            */

        for (Student s : list) {

            if (s.getClassNo() != prevClassNo) {
                prevRank = 0;
                prevTotal = 0;
            }
            prevClassNo = s.getClassNo();

            if (s.getTotal() == prevTotal) {
                s.setClassRank(prevRank);
            } else {
                s.setClassRank(prevRank + 1);
                prevRank = s.getClassRank();
                prevTotal = s.getTotal();
            }
        }
    }

    public static String format(String str, int length, int alignment) {
        if (str == null) str = "";
        int diff = length - str.length();


        // 주어진 문자열(str)의 길이보다 length의 값이 작으면 str를 length만큼만 남기고 잘라낸다.

        // 예를 들어, str이 "012345"이고, length가 3이면 결과는 "012"가 된다.
        if (diff < 0) return str.substring(0, length);


        char[] source = str.toCharArray();
        char[] result = new char[length];

        // 배열 result를 공백으로 채운다.
        for (int i = 0; i < result.length; i++)
            result[i] = ' ';
           /*

              다음의 코드를 완성하세요.



              1. 조건문을 이용해서 alignment의 값에 따라 다르게 처리한다.

                   (배열간의 복사에는 System.arraycopy()를 사용한다.)

                   1.1 alignment의 값이 CENTER일 때,

                        source의 내용이 result의 가운데 복사되도록 한다.

                   1.2 alignment의 값이 RIGHT일 때,

                        source의 내용의 끝이 result의 오른쪽 끝에 붙게 복사되도록 한다.

                   1.3 alignment의 값이 LEFT 또는 그 밖의 값 일 때

                        source의 내용을 result의 왼쪽끝 부터 복사되도록 한다..

           */
        switch (alignment) {
            case CENTER:
                System.arraycopy(source, 0, result, diff / 2, source.length);
                break;
            case LEFT:
                System.arraycopy(source,0,result,0,source.length);
                break;
            case RIGHT:
              default :
                System.arraycopy(source,0,result,diff,source.length);
                break;
        }
        return new String(result);
    }

    private static void calculateSchoolRank (List < Student > list) {
        Collections.sort(list); //먼저 list를 총점기준 내림차순으로 정렬한다.

        int preRank = 0; //이전 전교등수
        int preTotal = 0; //이전 총점
        int length = list.size();

    /*
        list가 이미 총점순으로 정렬되어 있기 때문에... 이전 데이터하고만 총점을 비교하면 된다.

            다음의 코드를 완성하세요.

            1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.

                1.1 총점(total)이 이전총점(prevTotal)과 같으면

                        이전 등수(prevRank)를 등수(schoolRank)로 한다.

                1.2 총점이 서로 다르면,

                      등수(schoolRank)의 값을 알맞게 계산해서 저장한다.

                      이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해서 계산되어야한다.

                      (실행결과 화면 참고)

                1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
     */

        for (Student s : list) {
            if (s.getTotal() == preTotal) {
                s.setSchoolRank(preRank);
            } else {
                s.setSchoolRank(preRank + 1);
                preTotal = s.getTotal();
                preRank = s.getSchoolRank();
            }
        }
    }



    private static void printList (ArrayList < Student > list) {
        System.out.println("이름      반  번호  국어    수학   영어    총점    전교등수    반등수");
        System.out.println("=========================================================");

        for (Student s : list) {
            System.out.println(s);
        }

        System.out.println("=========================================================");
    }
}


class Student implements Comparable<Student> {
    /*
        코드를 완성하세요.
        1. 이름(name), 반(classNo), 번호(studentNo), 국어(Korean), 수학(Math), 영어(English), 총정(Total)을 인스턴스변수로 선언한다.
        2. 이름,반,번호,국어,수학,영어를 입력받아서 각 인스턴스변수에 저장하는 생성자를 선언한다.
        3. Object클래스의 toString()을 오버라이딩해서 실행결과와 같이 이름, 반,번호,국어, 수학, 영어, 총점이 화면에 출력되도록한다.
     */


    private String name = "";
    private int classNo = 0;
    private int studentNo = 0;
    private int korean = 0;
    private int math = 0;
    private int english = 0;
    private int total = 0;
    private int schoolRank = 0;
    private int classRank = 0;

    public Student(String name, int classNo, int studentNo, int korean, int math, int english) {
        this.name = name;
        this.classNo = classNo;
        this.studentNo = studentNo;
        this.korean = korean;
        this.math = math;
        this.english = english;
        this.total = (korean+english+math);
    }
    @Override
    public String toString() {

        return SumgJukEx1.format(name,5,SumgJukEx1.LEFT)
                + SumgJukEx1.format(""+classNo,4,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+studentNo,4,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+korean,6,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+math,6,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+english,6,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+total,8,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+schoolRank,8,SumgJukEx1.RIGHT)
                + SumgJukEx1.format(""+classRank,8,SumgJukEx1.RIGHT);
    }

    @Override
    public int compareTo(Student o) {

        if (this.total > o.total) {
            return -1;
        } else if (this.total == o.total)
            return 0;
        else
            return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSchoolRank() {
        return schoolRank;
    }

    public void setSchoolRank(int schoolRank) {
        this.schoolRank = schoolRank;
    }

    public int getClassRank() {
        return classRank;
    }

    public void setClassRank(int classRank) {
        this.classRank = classRank;
    }
}
