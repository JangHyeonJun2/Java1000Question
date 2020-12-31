package 컬렉션프레임웍.ArrayListEx;
public class MyVector{
    protected Object[] data = null; //객체를 담기 위한 객체배열을 선언한다.
    protected int capacity = 0;//용량(객체배열의 크기)
    protected int size = 0; //객체배열에 저장된 객체의 개수

    public MyVector(int capacity){
        /*
        다음의 코드를 완성하세요.
        1. 지역변수 capacity의 값이 0보다 작으면, IllegalArgumentExcepton을 발생시킨다.
        2. 지역변수 capacity의 값을 인스턴스변수 capacity에 저장한다.
        3. 지역변수 capacity와 같은 크기의 Object배열을 생성해서 객체배열 data에 저장한다.
         */
        if(capacity < 0)
            throw new IllegalArgumentException("유효하지 않으 값입니다.: "+ capacity);
        this.capacity = capacity;
        data = new Object[capacity];
    }
    public MyVector(){
        //크기를 지정하지 않으면 크기를 10으로 한다.
        /*
         * 1.매개변수가 없는 생성자를 통해 MyVector를 생성한다면, 용량(capacity)가 10이 되도록 한다.
         * 매개변수가 있는 생성자 MyVector(int capacity)를 사용해라.
         */
        this(10);
    }

    public boolean isEmpty(){
        //MyVector가 비어있는지 확인한다.
        if(size == 0)
            return true;
        else
            return false;
    }

    public int capacity(){
        return capacity;
    }

    public int size(){
        return size;
    }

    public void ensurCapacity(int minCapacity){
        int newCapacity = capacity;
        /*
         * 1.minCapacity가 capacity보다 크면 newCapacity의 값을 두배로 한다.
         * (사실 반드시 2배이어야 할 필요는 없다. 적절한 비율로 크기를 늘려주기 위한 것이다.)
         * 2.그래도 minCapacity가 newCapacity보다 크면, minCapacity의 값을 newCapacity에 저장한다.
         * 3.setCapacity()를 호출해서 객체배열의 크기가 newCapacity가 되도록 한다.
         */
        if(minCapacity > capacity)
            newCapacity =  capacity * 2;
        else if(minCapacity > newCapacity)
            newCapacity = minCapacity;

        setCapacity(newCapacity);
    }

    public void setCapacity(int newCapacity){
        if(this.capacity == newCapacity)
            return;
        /*
         * 1.newCapacity 크기의 객체배열을 새로 만든다.
         * 2.기존의 객체배열(data)의 내용을 새로운 객체배열에 복사한다.
         *    (System.arrcopy()사용)
         * 3.data가 새로 생성된 객체배열을 참조하도록 한다.
         * 4.capacity의 값을 newCapacity로 변경한다.
         */
        Object[] newdata = new Object[newCapacity];
//        System.out.println("newdata.length: "+ newdata.length+ ", size: " + size);
        //밑에 코드에서 size부분을 조심하자!
        System.arraycopy(data,0,newdata,0,size);
        data = newdata;
        this.capacity = newCapacity;
    }

