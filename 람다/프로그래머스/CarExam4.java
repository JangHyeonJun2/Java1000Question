package 람다.프로그래머스;

import java.util.ArrayList;
import java.util.List;

/**
 * 같은 검색조건에 대해 람다를 이용하면 메소드 지정도 필요 없으므로 더 간결하게 표현할 수 있습니다
 */
public class CarExam4 {
    public static void main(String[] args){
        //Car객체를 만들어서 cars에 넣습니다.
        List<Car> cars = new ArrayList<>();
        cars.add( new Car("작은차",2,800,3) );
        cars.add( new Car("봉고차",12,1500,8) );
        cars.add( new Car("중간차",5,2200,0) );
        cars.add( new Car("비싼차",5,3500,1) );

        CarExam4 carExam = new CarExam4();
        carExam.printCar(cars,
                //인터페이스 CheckCar의 test메소드에 대응하는 람다를 만듭니다.
                (Car car) -> { return car.capacity >= 4 && car.price < 2500; }
        );
    }

    public void printCar(List<Car> cars, CheckCar tester){
        for(Car car : cars){
            if (tester.test(car)) {
                System.out.println(car);
            }
        }
    }

    interface CheckCar{
        boolean test(Car car);
    }
}
