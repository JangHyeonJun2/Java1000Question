package 컬렉션프레임웍.TreeSetEx;
/*
 * 문자열의 경우 정렬순서는 문자의 코드값이 기준이 되므로,
 * 오름차순 정렬의 경우 코드값의 크기가 작은 순서에서 큰 순서,
 * 즉 공백, 숫자, 대문자, 소문자 순으로 정렬되고 내림차순의 경우 그 반대가 된다.
 */
public class AsciiPrint {
    public static void main(String[] args) {
        char ch = ' ';
        //공백(' ')이후의 문자들을 출력한다.
        for (int i=0;i<95;i++)
            System.out.print(ch++);
    }
}
