package 자바1000제;

/**
 * [문제1] 다음의 MyVector클래스의 메서드들을 완성하세요.
 * MyVector(int capacity) - 매개변수 capacity의 값을 용량으로 갖는 객체배열을 생성한다.
 * MyVector() - 매개변수 없는 생성. 기본적으로 용량이 10인 객체배열을 생성한다.
 * boolean isEmpty() - 객체배열이 비어있는지 확인하고 비어있으면 true, 그렇지 않으면 false를 반환한다.
 * int size() - 객체배열의 저장되어 있는 객체의 개수를 반환한다.
 * int capacity() - 객체배열의 용량(배열의 크기)을 반환한다.
 */
class MyVector {
    protected Object[] data = null; //객체를 담기 위한 객체배열을 선언한다.
    protected int capacity = 0;     //용량(객체배열의 크기)
    protected int size = 0;         //객체배열에 저장된 객체의 개수

    public MyVector(int capacity) {
        /*
            1.지역변수 capacity의 값이 0보다 작으면, illegalArgumentException을 발생시킨다.
            2.지역변수 capacity의 값을 인스턴스변수 capacity에 저장한다.
            3.지역변수 capacity와 같은 크기의 Object배열을 생성해서 객체배열 data에 저장한다.
         */

        if (capacity < 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        //크기를 지정하지 않으면 크기를 10으로 한다.
        /*
            1.매개변수가 없는 생성자를 통해 MyVector를 생성한다면, 용량(capacity)가 10이 되도록한다.
              매개변수가 있는 생성자 MyVector(int capacity)를 사용하세요.
         */
//        MyVector myVector = new MyVector(10);
//        this.capacity = myVector.capacity;

        this(10);

    }

    public boolean isEmpty() {
        //MyVector가 비어있는지 확인한다.
        if (size == 0)
            return true;
        else
            return false;
    }

    public int capacity() {
        //MyVector의 용량(크기)를 반환한다.
        return capacity;
    }

    public int size() {
        //MyVector에 저장된 객체의 개수를 반환한다.
        return size;
    }
}
public class MyVectorEx1 {
    public static void main(String[] args) {
        MyVector v = new MyVector();
        System.out.println("size: " + v.size());
        System.out.println("capacity: " + v.capacity());
        System.out.println("isEmpty: " + v.isEmpty());
    }
}
