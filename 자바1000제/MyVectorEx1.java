package 자바1000제;

/**
 * [문제1] 다음의 MyVector클래스의 메서드들을 완성하세요.
 * MyVector(int capacity) - 매개변수 capacity의 값을 용량으로 갖는 객체배열을 생성한다.
 * MyVector() - 매개변수 없는 생성. 기본적으로 용량이 10인 객체배열을 생성한다.
 * boolean isEmpty() - 객체배열이 비어있는지 확인하고 비어있으면 true, 그렇지 않으면 false를 반환한다.
 * int size() - 객체배열의 저장되어 있는 객체의 개수를 반환한다.
 * int capacity() - 객체배열의 용량(배열의 크기)을 반환한다.
 *[문제2]
 * void ensureCapacity(int minCapacity) - 객체배열이 최소한 지정된 용량을 확보한다.
 * void setCapacity(int newCapacity) - 객체배열의 용량을 지정된 용량(newCapacity)으로 변경한다.
 * boolean add(Object obj) - 객체배열에 객체(obj)를 저장한다.
 * Object get(int index) - 객체배열에 저장된, index번쨰의 객체를 반환한다.
 * Object set(int index, Object obj) - 객체배열의 index번쨰의 위치에 객체(obj)를 저장하고 , 기존의 객체를 반환한다.
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
            throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
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
    public void ensureCapacity(int minCapacity) {
        int newCapacity = capacity;
        /*
            1.minCapacity가 capacity보다 크면 newCapacity의 값을 두 배로 한다.
            2.그래도 minCapacity가 newCapacity보다 크면, minCapacity의 값을 newCapacity에 저장한다.
            3.setCapacity()를 호출해서 객체배열의 크기가 newCapacity가 되도록한다.
         */

        if (minCapacity > capacity) {
            newCapacity *= 2;
            if (minCapacity > newCapacity ){
                newCapacity = minCapacity;
            }
        }

        setCapacity(newCapacity);
    }

    public void setCapacity(int newCapacity) {
        if (this.capacity == newCapacity)
            return;
        /*
            다음의 코드를 완성하여라.
            1.newCapacity 크기의 객체배열을 새로 만든다.
            2.기존의 객체배열(data)의 내용을 새로운 객체배열에 복사한다. *System.arraycopy()사용
            3.data가 새로 생성된 객체배열을 참조하도록 한다.
            4.capacity의 값을 newCapacity로 변경한다.
         */

       Object[] newData = new Object[newCapacity];
       System.arraycopy(data,0,newData,0,size);
       data = newData;
       this.capacity = newCapacity;
    }

    public boolean add(Object obj) {
        //새로운 객체를 저장하기 전에 저장할 공간을 확보한 후에 객체를 추가해야한다.
        boolean flag = true;
        if (this.capacity == this.size) {
            ensureCapacity(this.capacity*2);
        }else if (this.capacity < this.size) {
            flag = false;
        }
        data[size++] = obj;
        return flag;
    }


    public Object get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.")
        return data[index];
    }

    public Object set(int index, Object obj) {
        /*
            1.index가 size보다 크면 ArrayIndexOutOfBoundsException을 발생시킨다.
            2.객체배열 data의 index번째 값을 임시로 저장한다.
            3.새로운 객체(obj)를 객체배열 data의 index번째 값에 저장한다.
            4.임시로 저장했던 기존 객체를 반환한다.
         */

        if (index > this.size)
            throw new ArrayIndexOutOfBoundsException("index값이 배열의 크기보다 큽니다.");
        Object tmp = data[index];
        data[index] = obj;
        return tmp;
    }
}
public class MyVectorEx1 {
    public static void main(String[] args) {
        MyVector v = new MyVector(2);

        v.add("AAA");
        v.add("BBB");
        v.add("CCC");

        for (int i=0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }

        System.out.println("size: " + v.size());
        System.out.println("capacity: " + v.capacity());
        System.out.println("isEmpty: " + v.isEmpty());

        v.set(0,"aaa");

        for (int i=0; i<v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
