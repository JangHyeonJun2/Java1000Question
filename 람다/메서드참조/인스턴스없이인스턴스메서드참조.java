package 람다.메서드참조;

import java.util.function.ToIntBiFunction;

public class 인스턴스없이인스턴스메서드참조 {
    public static void main(String[] args) {
        IBox ib1 = new IBox(4);
        IBox ib2 = new IBox(7);

        //두 상자에 저장된 값 비교하여 더 큰값 반환
        /**
         * ToIntBiFunction<T,U>    int applyAsInt(T t, U u)
         */
        ToIntBiFunction<IBox,IBox> bf = (b1,b2) -> b1.larger(b2);
        int bigNum = bf.applyAsInt(ib1, ib2);
        System.out.println(bigNum);

    }
}

class IBox {
    private int n;

    public IBox(int n) {
        this.n = n;
    }

    public int larger(IBox b) {
        if (n > b.n) {
            return n;
        } else {
            return b.n;
        }
    }
}