    public boolean add(Object obj){
        //새로운 객체를 저장하기 전에 저장할 공간을 확보한 후에 객체를 추가해아한다.
        ensurCapacity(this.size+1);
        data[size++] = obj;
        return true;
    }
    public Object get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        return data[index];
    }

    public Object set(int index, Object obj){
        /*
         * 1.index가 size보다 크면 ArrayindexOutOfBoundsException을 발생시킨다.
         * 2.객체배열 data의 index번째 값을 임시로 저장한다.
         * 3.새로운 객체(obj)를 객체배열 data의 index번째 값에 저장한다.
         * 4.임시로 저장했던 기존 객체를 반환한다.
         */
        if(index >= this.size)
            throw new ArrayIndexOutOfBoundsException("index값이 size값보다 큽니다.");
        Object tmp = data[index];
        data[index] = obj;
        return tmp;
    }

    public int indexOf(Object obj, int index){
        if(obj == null){
            for(int i=index; i < size; i++) {
                if (data[i] == null)
                    return i;
            }
        }else {
            for(int i = index; i<size; i++){
                if(obj.equals(data[i]))
                    return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object obj, int index){
        if(index >= size){
            throw new IndexOutOfBoundsException(index + " >= " + size);
        }

        if(obj == null){
            for(int i=index; i>=0; i--){
                if(data[i] == null)
                    return i;
            }
        }else {
            for(int i=index;i>=0;i--){
                if(obj.equals(data[i]))
                    return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj,0) >= 0;
    }

    public int indexOf(Object obj){
        return indexOf(obj, 0);
    }
    public int lastIndexOf(Object obj){
        return lastIndexOf(obj, size-1);
    }

    public void add(int index, Object obj){
        /*
         * 1.index의 값이 size보다크면, ArrayIndexOutOfBoundsException
         * 2.ensurecapacity()를 호출해서 새로운 객체가 저장될 공간을 확보한다.
         * 3.객체배열에서 index위치의 객체와 이후의 객체들을 한칸씩 옆으로 이동한다.
         *   (System.arraycopy()사용)
         * 4.객체배열의 index위치에 새로운 객체(obj)를 저장한다.
         * 5.size의 값을 1증가 시킨다.
         */

        if(index >= size)
            throw new ArrayIndexOutOfBoundsException(index + ">=" + size);
        ensurCapacity(size+1);
        System.arraycopy(data,index,data,index+1,size);
        data[index] = obj;
        size++;
    }

    public Object remove(int index){
        Object oldObj = null;
        /*
         * 1.index가 배열의 범위를 벗어나는지 체크하고, 벗어나면 IndexOutOfBoundsException를 발생시킨다.
         * 2.삭제하고자하는 데이터를 oldObj에 저장한다.
         * 3.삭제하고자 하는 객체가 마지막 객체가 아니라면,배열복사를 통해 빈자리를 채워준다.
         * 4.마지막 데이터를 null로 한다. 배열은 0 부터 시작하므로 마지막 요소는 index가 size-1이다.
         * 5.size의 값을 1감소시킨다.
         * 6.oldObj를 반환한다.
         */
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index + ">=" +size);
        oldObj = data[index];
        if(index != size-1){
            System.arraycopy(data,index+1,data,index,size-index-1);
        }
        data[size-1] = null;
        size--;
        return oldObj;
    }
    public boolean remove(Object object){
        /*
         * 1.반복문을 이용해서 객체배열의 모든 요소와 obj가 일치하는지 확인한다.
         *   1.1일치하면 remove(int index)를 호출해서 삭제하고 true를 반환한다.
         *   1.2일치하는 것을 찾지 못하면,false를 반환한다.
         */

        for(int i=0; i<size; i++){
            if(data[i].equals(object)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i=0; i<size; i++){
            data[i] = null;
        }
        size = 0;
    }

    public Object[] toArray(){
        /*
         * 1.객체배열 data와 같은 크기의 객체배열을 생성한다.
         * 2.배열의 내용을 복사한다.(System.arraycopy())
         * 3.생성한 객체배열을 반환한다.
         */
        Object[] newArry = new Object[size];
        System.arraycopy(data,0,newArry,0,size);
        return newArry;
    }
    public String toString(){
        /*
         * 1.StringBuffer를 생성한다.
         * 2.반복문과 get(int i)를 사용해서 배열의 모든 요소에 접근해서 toString()을 호출해서 sb에 저장한다.
         * 3.sb를 String으로 변환해서 반환한다.
         */

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<size; i++){
            if(i!=0)
                sb.append(",");
            sb.append(get(i));
        }
        sb.append("]");
        String str = sb.toString();
        return str;
    }
}
