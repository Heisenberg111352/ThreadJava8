package cn.zwh.test;

import lombok.extern.slf4j.Slf4j;

/**打断案例  优雅的停止线程
 * 可以打断处于阻塞状态的线程 例如调用了sleep wait join等方法
 *
 * */

@Slf4j(topic = "c.InterruptedTest")
public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
            Thread t =  new Thread(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"t1");
            t.start();
            Thread.sleep(1000);
            log.debug("interrupt");
            t.interrupt();//打断
            log.debug("打断标记{}",t.isInterrupted());//打断值为 睡眠或等待的线程会为 false
    }

}
