package cn.zwh.test;


/**守护线程 */
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t =  new Thread(()->{
            while (Thread.currentThread().isInterrupted()){
                break;
            }
        });
        t.setDaemon(true);//只要主线程结束 该线程随之也结束  垃圾回收器
        t.start();

        Thread.sleep(1000);
    }
}
