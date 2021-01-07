package 스트림;

import java.util.Arrays;

public class MyfirstStream2 {
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};

        int sum = Arrays.stream(ar)
                .filter(v -> v%2 == 1)
                .sum();

        System.out.println(sum);
    }
}
