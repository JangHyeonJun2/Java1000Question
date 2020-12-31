package 쓰레드;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

//    ThreadGroup(ThreadGroup parent, String name);
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "subGroup1");
        ThreadGroup subGrp2 = new ThreadGroup(grp2, "subGroup2");
        ThreadGroup ssubGrp3 = new ThreadGroup(subGrp1, "ssubGroup3");
        grp1.setMaxPriority(3); //쓰레드 그룹 grp1의 최대우선순위를 3으로 변경.
        grp2.setMaxPriority(6);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        //Thread(ThreadGroup tg, Runnable r,String name)
        new Thread(grp1, r, "th1").start();
        new Thread(subGrp1, r, "th2").start();
        new Thread(grp2, r, "th3").start();
        new Thread(subGrp2, r, "th4").start();
        new Thread(ssubGrp3, r, "th5").start();

        System.out.println(">>List of ThreadGroup : " + main.getName()
                            +", Active ThreadGroup: " + main.activeGroupCount()
                            +", Active Thread: " + main.activeCount());
        main.list();
    }
}
