package cn.zwh.test;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.JoinTest1")
public class JoinTest1 {
    static  int r = 0;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static  void  test1() throws InterruptedException {
        log.debug("2开始");
       Thread t1 = new Thread(() -> {
           try {
               Thread.sleep(1000);
                log.debug("2结束");
               r = 10;
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });

        t1.setName("t1");
        t1.start();
        t1.join();//  程序运行到这里等待  然后直到t1线程结束 才会开始下一步 （参数）时间  等待时间过后执行下一步

        log.debug("结果为{}",r);
        log.debug("结束");
    }

//并行执行的  结果为0  需要等待1秒后才能计算出结果为10 但是man线程已经结束 拿到的值还是0
    //join方法 等待线程结束 谁来调用join 就等待调用join的线程结束
}
