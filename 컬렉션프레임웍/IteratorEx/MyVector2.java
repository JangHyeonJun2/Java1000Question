package 컬렉션프레임웍.IteratorEx;
import 컬렉션프레임웍.ArrayListEx.MyVector;

import java.util.Iterator;



public class MyVector2 extends MyVector implements Iterator {
    int cursor = 0;
    int lastRet = -1;

    public MyVector2(int capacity){
        super(capacity);
    }

    public MyVector2(){
        this(10);
    }
    public String toString(){
        String tmp = "";
        Iterator it = iterator();

        for(int i=0; it.hasNext(); i++){
            if(i != 0)
                tmp+=", ";
            tmp += it.next();
        }
        return "["+ tmp +"]";
    }

    public Iterator iterator(){
        cursor = 0;
        lastRet = -1;
        return this;
    }

    @Override
    public boolean hasNext() {

        return cursor != size();
    }

    @Override
    public Object next() {
        Object next = get(cursor);
        lastRet = cursor++;
        return next;
    }

    @Override
    public void remove() {
        //더이상 삭제할 것이 없으면 IllegalStateException을 발생시킨다.
        if (lastRet == -1)
            throw new IllegalStateException();
        else{
            remove(lastRet);
            cursor--; //삭제 후에 cursor의 위치를 감소시킨다.
            lastRet = -1;
        }
    }
}
