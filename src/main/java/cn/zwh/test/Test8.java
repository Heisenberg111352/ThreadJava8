package cn.zwh.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test8")
public class Test8 {

    /**yield  让出cpu使用权 使线程进入到就绪状态 然后调度执行其他线程 具体实现依赖于操作系统的任务调度器 */
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        sleep(1000);
                        //sleep适用于无需锁同步的场景
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

}
