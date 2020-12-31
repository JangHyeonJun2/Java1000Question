package 쓰레드;

public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int requireMemory = 0;

        for (int i=0; i<20; i++){
            requireMemory = (int)(Math.random() * 10) *20;

            //필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상을
            //사용했을 경우 gc를 깨운다.
            if (gc.freeMemory() < requireMemory || gc.freeMemory() < gc.totalMemory() * 0.4){
                gc.interrupt(); //잠자고 있던 쓰레드 gc를 깨운다.
                try {
                    gc.join(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gc.usedMemory += requireMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }
    }
}

class ThreadEx20_1 extends Thread {
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10 * 1000); // wait 10 sec .
            } catch (InterruptedException e) {
                System.out.println("Awaken by interrupt().");
            }
            gc(); //garbage collection
            System.out.println("Garbage Collected. Free Memory : "  + freeMemory());
        }
    }

    public void gc(){
        usedMemory -= 300;
        if(usedMemory < 0){
            usedMemory = 0;
        }
    }

    public int totalMemory(){
        return MAX_MEMORY;
    }

    public int freeMemory(){
        return MAX_MEMORY - usedMemory;
    }
}
