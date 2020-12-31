package 람다;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ExSupplier {
    public static void main(String[] args) {
        Supplier<Integer> spr = () -> {
            Random random = new Random();
            return random.nextInt(50);
        };

        List<Integer> list = makeInList(spr,5);
        System.out.println(list);

    }

    private static List<Integer> makeInList(Supplier<Integer> spr, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(spr.get());
        }
        return list;
    }
}
