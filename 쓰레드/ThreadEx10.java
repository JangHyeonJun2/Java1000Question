package 쓰레드;
/*
 * setDaemon method는 반드시 start()를 호출하기 전에 실해되어야한다. 그렇지 않으면 IlleagalThreadStateException이 발생한다.
 */
public class ThreadEx10 implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadEx10());
        thread.setDaemon(true);
        thread.start();

        for (int i=1; i<=10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);

            if(i==4){
                autoSave = true;
            }

        }
        System.out.println("프로그램을 종료합니다.");
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(autoSave){
                autoSave();
            }
        }
    }
    public void autoSave(){
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
