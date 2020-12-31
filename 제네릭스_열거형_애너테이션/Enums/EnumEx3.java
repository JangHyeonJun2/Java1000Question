package 제네릭스_열거형_애너테이션.Enums;
enum Transportation {
    BUS(100){
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    },
    TRAIN(150){
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    },
    SHIP(110){
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    },
    AIRPLANE(200){
        int fare(int distance){
            return distance*BASIC_FARE;
        }
    };

    protected final int BASIC_FARE;//protected로 해야 각 상수에서 접근가능
    Transportation(int basicFare){
        BASIC_FARE = basicFare;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    abstract int fare(int distance); //거리에 따른 요금 계산
}
public class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("bus fare= " + Transportation.BUS.fare(200));
        System.out.println("train fare= " +Transportation.TRAIN.fare(3000));
        System.out.println("ship fare= " + Transportation.SHIP.fare(10000));
        System.out.println("airplane fare= "+ Transportation.AIRPLANE.fare(200000));
    }
}
