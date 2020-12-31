package 컬렉션프레임웍.HashSetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bingo {
    public static void main(String[] args) {
//        Set set = new HashSet();
        Set set = new LinkedHashSet();
        int[][] board = new int[5][5];

        for(int i=0; set.size()<25; i++){ //여기서 i<25안하는 이유가 set은 중복을 허용하지 않기 때문에 같은 값이 나오게 되면 한번더 돌기 때문에 조건을 set.size()라고 해야한다.
            set.add((int)(Math.random()*50)+1+"");
        }

        Iterator it = set.iterator();

        System.out.println(set);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? "  " : " ")+board[i][j]);
            }
            System.out.println();
        }
    }
}
