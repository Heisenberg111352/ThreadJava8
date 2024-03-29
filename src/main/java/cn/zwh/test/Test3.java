package cn.zwh.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Test3")
public class Test3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> tsk = new  FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread thread = new Thread(tsk,"t3");
        thread.start();

        log.debug("{}",tsk.get());
    }


}
