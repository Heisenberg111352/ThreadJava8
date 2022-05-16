package cn.zwh.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.InterruptedTest2")
public class InterruptedTest2 {

    public static void main(String[] args) throws InterruptedException {
       Thread t1 =  new Thread(()->{
            while (true){
              boolean  interrupt  = Thread.currentThread().isInterrupted();//获取当前线程是否被打断 属于正常线程被打断执行is方法返回true
              if (interrupt){
                  log.debug("被打断了");
                  break;
              }
            }

        },"t1");

       t1.start();
       Thread.sleep(1000);
       log.debug("interrupted");
       t1.interrupt();
    }

}
