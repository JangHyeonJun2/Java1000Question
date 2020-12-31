package 제네릭스_열거형_애너테이션.Enums;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T>{
    static int id = 1;
    int ordinal;
    String name = "";

    public int ordinal(){
        return ordinal;
    }
    MyEnum(String name){
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t){
        return ordinal - t.ordinal();
    }
}

abstract class MyTrans extends MyEnum{
    static final MyTrans BUS = new MyTrans("BUS",100) {
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    };
    static final MyTrans TRAIN = new MyTrans("TRAIN",200) {
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    };
    static final MyTrans SHIP = new MyTrans("SHIP",150) {
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    };
    static final MyTrans AIR = new MyTrans("AIR",300) {
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    };

    abstract int fare(int distance); //추상 메서드
    protected final int BASIC_FARE;
    private MyTrans(String name, int basicFare){
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name(){
        return name;
    }
    public String toString(){
        return name;
    }
}



public class EnumEx4 {
    public static void main(String[] args) {
        MyTrans t1 = MyTrans.BUS;
        MyTrans t2 = MyTrans.BUS;
        MyTrans t3 = MyTrans.AIR;
        MyTrans t4 = MyTrans.SHIP;
        MyTrans t5 = MyTrans.TRAIN;

        System.out.printf("t1=%s, %d%n",t1.name(),t1.ordinal());
        System.out.printf("t2=%s, %d%n",t2.name(),t2.ordinal());
        System.out.printf("t3=%s, %d%n",t3.name(),t3.ordinal());
        System.out.printf("t4=%s, %d%n",t4.name(),t4.ordinal());
        System.out.printf("t5=%s, %d%n",t5.name(),t5.ordinal());
    }
}
