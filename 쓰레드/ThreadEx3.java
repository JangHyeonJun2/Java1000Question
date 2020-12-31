package 쓰레드;
/*
 * ThreadEx2.java예제와 달리 쓰레드가 새로 생성되지 않았다. 그저 ThreadEx3_1클래스의 run()이 호출되었을 뿐이다.
 */
public class ThreadEx3 {
    public static void main(String[] args) throws Exception {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
    }
}

class ThreadEx3_1 extends Thread {
    public void run(){
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
