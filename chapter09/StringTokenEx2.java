package chapter09;

import java.util.StringTokenizer;
/*
 * 구분자도 토큰으로 간주되도록 하였으며, 구분자로 여러 문자들을 지정한 것을 눈여겨보자. 앞서 얘기한 바와 같이 StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 때문에,"+-#/=()" 전체가 하나의 구분자가
 * 아니라 가각의 문자가 모두 구분자라는 것에 주의해야한다. "만일 구분자가 두 문자 이상이라면 Scanner,Split를 사용해야한다.
 */
public class StringTokenEx2 {
    public static void main(String[] args) {
        String expre = "x=100*(200+300)/2";
        StringTokenizer st = new StringTokenizer(expre,"+-*/=()",true);

        while (st.hasMoreTokens())
            System.out.println(st.nextToken());
    }
}
