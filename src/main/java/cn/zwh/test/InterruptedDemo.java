package cn.zwh.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.InterruptedDemo")
public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException{
        TwoPhaseTermination t = new TwoPhaseTermination();
        t.start();
        Thread.sleep(3500);
        t.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination{
    private Thread monitor;

    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();//sleep被打断后 打断标记会被清空
                    thread.interrupt();//重新设置打断标记
                }
            }


        });
        monitor.start();
    }

    public void  stop(){
        monitor.interrupt();
    }
    }

